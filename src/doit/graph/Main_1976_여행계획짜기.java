package doit.graph;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1976_여행계획짜기 {
    static int N, M;
    static int[] parents;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] == 1){
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = find(Integer.parseInt(st.nextToken()));
        boolean check = true;
        for(int i = 1; i < M; i++){
            int now = Integer.parseInt(st.nextToken());
            if(find(now) != index){
                check = false;
            }
        }

        if(check){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parents[aRoot] = bRoot;
    }

    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
