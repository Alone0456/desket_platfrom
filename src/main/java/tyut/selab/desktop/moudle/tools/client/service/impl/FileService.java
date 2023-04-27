
package tyut.selab.desktop.moudle.tools.client.service.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.dao.impl.GetMangerName;
import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;
import tyut.selab.desktop.ui.tools.utils.GetServerPath;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class FileService implements IFileUpService {
    private IUserDao userDao;             //  学生类的Dao层接口

    private IUpFileDao upFileDao;         //  周报管理系统的Dao

    private final int port = 45617;

    @Override
    public int fileDown(FileUpVo fileUpVo, String localFLiePath) {
        String managerName;
        String week;
        String sendMessage;
        week = GetServerPath.getWeek();          // 静态得到 周数字符串 example:第一周
        managerName = GetServerPath.getManagerName();  // 静态得到 组长名 字符串
        sendMessage = week+"-"+managerName;
        //Socket连接
        Socket Socket;
        //从本地输出到Socket 的流
        OutputStream outStream;
        DataOutputStream dataOutStream;

        //从Socket输入 的流
        InputStream inputStream;
        DataInputStream dataInputStream;
        //将 输入流 输出某一路径 的 文件输出流
        FileOutputStream fileOutputStream;
        int success = 0;
        try {
            //建立套接字
            Socket = new Socket("192.168.1.134",port); // 192.168.1.134
            //输出数据部分 的流
            outStream = Socket.getOutputStream();
            dataOutStream = new DataOutputStream(outStream);
            dataOutStream.writeUTF(sendMessage);
            //输入部分  的流
            inputStream =Socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            //文件输出流：将文件以写入数据到指定路径所代表的文件（可以理解为内部先输入，读取数据后作为输出流来用）
            fileOutputStream= new FileOutputStream(localFLiePath);
            byte[] data = new byte[1024];
            while (true){
                int len = dataInputStream.read(data);
                if (len == -1){
                    break;
                }
                fileOutputStream.write(data,0,len);
            }

            // 从服务器 输入 信息(文件传输完毕信息) 以便客户端关闭 输入流
            dataInputStream = new DataInputStream(inputStream);
            success = dataInputStream.readInt();
            if(success == 1){
                dataInputStream.close();
            }
            outStream.flush();
            outStream.close();
            dataOutStream.flush();
            dataOutStream.close();
            fileOutputStream.close();
            Socket.close();
            return success;
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public int fileUpLoading(FileUpVo fileUpVo, String localFilePath) {
        int length;
        int success = 0;
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
        String upFilePath;
        //输出流的第二部分------->文件内容
        String localPath;

        byte[] sendBytes;              // 文件本身
        try {
            socket = new Socket("192.168.1.134",port);
            outputStream = socket.getOutputStream();
            // 上传路径
            upFilePath = fileUpVo.getUpFilePath();
            // 本地文件
            localPath = localFilePath;
            File file = new File(localPath);
            fileInputStream = new FileInputStream(file);
            // 输出
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(upFilePath);
            sendBytes = new byte[1024];            //文件
            while ((length = fileInputStream.read(sendBytes)) > 0){
                dataOutputStream.write(sendBytes,0,length);
            }
            // 上传结束
            String upOver = "上传结束";
            dataOutputStream.writeUTF(upOver);
            // 读取服务器的返回值，作为成功判断
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            success =  dataInputStream.readInt();

            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
            fileInputStream.close();
            return success;
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
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
    public static List<String>queryAllManger(){
        return GetMangerName.queryAllManger();
    }
}