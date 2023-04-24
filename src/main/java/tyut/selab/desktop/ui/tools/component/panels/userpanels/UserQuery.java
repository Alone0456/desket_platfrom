package tyut.selab.desktop.ui.tools.component.panels.userpanels;

import tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane.UserQueryDate;

import javax.swing.*;

/**
 * ClassName:UserQueryDate
 * Package:tools.panels.userpanels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:00
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class UserQuery {
    public static JScrollPane getQueryPanel() {
        return new UserQueryDate();
    }
}
