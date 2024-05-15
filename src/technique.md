# 시간복잡도를 줄이는 테크닉
- [Prefix Sum](#prefix-sum) : 누적합을 이용해 시간복잡도 최적화
- [Grid Compression](#grid-compression) : 좌표 압축으로 시간, 공간 복잡도 줄이기
- [LR Technique](#lr-technique) : 왼쪽, 오른쪽에서 미리 한번 순회하여 정답을 빠르게 찾기
- [+1-1 Technique](#-1-1-technique) : 구간의 양 끝에 +1-1을 하여 빠르게 원하는 값을 계산
- [전처리](#전처리) : 전처리를 통해 미리 필요한 값을 추려 시간 복잡도 줄이기
- [Two Pointer](#two-pointer) : 2개의 포인터를 앞으로만 끌고 나가 시간복잡도 줄이기

# Prefix Sum
누적합 배열을 만드는 데에는 시간이 O(N)만큼 소요된다.

- 합 배열 S의 정의 : `S[i] = A[0] + A[1] + A[2] + ... + A[i-1] + A[i]`
- 합 배열 만드는 공식 : `S[i] = S[i-1] + A[i]`
- 구간 합 구하는 공식 : `S[j] - S[i-1]` // i에서 j까지 구간 합
- 2차원 구간 합 배열 D 정의 : `D[X][Y] = 원본 배열의 (0, 0)부터 (X, Y)까지의 사각형 영역 안에 있는 수의 합`
- `D[i][j]` 만드는 공식 : `D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]`
- 구간 합 구하는 공식 : `D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]`

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 6, 2, 6, 7, 7, 2};
        int[] prefixSum = new int[8];

        prefixSum[0] = 0;
        for(int i = 1; i <= 7; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        // 구간 [2, 5]까지 합 = 21
        System.out.println(prefixSum[5] - prefixSum[1]);
        // 구간 [1, 5]까지 합 = 24
        System.out.println(prefixSum[5] - prefixSum[0]);
    }
}

```

# Grid Compression
좌표 압축 문제)
```text
정점 번호가 1에서 10^9 사이의 값으로 이루어져 있는 그래프가 하나 주어졌을 때,

1번 정점에서 시작하여 방문 가능한 서로 다른 노드의 수를 구하는 프로그램을 작성해보세요.
```
일반적인 DFS 탐색은 1~N번 정점까지 번호가 매겨져 있기 때문에, 큰 문제없이 크기가 N인 인접리스트를 만들어 해결할 수 있다.
하지만 위와 같이 정점 번호가 1에서 10^9 사이로 주어진 경우에는 기존 방법으로 해결하기 어렵다.

이때 좌표 압축 기술을 사용할 수 있다.
주어진 정점 번호를 오름차순으로 나열하여 다시 번호를 1번부터 순서대로 매겨준다. 즉 다음과 같이 번호를 변경하는 작업을 진행한다.
```text
1     -> 1
4     -> 2
6     -> 3
7     -> 4
30    -> 5
2,000 -> 6
10^9  -> 7
```

1. 먼저 입력으로 들어온 모든 값을 TreeSet에 넣어준다.
2. 작은 숫자부터 순서대로 뽑아, 각 숫자에 번호를 매기고 그 결과를 HashMap에 넣어준다.
   - 위의 예에서는 (1, 1), (4, 2), (6, 3), (7, 4), (30, 5), (2000, 5), (10^9, 7) 형태
3. HashMap을 이용해 주어진 정점 번호를 1에서 N번 사이로 변경해줄 수 있다.

```java
import java.util.TreeSet;
import java.util.HashMap;

class Pair {
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
};

public class Main {
    public static void main(String[] args) {
        Pair[] edges = new Pair[]{ // 그래프를 표현하는 에지리스트
            new Pair(1, (int)1e9),
            new Pair(1, 2000),
            new Pair(1, 4),
            new Pair(30, (int)1e9),
            new Pair(6, 7),
        };
        
        TreeSet<Integer> nums = new TreeSet<>();

        // 사용되는 모든 번호를 TreeSet에 넣는다.
        for(int i = 0; i < 5; i++) {
            nums.add(edges[i].x);
            nums.add(edges[i].y);
        } 

        // TreeSet에서 정점을 작은 번호부터 뽑으면서
        // 각 정점별로 1번부터 순서대로 매칭하여
        // 그 결과를 HashMap에 넣어준다.
        HashMap<Integer, Integer> mapper = new HashMap<>();
        int cnt = 1;

        // 이떄 TreeSet 순회는 간단하게
        // Integer num : nums 형태로 가능하다.
        for(Integer num : nums) {
            mapper.put(num, cnt);
            // 기존 정점번호마다 어떤 번호로
            // 정해졌는지를 출력해봅니다.
            System.out.println(num + " -> " + cnt);
            cnt++;
        }
        
        // 주어진 간선을 이루는 정점 번호를
        // 새로운 정점 번호로 변경해줍니다.
        for(int i = 0; i < 5; i++)
            edges[i] = new Pair(
                mapper.get(edges[i].x),
                mapper.get(edges[i].y)
            );
    }
}

/* 출력:
1 -> 1
4 -> 2
6 -> 3
7 -> 4
30 -> 5
2000 -> 6
1000000000 -> 7
*/
```

# LR Technique
왼쪽, 오른쪽에서 미리 한번 순회하여 정답을 빠르게 찾는 법



# +1-1 Technique
구간의 양 끝에 +1-1을 하여 빠르게 원하는 값을 계산하는 법



# 전처리
전처리를 통해 미리 필요한 값을 추려 시간 복잡도를 줄이는 법



# Two Pointer
2개의 포인터를 앞으로만 끌고 나가 시간복잡도를 줄이는 법


