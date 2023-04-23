package tyut.selab.desktop.ui.tools.component.panels.managerpanels;

import tyut.selab.desktop.ui.tools.set.panelset.queryset.ManagerQuerySet;

import javax.swing.*;

/**
 * ClassName:ManagerQuerySet
 * Package:tools.panels.managerpanels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:59
 * @Version:v1.0
 */
public class ManagerQuery {
    public static JPanel getQueryPanel() {
        return new ManagerQuerySet();
    }
}
