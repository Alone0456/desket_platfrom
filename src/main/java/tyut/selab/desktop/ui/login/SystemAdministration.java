package tyut.selab.desktop.ui.login;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JTextField;

public class SystemAdministration extends JPanel {

    /**
     * Create the panel.
     */
    public SystemAdministration() {
        setLayout(null);
        JLabel accountLabel = new JLabel("系统管理"); //文本设计
        accountLabel.setFont(new Font("微软雅黑", Font.BOLD, 99));
        accountLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        accountLabel.setBounds(100, 100,600,300);
        add(accountLabel);

    }
}