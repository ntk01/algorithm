package BinarySearch;

public class testBinarySearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,5,8,10};
        int v0 = 0;
        int v1 = 1;
        int v2 = 3;
        int v3 = 6;
        int v4 = 10;
        int v5 = 12;

        System.out.println(BinarySearch.lowerbound(arr, v0));   //output: 0
        System.out.println(BinarySearch.lowerbound(arr, v1));   //output: 0
        System.out.println(BinarySearch.lowerbound(arr, v2));   //output: 2
        System.out.println(BinarySearch.lowerbound(arr, v3));   //output: 4
        System.out.println(BinarySearch.lowerbound(arr, v4));   //output: 5
        System.out.println(BinarySearch.lowerbound(arr, v5));   //output: 6

        System.out.println(BinarySearch.upperbound(arr, v0));   //output: 0
        System.out.println(BinarySearch.upperbound(arr, v1));   //output: 1
        System.out.println(BinarySearch.upperbound(arr, v2));   //output: 3
        System.out.println(BinarySearch.upperbound(arr, v3));   //output: 4
        System.out.println(BinarySearch.upperbound(arr, v4));   //output: 6
        System.out.println(BinarySearch.upperbound(arr, v5));   //output: 6
    }
}
