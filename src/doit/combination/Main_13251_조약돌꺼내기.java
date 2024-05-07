package doit.combination;

import java.util.Scanner;

public class Main_13251_조약돌꺼내기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        int[] D = new int[M];
        double total = 0;

        for(int i = 0; i < M; i++) {
            D[i] = sc.nextInt();
            total += D[i];
        }

        int K = sc.nextInt();

        double result = 0;
        for(int i = 0; i < M; i++) {
            double prob = 1;
            for(int j = 0; j < K; j++) {
                prob *= (D[i]-j)/(total-j);
            }
            result += prob;
        }

        System.out.println(result);
    }
}
