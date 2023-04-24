package tyut.selab.desktop.ui.student.manager;

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

public class administrators extends JFrame {

    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    administrators frame = new administrators();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public administrators() {
        setTitle("管理员页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 801);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //主模块
        JDesktopPane MainPane = new JDesktopPane();
        MainPane.setBackground(new Color(255, 255, 255));

        //职责管理模块
        JDesktopPane dutyPane = new JDesktopPane();
        dutyPane.setBackground(new Color(255, 255, 255));
        dutyPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                dutyPane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                dutyPane.setBackground(new Color(255,255,255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showDuty();
            }
        });

        //成员信息模块
        JDesktopPane studentMassagePane = new JDesktopPane();
        studentMassagePane.setBackground(new Color(255, 255, 255));
        studentMassagePane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                studentMassagePane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                studentMassagePane.setBackground(new Color(255, 255, 255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showStudents();
            }
        });


        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(MainPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                                        .addComponent(studentMassagePane, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                                        .addComponent(dutyPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MainPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(studentMassagePane, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(dutyPane, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addGap(399))
        );

        JLabel dutyText = new JLabel("职责管理");
     //   dutyText.setIcon(new ImageIcon(administrators.class.getResource("/pngs/duty.png")));
        dutyText.setFont(new Font("宋体", Font.PLAIN, 24));
        dutyText.setBounds(20, 20, 143, 53);
        dutyPane.add(dutyText);

        //固定文本设置
        JLabel studentsMassageText = new JLabel("学生信息");
     //   studentsMassageText.setIcon(new ImageIcon(administrators.class.getResource("/pngs/student.png")));
        studentsMassageText.setFont(new Font("宋体", Font.PLAIN, 24));
        studentsMassageText.setBounds(21, 16, 202, 56);
        studentMassagePane.add(studentsMassageText);

        JLabel user = new JLabel("管理员");
        user.setFont(new Font("宋体", Font.PLAIN, 44));
        user.setBounds(31, 52, 132, 51);
        MainPane.add(user);

        contentPane.setLayout(gl_contentPane);

    }

    //进入成员信息页面
    private void showStudents() {
        studentsAdmin student=new studentsAdmin();
        student.setDefaultCloseOperation(HIDE_ON_CLOSE);
        student.setVisible(true);
    }

    //进入职责管理页面
    private void showDuty() {
        dutyAdmin duty=new dutyAdmin();
        duty.setDefaultCloseOperation(HIDE_ON_CLOSE);
        duty.setVisible(true);
    }
}
