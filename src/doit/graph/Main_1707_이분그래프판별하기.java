package doit.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707_이분그래프판별하기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int tc=0; tc<K; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new boolean[V+1];
            check = new int[V+1];
            adj = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }
            isEven = true;
            for(int i=1; i<=V; i++){
                if(!isEven) break;
                DFS(i);
            }

            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void DFS(int now){
        visited[now] = true;

        for(int next: adj[now]){
            if(!visited[next]) {
                check[next] = (check[now]+1) % 2;
                DFS(next);
            } else if(check[next] == check[now]){
                isEven = false;
            }
        }
    }
}
