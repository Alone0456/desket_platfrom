package tyut.selab.desktop.ui.book.manager.dialog;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class MyJDialogDelete extends JDialog {
       BookMessageController bookMessageController = new BookMessageController();

            public MyJDialogDelete(int updateSelectColmn, Vector<Vector> dataV, Vector titlesV, JTable jt, DefaultTableModel defaultTableModel) {
                ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
                setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                setTitle("删除书籍");
                setModal(true);
                setSize(800, 500);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);
                JLabel jlName = new JLabel("书籍名称");

                JLabel jlName = new JLabel("书籍名称",JLabel.CENTER);
                jlName.setFont(new Font("微软黑体",Font.BOLD,15));
                jlName.setBounds(220,25,100,30);
                JLabel jlNameContent = new JLabel((String) dataV.get(updateSelectColmn).get(0));
                JLabel jlNameContent = new JLabel((String) dataV.get(updateSelectColmn).get(0),JLabel.CENTER);
                jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlNameContent.setBounds(330,25,300,30);
                JLabel jlOwner = new JLabel("书籍拥有者");

                JLabel jlOwner = new JLabel("书籍拥有者",JLabel.CENTER);
                jlOwner.setFont(new Font("微软黑体",Font.BOLD,15));
                jlOwner.setBounds(220,65,100,30);
                JLabel jlOwnerConter = new JLabel((String) dataV.get(updateSelectColmn).get(1));
                JLabel jlOwnerConter = new JLabel((String) dataV.get(updateSelectColmn).get(1),JLabel.CENTER);
                jlOwnerConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlOwnerConter.setBounds(330,65,300,30);
                JLabel jlOwnerStudentId = new JLabel("拥有者学号");

                JLabel jlOwnerStudentId = new JLabel("拥有者学号",JLabel.CENTER);
                jlOwnerStudentId.setFont(new Font("微软黑体",Font.BOLD,15));
                jlOwnerStudentId.setBounds(220,105,100,30);
                JLabel jlOwnerStudentIdConter = new JLabel(dataV.get(updateSelectColmn).get(2).toString());
                JLabel jlOwnerStudentIdConter = new JLabel( dataV.get(updateSelectColmn).get(2).toString(),JLabel.CENTER);
                jlOwnerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlOwnerStudentIdConter.setBounds(330,105,300,30);
                JLabel jlPrice = new JLabel("书籍价格");

                JLabel jlPrice = new JLabel("书籍价格",JLabel.CENTER);
                jlPrice.setFont(new Font("微软黑体",Font.BOLD,15));
                jlPrice.setBounds(220,155,100,30);
                JLabel jlPriceConter = new JLabel(dataV.get(updateSelectColmn).get(3).toString());
                JLabel jlPriceConter = new JLabel(dataV.get(updateSelectColmn).get(3).toString(),JLabel.CENTER);
                jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlPriceConter.setBounds(330,155,300,30);
                jlPriceConter.setSize(100, 30);
                JLabel jlStatus = new JLabel("书籍状态");

                JLabel jlStatus = new JLabel("书籍状态",JLabel.CENTER);
                jlStatus.setFont(new Font("微软黑体",Font.BOLD,15));
                jlStatus.setBounds(220,195,100,30);
                JLabel jlStatusConter = new JLabel(dataV.get(updateSelectColmn).get(5).toString());
                JLabel jlStatusConter = new JLabel(dataV.get(updateSelectColmn).get(4).toString(),JLabel.CENTER);
                jlStatusConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlStatusConter.setBounds(330,195,300,30);
                JLabel jlBorrower = new JLabel("借阅人");

                JLabel jlBorrower = new JLabel("借阅人",JLabel.CENTER);
                jlBorrower.setFont(new Font("微软黑体",Font.BOLD,15));
                jlBorrower.setBounds(220,235,100,30);
                JLabel jlBorrowerConter = new JLabel((String) dataV.get(updateSelectColmn).get(4));
                JLabel jlBorrowerConter = new JLabel((String) dataV.get(updateSelectColmn).get(5),JLabel.CENTER);
                jlBorrowerConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlBorrowerConter.setBounds(330,235,300,30);
                JLabel jlBorrowTime = new JLabel("借出时间");

                JLabel jlBorrowTime = new JLabel("借出时间",JLabel.CENTER);
                jlBorrowTime.setFont(new Font("微软黑体",Font.BOLD,15));
                jlBorrowTime.setBounds(220,275,100,30);
                JLabel jlBorrowTimeConter = new JLabel(dataV.get(updateSelectColmn).get(6).toString());
                JLabel jlBorrowTimeConter = new JLabel(dataV.get(updateSelectColmn).get(6).toString(),JLabel.CENTER);
                jlBorrowTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlBorrowTimeConter.setBounds(330,275,300,30);
                JLabel jlReturnTime = new JLabel("还书时间");

                JLabel jlReturnTime = new JLabel("还书时间",JLabel.CENTER);
                jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,15));
                jlReturnTime.setBounds(220,315,100,30);
                JLabel jlReturnTimeConter = new JLabel(dataV.get(updateSelectColmn).get(7).toString());
                JLabel jlReturnTimeConter = new JLabel(dataV.get(updateSelectColmn).get(7).toString(),JLabel.CENTER);
                jlReturnTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));
                jlReturnTimeConter.setBounds(330,315,300,30);
                JPanel jp = new JPanel();
                jp.setSize(800,500);
                jp.setBackground(Color.WHITE);
                jp.setLayout(null);

                JButton jb = new JButton("确认删除");
                jb.setFont(new Font("微软黑体",Font.BOLD,15));
                jb.setBounds(250,380,300,40);
                jb.setBackground(Color.PINK);
                jb.setForeground(Color.WHITE);
                jb.setFocusPainted(false);

                JPanel jp = new JPanel();
                jp.setSize(800,500);
                jp.setBackground(Color.WHITE);
                jp.setLayout(null);
                add(jp);

                jp.add(jlName);
                jp.add(jlNameContent);
                jp.add(jlOwner);
                jp.add(jlOwnerConter);
                jp.add(jlOwnerStudentId);
                jp.add(jlOwnerStudentIdConter);
                jp.add(jlPrice);
                jp.add(jlPriceConter);
                jp.add(jlStatus);
                jp.add(jlStatusConter);
                jp.add(jlBorrower);
                jp.add(jlBorrowerConter);
                jp.add(jlBorrowTime);
                jp.add(jlBorrowTimeConter);
                jp.add(jlReturnTime);
                jp.add(jlReturnTimeConter);
                jp.add(jb);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否删除此书籍", "确认删除", JOptionPane.YES_NO_OPTION);
                        if(confirmDialog == JOptionPane.YES_OPTION){
                            int selectedRow = jt.getSelectedRow();
                            dataV.remove(selectedRow);
                            defaultTableModel.setDataVector(dataV,titlesV);
                            try {
                                int flag = bookMessageController.deleteBook(Integer.valueOf(jlOwnerStudentIdConter.getText()), jlNameContent.getText());
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            setVisible(false);
                        }else{
                            setVisible(false);
                        }

                    }
                });
                jp.add(jb);
                add(jp);
            }
        }