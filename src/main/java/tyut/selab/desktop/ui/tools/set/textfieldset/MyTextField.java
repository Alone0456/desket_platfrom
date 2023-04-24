package tyut.selab.desktop.ui.tools.set.textfieldset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 输入框美化设置
 */
@SuppressWarnings("all")
public class MyTextField extends JTextField implements FocusListener {
    private String defaultText;

    public MyTextField(String text) {
        super(text);
        this.defaultText = text;
        this.setForeground(Color.GRAY);
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(defaultText)) {
            this.setSelectionStart(0);
            this.setSelectionEnd(this.getText().length());
            this.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            this.setForeground(Color.GRAY);
            this.setText(defaultText);
        }
    }
}
