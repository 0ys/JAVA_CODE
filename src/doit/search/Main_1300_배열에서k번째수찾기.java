package doit.search;

import java.util.Scanner;

public class Main_1300_배열에서k번째수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int start = 1;
        int end = k;
        int result = 0;
        while(start<=end){
            int mid = (start+end)/2;
            int cnt = 0;
            for(int i=1; i<=N; i++){
                cnt += Math.min(mid/i, N);
            }
            if(cnt<k) {
                start=mid+1;
            }
            else {
                end = mid-1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
