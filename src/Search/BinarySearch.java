package Search;

public class BinarySearch {

    public int lowerBound(int[] arr, int value) {
        int left = -1;
        int right = arr.length;
        while (right-left > 1) {
            int mid = (right+left)/2;
            if (arr[mid]>=value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public int upperBound(int[] arr, int value) {
        int left = -1;
        int right = arr.length;
        while (right-left > 1) {
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