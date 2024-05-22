package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(!pq.isEmpty()) System.out.println(pq.poll());
                else System.out.println(0);
            } else {
                pq.add(x);
            }
        }

    }
}
