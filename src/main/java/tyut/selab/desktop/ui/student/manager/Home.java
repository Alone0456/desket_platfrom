package tyut.selab.desktop.ui.student.manager;

import javax.swing.JPanel;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Home extends JPanel {
    private Image image;
    public Home() {
        setBackground(new Color(255, 255, 255));
        setSize(1010,650);

        JLabel WelcomeText = new JLabel("欢迎您，管理员");
        WelcomeText.setFont(new Font("幼圆", Font.BOLD, 35));

        File file = new File("src\\main\\java\\tyut\\selab\\desktop\\ui\\student\\manager\\pngs\\keli.png");
        try {
            image=ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(457, Short.MAX_VALUE)
                                .addComponent(WelcomeText, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                                .addGap(259))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(231)
                                .addComponent(WelcomeText, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(338, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 330, 218,100,100,null);
    }

}
