package doit.numbertheory;

import java.util.Scanner;

public class Main_1747_소수팰린드롬수중에서최솟값찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int MAX = 10000001; // N 보다 큰 수를 담아야 하므로 N의 최대 범위보다 큰 수로 정의함
        int[] prime = new int[MAX];
        for(int i=2; i<MAX; i++){
            prime[i] = i;
        }

        for(int i=2; i<Math.sqrt(MAX); i++){
            if(prime[i] == 0) continue;
            for (int j=i+i; j<MAX; j+=i){
                prime[j] = 0;
            }
        }

        int i = N;
        while(true){
            if(prime[i] != 0){ // 소수이면서
                int result = prime[i];
                if(isPalindrome(result)){ // 팰린드롬 수 일 때
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target){
        char[] temp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length -1;
        while(s<e){
            if(temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
