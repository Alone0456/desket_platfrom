package tyut.selab.desktop.moudle.tools.client.service;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;

public interface IFileUpService {
    int fileDown(UserVo userVo,String userUpFilePath, String localFilePath);

    int fileUpLoading(UserVo userVo,String userUpFilePath, String localFilePath);
}
