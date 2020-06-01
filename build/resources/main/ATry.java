import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**
 * java Swing界面编程
 * 实现简单的动画
 *
 * @author VisionDo
 *
 */
class GUI_Exp extends JFrame {

    private static final int WIDTH = 650;//界面的宽度
    private static final int HEIGHT = 600;//界面的高度


    public GUI_Exp(){
        this.setSize(WIDTH, HEIGHT);//设置GUI界面的宽高
        this.setTitle("月夜");//设置标题
        this.setResizable(false);//设置窗口大小不可改变
        this.setLocationRelativeTo(null);//设置窗口位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        this.setVisible(true);//设置窗口可见
    }

    public static void main(String[] args) {
        GUI_Exp ge = new GUI_Exp();
        ge.ShowMoon();
    }

    private void ShowMoon(){
        MyPanel panel = new MyPanel();//得到面板对象
        Thread t = new Thread(panel);//启动面板的动画线程
        t.start();
        this.add(panel);//将面板加载到Frame主窗口里
    }
}

/**
 * 面板类
 * 所有的绘画操作都在该类内实现
 *
 * 实现Runnable接口
 *
 * @author VisionDo
 *
 */
class MyPanel extends JPanel implements Runnable {

    int x = 0;
    int y = 0;
    int r = 50;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.blue);//设定背景颜色
        g.setColor(Color.yellow);//设置画笔颜色
        g.fillOval(x, y + 50, 100, 100);//画一个实心圆
        g.setColor(Color.blue);//重新设定画笔颜色
        g.fillOval(x, y, 2 * r, 2 * r);//画实心圆
    }

    //动画过程在线程内实现
    @Override
    public void run() {
        while (true) {//月亮的位置一直向下移动
            x++;
            y++;
            if (x > this.getWidth()) {//直到到达窗口边界
                x = 0;
                y = 0;
            }
            try {
                Thread.sleep(5);//暂停三秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();//三秒后重新开始
        }

    }
}