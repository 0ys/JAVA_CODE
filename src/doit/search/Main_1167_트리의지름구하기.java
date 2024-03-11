package doit.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1167_트리의지름구하기 {
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static class Node {
        int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static int[] DP;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        DP = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            while(e != -1) {
                int cost = Integer.parseInt(st.nextToken());
                adj[s].add(new Node(e, cost));
                e = Integer.parseInt(st.nextToken());
            }
        }

        BFS(1);
        int max = 1;
        for(int i=2; i<=N; i++){
            if(DP[max] < DP[i]) {
                max = i;
            }
        }
        visited = new boolean[N+1];
        DP = new int[N+1];
        BFS(max);
        Arrays.sort(DP);
        System.out.println(DP[N]);



    }

    static void BFS(int start){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int now = que.poll();

            for(Node e : adj[now]){
                int next = e.to;
                int cost = e.cost + DP[now];
                if(!visited[next]){
                    visited[next] = true;
                    DP[next] = cost;
                    que.add(next);
                }
            }
        }
    }
}
