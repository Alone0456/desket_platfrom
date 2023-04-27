package tyut.selab.desktop.ui.tools.utils;

import tyut.selab.desktop.ui.tools.component.dropdownbox.Managers;
import tyut.selab.desktop.ui.tools.component.dropdownbox.Weeks;


/**
 * ClassName:GetServerPath
 * Package:tools.utils.getpath
 * Description:
 * 获取选择的服务器路径
<<<<<<< HEAD
 *
=======
>>>>>>> baizerong
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 19:53
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class GetServerPath {
    public static String getPathByManager() {

        String path = "/home/fengyang/week/" + Managers.managerName + "/" + Weeks.week + "/" + "任务"+"/";
        return path;
    }

    public static String getPathByUser() {

        String path = "/home/fengyang/week/" + Managers.managerName + "/" + Weeks.week + "/" + "提交"+"/";
        return path;
    }

    public static String getWeek() {
        return Weeks.week;
    }


    public static String getManagerName() {
        return Managers.managerName;
    }

    public static void resetpath() {
        Managers.managerName = null;
        Weeks.week = null;
    }
}
