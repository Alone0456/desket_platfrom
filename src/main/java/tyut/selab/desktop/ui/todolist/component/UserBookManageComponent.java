package tyut.selab.desktop.ui.todolist.component;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import com.alibaba.druid.pool.DruidDataSource;
import tyut.selab.desktop.moudle.todolist.controller.impl.TaskController;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.ui.todolist.listener.ActionDoneListener;
import tyut.selab.desktop.ui.todolist.utils.AlarmClock01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class UserBookManageComponent extends Box {
    final int WIDTH = 850;
    final int HEIGHT = 600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private List<TaskVo>  quarryTableData;
    private DefaultTableModel tableModel;

    public UserBookManageComponent(JFrame jf) {
        //垂直布局
        super(BoxLayout.Y_AXIS);
        //组装视图
        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203, 220, 217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH, 80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");
        JButton queryBtn = new JButton("查询");
        AlarmClock01 alarmClock01 = new AlarmClock01();
        alarmClock01.start();

        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quarryUserDialog(table,tableData,tableModel,jf, "查询任务", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {

                    }
                }).setVisible(true);
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出一个对话框，让用户输入图书的信息
                new UserAddBookDialog(jf, "增加任务", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestData();
                    }
                }).setVisible(true);
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前表格选中的id
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(jf, "请选择要修改的条目！");
                    return;
                }

                String id = tableModel.getValueAt(selectedRow, 0).toString();

                //弹出一个对话框，让用户修改
                new UserUpdateBookDialog(table,tableData,tableModel,jf, "修改任务", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestData();
                    }
                }, id).setVisible(true);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取选中的条目
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(jf, "请选择要删除的条目！");
                    return;
                }

                //防止误操作
                int result = JOptionPane.showConfirmDialog(jf, "确认要删除选中的条目吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (result != JOptionPane.YES_OPTION) {
                    return;
                }

                //获取所选行的数据
                Integer taskID = Integer.valueOf(tableModel.getValueAt(selectedRow, 0).toString());
                Integer userStudentNumber = Integer.valueOf(tableModel.getValueAt(selectedRow, 1).toString());
                String taskContent = tableModel.getValueAt(selectedRow, 2).toString();
                String taskST = tableModel.getValueAt(selectedRow, 3).toString();
                String taskET = tableModel.getValueAt(selectedRow, 4).toString();

                SimpleDateFormat taskStartTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat taskEndTimeFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date taskStartTime = null;
                Date taskEndTime = null;
                try {
                    taskStartTime = taskStartTimeFormat.parse(taskST);
                    taskEndTime = taskEndTimeFormat.parse(taskET);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                //删除数据
                TaskVo taskVo = new TaskVo(taskID, userStudentNumber, taskContent, taskStartTime, taskEndTime);
                TaskController taskController = new TaskController();
                try {
                    taskController.deleteTask(taskVo);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                requestData();

            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        this.add(btnPanel);

        //组装表格
        String[] ts = {"任务编号", "用户学号", "任务介绍", "开始日期", "截止日期"};
        titles = new Vector<>();
        titles.addAll(Arrays.asList(ts));

        tableData = new Vector<>();
        quarryTableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData, titles);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        requestData();

    }


    public UserBookManageComponent(int axis) {
        super(axis);
    }


    //请求数据
    public void requestData(){
        //获取用户的录入
        Integer taskID = 2022005553;

        //查询数据
        TaskController taskController = new TaskController();

        List<TaskVo> data;
        try {
            data = taskController.queryAllTask(taskID);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        tableData.clear();
        for (TaskVo vo: data) {
            List<Object> row = new ArrayList<Object>();
            row.add(vo.getTaskId());
            row.add(vo.getUserStudentNumber());
            row.add(vo.getTaskContent());
            row.add(vo.getTaskStartTime());
            row.add(vo.getTaskEndTime());
            Vector<Object> rowData = new Vector<>();
            rowData.addAll(row);
            tableData.add(rowData);
        }

        // 更新表格模型
        tableModel.fireTableDataChanged();
    }


}

