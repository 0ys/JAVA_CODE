package doit.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_스택으로오름차순수열만들기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuffer bf = new StringBuffer();

        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;

        for(int i=0; i<N; i++){
            int a = A[i]; // 현재 수열의 값
            if(a >= num) {
                while(a >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                int n = stack.pop();
                if(n > a){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
