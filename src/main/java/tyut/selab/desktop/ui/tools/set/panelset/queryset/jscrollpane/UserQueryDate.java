package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
@SuppressWarnings("all")
public class UserQueryDate extends JScrollPane {
    public UserQueryDate() {
        // 根据用户信息获取数据库中对应的数据
        DefaultTableModel model = new DefaultTableModel();
        JTable table = JscrollSet.setJscrollPane(model);

        List<FileUp> fileUps = FileChooser.fileController.queryFileUpByUser(FileChooser.fileUp.getUser());
        for (FileUp fileUp : fileUps) {
            //添加数据
            model.addRow(new Object[]{String.valueOf(fileUp.getUpId()), fileUp.getWeek(),
                    fileUp.getUser().getStudentNumber(), fileUp.getUpIp(),
                    String.valueOf(fileUp.getUpTime()),fileUp.getUpFilePath()});
        }

        this.setViewportView(table);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getViewport().getView().setBackground(Color.pink);
    }
}
