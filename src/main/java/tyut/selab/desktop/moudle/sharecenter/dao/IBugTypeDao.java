package tyut.selab.desktop.moudle.sharecenter.dao;

import tyut.selab.desktop.moudle.sharecenter.domain.BugType;

import java.sql.SQLException;
import java.util.List;

public interface IBugTypeDao {
     /**
      * 查询所有类型
      * @return
      */
     List<BugType> queryAllType() throws Exception;

     int insertBugType(BugType bugType) throws SQLException;

     int updateBugType(BugType newBugType,BugType oldBugType) throws SQLException;

     int delete(BugType bugType) throws SQLException;
}