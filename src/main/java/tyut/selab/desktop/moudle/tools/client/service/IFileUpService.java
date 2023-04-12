package tyut.selab.desktop.moudle.tools.client.service;

import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;

public interface IFileUpService {
    int fileDown(FileUpVo fileUpVo);

    int fileUpLoading(FileUpVo fileUpVo);
}
