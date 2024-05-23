package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int now = 1;
        while(now <= 100){
            int cur = q.poll();

            for(int dice = 1; dice < 6; dice++){
                int next = now + dice;
                if(board[next] == 0){
                    visited[next] = true;
                    board[next] = cur+1;
                } else {
                    if(!visited[board[next]]){
                        visited[board[next]] = true;
                    }
                }
            }
        }

    }
}
