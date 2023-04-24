package tyut.selab.desktop.ui.tools.myframe;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:MyFrame
 * Package:tools.myframe
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:42
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class MyFrame extends JFrame {
    public MyFrame() {

        this.setSize(1010, 700);
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        //设置窗口居中显示
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public  void addPanel(JPanel panel) {
        this.add(panel);
    }
}
