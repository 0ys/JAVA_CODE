package doit.sort;

import java.io.*;

public class Main_10989_수정렬하기3 {
    static int[] A;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(5);

        for(int i=0; i<N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 구간 합을 이용하여 기수 정렬을 구현
    static void radixSort(int max_size) {
        int[] output = new int[N]; // 임시 정렬을 위한 배열
        int jarisu = 1; // 현재 자릿수를 표현하는 수
        int count = 0;
        while(count != max_size) { // 최대 자릿수만큼 반복
            int[] bucket = new int[10]; // 현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열
            for(int i=0; i<N; i++){
                // bucket의 배열 한 칸이 큐 하나와 같음
                bucket[(A[i]/jarisu)%10]++;
            }
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1]; // 합 배열을 이용해 output에 들어갈 index 계산
            }
            for(int i=N-1; i>=0; i--){ // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i]/jarisu)%10] - 1] = A[i];
                bucket[(A[i]/jarisu)%10]--;
            }
            for(int i=0; i<N; i++){
                A[i] = output[i]; // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
            }
            jarisu *= 10; // 자릿수 증가시키기
            count++;
        }
    }
}
