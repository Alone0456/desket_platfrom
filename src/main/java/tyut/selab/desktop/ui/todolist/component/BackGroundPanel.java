package tyut.selab.desktop.ui.todolist.component;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel {
    //ÉùÃ÷Í¼Æ¬
    private Image backIcon;
    public BackGroundPanel(Image backIcon){
        this.backIcon = backIcon;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //»æÖÆ±³¾°
        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

    }
}
