package doit.graph;

import java.io.*;
import java.util.*;

public class Main_17472_다리만들기 {
    static int N, M;
    static int[][] maps;
    static boolean[][] visited;
    // (1,0) (0,1) (0,-1) (-1,0)
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, 1, -1, 0 };

    static int islandNum = 1; // 섬의 개수 카운트
    static ArrayList<ArrayList<int[]>> islands; // 각 섬의 좌표를 저장

    static PriorityQueue<Edge> edges;
    static int[] parents;
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islands = new ArrayList();
        islands.add(new ArrayList()); // 존재하지 않는 0번 배열을 허구로 추가해줌
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || maps[i][j] == 0) continue;
                // 맵에서 섬을 찾으면, 붙어있는 땅을 확인하면서 각 섬의 좌표를 저장함
                islands.add(new ArrayList<>());
                findIsland(i, j);
                islandNum++;
            }
        }
        // printMaps();

        edges = new PriorityQueue<>();
        for(int i = 1; i < islandNum; i++){ // 각 섬을 이어주는 다리를 찾음
            // System.out.println(i+"번 섬의 좌표들");
            for(int[] island : islands.get(i)) {
                // System.out.println(island[0]+" "+island[1]);
                findBridge(i, island[0], island[1]);
            }
        }

        parents = new int[islandNum]; // islandNum = 실제 섬 개수 + 1
        for(int i = 1; i < islandNum; i++) {
            parents[i] = i;
        }

        int edgeCnt = 0;
        int answer = 0;
        while(!edges.isEmpty()) {
            if(edgeCnt == islandNum-1) break;

            Edge cur = edges.poll();
            int u = cur.u;
            int v = cur.v;
            int w = cur.w;

            if(Find(u) != Find(v)) {
                Union(u, v);
                edgeCnt++;
                answer += w;
            }
        }

        if(edgeCnt == islandNum - 2) System.out.println(answer);
        else System.out.println(-1);
    }

    public static void findIsland(int u, int v) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{u, v});
        visited[u][v] = true;
        maps[u][v] = islandNum;
        islands.get(islandNum).add(new int[]{u, v});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                    if(!visited[nextX][nextY] && maps[nextX][nextY] == 1) { // 방문한 적 없는 새로운 섬일 경우 i번째 섬 리스트에 추가해줌
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] = islandNum;
                        islands.get(islandNum).add(new int[]{nextX, nextY});
                        q.add(new int[]{nextX, nextY}); // 다음 탐색 범위로 저장
                    }

                }
            }

        }
    }

    public static void findBridge(int now, int u, int v) {
        for(int i = 0; i < 4; i++){ // 네 방향으로 다리를 확인함
            int cost = 0; // 다리 길이
            int nextX = u + dx[i];
            int nextY = v + dy[i];

            while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if(maps[nextX][nextY] == now) break; // 같은 섬일 땐 종료함
                else if(maps[nextX][nextY] != 0){ // 다른 섬에 도착했을 때
                    if(cost > 1) { // 다리 길이가 2이상이면 에지 리스트에 저장함
                        edges.add(new Edge(now, maps[nextX][nextY], cost));
                    }
                    break;
                } else { // 바다일 때는 다리의 길이를 늘려줌
                    cost++;
                }
                nextX = nextX + dx[i];
                nextY = nextY + dy[i];
            }
        }

    }

    public static void Union(int a, int b){
        int aRoot = Find(a);
        int bRoot = Find(b);
        if(aRoot != bRoot) parents[aRoot] = bRoot;
    }

    public static int Find(int x){
        if(parents[x] == x) return x;
        return parents[x] = Find(parents[x]);
    }
    
    public static void printMaps() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(maps[i][j]+" ");
            }
            System.out.println();
        }
    }
}
