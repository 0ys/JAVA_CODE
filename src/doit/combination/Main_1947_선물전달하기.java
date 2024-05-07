package doit.combination;

import java.util.Scanner;

public class Main_1947_선물전달하기 {
    public static void main(String[] args) {
        long mod = 1000000000L;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] D = new long[1000001]; // n이 1일 때 out of index 발생함으로 그냥 범위에 맞춰서 지정해줌
        D[1] = 0;
        D[2] = 1;
        for(int i = 3; i <= n; i++){
            D[i] = (i-1)*(D[i-1]+D[i-2])%mod;
        }

        System.out.println(D[n]);
    }
}
