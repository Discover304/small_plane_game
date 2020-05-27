/**
 * the is the entrance of the code
 */
public class Stater {

    public static void main(String[] args) {
        Window gameWindow = new Window();

        //Panel thePanel = new TestPanel();
        GameObject gameObject = new BabyPlane(Side.Hero);//todo 如果是enemy的话不可以呢

        //Thread theThread = new Thread(thePanel);
        Thread planeThread = new Thread(gameObject);

        //theThread.start();
        planeThread.start();

        gameWindow.add(gameObject);
        gameWindow.addKeyListener(gameObject);
        //gameWindow.add(thePanel);
    }
}
