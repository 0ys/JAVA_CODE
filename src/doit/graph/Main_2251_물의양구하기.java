package doit.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2251_물의양구하기 {
    static class AB {
        int A, B; // A,B 물통의 양
        public AB (int A, int B){
            this.A = A;
            this.B = B;
        }
    }
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean visited[][];
    static int now[];
    static boolean answer[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3]; // 주어진 물통의 양을 저장하는 배열
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201]; // 방문한 조합을 체크함
        answer = new boolean[201];

        BFS();
        for(int i=0; i<answer.length; i++){
            if(answer[i]) System.out.print(i+" ");
        }
    }

    static void BFS(){
        Queue<AB> que = new LinkedList<>();
        que.add(new AB(0,0));
        visited[0][0] =true;
        answer[now[2]] = true;

        while(!que.isEmpty()){
            AB p = que.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for(int k=0; k<6; k++){
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if(next[Receiver[k]] > now[Receiver[k]]){ // 물이 넘칠 때
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]]; // 초과하는 만큼 이전 물통에 넣어 줌
                    next[Receiver[k]] = now[Receiver[k]]; // 대상 물통은 최대로 채워 줌
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    que.add(new AB(next[0], next[1]));
                    if(next[0] == 0){
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}
