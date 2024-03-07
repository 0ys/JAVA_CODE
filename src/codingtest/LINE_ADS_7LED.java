package codingtest;

import java.util.ArrayList;
import java.util.Arrays;

/*
2024 LINE ADS AI/ML 인턴십 코딩테스트 2번 문제

7-LED로 시계를 표현한다.

  A
F   B
  G
E   C
  D

0 = A, B, C, D, E, F
1 = B, c
2 = A, B, D, E, G
...

다른 스위치가 켜지는 건 허용하지 않는다.

숫자를 표시할 때, 각 LED를 스위치에 연결해서 표시한다고 한다.
필요한 스위치 개수의 최솟값을 구하라.

예를 들어, 3839를 표시할 때는 ABCDG를 한 스위치로 사용할 수 있으므로 필요한 스위치는 3개가 된다.

arr=[3839, 2] -> result=[3, 1]
arr=[29471500, 6813427] -> result=[7, 7]
 */

public class LINE_ADS_7LED {
    public static int[] solution(String[] arr) {
        int len = arr.length;
        int[] answer = new int[len];

        String[][] initLED = {
                {"A", "B", "C", "D", "E", "F"},
                {"B", "C"},
                {"A", "B", "D", "E", "G"},
                {"A", "B", "C", "D", "G"},
                {"B", "C", "F", "G"},
                {"A", "C", "D", "F", "G"},
                {"A", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "F"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "F", "G"}};

        ArrayList<String>[] led = new ArrayList[10]; // init LED 위치
        for(int i=0; i<10; i++){
            led[i] = new ArrayList<>(Arrays.asList(initLED[i]));
        }

        for(int i=0; i<len; i++){
            ArrayList<String> inter = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G")); // 교집합 초기화

            String numString = arr[i];
            int maxSwitchNum = 0; // 이번 턴에 필요한 스위치의 개수
            for(int j=0; j<numString.length(); j++){
                int num = numString.charAt(j) - '0';

                maxSwitchNum = Math.max(maxSwitchNum, led[num].size());
                inter.retainAll(led[num]); // LED 위치들간의 교집합을 구함
            }

            int switchNum = 0;
            if(inter.isEmpty()){ // 만약 교집합이 없다면, 모든 스위치를 켜야함
                switchNum = 7;
            } else { // 교집합이 존재한다면 공통 스위치를 사용할 수 있음
                switchNum = maxSwitchNum - inter.size() + 1;
            }
            answer[i] = switchNum;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"3839", "2"};

        int[] result = solution(arr);

        for(Integer r : result){
            System.out.print(r+" ");
        }
    }
}
