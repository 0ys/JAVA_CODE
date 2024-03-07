package doit.datastructure;

import java.io.*;
import java.util.*;

public class Main_1253_좋은수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N]; // 정수 값 1,000,000,000 이 입력됨
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0; i<N; i++){
            int start = 0;
            int end = N-1; // 음수인 값도 있으므로 전체 탐색
            long target = arr[i];

            while(start<end){
                long sum = arr[start]+arr[end];
                if(sum == target){ // 서로 다른 두 수의 합인지 확인
                    if(start != i && end != i){
                        cnt++;
                        break;
                    } else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }
                } else if(sum < target){
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
