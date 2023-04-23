package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * ClassName:QueryAllDate
 * Package:tools.set.panelset.queryset
 * Description:
 * 管理员查询所有面板
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:33
 * @Version:v1.0
 */
public class QueryAllDate extends JScrollPane {
    public QueryAllDate(){
        JTextArea jTextArea = new JTextArea(50, 20);
         // 获取数据库中所有用户信息
        List<FileUp> fileUps = FileChooser.fileController.queryAllFileUpInfo();
        for (FileUp fileUp : fileUps) {
            jTextArea.setText(fileUp.getUpFilePath());
            jTextArea.setText(fileUp.getWeek());
            jTextArea.setText(fileUp.getUpIp());
            jTextArea.setText(String.valueOf(fileUp.getUpId()));
            jTextArea.setText(String.valueOf(fileUp.getUpTime()));
        }
        this.setViewportView(jTextArea);
        this.getViewport().getView().setBackground(Color.pink);
    }
}
