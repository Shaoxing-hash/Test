package Sort;
/*
 * @Title 排序类之冒泡排序
 * @Description //TODO
 * @Date 15:52 2021/1/12
 * @Param
 * @return
 **/
public class BubbleSort implements Sort
{
    private int[] array;
    private int number = 0;
    int bubbleTime = 0;
    public BubbleSort(int[] array){
        this.array = array;
    }

    public int[] sort() throws NullPointerException
    {
        if(array == null || array.length == 0){
            throw new NullPointerException("数组为空");
        }
        int leng = array.length;
        int i = 0;
        for(; i < leng; i++){
            boolean flag = false;
            for(int j = 0; j < leng-1-i; j++){
                if(array[j] > array[j+1]){
                    flag = swap(array, j, j+1);
                }

            }
            if(flag == false){
                this.bubbleTime = i;
                return array;
            }
        }
        this.bubbleTime = i;
        return array;
    }

    private boolean swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        this.number++;
        return true;
    }
    //鸡尾酒排序
   public void CocktailSort(int a[], int n){
        int left = 0, right=n;
        while(left<right){
            for(int i=left;i<right-1;i++){       //从前往后排
                if(array[i] > array[i+1]){
                    swap(a,i,i+1);
                }

            }
            right-=1;
            for(int j=right;j>left;j--){     //从后往前排
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
            }
            left+=1;
        }
    }
    public void traverse() throws NullPointerException
    {
        if(this.array == null || this.array.length == 0){
            throw new NullPointerException("数组没有初始化或数组长度为0");
        }
        int leng = this.array.length;
        String str = "";
        for (int i : array){
           str += i;
        }
        System.out.println(array + ":" + str + "交换次数:" + number + "冒泡次数:" + bubbleTime);
    }


}
