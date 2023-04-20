package tyut.selab.desktop.ui.tools.tools.src.tools.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName:FileName
 * Package:tools.dialogs
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:06
 * @Version:v1.0
 */
public class FileName extends JDialog {
    public FileName() {
        this.setTitle("提示信息");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        this.setBounds((sw - 200) / 2, (sh - 100) / 2, 200, 100);
        this.setResizable(false);
        JLabel jLabel = new JLabel("请按规范格式上传文件");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(jLabel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
