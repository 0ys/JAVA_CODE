package doit.datastructure;

import java.io.*;
import java.util.*;

public class Main_11003_최솟값찾기 {
    // 정렬을 사용하지 않고도, 슬라이딩 윈도우와 deque를 이용해 O(n)만에 정렬 효과를 볼 수 있음
    static Deque<Node> deque;
    static class Node {
        int index, value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            
            // 뒤에서부터 삭제 : 새로 들어오는 값보다 큰 노드는 덱에서 삭제함
            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            deque.addLast(new Node(i, now));
            
            // 앞에서부터 삭제 : 윈도우 크기를 벗어나는 인덱스를 삭제함
            if(deque.getFirst().index<i-L+1){
                deque.removeFirst();
            }
            
            // 최솟값은 항상 덱의 맨 앞에 위치하게 됨
            bw.write(deque.getFirst().value+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
