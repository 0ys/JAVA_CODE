package doit.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11004_k번째수구하기 {
    static int N, K;
    static int[] A;
    public static void main(String[] args) throws Exception {
        // N이 5,000,000이므로 시간 복잡도에 주의
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1; // 배열이 0번부터 시작하므로 -1 해줌

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort(A);
        quickSort(0, N-1);

        System.out.println(A[K]);
    }

    // 재귀함수로 구현
    static void quickSort(int start, int end) {
        if(start < end) {
            int pivot = partition(start, end); // pivot을 기준으로 왼쪽(작은 수), 오른쪽(큰 수)으로 정렬
            if(pivot == K) return;
            else if (K < pivot) {
                quickSort(start, pivot-1); // K가 pivot보다 작으면 왼쪽 그룹만 정렬
            } else {
                quickSort(pivot+1, end); // K가 pivot보다 크면 오른쪽 그룹만 정렬
            }
        }
    }

    static void swap(int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int partition(int start, int end){
        if(start+1 == end) { // 예외처리 : 배열의 크기가 2일 경우, 그냥 정렬
            if(A[start] > A[end]) swap(start, end);
            return end;
        }

        int M = (start + end) / 2; // 중앙값을 pivot으로 설정
        swap(start, M); // 기준값을 1번째 요소로 이동
        int pivot = A[start];
        int i = start+1, j = end;
        while(i<=j){
            while(A[i]<pivot && i<=end){
                i++;
            }
            while(A[j]>pivot && j>=start+1){
                j--;
            }
            if(i <= j){
                swap(i++, j--); // 큰 수는 오른쪽으로 작은 수는 왼쪽으로
            }
        } // i와 j가 교차할 때까지 수행
        A[start] = A[j]; // 첫 번째 자리에 있는 pivot과 j 번째를 교체
        A[j] = pivot; // pivot이 중앙에 위치하게 됨

        return j; // pivot의 자리를 리턴
    }
}
