package doit.combination;

import java.io.*;
import java.util.*;

public class Main_1722_순열의순서구하기 {
    public static void main(String[] args) throws Exception {
        long K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 팩토리얼 초기화
        long[] F = new long[21];
        F[0] = 1;
        for(int i = 1; i <= N; i++) {
            F[i] = F[i-1] * i;
        }

        int[] S = new int[21]; // 순열
        boolean[] visited = new boolean[21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tag = Integer.parseInt(st.nextToken());
        if(tag == 1){
            K = Long.parseLong(st.nextToken());
            for(int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j])
                        continue; // 이미 사용한 숫자는 사용할 수 없음
                    if (K <= cnt * F[N - i]) { // 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
                        K -= ((cnt - 1) * F[N - i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(S[i] + " ");
            }
        } else {
            K = 1;
            for(int i = 1; i <= N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (visited[j] == false) {
                        cnt++; // 미사용 숫자 개수만큼 카운트
                    }
                }
                K += cnt * F[N - i]; // 자리수 개수에 따라 순서 더해주기
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}
