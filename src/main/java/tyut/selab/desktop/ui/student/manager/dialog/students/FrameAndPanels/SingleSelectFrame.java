package tyut.selab.desktop.ui.student.manager.dialog.students.FrameAndPanels;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SingleSelectFrame extends JFrame {

    private JPanel contentPane;
    private CardLayout cardLayout=new CardLayout();
    JPanel TwoModePanel;
    private boolean isRepaint=false;
    //下面是两块面板
    private namePanel p1;
    private IDPanel p2;
    public SingleSelectFrame(Object[][] obj) {
        setTitle("单个查询");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 645);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //设置卡片布局，准备好两个面板
        TwoModePanel = new JPanel();
        TwoModePanel.setLayout(cardLayout);
        JPanel p1=new namePanel(obj);
        JPanel p2=new IDPanel(obj);
        TwoModePanel.add(p1,"p1");
        TwoModePanel.add(p2,"p2");
        cardLayout.show(TwoModePanel, "p1");

        JButton SchoolNumberButton = new JButton("按照学号查询");
        SchoolNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(TwoModePanel,"p2");
                changeP2();
            }
        });
        SchoolNumberButton.setFont(new Font("宋体", Font.PLAIN, 25));

        JButton NameButton = new JButton("按照姓名查询");
        NameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(TwoModePanel,"p1");
                changeP1();
            }
        });
        NameButton.setFont(new Font("宋体", Font.PLAIN, 25));

        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(58)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(TwoModePanel, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(NameButton)
                                                .addGap(98)
                                                .addComponent(SchoolNumberButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(119))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(NameButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SchoolNumberButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(TwoModePanel, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        contentPane.setLayout(gl_contentPane);
    }
    //初始化可切换面板
    private void initTwoPanel(Object[][] obj) {
        TwoModePanel.setLayout(cardLayout);
        p1=new namePanel(obj);
        p2=new IDPanel(obj);
        TwoModePanel.add(p1,"p1");
        TwoModePanel.add(p2,"p2");
        cardLayout.show(TwoModePanel, "p1");
        //初始权限设置在名字界面
        this.isRepaint=p1.isUpdate();
    }

    //切换权限开启界面
    private void changeP2(){
        this.isRepaint=p2.isUpdate();
    }
    private void changeP1(){
        this.isRepaint=p1.isUpdate();
    }

    //是否进行数据更新
    public boolean isUpdate(){
        return this.isRepaint;
    }
}

