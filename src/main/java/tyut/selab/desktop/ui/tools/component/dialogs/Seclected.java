package tyut.selab.desktop.ui.tools.component.dialogs;

import javax.swing.*;
import java.awt.*;

/**
 * 判断是否选择选项提示弹窗
 */
@SuppressWarnings("all")
public class Seclected extends JDialog {
    public Seclected(String message) {
        this.setTitle("提示信息");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        this.setBounds((sw - 200) / 2, (sh - 100) / 2, 200, 100);
        this.setResizable(false);
        //设置为顶级窗口
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        JLabel jLabel = new JLabel(message);
        jLabel.setFont(new Font("微软黑体", Font.PLAIN, 15));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(jLabel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}