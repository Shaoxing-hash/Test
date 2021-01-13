package Sort;

public class SortTest
{
    public static void main(String[] args)
    {
        int[] array = {5,4,3,2,1};
        BubbleSort sort = new BubbleSort(array);
        //sort.sort();
        sort.CocktailSort(array,array.length);

        sort.traverse();
    }
}
