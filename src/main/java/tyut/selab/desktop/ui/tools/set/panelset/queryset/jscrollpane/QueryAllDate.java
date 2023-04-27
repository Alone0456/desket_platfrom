package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
        JTable table = JscrollSet.setJscrollPane(model);
        List<FileUp> fileUps = FileChooser.fileController.queryAllFileUpInfo();
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
