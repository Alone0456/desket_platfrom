package tyut.selab.desktop.ui.book.manager.dialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MyJDialogBlackList extends JDialog {
        Vector<String> titleBlackList = null;
        Vector<Vector> valuesList = null;

        public MyJDialogBlackList(Vector<String> titleBlackList, Vector<Vector> valuesList) {
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
            JScrollPane jScrollPane = new JScrollPane(jTable);
            add(jScrollPane);
        }
    }