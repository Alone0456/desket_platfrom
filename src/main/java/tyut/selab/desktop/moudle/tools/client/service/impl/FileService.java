package tyut.selab.desktop.moudle.tools.client.service.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;//
// import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.IFileUpService;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class FileService implements IFileUpService {
    private IUserDao userDao;  //是学生类的一个接口  包含11个方法

    private IUpFileDao upFileDao;  // 周报管理系统的Dao

    private final int port = 45617;

    private String name;
    private String week;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeek() {
        return week;
    }

    public String getName() {
        return name;
    }

    @Override
    public int fileDown(FileUpVo fileUpVo, String localFLiePath) {    //String name, String week;  作为参数？
        //String name ="Defaulted";     //第一部分为：姓名 （本以为从Student 的Dao层 获取）()
        //String week ="第一周";         //第二部分为周数，判断周数需要自己写（当然，不是这一部分的内容）
        name = getName();
        week = getWeek();

        //Socket连接
        Socket Socket;
        //从本地输出到Socket
        OutputStream outStream;       //Socket 创建输出流
        DataOutputStream dataOutStream;
        byte[] sendByte;              //输出数据
        //从Socket输入
        InputStream inputStream;      //Socket 创建输入流
        DataInputStream dataInputStream;
        //输入流输出到文件
        FileOutputStream fileOutputStream;

        try {
            sendByte = new byte[39];            // 姓名7(21字节)+ 周数6(18字节)
            fileByteArray(sendByte, name.getBytes(StandardCharsets.UTF_8), week.getBytes(StandardCharsets.UTF_8), 21);//// 调用方法 实现固定模式的byte数组 让剩下的部分被0填充
            //建立套接字
            Socket = new Socket("localhost",port);

            //输出数据部分
            outStream = Socket.getOutputStream();
            dataOutStream = new DataOutputStream(outStream);//数据输出流
            dataOutStream.write(sendByte);

            System.out.println("连接到服务器成功"); // 终端

            //输入部分
            inputStream =Socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            fileOutputStream= new FileOutputStream(localFLiePath);
            byte[] data = new byte[5*1024];
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

        return 0;
    }

  


    @Override
    public int fileUpLoading(FileUp fileUp, String localFilePath) {  //FileUp
        int length;
        //套接字
        Socket socket;
        //输出流
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        //  PrintWriter printWriter;
        //从文件输入
        FileInputStream fileInputStream;
        //输出流的第一部分内容         ---->服务端路径 (从UI 或 数据库获取 ->调用fileUpTo???)

        String path = fileUp.getUpFilePath();        //服务端路径 //查询之后获取服务端路径
        int pathNum = 80;
        String serverPath ="Defaulted";
        byte[] serverPathByte;
        //输出流的第二部分------->文件内容
        String localPath = "Defaulted";               // 本地路径，也是需要获取的
        byte[] fileByte ;               // 文件路径
        byte[] sendBytes ;              // 上传数组

        try {
            socket = new Socket("localhost",port);
            outputStream = socket.getOutputStream();
            //     printWriter = new PrintWriter(outputStream);


            System.out.println("连接到服务器成功");
            File file = new File(localPath);
            fileInputStream = new FileInputStream(file);
            dataOutputStream = new DataOutputStream(outputStream);
            fileByte = new byte[1024*5];            //文件
            serverPathByte = serverPath.getBytes(StandardCharsets.UTF_8);
            sendBytes = new byte[1024*5+80];    //组合起来的第三个数组  有个流是无限流
            fileByteArray(sendBytes,serverPathByte,fileByte,80);

            while ((length=fileInputStream.read(sendBytes))>0){
                dataOutputStream.write(sendBytes,0,length);
            }
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
    public int insertFileUp(FileUp fileUp) {
        return 0;
    }

    /**
     *
     * @param endByte  待填充数组
     * @param data1    填充数组一
     * @param data2    填充数组二
     * @param length1  第一部分的长度
     */
    private static byte[] fileByteArray(byte[] endByte,byte[] data1, byte[] data2, int length1) {

        fileByteArrayAct(endByte, data1, data2, length1);
        // System.out.println(Arrays.toString(endByte));
        return endByte;
    }
    public static void fileByteArrayAct(byte[] endByte, byte[] data1, byte[] data2, int length1) {
        byte a = 0;
        System.arraycopy(data1, 0, endByte, 0, data1.length);
        Arrays.fill(endByte,data1.length,length1-1,a);
        System.arraycopy(data2,0,endByte,length1,data2.length);
        Arrays.fill(endByte,length1+data2.length,endByte.length,a);
    }
}
