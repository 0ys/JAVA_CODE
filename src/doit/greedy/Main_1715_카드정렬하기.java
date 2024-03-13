package doit.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            que.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(que.size()>1){
            int card = que.poll() + que.poll();
            sum += card;
            que.add(card);
        }

        System.out.println(sum);
    }
}
