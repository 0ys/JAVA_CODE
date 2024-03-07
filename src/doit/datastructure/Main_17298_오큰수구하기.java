package doit.datastructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수구하기 {
    // 인덱스를 스택에 저장함
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // stack init
        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++){
            bw.write(ans[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
