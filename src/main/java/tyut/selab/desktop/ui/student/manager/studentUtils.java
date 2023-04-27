package tyut.selab.desktop.ui.student.manager;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;

public class studentUtils {

    //判断输入是否全为数字
    public static boolean isNumber(JTextField textField){
        String content=textField.getText();
        for (int i=0;i<content.length();i++){
            if(!Character.isDigit(content.charAt(i))){
                JOptionPane.showMessageDialog(null,"输入格式有误");
                return false;
            }
        }
        return true;
    }

    //判断文本框是否为空
    public static boolean isNotNull(JTextField textField){
        String content=textField.getText();
        if("".equals(content)||"".equals(content.trim())){
            JOptionPane.showMessageDialog(null,"请将信息填写完整");
            return false;
        }else{
            return true;
        }
    }

    //判断是否查到该用户
    public static boolean isSelect(UserVo user){
        if(user==null){
            JOptionPane.showMessageDialog(null,"找不到该用户");
            return false;
        }else{
            return true;
        }
    }

    //判断添加是否成功
    public static boolean isSuccess(int number) {
        if(number!=1){
            return false;
        }else{
            return true;
        }
    }
}
