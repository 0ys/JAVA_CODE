package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1753_최단경로구하기 {
    static public class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int V, E;
    static ArrayList<Node>[] adj;
    static int[] DP;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        DP = new int[V + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        visited = new boolean[V + 1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        dijkstra(S);

        for(int i=1; i<=V; i++){
            if(!visited[i]) System.out.println("INF");
            else System.out.println(DP[i]);
        }
    }

    public static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        DP[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if(nowCost > DP[now]) continue;
            if(visited[now]) continue;
            visited[now] = true;

            for(Node e : adj[now]){
                int next = e.to;
                int nextCost = DP[now] + e.cost;
                if(DP[next] > nextCost){
                    DP[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }

    }
}
