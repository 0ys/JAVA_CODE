package doit.search;

import java.util.Scanner;

public class Main_2343_블루레이만들기 {
    static int[] lecture;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        lecture = new int[N];
        int start = 0, end = 0;
        for(int i=0; i<N; i++){
            lecture[i] = sc.nextInt();
            if(start<lecture[i]) start = lecture[i];
            end += lecture[i];
        }

        while(start<=end){
            int mid = (start+end)/2;
            int sum = 0, cnt = 0;
            for(int i=0; i<N; i++){
                if(sum+lecture[i]>mid){
                    cnt++;
                    sum = 0;
                }
                sum = sum + lecture[i];
            }
            if(sum != 0) cnt++;

            if(cnt > M) start = mid+1;
            else end = mid-1;
        }

        System.out.println(start);
    }
}
