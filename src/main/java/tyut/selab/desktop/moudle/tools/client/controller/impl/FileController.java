package tyut.selab.desktop.moudle.tools.client.controller.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.controller.IFileController;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;

import java.util.List;

public class FileController implements IFileController {
    private IFileUpService iFileUpService;

    @Override
    public int fileDown(FileUpVo fileUpVo, String localFilePath) {
        return 0;
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo, String localFilePath) {
        return 0;
    }

    @Override
    public List<FileUp> queryAllFileUpInfo() {
        return null;
    }

    @Override
    public List<FileUp> queryFileUpByUser(User user) {
        return null;
    }
}
