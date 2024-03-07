package doit.search;

import java.io.*;
import java.util.*;

public class Main_13023_친구관계파악하기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean result = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        Arrays.fill(visited, false);

        adj = new ArrayList[N];
        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }

        for(int i=0; i<N; i++){
            DFS(i, 1);
            if(result) break;
        }

        System.out.println(result? 1 : 0);

    }

    static void DFS(int v, int depth){
        if(depth == 5 || result) {
            result = true;
            return;
        }
        visited[v] = true;

        for(int i : adj[v]){
            if(!visited[i]){
                DFS(i, depth+1);
            }
        }
        visited[v] = false;
    }
}
