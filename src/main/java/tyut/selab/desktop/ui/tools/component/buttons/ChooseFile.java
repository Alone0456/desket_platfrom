package tyut.selab.desktop.ui.tools.component.buttons;

import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:ChooseFile
 * Package:tools.buttons
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:50
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class ChooseFile extends JButton {
    public ChooseFile(String name1,String name2){
        this.setText(name1);
        this.setFont(new Font("华文行楷",Font.BOLD,15));
        this.setBackground(Color.blue);
        this.setForeground(Color.black);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FileChooser.openFileChooser(name2);
            }
        });
    }

}
