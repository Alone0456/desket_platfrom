package tyut.selab.desktop.ui.todolist;



import javax.swing.*;

import javax.swing.border.LineBorder;

import java.awt.*;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class libraryManagerPanel extends JPanel {

    int index = 0;
    private paneDate panedate;

    public libraryManagerPanel() {
        setBackground(new Color(255, 255, 255));
        setSize(1670, 982);
        setLayout(null);

        JPanel panel_two = new JPanel();
        panel_two.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_two.setBackground(Color.WHITE);
        panel_two.setBounds(343, 10, 310, 100);
        this.add(panel_two);
        panel_two.setLayout(null);
        JFrame jFrame = new JFrame();
        jFrame.add(new JScrollPane());
        jFrame.add(new JScrollBar());


        JPanel panel_one = new JPanel();
        panel_one.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_one.setBackground(Color.WHITE);
        panel_one.setBounds(20, 10, 310, 100);
        this.add(panel_one);
        panel_one.setLayout(null);


        JPanel panel_Three = new JPanel();
        panel_Three.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_Three.setBackground(Color.WHITE);
        panel_Three.setBounds(675, 10, 310, 100);
        this.add(panel_Three);
        panel_Three.setLayout(null);

        ImageIcon imageThree = new ImageIcon("picture\\lblThree.png");
        JLabel lblThree = new JLabel(imageThree);
        lblThree.setBackground(Color.WHITE);
        lblThree.setBounds(43, 20, 60, 60);
        panel_Three.add(lblThree);



        JPanel panel_Four = new JPanel();
        panel_Four.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_Four.setBackground(Color.WHITE);
        panel_Four.setBounds(1008, 10, 310, 100);
        this.add(panel_Four);
        panel_Four.setLayout(null);

        ImageIcon imageFour = new ImageIcon("picture\\lblFour1.png");
        JLabel lblFive = new JLabel(imageFour);
        lblFive.setBackground(Color.WHITE);
        lblFive.setBounds(36, 20, 60, 60);
        panel_Four.add(lblFive);



        JPanel panel_Five = new JPanel();
        panel_Five.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_Five.setBackground(Color.WHITE);
        panel_Five.setBounds(1334, 10, 310, 100);
        this.add(panel_Five);
        panel_Five.setLayout(null);

        ImageIcon imageSix = new ImageIcon("picture\\lblSix.png");
        JLabel lblSix = new JLabel(imageSix);
        lblSix.setBackground(Color.WHITE);
        lblSix.setBounds(32, 20, 60, 60);
        panel_Five.add(lblSix);



        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.window);
        panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        panel_2.setBounds(20, 120, 1625, 280);
        this.add(panel_2);
        panel_2.setLayout(null);

        ImageIcon imagePicture = new ImageIcon("picture/pictures.png");
        JLabel lblpicture = new JLabel(imagePicture);
        lblpicture.setBounds(25, 10, 1600, 248);
        panel_2.add(lblpicture);



        JPanel panel_right = new JPanel();
        panel_right.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_right.setBackground(Color.WHITE);
        panel_right.setBounds(1374, 416, 280, 535);
        this.add(panel_right);
        panel_right.setLayout(null);

        JPanel panel_Green = new JPanel();

        panel_Green.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_Green.setBackground(new Color(60, 179, 113));
        panel_Green.setBounds(26, 57, 105, 60);
        panel_right.add(panel_Green);
        panel_Green.setLayout(null);

        ImageIcon imageOrder = new ImageIcon("picture\\orderMessage1.png");
        JLabel lblOrdermessage = new JLabel(imageOrder);
        lblOrdermessage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel_Green.setBackground(new Color(0, 139, 139));
                lblOrdermessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        lblOrdermessage.setBounds(24, 6, 55, 50);
        panel_Green.add(lblOrdermessage);

        JPanel panel_yellow = new JPanel();

        panel_yellow.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_yellow.setBackground(new Color(173, 255, 47));
        panel_yellow.setBounds(26, 176, 105, 60);
        panel_right.add(panel_yellow);
        panel_yellow.setLayout(null);

        ImageIcon imageNote = new ImageIcon("picture\\note.png");
        JLabel lblNote = new JLabel(imageNote);
        lblNote.setBounds(25, 5, 55, 50);
        panel_yellow.add(lblNote);

        JPanel panel_blue = new JPanel();

        panel_blue.setBackground(new Color(0, 255, 255));
        panel_blue.setBounds(26, 295, 105, 60);
        panel_right.add(panel_blue);
        panel_blue.setLayout(null);

        ImageIcon imageLogistics = new ImageIcon("picture\\logisticsManageMent.png");
        JLabel lblLogistics = new JLabel(imageLogistics);
        lblLogistics.setBounds(24, 5, 55, 50);
        panel_blue.add(lblLogistics);

        JPanel panel_Cyan = new JPanel();

        panel_Cyan.setBackground(new Color(187, 234, 213));
        panel_Cyan.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_Cyan.setBounds(26, 414, 105, 60);
        panel_right.add(panel_Cyan);
        panel_Cyan.setLayout(null);


        panedate = new paneDate();
        panedate.setBounds(724, 410, 640, 310);
        panedate.setBorder(new LineBorder(Color.blue));
        add(panedate);
        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panedate.repaint();
            }
        });
        timer.start();

        JPanel panelUser = new JPanel();
        panelUser.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelUser.setBackground(Color.WHITE);
        panelUser.setBounds(724, 725, 640, 226);
        this.add(panelUser);
        panelUser.setLayout(null);


        JPanel pane_Main = new JPanel();
        pane_Main.setBorder(new LineBorder(Color.LIGHT_GRAY));
        pane_Main.setBackground(Color.WHITE);
        pane_Main.setBounds(20, 410, 694, 409);
        this.add(pane_Main);
        pane_Main.setLayout(null);


        JPanel panel_friend = new JPanel();
        panel_friend.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_friend.setBackground(Color.WHITE);
        panel_friend.setBounds(20, 829, 694, 122);
        this.add(panel_friend);
        panel_friend.setLayout(null);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(127, 255, 0));
        panel.setBounds(253, 57, 120, 5);
        panel_friend.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(370, 57, 70, 5);
        panel_friend.add(panel_1);



    }

    class paneDate extends JPanel {
        /**
         *
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            index++;
        }

    }
}

