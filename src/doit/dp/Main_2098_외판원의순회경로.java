package doit.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비트 마스킹 기법
public class Main_2098_외판원의순회경로 {
    static int[][] W, d;
    static int N;
    static final int INF = 1000000 * 16 +1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        d = new int[16][1 << 16];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    static int tsp(int c, int v){ // c는 현재 도시, v는 현재까지 방문한 도시의 리스트를 이진수로 표현함
        if(v == (1 << N) - 1) { // 모든 노드를 방문했을 때
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if(d[c][v] != 0){ // 이미 방문한 노드일 때
            return d[c][v];
        }
        int min = INF;
        for(int i = 0; i < N; i++){
            if((v & (1 << i)) == 0 && W[c][i] != 0){ // 방문한 적이 없고, 갈 수 있는 도시일 때
                min = Math.min(min, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }

        return d[c][v] = min;
    }
    /*
    모든 도시 순회 판단 연산식 : if(v == (1 << N) - 1)
    예를 들어, 도시가 4개인 경우 (1 << 4) - 1 = 16 - 1 = 15이고, v가 15라면 모든 도시를 방문한 것임

    방문 도시 확인 연산식 : if((v & (1 << i)) == 0)
    예를 들어, i=3(4번째도시)인 경우 1 << 3 = 8 = 1000이고, v & 1000 연산을 수행했을 때 결과값이 0이면 4번 도시를 방문하지 않았다고 판단할 수 있음
    즉 v의 이진수 표현 시 4번째 자리가 1인 경우가 아니면 0을 리턴하며 4번째 도시를 방문하지 않았다고 판단함

    방문 도시 저장 연산식 : v | (1 << i)
    예를 들어, i=2(3번째도시)인 경우 1 << 2 = 100이고, v | 100 연산을 수행하면 v의 이진수 표현 시 3번째 자리를 1로 저장하게 되어,
    3번째 도시에 방문하였다는 사실을 저장하게 됨
     */
}
