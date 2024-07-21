package solved;

import java.io.*;
import java.util.*;

public class Main_1697_숨바꼭질 {
    static int N, K;
    static int[] DP = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(DP, Integer.MAX_VALUE);

        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        DP[N] = 0;
        if(N != 0 && N*2 < 100001){
            que.add(N*2);
            DP[N*2] = 1;
        }
        while(!que.isEmpty()) {
            int i = que.poll();
            int left = i-1;
            int right = i+1;
            int doubleLeft = (i-1)*2;
            int doubleRight = (i+1)*2;
            if(left >=0 && DP[i-1] > DP[i]+1){
                DP[i-1] = DP[i]+1;
                que.add(i-1);
            }
            if(0 <= doubleLeft && doubleLeft < 100001 && DP[doubleLeft] > DP[left]+1){
                DP[doubleLeft] = DP[left]+1;
                que.add(doubleLeft);
            }
            if(right < 100001 && DP[i+1] > DP[i]+1){
                DP[i+1] = DP[i]+1;
                que.add(i+1);
            }
            if(doubleRight < 100001 && DP[doubleRight] > DP[right]+1){
                DP[doubleRight] = DP[right]+1;
                que.add(doubleRight);
            }
        }

        for(int i = 0; i <= K; i++){
            System.out.print(DP[i]+" ");
        }
        System.out.println();
        System.out.println(DP[K]);
    }
}
