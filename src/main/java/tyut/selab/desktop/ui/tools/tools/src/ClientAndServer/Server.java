package tyut.selab.desktop.ui.tools.tools.src.ClientAndServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:Server
 * Package:test2
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/03/31 - 14:26
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class Server{
    ServerSocket server=null;
    Socket client=null;
    boolean flag=true;
    DataInputStream dis;
    DataOutputStream dos;

    public static void main(String[] args){
        new Server().ServerStart();
    }

    public void ServerStart(){
        try{
            server=new ServerSocket(8080);
            System.out.println("端口号:"+server.getLocalPort());
            client=server.accept();//等待接收
            System.out.println("连接完毕");
            dis=new DataInputStream(client.getInputStream());
            dos=new DataOutputStream(client.getOutputStream());
            try{
                Copy(dis,dos);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                client.close();
                server.close();
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }

    public void Copy(DataInputStream dis1,DataOutputStream dos1) throws Exception{
        String answer="g";
        byte ans[]=answer.getBytes();
        byte b[]=new byte[1000];
        int ti;
        int count1=0;//计算收到文件夹的次数
        int count2=0;//计算收到文件的次数
        new File("C:\\Users\\10597\\Desktop\\提交").mkdirs();
        FileOutputStream fos;
        while(flag){
            ti=dis1.read(b);
            dos1.write(ans);
            String select=new String(b,0,ti);
            if(select.contains("/]0f")){//识别文件夹
                File f=new File("C:\\Users\\10597\\Desktop\\提交"+(select.replace("/]0f","")));//去掉标识
                count1++;
                System.out.println("creat directory "+count1+" times");
                f.mkdirs();
            }else if(select.contains("/]0c")){//识别文件
                fos=new FileOutputStream("C:\\Users\\10597\\Desktop\\提交"+(select.replace("/]0c","")));
                int tip=dis1.readInt();
                dos1.write(ans);
                while(tip>0){
                    ti=dis1.read(b,0,(tip>1000?1000:tip));
                    tip=tip-ti;
                    String cs=new String(b,0,4);
                    fos.write(b,0,ti);
                }
                count2++;
                fos.flush();
                fos.close();
                dos1.write(ans);
                System.out.println("creat file "+count2+" times");
            }else if(select.contains("/]00")){
                flag=false;//彻底结束的标志
                System.out.println("creat successfully");
            }
        }
        dis1.close();
    }
}

