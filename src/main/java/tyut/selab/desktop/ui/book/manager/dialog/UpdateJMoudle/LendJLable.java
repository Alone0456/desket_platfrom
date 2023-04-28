package tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LendJLable {
    JPanel jPanel = null;

    JTextField jlLendablePriceConter = null;

    JButton jb = null;
    JTextField jlReturnTimeConter = null;
    JLabel  jlBorrowerStudentIdConter = null;


    public LendJLable(Vector<Vector> dataV,int updateSelectColmn){
        // 修改已借阅书籍的面板 所需组件
        JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
        jlName.setBounds(190,25,100,30);
        jlName.setFont(new Font("微软黑体",Font.BOLD,15));
        JLabel jlNameContent = new JLabel((String) dataV.get(updateSelectColmn).get(0),JLabel.CENTER);
        jlNameContent.setBounds(300,25,300,30);
        jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlOwner = new JLabel("书籍拥有者:",JLabel.CENTER);
        jlOwner.setBounds(190,65,100,30);
        jlOwner.setFont((new Font("微软黑体",Font.BOLD,15)));
        JLabel jlOwnerConter = new JLabel((String) dataV.get(updateSelectColmn).get(1),JLabel.CENTER);
        jlOwnerConter.setBounds(300,65,300,30);
        jlOwnerConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlOwnerStudentid = new JLabel("拥有者学号:",JLabel.CENTER);
        jlOwnerStudentid.setBounds(190,105,100,30);
        jlOwnerStudentid.setFont(new Font("微软黑体",Font.BOLD,15));
        JLabel jlOwnerStudentIdConter = new JLabel( dataV.get(updateSelectColmn).get(2).toString(),JLabel.CENTER);
        jlOwnerStudentIdConter.setBounds(300,105,300,30);
        jlOwnerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlPrice = new JLabel("书籍价格:",JLabel.CENTER);
        jlPrice.setBounds(190,155,100,30);
        jlPrice.setFont(new Font("微软黑体",Font.BOLD,15));
        JTextField jlPriceConter = new JTextField( dataV.get(updateSelectColmn).get(3).toString());
        jlPriceConter.setHorizontalAlignment(JTextField.CENTER);
        jlPriceConter.setBounds(300,155,300,30);
        jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlStatus = new JLabel("书籍状态:",JLabel.CENTER);
        jlStatus.setBounds(190,195,100,30);
        jlStatus.setFont(new Font("微软黑体",Font.BOLD,15));
        JLabel jLabel = new JLabel((String) dataV.get(updateSelectColmn).get(4),JLabel.CENTER);
        jLabel.setBounds(300,195,300,30);
        jLabel.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlBorrower = new JLabel("借阅人:",JLabel.CENTER);
        jlBorrower.setBounds(190,235,100,30);
        jlBorrower.setFont(new Font("微软黑体",Font.BOLD,15));
        JLabel jlBorrowerConter = new JLabel((String) dataV.get(updateSelectColmn).get(5));
        jlBorrowerConter.setHorizontalAlignment(JTextField.CENTER);
        jlBorrowerConter.setBounds(300,235,300,30);
        jlBorrowerConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlBorrowTime = new JLabel("借出时间:",JLabel.CENTER);
        jlBorrowTime.setBounds(190,275,100,30);
        jlBorrowTime.setFont(new Font("微软黑体",Font.BOLD,15));
        JLabel jlBorrowTimeConter = new JLabel(dataV.get(updateSelectColmn).get(6).toString(),JLabel.CENTER);
        jlBorrowTimeConter.setBounds(300,275,300,30);
        jlBorrowTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JLabel jlReturnTime = new JLabel("还书时间:",JLabel.CENTER);
        jlReturnTime.setBounds(190,315,100,30);
        jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,15));
        JTextField jlReturnTimeConter = new JTextField(dataV.get(updateSelectColmn).get(7).toString()+"(请使用yyyy-MM-dd HH:mm:ss 格式)");
        jlReturnTimeConter.setHorizontalAlignment(JTextField.CENTER);
        jlReturnTimeConter.setBounds(300,315,300,30);
        jlReturnTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));

        JButton jb = new JButton("确认修改");
        jb.setFont(new Font("微软黑体",Font.BOLD,15));
        jb.setBounds(250,380,300,40);
        jb.setBackground(Color.PINK);
        jb.setForeground(Color.WHITE);
        jb.setFocusPainted(false);


        JPanel jplended = new JPanel();
        jplended.setBounds(0,0,800,500);
        jplended.setBackground(Color.WHITE);
        jplended.setLayout(null);

        // 往已借出书籍面板添加组件
        jplended.add(jb);
        jplended.add(jlName);
        jplended.add(jlNameContent);
        jplended.add(jlOwner);
        jplended.add(jlOwnerConter);
        jplended.add(jlOwnerStudentid);
        jplended.add(jlOwnerStudentIdConter);
        jplended.add(jlPrice);
        jplended.add(jlPriceConter);
        jplended.add(jlStatus);
        jplended.add(jLabel);      // add
        jplended.add(jlBorrower);
        jplended.add(jlBorrowerConter);
        jplended.add(jlBorrowTime);
        jplended.add(jlBorrowTimeConter);
        jplended.add(jlReturnTime);
        jplended.add(jlReturnTimeConter);

        jPanel = jplended;
        this.jb = jb;
        this.jlReturnTimeConter = jlReturnTimeConter;
        this. jlBorrowerStudentIdConter =  jlBorrowerStudentIdConter;
        this.jlLendablePriceConter = jlPriceConter;
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

    public JTextField getJlReturnTimeConter() {
        return jlReturnTimeConter;
    }

    public JLabel getJlBorrowerStudentIdConter() {
        return  jlBorrowerStudentIdConter;
    }
}
