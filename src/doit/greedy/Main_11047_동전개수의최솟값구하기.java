package doit.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전개수의최솟값구하기 {
    static int N, K;
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=N-1; i>=0; i--){
            if(A[i]<=K){
                cnt += K/A[i];
                K = K % A[i];
            }
        }

        System.out.println(cnt);
    }
}
