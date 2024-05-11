package doit.dp;

import java.util.Scanner;

public class Main_1463_정수를1로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] D = new int[n+1];
        D[1] = 0;
        for(int i = 2; i <= n; i++){
            D[i] = D[i-1]+1;
            if(i % 2 == 0) D[i] = Math.min(D[i], D[i/2]+1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i/3]+1);
        }
        System.out.println(D[n]);
    }
}
