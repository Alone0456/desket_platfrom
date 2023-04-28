package tyut.selab.desktop.ui.book.user.dialog;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class BorrowBookDialog extends JDialog {
    BookMessageController bookMessageController = new BookMessageController();
    BookBorrowController bookBorrowController = new BookBorrowController();

        public BorrowBookDialog(int borrowSelectColmn, Vector<Vector> dataV, Vector titlesV, DefaultTableModel defaultTableModel, UserVo userVo) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            setTitle("借阅书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
            jlName.setFont(new Font("微软黑体",Font.BOLD,20));
            jlName.setBounds(150,30,200,40);
            JLabel jlNameContent = new JLabel((String) dataV.get(borrowSelectColmn).get(0),JLabel.CENTER);
            jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlNameContent.setBounds(260,30,400,40);

            JLabel jlBorrowName = new JLabel("书籍拥有者:",JLabel.CENTER);
            jlBorrowName.setFont(new Font("微软黑体",Font.BOLD,20));
            jlBorrowName.setBounds(150,85,200,40);
            JLabel jlBorrowConter = new JLabel((String) dataV.get(borrowSelectColmn).get(1),JLabel.CENTER);
            jlBorrowConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlBorrowConter.setBounds(260,85,400,40);

            JLabel jlStudentId = new JLabel("拥有者学号:",JLabel.CENTER);
            jlStudentId.setFont(new Font("微软黑体",Font.BOLD,20));
            jlStudentId.setBounds(150,140,200,40);
            JLabel jlStudentIdConter = new JLabel(dataV.get(borrowSelectColmn).get(2).toString(),JLabel.CENTER);
            jlStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlStudentIdConter.setBounds(260,140,400,40);

            JLabel jlPrice = new JLabel("书籍价格:",JLabel.CENTER);
            jlPrice.setFont(new Font("微软黑体",Font.BOLD,20));
            jlPrice.setBounds(150,195,200,40);
            JLabel jlPriceConter = new JLabel(dataV.get(borrowSelectColmn).get(3).toString(),JLabel.CENTER);
            jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlPriceConter.setBounds(260,195,400,40);

            JLabel jlReturnTime = new JLabel("借阅时间",JLabel.CENTER);
            jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,20));
            jlReturnTime.setBounds(150,250,200,40);

            JRadioButton rb1 = new JRadioButton("3天", true);
            // 创建单选按钮，并且默认已选中
            JRadioButton rb2 = new JRadioButton("5天", false);
            // 创建单选按钮，并且默认未选中
            JRadioButton rb3 = new JRadioButton("7天", false);
            rb1.setBounds(360,250,60,40);
            rb2.setBounds(430 ,250,60,40);
            rb3.setBounds(500,250,60,40);
            rb1.setBackground(Color.white);
            rb2.setBackground(Color.white);
            rb3.setBackground(Color.white);
            rb1.setFont(new Font("微软黑体",Font.BOLD,20));
            rb2.setFont(new Font("微软黑体",Font.BOLD,20));
            rb3.setFont(new Font("微软黑体",Font.BOLD,20));

            ButtonGroup group = new ButtonGroup(); // 创建一个按钮小组
            group.add(rb1); // 把单选按钮1加入到按钮小组
            group.add(rb2); // 把单选按钮2加入到按钮小组
            group.add(rb3); // 把单选按钮3加入到按钮小组

            JPanel jp = new JPanel();
            jp.setSize(800,500);
            jp.setBackground(Color.WHITE);
            jp.setLayout(null);
            add(jp);

            JButton jb = new JButton("确认借阅");
            jb.setFont(new Font("微软黑体",Font.BOLD,15));
            jb.setBounds(150,350,500,60);
            jb.setBackground(Color.PINK);
            jb.setForeground(Color.WHITE);
            jb.setFocusPainted(false);

            jp.add(jlName);
            jp.add(jlNameContent);
            jp.add(jlBorrowName);
            jp.add(jlBorrowConter);
            jp.add(jlStudentId);
            jp.add(jlStudentIdConter);
            jp.add(jlPrice);
            jp.add(jlPriceConter);
            jp.add(jlReturnTime);
            jp.add(rb1);
            jp.add(rb2);
            jp.add(rb3);
            jp.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BookVo bookVo = null;
                    try {
                        bookVo = bookMessageController.queryBookLog(Integer.valueOf(jlStudentIdConter.getText()),jlNameContent.getText());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (NoSuchFieldException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (InstantiationException ex) {
                        throw new RuntimeException(ex);
                    } catch (IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String nowFormat = simpleDateFormat.format(date);
                    bookVo.setBorrowBookUserVo(userVo);
                    bookVo.setBorrowBookTime(date);
                    String info = null;
                    for(Component c:jp.getComponents()){
                        if(c instanceof JRadioButton){
                            if(((JRadioButton) c).isSelected()){
                                info = ((JRadioButton)c).getText();
                            }
                        }
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, info.charAt(0));
                    Date time = calendar.getTime();
                    bookVo.setReturnBookTime(time);
                    try {
                        bookBorrowController.borrowBook(bookVo);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (NoSuchFieldException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (InstantiationException ex) {
                        throw new RuntimeException(ex);
                    } catch (IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                    dataV.get(borrowSelectColmn).set(4,"已借出");
                    dataV.get(borrowSelectColmn).set(5,userVo.getName());
                    dataV.get(borrowSelectColmn).set(6,nowFormat);
                    dataV.get(borrowSelectColmn).set(7,simpleDateFormat.format(time));
//                    dataV.get(borrowSelectColmn).set(7,)
                    defaultTableModel.setDataVector(dataV,titlesV);
                    JOptionPane.showMessageDialog(null, "借阅成功", "借阅信息", JOptionPane.WARNING_MESSAGE);
                    setVisible(false);
                  }
            });
        }
    }