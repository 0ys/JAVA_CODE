package doit.numbertheory;

import java.util.Scanner;

public class Main_1456_거의소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        int MAX = 10000001;
        // 최대 범위 내의 소수를 먼저 구한다.
        long[] prime = new long[MAX];
        for(int i=2; i<MAX; i++){
            prime[i] = i;
        }

        for(int i=2; i<Math.sqrt(MAX); i++){
            if(prime[i] == 0) continue;
            for(int j = i+i; j<MAX; j += i){
                prime[j] = 0;
            }
        }
        // 거의 소수 구하기 : 소수의 제곱 수
        int cnt = 0;
        for(int i=2; i<MAX; i++){
            if(prime[i] != 0){ // 소수에 대해서
                long temp = prime[i];
                while((double)prime[i] <= (double)B/(double)temp){ // 나누기가 있기 때문에 실수 double 로 계산해줘야 정확함
                    if((double)prime[i] >= (double)A/(double)temp) cnt++;
                    temp *= prime[i];
                }
            }
        }

        System.out.println(cnt);
    }
}