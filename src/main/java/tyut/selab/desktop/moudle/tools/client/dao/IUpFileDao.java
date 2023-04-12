package tyut.selab.desktop.moudle.tools.client.dao;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;

import java.util.List;

public interface IUpFileDao {
    List<FileUp> queryAllFileUpInfo();

    List<FileUp> queryFileUpByUser(User user);

    int insertFileUp(FileUp fileUp);
}
