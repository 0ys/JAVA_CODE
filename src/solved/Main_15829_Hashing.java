package solved;

import java.util.Scanner;
/*
파이썬의 경우 수 범위가 무한이기 때문에 나머지 연산을 그냥 사용하면 되지만,
그 외 언어를 쓴다면 나머지 연산을 주의해서 사용해야 한다.
즉 31^50을 구할 때 이 엄청난 범위의 수를 담아낼 자료형이 없어 오버플로우가 발생할 수 있다.

나머지 연산의 분배 법칙은 (A * B) % m = (A % m) * (B % m) % m 과 같다.
r의 거듭제곱 수를 구할 때 마다 나머지 연산을 수행해줘야 int 범위 내에서 문제를 해결할 수 있다.
 */
public class Main_15829_Hashing {
    static int M = 1234567891;
    static int r = 31;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] input = sc.next().toCharArray();

        long hashing = 0;
        long mod = 1;
        for(int i = 0; i < n; i++){
            int a = input[i] - 'a' + 1;
            hashing += a * mod;
            mod = (r * mod) % M;
        }
        System.out.println(hashing % M);
    }
}
