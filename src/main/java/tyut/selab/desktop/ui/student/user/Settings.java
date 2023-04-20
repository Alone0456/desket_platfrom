package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.ui.student.user.dialog.codeUpdateDialog;
import tyut.selab.desktop.ui.student.user.dialog.massageUpdateDialog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame {

    private JPanel contentPane;

    public Settings() {
        setTitle("设置");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 774, 782);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        //修改密码模块
        JDesktopPane updateCodePane = new JDesktopPane();
        updateCodePane.setBackground(new Color(192, 192, 192));
        updateCodePane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                updateCodePane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                updateCodePane.setBackground(new Color(192, 192, 192));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                codeUpdateDialog codechange=new codeUpdateDialog();
                codechange.setVisible(true);
            }
        });

        //修改个人信息模块
        JDesktopPane personalMassagePane = new JDesktopPane();
        personalMassagePane.setBackground(new Color(192, 192, 192));
        personalMassagePane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                personalMassagePane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                personalMassagePane.setBackground(new Color(192, 192, 192));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                massageUpdateDialog Massagechange=new massageUpdateDialog();
                Massagechange.setVisible(true);
            }
        });

        JLabel updateCodeText = new JLabel("修改密码");
        updateCodeText.setFont(new Font("宋体", Font.PLAIN, 32));
        updateCodeText.setBounds(10, 21, 164, 67);
        updateCodePane.add(updateCodeText);

        JLabel MassageUpdateText = new JLabel("修改个人信息");
        MassageUpdateText.setFont(new Font("宋体", Font.PLAIN, 32));
        MassageUpdateText.setBounds(10, 10, 210, 69);
        personalMassagePane.add(MassageUpdateText);


        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(updateCodePane, GroupLayout.PREFERRED_SIZE, 725, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(personalMassagePane, GroupLayout.PREFERRED_SIZE, 724, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(20)
                                .addComponent(updateCodePane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(personalMassagePane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(519, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
