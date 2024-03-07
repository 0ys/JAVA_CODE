package sds;

import java.io.*;
import java.util.*;

public class Main_1717_집합의표현 {
    static int[] parent;
    static int N, M;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        // initialize
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        int condition, a, b;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            condition = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(condition==0) {
                union(a, b);
            }
            else {
                if(find(a)==find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
