package tyut.selab.desktop.ui.login;

import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            //界面渲染效果
            try {
                UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel");
                new LoginDemo();
            } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                JOptionPane.showMessageDialog(null, "系统异常", "你个老六", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}