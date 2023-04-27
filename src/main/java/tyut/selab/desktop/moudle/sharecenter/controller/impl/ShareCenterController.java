package tyut.selab.desktop.moudle.sharecenter.controller.impl;


import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.sharecenter.inputMessageFrame;
import tyut.selab.desktop.ui.sharecenter.showMessageFrame;
import tyut.selab.desktop.moudle.sharecenter.controller.IShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.ui.sharecenter.boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ShareCenterController implements IShareCenterController {

    private IShareCenterService shareCenterService = new ShareCenterService();
    private boundary ui = new boundary();
    private String errorInformation ;
    private String saveInformation;
    private int lastIndex;



    /**
     * 通过userVo是管理员还是用户来区分界面功能(菜单栏)
     * @param userVo
     */
    public ShareCenterController(UserVo userVo) {
         if("用户".equals(userVo.getDuty())){
             ui.getPopupMenu().add(ui.getStackItem1());

             ui.getPopupMenu().add(ui.getAddItem());
             ui.getPopupMenu().add(ui.getOwnItem());
             ui.getPopupMenu().add(ui.getAllItem());
         }

        if("管理员".equals(userVo.getDuty())){
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

    public List<BugType>  addAllType(){
        List<BugType> bugTypeList = shareCenterService.queryAllType();
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
    @Override
    public List<BugType> queryAllType() {
        //service层应给的bugType
        List<BugType> bugTypeList = shareCenterService.queryAllType();
        List<String> bugType = new ArrayList<String>();
        for(int i = 0; i < bugTypeList.size(); i++) {
            bugType.add(bugTypeList.get(i).getBugType());
        }
//        ShowBugInfo(bugType);


        ui.getStackCheck().add(ui.getOptions(),BorderLayout.NORTH);
        ui.getStackCheck().add(ui.getButtons(),BorderLayout.CENTER);
        ui.getStackCheck().setBounds(100,100,100,100);

//        ui.getOptions().removeAll();
        ui.getStackCheck().pack();
        ui.getStackCheck().setVisible(false);
        //居中
        ui.getStackCheck().setLocationRelativeTo(null);
        //不可改变大小
        ui.getStackCheck().setResizable(false);

        System.out.println(ui.getCheckBoxes().size());

        return null;
    }

    @Override
    public List<BugVo> showBugInfo() {
        List<BugVo> bugVos = shareCenterService.showBugInfo();
        System.out.println(bugVos);
        ui.getDefaultListModel().clear();
        ui.getDefaultListModel().addAll(bugVos);
//        ui.setDefaultJlist(bugVos);
        ui.setList(bugVos);

        ui.getAllItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
//                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);
                new showMessageFrame("已更新数据");
            }
        });
        return null;
    }

    /**
     * 用户和管理员对技术栈的筛选（一样的功能）
     * @param bugType
     * @param jMenuItem
     */
    public void showBugInfo(List<String> bugType,JMenuItem jMenuItem) {
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
                        List<BugVo> bugVos = shareCenterService.ShowBugInfo(bugType);
                        ui.getDefaultListModel().clear();
                        ui.getDefaultListModel().addAll(bugVos);
//                        ui.setDefaultJlist(bugVos);
                        ui.setList(bugVos);
                        new showMessageFrame("已更新数据");
                        System.out.println("筛选后我的"+bugVos);
                    }
                });
            }
        });
    }

    @Override
    public List<BugVo> ShowBugInfo(List<String> bugType) {
        /**
         * 用户筛选
         */
        showBugInfo(bugType,ui.getStackItem1());

        /**
         * 管理员筛选
         */
        showBugInfo(bugType,ui.getStackItem2());

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
                delete(new BugType());
                updateBugType(new BugType(),new BugType());
            }
        });

        return null;
    }

    @Override
    public List<BugVo> ShowBugInfo(UserVo userVo) {
        /**
         * 用户的<我的>功能
         */
//                ui.getOwnItem().addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        String username = userVo.getName();
//                        List<BugVo> bugVos = new ShareCenterService().showBugInfo();
//                        ui.getDefaultListModel().clear();
//                        ui.getDefaultListModel().addAll(bugVos);
//                        ui.setDefaultJlist(bugVos);
//                        ui.setList(bugVos);
//
//                    }
//                });

        /**
         * 管理员和用户通过点击用户查看用户信息功能
         */
        ui.getAdminShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String s = ui.getAdminShow().getText();
               System.out.println(s);
               //shareCenterService.showBugInfo(user);
            }
        });
        ui.getAdminShow().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ui.getAdminShow().setForeground(Color.cyan);
//                ui.getAdminShow().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ui.getAdminShow().setForeground(Color.BLACK);
            }
        });



        return null;
    }


    @Override
    public int insertBugInfo(BugVo bugVo) {

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
                        inputMessageFrame add_error = new inputMessageFrame("add error");
                        add_error.getjButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                bugVo.setBugTitle(add_error.getJta().getText());
                                inputMessageFrame add_save = new inputMessageFrame("add save");
                                add_error.getFrame().setVisible(false);
                                add_save.getjButton().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        bugVo.setBugSolve(add_save.getJta().getText());
                                        add_save.getFrame().setVisible(false);
                                        bugVo.setUserVo(new UserVo(1,"wzy","wzy",1,"153426844884","w","用户"));
                                        bugVo.setReleaseTime(new Date());

                                        List<BugVo> bugVos = shareCenterService.showBugInfo();
                                        shareCenterService.insertBugInfo(bugVo);

                                        List<BugMessage> bugMessages = null;
                                        try {
                                            bugMessages = new ShareCenterDao().queryAllBugInfo();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                        bugVos = shareCenterService.showBugInfo();
                                        ui.getDefaultListModel().clear();
                                        ui.getDefaultListModel().addAll(bugVos);
//                                        ui.setDefaultJlist(bugVos);
                                        ui.setList(bugVos);
                                        new showMessageFrame("已更新数据");
                                        System.out.println(bugVos);
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

    @Override
    public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {

        return 0;
    }

    @Override
    public int deleteBugInfo(BugVo bugVo) {
        int selectedIndex;
        selectedIndex = ui.getBugVoJList().getSelectedIndex();

        ui.getDeleteItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("selectedIndex: " + selectedIndex);
                Object o = ui.getDefaultListModel().get(selectedIndex);
                shareCenterService.deleteBugInfo((BugVo) o);
                List<BugVo> bugVos = shareCenterService.showBugInfo();
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
//                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);
            }
        });

        return 0;
    }

    @Override
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
                    shareCenterService.insertBugType(bugType);
                }


            }
        });
        return 0;
    }

    @Override
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
                shareCenterService.updateBugType(newBugType, oldBugType);
            }
        });
        return 0;
    }

    @Override
    public int delete(BugType bugType) {
        ui.getDeleteJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("删除前长度"+ui.getCheckBoxes().size());
                for(int i = 0;i<ui.getCheckBoxes().size();i++){
                    if(ui.getCheckBoxes().get(i).isSelected()) {
                        System.out.println(i+"selected");
                        BugType bugType1 = new BugType();
                        bugType1.setBugType(ui.getCheckBoxes().get(i).getText());
                        shareCenterService.delete(bugType1);
                        ui.getOptions().remove(i);
                        ui.getCheckBoxes().remove(i);
                        lastIndex--;


                    }
                }
                ui.getStackCheck().setVisible(false);
                System.out.println("删除后长度"+ui.getCheckBoxes().size());
               /* for(int i = 0;i<deleteList.size();i++){
                    ui.getOptions().remove(ui.getCheckBoxes().get(deleteList.get(i)));
                }*/
                ui.getStackCheck().setVisible(true);
                ui.getStackCheck().pack();
                //居中
                ui.getStackCheck().setLocationRelativeTo(null);

            }
        });
        return 0;
    }
}