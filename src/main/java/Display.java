import java.io.File;

/**
 * this is the display interface, help each object return the data required to display.
 */
public interface Display {

    /**
     * this is the path of the object pic
     * @return the file
     */
    File imageFile();

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     */
    void display(int x, int y);
}
