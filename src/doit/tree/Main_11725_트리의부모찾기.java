package doit.tree;

import java.io.*;
import java.util.*;

public class Main_11725_트리의부모찾기 {
    static int N;
    static int[] parents;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : adj[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    parents[i] = cur;
                    q.add(i);
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }
}
