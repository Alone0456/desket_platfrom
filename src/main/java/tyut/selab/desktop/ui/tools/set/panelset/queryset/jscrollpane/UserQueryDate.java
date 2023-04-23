package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * ClassName:UserQueryDate
 * Package:tools.set.panelset.queryset
 * Description:
 * 用户查询个人信息面板
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/17 - 9:28
 * @Version:v1.0
 */
public class UserQueryDate extends JScrollPane {
    public UserQueryDate() {
        JTextArea jTextArea = new JTextArea(50, 20);
        // 根据用户信息获取数据库中对应的数据
        List<FileUp> fileUps = FileChooser.fileController.queryFileUpByUser(FileChooser.fileUp.getUser());
//        for (FileUp fileUp : fileUps) {
//            jTextArea.setText(fileUp.getUpFilePath());
//            jTextArea.setText(fileUp.getWeek());
//            jTextArea.setText(fileUp.getUpIp());
//            jTextArea.setText(String.valueOf(fileUp.getUpId()));
//            jTextArea.setText(String.valueOf(fileUp.getUpTime()));
//            User user = fileUp.getUser();
//            jTextArea.setText(user.getPost());
//            jTextArea.setText(user.getName());
//            jTextArea.setText(String.valueOf(user.getStudentNumber()));
//            jTextArea.setText(user.getPhone());
//        }
        this.setViewportView(jTextArea);
        this.getViewport().getView().setBackground(Color.pink);
    }
}
