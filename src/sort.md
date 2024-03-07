# 정렬 알고리즘

## 버블 정렬 Bubble O(N^2)
데이터의 인접 요소끼리 비교하고, swap 연산을 수행하며 정렬하는 방식이다.
```java
public class Main {
    public static void main(String[] args) {
        
        for (int i = 0; i < N - 1; i++) { // 모든 인접 데이터를 비교하여 swap
            for (int j = 0; j < N - 1 - i; j++) { // 정렬된 영역을 제외한 n-1-i 까지 반복 수행
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        
    }
}
```

## 선택 정렬 Selection O(N^2)
대상 데이터에서 가장 크거나 작은 데이터를 찾아가 선택을 반복하면서 정렬하는 방식이다.
즉, 최솟값 또는 최댓값을 찾고, 남은 정렬 부분의 가장 앞에 있는 데이터와 swap한다.
오름차순을 하고 싶으면 최솟값을 찾아서 맨 앞에서부터 쌓아주고, 내림차순을 하고싶으면 반대로 하면 된다.
```java
public class Main {
    public static void main(String[] args) { // 내림차순 정렬
        
        for(int i=0; i<N; i++){ // 0~N까지 하나씩 최댓값(최솟값)을 찾아서 정렬해줌
            int Max = i;
            for(int j=i+1; j<N; j++){ // 남은 정렬 중 Max를 찾음
                if(A[j] > A[Max]){
                    Max = j;
                }
            }
            if(A[i] < A[Max]){ // 남은 정렬 부분 중 가장 앞에 있는 데이터와 swap
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        
    }
}
```

## 삽입 정렬 Insertion O(N^2)
이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식이다.
적절한 삽입 위치를 탐색하는 부분에서 이진 탐색 등과 같은 탐색 알고리즘을 사용하면 시간 복잡도를 줄일 수 있다.
```java
public class Main {
    public static void main(String[] args) {
        
        for(int i=1; i<N; i++){ // 1번부터 정렬시작
            int insertPoint = i;
            int insertValue = A[i];
            for(int j=i-1; j>=0; j--){ // 0~i-1까지 정렬된 데이터 중 삽입할 위치를 찾음
                if(A[j] < insertValue){
                    insertPoint = j+1;
                    break;
                }
                if(j == 0){ // 예외처리 : 현재 insertValue가 가장 작음
                    insertPoint = 0;
                }
            }
            for(int j=i; j>insertPoint; j--){ // 삽입할 위치를 비우기 위해
                A[j] = A[j-1]; // 배열의 값을 뒤로 한칸씩 이동
            }
            A[index] = insertValue;
        }
        
    }
}
```

## 퀵 정렬 Quick O(NlogN) / 최악의 경우 O(N^2)
pivot 값을 선정해 해당 값을 기준으로 정렬하는 방식이다.
기준값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬한다.
코딩 테스트에서 자주 응용된다. 재귀 함수 형태로 직접 구현해보자.
```java
public class Main {
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
```

## 병합 정렬 Merge O(NlogN) [중요]
이미 정렬된 부분 집합들을 효율적으로 병합해 전체를 정렬하는 방식이다.
분할 정복 방식을 사용해 데이터를 분할하고, 분할한 집합을 정렬하며 합치는 알고리즘이다.
코딩 테스트의 정렬 관련 문제에서 자주 등장하며, 특히 2개의 그룹을 병합하는 원리는 알아야 한다.
* 2개의 그룹을 병합하는 과정
- 투 포인터 개념을 사용하여 왼쪽, 오른쪽 그룹을 병합한다. 
- 왼쪽 포인터와 오른쪽 포인터의 값을 비교하여 작은 값을 결과 배열에 추가하고 포인터를 오른쪽으로 1칸 이동한다. 
```java
public class Main {
    static void mergeSort(int s, int e) {
        if(e-s < 1) return; // 배열 한칸까지 재귀함수로 나누기
        int m = s + (e-s)/2;
        // 재귀 함수 : Divide
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i=s; i<=e; i++){
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m+1;
        // 두 그룹을 병합하는 로직 : Conquer
        // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 배열에 저장하고,
        // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
        while(index1<=m && index2<=e){
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while(index1<=m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2<=e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
```

## 기수 정렬 Radix O(kN) (k는 데이터의 자릿수)
데이터의 자릿수를 바탕으로 비교해 데이터를 정렬하는 방식이다.
10개의 큐를 사용하여 0~9까지의 자릿수를 기준으로 데이터를 저장한다.
기수 정렬은 시간 복잡도가 가장 짧은 정렬이기 때문에 만약 코딩 테스트에서 정렬해야 하는 데이터의 개수가 너무 많으면 생각해봐야함
아이디어는 간단하지만 구현이 조금 까다로움, 3같이 한 자릿수를 03으로 어떻게 표현할 것인가 등
```java
public class Main {
    // 구간 합을 이용하여 기수 정렬을 구현
    static void radixSort(int max_size) {
        int[] output = new int[N]; // 임시 정렬을 위한 배열
        int jarisu = 1; // 현재 자릿수를 표현하는 수
        int count = 0;
        while(count != max_size) { // 최대 자릿수만큼 반복
            int[] bucket = new int[10]; // 현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열
            for(int i=0; i<N; i++){
                // bucket의 배열 한 칸이 큐 하나와 같음
                bucket[(A[i]/jarisu)%10]++;
            }
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1]; // 합 배열을 이용해 output에 들어갈 index 계산
            }
            for(int i=N-1; i>=0; i--){ // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i]/jarisu)%10] - 1] = A[i];
                bucket[(A[i]/jarisu)%10]--;
            }
            for(int i=0; i<N; i++){
                A[i] = output[i]; // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
            }
            jarisu *= 10; // 자릿수 증가시키기
            count++;
        }
    }
}
```