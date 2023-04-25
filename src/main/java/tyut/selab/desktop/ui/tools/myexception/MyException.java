package tyut.selab.desktop.ui.tools.myexception;

/**
 * ClassName:MyException
 * Package:tools.myexception
 * Description:
 * 自定义异常
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 20:39
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class MyException extends Exception {
    public MyException(){

    }

    public MyException(String message){
        super(message);
    }
}
