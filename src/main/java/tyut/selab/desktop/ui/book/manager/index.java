package tyut.selab.desktop.ui.book.manager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import tyut.selab.desktop.ui.book.user.SystemOrdinaryUsers;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class index {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {

                    JFrame jFrame = new JFrame();
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int sw = screenSize.width;
                    int sh = screenSize.height;
                    int width = 1300;
                    int height = 800;
                    jFrame.setBounds((sw - width) / 2, (sh - height) / 2, width, height);
                    jFrame.setTitle("主界面");
                    SystemOrdinaryUsers systemAdministration = new SystemOrdinaryUsers();
//        SystemAdministration systemAdministration = new SystemAdministration();
                    jFrame.add(systemAdministration);
                    jFrame.setVisible(true);
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            }



}
