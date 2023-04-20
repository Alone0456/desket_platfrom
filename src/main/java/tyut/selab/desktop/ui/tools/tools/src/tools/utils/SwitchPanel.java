package tyut.selab.desktop.ui.tools.tools.src.tools.utils;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:SwitchPanel
 * Package:tools.utils
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 18:28
 * @Version:v1.0
 */
public class SwitchPanel {
    /**
     * 切换面板中的内容
     * @param panel
     * @param switchPanel
     */
    public static void switchPanel(JPanel panel, JPanel switchPanel) {
        // 移除面板中的所有组件
        panel.removeAll();
        panel.add(switchPanel);
        panel.repaint();
        // 使重绘的面板确认生效
        panel.validate();
    }
    public static void switchQueryPanel(JPanel panel, JScrollPane switchPanel) {
        // 移除面板中的所有组件
        panel.removeAll();
        panel.add(switchPanel);
        panel.repaint();
        // 使重绘的面板确认生效
        panel.validate();
    }


}
