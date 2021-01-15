package Sort;

public class SortTest
{
    public static void quickSort(int[] array){
        Sort sort = new QuickSort(array);
        QuickSort quickSort = (QuickSort) sort;
        quickSort.sort();
        quickSort.traverse(array);
    }
    public static void main(String[] args)
    {

        int[] array = {15,15,15,23,24,23,31,13,15,22,6,53,12};
        /*Sort sort = new ShellSort(array);
        //向下转型
        ShellSort shellSort = (ShellSort) sort;
        shellSort.sortTwo();
        shellSort.traverse(array);*/
        quickSort(array);
    }
}
