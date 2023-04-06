package tyut.selab.desktop.moudle.tools.client.controller;

import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;

public interface IFileController {
    int fileDown(FileUpVo fileUpVo);

    int fileUpLoading(FileUpVo fileUpVo);
}
