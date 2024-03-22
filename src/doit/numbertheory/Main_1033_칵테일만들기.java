package doit.numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1033_칵테일만들기 {
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static long[] DP;
    static long lcm;

    static class Node {
        int b, p, q;
        public Node(int b, int p, int q){
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        visited = new boolean[N];
        DP = new long[N];
        lcm = 1;
        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, p, q));
            adj[b].add(new Node(a, q, p));
            lcm *= (p*q / gcd(p,q));
        }

        DP[0] = lcm;
        DFS(0);
        long mgcd = DP[0];
        for(int i=1; i<N; i++){
            mgcd = gcd(mgcd, DP[i]);
        }
        for(int i=0; i<N; i++){
            System.out.print(DP[i]/mgcd + " ");
        }

    }
    static void DFS(int n) {
        visited[n] = true;
        for(Node e : adj[n]){
            int next = e.b;
            if(!visited[next]) {
                DP[next] = DP[n]*e.q/e.p;
                DFS(next);
            }
        }
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
