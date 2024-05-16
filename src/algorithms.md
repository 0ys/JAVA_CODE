# 목차
- [알고리즘](#알고리즘)
- [자바 형변환](#자바에서의-형변환)
- [정렬](#정렬)
   * [라이브러리를 이용한 정렬](#라이브러리를-이용한-정렬)
   * [병합 정렬](#병합-정렬-분할-정복-divide-and-conquer-onlogn)
- [탐색](#탐색)
   * [합 배열](#합-배열)
   * [2 Pointers O(N)](#2-pointers-on)
   * [슬라이딩 윈도우 O(N)](#슬라이딩-윈도우-on)
   * [Lower & Upper Bound O(logN)](#lower--upper-bound-ologn)
   * [깊이 우선 탐색 DFS O(V+E)](#깊이-우선-탐색-dfs-ove)
   * [너비 우선 탐색 BFS O(V+E)](#너비-우선-탐색-bfs-ove)
   * [이진 탐색 O(logN)](#이진-탐색-ologn)
   * [우선순위 큐 O(NlogN)](#우선순위-큐-priority-queue--onlogn)
- [정수론](#정수론)
   * [에라토스테네스의 체](#에라토스테네스의-체)
   * [팰린드롬 수](#팰린드롬-수)
   * [오일러 피](#오일러-피)
   * [유클리드 호제법](#유클리드-호제법)
   * [확장 유클리드 호제법](#확장-유클리드-호제법-베주-항등식-bezouts-identity)
- [조합](#조합)
- [그래프](#그래프)
   * [그래프의 표현](#그래프의-표현)
   * [유니온파인드](#유니온파인드)
   * [위상정렬 O(V+E)](#위상정렬-ove)
   * [다익스트라 O(ElogV)](#다익스트라-oelogv)
   * [벨만-포드 O(VE)](#벨만-포드-ove)
   * [플로이드-워셜 O(V^3)](#플로이드-워셜-ov3)
   * [최소 신장 트리(MST)](#최소-신장-트리-mst-minimum-spanning-tree)
- [트리](#트리)
   * [코딩 테스트에서 트리 문제 유형](#코딩-테스트에서-트리-문제-유형)
   * [이진 트리](#이진-트리)
   * [트라이](#트라이)
   * [인덱스 트리 O(MlogN)](#인덱스-트리-omlogn)
   * [최소 공통 조상(LCA)](#최소-공통-조상-lca-lowest-common-ancestor)
- [기하(CCW)](#기하)

---
# 알고리즘
## 알고리즘 정리
|   구분    | 알고리즘              | 시간복잡도    | 구현 유형         | 사용 기법          |
|:---------:|:------------------|----------|---------------|----------------|
| 완전 탐색 | DFS               | N^2      | List, 배열      | stack, 재귀      |
|           | BFS               | N^2      | List, 배열      | Queue          |
|           | 백트래킹              |          | List, 배열      |                |
|  최적화   | 분할정복              | NlogN    | 배열            |                |
|           | 동적계획법 DP          | N        | 배열            | 메모제이션, <br>점화식 |
|           | 슬라이딩 윈도우          | N        | 배열, Deque     |                |
|           | Greedy            |          | List, 배열      |                |
| 자료구조  | 우선순위큐             | NlogN    | List          |                |
|           | Union Find        | N        | List, 배열      |                |
|           | 이진탐색              | logN     | 배열            |                |
|           | lower/upper bound | logN     | 배열            |                |
|   수학    | 유클리드 호제법          |          |               |                |
|           | 확장 유클리드 호제법       |          |               |                |
|           | 에라토스테네스의 체        |          |               |                |
|           | 파스칼의 삼각형          |          |               |                |


|       구분        | 알고리즘                    | 확장 알고리즘           | 시간복잡도 | 구현유형     | 사용기법              | 간선방향        |
|:---------------:|-------------------------|-------------------| ---------- |----------| --------------------- | --------------- |
|       트리        | LCA<br>(공통조상찾기)         |                   | NlogN      | List     |                       |                 |
|                 | 인덱스트리<br>(Segment Tree) | 펙웍트리(BIT)<br>Lazy Propagation | NlogN      | 배열       | 이진탐색              |                 |
|  그래프 <br>최단경로   | 다익스트라                   |                   | ElogV      | 인접 리스트   | 우선순위큐            | 방향,<br>무방향 |
|                 | 벨만포드                    |                   | VE         | 에지 리스트   | 완전탐색<br>음수가능  | 방향,<br>무방향 |
|                 | 플로이드-워셜                 |                   | V^3        | 인접 행렬    | 완전탐색<br>음수가능  | 방향,<br>무방향 |
| 최소신장<br>트리(MST) | 크루스칼 Kruscal            |                   | ElogV      | 에지 리스트   | 탐욕법,<br>UnionFind  | 무방향          |
|                 | 프림 Prim                 |                   | V^2        | List, 배열 | 탐욕법,<br>우선순위큐 | 무방향          |
|       그래프       | 위상정렬                    |                   | V+E        | List, 배열 | DAG                   | 방향            |
|                 | 단절점, 단절선                | 강한 연결 요소<br>- 타잔, 코사라주 | V+E        | List, 배열 |                       | 무방향          |


## 알고리즘 문제풀이 기초
- 히든케이스(Edge 검사) : 기본 테스트케이스 외에도 끝 값이나 시작 값으로 검사해보기
- 모든 테스트 케이스를 통과했는데도 틀린다면, 자료형을 고려!(int를 long으로)
- 20억이 넘어가면 자료형 long을 사용하자.
- 1억 연산은 1초를 의미한다. 즉, 만*만이 넘어가면 틀린거임
- 자바는 실수를 double을 기본으로 사용한다.
- int 배열은 1억건 이상 넘어가면 힘들다.
- `연산 횟수 = 알고리즘 시간 복잡도 * 데이터의 크기`
- 예를 들어, 시간제한이 2초(2억번 연산)일 때, 데이터가 1,000,000이라면 N*N은 사용할 수 없다.
- 100,000 이상의 데이터를 처리할 때 N*N 알고리즘은 어렵다.
- 1,000,000인 데이터를 처리할 때는 NlogN 알고리즘을 사용
- 5,000,000인 데이터일 경우, NlogN 알고리즘 사용 불가(단순 정렬은 가능)하므로 O(n) 알고리즘을 사용해야함

### 시간복잡도 문제 해결
1. 알맞은 알고리즘을 선택
   - 데이터와 시간 제한을 보고 그에 맞는 알고리즘을 선택해야 함
2. 내 코드를 살펴보기
   - 알고리즘이 맞았는데 시간초과가 나는 경우, 내 코드에 비효율적인 부분이 없는지 살펴봐야 함

#### 예시 : 제한시간이 1초일때
- N<=10 : N!, 2^N, 3^N
- N<=20 : 2^N
- N<=100 : N^4
- N<=500 : N^3
- N<=1,000 : N^2, N^2logN
- N<=100,000 : N, NlogN, logN, O(1)

# 자바에서의 형변환
```java
public class Main {
    public static void main(String[] args) {
        String sNum = "1234";
        int i1 = Integer.parseInt(sNum); // 4 byte : -2,147,483,648 ~ 2,147,483,647
        int i2 = Integer.valueOf(sNum);
        double d1 = Double.parseDouble(sNum);
        double d2 = Double.valueOf(sNum);
        float f1 = Float.parseFloat(sNum);
        float f2 = Float.valueOf(sNum);
        long l1 = Long.parseLong(sNum); // 8 byte
        long l2 = Long.valueOf(sNum);
        short s1 = Short.parseShort(sNum);
        short s2 = Short.valueOf(sNum);
        char c1 = sNum.charAt(0);

        int i3 = 1234;
        double d3 = 12.34;
        String sNum2 = String.valueOf(i3);
        String sNum3 = Integer.toString(i3);
        String sNum4 = String.valueOf(d3);
        String sNum5 = Double.toString(d3);
    }
}
```

# 정렬
## 정렬의 응용
1. 유일성 검사/ 중복 제거
   - Set도 같은 역할을 함 = treeSet(정렬이 되는 Set)
2. 빈도 구하기(logN)
   - lower bound ~ upper bound
3. 합집합/교집합 구하기
   - 2 pointers 알고리즘을 이용
4. 이분 탐색(log N) = priority queue
   1. Array.binarySearch를 사용
   2. N이 10만대이면 NlogN 알고리즘을 사용

## 라이브러리를 이용한 정렬
보통 퀵 정렬로 구현되어 있다. 시간 복잡도는 O(NlogN)이며 최악의 경우 O(N^2)이다.
```java
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
        // 1. 기본 Arrays Sort
        int[] A = new int[N];
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        // 2. Collections Sort
        ArrayList<Integer> A = new ArrayList<>();
        Collections.sort(A);
    }
}
```

## 병합 정렬 (=분할 정복 Divide and Conquer) O(NlogN)
분할 정복 방식을 사용해 데이터를 분할하고, 분할한 집합을 정렬하며 합친다.
코딩 테스트의 정렬 관련 문제에서 자주 등장하며, 특히 2개의 그룹을 병합하는 원리는 알아야 한다.
#### 2개의 그룹을 병합하는 과정
- 투 포인터 개념을 사용하여 왼쪽, 오른쪽 그룹을 병합한다.
- 왼쪽 포인터와 오른쪽 포인터의 값을 비교하여 작은 값을 결과 배열에 추가하고 포인터를 오른쪽으로 1칸 이동한다.
```java
public class DivideAndConquer {
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
---
# 탐색
## 합 배열
합 배열을 이용하여 특정 범위의 값들의 합(구간합)을 빠른 시간 안에 구할 수 있다.
합 배열을 미리 계산해두면 구간 합은 한 번의 계산으로 구할 수 있게 된다. 
다만 배열 A의 값이 계속 변화할 경우, 구간 합은 인덱스 트리를 활용해야 한다.

- 합 배열 S의 정의 : `S[i] = A[0] + A[1] + A[2] + ... + A[i-1] + A[i]`
- 합 배열 만드는 공식 : `S[i] = S[i-1] + A[i]`
- 구간 합 구하는 공식 : `S[j] - S[i-1]` // i에서 j까지 구간 합
- 2차원 구간 합 배열 D 정의 : `D[X][Y] = 원본 배열의 (0, 0)부터 (X, Y)까지의 사각형 영역 안에 있는 수의 합`
- `D[i][j]` 만드는 공식 : `D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]`
- 구간 합 구하는 공식 : `D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]`

```java
public class PrefixSumArray {
    static int N, M;
    public static void main(String[] args) {
        // 1차원 배열 구간 합 구하기
        long[] sum = new long[N+1];
        for(int i=1; i<=N; i++) {
            sum[i] += sum[i-1]+Integer.parseInt(st.nextToken());
        }

        int answer = sum[j]-sum[i-1];
        
        // 2차원 배열 구간 합 구하기
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
           for(int j=1; j<=N; j++){
              arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }

        int[][] sum = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
           for(int j=1; j<=N; j++){
              sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
           }
        }

        int answer = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
    }
}
```

## 2 Pointers O(N)
2개의 포인터로 알고리즘의 시간 복잡도를 최적화한다.
특히 시간 제한이 1초일 때, N의 최댓값이 5,000,000이면 O(N)의 시간 복잡도를 가진 알고리즘을 사용해야 하므로 투 포인터를 많이 쓴다.

- 정렬된 데이터를 빠르게 탐색
- 두 가지 배열의 교집합을 비교

1. 시작 인덱스와 종료 인덱스를 투 포인터로 지정함
   1. 보통 정렬된 데이터에 대해 양쪽 끝 값으로 지정하고 탐색하거나
   2. 또는 첫 번째 값을 동시에 가리키면서 차례로 이동해나가기도 함
2. 투 포인터 이동 원칙에 따라 배열의 끝까지 탐색함
   1. 예를 들어, 연속된 자연수의 합을 구할 때 투 포인터 이동 원칙은 아래와 같음
   2. startIndex와 endIndex를 첫 번째 인덱스 값으로 초기화함, endIndex == N까지 탐색함
   2. `sum > N : sum=sum-startIndex; startIndex++;`
   3. `sum < N : endIndex++; sum=sum+endIndex;`
   4. `sum == N : endIndex++; sum=sum+endIndex; count++;`
   5. 또는 두 데이터의 합을 구할 때 이동 원칙은 아래와 같음
   6. 투 포인터 i, j를 양쪽 끝에 위치시킨 후, i와 j가 만날 때까지 이동함
   6. `A[i] + A[j] > M; j--;'`
   7. `A[i] + A[j] < M; i++;`
   8. `A[i] + A[j] == M; i++; j--; count++;`

```java
public class TwoPointers {
    public static void main(String[] args) {
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int cnt = 0;
        while(start<end){
            int sum = arr[start]+arr[end];
            if(sum == M){
                cnt++;
                start++;
                end--;
            } else if(sum < M){
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);
    }
}
```

## 슬라이딩 윈도우 O(N)
슬라이딩 윈도우 알고리즘은 2개의 포인터로 범위(window)를 지정한 다음, window를 유지한 채로 이동(sliding)하여 문제를 해결한다.

 - 슬라이딩 윈도우인 부분 배열 P와 문제의 조건을 체크하는 상태 배열을 선언하여 윈도우가 이동할 때마다 상태 배열을 업데이트함
   - 현재 상태 배열을 업데이트할 때는 빠지는 데이터와 신규 데이터만 보고 업데이트하기 때문에 O(N)의 시간 복잡도를 가짐
   - ADD()와 REMOVE() 함수를 각각 조건에 맞게 구현할 수 있음
 - 데이터가 너무 커서 NlogN의 정렬을 사용할 수 없는 경우, 슬라이딩 윈도우를 deque로 구현하여 정렬 효과를 볼 수 있음
   - 예를 들어, 일정 범위 안의 최솟값을 찾는 문제에서 덱에 (인덱스, 숫자) 형태의 새 노드를 저장할 때,
   - 덱의 뒤에서부터 비교하여 저장된 노드의 숫자가 크면 removeLast() 하고 숫자가 작으면 addLast() 함
   - 이렇게 하면 덱에는 노드가 오름차순으로 정렬됨
   - 인덱스 범위가 슬라이딩 윈도우를 벗어날 경우 removeFirst()로 맨 앞 노드를 제거함

### Deque
덱은 양 끝에서 데이터를 삽입하거나 삭제할 수 있는 자료구조이다.
LinkedList와 ArrayDeque 모두로 구현할 수 있는데, ArrayDeque가 좀 더 유리하다.
ArrayDeque 공식문서에 보면 스택구조로 사용하면 Stack 클래스보다 빠르고, 큐 구조로 사용하면 Queue 클래스보다 빠르다.

- addFirst(), removeFirst()
- addLast(), removeLast()

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(2);
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
        deque.getFirst();
        deque.getLast();
        deque.peekFirst();
        deque.peekLast();
    }
}
```

## Lower & Upper Bound O(logN)
lower bound는 하한선, upper bound는 상한선을 의미한다.
이 때 upper bound는 타겟보다 처음으로 큰 수를 가리킨다.
이진 탐색으로 원하는 타겟의 범위 인덱스를 구한다.

- 빈도 구하기

```java
public class LowerUpperBound {
    static int[] input = new int[]{1, 2, 2, 2, 3, 4, 5};

    public static void main(String[] args) {
        // 중복값이 있을 경우 먼저 찾은 값의 인덱스를 반환
        System.out.println("# API index:" + Arrays.binarySearch(input, 2));
        System.out.println("# lowerbound index:" + lowerBound(2)); // 1
        System.out.println("# upperbound index:" + upperBound(2)); // 4
    }

    static int lowerBound(int target){
        int low = 0;
        int high = input.length;
        int mid;

        while(low < high){
            mid = (low + high)/2;
            if(input[mid] >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    static int upperBound(int target){
        int low = 0;
        int high = input.length;
        int mid;

        while(low < high){
            mid = (low + high)/2;
            if(input[mid] > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}
```

## 깊이 우선 탐색 DFS O(V+E)
그래프 완전 탐색 기법 중 하나이다.
깊이 우선 탐색은 그래프의 시작 노드부터 시작하여 탐색 분기의 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행한다.
시간 복잡도는 O(V+E)로 V는 노드의 개수, E는 엣지의 개수를 의미한다.
DFS는 재귀함수 또는 스택 자료구조로 구현한다. 즉 DFS는 재귀 함수 그 자체로 생각할 수 있다.
#### 응용 문제
- 백트래킹
- 위상 정렬
- 단절선 찾기
- 단절점 찾기
- 사이클 찾기

```java
public class DFS {
   static ArrayList<Integer>[] adj; // 그래프 인접리스트
   static boolean[] visited;
   
   static void DFS(int v){
      if(visited[v]) return;
      visited[v] = true;

      for(int i : adj[v]){
         if(!visited[i]){
            DFS(i);
         }
      }
   }
}
```

## 너비 우선 탐색 BFS O(V+E)
그래프 간선의 가중치가 모두 동일할 때, BFS로 탐색한다.
너비 우선 탐색은 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
선입선출 방식으로 탐색하므로 큐를 이용해 구현하는데, 주로 ArrayDeque를 사용한다. 
또한 BFS는 탐색 시작 노드와 가까운 노드를 우선하여 탐색하므로 목표 노드에 도착하는 경로가 여러 개일 때, 최단 경로를 보장한다. 
시간 복잡도는 O(V+E)로 DFS와 같다.
#### 응용 문제
- 최단 경로 찾기
- 위상 정렬

```java
public class BFS {
   static ArrayList<Integer>[] adj; // 그래프 인접리스트
   static boolean[] visited;
   
   static void BFS(int v){
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(v);
      visited[v] = true;

      while(!queue.isEmpty()){
         int now = queue.poll();
         for(int i : adj[now]){
            if(!visited[i]){
               visited[i] = true;
               queue.add(i);
            }
         }
      }
   }
}
```

## 이진 탐색 O(logN)
데이터가 정렬돼 있는 상태에서 대상 데이터의 중앙값과 찾고자 하는 값을 비교해 데이터의 크기를 절반씩 줄이면서 대상을 찾는다.
이진 탐색을 사용하면 N개의 데이터에서 logN 번의 연산으로 원하는 데이터의 위치를 찾을 수 있다.
다만 이진 탐색은 데이터가 정렬되어 있어야 한다.
```java
import java.util.Arrays;

/*
 * N * (1/2)^K = 1 -> K = logN
 * O(logN)
 */
public class BinarySearch {

    public static void main(String[] args) {
//		int[] input = new int[] {4, 6, 11, 19, 21, 50, 77, 81, 99, 100};
        int[] input = new int[] {4, 6, 11, 19, 21, 50, 77, 81, 99, 99, 100};
        Arrays.sort(input);
        binarySearch(input, 99);

        // 중복값이 있을 경우 먼저 찾은 값의 인덱스를 반환
        System.out.println("API : " + Arrays.binarySearch(input, 99));

        // 없는 값을 넣으면 그 값이 위치할 곳을 음수로 리턴한다. input의 최소값보다 작은 구간에 있으면 -1
        System.out.println("API : " + Arrays.binarySearch(input, 102));
    }

    static void binarySearch(int[] array, int target) {
        int low = 0, high = array.length-1, mid = 0;

        while(low <= high) {
            mid = (low + high)/2; //pivot 잡기
            printArray(low, mid, high, array); //탐색 과정을 보여주기 위한 method

            // target이 중간값이면 찾은 것!
            if(target == array[mid]) {
                System.out.println(target + "의 index : " + mid);
                break;
            }

            // target 값이 중간값보다 작으면, 다음에는 아래쪽 절반을 탐색
            if(target < array[mid]) {
                high = mid - 1;
            }
            // target 값이 중간값보다 크면, 다음에는 위쪽 절반을 탐색
            else {
                low = mid + 1;
            }
        }
    }

    static void printArray(int low, int mid, int high, int[] array) {
        System.out.print("low = "+ low + " mid = "+ mid + " high = "+ high +" [");
        for(int i = low; i <= high; i++ ) {
            if(i == high) System.out.print(array[i]);
            else System.out.print(array[i]+", ");
        }
        System.out.println("]");
    }
}
```

## 우선순위 큐 Priority Queue : O(NlogN)
우선순위 큐는 값이 들어간 순서와 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조이다.
큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치한다.
일반적으로 힙을 이용해 구현하며, Comparable 또는 Comparator를 이용하여 우선순위를 설정한다.
```java
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 오름차순
            // 반환 값이 음수인지 양수인지에 따라 우선순위가 결정됨
            // 내 것과 새로 들어온 객체를 계산해서 0, 음수면 그대로, 양수면 바꿔라
        }
    }

    public static void main(String[] args) {
        // 1. 기본 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        // 2. Comparable 를 활용한 우선순위 설정
        PriorityQueue<Node> que = new PriorityQueue<>();

        // 3. 새로운 우선순위 설정 : 절댓값에 따라 순위결정하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) return o1 > o2 ? 1 : -1; // 절댓값이 같으면 더 작은 수를 먼저(오름차순)
            else return first_abs - second_abs;
        });
        
        // 4. Comparator 클래스를 활용한 우선순위 설정
        PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>(){
           @Override
           public int compare(Jewel o1, Jewel o2) {
              return Integer.compare(o2.v, o1.v); // 내림차순
              // <. =. > 순으로 true 일 경우 -1, 0, 1을 반환
           }
        });

        pq.add(1);
        pq.poll();
    }
}
```

---
# 정수론
## 에라토스테네스의 체
코딩테스트에서 소수를 구하는 가장 일반적인 방법이다.
1. 구하고자 하는 소수 범위만큼 1차원 배열을 생성한다.
2. 소수를 찾으면 해당하는 소수의 배수들을 모두 지워줌으로써 지워지지 않은 숫자를 찾는다.
```java
public class Prime {
    public static void main(String[] args) {
        int[] prime = new int[N+1]; // 1차원 배열 생성 후 초기화
        for(int i=2; i<=N; i++){
            prime[i] = i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){ // 제곱근까지만 탐색
            if(prime[i] == 0) continue;
            for(int j=i+i; j<=N; j += i){ // 배수 지우기
                prime[j] = 0;
            }
        }

        for(int i=M; i<=N; i++){ // M 이상 N 이하의 소수 출력
            if(prime[i] != 0) System.out.println(prime[i]);
        }
    }
}
```
이중 for문을 사용하지만 실제 시간 복잡도는 최적화의 정도에 따라 다르겠지만, 일반적으로 `O(Nlog(logN))`이다.
그 이유는 배수를 삭제하는 연산으로 실제 구현에서 바깥쪽 for문을 생략하는 경우가 빈번하게 발생하기 때문이다.

## 팰린드롬 수
79,179와 324,423 처럼 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라고 부른다.
숫자를 char 배열 형태로 변환한 후 양끝의 투 포인터를 비교하면 쉽게 판별할 수 있다.
```java
public class Palindrome {
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
```

## 오일러 피
[정의] : 자연수 n이 주어졌을 때, gcd(n,k)=1 (1<=k<=n)를 만족하는 자연수의 개수\
오일러 피 함수 P[N]의 정의는 1부터 N까지 범위에서 N과 서로소인 자연수의 개수를 뜻한다.\
예) P[6] = 1~6 범위에서 6과 서로소인 자연수의 개수 = (1, 5)로 2개이다.
1. 구하고자 하는 오일러 피의 범위만큼 배열을 자기 자신의 인덱스값으로 초기화한다.
2. 2부터 시작해 현재 배열의 값과 인덱스가 같으면(=소수일 때) 현재 선택된 숫자(K)의 배수에 해당하는 수를
   끝까지 탐색하며 `P[i] = P[i] - P[i]/K` 연산을 수행한다. (i는 K의 배수)
```java
public class EulerPhi {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();

      int[] P = new int[N+1];
      for(int i=0; i<=N; i++){
         P[i] = i;
      }

      for(int K=2; K<=N; K++){
         if(P[K] == K){
            for(int i=K; i<=N; i += K){
               P[i] = P[i] - P[i]/K;
            }
         }
      }

      for(int p : P){
         System.out.print(p+" ");
      }
   }
}
```


## 유클리드 호제법
두 수의 최대공약수(GCD)를 구하는 알고리즘이다.\
2개의 자연수 a, b에 대해 a를 b로 나눈 나머지를 r이라 하면 (단, a > b), 
a와 b의 최대공약수는 b와 r의 최대공약수와 같다는 성질을 이용한다.\
즉, `gcd(a, b) = gcd(b, a%b) (단, a>=b)`이다.
1. 큰 수를 작은 수로 나누는 MOD 연산을 수행한다.
2. 앞 단계에서의 작은 수와 MOD 연산 결괏값(나머지)으로 다시 MOD 연산을 수행한다. (재귀)
3. 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택한다.
```java
static int gcd(int a, int b){
    if(b==0) return a; // 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택함
    return gcd(b, a%b); // 앞 단계의 작은 수(b)와 큰 수에서 작은 수 MOD 연산(a%b)로 다시 MOD 연산 수행
}
```
#### 최소 공배수: `A*B/gcd(A, B)`
```java
//LCM 최소공배수 = (a*b)/gcd(a,b)
 static int lcm(int a, int b) {
     return a * b / gcd(a,b);
 }
```
#### 세 개 이상의 정수의 최대 공약수를 구하는 방법
유클리드 호제법을 재귀적으로 사용한다. 
`gcd(A, B, C) = gcd(gcd(A, B), C)`를 이용한다.


## 확장 유클리드 호제법 (베주 항등식 Bezout's identity)
유클리드 호제법이 최대 공약수를 구하는 것이라면, 확장 유클리드 호제법(Extended Euclidean Algorithm)은 방정식의 해 x, y를 구한다.
- 해를 구하고자 하는 방정식 : `ax + by = c (a, b, c, x, y, 는 정수)`

위 방정식은 `c % gcd(a,b) = 0`인 경우에만 정수해를 가진다. 만약 c가 gcd(a,b)의 배수가 아니라면 해당 방정식을 만족하는 x, y값은 정수 범위에서 존재하지 않는다.\
다시 말해 ax + by = c가 정수해를 갖게 하는 c의 최솟값이 gcd(a,b)라는 것을 의미한다. 이 때 x, y 중 한개는 보통 음수가 된다.\
특히 a, b가 서로소(gcd(a,b)=1)인 경우 유용하다. 이 경우, ax + by = 1이 되고, 여기서 x는 MOD 연산의 곱의 역원이 되기 때문이다. 
#### 5x+9y=2일 때 이 식을 만족하는 정수 x, y를 구해보자.
1. 해당 식이 정수해를 갖게 하는 c의 최솟값이 gcd(5,9)=1이므로 5x+9y=1로 식을 놓고 mok=2를 저장한다.
2. a, b로 유클리드 호제법을 반복하면서 몫, 나머지를 저장한다. 나머지가 0이 되면 반복을 중단한다.
3. 반복으로 구한 나머지와 몫을 이용하여 거꾸로 올라가며 x=y', y=x'-y'*q를 계산한다.
이때 x'는 이전 x, y'는 이전 y를 의미하고, q는 현재 보고 있는 몫을 의미한다.
4. 이렇게 재귀 방식으로 알아낸 최종 x, y는 ax+by=gcd(a,b)를 만족하므로 mok를 곱해서 최종 Kx, Ky를 간단히 구할 수 있다.
```java
public class EEA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int gcd = gcd(A, B);
        if(C % gcd != 0) System.out.println(-1);
        else {
            int mok = C /gcd;
            long[] ret = Excute(A, B);
            System.out.println(ret[0]*mok + " " + ret[1]*mok);
        }
    }

    public static long[] Excute(long a, long b){ // 유클리드 호제법
        long[] ret = new long[2];
        if(b==0) {
            ret[0] = 1; ret[1] = 0; // x=1, y=0으로 설정하고 리턴하기
            return ret;
        }

        long q = a/b;
        long[] v = Excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 올라오면서 x, y값을 계산하는 로직
        ret[1] = v[0]-v[1]*q;
        return ret;
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
```

---
# 조합
알고리즘에서 조합을 구현할 때는 수학 공식을 코드화하지 않고 점화식을 사용해 표현한다.

1. 특정 문제를 가정하기
   - 예를 들어 5개의 데이터 중 3개를 선택하는 조합의 경우의 수를 구해보자
2. 모든 부분 문제가 해결된 상황이라고 가정하고 지금 문제 생각하기
   - 먼저 5개의 데이터 중 4개를 이미 선택이 완료된 데이터라고 가정한다. 그리고 마지막 데이터의 선택 여부에 따른 경우의 수를 계산한다.
   - 만약 마지막 데이터를 포함해 총 3개의 데이터를 선택하려면 선택이 완료됐다고 가정한 4개의 데이터에서 2개를 선택해야 한다.
   - 마지막 데이터를 포함하지 않고 총 3개의 데이터를 선택하려면 이전 데이터 4개 중 3개를 선택해야 한다.
   - 위의 2가지 경우의 수를 합치면 데이터 5개 중 3개를 선택하는 경우의 수가 나온다.
3. 특정 문제를 해결한 내용을 바탕으로 일반 점화식 도출하기
   1. 조합 점화식 : `D[i][j] = D[i-1][j] + D[i-1][j-1]`
   2. 예 : `D[5][3] = D[4][2] + D[4][3]`
   3. 고민해보면 파스칼의 삼각형 점화식과 같다.

```java
public class Combination {
    static int N, K;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // DP 배열 초기화
        D = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        // 조합 기본 점화식으로 채우기
        for(int i = 2; i <= N; i++){ 
            for(int j = 1; j < i; j++){ // 대각선 아래쪽 배열만 채우게 됨
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }

        System.out.println(D[N][K]);
    }
}
```

---
# 그래프
## 그래프의 표현
#### 에지 리스트
에지를 중심으로 그래프를 표현한다. 배열에 출발 노드와 도착 노드를 저장하면 에지를 표현할 수 있다.\
노드가 N개일 때, 가중치가 없는 그래프의 경우 `A[N][2]`(S, E)로 표현할 수 있고, 가중치가 있을 경우 `A[N][3]`(S, E, V)으로 표현할 수 있다.\
에지 리스트는 구현은 쉽지만 특정 노드와 관련되어 있는 에지를 탐색하기는 어렵다. 
그래서 에지 리스트는 벨만 포드나 크루스칼 알고리즘에 사용되며, 노드 중심 알고리즘에는 사용하지 않는다.

#### 인접 행렬
노드가 N개일 때, `A[N][N]`인 2차원 배열을 자료구조로 이용하여 그래프를 표현한다. 인접 행렬은 노드 중심으로 그래프를 표현한다.\
인접 행렬을 이용한 구현 역시 쉽다. 두 노드를 연결하는 에지의 여부와 가중치 값은 배열에 직접 접근하면 바로 확인할 수 있는 것도 장점이다.\
하지만 노드와 관련되어 있는 에지를 탐색하려면 N번 접근해야 하므로 노드 개수에 비해 에지가 적을 때는 공간 효율성이 떨어진다. 
또한 노드 개수가 많으면 아예 2차원 배열을 선언할 수 없다. 특히 노드가 3만 개가 넘으면 자바 힙 스페이스 에러가 발생한다.

#### 인접 리스트
인접 리스트는 ArrayList로 그래프를 표현한다. 즉, 노드의 개수만큼 ArrayList를 선언한다.\
예를 들어 Integer형인 N개의 노드는 `ArrayList<Integer>[N]`으로 선언할 수 있다.
가중치가 있는 그래프의 경우 Node 클래스를 자료형으로 사용하여 `ArrayList<Node>[N]`으로 선언한다.\
인접 리스트 방식은 구현이 복잡하지만, 노드와 연결되어 있는 에지를 탐색하는 시간이 매우 뛰어나며, 
노드 개수가 커도 공간 효율이 좋아 메모리 초과 에러도 발생하지 않는다.

```java
import java.util.ArrayList;

public class AdjacencyList {
   static ArrayList<Node>[] adj;

   static class Node {
      int to, cost;

      public Node(int to, int cost) {
         this.to = to;
         this.cost = cost;
      }
   }

   public static void main(String[] args) {
       int a = 3, b = 2, c = 4; 
       adj[a].add(new Node(b, c));
       adj[b].add(new Node(a, c)); // 양방향
   }
}
```

## 유니온파인드
그래프의 사이클이 있는지 판별하는 알고리즘이다.
일반적으로 여러 노드가 있을 때, 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과 두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성된다.\
특히 find 연산은 특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환한다.
1. 각 노드의 대표 노드를 저장하는 1차원 배열을 초기화함
2. union 연산을 수행하면서 같은 대표 노드를 가지도록 배열을 업데이트함
   1. 선택된 노드끼리 연결하는 것이 아닌, 선택된 노드의 대표 노드끼리 연결하는 것임!
3. find 연산을 수행한다.
   1. 대상 노드 배열에 index 값과 value 값이 동일한지 확인
   2. 동일하지 않으면 value 값이 가리키는 index 위치로 이동
   3. 이동 위치의 index 값과 value 값이 같을 때까지(대표노드를 찾을 때까지) 재귀
   4. 대표 노드에 도달하면 재귀 함수를 빠져나오면서 거치는 모든 노드 값을 루트 노드값으로 변경(중요!)
find 연산은 자신이 속한 집합의 대표 노드를 찾는 연산으로 그래프를 정돈하고 시간복잡도를 향상시킨다.(경로 압축의 효과)

```java
public class UnionFind {
    static int[] parent; // 대표 노드 배열
    public static void main(String[] args){
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }

    public static void Union(int a, int b){
        int aRoot = Find(a); // 선택된 노드의 대표 노드를 찾음
        int bRoot = Find(b);
        if(aRoot != bRoot) parent[aRoot] = bRoot; // 같은 대표 노드를 가지도록 업데이트
    }

    public static int Find(int a){
        if(parent[a] == a) return a; // index와 value가 같으면 리턴
        return parent[a] = Find(parent[a]); // 재귀 함수에서 탐색한 모든 노드의 대표 노드값을 이번 연산에서 발견한 대표 노드로 업데이트(중요)
    }
}
```
### 그래프 내 사이클을 판별 = MST에서 활용
이러한 유니온 파인드 연산으로 그래프의 사이클을 판별할 수 있다.
union 연산은 그래프에서의 간선으로 표현될 수 있다. 따라서 간선을 하나씩 확인하면서 두 노드가 포함되어 있는 집합을 합치는 과정을 반복하는 것만으로도 그래프 내 '사이클'을 판별할 수 있다.
1. 각 간선을 확인하며 두 노드의 대표 노드를 확인함
2. 만약 서로의 parent가 다르면 두 노드에 대해 union 연산을 수행함
3. 만약 parent가 같다면 사이클이 발생한 것임!
4. 그래프에 포함되어 있는 모든 간선에 대해 위의 과정을 반복함

### 변형된 유니온 파인드 : 집합의 개수와, 원소의 개수를 카운트
변형된 유니온 파인드를 수행하면, 전체 집합이 몇 개 존재하는지 셀 수 있다. 
또한 해당 집합에 포함되는 원소의 개수도 함께 셀 수 있다.

1. 대표 노드를 -1로 초기화한다. 음수가 곧 대표(부모)노드를 의미함
2. Find 수행 시, 배열의 값이 음수일 경우 대표노드로 리턴한다.
3. Union 수행 시, 대표 노드의 배열 값에 새롭게 합쳐지는 집합의 개수를 음수값으로 더한다.

```java
public class UnionFind2 {
    static int[] parents;
    public static void main(String[] args) {
        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = -1;
        }
        
        int a, b; //입력
        Union(a, b);

        int group = 0; // 집합의 수
        int cnt = 0; // 원소의 개수 중 max
        for(int i = 0; i < N; i++){
            if(parents[i] < 0) {
                group++; // 음수이면 대표 노드임
                cnt = Math.min(cnt, parents[i]); //음수의 절댓값이 원소 개수
            }
        }
        System.out.println(group);
        System.out.println(-cnt);
    }
    
    static void Union(int a, int b) {
        int aRoot = Find(a);
        int bRoot = Find(b);
        if(aRoot != bRoot){
            parents[aRoot] += parents[bRoot];
            parents[bRoot] = aRoot;
        }
    }

    static int Find(int x) {
        if(parents[x] < 0) return x;
        return parents[x] = Find(parents[x]);
    }
}
```

## 위상정렬 O(V+E)
사이클이 없고 방향이 있는 그래프일 때, 그래프를 선형으로 정렬한다.
그래서 정답이 여러 개 존재할 수 있다. 예를 들어 수강 신청이나 게임 빌드 순서 등의 문제가 나온다.
진입 차수 배열을 기준으로 노드의 순서가 정렬된다.
사이클이 존재하면 노드 간의 순서를 명확하게 정의할 수 없으므로 위상 정렬을 적용할 수 없다.

```text
진입차수 배열을 이용해 그래프의 노드를 순차적으로 탐색한다.
진입차수가 0인 노드는 모두 출발 노드이므로 탐색하여 모두 큐에 추가한다.
진입차수가 0이 아닌 노드는 이전에 완료해야 할 작업이 남았다는 것을 의미한다.
임계 경로 값을 구하는 DP 배열을 선언하여 값을 업데이트한다.
```

- 진입 차수란? 자기 자신을 가리키는 에지의 개수
1. 인접 리스트로 표현된 그래프와 진입 차수 배열을 초기화함
2. 진입 차수가 0인 노드를 선택하고, 선택된 노드를 정렬 배열에 저장함
3. 인접 리스트에서 선택된 노드가 가리키는 노드들의 집입 차수를 1씩 뺌
4. 다음 집입 차수가 0인 노드를 찾아 반복

```java
import java.io.*;
import java.util.*;

public class TopologySort {
    static ArrayList<Integer>[] graph;
    static int[] degree; // 진입 차수 배열
    static int[] result; //DP
    public static void main(String[] args){
        int n, m; // input
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        degree = new int[n+1];

        for (int i = 1; i <= m; i++) {
            int a, b; //input
            graph[a].add(b);
            degree[b]++;
        }
        
        // 위상 정렬 수행
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(degree[i] == 0){ // 진입 차수가 0인 노드를 찾아 큐에 추가
                q.add(i);
            }
        }
        
        result = new int[n+1];
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" "); // 정렬된 노드 출력
            for(int next : graph[now]){
                degree[next]--; // 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺌
                result[next] = Math.max(result[next], result[now]+next.cost); // 임계 경로 값 구하기
               // 타깃 노드의 현재 경로 값과 (현재 노드의 경로 값 + 도로의 시간값) 중 큰 값으로 저장함
                if(degree[next] == 0){
                    q.add(next); // 다음 선택 노드를 큐에 추가
                }
            }
        }
    }
}
```
단순한 정렬 문제 보다는, 임계 경로를 찾는 것처럼 최대 경로 값을 구하는 문제에 이용된다. 
예를 들어, 위상 정렬을 수행하면 출발 도시에서 도착 도시까지 거치는 모든 도시와 관련된 임계 경로값을 구할 수 있다. 
특히, 1분도 쉬지 않고 달려야 하는 도로의 수를 구할 때는 에지 뒤집기 아이디어를 사용하여 도착 도시에서부터 출발하는 reverseGraph를 그려서 해결할 수 있다. 
visited 배열을 사용하여 중복 카운트를 방지한다. (1516_게임개발, 1948_임계경로)

## 다익스트라 O(ElogV)
출발 노드에서 다른 모든 노드로 가는 최단 거리를 구하는 알고리즘이다.
단, 음수 간선이 존재하면 풀 수 없다.

```text
BFS 알고리즘을 기본으로 탐색하며 DP로 최단 경로를 업데이트한다.
PriorityQueue를 이용해 가장 적은 비용의 노드부터 탐색한다.
시작노드부터 큐에 넣어 BFS 탐색을 하며, 새로운 최단 경로가 발생했을 때만 해당 노드를 큐에 추가한다.
한번 방문한 노드는 새로운 최단 경로가 될 수 없다.
```

1. 인접 리스트로 그래프 구현하고, 최단 거리 배열을 초기화함
   1. 인접 리스트에 연결한 배열의 자료형은 보통 (노드, 가중치) 형태로 선언함
   2. 최단 거리 배열은 출발 노드는 0, 이외의 노드는 무한으로 초기화함
3. 값이 가장 작은 노드를 선택하여 최단 거리 배열을 업데이트함
   1. 선택된 노드에 연결된 에지의 값을 바탕으로 다른 노드의 값을 업데이트함
   2. 최단 거리 = Min(선택 노드의 최단 거리 배열의 값 + 에지 가중치, 연결 노드의 최단 거리 배열의 값)
   3. 최단 거리 배열이 업데이트될 때, 큐에 해당 노드를 추가함(최단경로로 탐색)
4. 모든 노드가 처리될 때까지 위의 과정을 반복함
   1. 재방문하지 않기 위해 visited[] 배열을 만들어 처리함

대부분 다익스트라 알고리즘이 출발 노드와 도착 노드 간의 최단 거리를 구하는 알고리즘이라고 생각하지만,
실제로 완성된 배열은 출발 노드와 이외의 모든 노드 간의 최단 거리를 표현하고 있다.

```java
public class Dijkstra {
    static public class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int V, E, S;
    static ArrayList<Node>[] adj;
    static int[] DP;
    static boolean[] visited;

    public static void main(String[] args) {
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        DP = new int[V + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        visited = new boolean[V + 1];

        for(int i=0; i<E; i++){
            int u, v, w;
            adj[u].add(new Node(v, w));
        }

        dijkstra(S);
    }

    public static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        DP[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if(nowCost > DP[now]) continue;
            if(visited[now]) continue; // 이미 방문한 노드는 새로운 최단 경로가 될 수 없음
            visited[now] = true;

            for(Node e : adj[now]){
                int next = e.to;
                int nextCost = DP[now] + e.cost;
                if(DP[next] > nextCost){ // 새로운 최단 경로가 발생했을 때
                    DP[next] = nextCost; // 최단 거리 배열을 업데이트하고
                    pq.add(new Node(next, nextCost)); // 해당 경로를 큐에 추가함
                }
            }
        }

    }
}
```

## 벨만-포드 O(VE)
다익스트라와 똑같이 특정 출발 노드에서 다른 모든 노드로 가는 최단거리를 구한다.
벨만-포드 알고리즘은 음수 간선이 존재해도 가능하기 때문에 음수 사이클을 판별하는 문제가 많이 나온다.
예를 들어, 시간 여행이나 웜홀을 통한 워프 등 실제로 일어날 수 없는 상황들이 주어진다.
- 최단 거리를 N-1번의 DP 배열 업데이트로 구한다. 
- 한번 더 업데이트(N번째)를 시도해서 새로운 업데이트가 발생하면, 해당 그래프는 최단 거리를 구할 수 없으며 음수 싸이클이 존재한다.

```text
벨만 포드 알고리즘은 DP를 N-1번 업데이트한다는 아이디어가 중요하다.
그리고 N-1번의 for문 동안 모든 에지에 대해 최단 경로 값을 업데이트한다.
에지리스트로 그래프를 저장한다. 모든 에지에 대해 탐색해야 하기 때문에 에지 간 순서는 중요하지 않다.
그래프 내에서 방문한 노드는 DP의 초기값(무한대)으로 확인한다.
N번 째에 업데이트가 발생하다면 음수 싸이클이 존재한다.
```

1. 에지 리스트로 그래프를 구현(`ArrayList<edge> edges;`)하고, 최단 경로 배열(`DP[index]`)을 초기화함
   1. edge 클래스는 일반적으로 출발 노드, 도착 노드와 가중치 변수로 구성됨 
   2. 최단 경로 배열은 출발 노드는 0, 나머지 노드는 무한대로 초기화함(기본구조)
   3. 하지만 초기값은 문제의 조건에 따라 달라질 수 있음!
2. 모든 에지를 확인해 총 N-1번 DP 배열을 업데이트함(for문으로!!) 
   1. 최단 거리 배열에서 업데이트 반복 횟수는 `노드 개수-1`이다! <- `N-1개의 usedEdge를 찾는 MST와 구별`
      - 노드의 개수가 N이고, 음수 사이클이 없을 때 특정 두 노드의 최단 거리를 구성할 수 있는 에지의 최대 개수는 N-1개이기 때문임
   2. `DP[s] != 무한대`이며 `DP[e] > DP[s] + w` 일 때 `DP[e] = DP[s] + w`로 배열의 값을 업데이트함
      - `DP[s]`가 무한대라면, 시작 노드가 현재 미방문 상태라는 뜻으로 경로 탐색에 포함되지 않음
   3. 업데이트 반복 횟수가(에지 사용 횟수)가 k번 이라면 해당 시점에 정답 배열의 값은 시작점에서 k개의 에지를 사용했을 때 각 노드에 대한 최단 거리임
3. 음수 사이클이 존재하는지 확인하기 위해 한번 더 업데이트를 수행함
   1. 모든 에지를 한 번씩 다시 사용해 업데이트되는 노드가 발생하는지 확인함.
   2. 만약 업데이트되는 노드가 있다면, 음수 사이클이 존재하여 최단 거리를 구할 수 없음 

```java
public class BellmanFord {
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static int N, M;
    static long[] DP;
    static ArrayList<Edge> edges; // 에지 리스트 형태로 그래프를 저장함
    
    public static void main(String[] args) {
        DP = new long[N + 1];
        Arrays.fill(DP, Long.MAX_VALUE);
        DP[1] = 0L;
       
        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            edges.add(new Edge(from, to, cost)); // 모든 에지를 저장
        }
        
        // 벨만 포드 알고리즘
        boolean checked = false; // 음수 사이클 여부
        for (int i = 1; i <= N; i++) { // for 문으로 무조건 DP 업데이트를 N-1번 반복하고, N번 째에 음수 사이클을 확인함
            for(Edge e : edges) { // 모든 에지에 대해 계속 탐색함
                int start = e.from;
                int end = e.to;
                int time = e.cost;
                // 정답 배열 업데이트 조건 : 무한대가 아닌 DP 값 중에 최단 거리
                // 현재 DP 값이 무한대인 노드는 미방문 노드임
                // 방문한 노드 중에서 새로운 경로에 해당하는 경우 DP 값을 업데이트함
                if(DP[start] != Long.MAX_VALUE && DP[end] > DP[start]+time) {
                    DP[end] = DP[start]+time; // 값이 더 작아지는 경로가 발생했으므로 업데이트함
                    if(i==N) checked = true; // N 번째에 업데이트가 발생함 = 음수 사이클이 존재함
                }
            }
        }
    }
}
```
위의 알고리즘처럼 최단 거리를 구하는 것이 아닌, 최대 비용을 구하고 싶을 때는 DP 업데이트 방식을 반대로 변경해주면 된다. 
즉 `DP[end] < DP[start]+time`일 때 업데이트하며, 이 때 음수 사이클 검사 구문도 양수 사이클을 찾는 구문으로 바뀌게 된다.
무한대가 발생하는 경우를 찾아야할 때는 DP 업데이트를 하는 For 문을 N번이 아니라, 충분히 큰 수만큼 반복하여 싸이클이 전파되도록 하여 무한대를 검사할 수 있다.

## 플로이드-워셜 O(V^3)
정해진 시작점 없이, 주어진 모든 노드 간의 최단 경로를 탐색한다. 시간복잡도가 크기 때문에 주어진 정점 V가 500개 이하일 때 사용할 수 있다.
음수 가중치 에지가 있어도 계산이 가능하다. 동적 계획법의 원리를 이용해 알고리즘에 접근할 수 있다.

````text
인접행렬로 구현된 그래프를 점화식으로 업데이트한다.
부분 경로의 합이 최소일 때, 최단 경로이라는 아이디어가 중요하다.
인접행렬로 값을 입력받을 때, 같은 간선에 대해 최소 비용으로 받도록 주의해야 한다.
또한 인접행렬에서 자기자신으로 가는 경로는 0으로 초기화해야 한다.
````

- 전체 경로의 최단 경로는 부분 경로의 최단 경로의 조합으로 이루어진다.
- 즉, 점화식은 `D[S][E] = Math.min(D[S][E], D[S][K]+D[K][E]`이다.

1. 인접 행렬로 최단 거리 배열 `D[S][E]`를 선언하고 초기화함
   1. `D[S][E]`는 노드 S에서 노드 E까지의 최단 거리를 저장하는 배열임
   2. S와 E의 값이 같은 칸은 0, 다른 칸은 무한으로 초기화함 (자기 자신에게 가는 최단 거리는 0이기 때문)
2. 최단 거리 배열에 그래프 데이터를 저장함
   1. 플로이드-워셜 알고리즘은 사용하는 정점 V의 개수가 적기 때문에 인접 행렬로 그래프를 표현함
   2. 출발 노드 S, 도착 노드 E, 에지의 가중치 W에 대해 `D[S][E] = W`로 배열에 입력함
3. 점화식을 3중 for 문의 형태로 반복하면서 배열을 업데이트함
```text
# 플로이드-워셜 알고리즘 로직
for 경유지 K에 관해 (1~N) // N=노드 개수
    for 출발 노드 S에 관해 (1~N)
        for 도착 노드 E에 관해 (1~N)
        D[S][E] = Math.min(D[S][E], D[S][K]+D[K][E])
        
```

```java
public class FloydWarshall {
    public static void main(String[] args) {
        long[][] D = new long[N+1][N+1]; // 최단 거리 배열
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) D[i][j] = 0;
                else D[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) { // 인접 행렬에 그래프 저장
            D[a][b] = Math.min(D[a][b], c);
        }
        
        // 플로이드-워셜 알고리즘
        for(int k = 1; k <= N; k++){
            for(int s = 1; s <= N; s++){
                for(int e = 1; e <= N; e++){
                    D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
                }
            }
        }
    }
}
```
완성된 배열은 모든 노드 간의 최단 거리를 저장하고 있다.
값이 무한대일 경우, 경로가 존재하지 않는 것이다.

플로이드-워셜 알고리즘은 어떤 경로를 그 경로의 부분 경로의 합으로 보는 DP 문제와 같다. 
기본적인 틀은 3중 반복문에 DP 점화식을 사용하는 것이지만 실제 문제에서 요구하는 바가 어떤 것인지를 고려하여 점화식을 세워야 한다. 
S, E, K라는 변수로 그래프의 경로를 나누어 생각하는 점화식이라는 점을 잘 기억하자.

## 최소 신장 트리 (MST; Minimum Spanning Tree)
그래프가 주어졌을 때, 최소 비용으로 모든 노드를 연결하는 알고리즘이다.
사이클 여부를 확인해야 하기 때문에 유니온 파인드를 활용한다.
음수 가중치를 가지는 에지가 있어도 가능하다.

- 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않음 (유니온 파인드로 판별)
- N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1개임

크루스칼 알고리즘과 프림 알고리즘으로 구현할 수 있다.

### 크루스칼 O(ElogV)
가중치가 가장 작은 에지부터 먼저 연결해서 최소 신장 트리를 구성한다. 이 때 유니온 파인드 기법으로 사이클 여부를 검사한다.

1. 에지 리스트로 그래프를 구현하고 유니온 파인드 배열을 초기화함
   1. 노드 변수 2개와 가중치 변수를 가지는 `A[N][3]`형태의 `ArrayList<edge> edges`를 선언함
   2. 사이클 처리를 위한 유니온 파인트 배열을 자기 자신의 인덱스 값으로 초기화함
2. 그래프 데이터를 가중치를 기준으로 정렬함
   1. 에지 리스트에 담긴 데이터를 가중치 기준으로 오름차순 정렬함
3. 가중치가 낮은 에지부터 연결을 시도함
   1. 에지를 연결했을 때 그래프에 사이클 형성 유무를 find 연산을 이용해 확인
   2. 사이클이 형성되지 않을 때만 union 연산으로 두 노드를 연결함
   3. 만약 사이클이 존재한다면, 현재 더 낮은 가중치의 에지로 연결되어 있다는 뜻임
4. 연결한 에지의 개수가 N-1이 될 때까지 과정 3을 반복함
5. 총 에지 비용 출력하기

```java
public class MST {
    static PriorityQueue<Edge> edges; // 에지 리스트
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int[] parent; // 유니온 파인드 배열

    public static void main(String[] args) {
        // 우선순위 큐로 에지 리스트를 구성함으로써 오름차순 정렬을 수행함
        edges = new PriorityQueue<>();
        
        // 유니온 파인드 배열을 자기 자신의 인덱스 값으로 초기화
        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        // 그래프 저장
        for (int i = 0; i < E; i++) {
            edges.add(new Edge(a, b, c));
        }
        
        // 크루스칼 알고리즘
        int usedEdge = 0;
        int result = 0;
        while(usedEdge < V-1){ // 에지의 개수가 N-1이 될 때까지 반복
            Edge e = edges.poll(); // 가장 작은 가중치의 에지를 선택
            int now = e.from;
            int next = e.to;
            if(Find(now) != Find(next)){ // 사이클 여부 판별
                Union(now, next);
                result = result + e.cost;
                usedEdge++;
            }
        }
        System.out.println(result);
    }
}

```

---
# 트리
## 코딩 테스트에서 트리 문제 유형
1. 그래프로 푸는 트리
   1. 노드와 에지를 그래프처럼 인접 리스트로 표현할 수 있음
   2. 그래서 DFS와 BFS를 적용하여 트리 문제를 해결할 수 있음
2. 트리만을 위한 문제
   1. 이진 트리, 세그먼트 트리, LCA 처럼 1차원 배열로 트리를 표현할 수 있음
   2. 즉, 드라마틱하게 데이터를 관리함

## 이진 트리
1차원 배열로 표현할 수 있는 트리의 기본 구조이다.
이진 트리는 각 노드의 자식 노드(차수)의 개수가 2 이하로 구성돼 있는 트리를 말한다.

- 편향 이진 트리: 노드들이 한쪽으로 편향돼 생성된 이진 트리, 탐색 속도가 저하되고 공간 낭비가 심함
- 포화 이진 트리: 트리의 높이가 모두 일정하며, 리프 노드가 꽉찬 이진 트리
- 완전 이진 트리: 마지막 레벨을 제외하고 완전하게 노드들이 채워져 있고, 마지막 레벨은 왼쪽부터 채워짐

보통 배열에 데이터를 담을 때는 완전 이진 트리 형태를 떠올리면 된다.
### 트리의 노드와 배열의 인덱스 사이 상관 관계
| 이동 목표 노드  | 인덱스 연산                | 제약 조건(N=노드 개수)     |
| --------- | --------------------- | ------------------ |
| 루트 노드     | index = 1             |                    |
| 부모 노드     | index = index / 2     | 현재 노드가 루트 노드가 아님   |
| 왼쪽 자식 노드  | index = index * 2     | index * 2 <= N     |
| 오른쪽 자식 노드 | index = index * 2 + 1 | index * 2 + 1 <= N |

## 트라이
문자열 검색을 빠르게 실행할 수 있도록 설계한 트리 형태의 자료구조이다.
- N진 트리: 문자 종류의 개수에 따라 N이 결정됨, 예를 들어 알파벳은 26개의 문자로 이뤄져 있으므로 26진 트리로 구성됨
- 루트 노드는 항상 빈 문자열을 뜻하는 공백 상태를 유지함
- 각 노드는 기본적으로 N개의 공백 노드를 자식으로 가짐

1. 루트 노드는 공백으로 유지하며, 문자열의 각 알파벳에 해당하는 노드를 생성함
2. 다음 문자열을 삽입할 때는 루트 노드부터 검색하여 자료 구조를 생성함
   1. 새로운 알파벳 노드가 공백 상태가 아니라면 이동하고,
   2. 공백 상태하면 신규 노드를 생성함
   3. 문자열의 마지막에 도달하면 리프 노드를 표시해줌
3. 트라이 자료 구조로 대상 문자열을 검색할 때,
   1. 루트부터 문자열이 끝날 때까지 공백이 없고, 
   2. 현재 문자의 마지막 노드가 트라이의 리프 노드라면 이 문자는 트라이 구조에 포함됨


```java
public class Trie {
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode(); // 루트 노드는 공백 노드

        // 트라이 자료구조 생성
        for (int i = 0; i < n; i++) {
            String text = sc.next();
            tNode now = root;
            for(int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                // 26개 알파벳의 위치를 배열 index로 나타내기 위해 (c - 'a')를 수행함
                if(now.next[c - 'a'] == null) { // 현재 문자가 공백상태라면 노드를 추가해줌
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a']; // 다음 문자로 이동
                if(j == text.length() - 1) {
                    now.isEnd = true; // 리프 노드를 표시
                }
            }
        }

        // 트라이 자료구조 검색
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            String text = sc.next();
            tNode now = root;
            for(int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                if(now.next[c - 'a'] == null) { // 공백 노드라면 검색 중단
                    break;
                }
                now = now.next[c - 'a'];
                if(j == text.length() - 1 && now.isEnd) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
```

## 인덱스 트리 O(MlogN)
주어진 데이터들의 구간 합과 데이터 업데이트를 빠르게 수행하기 위해 고안해낸 자료구조이다.
보통 구간 합은 '합 배열'을 이용하여 구할 수 있는데, 인덱스 트리와의 차이점은 데이터의 업데이트가 어렵다는 것이다.
인덱스 트리는 특유의 자료구조를 가지고 데이터의 업데이트를 손쉽게 수행하며 구간의 질의값을 구할 수 있다.

- 구간 합, 구간 곱
- 최대, 최소 구하기

### 1. 트리 초기화하기
1. 리프 노드의 개수가 N개 이상이 되도록 높이 T인 트리 배열을 만든다.
   1. `2^K >= N`을 만족하는 k의 최솟값을 구한 후 `2^K * 2`를 배열의 크기로 정의한다.
   2. 배열의 0번째는 사용하지 않는다.
   3. 예를 들어, 리프 노드가 5개라면 arr[16]으로 선언하고 0번째 배열을 제외한 15개의 노드를 사용한다.
2. 인덱스 트리의 리프노드에 원본 데이터를 저장한다.
   1. 2^K를 시작 인덱스로 해서 차례로 원본 데이터를 저장한다.
3. 인덱스 2^K를 리프 포인터를 설정해서 리프 노드의 위치를 저장하고 업데이트에 사용한다.
4. 리프 노드를 제외한 나머지 노드의 값을 채운다.
   1. 2^K-1부터 1번 쪽으로 채우게 된다.
   2. 채워야 하는 인덱스가 N이라고 가정하면 자신의 자식 노드를 이용해 해당 값을 채울 수 있다.
   3. 자식 노드의 인덱스는 이진 트리 형식이기 때문에 2N, 2N+1이 된다.
   4. 구간 합 예 : `A[N] = A[2N] + A[2N+1]`
   5. 최대 예 : `A[N] = Math.max(A[2N], A[2N+1])`

### 2. 질의값 구하기 (구간합 또는 최대, 최소)
1. 주어진 질의 인덱스를 인덱스 트리의 리프 노드에 해당하는 인덱스로 변경한다.
   1. `인덱스 트리 index = 주어진 질의 index + 2^K - 1`
2. 질의에 해당하는 노드를 선택한다.
   1. left % 2 == 1일 때 해당 노드를 선택한다. // 완전 이진 트리에서 left child는 항상 짝수임
   2. right % 2 == 0일 때 해당 노드를 선택한다. // 완전 이진 트리에서 right child는 항상 홀수임
   3. left의 depth를 변경한다. -> left = (left + 1) / 2 연산을 실행
   4. right의 depth를 변경한다. -> right = (right - 1) / 2 연산을 실행
   5. right < left 될 때까지 과정 1~4를 반복한다.
3. 선택된 노드를 가지고 질의값을 구한다.
   1. 구간 합 : 선택된 노드를 모두 더함
   2. 최댓값 : 선택된 노드들 중 MAX 값을 선택해 출력

### 3. 데이터 업데이트하기
1. 주어진 질의 인덱스를 인덱스 트리의 리프 노드에 해당하는 인덱스로 변경한다.
   1. `인덱스 트리 index = 주어진 질의 index + 2^K - 1`
2. 인덱스에 해당하는 배열의 값을 변경한다.
3. 자신의 부모 노드로 이동하면서 주어진 조건에 맞는 값으로 업데이트한다.


```java
public class IndexTree {
    static int N, M, K;
    static long[] input, tree;
    static int leafPointer;
    public static void main(String[] args) {
        input = new long[N];
        for(int i=0; i<N; i++) {
            input[i]= Long.parseLong(br.readLine());
        }
        
        initTree();
        query(2, 7);
        update(3, 5);
    }
    
    static void initTree(){
        // 1. input 데이터가 N개인 경우, 리프노드의 수 구하기
        // N <= 2^K 를 만족하는 최소값 K을 구한다.
        // ex) N = 9일 경우, 2^K = leafCount = 16
        int leafCount = 1;
        while(N > leafCount){
            leafCount *= 2;
            // leafCount <<= 1;
        }
   
        // 2. 리프노드의 사이즈를 바탕으로 전체 인덱스 트리의 크기를 구한다.
        // 전체 인덱스 트리의 크기 = 2^K * 2
        tree = new long[leafCount * 2];
        leafPointer = leafCount;
    
        // 3. 원본 데이터를 리프 노드에 저장한다.
        for(int i=0; i<N; i++){
            tree[leafPointer + i] = input[i];
        }
   
        // 4. 조건에 따라 리프노드를 제외한 나머지 노드의 값을 채운다.
        // 2^K-1 부터 1번 쪽으로 차례로 채움
        for(int i=leafPointer-1; i>0; i--){
            // tree 올라가면서 구간 합으로 채우기
            tree[i] = tree[i*2] + tree[(i*2)+1];
        }
    }

    static long query(int left, int right){
        // left, right 포인터를 인덱스 트리의 leafNode에 해당하는 인덱스로 바꿔준다.
        // 인덱스 트리 index = 주어진 질의 index + 2^K - 1
        left += leafPointer - 1;
        right += leafPointer - 1;
        
        long result = 0L;
        // left, right 포인터가 교차될 때까지
        while(left <= right){
            // left 포인터가 right child면 현재 값을 result에 더하고 left포인터를 오른쪽으로 하나 당긴다.
            if(left % 2 == 1){
                result += tree[left];
                left++;
            }
            // right 포인터가 left child면 현재 값을 result에 더하고 right포인터를 왼쪽으로 하나 당긴다.
            if(right % 2 == 0){
                result += tree[right];
                right--;
            }
            // 부모로 이동
            left /= 2;
            right /= 2;
        }

        return result;
    }

    static void update(int index, long value){
        // index로 들어온 값을 tree 배열에서 찾을 수 있는 leafNode 인덱스로 바꿔준다.
        int treeIndex = leafPointer + index - 1 ;

        // 리프노드의 값을 바꾸고
        tree[treeIndex] = value;
        // 부모노드로 간다
        treeIndex /= 2;

        // 부모노드->루트노드까지 값을 update 한다.
        while(treeIndex > 0){
            tree[treeIndex] = tree[treeIndex*2] + tree[(treeIndex*2)+1];
            treeIndex /= 2;
        }
    }
}
```

## 최소 공통 조상 (LCA; Lowest Common Ancestor)
트리 그래프에서 임의의 두 노드를 선택했을 때 처음 공통으로 만나게 되는 부모 노드를 최소 공통 조상이라고 한다.

### 일반적인 최소 공통 조상 구하기
트리의 높이가 크지 않을 때(시간 제한이 여유로울 때) 이 방법으로 구할 수 있다.

1. 루트 노드에서 DFS 또는 BFS 탐색을 시작해 각 노드의 부모 노드와 깊이를 저장한다.
2. 선택된 두 노드의 깊이가 다른 경우, 더 깊은 노드를 부모 노드로 1개씩 올려주면서 같은 깊이로 맞춘다. 
   1. 이때 두 노드가 같으면 해당 노드가 최소 공통 조상이므로 탐색을 종료한다.
3. 깊이가 같은 상태에서는 동시에 부모 노드로 올라가면서 두 노드가 같은 노드가 될 때까지 반복한다.

```java
public class LCA1 {
   static ArrayList<Integer>[] tree;
   static int[] depth;
   static int[] parent;
   static boolean[] visited;

   public static void main(String[] args) {
      tree = new ArrayList[n+1];
      for(int i = 1; i <= n; i++){
         tree[i] = new ArrayList<>();
      }
      for(int i = 1; i < n; i++){
         tree[s].add(e);
         tree[e].add(s);
      }

      depth = new int[n+1];
      parent = new int[n+1];
      visited = new boolean[n+1];

      BFS(1);
      LCA(a, b);
   }

   static int LCA(int a, int b){
      if(depth[a] < depth[b]){
         int temp = a;
         a = b;
         b = temp;
      }
      while(depth[a] != depth[b]){
         a = parent[a];
      }
      while(a != b){
         a = parent[a];
         b = parent[b];
      }

      return a;
   }

   static void BFS(int node){
      Queue<Integer> q = new LinkedList<>();
      q.add(node);
      visited[node] = true;

      int level = 1;
      int nowSize = 1;
      int cnt = 0;
      while(!q.isEmpty()){
         int now = q.poll();
         for(int next : tree[now]){
            if(!visited[next]){
               visited[next] = true;
               q.add(next);
               parent[next] = now;
               depth[next] = level;
            }
         }
         cnt++;
         if(cnt == nowSize){
            cnt = 0;
            nowSize = q.size();
            level++;
         }
      }
   }
}
```

### 최소 공통 조상 빠르게 구하기
빠르게 구하는 방식의 핵심은 서로의 깊이를 맞춰 주거나 같아지는 노드를 찾을 때 기존에 한 단계씩 올려 주는 방식에서 2^K씩 올라가 비교하는 것이다.
따라서 기존에 자신의 부모 노드만 저장해 놓던 방식에서 2^K번째 위치의 부모 노드까지 저장해 둬야 한다.

1. 부모 노드 저장 배열 P 만들기
   1. 부모 노드 배열의 정의 : `P[K][N] = N번 노드의 2^K번째 부모의 노드 번호`
   2. 부모 노드 배열의 점화식 : `P[K][N] = P[K-1][P[K-1][N]]`
   3. 점화식에서 N의 2^3번째 부모 노드는 N의 2^2번째 부모 노드의 2^2번째 부모노드라는 의미이다.
   4. 예를 들어 N의 8번째 부모 노드는 N의 네번째 부모 노드의 네번째 부모노드이다.
   5. 배열에서 K는 `트리의 깊이 > 2^K`를 만족하는 최댓값이다.
2. 선택된 두 노드의 깊이 맞추기
   1. 2^K 단위로 넘어가면서 깊이를 맞춘다.
   2. 두 노드의 높이 차이 M을 구하고, 2^K <= M을 만족하면서 K가 최대가 되는 만큼 이동하면서 높이 차이가 0이 될 때까지 반복한다.
   3. 예를 들어 높이 차이가 20이라면, 2^4<= 20 이므로 `P[4][N]`으로 16번째로 점프 -> 2^2<=4 이므로 `P[2][N]`으로 4번째 부모로 점프함 
3. 최소 공통 조상 찾기
   1. 마찬가지로 2^K 단위로 점프하면서 맞춘다.
   2. K값을 1씩 감소하면서 P 배열을 이용해 최초로 두 노드의 부모가 달라지는 값을 찾는다.
   3. 두 노드의 부모가 같으면 K를 1씩 감소하고, 이를 K가 0이 될 때까지 반복한다.
   4. 반복문이 종료된 후 이동한 2개의 노드가 같은 노드라면 해당 노드가, 다른 노드라면 바로 위의 부모 노드가 최소 공통 조상이 된다.

```java
public class LCA2 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;
    static int kMax; // 트리의 최대 가능 높이

    public static void main(String[] args) {
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            adj[a].add(b);
            adj[b].add(a);
        }

        depth = new int[N+1];
        visited = new boolean[N+1];

        // 최대 가능 높이 구하기
        int temp = 1;
        kMax = 0;
        while(temp <= N) {
            temp *= 2;
            kMax++;
        }

        parent = new int[kMax+1][N+1];
        BFS(1); // parent와 depth 배열 초기화
        // 점화식으로 k번째 부모 노드의 값 채우기
        for(int k = 1; k <= kMax; k++) {
            for(int n = 1; n <= N; n++) {
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        LCA(a,b);
    }

    static int LCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 1. depth 맞추기
        for(int k = kMax; k >= 0; k--) {
            if(Math.pow(2, k) <= depth[a] - depth[b]){
                a = parent[k][a];
            }
        }

        //depth를 맞췄는데 조상이 같으면 바로 종료
        if(a==b) return a;

        // 2. LCA 찾기 : 2^K승 점프를 하면서 공통부모 바로 아래까지 올리기
        for(int k = kMax-1; k >= 0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // 공통부모 바로 아래에서 반복문이 끝났으므로, 첫 번째 부모(2^0)을 리턴
        return parent[0][a];
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next: adj[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = depth[now]+1;
                    q.add(next);
                }
            }
        }
    }
}
```

---
# 기하
## CCW(Counter-ClockWise)
코딩 테스트에서의 기하 알고리즘은 모두 CCW(counter-clockwise)라는 기하학적 성질을 이용해 출 수 있다.
CCW는 평면상의 3개의 점과 관련된 점들의 위치 관계를 판단하는 알고리즘이다.
세 점을 `A(X1, Y1), B(X2, Y2), C(X3, Y3)`라고 가정했을 때 CCW의 공식은 다음과 같다.

- `CCW = (X1Y2 + X2Y3 + X3Y1) - (X2Y1 + X3Y2 + X1Y3)`
- `|CCW결괏값| / 2 = 세 점으로 이뤄진 삼각형의 넓이`

### 공식 도출 과정
1. 1번째 점을 뒤에 한 번 더 쓴다.
2. 오른쪽 아래 방향 화살표 곱은 더하고, 왼쪽 아래 방향 화살표의 곱은 뺀다.
```text
X1 X2 X3 X1     X1 X2 X3 X1
  \  \  \    -    /  /  /
Y1 Y2 Y3 Y1     Y1 Y2 Y3 Y1
```

이렇게 세 점이 주어졌을 때 CCW 공식을 사요해 세 점에 관한 다양한 관계를 도출할 수 있다.
CCW는 부호에 따라 다음과 같은 3가지 의미가 있다.
- CCW 결과 < 0 : 세 점이 시계 방향으로 배치됨
- CCW 결과 == 0 : 세 점이 일직선으로 배치됨
- CCW 결과 > 0 : 세 점이 반시계 방향으로 배치됨
그리고 부호와는 별개로 CCW 결과의 절댓값은 세 점의 벡터의 외적값을 나타내고,
CCW의 절댓값을 절반으로 나누면 세 점으로 이뤄진 삼각형의 넓이를 나타낸다.
또한, 보통 CCW를 계산하는 과정에서 곱셈으로 인해 오버플로우가 발생할 수 있다. 그래서 long 형으로 선언해야 한다.

```java
public class CCW {
    public static void main(String[] args) {
        int x1, y2, x2, y2, x3, y3;
        int ccw = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        
        if(ccw < 0) System.out.println("시계방향");
        else if(ccw == 0) System.out.println("일직선");
        else if(ccw > 0) System.out.println("반시계방향");
    }
}
```
세 점의 위치관계에 대해서 시계 방향과 반시계 방향으로 표현하는 것을 정리하면,
어떤 직선 AB에 대해 마지막 점 C(X3, Y3)가 왼쪽에 있으면 시계 방향, 오른쪽에 있으면 반시계 방향이라고 정리할 수 있다.
```text
    A         A
C   |    or   |   C
    B         B
(시계방향)  (반시계방향)
```

### 선분 AB와 CD의 교차 여부를 구하시오.
```java
public class CCW { // 선분의 교차여부
    public static void main(String[] args) {
        // A(x1, y1), B(x2, y2), C(x3, y3), D(x4, y4)
        int ABC = CCW(x1, y1, x2, y2, x3, y3);
        int ABD = CCW(x1, y1, x2, y2, x4, y4);
        int CDA = CCW(x3, y3, x4, y4, x1, y1);
        int CDB = CCW(x3, y3, x4, y4, x2, y2);

        boolean cross = false;
        if(ABC*ABD == 0 && CDA*CDB == 0) { // 일직선 상에서 만남
            cross = isOverlab(AB, CD);
        } else if(ABC*ABD <= 0 && CDA*CDB <= 0) { // 두 선분이 만남
            cross = true;
        }

    }

    static int CCW (long x1, long y1, long x2, long y2, long x3, long y3) {
        long ccw = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3); // 곱셈 중 오버플로우 발생 -> long 형으로 선언
        if(ccw < 0) return -1; // 왼쪽
        else if(ccw > 0) return 1; // 오른쪽
        else return 0;
    }

    public static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
        &&  Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3,y4) <= Math.max(y1, y2)){
            return true;
        }
        return false;
    }
}
```

### 원점과 다른 두 점 사이의 CCW 공식
```text
CCW = (X1Y2 + X2Y3 + X3Y1) - (X2Y1 + X3Y2 + X1Y3)
    = (X1Y2 + 0 + 0) - (X2Y1 + 0 + 0)
    = X1Y2 - X2Y1
```
원점과 다른 두 점 사이의 CCW로 다각형의 넓이를 구할 수 있다.
- 원점과 다른 두 점이 반시계 방향이면 넓이가 양수로 나옴
- 원점과 다른 두 점이 시계 방향이면 넓이가 음수로 나옴


---


















