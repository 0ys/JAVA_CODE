package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Knapsack 문제
public class Main_12865_평범한배낭 {
    static int N, K;
    static int[] W, V;
    static int[][] DP1;
    static int[] DP2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        DP1 = new int[N+1][K+1];
        DP2 = new int[K+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        // Bottom Up 방식 구현 1 : 2차원 배열 이용 (192ms / 53,768KB)
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                // i번째 무게를 더 담을 수 없는 경우
                if(W[i] > j) {
                    DP1[i][j] = DP1[i-1][j];
                }
                // i번째 무게를 더 담을 수 있는 경우
                else {
                    DP1[i][j] = Math.max(DP1[i-1][j], DP1[i-1][j-W[i]] + V[i]);
                }
            }
        }

        // Bottom Up 방식 구현 2 : 1차원 배열 이용 (180ms / 14,728KB)
        for(int i = 1; i <= N; i++){
            for(int j = K; j - W[i] >= 0; j--){
                // K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
                DP2[j] = Math.max(DP2[j], DP2[j-W[i]] + V[i]);
            }
        }

        System.out.println(DP1[N][K]);
        System.out.println(DP2[K]);
        System.out.println(knapsack(N, K));

    }
    static int knapsack(int i, int k){ // Top Down 방식 구현 (248ms / 55,088KB)
        if(i < 0) return 0; // i가 0 미만, 즉 범위 밖이 되면 리턴

        if(DP1[i][k] == 0){ // 탐색하지 않은 위치라면?
            // 현재 물건(i)을 추가로 못 담는 경우 (이전 i 값 탐색)
            if(W[i] > k){
                DP1[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else if (W[i] <= k){
                // 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i]) 중 큰 값을 저장
                DP1[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
            }
        }

        return DP1[i][k];
    }
}
