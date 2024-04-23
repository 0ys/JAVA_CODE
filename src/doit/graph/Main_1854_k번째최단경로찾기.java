package doit.graph;

import java.util.*;
import java.io.*;

public class Main_1854_k번째최단경로찾기 {
    static PriorityQueue<Integer>[] distPQ;
    static int n, m, k;
    static ArrayList<Node>[] adj;

    static class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node arg0) {
            return this.cost - arg0.cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distPQ = new PriorityQueue[n + 1]; // k번째 최단경로를 저장
        adj = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            distPQ[i] = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            adj[i] = new ArrayList<>();
        }


        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
        }

        dijkstra(1);

        for(int i=1; i<=n; i++) {
            if(distPQ[i].size() == k) {
                bw.write(distPQ[i].peek()+"\n");
            } else {
                bw.write(-1+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distPQ[start].add(0);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node a = pq.poll();
            int now = a.to;
            int nowCost = a.cost;

            for(Node e : adj[now]) {
                int next = e.to;
                int nextCost = e.cost + nowCost;
                if(distPQ[next].size() < k) {
                    distPQ[next].add(nextCost);
                    pq.add(new Node(next, nextCost));
                } else if(nextCost < distPQ[next].peek()) {
                    distPQ[next].poll();
                    distPQ[next].add(nextCost);
                    pq.add(new Node(next, nextCost));
                }
            }

        }
    }

}
