package tyut.selab.desktop.ui.book.user.dialog;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class MyDialogMyBook extends JDialog {
BookMessageController bookMessageController = new BookMessageController();
        Vector<String> titleMyBookList = null;
        Vector<Vector> valuesList = null;
        Vector<Vector> dataV = null;
        public MyDialogMyBook(Vector<String> titleMyBookList, Vector<Vector> valuesList, UserVo userVo,Vector<Vector> dataV,Vector titlesV,DefaultTableModel defaultTableModel) {
            this.dataV = dataV;
            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            JPanel jPanel1 = new JPanel();
            JPanel jPanel2 =  new JPanel();

            jPanel1.setBounds(0,0,800,400);
            jPanel1.setLayout(null);
            jPanel1.setVisible(true);
            jPanel2.setBounds(300,400,200,60);
            jPanel2.setLayout(null);
            jPanel2.setVisible(true);

            this.titleMyBookList =titleMyBookList;
            this.valuesList = valuesList;
            setTitle("我的书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);
            DefaultTableModel defaultTableModel1 = new DefaultTableModel(valuesList,titleMyBookList){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable jTable = new JTable(defaultTableModel1);
            JTableHeader tableHeader = jTable.getTableHeader();
            jTable.setFont(new Font("楷书",Font.PLAIN,15));
            jTable.setRowHeight(35);
            tableHeader.setFont(new Font("楷书",Font.PLAIN,20));
            tableHeader.setReorderingAllowed(false);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(0,0,800,350);
            jPanel1.add(jScrollPane);
            //删除书籍
            JButton deleteButton = new JButton("删除书籍");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否删除此书籍", "确认删除", JOptionPane.YES_NO_OPTION);
                    if (confirmDialog == JOptionPane.YES_OPTION) {
                        int selectedRow = jTable.getSelectedRow();
                        for (int i = 0; i < dataV.size(); i++) {
                            if(dataV.get(i).get(0).equals(valuesList.get(selectedRow).get(0)) && dataV.get(i).get(2).equals(userVo.getStudentNumber())){
                                try {
                                    int flag = bookMessageController.deleteBook(userVo.getStudentNumber(),dataV.get(i).get(0).toString());
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                dataV.removeElementAt(i);
                                break;
                            }

                        }
                       valuesList.removeElementAt(selectedRow);
                        defaultTableModel1.setDataVector(valuesList,titleMyBookList);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                }
            });
            deleteButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
            deleteButton.setBackground(new Color(0xFFFF4E4E, true));
            deleteButton.setForeground(Color.white);
            deleteButton.setSize(200,50);
            deleteButton.setFocusPainted(false);
            jPanel2.add(deleteButton);
            add(jPanel1);
            add(jPanel2);
        }

    public Vector<Vector> getDataV() {
        return dataV;
    }
}