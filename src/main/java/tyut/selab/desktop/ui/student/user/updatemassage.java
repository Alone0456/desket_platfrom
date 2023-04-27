package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.student.user.innerPanels.MassageUpdate;
import tyut.selab.desktop.ui.student.user.innerPanels.passwordUpdate;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
public class updatemassage extends JPanel {
    private JButton UpdateMassage;
    private JButton UpdatePassword;
    private CardLayout cardLayout=new CardLayout();
    private JPanel panel;
    public updatemassage(User user,Massage parentPanel) {
        setBackground(new Color(255, 255, 255));
        setSize(1010,650);
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        desktopPane.setBackground(new Color(255, 255, 255));

        //设置卡片布局器
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(cardLayout);
        MassageUpdate updateM =new MassageUpdate(user,parentPanel);
        passwordUpdate updateP = new passwordUpdate(user);
        panel.add(updateM,"massage");
        panel.add(updateP,"password");
        cardLayout.show(panel, "massage");

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 1011, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
        );

        //修改基本信息按钮
        UpdateMassage = new JButton("修改基本信息");
        UpdateMassage.setBackground(new Color(46, 218, 226));
        UpdateMassage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateMassage.setBackground(new Color(46, 218, 226));
                UpdatePassword.setBackground(Color.white);
                cardLayout.show(panel, "massage");
            }
        });
        UpdateMassage.setFont(new Font("幼圆", Font.BOLD, 20));
        UpdateMassage.setBounds(0, 0, 178, 40);
        desktopPane.add(UpdateMassage);

        //修改密码按钮
        UpdatePassword = new JButton("修改密码");
        UpdatePassword.setBackground(Color.white);
        UpdatePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePassword.setBackground(new Color(46, 218, 226));
                UpdateMassage.setBackground(Color.white);
                cardLayout.show(panel, "password");
            }
        });
        UpdatePassword.setFont(new Font("幼圆", Font.BOLD, 20));
        UpdatePassword.setBounds(176, 0, 171, 40);
        desktopPane.add(UpdatePassword);
        setLayout(groupLayout);
    }

}

