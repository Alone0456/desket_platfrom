package tyut.selab.desktop.ui.tools.component.dialogs;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:FileName
 * Package:tools.dialogs
 * Description:
 * 文件命名规范提示
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:06
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class FileName extends JDialog {
    public FileName() {
        this.setTitle("提示信息");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        this.setBounds((sw - 200) / 2, (sh - 100) / 2, 200, 100);
        this.setResizable(false);
        //设置为顶级窗口
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        JLabel jLabel = new JLabel("请按规范格式上传文件");
        jLabel.setFont(new Font("微软黑体",Font.PLAIN,15));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(jLabel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}