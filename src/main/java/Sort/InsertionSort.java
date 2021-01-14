package Sort;


//直接插入排序 时间复杂度O(n^2) 最好情况O(n)空间复杂度O(1)
public class InsertionSort extends Sort
{
    private int[] array;

    public InsertionSort(int[] array){
        this.array = array;
    }

    public int[] sort() throws NullPointerException
    {
        if (array == null || array.length == 0){
            throw new NullPointerException("数组为null，或数组长度为0");
        }
        int j;
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            if(array[i] < array[i-1]){
                for (j = i-1; j>=0 && array[j] > temp; j--)
                    array[j+1] = array[j];

                array[j+1] = temp;
            }
        }
        return array;
    }
    //第二种方法用数据交换替代数据后移
    public int[] sortTwo() throws NullPointerException{
        if(array == null || array.length == 0){
            throw new NullPointerException("数组为null或数组长度为0");
        }
        for(int i =1; i < array.length; i++)
            for (int j = i-1; j >= 0 && array[j] > array[j+1]; j--)
                swap(array, j, j+1);
        return  array;
    }

    //第三种方法折半插入排序
    public int[] sortThree() throws NullPointerException{
        int temp,i,j,low,high,mid =0;
        if (array == null){
            throw new NullPointerException("数组为null或数组长度为0");
        }
        for( i= 1; i < array.length; i++){//从i—n的数据都时无序的

            temp = array[i];
            low = 0;
            high = i;//low - high(不包括i)的数据都是有序
            while (low <= high){//当low < high时进行循环
                if(low == i){//当low等于i时代表此i和i之前的数组都是有序的不需要排序
                    mid = i;
                    break;
                }
                mid = (low + high) / 2;//每次都从之前的一半开始循环比较
                if(array[mid] > temp){
                    high = mid - 1;//
                }else
                {
                    low = mid + 1;
                }



            }
            for(j = i;  j > mid && j>0; j--){
                array[j] = array[j-1];
            }
            array[mid] = temp;
        }
        return array;

    }
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
