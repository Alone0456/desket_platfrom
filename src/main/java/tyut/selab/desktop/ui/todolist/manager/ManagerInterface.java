package tyut.selab.desktop.ui.todolist.manager;



import tyut.selab.desktop.ui.todolist.component.BookManageComponent;
import tyut.selab.desktop.ui.todolist.utils.PathUtils;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ManagerInterface {
    JFrame jf = new JFrame("����ʵ����ͼ��ݣ�Xxx����ӭ��");

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //��װ��ͼ
    public void init() throws Exception {
        //��������������
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //���ò˵���
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("����");
        JMenuItem m1 = new JMenuItem("�л��˺�");
        JMenuItem m2 = new JMenuItem("�˳�����");
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterface().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);

        jf.setJMenuBar(jmb);

        //���÷ָ����
        JSplitPane sp = new JSplitPane();

        //֧����������
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //�����������
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("ϵͳ����");
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("�û�����");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("�����嵥");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("���Ĺ���");
        DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("ͳ�Ʒ���");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsManage);

        Color color = new Color(203,220,217);
        JTree tree = new JTree(root);
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
        tree.setCellRenderer(myRenderer);

        tree.setBackground(color);
        //���õ�ǰtreeĬ��ѡ��ͼ�����
        tree.setSelectionRow(2);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //����Ŀѡ�б仯�����������ִ��
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //�õ���ǰѡ�еĽ�����
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (userManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("��������û�����..."));
                    sp.setDividerLocation(150);
                }else if (bookManage.equals(lastPathComponent)){
                    sp.setRightComponent(new BookManageComponent(jf));
                    sp.setDividerLocation(150);
                } if (borrowManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("������н��Ĺ���..."));
                    sp.setDividerLocation(150);
                } if (statisticsManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("�������ͳ�Ʒ���..."));
                    sp.setDividerLocation(150);
                }

            }
        });


        sp.setRightComponent(new BookManageComponent(jf));
        sp.setLeftComponent(tree);
        jf.add(sp);
        jf.setVisible(true);

        jf.setTitle("����ʵ����ͼ��ݣ���ӭ��");

    }

    public static void main(String[] args) {
        try {
            new ManagerInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //�Զ����������
    private class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon userManageIcon = null;
        private ImageIcon bookManageIcon = null;
        private ImageIcon borrowManageIcon = null;
        private ImageIcon statisticsManageIcon = null;

        public MyRenderer() {
            rootIcon = new ImageIcon(PathUtils.getRealPath("systemManage.png"));
            userManageIcon = new ImageIcon(PathUtils.getRealPath("userManage.png"));
            bookManageIcon = new ImageIcon(PathUtils.getRealPath("bookManage.png"));
            borrowManageIcon = new ImageIcon(PathUtils.getRealPath("borrowManage.png"));
            statisticsManageIcon = new ImageIcon(PathUtils.getRealPath("statisticsManage.png"));

        }

        //����������ÿ�����ʱ����������������
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //ʹ��Ĭ�ϻ���
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            ImageIcon image = null;
            switch (row) {
                case 0:
                    image = rootIcon;
                    break;
                case 1:
                    image = userManageIcon;
                    break;
                case 2:
                    image = bookManageIcon;
                    break;
                case 3:
                    image = borrowManageIcon;
                    break;
                case 4:
                    image = statisticsManageIcon;
                    break;
            }

            this.setIcon(image);
            return this;
        }
    }
}
