package sds;

import java.io.*;
import java.util.*;

public class Main_1753_최단경로 {
    static int[] DP;
    static ArrayList<Node>[] adj;
    static int V, E, sNode;

    static class Node implements Comparable<Node> {
        int weight, to, dist;

        public Node(int to, int w) {
            this.to = to;
            this.weight = w;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight == o.weight) {
                return this.dist - o.dist; // 2가지 기준으로 할 수 있음
            }
            return this.weight - o.weight; // 오름차순
            /*
             * 내 것과 새로 들어온 객체를 계산해서 0, 음수면 그대로, 양수면 바꿔라
             */
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        sNode = Integer.parseInt(br.readLine());

        DP = new int[V + 1];
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            DP[i] = Integer.MAX_VALUE;
            adj[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w)); // 양방향인지 확인해야함
        }

        // print Graph
        for (int i = 1; i <= V; i++) {
            System.out.print("node " + i);
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(" -> " + adj[i].get(j).to + "(" + adj[i].get(j).weight + ")");
            }
            System.out.println();
        }

        dijkstra(sNode);

        for (int i = 1; i <= V; i++) {
            if (DP[i] == Integer.MAX_VALUE) {
                bw.write("INF");
                bw.newLine();
            } else {
                bw.write("" + DP[i]);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        DP[start] = 0;
        queue.add(new Node(start, 0));

        boolean[] visited = new boolean[V + 1]; // 방문을 검사하면 속도개선
        Arrays.fill(visited, false);
        while (!queue.isEmpty()) {
            Node a = queue.poll();
            int now = a.to;
            int nowCost = a.weight;

            if (nowCost > DP[now])
                continue;

            /*
             * if(visited[now] == true) continue; // 문제상황을 잘 고려해야함
             * visited[now] = false;
             */

            for (Node e : adj[now]) {
                int next = e.to;
                int nextCost = e.weight + DP[now]; // 다음노드까지 거리 + 본인까지의 최단거리
                if (nextCost < DP[next]) { // 다음노드의 최단거리를 확인해줌
                    DP[next] = nextCost;
                    queue.add(new Node(next, nextCost));
                }
            }
        }

    }
}
