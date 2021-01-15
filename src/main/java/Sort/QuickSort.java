package Sort;

public class QuickSort extends Sort
{
    private int[] array;
    private int length;

    public QuickSort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public int[] sort() throws NullPointerException
    {
        if(array == null && array.length == 0){
            throw new NullPointerException("数组为null或数组长度为0");
        }
        int i = 0, j = length-1, base = array[0] ,flag = j;
        while (i <= j){
            for(; j >= i; j--){
                flag = j;
                if(array[j] < base ){
                    break;
                }
            }
            for(; i <= j; i++){
                if(array[i] > base) break;
            }
            if(i < j){
                swap(array, i, j);

            }
        }
        for(int k = 0; k < flag; k++){
            swap(array, k, k+1);
        }
        array[flag] = base;
        this.traverse(array);
        sort(array, 0, flag-1);
        this.traverse(array);
        sort(array, flag+1, length-1);
        return array;
    }
    private void sort(int[] array,int baseIndex, int length){
        if(array == null && array.length == 0){
            throw new NullPointerException("数组为null或数组长度为0");
        }
        if(baseIndex < length){
            int i = baseIndex, j = length, base = array[baseIndex] ,flag = j;
            while (i <= j){
                for(; j >= i; j--){
                    flag = j;
                    if(array[j] < base ){
                        break;
                    }
                }
                for(; i <= j; i++){
                    if(array[i] > base) break;
                }
                if(i < j){
                    swap(array, i, j);

                }
            }
            for(int k = baseIndex; k < flag; k++){
                swap(array, k, k+1);
            }
            array[flag] = base;

            sort(array, baseIndex, flag-1);
            sort(array, flag+1, length);
        }
        //i代表从左边查找比base大的值的起始点，j代表从右边查找比base小的值的起始点，base为基准值，flag表示base应该存在的位置

    }


}
