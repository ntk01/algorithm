import java.util.Scanner;

public class Bubble {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        int index = 0;

        boolean flag = true;

        while (flag){
            flag = false;
            for (int i=n-1; i>index; i--){
                if (arr[i]<arr[i-1]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = true;
                }
            }
            index++;
        }
        for (int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
