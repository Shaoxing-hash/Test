package serializable;

import java.io.*;

public class SerializableUtil
{
    //存储对象，序列化
    public static void saveObject(Object object) throws Exception
    {
        ObjectOutputStream out = null;
        FileOutputStream fileOut = null;
        try
        {
            fileOut = new FileOutputStream("H:\\newspace\\Test\\src\\main\\resources\\1.txt");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
        }finally
        {
            fileOut.close();
            out.close();
        }
    }
    //读取对象，反序列化
    public static Object readObject() throws Exception
    {
        ObjectInputStream in = null;
        FileInputStream fileIn = null;
        try
        {
            fileIn = new FileInputStream("H:\\newspace\\Test\\src\\main\\resources\\1.txt");
            in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            return obj;
        }finally
        {
            fileIn.close();
            in.close();
        }
    }
}
