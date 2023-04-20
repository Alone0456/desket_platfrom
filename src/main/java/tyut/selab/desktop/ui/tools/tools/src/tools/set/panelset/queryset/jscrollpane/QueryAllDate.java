package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.queryset.jscrollpane;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:QueryAllDate
 * Package:tools.set.panelset.queryset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:33
 * @Version:v1.0
 */
public class QueryAllDate extends JScrollPane {
    public QueryAllDate(){
        JTextArea jTextArea = new JTextArea(50, 20);
        // TODO: 2023/04/19 获取数据库中所有用户信息
        jTextArea.setText("Welcome");
        this.setViewportView(jTextArea);
        this.setBackground(Color.white);
    }
}
