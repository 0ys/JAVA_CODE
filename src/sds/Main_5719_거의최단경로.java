package sds;
import java.util.*;
import java.io.*;

public class Main_5719_거의최단경로 {
    static int[] DP;
    static ArrayList<Integer>[] path; // 각 지점까지의 최단경로로 가는 prev 노드를 저장함
    static boolean[][] checkShortest; // 최단경로에 포함되는 노드를 체크함
    static ArrayList<Node>[] adj;
    static int N, M;
    static final int MAX = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node arg0) {
            return this.cost - arg0.cost;
        }
    }
    public static void main(String[] args) throws Exception{
//		InputStream fileInput = new FileInputStream("input.txt");
//		System.setIn(fileInput);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            DP = new int[N];
            adj = new ArrayList[N]; // 문제에서 0번부터 N-1번 노드까지 있음
            path = new ArrayList[N];
            for(int i=0; i<N; i++) {
                adj[i] = new ArrayList<>();
                path[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                adj[u].add(new Node(v, p));
            }

            // printGraph();

            checkShortest = new boolean[N][N];
            dijkstra(S);

            // printPath();
            checkPath(S, D); // S에서 D로 가는 경로 중 최단 경로에 포함되는 것을 찾음
            // printCheckShortest();
            dijkstra(S);
            // printDP();

            bw.write(""+(DP[D]==MAX ? -1 : DP[D]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void checkPath(int start, int end) { // start에서 end까지의 경로 중 최단 경로 표시
        if(start == end) return;
        for(Integer n : path[end]) {
            if(!checkShortest[n][end]) {
                checkShortest[n][end] = true;
                checkPath(start, n); // 백트래킹
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(DP, MAX);
        DP[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node a = pq.poll();
            int now = a.to;
            int nowCost = a.cost;

            if(nowCost>DP[now]) continue;

            for(Node e : adj[now]) {
                int next = e.to;
                int nextCost = e.cost + DP[now];
                if(checkShortest[now][next]) {
                    continue;
                }
                if(nextCost < DP[next]) {
                    DP[next] = nextCost;
                    path[next] = new ArrayList<>();
                    path[next].add(now);
                    pq.add(new Node(next, nextCost));
                } else if(nextCost == DP[next]) {
                    path[next].add(now);
                }
            }
        }
    }
    static void printGraph() {
        // 그래프 확인
        for(int i=0; i<N; i++) {
            System.out.print("node "+i);
            for(int j=0; j<adj[i].size(); j++) {
                System.out.print(" -> "+adj[i].get(j).to+"("+adj[i].get(j).cost+")");
            }
            System.out.println();
        }
    }

    static void printPath() {
        // 각 노드의 최단경로에 있는 prev 노드 출력
        for(int i=0; i<N; i++) {
            System.out.println(i+" : "+path[i]);
        }
    }

    static void printCheckShortest() {
        // checkShortest 확인
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(checkShortest[i][j] +" ");
            }
            System.out.println();
        }
    }

    static void printDP() {
        for (int i = 0; i < N; i++) {
            if (DP[i] == MAX) {
                System.out.print("INF ");
            } else {
                System.out.print(DP[i]+ " ");
            }
        }
        System.out.println();
    }
}
