package tyut.selab.desktop.ui.todolist.component;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel {
    //����ͼƬ
    private Image backIcon;
    public BackGroundPanel(Image backIcon){
        this.backIcon = backIcon;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //���Ʊ���
        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

    }
}
