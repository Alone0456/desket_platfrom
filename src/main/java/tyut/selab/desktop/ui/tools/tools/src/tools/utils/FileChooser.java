package tyut.selab.desktop.ui.tools.tools.src.tools.utils;

import tools.dialogs.FileName;
import tools.myexception.MyException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * ClassName:FileChooser
 * Package:tools.filechooser
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:16
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class FileChooser {
    public static String path = "";
    public static String fileName;
    public static String allPath;

    public static void openFileChooser(String name) {
        JFileChooser jf = new JFileChooser();
        //只能选文件
        if (name.equals("上传周报") || name.equals("上传任务")) {
            jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //设置默认的文件过滤选择器为压缩包
            FileFilter filter = new FileNameExtensionFilter("压缩包(.zip .rar)", "zip", "rar");
            jf.setFileFilter(filter);
        }
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
            allPath = GetServerPath.getPathByUser() + "/" + fileName;
        }
        //点击确定后发生事件
        if (result == JFileChooser.APPROVE_OPTION) {
            // TODO: 2023/04/19 将服务器路径和本地路径一并传给后台
            if (name.equals("上传任务")) {
                //设置文件命名规范
                if (SetName.setName(fileName)) {
                    // TODO: 2023/04/19 传给后台
                    System.out.println(path);
                    System.out.println(GetServerPath.getPathByManager());
                    GetServerPath.resetpath();
                }
            }
            if (name.equals("上传周报")) {
                //设置文件命名规范
                if (SetName.setName(fileName)) {
                    // TODO: 2023/04/19 传给后台
                    System.out.println(path);
                    System.out.println(GetServerPath.getPathByUser());
                    GetServerPath.resetpath();
                    // TODO: 2023/04/19 传输完整路径给数据库
                    System.out.println(allPath);
                    // TODO: 2023/04/19 传输周数给数据库

                    // TODO: 2023/04/19 数据库在此处记录信息

                }
            }
            if (name.equals("存放任务")) {
                // TODO: 2023/04/19 传给后台
                System.out.println(path);
                System.out.println(GetServerPath.getPathByManager());
                GetServerPath.resetpath();
            }
            if (name.equals("存放周报")) {
                // TODO: 2023/04/19 传输周数、用户名和服务器路径给后台
                System.out.println(path);
                System.out.println(GetServerPath.getWeek());
                System.out.println(GetServerPath.getUserName());
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

