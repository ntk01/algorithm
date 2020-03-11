package BinarySearch;

public class BinarySearch {

    public static int lowerbound(int[] arr, int value){
        int left = 0;
        int right = arr.length;
        while (left<right){
            int mid = (left+right)/2;
            if (arr[mid]<value){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static int upperbound(int[] arr, int value){
        int left = 0;
        int right = arr.length;
        while (left<right){
            int mid = (left+right)/2;
            if (arr[mid]<=value){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}