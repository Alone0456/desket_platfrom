package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
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
        JTextArea jTextArea = new JTextArea(50, 20);
        User user = new User();
        user.setStudentNumber(2022005703);
        FileChooser.fileUp.setUser(user);
        DefaultTableModel model = new DefaultTableModel();
        //创建表头
        model.setColumnIdentifiers(new Object[]{"上传id", "周数", "上传时间", "上传ip","上传路径"});
        //JTable是将数据以表格的形式显示给用户看的一种组件，它包括行和列，其中每列代表一种属性
        List<FileUp> fileUps = FileChooser.fileController.queryFileUpByUser(FileChooser.fileUp.getUser());
        for (FileUp fileUp : fileUps) {
            //添加数据
            model.addRow(new Object[]{String.valueOf(fileUp.getUpId()), fileUp.getWeek(),
                    String.valueOf(fileUp.getUpTime()), fileUp.getUpIp(),fileUp.getUpFilePath()});
        }
        JTable fk = new JTable(model);
        this.setViewportView(fk);
        this.getViewport().getView().setBackground(Color.pink);
    }
}
