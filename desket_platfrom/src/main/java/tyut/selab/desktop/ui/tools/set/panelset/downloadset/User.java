package tyut.selab.desktop.ui.tools.set.panelset.downloadset;

import tyut.selab.desktop.ui.tools.set.panelset.panelutils.DownPanelSet;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.UploadPanelSet;

import javax.swing.*;

/**
 * ClassName:User
 * Package:tools.set.panelset.download
 * Description:
 * 用户下载界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:12
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class User {
    public static JPanel setDown(){
        return new DownPanelSet("用户下载页面","存放任务");
    }
}
