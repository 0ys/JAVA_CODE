package doit.search;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS프로그램 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        for(int i=1; i<=N; i++){ // 작은 번호부터 방문하도록
            Collections.sort(adj[i]);
        }

        visited = new boolean[N+1];
        DepthFirstSearch(v);
        System.out.println();

        visited = new boolean[N+1];
        BreadthFirstSearch(v);

    }

    static void DepthFirstSearch(int v) {
        if(visited[v]) return;
        visited[v] = true;
        System.out.print(v+" ");
        for(int i : adj[v]){
            if(!visited[i]){
                DepthFirstSearch(i);
            }
        }
    }

    static void BreadthFirstSearch(int v){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int i : adj[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
