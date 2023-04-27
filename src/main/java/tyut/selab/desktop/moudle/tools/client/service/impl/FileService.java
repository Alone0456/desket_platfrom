package tyut.selab.desktop.moudle.tools.client.service.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

public class FileService implements IFileUpService {

    private IUserDao userDao = new UserDao();

    private IUpFileDao upFileDao = new UpFileDao();

    @Override
    public int fileDown(UserVo user, String userUpFilePath, String localFilePath) {
        return 1;
    }


    @Override
    public int fileUpLoading(UserVo userVo,String userUpFilePath, String localFilePath) {
        FileUp fileUp = new FileUp();
        DataInputStream dataInputStream = null;
        DataOutputStream filePathOutStream = null;
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        byte[] bytes = new byte[1024];

        try {
            Socket socket = new Socket("192.168.1.134",45617);
            outputStream = socket.getOutputStream();

            dataInputStream = new DataInputStream(socket.getInputStream());
            filePathOutStream = new DataOutputStream(outputStream);
            filePathOutStream.writeUTF(userUpFilePath);
            filePathOutStream.flush();

            fileInputStream = new FileInputStream(localFilePath);
            int len = 0;
            while ( (len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0, len);
            }
            outputStream.flush();

            fileInputStream.close();
            filePathOutStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileUp.setUpFilePath(userUpFilePath);
        User userLog = new User();
        userLog.setStudentNumber(userVo.getStudentNumber());
        fileUp.setUser(userLog);
        fileUp.setUpTime(new Timestamp(new Date().getTime()));

        try {
            fileUp.setUpIp(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        upFileDao.insertFileUp(fileUp);

        return 1;
    }
}
