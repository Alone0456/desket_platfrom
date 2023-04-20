package tyut.selab.desktop.ui.sharecenter;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;


public class boundary{

    //列表展示信息 (传入一个信息集合)
    private DefaultListModel defaultListModel = null;
    private JList<BugVo> bugVoJList = null;

    //窗口
    private JFrame frame = null;

    //菜单栏（实现添加，搜索，我的)
    private JMenuBar jMenuBar = null;
    //功能
    private JMenu jMenu = null;
    //按技术栈搜索
    private JMenuItem jMenuItem1 = null;
    //添加
    private JMenuItem jMenuItem2 = null;
    //我的
    private JMenuItem jMenuItem3 = null;
    //全部
    private JMenuItem jMenuItem4 = null;
    //管理技术栈
    private JMenuItem jMenuItem5 = null;
    //筛选
    private JMenu jMenu2 = null;

    //按技术栈选择
    private JMenuItem jMenuItem7 = null;


    //报错信息以及头像时间
    // 布局管理器
    GridBagLayout gridBag = null;
    // 约束
    GridBagConstraints c = null;
    private JPanel errorShow = null;
    private JButton adminShow = null;
    private JLabel timeShow = null;
    private JLabel informationShow = null;
    private JLabel stackShow = null;


    //解决方案
    private JPanel saveShow = null;
    private JLabel saveInformation = null;


    //创建一个垂直的分割面板
    private JSplitPane right = null;

    //创建一个水平分隔面板
    private JSplitPane content = null ;

    //技术栈选择
    private JFrame stackCheck = null;
    private JPanel options = null;
    private JPanel buttons = null;
    private JCheckBox[] checkBoxes = null;

    //用户筛选时确认的按钮
    private JButton sureJButton = null;
    //管理员按钮
    private JButton insertJButton = null;
    private JButton deleteJButton = null;
    private JButton updateJButton = null;

    //添加报错信息
    private JFrame addErrorShow = null;



    public boundary() {
        this.defaultListModel = new DefaultListModel();
//        defaultListModel.addAll();
        this.bugVoJList =new JList<>(defaultListModel);

        this.frame = new JFrame("这里在测试");
        this.jMenuBar = new JMenuBar();
        this.jMenu = new JMenu("功能");
        this.jMenuItem1 = new JMenuItem("筛选");
        this.jMenuItem2 = new JMenuItem("添加");
        this.jMenuItem3 = new JMenuItem("我的");
        this.jMenuItem4 = new JMenuItem("全部");

        this.jMenuItem5 = new JMenuItem("管理技术栈");
        this.jMenu2 = new JMenu("筛选");
        this.jMenuItem7 = new JMenuItem("按技术栈选择");


        this.gridBag = new GridBagLayout();
        this.c = null;
        this.errorShow = new JPanel(gridBag);
        this.adminShow = new JButton();
        this.timeShow = new JLabel();
        this.informationShow = new JLabel();
        this.stackShow = new JLabel();
        this.saveShow = new JPanel(new BorderLayout());
        this.saveInformation = new JLabel();
        this.right = new JSplitPane(JSplitPane.VERTICAL_SPLIT,errorShow,saveShow);
        this.content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(bugVoJList),right);

        this.stackCheck = new JFrame("技术栈");
        this.options = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.checkBoxes = new JCheckBox[5];

        /**
         * 这里需要给 checkBoxes = new JCheckBox[bugType.size()];
         */

        this.sureJButton = new JButton("yes");

        this.insertJButton = new JButton("insert");
        this.deleteJButton = new JButton("delete");
        this.updateJButton = new JButton("update");



    }

    //一些供外部使用的get方法

    public DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JMenuBar getjMenuBar() {
        return jMenuBar;
    }

    public JMenu getjMenu() {
        return jMenu;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public JMenuItem getjMenuItem5() {
        return jMenuItem5;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public JMenuItem getjMenuItem7() {
        return jMenuItem7;
    }

    public JFrame getStackCheck() {
        return stackCheck;
    }


    public JPanel getOptions() {
        return options;
    }

    public JPanel getButtons() {
        return buttons;
    }

    public JCheckBox[] getCheckBoxes() {
        return checkBoxes;
    }

    public JButton getSureJButton() {
        return sureJButton;
    }

    public JButton getInsertJButton() {
        return insertJButton;
    }

    public JButton getDeleteJButton() {
        return deleteJButton;
    }

    public JButton getUpdateJButton() {
        return updateJButton;
    }

    public JButton getAdminShow() {
        return adminShow;
    }

    public JList<BugVo> getBugVoJList() {
        return bugVoJList;
    }

    /**
     * 整个界面的组装
     */
    public void init(){
        //为板块设置大小
        setPreferredSize();
        //组装报错信息栏
        setErrorShow();
        //组装解决方案栏
        setSaveShow();
        //组装菜单栏和菜单栏功能
        //分割条功能
        jSplitPane();
        //窗口功能实现
        frame();
    }


    /**
     * 为界面的三个板块设置大小
     */
    public void setPreferredSize(){
        bugVoJList.setPreferredSize(new Dimension(150,400));
        errorShow.setPreferredSize(new Dimension(220,330));
        saveShow.setPreferredSize(new Dimension(220,70));
    }


    /**
     * 两个分隔条的设置
     */
    public void jSplitPane(){
        //打开"一触即展"特性
        right.setOneTouchExpandable(true);
        //设置分隔条的大小
        right.setDividerSize(10);
        //设置分隔条位置
        right.setDividerLocation(200);
        //设置分割面板根据组件的大小调整最佳布局
        right.resetToPreferredSizes();

        content.resetToPreferredSizes();
        content.setDividerLocation(150);
        content.setEnabled(false);
        right.setEnabled(true);
        //设置支持连续布局
        content.setContinuousLayout(true);
    }


    /**
     *列表最初显示
     * 不管是查看所有信息，还是查看相关类型信息，还是增加或者删除后，把更新后的list传到该方法即可显示在界面。
     */
    public void setDefaultJlist(List<BugVo> bugVos){

        List<BugVo> bugVos1 = bugVos;
        bugVoJList.setSelectedIndex(0);
        bugVoJList.setSelectedValue(bugVos.get(0),true);
        adminShow.setText(bugVos.get(0).getUserVo().getName());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeShow.setText(sdf.format(bugVos.get(0).getReleaseTime()));
        informationShow.setText(bugVos.get(0).getBugTitle());
        StringBuffer stackBuffer = new StringBuffer();
        for(int i = 0;i<=bugVos.get(0).getBugType().size()-1;i++){
            stackBuffer.append(" ");
            stackBuffer.append(bugVos.get(0).getBugType().get(i));
            if(i!=bugVos.get(0).getBugType().size()-1){
                stackBuffer.append(",");
            }else{
                stackBuffer.append(" ");
            }
        }
        stackShow.setText(stackBuffer.toString());

        //展示解决方案
        saveInformation.setText(bugVos.get(0).getBugSolve());

        beautifyErrorShow();
        beautifySaveShow();
        beautifyAdminShow();

    }


    /**
     * 为列表添加事件监听器,用户点击一条错误，右边相应展示报错信息和解决方案
     * 不管是查看所有信息，还是查看相关类型信息，还是增加或者删除后，把更新后的list传到该方法即可显示在界面。
     */
    public void setList(List<BugVo> informations){
        bugVoJList.removeAll();
        bugVoJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(bugVoJList.getValueIsAdjusting()){
//                    获取列表上选择的报错信息

                    int selectedIndex = 0;
                    selectedIndex = bugVoJList.getSelectedIndex();
                    if(selectedIndex == -1){
                        selectedIndex = 0;
                    }

//                展示报错信息，用户，时间.
                    adminShow.setText(informations.get(selectedIndex).getUserVo().getName());
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    timeShow.setText(sdf.format(informations.get(selectedIndex).getReleaseTime()));
                    informationShow.setText(informations.get(selectedIndex).getBugTitle());
                    StringBuffer stackBuffer = new StringBuffer();
                    for(int i = 0;i<=informations.get(selectedIndex).getBugType().size()-1;i++){
                        stackBuffer.append(" ");
                        stackBuffer.append(informations.get(selectedIndex).getBugType().get(i));
                        if(i!=informations.get(selectedIndex).getBugType().size()-1){
                            stackBuffer.append(",");
                        }else{
                            stackBuffer.append(" ");
                        }
                    }
                    stackShow.setText(stackBuffer.toString());

                    //展示解决方案
                    saveInformation.setText(informations.get(selectedIndex).getBugSolve());

                    beautifyErrorShow();
                    beautifySaveShow();
                    beautifyAdminShow();
                }
            }


        });


    }


    /**
     * 组装errorShow(右上角栏)
     */
    public void setErrorShow(){
        JScrollPane errorJScrollPane = new JScrollPane(informationShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GridBagLayout igridBag = new GridBagLayout();    // 布局管理器
        GridBagConstraints ic = null;
        JPanel iPanel = new JPanel(igridBag);

        ic = new GridBagConstraints();

        ic.insets = new Insets(0, 10, 0, 10);

        ic = new GridBagConstraints();

        ic.insets = new Insets(0, 10, 0, 10);

        igridBag.addLayoutComponent(adminShow, ic);

        iPanel.add(adminShow);


        /* 添加 组件 和 约束 到 布局管理器 */

        //stackshow

        c = new GridBagConstraints();

        c.anchor = GridBagConstraints.WEST;

        c.insets = new Insets(2, 10, 2, 10);

        c.gridx = 0;

        c.gridy = 0;

        gridBag.addLayoutComponent(stackShow, c);


        //放头像和信息
        c = new GridBagConstraints();

        c.anchor = GridBagConstraints.EAST;

        c.insets = new Insets(2, 10, 2, 10);

        c.gridwidth = GridBagConstraints.REMAINDER;

        gridBag.addLayoutComponent(iPanel, c);


        //informationshow

        c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;

        c.insets = new Insets(2, 10, 2, 10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1;

        c.weighty = 1;

        gridBag.addLayoutComponent(errorJScrollPane, c);


        //timeshow

        c = new GridBagConstraints();

        c.anchor = GridBagConstraints.EAST;

        c.insets = new Insets(2, 10, 2, 10);

        c.gridwidth = GridBagConstraints.REMAINDER;

        gridBag.addLayoutComponent(timeShow, c);

        /* 添加 组件 到 内容面板 */
//        informationShow.setHorizontalAlignment(SwingConstants.CENTER);
        errorShow.add(stackShow);
        errorShow.add(iPanel);
        errorShow.add(errorJScrollPane);
        errorShow.add(timeShow);
    }


    /**
     * 美化errorShow里面的组件
     */
    public void beautifyErrorShow(){
        //技术栈框
        Border etchedRaisedBorder1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border lineBorder1 = BorderFactory.createLineBorder(Color.ORANGE,2);
        Border stackBorder = BorderFactory.createCompoundBorder(etchedRaisedBorder1, lineBorder1);
        stackShow.setBorder(stackBorder);
        //信息框
        Border etchedRaisedBorder2 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border lineBorder2 = BorderFactory.createLineBorder(Color.GRAY,4);
        Border informationBorder = BorderFactory.createCompoundBorder(etchedRaisedBorder2, lineBorder2);
        informationShow.setBorder(informationBorder);
        //时间框
        Border etchedRaisedBorder3 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border lineBorder3 = BorderFactory.createLineBorder(Color.black,0);
        Border timeBorder = BorderFactory.createCompoundBorder(etchedRaisedBorder3, lineBorder3);
        timeShow.setBorder(timeBorder);
    }


    /**
     * 组装saveShow(右上角栏)
     */
    public void setSaveShow(){
        saveShow.add(new JScrollPane(saveInformation,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
    }


    /**
     * 美化saveShow里面的组件
     */
    public void beautifySaveShow(){
        Border etchedRaisedBorder4 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border lineBorder4 = BorderFactory.createLineBorder(Color.cyan,3);
        Border saveBorder = BorderFactory.createCompoundBorder(etchedRaisedBorder4, lineBorder4);
        saveInformation.setBorder(saveBorder);
    }


    /**
     * 美化adminShow
     */
    public void beautifyAdminShow(){
        adminShow.setBorderPainted(false);
    }




    /**
     * 窗口风格，大小
     */
    public void frame(){
        frame.add(content);

        //打开窗口
        Object o = (Object)"欢迎进入Dug查看中心";
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(frame,o,"欢迎",JOptionPane.INFORMATION_MESSAGE);

            }
        });
/**
 * 没导包
 */
        //窗口风格
//        try {
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



        //关闭程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗口图标(还未设置)
        URL resource = boundary.class.getClassLoader().getResource("");
        Image image = new ImageIcon(resource).getImage();
        //窗口大小
        frame.setSize(600,500);
        //居中
        frame.setLocationRelativeTo(null);
        //不可改变大小
        frame.setResizable(false);
        //可视
        frame.setVisible(true);

    }


    /**
     * 报错信息和解决方案的文字自动换行方法（美化）
     * 如果不美化，将不换行，无法全部展示
     * 为了使JLabel的文字换行，需要使用html
     * 通过StringBuffer进行拼接，将想展示的文字和html标签拼接，用循环来确保每次有多少个字在一行展示，然后进行换行。
     * 第一行的处理和其他行有所不同，用<&nbsp进行首行缩进
     * jlistTextshow是左侧显示列表框，显示的信息是省略了的报错信息
     * @param
     * @return 返回的就是要展现在JLabel上的String
     */
    public static String errorLineFeed(String s){
        StringBuffer errorStringBuffer = new StringBuffer();
        errorStringBuffer.append("<html><body>");
        int start = 0;
        int end = 34;
        int interval = 40;
        for(int i = 0;i< s.length()/interval+1;i++) {
            if (i == 0) {
                errorStringBuffer.append("<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp");
                errorStringBuffer.append(s, start, end);
                errorStringBuffer.append("<br>");
                start = end;
                if(start + interval > s.length()) {
                    end = s.length();
                }else {
                    end = start + interval;
                }
            }else{
                errorStringBuffer.append(s, start, end);
                errorStringBuffer.append("<br>");
                if (end < s.length() - interval ) {
                    start += interval;
                    end += interval;
                } else {
                    start += interval;
                    end = s.length();
                }
            }
        }
        errorStringBuffer.append("</body></html>");
        return errorStringBuffer.toString();
    }
    public static String saveLineFeed(String s){
        //save信息的换行
        StringBuffer saveStringBuffer = new StringBuffer();
        saveStringBuffer.append("<html><body>");

        int start = 0;
        int end = 31;
        int interval = 31;
        for(int i = 0;i< s.length()/interval+1;i++){
            if(i == 0){
                saveStringBuffer.append("<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp");
                saveStringBuffer.append(s,start,end);
                saveStringBuffer.append("<br>");
                start = end;
                end = start + interval;
            }else {
                saveStringBuffer.append(s, start, end);
                saveStringBuffer.append("<br>");
                if (end < s.length() - interval ) {
                    start += interval;
                    end += interval;
                } else {
                    start += interval;
                    end = s.length();
                }
            }
        }
        saveStringBuffer.append("</body></html>");
        return saveStringBuffer.toString();
    }
    public static String jlistTextShow(String s){
        StringBuffer jlistStringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        int jlistTextlength = 10;
        jlistStringBuffer.append(chars,0,jlistTextlength);
        jlistStringBuffer.append("……");
        return jlistStringBuffer.toString();
    }



}
