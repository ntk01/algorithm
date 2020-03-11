public class BinarySearch {

    public static int lowerbound1(int[] arr, int value){
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


    public static int lowerbound2(int[] arr, int value) {
        int left = -1;
        int right = arr.length;
        while (right-left>1) {
            int mid = (right+left)/2;
            if (arr[mid]>=value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }



    public static int upperbound1(int[] arr, int value){
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


    public static int upperbound2(int[] arr, int value) {
        int left = -1;
        int right = arr.length;
        while (right-left>1) {
            int mid = (right+left)/2;
            if (arr[mid]>value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}