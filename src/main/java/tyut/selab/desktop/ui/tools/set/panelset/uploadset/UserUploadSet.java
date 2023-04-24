package tyut.selab.desktop.ui.tools.set.panelset.uploadset;

import tyut.selab.desktop.ui.tools.set.panelset.panelutils.UploadPanelSet;

import javax.swing.*;

/**
 * ClassName:UserUploadSet
 * Package:tools.set.panelset.uploadset
 * Description:
 * 用户上传界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 0:59
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class UserUploadSet {
    public static JPanel setUpload(){
        return new UploadPanelSet("用户上传页面","请按照规定格式上传，例如，学号-姓名.zip","选择上传文件","上传周报");
    }
}
