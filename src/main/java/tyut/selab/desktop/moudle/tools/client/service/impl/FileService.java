package tyut.selab.desktop.moudle.tools.client.service.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;

import java.util.List;

public class FileService implements IFileUpService {
    private IUserDao userDao;

    private IUpFileDao upFileDao;
    @Override
    public int fileDown(FileUpVo fileUpVo) {
        return 0;
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo) {
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
