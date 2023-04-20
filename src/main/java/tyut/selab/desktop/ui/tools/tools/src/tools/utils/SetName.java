package tyut.selab.desktop.ui.tools.tools.src.tools.utils;

import tools.dialogs.FileName;

/**
 * ClassName:SetName
 * Package:tools.utils
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/19 - 10:59
 * @Version:v1.0
 */
public class SetName {
    public static boolean setName(String fileName) {
        String[] split1 = fileName.split("-");
        String grade = split1[0];
        String s;
        String[] split2;
        String suffix = "";
        if (split1.length == 2) {
            s = split1[1];
            split2 = s.split("\\.");
            if (split2.length == 2) {
                suffix = split2[1];
                return true;
            }
        } else if (grade.length() != 4 || !(suffix.equals("rar") || suffix.equals("zip"))) {
            new FileName();
        }
        return false;
    }
}
