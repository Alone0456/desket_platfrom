package tyut.selab.desktop.ui.sharecenter;

import javax.swing.*;
import java.awt.*;

public class inputMessageFrame {
    private JFrame frame=  null;   //创建Frame窗口
    private String title = null;
    private JPanel jp= null;    //创建一个JPanel对象
    private JPanel jp2 = null;
    private JTextArea jta = null;
    private JScrollPane jsp = null;
    private Dimension size = null;
    private  JButton jButton = null;


    public inputMessageFrame(String title,String initString) {
        this.title = title;
        frame = new JFrame(title);
        jp = new JPanel();
        jp2 = new JPanel();

        jta = new JTextArea(initString,7,30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.YELLOW);    //设置按钮背景色

        jsp=new JScrollPane(jta);
        size=jta.getPreferredSize();

        jButton = new JButton("提交");
        jButton.setPreferredSize(new Dimension(80,20));


        jsp.setBounds(65,20,size.width,size.height);

        jp.add(jsp);
        jp.setLayout(new BorderLayout());
        jp2.add(jButton);

        frame.add(jp,BorderLayout.CENTER);    //将JPanel容器添加到JFrame容器中
        frame.add(jp2,BorderLayout.SOUTH);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setSize(400,200);    //设置JFrame容器的大小
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JButton getjButton() {
        return jButton;
    }

    public JTextArea getJta() {
        return jta;
    }

    public JFrame getFrame() {
        return frame;
    }
}
