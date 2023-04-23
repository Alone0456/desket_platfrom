package tyut.selab.desktop.moudle.tools.client.service.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.tools.client.dao.impl.GetMangerName;
import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;
import tyut.selab.desktop.ui.tools.utils.GetServerPath;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class FileService implements IFileUpService {
    private IUserDao userDao;            //  学生类的Dao层接口

    private IUpFileDao upFileDao;         //  周报管理系统的Dao

    private final int port = 45617;

    @Override
    public int fileDown(FileUpVo fileUpVo, String localFLiePath) {

        String userName;            //  2234-袁晓晶.zip  袁晓晶
        String week;                //  第一周  (或次数(第一次))
        String sendMessage;
        week = GetServerPath.getWeek();          // 静态得到 周数字符串
        userName = GetServerPath.getUserName();  // 静态得到 文件名字符串
        sendMessage = week+"-"+userName;  //"第一周"+"-"+"袁晓晶"
        sendMessage = "第一周"+"-"+"袁晓晶"; //测试
        //Socket连接
        Socket Socket;
        //从本地输出到Socket
        OutputStream outStream;
        DataOutputStream dataOutStream;

        //从Socket输入
        InputStream inputStream;
        DataInputStream dataInputStream;
        //输入流输出到文件
        FileOutputStream fileOutputStream;

        try {
            //建立套接字
            Socket = new Socket("localhost",port); //localhost  192.168.1.134
            //输出数据部分
            outStream = Socket.getOutputStream();
            dataOutStream = new DataOutputStream(outStream);
            dataOutStream.writeUTF(sendMessage);
            //输入部分
            inputStream =Socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            fileOutputStream= new FileOutputStream(localFLiePath);
            byte[] data = new byte[1024];
            while (true){
                int len = dataInputStream.read(data);
                if (len == -1){
                    break;
                }
                System.out.println("len："+len);
                fileOutputStream.write(data,0,len);
            }
            fileOutputStream.close();
            dataInputStream.close();
            dataOutStream.close();
            Socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //本地判断是否存在？
        return 0;
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo, String localFilePath) {
        int length;
        int success;
        //套接字
        Socket socket;
        //输出流
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        DataInputStream dataInputStream;
        //从文件输入
        FileInputStream fileInputStream;
        //输出流的第一部分内容
        String upFilePath;;
        //输出流的第二部分------->文件内容
        String localPath;
        byte[] sendBytes1;              // 文件路径
        byte[] sendBytes2;              // 文件本身
        byte[] upFilePathBytes;
        try {
            socket = new Socket("192.168.1.134",port);
            outputStream = socket.getOutputStream();

 //           sendBytes1 = new byte[80];

            upFilePath = fileUpVo.getUpFilePath();
//            // 对上传路径 ->bytes数组-> bytes数组复制到80字节的前一部分
//            upFilePathBytes = upFilePath.getBytes(StandardCharsets.UTF_8);
//            int lengthOfFileUpFilePath = upFilePath.getBytes().length;
//            System.arraycopy(sendBytes1,0,upFilePathBytes,0,lengthOfFileUpFilePath);
            // 本地文件
            localPath = localFilePath;
            File file = new File(localPath);
            fileInputStream = new FileInputStream(file);
            // 输出
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(upFilePath);
            sendBytes2 = new byte[1024];            //文件
            while ((length = fileInputStream.read(sendBytes2)) > 0){
                dataOutputStream.write(sendBytes2,0,length);
            }
            //inputStream = socket.getInputStream();
            //dataInputStream = new DataInputStream(inputStream);
            //todo
            //成功判断  --服务器判断文件是否存在
            //  success= dataInputStream.readInt();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<FileUp> queryAllFileUpInfo() {
        upFileDao = new UpFileDao();
        return upFileDao.queryAllFileUpInfo();
    }
    @Override
    public List<FileUp> queryFileUpByUser(User user) {
        upFileDao = new UpFileDao();
        return upFileDao.queryFileUpByUser(user);
    }
    @Override
    public int  insertFileUp(FileUp fileUp) {
        upFileDao = new UpFileDao();
        return upFileDao.insertFileUp(fileUp);
    }
    public static List<String> queryAllMangers(){
       return GetMangerName.queryAllManger();
    }
}
