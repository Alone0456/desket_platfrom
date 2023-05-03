package tyut.selab.desktop.ui.todolist.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.Timer;

public class AlarmClock extends JFrame implements ActionListener {
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JButton setButton;
    private Timer timer;
    private DateFormat dateFormat;
    private DateFormat timeFormat;

    public AlarmClock() {
        setTitle("Alarm Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel dateLabel = new JLabel("Date (年/月/日):");
        dateTextField = new JTextField();
        JLabel timeLabel = new JLabel("Time (时:分)");
        timeTextField = new JTextField();
        setButton = new JButton("Set Alarm");
        setButton.addActionListener(this);

        panel.add(dateLabel);
        panel.add(dateTextField);
        panel.add(timeLabel);
        panel.add(timeTextField);
        panel.add(new JLabel());
        panel.add(setButton);

        add(panel, BorderLayout.CENTER);

        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        timeFormat = new SimpleDateFormat("hh:mm");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setButton) {
            try {
                String dateStr = dateTextField.getText();
                String timeStr = timeTextField.getText();

                Date date = dateFormat.parse(dateStr);
                Date time = timeFormat.parse(timeStr);
                Date alarm = new Date(date.getYear(), date.getMonth(), date.getDate(),
                        time.getHours(), time.getMinutes(), time.getSeconds());

                Date now = new Date();
                long delay = alarm.getTime() - now.getTime();
                if (delay < 0) {
                    JOptionPane.showMessageDialog(this, "非法日期，请重新输入");
                    return;
                }

                if (timer != null) {
                    timer.cancel();
                }
                timer = new Timer();
                timer.schedule(new AlarmTask(), delay);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "非法日期，请重新输入");
            }
        }
    }

    private class AlarmTask extends TimerTask {
        public void run() {
            JOptionPane.showMessageDialog(AlarmClock.this, "时间到");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AlarmClock().setVisible(true);
            }
        });
    }
}

