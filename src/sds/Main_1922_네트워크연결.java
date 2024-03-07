package sds;
import java.util.*;
import java.io.*;

public class Main_1922_네트워크연결 {

    static class Computer implements Comparable<Computer>{
        int from, to, cost;
        Computer(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Computer arg0) {
            return this.cost - arg0.cost;
        }
    }

    static int N, M;
    static ArrayList<Computer> kruskalGraph;
    static int[] parents; // 크루스칼에서 사용하는 Union Find 부모 노드 저장

    static ArrayList<Computer>[] primGraph;

    public static void main(String[] args) throws Exception {
        InputStream fileInput = new FileInputStream("input.txt");
        System.setIn(fileInput);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        primGraph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            primGraph[i] = new ArrayList<>();
        }

        kruskalGraph = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            kruskalGraph.add(new Computer(a, b, c));
            primGraph[a].add(new Computer(a, b, c)); //양방향
            primGraph[b].add(new Computer(b, a, c));
        }

        for (int i = 1; i <= N; i++) {
            System.out.print("node " + i);
            for (int j = 0; j < primGraph[i].size(); j++) {
                System.out.print(" -> " + primGraph[i].get(j).to + "(" + primGraph[i].get(j).cost + ")");
            }
            System.out.println();
        }

		bw.write(kruskal()+"\n");
        bw.write(prim(1)+"");

        bw.flush();
        bw.close();
        br.close();
    }

    static int prim(int a) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(a, a, 0));

        boolean visited[] = new boolean[N+1];

        int answer = 0;
        while(!pq.isEmpty()) {
            Computer c = pq.poll();
            int now = c.to;
            int value = c.cost;

            if(visited[now]) continue;
            visited[now] = true;
            answer += value;

            for(Computer e : primGraph[now]) {
                if(!visited[e.to]) {
                    pq.add(e);
                    /*
                     * 연결된 노드 중 방문하지 않은 노드를 우선순위 큐에 넣음
                     * 우선순위 큐는 가중치를 기준으로 오름차순으로 정렬함
                     */
                }
            }
        }

        return answer;
    }

    static int kruskal() {
        parents = new int[N+1];

        for(int i=1; i<=N; i++) {
            parents[i] = i;
        }

        Collections.sort(kruskalGraph); // 가중치를 기준으로 오름차순 정렬

        int answer = 0;
        for(Computer e : kruskalGraph) {
            int start = e.from;
            int end = e.to;
            int value = e.cost;

            if(find(start) == find(end)) continue; //cycle 검사
            answer += value;
            union(start, end); // 노드를 연결해줌
        }

        return answer;

    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parents[bRoot] = aRoot;
    }

    static int find(int a) { // 부모노드를 찾음
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
