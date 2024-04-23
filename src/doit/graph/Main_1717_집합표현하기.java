package doit.graph;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1717_집합표현하기 {
    static int[] parent; // 대표 노드 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 0,1 check
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c == 0) Union(a, b);
            else if(c == 1){
                if(Find(a) == Find(b)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    public static void Union(int a, int b){
        int aRoot = Find(a);
        int bRoot = Find(b);
        parent[aRoot] = bRoot;
    }

    public static int Find(int a){
        if(parent[a] == a) return a;
        return parent[a] = Find(parent[a]);
    }
}
