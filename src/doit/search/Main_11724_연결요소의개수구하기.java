package doit.search;

import java.io.*;
import java.util.*;

public class Main_11724_연결요소의개수구하기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);

    }

    static void DFS(int v){
        if(visited[v]) return;
        visited[v] = true;

        for(int i : adj[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
