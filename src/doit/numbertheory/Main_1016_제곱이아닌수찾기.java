package doit.numbertheory;

import java.util.Scanner;

public class Main_1016_제곱이아닌수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] check = new boolean[(int)(max-min+1)];
        // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복하기
        for(long i=2; i*i<=max; i++){
            long pow = i*i;
            long start_index = min / pow; // 제곱수(pow)의 배수 중 min 보다 큰 수를 찾기 위한 인덱스
            if(min%pow != 0) start_index++; // min이 pow로 나누어 떨어지지 않으면 index++을 해서 min보다 큰 제곱수의 배수가 되도록 한다.

            for(long j=start_index; pow*j <= max; j++){
                check[(int)((j*pow)-min)] = true; // 제곱수의 배수들을 check
            }
        }

        int cnt = 0;
        for(int i=0; i<=max-min; i++){
            if(!check[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
