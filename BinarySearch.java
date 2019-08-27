import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] S = new int[n];
        for (int i=0; i<n; i++) S[i] = sc.nextInt();
        int q = sc.nextInt();

        boolean flag = false;
        for (int i=0; i<q; i++){
            int left = 0;    //境界値を含む(閉区間)
            int right = n;   //境界値を含まない(開区間)
            while (left<right){
                int mid = (left+right)/2;
                if (S[mid]==q){
                    flag=true;
                    break;
                }else if (S[mid]<q){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        System.out.print(flag);
    }
}
