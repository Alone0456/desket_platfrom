package tyut.selab.desktop.ui.sharecenter;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class function {
    private ShareCenterController shareCenterController = new ShareCenterController();
    private boundary ui = new boundary();
    private String errorInformation ;
    private String saveInformation;
    private int lastIndex;



    /**
     * 通过userVo是管理员还是用户来区分界面功能(菜单栏)
     * @param userVo
     */
    public function(UserVo userVo) {
        if("用户".equals(userVo.getDuty())){
            ui.getPopupMenu().add(ui.getStackItem1());

            ui.getPopupMenu().add(ui.getAddItem());
            ui.getPopupMenu().add(ui.getOwnItem());
            ui.getPopupMenu().add(ui.getAllItem());
        }

        if("管理".equals(userVo.getDuty())){
            ui.getPopupMenu().add(ui.getStackItem2());
            ui.getPopupMenu().add(ui.getManageItem());
            ui.getPopupMenu().add(ui.getUpdateItem());
            ui.getPopupMenu().add(ui.getDeleteItem());
            ui.getPopupMenu().add(ui.getAllItem());
        }



    }

    public boundary getUi() {
        return ui;
    }

    public List<BugType> addAllType(){
        List<BugType> bugTypeList = shareCenterController.queryAllType();
        List<String> bugType = new ArrayList<String>();
        for(int i = 0; i < bugTypeList.size(); i++) {
            bugType.add(bugTypeList.get(i).getBugType());
        }
        for(int i = 0;i < bugType.size();i++) {
            JCheckBox jCheckBox = new JCheckBox(bugType.get(i));
            ui.getCheckBoxes().add(i,jCheckBox);
            ui.getOptions().add(jCheckBox);
        }
        lastIndex = ui.getCheckBoxes().size() - 1;

        return null;
    }

    public List<BugType> queryAllType() {
        //service层应给的bugType
        List<BugType> bugTypeList = shareCenterController.queryAllType();
        List<String> bugType = new ArrayList<String>();
        for(int i = 0; i < bugTypeList.size(); i++) {
            bugType.add(bugTypeList.get(i).getBugType());
        }

        ui.getStackCheck().add(ui.getOptions(), BorderLayout.NORTH);
        ui.getStackCheck().add(ui.getButtons(),BorderLayout.CENTER);
        ui.getStackCheck().setBounds(100,100,100,100);


        ui.getStackCheck().pack();
        ui.getStackCheck().setVisible(false);
        //居中
        ui.getStackCheck().setLocationRelativeTo(null);
        //不可改变大小
        ui.getStackCheck().setResizable(false);


        return null;
    }


    public List<BugVo> showBugInfo() {
        List<BugVo> bugVos = shareCenterController.showBugInfo();
        ui.getDefaultListModel().clear();
        ui.getDefaultListModel().addAll(bugVos);
//        ui.setDefaultJlist(bugVos);
        ui.setList(bugVos);

        ui.getAllItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<BugVo> bugVos = shareCenterController.showBugInfo();
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
//                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);

            }
        });
        return null;
    }

    /**
     * 用户和管理员对技术栈的筛选（一样的功能）
     * @param
     * @param jMenuItem
     */
    public void showBugInfo(JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryAllType();
                ui.getStackCheck().setVisible(true);
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getSureJButton());
                ui.getStackCheck().pack();
                /**
                 * bugType存的是用户勾选的技术栈，需传给service层。
                 */
                ui.getSureJButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<String> bugType = new Vector<>();
                        for(int i = 0;i<ui.getCheckBoxes().size();i++){
                            if(ui.getCheckBoxes().get(i).isSelected()) {
                                bugType.add(ui.getCheckBoxes().get(i).getText());
                                ui.getCheckBoxes().get(i).setSelected(false);
                            }
                        }

                        ui.getStackCheck().setVisible(false);
                        /**
                         * 将bugType传给service，获取到对应技术栈的报错信息，然后显示
                         */
                        List<BugVo> bugVos = shareCenterController.ShowBugInfo(bugType);
                        ui.getDefaultListModel().clear();
                        ui.getDefaultListModel().addAll(bugVos);
//                        ui.setDefaultJlist(bugVos);
                        ui.setList(bugVos);


                    }
                });
            }
        });
    }


    public List<BugVo> ShowBugInfo(List<String> bugType) {
        /**
         * 用户筛选
         */
        showBugInfo(ui.getStackItem1());

        /**
         * 管理员筛选
         */
        showBugInfo(ui.getStackItem2());

        /**
         * 管理员管理技术栈
         */
        ui.getManageItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.setInsertJButton(new JButton("insert"));
                ui.setDeleteJButton(new JButton("delete"));
                ui.setUpdateJButton(new JButton("update"));
                queryAllType();
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getInsertJButton());
                ui.getButtons().add(ui.getUpdateJButton());
                ui.getButtons().add(ui.getDeleteJButton());
                ui.getStackCheck().setVisible(true);
                ui.getStackCheck().pack();
                //居中
                ui.getStackCheck().setLocationRelativeTo(null);
                //不可改变大小
                ui.getStackCheck().setResizable(false);

                insertBugType(new BugType());
                delete();
                updateBugType(new BugType(),new BugType());
            }
        });

        return null;
    }


    public List<BugVo> ShowBugInfo(UserVo userVo) {
        /**
         * 用户的<我的>功能
         */
                ui.getOwnItem().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        List<BugVo> bugVos = shareCenterController.ShowBugInfo(userVo);
                        ui.getDefaultListModel().clear();
                        ui.getDefaultListModel().addAll(bugVos);
//                        ui.setDefaultJlist(bugVos);
                        ui.setList(bugVos);

                    }
                });

        /**
         * 管理员和用户通过点击用户查看用户信息功能
         */
        ui.getAdminShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = ui.getAdminShow().getText();
                User user = new UserDao().queryUserByStudentName(username);
                UserVo userVo = new UserVo(user.getStudentNumber(), user.getName(), user.getAccountNumber(),
                        user.getGender(), user.getPhone(),
                        user.getPost(), user.getRole().getDuty());
                List<BugVo> bugVos = shareCenterController.ShowBugInfo(userVo);
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
//                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);
            }
        });
        ui.getAdminShow().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ui.getAdminShow().setForeground(Color.cyan);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                ui.getAdminShow().setForeground(new Color(127,133,143));
            }
        });



        return null;
    }



    public int insertBugInfo(UserVo userVo) {
        BugVo bugVo = new BugVo();
        ui.getAddItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //选择技术栈
                List<String> bugType = bugVo.getBugType();
                queryAllType();
                ui.getStackCheck().setVisible(true);
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getSureJButton());
                ui.getStackCheck().pack();
                ui.getSureJButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i = 0;i<ui.getCheckBoxes().size();i++){
                            if(ui.getCheckBoxes().get(i).isSelected()) {
                                bugType.add(ui.getCheckBoxes().get(i).getText());

                                ui.getCheckBoxes().get(i).setSelected(false);
                            }
                        }

                        ui.getStackCheck().setVisible(false);

                        bugVo.setBugType(bugType);

                        //报错信息
                        inputMessageFrame add_error = new inputMessageFrame("add error","请输入内容");
                        add_error.getjButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                if(add_error.getJta().getText().equals("请输入内容") || add_error.getJta().getText().length() ==0){
                                    JOptionPane.showMessageDialog(ui.getHomeJPanel(),"报错信息标题不能为空","error",0);
                                    return;
                                }
                                bugVo.setBugTitle(add_error.getJta().getText());
                                inputMessageFrame add_save = new inputMessageFrame("add save","请输入内容");
                                add_error.getFrame().setVisible(false);
                                add_save.getjButton().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        bugVo.setBugSolve(add_save.getJta().getText());
                                        add_save.getFrame().setVisible(false);
                                        bugVo.setUserVo(userVo);
                                        bugVo.setReleaseTime(new Date());


                                        shareCenterController.insertBugInfo(bugVo);


                                        List<BugVo> bugVos = shareCenterController.showBugInfo();
                                        ui.getDefaultListModel().clear();
                                        ui.getDefaultListModel().addAll(bugVos);
//                                        ui.setDefaultJlist(bugVos);
                                        ui.setList(bugVos);

                                    }
                                });
                            }
                        });

                    }
                });

            }

        });


        return 0;
    }


    public int updateBugInfo(UserVo userVo) {

        ui.getUpdateItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = ui.getDefaultListModel().get(ui.getBugVoJList().getSelectedIndex());
                BugVo oldBugVo = (BugVo) o;
                BugVo newBugVo = new BugVo();
                //选择技术栈
                List<String> bugType = newBugVo.getBugType();
                queryAllType();
                ui.getStackCheck().setVisible(true);
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getSureJButton());
                ui.getStackCheck().pack();
                ui.getSureJButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i = 0;i<ui.getCheckBoxes().size();i++){
                            if(ui.getCheckBoxes().get(i).isSelected()) {
                                bugType.add(ui.getCheckBoxes().get(i).getText());
                                ui.getCheckBoxes().get(i).setSelected(false);
                            }
                        }
                        ui.getStackCheck().setVisible(false);
                        newBugVo.setBugType(bugType);
                        //报错信息
                        inputMessageFrame add_error = new inputMessageFrame("add error",oldBugVo.getBugTitle());
                        add_error.getjButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                newBugVo.setBugTitle(add_error.getJta().getText());

                                inputMessageFrame add_save = new inputMessageFrame("add save",oldBugVo.getBugSolve());
                                add_error.getFrame().setVisible(false);
                                add_save.getjButton().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        newBugVo.setBugSolve(add_save.getJta().getText());
                                        add_save.getFrame().setVisible(false);
                                        newBugVo.setUserVo(userVo);
                                        newBugVo.setReleaseTime(new Date());


                                        shareCenterController.updateBugInfo(newBugVo,oldBugVo);


                                        List<BugVo> bugVos = shareCenterController.showBugInfo();
                                        ui.getDefaultListModel().clear();
                                        ui.getDefaultListModel().addAll(bugVos);
//                                        ui.setDefaultJlist(bugVos);
                                        ui.setList(bugVos);

                                    }
                                });
                            }
                        });

                    }
                });

            }

        });
        return 0;
    }


    public int deleteBugInfo() {


        ui.getDeleteItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object o = ui.getDefaultListModel().get(ui.getBugVoJList().getSelectedIndex());

                shareCenterController.deleteBugInfo((BugVo) o);
                List<BugVo> bugVos = shareCenterController.showBugInfo();
                System.out.println(bugVos);
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
//                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);
            }
        });

        return 0;
    }


    public int insertBugType(BugType bugType) {
        /**
         * 处理增
         */
        ui.getInsertJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i<ui.getCheckBoxes().size();i++){
                    System.out.println(ui.getCheckBoxes().get(i).getText());
                }

                String insertInput = JOptionPane.showInputDialog(ui.getStackCheck(), "请输入你想添加的技术栈", "insert stack", JOptionPane.INFORMATION_MESSAGE);
                if(insertInput.length() > 0 && insertInput != null) {
                    if(ui.getCheckBoxes().size() == lastIndex + 1){
                        JCheckBox insertJCheckBox = new JCheckBox(insertInput);
                        ui.getCheckBoxes().add(insertJCheckBox);
                        lastIndex++;
                        ui.getOptions().add(insertJCheckBox);

                    }else{
                        JCheckBox insertJCheckBox = new JCheckBox(insertInput);
                        ui.getCheckBoxes().set(lastIndex,insertJCheckBox);
                        lastIndex++;
                        ui.getOptions().add(insertJCheckBox);
                    }

                    ui.getStackCheck().pack();
                    //居中
                    ui.getStackCheck().setLocationRelativeTo(null);
                    bugType.setBugType(insertInput);
                    shareCenterController.insertBugType(bugType);
                }


            }
        });
        return 0;
    }


    public int updateBugType(BugType newBugType, BugType oldBugType) {
        ui.getUpdateJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i<ui.getCheckBoxes().size();i++){
                    if(ui.getCheckBoxes().get(i).isSelected()) {
                        oldBugType.setBugType(ui.getCheckBoxes().get(i).getText());
                        String addInput1 = JOptionPane.showInputDialog(ui.getHomeJPanel(), "请输入你想更新的技术栈", "update message", JOptionPane.INFORMATION_MESSAGE);
                        if(addInput1 != null){
                            newBugType.setBugType(addInput1);
                            ui.getCheckBoxes().get(i).setText(addInput1);

                            ui.getStackCheck().pack();
                            //居中
                            ui.getStackCheck().setLocationRelativeTo(null);
                            return;
                        }
                    }

                }
                shareCenterController.updateBugType(newBugType, oldBugType);
            }
        });
        return 0;
    }


    public int delete() {
        ui.getDeleteJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i = 0;i<ui.getCheckBoxes().size();i++){
                    if(ui.getCheckBoxes().get(i).isSelected()) {
                        System.out.println(i+"selected");
                        BugType bugType1 = new BugType();
                        bugType1.setBugType(ui.getCheckBoxes().get(i).getText());
                        shareCenterController.delete(bugType1);
                        ui.getOptions().remove(i);
                        ui.getCheckBoxes().remove(i);
                        lastIndex--;


                    }
                }
                ui.getStackCheck().setVisible(false);

                ui.getStackCheck().setVisible(true);
                ui.getStackCheck().pack();
                //居中
                ui.getStackCheck().setLocationRelativeTo(null);

            }
        });
        return 0;
    }
}