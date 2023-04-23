package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.component.jtextfield.IdText;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * ClassName:QueryByIdDate
 * Package:tools.set.panelset.queryset.jscrollpane
 * Description:
 * 管理员查询个人面板
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/20 - 10:59
 * @Version:v1.0
 */
public class QueryByIdDate extends JScrollPane {
    public QueryByIdDate() {
        JTextArea jTextArea = new JTextArea(50, 20);
        //  根据学号获取数据库中个别用户信息
        User privateuser = new User();
        Integer StudentNumber = Integer.parseInt(IdText.id);
        privateuser.setStudentNumber(StudentNumber);
        List<FileUp> fileUps = FileChooser.fileController.queryFileUpByUser(privateuser);
        for (FileUp fileUp : fileUps) {
            jTextArea.setText(fileUp.getUpFilePath());
            jTextArea.setText(fileUp.getWeek());
            jTextArea.setText(fileUp.getUpIp());
            jTextArea.setText(String.valueOf(fileUp.getUpId()));
            jTextArea.setText(String.valueOf(fileUp.getUpTime()));
        }
        jTextArea.setText("Welcome");
        this.setViewportView(jTextArea);
        this.getViewport().getView().setBackground(Color.pink);
    }
}

