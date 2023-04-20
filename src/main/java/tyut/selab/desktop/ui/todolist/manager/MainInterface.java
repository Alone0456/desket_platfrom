package tyut.selab.desktop.ui.todolist.manager;



import tyut.selab.desktop.ui.todolist.component.BackGroundPanel;
import tyut.selab.desktop.ui.todolist.utils.PathUtils;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.Map;

public class MainInterface {

    JFrame jf = new JFrame("����ʵ����ͼ���");

    final int WIDTH = 500;
    final int HEIGHT = 300;

    //��װ��ͼ
    public void init() throws Exception {
        //���ô�����ص�����
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //���ô��ڵ�����

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("library.jpg"))));
        bgPanel.setBounds(0,0,WIDTH,HEIGHT);
        //��װ��¼��ص�Ԫ��
        Box vBox = Box.createVerticalBox();

        //��װ�û���
        Box uBox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("�û�����");
        JTextField uField = new JTextField(15);

        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        //��װ����
        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("��    �룺");
        JTextField pField = new JTextField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pField);

        //��װ��ť
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("��¼");
        JButton registBtn = new JButton("ע��");

       loginBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //��ȡ�û����������
               String username = uField.getText().trim();
               String password = pField.getText().trim();
               Map<String,String> params = new HashMap<>();
               params.put("username",username);
               params.put("password",password);

               try {
                   new ManagerInterface().init();
                   jf.dispose();
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       });

        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(registBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

    //�ͻ��˳�������
    public static void main(String[] args) {
        try {
            new MainInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
