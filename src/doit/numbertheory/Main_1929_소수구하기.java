package doit.numbertheory;

import java.util.Scanner;

public class Main_1929_소수구하기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] prime = new int[N+1];
        for(int i=2; i<=N; i++){
            prime[i] = i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){ // 제곱근까지만 탐색
            if(prime[i] == 0) continue;
            for(int j=i+i; j<=N; j += i){
                prime[j] = 0;
            }
        }

        for(int i=M; i<=N; i++){
            if(prime[i] != 0) System.out.println(prime[i]);
        }
    }
}
