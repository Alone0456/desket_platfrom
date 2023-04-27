package tyut.selab.desktop.ui.todolist.component;


import tyut.selab.desktop.moudle.todolist.controller.impl.TaskController;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.ui.todolist.listener.ActionDoneListener;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

public class UserUpdateBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    private String id;
    private ActionDoneListener listener;
    private Map<String,Object> map;

    private JTextField nameField;
    private JTextField stockField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea descArea;
    JFrame jf = null;


    public UserUpdateBookDialog(JTable table, Vector<Vector> tableData, DefaultTableModel tableModel, JFrame jf, String title, boolean isModel, ActionDoneListener listener, String id){
        super(jf,title,isModel);
        this.listener  = listener;
        this.id=id;
        //组装视图
        this.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);

        Box vBox = Box.createVerticalBox();

        //组装任务编号
//        Box nameBox = Box.createHorizontalBox();
//        JLabel nameLable = new JLabel("任务编号：");
//        nameField = new JTextField(15);

//        nameBox.add(nameLable);
//        nameBox.add(Box.createHorizontalStrut(20));
//        nameBox.add(nameField);

        //组装用户学号
//        Box stockBox = Box.createHorizontalBox();
//        JLabel stockLable = new JLabel("用户学号：");
//        stockField = new JTextField(15);
//
//        stockBox.add(stockLable);
//        stockBox.add(Box.createHorizontalStrut(20));
//        stockBox.add(stockField);

//        组装开始日期
//        Box authorBox = Box.createHorizontalBox();
//        JLabel authorLable = new JLabel("开始日期：");
//        authorField = new JTextField(15);
//
//        authorBox.add(authorLable);
//        authorBox.add(Box.createHorizontalStrut(20));
//        authorBox.add(authorField);

        //组装截止日期
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLable = new JLabel("截止日期：");
        priceField = new JTextField(15);
        CalendarPanel p = new CalendarPanel(priceField, "yyyy-MM-dd");
        p.initCalendarPanel();
        add(p);
        add(priceField);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);


        //组装任务介绍
        Box descBox = Box.createHorizontalBox();
        JLabel descLable = new JLabel("任务介绍：");
        descArea = new JTextArea(3,15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(new JScrollPane(descArea));

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton updateBtn = new JButton("修改");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前表格选中的id
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1

                //获取用户修改后在输入框中输入的内容
                Integer taskID = Integer.valueOf(tableModel.getValueAt(selectedRow, 0).toString());








                Integer userStudentNumber = 2022005553;






                String taskST = null;
                String taskET = priceField.getText().trim();
                CalendarPanel p = new CalendarPanel(priceField, "yyyy-MM-dd");
                p.initCalendarPanel();
                add(p);
                add(priceField);
                String taskContent = descArea.getText().trim();

                SimpleDateFormat taskStartTimeFormat=new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat taskEndTimeFormat=new SimpleDateFormat("yyyy-MM-dd");

                Date taskStartTime = null;
                Date taskEndTime = null;
                try {
                    taskStartTime = new Date();
                    taskEndTime = taskEndTimeFormat.parse(taskET);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                TaskVo taskVo = new TaskVo(taskID,userStudentNumber,taskContent,taskStartTime,taskEndTime);
                TaskController taskController = new TaskController();
                try {
                    taskController.updateTask(taskVo);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(jf,"修改成功");
                dispose();
                listener.done(null);
            }
        });
        //TODO 处理修改的行为
        btnBox.add(updateBtn);

//        vBox.add(Box.createVerticalStrut(20));
//        vBox.add(nameBox);
//        vBox.add(Box.createVerticalStrut(15));
//        vBox.add(stockBox);
//        vBox.add(Box.createVerticalStrut(15));
//        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

        //为了左右有间距，在vBox外层封装一个水平的Box，添加间隔
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));

        this.add(hBox);
        //回显数据
        requestData();
    }

    //请求数据
    public void requestData(){

    }

}
