package tyut.selab.desktop.ui.todolist.user;


import tyut.selab.desktop.ui.todolist.component.ManagerBookManageComponent;
import tyut.selab.desktop.ui.todolist.component.UserBookManageComponent;
import tyut.selab.desktop.ui.todolist.manager.ManagerInterface;
import tyut.selab.desktop.ui.todolist.utils.AlarmClock01;
import tyut.selab.desktop.ui.todolist.utils.PathUtils;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;

public class UserInterface {
    JFrame jf = new JFrame("创新实验室图书馆：用户，欢迎您");

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //组装视图
    public void init() throws Exception {
        //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //设置分割面板
        JSplitPane sp = new JSplitPane();

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //设置左侧内容
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("任务清单");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("统计分析");

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
        //设置当前tree默认选中图书管理
        tree.setSelectionRow(2);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (userManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行用户管理..."));
                    sp.setDividerLocation(150);
                }else if (bookManage.equals(lastPathComponent)){
                    sp.setRightComponent(new UserBookManageComponent(jf));
                    sp.setDividerLocation(150);
                } if (borrowManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行借阅管理..."));
                    sp.setDividerLocation(150);
                } if (statisticsManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行统计分析..."));
                    sp.setDividerLocation(150);
                }

            }
        });


        sp.setRightComponent(new UserBookManageComponent(jf));
        sp.setLeftComponent(tree);
        jf.add(sp);
        jf.setVisible(true);

        jf.setTitle("创新实验室图书馆：用户，欢迎您");

    }

    public static void main(String[] args) {
        try {
            new UserInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AlarmClock01 alarmClock01 = new AlarmClock01();
        alarmClock01.start();
    }

    //自定义结点绘制器
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

        //当绘制树的每个结点时，都会调用这个方法
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //使用默认绘制
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
