package Sort.util;

public abstract class Traverse
{
    //遍历
    public void traverse(int[] array) throws NullPointerException{
        if(array == null || array.length == 0){
            throw new NullPointerException("数组没有初始化或数组长度为0");
        }
        int leng = array.length;
        String str = "";
        for (int i : array){
            str += i;
        }
        System.out.println(array + ":" + str);

    }
}
