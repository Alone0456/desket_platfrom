package tyut.selab.desktop.ui.tools.utils;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.tools.component.dialogs.FileName;

/**
 * ClassName:SetName
 * Package:tools.utils
 * Description:
 * 文件命名规范提示弹窗
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/19 - 10:59
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class SetName {
    public static boolean setName(String fileName) {
        User user = FileChooser.fileUpVo.getUser();
<<<<<<< HEAD
        user.setStudentNumber(2022005565);
        user.setName("");
        String studentNumber ="";
        studentNumber= String.valueOf(user.getStudentNumber().intValue());
        String stdentName = user.getName();
=======
        String studentNumber = String.valueOf(user.getStudentNumber().intValue());
        String stdentName = user.getName();

>>>>>>> baizerong
        String[] split1 = fileName.split("-");
        String number = split1[0];
        String temp;
        String[] split2;
        String name;
        if (split1.length == 2) {
            temp = split1[1];
            split2 = temp.split("\\.");
            if (split2.length == 2) {
                name = split2[0];
                if(number.equals(studentNumber)&&name.equals(stdentName)){
                    return true;
<<<<<<< HEAD
                }
=======
                }else {
                    new FileName();
                }
            }else {
                new FileName();
>>>>>>> baizerong
            }
        }else {
            new FileName();
        }
        return false;
    }
}
