package doit.tree;

import java.util.*;

public class Main_11437_최소공통조상구하기1 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];

        BFS(1);

        int M = sc.nextInt();
        for(int i = 1; i <= M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(LCA(a, b));
        }
    }

    static int LCA(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]){
            a = parent[a];
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        int level = 1;
        int nowSize = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : tree[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            cnt++;
            if(cnt == nowSize){
                cnt = 0;
                nowSize = q.size();
                level++;
            }
        }
    }
}
