package tyut.selab.desktop.ui.book.manager.dialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class MyJDialogBlackList extends JDialog {

        Vector<String> titleBlackList = null;
        Vector<Vector> valuesList = null;

        public MyJDialogBlackList(Vector<String> titleBlackList, Vector<Vector> valuesList) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            this.titleBlackList = titleBlackList;
            this.valuesList = valuesList;
            setTitle("黑名单列表");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            DefaultTableModel defaultTableModel1 = new DefaultTableModel(valuesList,titleBlackList){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable jTable = new JTable(defaultTableModel1);
            //设置列宽
            TableColumn column = null;
            int colunms = jTable.getColumnCount();
            int[] columnList = {200, 300, 300, 400, 410, 200};
            for (int i = 0; i < titleBlackList.size(); i++) {
                column = jTable.getColumnModel().getColumn(i);
                /*将每一列的默认宽度设置为100*/
                column.setPreferredWidth(columnList[i]);
            }
            JTableHeader tableHeader = jTable.getTableHeader();
            jTable.setFont(new Font("楷书",Font.PLAIN,15));
            jTable.setRowHeight(35);
            tableHeader.setFont(new Font("楷书",Font.PLAIN,20));
            tableHeader.setReorderingAllowed(false);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            add(jScrollPane);
        }
    }