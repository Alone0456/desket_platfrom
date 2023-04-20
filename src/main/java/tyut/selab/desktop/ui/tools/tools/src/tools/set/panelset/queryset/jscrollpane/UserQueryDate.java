package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.queryset.jscrollpane;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:UserQueryDate
 * Package:tools.set.panelset.queryset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/17 - 9:28
 * @Version:v1.0
 */
public class UserQueryDate extends JScrollPane {
    public UserQueryDate() {
        JTextArea jTextArea = new JTextArea(50, 20);
        // TODO: 2023/04/19 根据用户信息获取数据库中对应的数据
        jTextArea.setText("Welcome");
        this.setViewportView(jTextArea);
        this.setBackground(Color.white);
    }
}
