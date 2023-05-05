package tyut.selab.desktop.ui.student.manager;


import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JPanel {
    private JButton HomeButton;
    private JButton studentsAdminButton;
    private JButton MassageButton;
    private CardLayout cardLayout=new CardLayout();
    private JPanel panel;
    public AdminPanel(){
    setSize(1010, 700);
    setBackground(new Color(0,120,159));
    JDesktopPane desktopPane = new JDesktopPane();
    desktopPane.setBounds(0, 0, 1010, 50);
    desktopPane.setBackground(new Color(7, 184, 149));

    //设置卡片布局器
    panel = new JPanel();
    panel.setLayout(cardLayout);
    Home home=new Home();
    MassageSettings settings=new MassageSettings();
    studentsAdmin students=new studentsAdmin(settings,this);
		panel.add(home,"home");
		panel.add(students,"students");
		panel.add(settings,"settings");
		cardLayout.show(panel, "home");

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1007, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
            .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
            );

        //设置成员管理按钮
        studentsAdminButton = new JButton("成员管理");
		studentsAdminButton.setBackground(new Color(227, 227, 227));
		studentsAdminButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            studentsAdminButton.setBackground(Color.white);
            HomeButton.setBackground(new Color(227, 227, 227));
            MassageButton.setBackground(new Color(227, 227, 227));
            cardLayout.show(panel,"students");

        }
    });
		studentsAdminButton.setBounds(100,0,100,50);
		studentsAdminButton.setFont(new Font("幼圆", Font.BOLD, 20));

        //设置首页按钮
        HomeButton = new JButton("首页");
		HomeButton.setBackground(Color.white);
		HomeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            HomeButton.setBackground(Color.white);
            studentsAdminButton.setBackground(new Color(227, 227, 227));
            MassageButton.setBackground(new Color(227, 227, 227));
            cardLayout.show(panel,"home");
        }
    });
		HomeButton.setFont(new Font("幼圆", Font.BOLD, 20));
		HomeButton.setBounds(0,0,100,50);

        //设置信息设置按钮
        MassageButton = new JButton("信息设置");
		MassageButton.setBackground(new Color(227, 227, 227));
		MassageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            MassageButton.setBackground(Color.white);
            HomeButton.setBackground(new Color(227, 227, 227));
            studentsAdminButton.setBackground(new Color(227, 227, 227));
            cardLayout.show(panel, "settings");
        }
    });
		MassageButton.setFont(new Font("幼圆", Font.BOLD, 20));

        //设置布局器
         GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
                gl_desktopPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_desktopPane.createSequentialGroup()
					.addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(studentsAdminButton, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MassageButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(462, Short.MAX_VALUE))
            );
		gl_desktopPane.setVerticalGroup(
                gl_desktopPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_desktopPane.createSequentialGroup()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(MassageButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(HomeButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addComponent(studentsAdminButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
            .addContainerGap())
            );
		desktopPane.setLayout(gl_desktopPane);
    setLayout(groupLayout);

}
    public CardLayout getCardLayout() {
        return cardLayout;
    }
    public JPanel getPanel() {
        return panel;
    }
    public void changColor(){
        HomeButton.setBackground(new Color(227, 227, 227));
        studentsAdminButton.setBackground(new Color(227, 227, 227));
        MassageButton.setBackground(Color.white);
    }
}
