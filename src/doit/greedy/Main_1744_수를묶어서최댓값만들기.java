package doit.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1744_수를묶어서최댓값만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder()); // 양수
        PriorityQueue<Integer> minusQue = new PriorityQueue<>(); // 음수
        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                zero++;
            } else if(num == 1) {
                one++;
            } else if(num<0) {
                minusQue.add(num);
            } else {
                que.add(num);
            }
        }

        int sum = 0;
        while(que.size()>1){
            sum += que.poll() * que.poll();
        }
        if(!que.isEmpty()){
            sum += que.poll();
        }

        while(minusQue.size()>1){
            sum += minusQue.poll() * minusQue.poll();
        }
        if(!minusQue.isEmpty()){
            if(zero == 0){
                sum += minusQue.poll();
            }
        }

        sum += one;

        System.out.println(sum);
    }
}
