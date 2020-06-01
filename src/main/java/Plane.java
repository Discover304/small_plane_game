import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * this is the plane object in the game
 */
abstract class Plane extends GameObject {

    /**
     * this defines the shield of the plane, which can be regenerate.
     */
    public int shield;

    /**
     * this is the health of the plane
     */
    public int health;

    /**
     * this defines the shooting speed of guns.
     */
    public int shootingSpeed;

    /**
     * this is the orientation of Guns.
     */
    public double[] orientationOfGuns;


    /**
     * this is the initialization of the general data involved for a plane
     * @param size the size of the bullet circle
     * @param damage the damage may cause if some thing activate (add)
     * @param speed the speed of some thing move, could be 0.
     * @param side the side of the object.
     * @param shield the shield of the plane.
     * @param health the health of the plane.
     * @param shootingSpeed this is the shooting speed of the plane
     * @param orientationOfGuns this is a list of guns.
     */
    public Plane(int size, int damage, int speed, Side side,
                 int shield, int health, int shootingSpeed, double[] orientationOfGuns) {
        super(size, damage, speed, side);
        this.shield = shield;
        this.health = health;
        this.shootingSpeed = shootingSpeed;
        this.orientationOfGuns = orientationOfGuns;
    }


    /**
     * this is for judge if some thing cause damage by others.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    @Override
    boolean ifCauseDamage(GameObject[] gameObject) {//todo
        return false;
    }

    @Override
    public String toString() {//todo 补充数据列表
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return shield == plane.shield &&
                health == plane.health &&
                shootingSpeed == plane.shootingSpeed &&
                Arrays.equals(orientationOfGuns, plane.orientationOfGuns);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(shield, health, shootingSpeed);
        result = 31 * result + Arrays.hashCode(orientationOfGuns);
        return result;
    }
}

/**
 * this is a starter level plane (or most difficult plane to play).
 */
class BabyPlane extends Plane {

    /**
     * this is the initialization of the general data involved for a plane
     * @param side this is the side of the plane
     */
    public BabyPlane(Side side) {
        super(5, 100, 3, side, 500, 1000,
                100, new double[]{Math.PI / 2, Math.PI / 2});
    }

    /**
     * this is the path of the object pic
     */
    @Override
    public void defineImageFile() {
        try {
            this.image = ImageIO.read(new File("src/main/java/images/data_character_remilia_attackCb011.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this defines the way to update the frame from the previous method
     */
    @Override
    public void displayUpdateMethod() {
        if (!(x >= -100 && x <= 500 && y >= -100 && y <= 500)) {
            this.x = -100;
            this.y = 200;
            return;
        }

        if (Math.random() >= 0.5) {
            switcher = TestPanel.Switcher.Neg;
        } else {
            switcher = TestPanel.Switcher.Posi;
        }

        int delta = 10;

        this.x += delta;

        switch (switcher) {
            case Neg:
                this.y += delta;
                break;
            case Posi:
                this.y -= delta;
        }

    }

    enum Switcher {Posi, Neg}

    TestPanel.Switcher switcher = TestPanel.Switcher.Posi;

    /**
     * this defines the special skills of the game object.
     * different have different special skill and need a special to activate.
     */
    @Override
    void defineSpecialSkill() {
        super.shield *= 0.8;
        super.shootingSpeed *= 3;
        super.speed *= 1.5;
    }

    /**
     * this is for judge if some thing can activate their special skill.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    @Override
    boolean ifActiveSkill(GameObject[] gameObject) {
        return false;
    }

    /**
     * this defines how the plane is special
     */
    @Override
    void special() {//todo

    }

    @Override
    public String toString() {//todo 介绍
        return "Hello, where am I?";
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        char a = e.getKeyChar();
        if (a == 'j'){
            defineSpecialSkill();
        }
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char a = e.getKeyChar();
        int increment = speed;
        switch (a){
            case 'a':
                x-=increment;
                break;
            case 'd':
                x += increment;
                break;
            case 'w':
                y -= increment;
                break;
            case 's':
                y += increment;
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        switch(side){
            case Hero:
                g.drawImage(image, x, y, 145, 119, null);
                break;
            case Enemy:
                g.drawImage(image, x, y, 144, 119, null);
        }
        System.out.println("paint the plane");

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     * @see Thread#run()
     */
    @Override
    public void run() {
        //initialise all datas
        defineImageFile();
        switch(side){
            case Hero: {
                defineInitialPosition(200, 100, 0);
                while (true) {//cycle
                    try {
                        Thread.sleep(100);//stop some time
                        System.out.println("run plane");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();//restart
                }
            }
            case Enemy: {
                defineInitialPosition(300, 400, 0);
                while (true) {//cycle
                    displayUpdateMethod();
                    try {
                        System.out.println("我不是东");
                        Thread.sleep(100);//stop some time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();//restart
                }
            }
        }
    }
}
