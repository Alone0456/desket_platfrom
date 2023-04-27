package tyut.selab.desktop.ui.sharecenter;


import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class boundary extends JPanel{

    //列表展示信息 (传入一个信息集合)
    private DefaultListModel defaultListModel = null;
    private JList<BugVo> bugVoJList = null;

    //窗口
    private JPanel homeJPanel = null;



    //报错信息以及头像时间
    // 布局管理器
    GridBagLayout gridBag = null;
    // 约束
    GridBagConstraints c = null;
    GridBagLayout igridBag = null;
    private JPanel errorShow = null;
    private JPanel iPanel = null;


    private JButton adminShow = null;
    private JLabel timeShow = null;
    private JLabel informationShow = null;
    private JLabel stackShow = null;



    //解决方案
    private JPanel saveShow = null;
    private JLabel saveInformation = null;
    private JLabel saveImage = null;


    //创建一个垂直的分割面板
    private JSplitPane right = null;

    //创建一个水平分隔面板
    private JSplitPane content = null ;

    //技术栈选择
    private JFrame stackCheck = null;
    private JPanel options = null;
    private JPanel buttons = null;
    private List<JCheckBox> checkBoxes = null;

    //用户筛选时确认的按钮
    private JButton sureJButton = null;
    //管理员按钮
    private JButton insertJButton = null;
    private JButton deleteJButton = null;
    private JButton updateJButton = null;

    //右键菜单
    private JPopupMenu popupMenu = null;
    private JMenuItem deleteItem = null;
    private JMenuItem updateItem = null;

    //按技术栈搜索
    private JMenuItem stackItem1 = null;
    //添加
    private JMenuItem addItem = null;
    //我的
    private JMenuItem ownItem = null;
    //全部
    private JMenuItem allItem = null;
    //管理技术栈
    private JMenuItem manageItem = null;
    //按技术栈选择
    private JMenuItem stackItem2 = null;


    public boundary() {
        this.defaultListModel = new DefaultListModel();
        this.bugVoJList =new JList<>(defaultListModel);

        this.homeJPanel = new JPanel();


        this.stackItem1 = new JMenuItem("筛选");
        this.addItem = new JMenuItem("添加");
        this.ownItem = new JMenuItem("我的");
        this.allItem = new JMenuItem("全部");

        this.manageItem = new JMenuItem("管理技术栈");
        this.stackItem2 = new JMenuItem("按技术栈选择");



        this.gridBag = new GridBagLayout();
        this.igridBag = new GridBagLayout();
        this.c = null;
        this.errorShow = new JPanel(gridBag);
        this.iPanel = new JPanel(igridBag);
        this.adminShow = new JButton();


        this.timeShow = new JLabel();
        this.informationShow = new JLabel("",SwingConstants.CENTER);
        this.stackShow = new JLabel();
        this.saveShow = new JPanel(new BorderLayout());
        this.saveInformation = new JLabel("",SwingConstants.CENTER);

        this.right = new JSplitPane(JSplitPane.VERTICAL_SPLIT,errorShow,saveShow);
        this.content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(bugVoJList),right);

        this.stackCheck = new JFrame("技术栈");
        this.options = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.checkBoxes = new ArrayList<>();


        this.sureJButton = new JButton("yes");


        this.popupMenu = new JPopupMenu();
        this.deleteItem = new JMenuItem("删除");
        this.updateItem = new JMenuItem("更改");





    }



    public void setInsertJButton(JButton insertJButton) {
        this.insertJButton = insertJButton;
    }

    public void setDeleteJButton(JButton deleteJButton) {
        this.deleteJButton = deleteJButton;
    }

    public void setUpdateJButton(JButton updateJButton) {
        this.updateJButton = updateJButton;
    }



    //一些供外部使用的get方法

    public DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }

    public JPanel getHomeJPanel() {
        return homeJPanel;
    }

    public JMenuItem getStackItem1() {
        return stackItem1;
    }

    public JMenuItem getAddItem() {
        return addItem;
    }

    public JMenuItem getOwnItem() {
        return ownItem;
    }

    public JMenuItem getAllItem() {
        return allItem;
    }

    public JMenuItem getManageItem() {
        return manageItem;
    }

    public JMenuItem getStackItem2() {
        return stackItem2;
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

    public List<JCheckBox> getCheckBoxes() {
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

    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    public JMenuItem getDeleteItem() {
        return deleteItem;
    }

    public JMenuItem getUpdateItem() {
        return updateItem;
    }

    @Override
    public String toString() {
        return "boundary{" +
                "checkBoxes=" + checkBoxes +
                '}';
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
        homeJPanel();
        beautifyAdminShow();
        beautifyErrorShow();
        beautifySaveShow();
        beautifyAdminShow();
    }


    /**
     * 为界面的三个板块设置大小
     */
    public void setPreferredSize(){
        bugVoJList.setPreferredSize(new Dimension(230,670));
        errorShow.setPreferredSize(new Dimension(750,250));
        saveShow.setPreferredSize(new Dimension(750,420));
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
        right.setDividerLocation(250);
        //设置分割面板根据组件的大小调整最佳布局
        right.resetToPreferredSizes();

        content.resetToPreferredSizes();
        content.setDividerLocation(300);
        content.setEnabled(false);
        right.setEnabled(true);
        //设置支持连续布局
        content.setContinuousLayout(true);
    }





    /**
     * 为列表添加事件监听器,用户点击一条错误，右边相应展示报错信息和解决方案
     * 不管是查看所有信息，还是查看相关类型信息，还是增加或者删除后，把更新后的list传到该方法即可显示在界面。
     */
    public void setList(List<BugVo> informations){
        if(informations.size() == 0){
            bugVoJList.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    if(e.getButton()==MouseEvent.BUTTON3){

                        int index = bugVoJList.locationToIndex(e.getPoint());

                        bugVoJList.setSelectedIndex(index);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());



                    }
                }
            });
        }

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
                    informationShow.setText(boundary.errorLineFeed(informations.get(selectedIndex).getBugTitle()));
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
                    saveInformation.setText(boundary.saveLineFeed(informations.get(selectedIndex).getBugSolve()));



                    bugVoJList.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);

                            if(e.getButton()==MouseEvent.BUTTON3){

                                int index = bugVoJList.locationToIndex(e.getPoint());

                                    bugVoJList.setSelectedIndex(index);
                                    popupMenu.show(e.getComponent(), e.getX(), e.getY());



                            }
                        }
                    });

                }
            }


        });

    }


    /**
     * 组装errorShow(右上角栏)
     */
    public void setErrorShow(){
        JScrollPane errorJScrollPane = new JScrollPane(informationShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        errorJScrollPane.setBackground(new Color(40,47,54));
        errorJScrollPane.setForeground(new Color(40,47,54));
           // 布局管理器
        GridBagConstraints ic = null;

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

        errorShow.setOpaque(true);
//        errorShow.setBackground(new Color(166,166,166));
        errorShow.setBackground(new Color(40,47,54));
        informationShow.setFont(new Font("宋体",Font.BOLD,25));
        informationShow.setOpaque(true);
        informationShow.setBackground(new Color(29,32,38));

        timeShow.setForeground(new Color(166,166,166));

        //报错信息
        informationShow.setForeground(new Color(255,255,255));

        stackShow.setOpaque(true);
        stackShow.setBackground(new Color(24,189,209));
        stackShow.setForeground(new Color(255,255,255));
        stackShow.setFont(new Font("宋体",Font.BOLD,20));

        iPanel.setOpaque(true);
        iPanel.setBackground(new Color(40,47,54));
        adminShow.setOpaque(true);
        adminShow.setBorderPainted(false);//不绘制边框
        adminShow.setFocusPainted(false);//选中后不绘制边框
        adminShow.setContentAreaFilled(false);//不绘制按钮区域
        adminShow.setFont(new Font("宋体", Font.BOLD,22));
        adminShow.setForeground(new Color(127,133,143));



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
        saveInformation.setOpaque(true);
        saveInformation.setFont(new Font("宋体", Font.ITALIC,18));
        saveInformation.setForeground(new Color(24,189,209));
        saveInformation.setBackground(new Color(29,32,38));
//        saveInformation.setBackground(new Color(166,166,166));

        bugVoJList.setBackground(new Color(29,32,38));
//        bugVoJList.setBackground(new Color(166,166,166));
        bugVoJList.setForeground(new Color(166,166,166));
    }


    /**
     * 美化adminShow
     */
    public void beautifyAdminShow(){
        adminShow.setBorderPainted(false);
        adminShow.setFocusPainted(false);
    }





    /**
     * 窗口风格，大小
     */
    public void homeJPanel(){
        homeJPanel.setPreferredSize(new Dimension(1010,700));
        homeJPanel.add(content);
        homeJPanel.setBackground(new Color(40,47,54));
        homeJPanel.setVisible(true);

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
        int end = 40;
        int interval = 40;
        for(int i = 0;i< s.length()/interval+1;i++) {
            if(end > s.length()){
                end = s.length();
                errorStringBuffer.append(s, start, end);
                errorStringBuffer.append("<br>");
                return errorStringBuffer.toString();
            }
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

        errorStringBuffer.append("</body></html>");
        return errorStringBuffer.toString();
    }
    public static String saveLineFeed(String s){
        //save信息的换行
        StringBuffer saveStringBuffer = new StringBuffer();
        saveStringBuffer.append("<html><body>");

        int start = 0;
        int end = 30;
        int interval = 30;
        for(int i = 0;i< s.length()/interval+1;i++){
            if(end > s.length()){
                end = s.length();
                saveStringBuffer.append(s, start, end);
                saveStringBuffer.append("<br>");
                return saveStringBuffer.toString();
            }

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

        saveStringBuffer.append("</body></html>");
        return saveStringBuffer.toString();
    }
    public static String jlistTextShow(String s){
       int jlistTextlength = 70;
        if(s.length()>jlistTextlength){
            StringBuffer jlistStringBuffer = new StringBuffer();
            char[] chars = s.toCharArray();

            jlistStringBuffer.append(chars,0,jlistTextlength);
            jlistStringBuffer.append("……");
            return jlistStringBuffer.toString();
        }else{
            return s;
        }
    }




}
