import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class Window extends JFrame {

    /**
     * this is the width of the window
     */
    public int WIDTH = 600;

    /**
     * this is the length of the window
     */
    public int HEIGHT = 600;

    /**
     * initialise all value required for a window
     */
    public Window() {
        this.setSize(WIDTH, HEIGHT);//设置GUI界面height
        this.setTitle("East-Project");//设置标题
        this.setResizable(false);//设置窗口大小不可改变
        this.setLocationRelativeTo(null);//设置窗口位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        this.setVisible(true);//设置窗口可见
    }
}
