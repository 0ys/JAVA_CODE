package doit.greedy;

import java.util.Scanner;

public class Main_1541_최솟값을만드는괄호배지찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");

        int answer = 0;
        for(int i=0; i<str.length; i++){
            int temp = Sum(str[i]);
            if(i==0) answer += temp;
            else answer -= temp;
        }

        System.out.println(answer);
    }

    static int Sum(String a){
        int sum = 0;
        // Dangling quantifier '+' : 문자열을 나누는 split 함수와 StringTokenizer에서 구분자로 .(dot), +, - 를 사용하면 에러 발생
        // 왜냐하면 ., +, -가 정규표현식에 사용되는 문자이기 때문이다. 단순 문자인 구분자로 사용하고 싶으면 escape를 해주자!
        // [+] 또는 \\+
        String[] temp = a.split("\\+");
        for(int i=0; i<temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
