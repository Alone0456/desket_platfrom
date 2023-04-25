package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
@SuppressWarnings("all")
public class QueryAllDate extends JScrollPane {
    public QueryAllDate(){
        // 获取数据库中所有用户信息
        DefaultTableModel model = new DefaultTableModel();
        //创建表头
        model.setColumnIdentifiers(new Object[]{"上传id", "周数", "上传时间", "上传ip","上传路径","学号"});

        //JTable是将数据以表格的形式显示给用户看的一种组件，它包括行和列，其中每列代表一种属性
        List<FileUp> fileUps = FileChooser.fileController.queryAllFileUpInfo();
        for (FileUp fileUp : fileUps) {
            //添加数据
            model.addRow(new Object[]{String.valueOf(fileUp.getUpId()), fileUp.getWeek(),
                    String.valueOf(fileUp.getUpTime()), fileUp.getUpIp(),fileUp.getUpFilePath(),
            fileUp.getUser().getStudentNumber()});
        }
        JTable fk = new JTable(model);
        this.setViewportView(fk);
        this.getViewport().getView().setBackground(Color.pink);
    }
}
