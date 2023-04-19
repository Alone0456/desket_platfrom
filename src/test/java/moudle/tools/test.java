package moudle.tools;

import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        UpFileDao fileDao = new UpFileDao();
        fileDao.queryAllFileUpInfo();
    }
}
