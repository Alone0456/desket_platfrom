package tyut.selab.desktop.ui.tools.tools.src.ClientAndServer;


import java.io.*;
import java.lang.invoke.VarHandle;
import java.net.*;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Client {
    Socket client;
    boolean flag = true;
    FileInputStream fis;//此输入流负责读取本机上要传输的文件
    DataOutputStream dos;//此输出流负责向另一台电脑(服务器端)传输数据
    DataInputStream dis;//此输入流负责读取另一台电脑的回应信息

    public static void main(String[] args) throws Exception {
        new Client().ClientStart();
    }

    public void ClientStart() throws Exception {
        try {
            client = new Socket("localhost", 8080);//服务器端的IP,(这个只是在局域网内的)我的是这个,你的根据实际而定
            System.out.println("已连接");
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
            String sc = "C:\\Users\\10597\\Desktop\\test.zip";//这里你可以直接写成文件夹的路径或文件的路径
            File fi1 = new File(sc);
            if (fi1.isDirectory()) {//识别一开始你的是不是文件夹。是就以递归的形式，发送给服务端
                copydirectory(fi1, sc);
            } else if (fi1.isFile()) {//如果你发送的是文件，那么就发给服务端
                String str1 = sc.substring(0, sc.lastIndexOf("\\"));
                System.out.println(str1);
                copyfile(fi1, str1, dos, dis);
            } else {//加入错误提示
                System.out.println("请认真输入路径");
            }

            String s = "/]00";//提示传输完毕的标记
            byte b[] = s.getBytes();
            dos.write(b, 0, s.length());
            dos.flush();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void copyfile(File file, String ss1, DataOutputStream dos1, DataInputStream dis1) {
        byte buff[];
        String str;
        int ti;
        try {
            fis = new FileInputStream(file);
            str = "/]0c" + (file.getPath().replace(ss1, ""));//这是一个文件的名称
            buff = str.getBytes();
            dos1.write(buff);
            dos1.flush();
            dis1.read();
            dos1.writeInt(fis.available());//传输一个整型值,指明将要传输的文件的大小
            dos1.flush();
            dis1.read();
            buff = new byte[10000];
            while (fis.available() > 0) {//开始传送文件
                ti = fis.read(buff);
                dos1.write(buff, 0, ti);
                dos1.flush();
            }
            dos1.flush();
            fis.close();
            dis1.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void copydirectory(File f, String ss) throws Exception {//这是传输的核心,而且将被递归
        byte b[] = null;
        String ts = null;
        for (File f1 : f.listFiles()) { //首先通过if语句判断f1是文件还是文件夹
            if (f1.isDirectory()) { //fi是文件夹,则向服务器端传送一条信息
                ts = "/]0f" + (f1.getPath().replace(ss, ""));//"/]0f"用于表示这条信息的内容是文件夹名称
                b = ts.getBytes();
                dos.write(b);
                dos.flush();
                dis.read();
                copydirectory(f1, ss);//由于f1是文件夹(即目录),所以它里面很有可能还有文件或者文件夹,所以进行递归
            } else {
                copyfile(f1, ss, dos, dis);
            }
        }
    }
}

