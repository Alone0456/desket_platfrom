package tyut.selab.desktop.ui.student.manager;

import tyut.selab.desktop.ui.student.manager.innerPanels.updateUser;
import tyut.selab.desktop.ui.student.manager.innerPanels.insertUser;
import tyut.selab.desktop.ui.student.user.Massage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MassageSettings extends JPanel {
    private JButton UpdateUser;
    private JButton insertUser;
    private CardLayout cardLayout=new CardLayout();
    private JPanel panel;
    private Image background;
    public MassageSettings() {
        setBackground(new Color(255, 255, 255));
        setSize(1010,650);
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setOpaque(false);
        desktopPane.setBackground(new Color(255, 255, 255));

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(cardLayout);
        tyut.selab.desktop.ui.student.manager.innerPanels.insertUser insert = new insertUser();
        updateUser update = new updateUser();
        panel.add(insert,"insert");
        panel.add(update,"update");
        cardLayout.show(panel, "update");
        background = new ImageIcon(Massage.class.getResource("pngs/background.png")).getImage();

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

        //修改按钮
        UpdateUser = new JButton("修改用户信息");
        UpdateUser.setBackground(new Color(46, 218, 226));
        UpdateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateUser.setBackground(new Color(46, 218, 226));
                insertUser.setBackground(Color.white);
                cardLayout.show(panel, "update");
            }
        });
        UpdateUser.setFont(new Font("幼圆", Font.BOLD, 20));
        UpdateUser.setBounds(0, 0, 178, 40);
        desktopPane.add(UpdateUser);

        //增加按钮
        insertUser = new JButton("增添用户");
        insertUser.setBackground(Color.white);
        insertUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertUser.setBackground(new Color(46, 218, 226));
                UpdateUser.setBackground(Color.white);
                cardLayout.show(panel, "insert");
            }
        });
        insertUser.setFont(new Font("幼圆", Font.BOLD, 20));
        insertUser.setBounds(176, 0, 171, 40);
        desktopPane.add(insertUser);
        setLayout(groupLayout);
    }
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void ColorChange(){
        insertUser.setBackground(new Color(46, 218, 226));
        UpdateUser.setBackground(Color.white);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0,getWidth(),getHeight(),this);
    }
}
