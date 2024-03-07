package codingtest;

/*
2024 LINE ADS AI/ML 인턴십 코딩테스트 1번 문제

n개의 로봇이 작업을 한다.
작업의 크기는 s, 반복 횟수는 k(1<=k<=9)이다.
동일한 작업은 이어붙일 수 있다. 이 때 이어 붙이는 작업의 개수만큰 작업의 시간이 늘어난다.
즉, 동일한 작업을 t만큼 이어 붙이면 작업 시간은 s^t로 늘어난다.

tasks는 반복횟수 k와 이어붙이는 작업 t의 문자열로 주어진다.
주어진 시간 내에 작업이 가능한 경우 1, 불가능한 경우 0을 출력하라.

예를 들어, 작업 시간이 10일 때 3x10x10 = 300 <= 300이므로 결과는 1이다.

sizes=[10, 2, 13, 1] , limits=[300, 31, 100, 5] , tasks=["3tt", "4ttt", "8t", "4tttt"] -> result=[1, 0, 0, 1]
sizes=[100 100 100] , limits=[1000000000, 100, 3] , tasks=["9tttt", "1t", "4"] -> result=[1, 1, 0]
 */

public class LINE_ADS {
    public static int[] solution(int[] sizes, int[] limits, String[] tasks){
        int[] answer = new int[sizes.length];

        for(int i=0; i< sizes.length; i++){
            String task = tasks[i];
            int num = task.charAt(0) - '0'; // 반복횟수

            int tCnt = 0; // 이어 붙인 작업의 개수
            for(int j=1; j<task.length(); j++){
                tCnt++;
            }

            int size = 1; // 이어 붙인 작업의 크기
            for(int k=0; k<tCnt; k++){
                size *= sizes[i];
            }

            if(size*num <= limits[i]){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sizes = new int[]{10, 2, 13, 1};
        int[] limits = new int[]{300, 31, 100, 5};
        String[] tasks = new String[]{"3tt", "4ttt", "8t", "4tttt"};

        int[] result = solution(sizes, limits, tasks);

        for(Integer r : result){
            System.out.print(r+" ");
        }
    }
}
