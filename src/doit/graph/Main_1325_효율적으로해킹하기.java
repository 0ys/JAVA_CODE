package doit.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적으로해킹하기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] DP;
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        DP = new int[N+1];
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            DFS(i);
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, DP[i]);
        }

        for(int i=1; i<=N; i++){
            if(DP[i]==max) bw.write(i+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void BFS(int node){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visited[node] = true;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : adj[now]){
                if(!visited[next]){
                    visited[next] = true;
                    DP[next]++;
                    que.add(next);
                }
            }
        }
    }

    static void DFS(int node){
        visited[node] = true;

        for(int next : adj[node]){
            if(visited[next]) continue;
            DP[next]++;
            DFS(next);
        }
    }
}
