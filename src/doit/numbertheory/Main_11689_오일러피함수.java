package doit.numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11689_오일러피함수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = N;
        for(long p=2; p<=Math.sqrt(N); p++){
            if(N % p == 0){ // 현재 p가 N의 소인수였을 때
                result = result - result/p; // 오일러 피 공식 P[i] = P[i] - P[i]/K
                while(N % p == 0) { // N에서 소인수 p를 제거함(더이상 나누어지지 않도록)
                    N /= p;
                }
            }
        }

        if(N>1) // 아직 마지막 소인수가 남음(반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스)
            result = result - result/N;
        System.out.println(result);
    }
}
