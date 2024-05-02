package doit.graph;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
    static int N, M;
    static int[][] DP;
    static class Person implements Comparable<Person> {
        int index, kbNum;
        public Person(int index, int kbNum) {
            this.index = index;
            this.kbNum = kbNum;
        }

        @Override
        public int compareTo(Person o) {
            if(this.kbNum == o.kbNum) return this.index - o.index;
            return this.kbNum - o.kbNum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DP = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i==j) DP[i][j] = 0;
                else DP[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            DP[a][b] = 1;
            DP[b][a] = 1;
        }
        //printDP();

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(DP[i][k] != Integer.MAX_VALUE && DP[k][j] != Integer.MAX_VALUE){
                        DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);
                    }
                }
            }
        }

        //printDP();

        PriorityQueue<Person> que = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            int num = 0;
            for(int j = 1; j <= N; j++){
                num += DP[i][j];
            }
            que.add(new Person(i, num));
        }

        System.out.println(que.peek().index);
    }

    public static void printDP(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
}
