package netty.nioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuliyang
 * @date 2020-06-20
 * @time 22:15
 **/
public class FileChanelTest {
    public static void main(String[] args) throws Exception {
        readAndWrite();
    }

    public static void write()throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer =  ByteBuffer.allocate(1024);
        buffer.put("1213121".getBytes());
        buffer.flip();
        channel.write(buffer);
        fileOutputStream.close();
    }

    public static void read()throws Exception{
        File file = new File("D:\\test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer =  ByteBuffer.allocate((int)file.length());
        channel.read(buffer);
        buffer.flip();
        byte[] bytes = new byte[(int)file.length()];
        for (int i = 0; i <file.length() ; i++) {
            bytes[i] = buffer.get();
        }
        System.out.println(new String(bytes));
        fileInputStream.close();
    }


    public static void readAndWrite()throws Exception{
        File file = new File("D:\\test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test2.txt");
        FileChannel readChanel = fileInputStream.getChannel();
        FileChannel writeChanel = fileOutputStream.getChannel();
        ByteBuffer buffer =  ByteBuffer.allocate(5);
        while (true){
            buffer.clear();
            int read  = readChanel.read(buffer);
            if (read==-1)break;
            buffer.flip();
            writeChanel.write(buffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
