package tyut.selab.desktop.moudle.tools.client.service;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;

import java.util.List;

public interface IFileUpService {
    public int fileDown(FileUpVo fileUpVo,String localFilePath);

    public int fileUpLoading(FileUpVo fileUpVo,String localFilePath);

    List<FileUp> queryAllFileUpInfo();

    List<FileUp> queryFileUpByUser(User user) ;
    int insertFileUp(FileUp fileUp);
}
