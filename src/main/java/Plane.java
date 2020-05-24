import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public abstract class Plane extends GameObject implements Display{

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
                100, new double[] {Math.PI / 2, Math.PI / 2});
    }

    /**
     * this is the path of the object pic
     * @return the file
     */
    @Override
    public File imageFile() {//todo
        return null;
    }

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     */
    @Override
    public void display(int x, int y) {//todo this need to be done later
    }

    /**
     * this defines the special skills of the game object.
     * different have different special skill and need a special to activate.
     */
    @Override
    void defineSpecialSkill() {
        super.shield*=4;
        super.shootingSpeed*=3;
        super.speed*=3;
    }

    /**
     * this is for judge if some thing can activate their special skill.
     * @param gameObject this is a collection of all object of this game
     * @return a boolean value to change something.
     */
    @Override
    boolean ifActiveSkill(GameObject[] gameObject) {//todo
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
}