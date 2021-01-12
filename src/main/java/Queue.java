import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queue
{
    protected List<String> list1 = new LinkedList<String>();
    protected List<String> list2 = new ArrayList<String>();
    //队列出栈
    public String pop(){
        if(list1.isEmpty()){
            System.out.println("队列为空,无需出栈");
            throw new NullPointerException("队列为空");
        }else{
            while(list1.size() >0){
                list2.add(list1.remove(list1.size()-1));
            }
            String s = list2.remove(list2.size()-1);
            while(list2.size() > 0){
                list1.add(list2.remove(list2.size()-1));
            }
            return s;
        }

    }
    public void push(String s){
        list1.add(s);
    }
    public int pushAll(String[] s){
        int len = s.length;
        int count = 0;
        if(count == len){
            return 0;
        }
        while(len > count){
            list1.add(s[count++]);
        }
        return s.length;
    }
    public int size(){
        return list1.size();
    }
    public Boolean isEmpty(){
        return list1.isEmpty();
    }
}
