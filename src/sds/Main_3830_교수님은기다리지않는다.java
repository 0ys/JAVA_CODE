package sds;

import java.io.*;
import java.util.*;

public class Main_3830_교수님은기다리지않는다 {
    public static int[] parent, weight;
    public static int N, M;
    public static void main(String[] args) throws Exception {
//		InputStream fileInput = new FileInputStream("input.txt");
//		System.setIn(fileInput);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }
            weight = new int[N+1];

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                String condition = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(condition.equals("!")) {
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                }else {
                    if(find(a) != find(b)) {
                        bw.write("UNKNOWN\n");
                    } else {
                        bw.write((weight[b]-weight[a]) +"\n");
                    }
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b, int w) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
        weight[bRoot] += (w + weight[a]-weight[b]);
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        int temp = find(parent[a]);
        weight[a] += weight[parent[a]];
        return parent[a] = temp;

    }
}
