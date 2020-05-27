import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * this is the class of all Panel Object
 */
abstract class Panel extends JLabel implements DisplayData, Runnable {

    /**
     * this is the image of this Object
     */
    Image image;

    /**
     * x coordinate
     */
    int x;

    /**
     * y coordinate
     */
    int y;

    /**
     * define orientation
     */
    double degree;
}

class TestPanel extends Panel {

    /**
     * this is the path of the object pic
     */
    @Override
    public void defineImageFile() {
        try {
            image = ImageIO.read(new File("src/main/java/images/data_character_remilia_attackCb011.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     */
    @Override
    public void defineInitialPosition(int x, int y, double degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
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
            switcher = Switcher.Neg;
        } else {
            switcher = Switcher.Posi;
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

    Switcher switcher = Switcher.Posi;

    @Override//todo these two part (paint and run is for display something)
    public void paint(Graphics g) {
        g.drawImage(image, x, y, 145, 119, null);
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
        defineImageFile();
        defineInitialPosition(-100, 200, 0);
        while (true) {//cycle
            displayUpdateMethod();
            try {
                Thread.sleep(20);//stop some time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();//restart
        }
    }
}
