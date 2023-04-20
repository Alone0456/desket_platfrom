package tyut.selab.desktop.ui.tools.tools.src.test.test1;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * ClassName:test5
 * Package:test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 20:34
 * @Version:v1.0
 */

public class Focus implements FocusListener {
    myWindow view;
    public void setView(myWindow view) {
        this.view = view;
    }
    @Override
    public void focusGained(FocusEvent focusEvent) {    //获取焦点时
        if (focusEvent.getSource() == view.jTextField){
            view.jTextField.setBackground(new Color(0x674553));
        }

    }
    @Override
    public void focusLost(FocusEvent focusEvent) {  //失去焦点时
        if (focusEvent.getSource() != view.jTextField){
            view.jTextField.setBackground(new Color(0xFFFFFF));
        }

    }
}

