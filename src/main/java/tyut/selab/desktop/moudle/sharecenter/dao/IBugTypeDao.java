package tyut.selab.desktop.moudle.sharecenter.dao;

import tyut.selab.desktop.moudle.sharecenter.domain.BugType;

import java.util.List;

public interface IBugTypeDao {
     /**
      * 查询所有类型
      * @return
      */
     List<BugType> queryAllType();

     int insertBugType(BugType bugType);

     int updateBugType(BugType newBugType,BugType oldBugType);

     int delete(BugType bugType);
}
