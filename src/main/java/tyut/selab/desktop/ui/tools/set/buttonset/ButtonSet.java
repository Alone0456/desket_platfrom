package tyut.selab.desktop.ui.tools.set.buttonset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * ClassName:ButtonSet
 * Package:tools.set.buttonset
 * Description:
 * 按钮外观设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/21 - 21:49
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class ButtonSet {
    public static void setButton(URL fileName, Color color, JButton button){
        // 添加背景图片
        ImageIcon icon = new ImageIcon(fileName);
        //设置background颜色
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        //设置图片的大小
        icon.setImage(icon.getImage().getScaledInstance(70, 70, 0));
        button.setHorizontalAlignment(JButton.LEFT);
        button.setIcon(icon);
        //设置鼠标手势
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setForeground(Color.WHITE);
        //设置鼠标移入移出字体颜色变化
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });
    }

}
