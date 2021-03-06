package Sort;

public abstract class Sort
{
    //排序
    public abstract int[] sort() throws NullPointerException;
    //交换
    //public boolean swap(int[] array, int index1, int index2);
    //遍历
    public void traverse(int[] array) throws NullPointerException{
        if(array == null || array.length == 0){
            throw new NullPointerException("数组没有初始化或数组长度为0");
        }
        int leng = array.length;
        String str = "";
        for (int i : array){
            str += i + "----";
        }
        System.out.println(array + ":" + str);

    }
    protected void swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
