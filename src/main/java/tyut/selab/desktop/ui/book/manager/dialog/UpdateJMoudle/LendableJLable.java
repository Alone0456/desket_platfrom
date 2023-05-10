package tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LendableJLable {

    JPanel jPanel = null;

    JTextField jlLendablePriceConter = null;
    JButton jb = null;

    public LendableJLable(Vector<Vector> dataV, int updateSelectColmn){
        //修改未借出书籍的面板 所需组件

        JLabel jlNameLendable = new JLabel("书籍名称:",JLabel.CENTER);
        jlNameLendable.setBounds(150,30,200,40);
        jlNameLendable.setFont(new Font("微软黑体",Font.BOLD,20));
        JLabel jlNameLendableContent = new JLabel((String) dataV.get(updateSelectColmn).get(0),JLabel.CENTER);
        jlNameLendableContent.setBounds(260,30,400,40);
        jlNameLendableContent.setFont(new Font("微软黑体",Font.PLAIN,20));

        JLabel jlLendableOwner = new JLabel("书籍拥有者:",JLabel.CENTER);
        jlLendableOwner.setBounds(150,85,200,40);
        jlLendableOwner.setFont(new Font("微软黑体",Font.BOLD,20));
        JLabel jlLendableOwnerConter = new JLabel((String) dataV.get(updateSelectColmn).get(1),JLabel.CENTER);
        jlLendableOwnerConter.setBounds(260,85,400,40);
        jlLendableOwnerConter.setFont(new Font("微软黑体",Font.PLAIN,20));

        JLabel jlLendableOwnerStudentid = new JLabel("拥有者学号:",JLabel.CENTER);
        jlLendableOwnerStudentid.setBounds(150,140,200,40);
        jlLendableOwnerStudentid.setFont(new Font("微软黑体",Font.BOLD,20));
        JLabel jlLendableOwnerStudentIdConter = new JLabel( dataV.get(updateSelectColmn).get(2).toString(),JLabel.CENTER);
        jlLendableOwnerStudentIdConter.setBounds(260,140,400,40);
        jlLendableOwnerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,20));

        JLabel jlPrice1 = new JLabel("书籍价格:",JLabel.CENTER);
        jlPrice1.setBounds(150,195,200,40);
        jlPrice1.setFont(new Font("微软黑体",Font.BOLD,20));
        JTextField jlLendablePriceConter = new JTextField( dataV.get(updateSelectColmn).get(3).toString());
        jlLendablePriceConter.setHorizontalAlignment(JTextField.CENTER);
        jlLendablePriceConter.setBounds(360,195,200,40);
        jlLendablePriceConter.setFont(new Font("微软黑体",Font.PLAIN,20));

        JLabel jlStatus1 = new JLabel("书籍状态:",JLabel.CENTER);
        jlStatus1.setBounds(150,250,200,40);
        jlStatus1.setFont(new Font("微软黑体",Font.BOLD,20));
        JLabel jLabel1 = new JLabel((String) dataV.get(updateSelectColmn).get(4),JLabel.CENTER);
        jLabel1.setBounds(260,250,400,40);
        jLabel1.setFont(new Font("微软黑体",Font.PLAIN,20));

        JButton jbLendable = new JButton("确认修改");
        jbLendable.setFont(new Font("微软黑体",Font.BOLD,15));
        jbLendable.setBounds(250,380,300,40);
        jbLendable.setBackground(Color.PINK);
        jbLendable.setForeground(Color.WHITE);
        jbLendable.setFocusPainted(false);



        JPanel jplendable = new JPanel();
        jplendable.setBounds(0,0,800,500);
        jplendable.setBackground(Color.WHITE);
        jplendable.setLayout(null);



        // 往未借出书籍面板添加组件
        jplendable.add(jbLendable);
        jplendable.add(jlNameLendable);
        jplendable.add(jlNameLendableContent);
        jplendable.add(jlLendableOwner);
        jplendable.add(jlLendableOwnerConter);
        jplendable.add(jlLendableOwnerStudentid);
        jplendable.add(jlLendableOwnerStudentIdConter);
        jplendable.add(jlPrice1);
        jplendable.add(jlLendablePriceConter);
        jplendable.add(jlStatus1);
        jplendable.add(jLabel1);
        jPanel = jplendable;
        this.jlLendablePriceConter = jlLendablePriceConter;
        this.jb = jbLendable;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public JTextField getJlLendablePriceConter() {
        return jlLendablePriceConter;
    }

    public JButton getJb() {
        return jb;
    }
}
