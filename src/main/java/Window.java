import javax.swing.*;
import java.io.File;

abstract class Window implements Display {

    /**
     * this is the width of the window
     */
    public int width;

    /**
     * this is the length of the window
     */
    public int length;

    /**
     * initialise all value required for a window
     * @param width the width of the window
     * @param length the length of the window
     */
    public Window(int width,int length){
        this.width = width;
        this.length = length;
    }
}

class startWindow extends Window {

    /**
     * initialise all value required for a window
     * @param width the width of the window
     * @param length the length of the window
     */
    public startWindow(int width, int length) {
        super(width, length);
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
    public void display(int x, int y) {//todo

    }
}

class gameWindow extends Window{

    /**
     * initialise all value required for a window
     * @param width the width of the window
     * @param length the length of the window
     */
    public gameWindow(int width, int length) {
        super(width, length);
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
    public void display(int x, int y) {//todo

    }
}

class endWindow extends Window{

    /**
     * initialise all value required for a window
     * @param width the width of the window
     * @param length the length of the window
     */
    public endWindow(int width, int length) {
        super(width, length);
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
    public void display(int x, int y) {//todo

    }
}
