package BinarySearch;

public class testBinarySearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,5,8,10};
        int v1 = 3;
        int v2 = 6;
        System.out.println(BinarySearch.lowerbound(arr, v1));   //output: 2
        System.out.println(BinarySearch.lowerbound(arr, v2));   //output: 4
        System.out.println(BinarySearch.upperbound(arr, v1));   //output: 3
        System.out.println(BinarySearch.upperbound(arr, v2));   //output: 4
    }
}
