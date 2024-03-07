package doit.datastructure;

import java.util.*;
import java.io.*;

public class Main_10986_나머지합구하기 {
    static long[] arr, index; //long으로 선언하지 않으면, arrayIndexOutOfBound 에러가 남
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        long cnt = 0;
        index = new long[M];
        // if arr[j] % M == arr[i] % M -> (arr[j]-arr[i]) % M == 0
        for(int i=1; i<=N; i++){
            int remainder = (int)(arr[i] % M);
            if(remainder==0) {
                cnt += 1;
            }
            index[remainder]++;

        }

        for(int i=0; i<M; i++){
            if(index[i]>1){
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수
                cnt += index[i]*(index[i]-1)/2;
            }
        }

        System.out.println(cnt);
    }
}
