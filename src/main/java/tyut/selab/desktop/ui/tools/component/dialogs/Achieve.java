package tyut.selab.desktop.ui.tools.component.dialogs;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:Achieve
 * Package:tools.dialogs
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:05
 * @Version:v1.0
 */
public class Achieve extends JDialog {
    public Achieve(String isAchieve) {
        this.setTitle("提示信息");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        this.setBounds((sw - 200) / 2, (sh - 100) / 2, 200, 100);
        this.setResizable(false);
        //设置为顶级窗口
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JLabel jLabel = new JLabel(isAchieve);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(jLabel, BorderLayout.CENTER);
        this.setVisible(true);
    }


}
