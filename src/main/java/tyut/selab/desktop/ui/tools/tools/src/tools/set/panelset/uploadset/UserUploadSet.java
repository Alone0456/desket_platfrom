package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.uploadset;

import tools.set.panelset.panelutils.PanelSet;

import javax.swing.*;

/**
 * ClassName:UserUploadSet
 * Package:tools.set.panelset.uploadset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 0:59
 * @Version:v1.0
 */
public class UserUploadSet {
    public static JPanel setUpload(){
        return new PanelSet("用户上传页面","请按照规定格式上传，例如，2223-XXX.zip","选择上传文件","上传周报");
    }
}
