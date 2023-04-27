package tyut.selab.desktop.ui.tools.utils;

import tyut.selab.desktop.moudle.tools.client.controller.impl.FileController;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.ui.tools.component.dialogs.Achieve;
import tyut.selab.desktop.ui.tools.component.dropdownbox.Weeks;
import tyut.selab.desktop.ui.tools.myexception.MyException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.InetAddress;

/**
 * ClassName:FileChooser
 * Package:tools.filechooser
 * Description:
 * 文件选择器以及重要的逻辑判断
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:16
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class FileChooser {
    public static String path = "";
    public static String fileName;
<<<<<<< HEAD
    public static String allPath;
=======
    public static String userAllPath;
    public static String managerAllPath;
>>>>>>> baizerong
    public static FileController fileController = new FileController();
    public static FileUpVo fileUpVo = new FileUpVo();
    public static FileUp fileUp = new FileUp();
    public static String ip;

    public static void openFileChooser(String name) {
        JFileChooser jf = new JFileChooser();
        //只能选文件
        if (name.equals("上传周报") || name.equals("上传任务")) {
            jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //设置默认的文件过滤选择器为压缩包
            FileFilter filter = new FileNameExtensionFilter("压缩包(.zip )", "zip");
            jf.setFileFilter(filter);
        }
<<<<<<< HEAD
=======
        //只能选文件夹
>>>>>>> baizerong
        if (name.equals("存放周报") || name.equals("存放任务")) {
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        //设置选择模式
        jf.setMultiSelectionEnabled(false);
        //打开文件选择器对话框
        int result = jf.showDialog(null, name);
        //获取选择的文件路径
        File file = jf.getSelectedFile();
        if (file != null) {
            path = file.getAbsolutePath();
        }
        //获取本地文件名
        if (name.equals("上传周报") || name.equals("上传任务")) {
            String temp[] = path.split("\\\\");
            if (temp.length > 1) {
                fileName = temp[temp.length - 1];
            }
<<<<<<< HEAD
            allPath = GetServerPath.getPathByUser() + "/" + fileName;
=======
            userAllPath = GetServerPath.getPathByUser() + fileName;
            managerAllPath = GetServerPath.getPathByManager() + fileName;
>>>>>>> baizerong
        }
        //获取本地ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            try {
                throw new MyException("获取本地ip地址失败");
            } catch (MyException ex) {
                ex.printStackTrace();
            }
        }
        ip = addr.getHostAddress();
        //点击确定后发生事件
        if (result == JFileChooser.APPROVE_OPTION) {
<<<<<<< HEAD
=======
            //用户上传
>>>>>>> baizerong
            if (name.equals("上传任务")) {
                //设置文件命名规范
                if (SetName.setName(fileName)) {
                    //  传给后台上传路径和本地路径
<<<<<<< HEAD
                    fileUpVo.setUpFilePath(GetServerPath.getPathByManager());
=======
                    fileUpVo.setUpFilePath(managerAllPath);
>>>>>>> baizerong
                    int i = fileController.fileUpLoading(fileUpVo, path);
                    //上传成功与否的提示弹窗
                    if (i > 0) {
                        new Achieve("上传成功");
                    } else {
                        new Achieve("上传失败");
                    }
                    GetServerPath.resetpath();
                }
            }
<<<<<<< HEAD
=======
            //管理员上传
>>>>>>> baizerong
            if (name.equals("上传周报")) {
                //设置文件命名规范
                if (SetName.setName(fileName)) {
                    //传输给后台
<<<<<<< HEAD
                    fileUpVo.setUpFilePath(GetServerPath.getPathByUser());
=======
                    fileUpVo.setUpFilePath(userAllPath);
>>>>>>> baizerong
                    int i = fileController.fileUpLoading(fileUpVo, path);
                    //上传成功与否的提示弹窗
                    if (i > 0) {
                        new Achieve("上传成功");
<<<<<<< HEAD
=======
                        //传输给数据库
                        fileUp.setUpIp(ip);
                        fileUp.setWeek(Weeks.week);
                        fileUp.setUpTime(WeekNumber.date);
                        fileUp.setUpFilePath(userAllPath);
                        fileController.insertFileUp(fileUp);
>>>>>>> baizerong
                    } else {
                        new Achieve("上传失败");
                    }
                    GetServerPath.resetpath();
<<<<<<< HEAD
                    //传输给数据库
                    fileUp.setUpIp(ip);
                    fileUp.setWeek(Weeks.week);
                    fileUp.setUpTime(WeekNumber.date);
                    fileUp.setUpFilePath(allPath);
                    fileController.insertFileUp(fileUp);
                }
            }
=======

                }
            }
            //用户下载
>>>>>>> baizerong
            if (name.equals("存放任务")) {
                // 传输本地路径给后台
                int i = fileController.fileDown(fileUpVo, path);
                //下载成功与否的提示弹窗
                if (i > 0) {
                    new Achieve("下载成功");
                } else {
                    new Achieve("下载失败");
                }
                GetServerPath.resetpath();
            }
<<<<<<< HEAD
=======
            //管理员下载
>>>>>>> baizerong
            if (name.equals("存放周报")) {
                int i = fileController.fileDown(fileUpVo, path);
                //下载成功与否的提示弹窗
                if (i > 0) {
                    new Achieve("下载成功");
                } else {
                    new Achieve("下载失败");
                }
                GetServerPath.resetpath();
            }
        }
        //点击取消或者发生异常
        if (result == JFileChooser.CANCEL_OPTION || result == JFileChooser.ERROR_OPTION) {
            try {
                throw new MyException("未选择文件");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

}

