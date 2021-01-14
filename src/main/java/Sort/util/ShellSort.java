package Sort.util;

import Sort.Sort;
//不稳定，时间复杂度为O(n^1+e)其中(0 < e <1), 空间复杂度为O(1)
//希尔排序的思想是把记录按下标的一定量n（n<length）进行分组,对每组使用直接插入进行排序，本次分组排序完成后
//将n换成更小的数即将记录平分成更多的组，每组原子更小依次减少直到增量减至1并排序完成后记录有序
public class ShellSort extends Sort
{
    private int[] array;
    private int length;

    public ShellSort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public int[] sort() throws NullPointerException
    {
        if(array == null || this.length == 0){
            throw new NullPointerException("数组未初始化或数组长度为0");
        }
        int gap, i, j, temp;
        //i代表组数也代表从自己开始每加i个数就时自己的组员每次除以2进行循环分组
        for(gap = length/2; gap > 0; gap/=2){
            for(i = gap; i < length; i++)
                for(j = i; j >= gap && array[j] < array[j-gap]; j-=gap)
                    super.swap(array, j, j-gap);
        }
        return array;
    }
    public int[] sortTwo() throws NullPointerException{
        if(array == null || this.length == 0){
            throw new NullPointerException("数组未初始化或数组长度为0");
        }
        int gap, i, j, temp, index;
        for(gap = length/2; gap > 0; gap/=2){
            for(i = gap; i < length; i++){
                index = i;
                temp = array[i];
                for(j = i; j >= gap && array[i] < array[j-gap]; j -= gap){
                    index = j - gap;
                }
                for(j = i; j > index && j >=gap; j -= gap){
                    array[j] = array[j-gap];
                }
                array[index] = temp;
            }
        }
        return array;
    }
}
