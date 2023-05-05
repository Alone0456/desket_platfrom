package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class UserPanel extends JPanel {

    private JButton MassageButton;
    private JButton studentsAdminButton;
    private CardLayout cardLayout=new CardLayout();
    private JPanel panel;
    private JButton updateButton;
    IUserDao userDao = new UserDao();
    private User user=userDao.queryUserByStudentNumber(LoginService.getUser().getStudentNumber());
    public UserPanel() {
        setBackground(new Color(0, 120, 159));

        setSize(1010, 700);
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, 1010, 50);
        desktopPane.setBackground(new Color(7, 184, 149));

        //设置卡片布局器
        panel = new JPanel();
        panel.setLayout(cardLayout);
        Massage massage=new Massage(user);
        massage.setBackground(new Color(255, 255, 255));
        students students=new students();
        updatemassage update=new updatemassage(user,massage);
        panel.add(update,"update");
        panel.add(massage,"massage");
        panel.add(students,"students");
        cardLayout.show(panel, "massage");

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 624, Short.MAX_VALUE)
                                .addContainerGap())
        );

        //用户管理按钮
        studentsAdminButton = new JButton("用户管理");
        studentsAdminButton.setBackground(new Color(227, 227, 227));
        studentsAdminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentsAdminButton.setBackground(Color.white);
                MassageButton.setBackground(new Color(227, 227, 227));
                updateButton.setBackground(new Color(227, 227, 227));
                cardLayout.show(panel,"students");
            }
        });
        studentsAdminButton.setBounds(100,0,100,50);
        studentsAdminButton.setFont(new Font("幼圆", Font.BOLD, 20));

        //个人信息按钮
        MassageButton = new JButton("个人信息按钮");
        MassageButton.setBackground(Color.white);
        MassageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MassageButton.setBackground(Color.white);
                studentsAdminButton.setBackground(new Color(227, 227, 227));
                updateButton.setBackground(new Color(227, 227, 227));
                cardLayout.show(panel,"massage");
            }
        });
        MassageButton.setFont(new Font("幼圆", Font.BOLD, 20));
        MassageButton.setBounds(0,0,100,50);

        //信息修改按钮
        updateButton = new JButton("信息修改");
        updateButton.setFont(new Font("幼圆", Font.BOLD, 20));
        updateButton.setBackground(new Color(227, 227, 227));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButton.setBackground(Color.white);
                studentsAdminButton.setBackground(new Color(227, 227, 227));
                MassageButton.setBackground(new Color(227, 227, 227));
                cardLayout.show(panel,"update");
            }
        });

        //设置布局器
        GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
        gl_desktopPane.setHorizontalGroup(
                gl_desktopPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addComponent(MassageButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(studentsAdminButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(427, Short.MAX_VALUE))
        );
        gl_desktopPane.setVerticalGroup(
                gl_desktopPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(MassageButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                                .addComponent(studentsAdminButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        desktopPane.setLayout(gl_desktopPane);
        setLayout(groupLayout);


    }
}
