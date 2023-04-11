package tyut.selab.desktop.ui.todolist;

import tyut.selab.desktop.ui.todolist.libraryManagerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import com.lms.NULL_.BookManageUI;
//import com.lms.NULL_.LendManageUI;
//import com.lms.NULL_.UserManageUI;
//import com.lms.NULL_.headerIcon3;

//import com.lms.ui.libraryManagerPanel.paneDate;
@SuppressWarnings({"all"})

public class MainUI extends JFrame {


    private JPanel contentPane;
    private JTextField txtSearch;
    private JTextField txtBookeName;
    private JTextField txtBookNamber;
    private JTable Tables;
    private JPanel panelBigerMain;
    private JLabel txtheader;
    private JLabel lblLibraryMessage;
    private JLabel lblMainMenu;
    private JLabel lbllendManager;
    private JLabel lblUserManae;
    private JPanel panelIcon;
    private JPanel panelheadIcon;
    private boolean isShow = false;// 定义是否显示，默认不显示

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    MainUI frame = new MainUI();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public MainUI() {
        setBackground(new Color(255, 255, 255));


        //标题创建
        setTitle("图书管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH); //最大化
        this.setVisible(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(192, 192, 192)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 250, 1031);
        contentPane.add(panel);
        panel.setLayout(null);

        panelheadIcon = new JPanel();


        JLabel lbladmin = new JLabel("admin");

        JButton btnImage01 = new JButton("");
        btnImage01.setBounds(38, 221, 20, 20);
        panelheadIcon.add(btnImage01);
        btnImage01.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnImage01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        btnImage01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelIcon.setVisible(false);

            }
        });

        JButton btnImage02 = new JButton("");

        btnImage02.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnImage02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        JButton btnImage03 = new JButton("");
        btnImage03.setBackground(new Color(250, 128, 114));

        panelIcon = new JPanel();



        txtSearch = new JTextField();
        txtSearch.setText("\u641C\u7D22..");
        txtSearch.setBackground(new Color(240, 255, 240));
        txtSearch.setBounds(0, 280, 218, 30);
        panel.add(txtSearch);
        txtSearch.setColumns(10);

        ImageIcon image = new ImageIcon("picture\\search.png");
        JLabel lblIcon = new JLabel(image);
        lblIcon.setBounds(215, 285, 25, 25);
        panel.add(lblIcon);

        JPanel panelMenu = new JPanel();


        ImageIcon imageMenu = new ImageIcon("picture\\lblMenu.png");
        JLabel lblMenu1 = new JLabel();


        JPanel paneLibrarymanage = new JPanel();
        paneLibrarymanage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                paneLibrarymanage.setBackground(new Color(43, 187, 173));
                paneLibrarymanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                paneLibrarymanage.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtheader.setText(lblLibraryMessage.getText());
                panelBigerMain.setVisible(false);
//				panelBigerMain = new BookManageUI();
                panelBigerMain.setBounds(250, 5, 1645, 996);
                contentPane.add(panelBigerMain);
                repaint();

            }
        });
        paneLibrarymanage.setLayout(null);
        paneLibrarymanage.setBackground(Color.WHITE);
        paneLibrarymanage.setBounds(0, 365, 249, 44);
        panel.add(paneLibrarymanage);

        lblLibraryMessage = new JLabel("\u95f9\u949f\u8ba1\u65f6");
        lblLibraryMessage.setForeground(Color.BLACK);
        lblLibraryMessage.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
        lblLibraryMessage.setBounds(47, 13, 74, 20);
        paneLibrarymanage.add(lblLibraryMessage);

        ImageIcon imageManager = new ImageIcon("picture\\LibraryManage.png");
        JLabel lblManager = new JLabel(imageManager);
        lblManager.setBounds(15, 12, 22, 22);
        paneLibrarymanage.add(lblManager);

        JPanel paneLendManage = new JPanel();
        paneLendManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                paneLendManage.setBackground(new Color(43, 187, 173));
                paneLendManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                paneLendManage.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtheader.setText(lbllendManager.getText());
                panelBigerMain.setVisible(false);
//				panelBigerMain = new LendManageUI();
                panelBigerMain.setBounds(250, 45, 1670, 996);
                contentPane.add(panelBigerMain);
                repaint();

            }
        });
        paneLendManage.setLayout(null);
        paneLendManage.setBackground(Color.WHITE);
        paneLendManage.setBounds(0, 410, 249, 44);
        panel.add(paneLendManage);

        lbllendManager = new JLabel("\u7ec4\u957f\u4efb\u52a1");
        lbllendManager.setForeground(Color.BLACK);
        lbllendManager.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
        lbllendManager.setBounds(47, 13, 74, 20);
        paneLendManage.add(lbllendManager);

        ImageIcon imagelend = new ImageIcon("picture\\lendManager.png");
        JLabel lblManager_1 = new JLabel(imagelend);
        lblManager_1.setBounds(15, 12, 22, 22);
        paneLendManage.add(lblManager_1);

        JPanel panelUsermanage = new JPanel();
        panelUsermanage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panelUsermanage.setBackground(new Color(43, 187, 173));
                panelUsermanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelUsermanage.setBackground(Color.white);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtheader.setText(lblUserManae.getText());
                panelBigerMain.setVisible(false);
//				panelBigerMain = new UserManageUI();
                panelBigerMain.setBounds(250, 45, 1670, 996);
                contentPane.add(panelBigerMain);
                repaint();

            }
        });
        panelUsermanage.setLayout(null);
        panelUsermanage.setBackground(Color.WHITE);
        panelUsermanage.setBounds(0, 455, 249, 44);
        panel.add(panelUsermanage);

        lblUserManae = new JLabel("\u4e2a\u4eba\u4efb\u52a1");
        lblUserManae.setForeground(Color.BLACK);
        lblUserManae.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
        lblUserManae.setBounds(47, 13, 74, 20);
        panelUsermanage.add(lblUserManae);

        ImageIcon imageUsermanger = new ImageIcon("picture\\UserManage.png");
        JLabel lblManager_1_1 = new JLabel(imageUsermanger);
        lblManager_1_1.setBounds(15, 12, 22, 22);
        panelUsermanage.add(lblManager_1_1);



        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(211, 211, 211));
        separator.setBounds(250, 45, 1670, 2);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(new Color(211, 211, 211));
        separator_1.setBounds(250, 1, 1670, 2);
        contentPane.add(separator_1);

        ImageIcon images = new ImageIcon("picture\\menu.png");
        JLabel lblMenu = new JLabel(images);

        lblMenu.setBounds(253, 8, 32, 32);
        contentPane.add(lblMenu);

        txtheader = new JLabel("\u4E3B\u9875");
        txtheader.setFont(new Font("宋体", Font.BOLD, 12));
        txtheader.setForeground(new Color(105, 105, 105));
        txtheader.setBounds(290, 7, 73, 30);
        contentPane.add(txtheader);



        panelBigerMain = new JPanel();
        panelBigerMain.setBackground(new Color(255, 255, 255));
        panelBigerMain.setBounds(250, 45, 1654, 996);
        contentPane.add(panelBigerMain);
        panelBigerMain.setLayout(null);

        panelBigerMain.setVisible(false);
        panelBigerMain = new libraryManagerPanel();
        panelBigerMain.setBounds(250, 45, 1670, 996);
        getContentPane().add(panelBigerMain);



//		content();
//		content2();

    }
}
