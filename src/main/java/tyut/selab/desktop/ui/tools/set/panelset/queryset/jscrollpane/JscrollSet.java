package tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JscrollSet {
    public static JTable setJscrollPane(DefaultTableModel model){
        //创建表头
        model.setColumnIdentifiers(new Object[]{"上传id", "周数", "学号", "上传ip","上传时间","上传路径"});
        //JTable是将数据以表格的形式显示给用户看的一种组件，它包括行和列，其中每列代表一种属性
        JTable table = new JTable(model);
        //设置表格标题对象
        JTableHeader head=table.getTableHeader();
        head.setPreferredSize(new Dimension(head.getWidth(),35));
        head.setFont(new Font("楷体",Font.PLAIN,18));
        table.setRowHeight(30);
        table.setEnabled(false);
        table.setFont(new Font("微软黑体",0,18));

        //设置表格列宽
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(130);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(550);
        return table;
    }
}
