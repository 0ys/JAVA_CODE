package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
    static int[] board = new int[101];
    static int[] check = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 101; i++) { // 자기 자신을 향하도록 초기화
            board[i] = i;
        }

        for(int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; // 뱀과 사다리 입력받음
        }
        BFS(1);
        System.out.println(check[100]);
    }
    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = 0;
        int now = 1;
        while(now < 100){
            int cur = q.poll();

            for(int dice = 1; dice <= 6; dice++){
                int next = cur + dice;
                if(next > 100) continue;

                if(check[board[next]] == 0){
                    check[board[next]] = check[cur]+1;
                    now = Math.max(now, board[next]);
                    q.add(board[next]);
                }
            }
            printBoard();
        }
    }

    static void printBoard() {
        for(int i = 1; i < 101; i++) {
            System.out.print(check[i] + " ");
            if(i % 10 == 0) System.out.print("\n");
        }
        System.out.println("--------------");
    }
}
