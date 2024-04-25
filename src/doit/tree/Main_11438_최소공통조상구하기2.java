package doit.tree;

import java.io.*;
import java.util.*;

public class Main_11438_최소공통조상구하기2 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;
    static int kMax; // 트리의 최대 가능 높이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        depth = new int[N+1];
        visited = new boolean[N+1];

        // 최대 가능 높이 구하기
        int temp = 1;
        kMax = 0;
        while(temp <= N) {
            temp *= 2;
            kMax++;
        }

        parent = new int[kMax+1][N+1];
        BFS(1); // parent와 depth 배열 초기화
        // 점화식으로 k번째 부모 노드의 값 채우기
        for(int k = 1; k <= kMax; k++) {
            for(int n = 1; n <= N; n++) {
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a,b));
        }
    }

    static int LCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 1. depth 맞추기
        for(int k = kMax; k >= 0; k--) {
            if(Math.pow(2, k) <= depth[a] - depth[b]){
                a = parent[k][a];
            }
        }

        //depth를 맞췄는데 조상이 같으면 바로 종료
        if(a==b) return a;

        // 2. LCA 찾기 : 2^K승 점프를 하면서 공통부모 바로 아래까지 올리기
        for(int k = kMax-1; k >= 0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // 공통부모 바로 아래에서 반복문이 끝났으므로, 첫 번째 부모(2^0)을 리턴
        return parent[0][a];
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next: adj[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = depth[now]+1;
                    q.add(next);
                }
            }
        }
    }
}
