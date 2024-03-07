package sds;
import java.io.*;
import java.util.*;

// 11438 LCA 2
public class Main_11438_LCA2 {

    static int[] depth;
    static int[][] parents; // parents[K][V]는 정점 V의 2^K번째 조상
    /*
     * LCA 점화식
     * parents[K][V] = parents[K-1][parents[K-1][V]];
     */
    static int N, M, K;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws Exception{
        //InputStream fileInput = new FileInputStream("input.txt");
        //System.setIn(fileInput);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        /*
         * 2^K >= N인 첫번째 K 찾기 (N>=2)
         * N이 17이면, 2^4번째 조상까지 기록 -> 17 = 2^4 + 2^0;
         * N이 16이면, 2^4번째 조상까지 기록 -> 16 = 2^4;
         * N이 15이면, 2^3번째 조상까지 기록 -> 15 = 2^3 + 2^2 + 2^1;
         */
        // 보통 K = 18 로 하면 거의 다 처리할 수 있지만, 효율적이게 N까지 구함
        K = -1;
        for(int i=1; i<=N; i*=2) {
            K++;
        }

        depth = new int[N + 1];
        parents = new int[K + 1][N + 1];
        tree = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) { // 트리초기화
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) { // 트리에 정점을 연결
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[v].add(w);
            tree[w].add(v);
        }
        // printTree();

        // init(1, 1, 0);
        BFS(1);
        // printParents();
        fillParents();
        // printParents();

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(LCA(a, b)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // DFS로 depth 확인, 0번째 부모를 채움
    static void init(int current, int height, int parent) {
        depth[current] = height;
        for(int next : tree[current]) {
            if(next != parent) {
                init(next, height+1, current);
                parents[0][next] = current;
            }
        }
    }

    // BFS로 depth확인 및 0번째 부모를 채움
    static void BFS(int root) {
        Queue<Integer> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int now = que.poll();

            for(int next : tree[now]) {
                if(next==1 || parents[0][next] != 0) continue;
                parents[0][next] = now;
                depth[next] = depth[now]+1;
//				System.out.println(next + " " +depth[next]);
                que.add(next);
            }
        }
    }

    // 2^K 부모 채우기
    static void fillParents() {
        for(int i=1; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                // parents[K][V] = parents[K-1][parents[K-1][V]];
                parents[i][j] = parents[i-1][parents[i-1][j]];
            }
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        if(ah < bh) { // ah > bh로 세팅
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 1. depth 맞추기
        // 더 깊은 a를 2^K승 점프하여 depth를 맞춘다.
        // 깊이의 차보다 작은, 가장 큰 2의 제곱수로 점프
        // Math.pow(2,  i) == 1 << i
        for(int i=K; i>=0; i--) {
            if(Math.pow(2,  i) <= depth[a] - depth[b]) {
                a = parents[i][a];
            }
        }

        //depth를 맞췄는데 조상이 같으면 바로 종료
        if(a==b) return a;

        // 2. LCA 찾기 : 2^K승 점프를 하면서 공통부모 바로 아래까지 올리기
        for(int i=K-1; i>=0; i--) {
            if(parents[i][a] != parents[i][b]) {
                a = parents[i][a];
                b = parents[i][b];
            }
        }
        // 공통부모 바로 아래에서 반복문이 끝났으므로, 첫 번째 부모(2^0)을 리턴
        return parents[0][a];
    }


    static int getTreeHeight() { // 수학 공식으로 트리의 높이를 구할 수도 있음
        return (int)Math.ceil(Math.log(N)/Math.log(2)) + 1;
    }

    static void printTree() {
        for(int i=1; i<=N; i++) {
            System.out.print("node "+i);
            for(int j=0; j<tree[i].size(); j++) {
                System.out.print(" -> "+tree[i].get(j));
            }
            System.out.println();
        }
    }

    static void printParents() {
        for(int i=0; i<=K; i++) {
            for(int j=0; j<=N; j++) {
                System.out.print(parents[i][j]+" ");
            }
            System.out.println();
        }
    }

}