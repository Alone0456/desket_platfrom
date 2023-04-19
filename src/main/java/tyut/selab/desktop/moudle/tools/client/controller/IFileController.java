package tyut.selab.desktop.moudle.tools.client.controller;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;

import java.util.List;

public interface IFileController {
    int fileDown(FileUpVo fileUpVo,String localFilePath);

    int fileUpLoading(FileUpVo fileUpVo,String localFilePath);

    List<FileUp> queryAllFileUpInfo();

    List<FileUp> queryFileUpByUser(User user) ;
}
