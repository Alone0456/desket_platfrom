package tyut.selab.desktop.moudle.tools.client.controller.impl;

import tyut.selab.desktop.moudle.tools.client.controller.IFileController;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;

public class FileController implements IFileController {
    private IFileUpService iFileUpService;
    @Override
    public int fileDown(FileUpVo fileUpVo) {
        return 0;
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo) {
        return 0;
    }
}
