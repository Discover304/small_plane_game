/**
 * the is the entrance of the code
 */
public class Stater {

    public static void main(String[] args) {
        Window gameWindow = new Window();

        Panel testPanel = new testPanel();

        Thread testThread = new Thread(testPanel);

        testThread.start();

        gameWindow.add(testPanel);
    }
}
