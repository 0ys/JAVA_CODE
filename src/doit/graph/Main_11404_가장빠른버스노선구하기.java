package doit.graph;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11404_가장빠른버스노선구하기 {
    static long[][] D; // 최단 거리 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        D = new long[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) D[i][j] = 0;
                else D[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            D[a][b] = Math.min(D[a][b], c);
        }

        for(int k = 1; k <= N; k++){
            for(int s = 1; s <= N; s++){
                for(int e = 1; e <= N; e++){
                    D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(D[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
                else System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }
}
