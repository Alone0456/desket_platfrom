package tyut.selab.desktop.ui.tools.tools.src.tools.utils;

import tools.dropdownbox.Managers;
import tools.dropdownbox.Weeks;
import tools.jtextfield.NameText;

/**
 * ClassName:GetServerPath
 * Package:tools.utils.getpath
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 19:53
 * @Version:v1.0
 */
public class GetServerPath {
    public static String getPathByManager() {
        String path = "home/fengyang/" + Managers.managerName + "/" + Weeks.week + "/" + "任务";
        return path;
    }

    public static String getPathByUser() {
        String path = "home/fengyang/" + Managers.managerName + "/" + Weeks.week + "/" + "提交";
        return path;
    }

    public static String getWeek() {
        return Weeks.week;
    }

    public static String getUserName() {
        return NameText.name;
    }
    public static void resetpath() {
        Managers.managerName=null;
        Weeks.week=null;
    }
}
