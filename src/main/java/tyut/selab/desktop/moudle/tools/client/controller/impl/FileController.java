package tyut.selab.desktop.moudle.tools.client.controller.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.controller.IFileController;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;
import tyut.selab.desktop.moudle.tools.client.service.impl.FileService;

import java.util.List;

public class FileController implements IFileController {
    private IFileUpService iFileUpService = new FileService();

    @Override
    public int fileDown(FileUpVo fileUpVo, String localFilePath) {
        return iFileUpService.fileDown(fileUpVo,localFilePath);
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo, String localFilePath) {
        return iFileUpService.fileUpLoading(fileUpVo,localFilePath);
    }

    @Override
    public List<FileUp> queryAllFileUpInfo() {
        return iFileUpService.queryAllFileUpInfo();
    }

    @Override
    public List<FileUp> queryFileUpByUser(User user) {
        return iFileUpService.queryFileUpByUser(user);
    }
}
