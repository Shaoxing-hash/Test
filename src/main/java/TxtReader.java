import serializable.SerializableUtil;
import serializable.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TxtReader
{
    public static void txtReaderTest(){
        String res = "";
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader(new File("H:\\newspace\\Test\\src\\test\\resources","1.txt")));
            String s = "";
            while((s = buff.readLine()) != null){
                res += s;
            }
            System.out.println(res);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public  void main01(String[] args)
    {
        Queue queue = new Queue();
        String[] s = {"abc", "当积累", "hahaha"};
        queue.pushAll(s);
        while(!queue.isEmpty())
        {
            System.out.println(queue.pop());
        }
    }

    public static void main(String[] args)
    {
        User user = new User();
        user.setAge(10);
        user.setName("刻晴,可莉");
        user.setSex(user.WOMAN);
        User user1 = user;
        if(user1.getAge() ==10){
            user1 = null;
        }
        System.out.println(user);
        /*try
        {
            SerializableUtil.saveObject(user);
        } catch (Exception e)
        {
            System.out.println("保存时异常" + e.getStackTrace());
        }
        try
        {
            User userObj = (User) SerializableUtil.readObject();
            System.out.println(userObj);
        } catch (Exception e)
        {
            System.out.println("读取时异常" + e.getStackTrace());
        }*/
    }


}
