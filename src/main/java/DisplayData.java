/**
 * this is the display interface, help each object return the data required to display.
 */
public interface DisplayData {

    /**
     * this defines the image object of the class
     */
    void defineImageFile();

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     * @param degree the orientation of the pic
     */
    void defineInitialPosition(int x, int y, double degree);

    /**
     * this defines the way to update the frame position from the previous method
     */
    void displayUpdateMethod();
}
