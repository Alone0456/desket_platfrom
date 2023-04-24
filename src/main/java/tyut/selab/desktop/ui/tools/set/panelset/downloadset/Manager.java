package tyut.selab.desktop.ui.tools.set.panelset.downloadset;

import tyut.selab.desktop.ui.tools.set.panelset.panelutils.DownPanelSet;

import javax.swing.*;

/**
 * ClassName:Managers
 * Package:tools.set.panelset.download
 * Description:
 * 管理员下载界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:12
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class Manager {
    public static JPanel setDown(){
        return new DownPanelSet("管理员下载页面","存放周报");
    }
}
