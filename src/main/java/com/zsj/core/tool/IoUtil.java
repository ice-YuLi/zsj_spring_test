package com.zsj.core.tool;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IoUtil {

    public static void inputStream(){ // 注意：没有关闭流
        // https://www.cnblogs.com/pxb2018/p/10738758.html
        try {
            File file = new File("/Users/zhishengjie/Downloads/java.txt");
            FileInputStream in = new FileInputStream(file);
//			byte[] bytes = new byte[256];
            byte[] bytes = new byte[100];
            int temp;
            if((temp = in.read(bytes)) != -1){
                String str = new String(bytes,0,temp,"UTF-8");
                System.out.print(str);
            }
            System.out.println("----------------------");
            System.out.println(file);
            System.out.println(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileReader(){ // 注意：没有关闭流
        // https://www.cnblogs.com/cookie1026/p/9703879.html
        try {
            File file = new File("/Users/zhishengjie/Downloads/java.txt");
            FileInputStream in = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(is);
//            // 每次读取一个字节
//            char[] chars = new char[1];
//            int temp;
//            while((temp = bufferedReader.read(chars)) != -1){
//                String str = new String(chars,0,temp);
//                System.out.print(str);
//            }
            // 每次读取一行
            String oneLine = bufferedReader.readLine();
            String twoLine = bufferedReader.readLine();
            String threeLine = bufferedReader.readLine();
            String fourLine = bufferedReader.readLine();

            System.out.println(oneLine);
            System.out.println(twoLine);
            System.out.println(threeLine);
            System.out.println(fourLine);
            System.out.println("----------------------");
            System.out.println(bufferedReader);
            System.out.println(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nio(){
        try {
            RandomAccessFile aFile = new RandomAccessFile("/Users/zhishengjie/Downloads/java.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            // 创建容量为48字节的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
//            buf.put();
            // 读入缓冲区
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {

                System.out.println("Read " + bytesRead);
                // 从写入模式切换到读取模式
                buf.flip();

                while(buf.hasRemaining()){
                    // 一次读取 1 个字节
                    System.out.print((char) buf.get());
                }

                // 清空缓冲区，使缓冲区准备好写入
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String arg[]){
        nio();
    }

}
