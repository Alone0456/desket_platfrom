package tyut.selab.desktop.ui.tools.set.panelset.uploadset;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.UploadPanelSet;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;

/**
 * ClassName:ManagerUploadSet
 * Package:tools.set.panelset.uploadset
 * Description:
 * 管理员上传界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 0:59
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class ManagerUploadSet {
    public static JPanel setUpload() {
        User user = FileChooser.fileUpVo.getUser();
        String studentNumber = String.valueOf(user.getStudentNumber().intValue());
        String stdentName = user.getName();
        String message="请按照:"+studentNumber+"-"+stdentName+".zip的格式上传";
        JPanel panelSet = new UploadPanelSet("管理员上传页面", message, "选择上传文件", "上传任务");
        return panelSet;
    }
}
