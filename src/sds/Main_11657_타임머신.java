package sds;

import java.util.*;
import java.io.*;

public class Main_11657_타임머신 {

    static class Node {
        int from, to, time;

        public Node(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    static int N, M;
    static long[] DP; // long으로 선언
    /*
     * 한번 돌 때, 도시의 개수 500 * 버스 노선의 개수 6,000
     * 그리고 시간 C가 10,000이므로
     * 3,000,000 * 10,000 = 30,000,000,000
     * 20억을 넘어가기 때문에 int를 사용할 수 없다. -> long으로 선언
     */
    static ArrayList<Node> adj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DP = new long[N + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
//		for(int i=1; i<=N; i++) { // 위의 코드랑 같은 역할
//			DP[i] = Integer.MAX_VALUE;
//		}

        adj = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj.add(new Node(A, B, C));
        }

        // bellman ford
        boolean checked = false;
        DP[1] = 0;
        for(int i=1; i<=N; i++) {
            for(Node e : adj) {
                int start = e.from;
                int end = e.to;
                int time = e.time;

                if(DP[start] != Integer.MAX_VALUE && DP[start]+time < DP[end]) {
                    DP[end] = DP[start] + time;

                    if(i==N) // 음수사이클이 존재함
                        checked = true;
                }
            }
        }
        if(checked) {
            bw.write("-1");
        } else {
            for(int i=2; i<=N; i++) {
                if(DP[i] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(DP[i]+"\n");
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }

}
