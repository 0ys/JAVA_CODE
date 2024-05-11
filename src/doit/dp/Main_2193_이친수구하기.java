package doit.dp;

import java.util.Scanner;

public class Main_2193_이친수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] D = new long[n+1]; // 90에서 int형을 벗어나기 때문에 long형으로 선언필요!
        D[1] = 1;
        if(n != 1){ // 가장 작은 범위의 숫자가 들어올 때 예외처리가 필요함
            D[2] = 1;
        }
        for (int i = 3; i <= n; i++) {
            D[i] = D[i-1] + D[i-2];
            // D[5] = D[1]+D[2]+D[3]+1
            // D[6] = D[1]+D[2]+D[3]+D[4]+1
            //      = D[5]+D[4]

        }

        System.out.println(D[n]);
    }
}
