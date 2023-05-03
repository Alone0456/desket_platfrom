package tyut.selab.desktop.ui.todolist.component;

import tyut.selab.desktop.moudle.todolist.controller.impl.TaskController;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.ui.todolist.listener.ActionDoneListener;
import tyut.selab.desktop.ui.todolist.utils.ScreenUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ManagerAddBookDialog extends JDialog {
    private JTable table;

    private DefaultTableModel tableModel;
    final int WIDTH = 400;
    final int HEIGHT = 300;

    private ActionDoneListener listener;

    public ManagerAddBookDialog(JFrame jf, String title, boolean isModel, ActionDoneListener listener) {
        super(jf, title, isModel);
        this.listener = listener;
        //组装视图
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        //组装图书名称
//        Box nameBox = Box.createHorizontalBox();
//        JLabel nameLable = new JLabel("任务编号：");
//        JTextField nameField = new JTextField(15);
//
//        nameBox.add(nameLable);
//        nameBox.add(Box.createHorizontalStrut(20));
//        nameBox.add(nameField);

        //组装用户编号
        Box stockBox = Box.createHorizontalBox();
        JLabel stockLable = new JLabel("用户编号：");
        JTextField stockField = new JTextField(15);

        stockBox.add(stockLable);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //组装任务简介
        Box descBox = Box.createHorizontalBox();
        JLabel descLable = new JLabel("任务介绍：");
        JTextArea descArea = new JTextArea(3, 15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(descArea);
//
//        //组装开始日期
//        Box authorBox = Box.createHorizontalBox();
//        JLabel authorLable = new JLabel("开始日期：");
//        JTextField authorField = new JTextField(15);
//
//        authorBox.add(authorLable);
//        authorBox.add(Box.createHorizontalStrut(20));
//        authorBox.add(authorField);

        //组装截止日期
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLable = new JLabel("截止日期：");
        JTextField priceField = new JTextField(15);
        CalendarPanel p = new CalendarPanel(priceField, "yyyy-MM-dd");
        p.initCalendarPanel();
        add(p);
        add(priceField);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);


        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer taskID = null;
                String taskST = null;
                Integer userStudentNumber;
                String taskET;
                String taskContent;

                //获取用户的录入
                try {
                    userStudentNumber = Integer.valueOf(stockField.getText().trim());
                    taskET = priceField.getText().trim();

                    taskContent = descArea.getText().trim();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "请输入正确格式");
                    return;
                }
                //String转Date
                SimpleDateFormat taskStartTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat taskEndTimeFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date taskStartTime = null;
                Date taskEndTime = null;
                try {
                    taskStartTime = new Date();
                    taskEndTime = taskEndTimeFormat.parse(taskET);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(jf, "请输入正确格式");
                    return; // 结束查询操作
                }

                //添加数据
                TaskController taskController = new TaskController();
                TaskVo taskVo = new TaskVo(taskID, userStudentNumber, taskContent, taskStartTime, taskEndTime);
                try {
                    taskController.insertTask(taskVo);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(jf, "添加成功");

                dispose();
                try {
                    listener.done(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        btnBox.add(addBtn);

//        vBox.add(Box.createVerticalStrut(20));
//        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(stockBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
//        vBox.add(Box.createVerticalStrut(15));
//        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);

        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

        //为了左右有间距，在vBox外层封装一个水平的Box，添加间隔
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));

        this.add(hBox);

    }

}