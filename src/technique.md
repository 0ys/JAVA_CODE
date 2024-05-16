# 시간복잡도를 줄이는 테크닉
- [Prefix Sum](#prefix-sum) : 누적합을 이용해 시간복잡도 최적화
- [Grid Compression](#grid-compression) : 좌표 압축으로 시간, 공간 복잡도 줄이기
- [LR 배열](#lr-배열) : 왼쪽, 오른쪽에서 미리 한번 순회하여 정답을 빠르게 찾기
- [+1-1 가중치](#1-1-가중치) : 구간의 양 끝에 +1-1로 가중치를 주어 빠르게 원하는 값을 계산
- [전처리](#전처리) : 전처리를 통해 미리 필요한 값을 추려 시간 복잡도 줄이기
- [Two Pointer](#two-pointer) : 2개의 포인터를 앞으로만 끌고 나가 시간복잡도 줄이기

---
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

---
# Grid Compression
### 좌표 압축 문제)
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

### 구현)
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

---
# LR 배열
왼쪽, 오른쪽에서 미리 한번 순회하여 정답을 빠르게 찾는 법
### 대표 문제)
```text
[3, 6, 2, 6, 7, 5, 2] 와 같이 숫자들이 주어졌을 때,
다음 질의에 대해 답하는 프로그램을 작성해보세요.

단, 질의마다 하나의 숫자가 주어지며 
해당 번째 숫자를 제외한
다른 숫자들에 대해 인접한 숫자간의 차이의 합을 구해야 합니다.

예를 들어 질의로 5가 주어졌다면
5번째 숫자인 7을 제외한 다른 숫자들을 나열하면
[3, 6, 2, 6, 5, 2]가 되므로
인접한 숫자간의 차이의 합은
|3 - 6| + |6 - 2| + |2 - 6| + |6 - 5| + |5 - 2| = 15가 됩니다.

이때 주어지는 숫자는 1초과 N 미만임을 가정해도 좋습니다.
```
정직하게 구현하면 숫자가 주어질 때마다 남은 숫자 N-1개를 순회하므로 O(N)의 시간이 소요된다.
즉 질의의 개수를 Q라 했을 때 총 시간복잡도는 O(QN)이다.

LR 배열을 사용하면 이를 개선할 수 있다.

- L 배열 : `L[i] = L[i-1] + Math.abs(A[i]-A[i-1])` 1번부터 i번 까지의 답
- R 배열 : `R[i] = R[i+1] + Math.abs(A[i+1]-A[i])` 1번부터 N번 까지의 답

즉, LR 배열은 i번째 숫자를 제외했을 때 왼쪽 배열의 정답과 오른쪽 배열의 정답을 전부 미리 구해놓는다.
그래서 LR 배열만 O(N)에 구하면, 질의마다 시간복잡도 O(1)에 답을 구할 수 있으므로 
총 Q개의 질의에 대한 시간복잡도는 O(N+Q)가 된다.

```text
i =  1, 2, 3, 4, 5, 6, 7
A = [3, 6, 2, 6, 7, 5, 2]
  차이  3  4  4  1  2  3
L = [0, 3, 7, 11,12,14,15]
R = [17,14,10,6, 5, 3, 0]
```
### 구현)
```java
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 6, 2, 6, 7, 5, 2};
        int[] L = new int[8];
        int[] R = new int[8];
        int n = 7;

        // L 배열을 채워줍니다.
        L[1] = 0;
        for(int i = 2; i <= n; i++)
            L[i] = L[i - 1] + Math.abs(arr[i] - arr[i - 1]);
        
        // R 배열을 채워줍니다.
        R[n] = 0;
        for(int i = n - 1; i >= 1; i--)
            R[i] = R[i + 1] + Math.abs(arr[i + 1] - arr[i]);
        
        // 4번째 숫자를 제외했을 때의 답 = 17
        System.out.println(L[3] + R[5] + Math.abs(arr[5] - arr[3]));
        // 5번째 숫자를 제외했을 때의 답 = 15
        System.out.println(L[4] + R[6] + Math.abs(arr[6] - arr[4]));
    }
}
```

---
# +1-1 가중치
선분의 양 끝에 +1-1로 가중치를 주어 빠르게 원하는 값을 계산하는 법
겹치는 구간을 찾아내거나, 시기상 겹치는 프로세스들을 구별할 때 사용한다.
### 대표 문제)
```text
1차 수직선 상에 n개의 선분이 주어졌을 때, 
x = k 직선과 만나는 서로 다른 선분의 수는 몇 개인지를 판단하라.
단, 주어지는 x 좌표는 모두 다름을 가정해도 좋습니다.
```
x가 k인 직선이 만나는 선분의 개수를 구하기 위해서는
주어지는 선분마다 시작점에는 +1, 끝나는 점에는 -1을 적은 뒤, K 앞에 있는 점들에 적혀 있는 숫자를 전부 더하면 된다.
즉 k앞에 시작, 끝 지점이 전부 있는 선분은 0으로 처리되고, 시작점만 나온 선분들에 대해서 +1로 개수를 셀 수 있다.

1. 모든 선분 N개를 각각 시작점(+1), 끝점(-1)으로 구분하여 총 2N개의 점으로 나눈다.
2. 이를 x 좌표 순으로 오름차순 정렬한 뒤, x=k 보다 커지기 직전까지의 숫자를 전부 더한다.

이렇게 N개의 선분을 2개의 시작, 끝 정점으로 나눠 각각 +1, -1 가중치를 줘서 x가 증가하는 순서대로 정렬하는 방법을 +1-1 Technique라고 부른다.

### 구현 1)
좌표의 범위가 작을 때는 배열로 구현한다.
이때 배열의 크기는 최대 좌표의 범위만큼 잡아야 하며, 이후 각 칸을 x=1부터 최대 위치까지 순서대로 순회한다.
```java
class Segment {
    int x1, x2;

    public Segment(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
};

public class Main {
    public static void main(String[] args) {
        Segment[] segments = new Segment[]{
            new Segment(1, 5),
            new Segment(4, 7),
            new Segment(3, 6),
            new Segment(5, 10),
            new Segment(9, 13),
            new Segment(8, 15),
            new Segment(12, 16),
        };
        int n = 7;
        int k = 11;
        
        // 주어진 좌표의 범위가 작을 때에는
        // 배열을 이용하여 직접 각 칸에
        // +1 -1을 진행해도 무방합니다.
        int[] checked = new int[21];

        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            checked[x1] += 1;
            checked[x2] -= 1;
        }

        // x = k 전까지
        // 각 위치에 적혀있는 숫자들의 합을 구해줍니다.

        int sumVal = 0;
        for(int i = 1; i < k; i++)
            sumVal += checked[i];
        
        // x = k에 겹쳐져 있는 선분의 수 = 2
        System.out.println(sumVal);
    }
}
```

### 구현 2)
좌표의 범위가 클 경우 직접 양쪽 끝 점을 정렬해야 한다.
선분 N개를 각각 시작점, 끝점으로 구분ㅁ하여 총 2N개의 점으로 나누고 이를 x좌표 순으로 오름차순 정렬한다.
```java
import java.util.ArrayList;
import java.util.Collections;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
};

class Point implements Comparable<Point> {
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) { // x 오름차순
        return this.x - p.x;
    }
};

public class Main {
    public static void main(String[] args) {
        Segment[] segments = new Segment[]{
            new Segment(1, 5),
            new Segment(4, 7),
            new Segment(3, 6),
            new Segment(5, 10),
            new Segment(9, 13),
            new Segment(8, 15),
            new Segment(12, 16),
        };
        int n = 7;
        int k = 11;
        
        // 주어진 좌표의 범위가 큰 경우에는
        // 각 선분을 두 지점으로 나눠서
        // +1, -1로 담은 뒤,
        // 정렬해줍니다.
        ArrayList<Point> points = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Point(x1, +1)); // 시작점
            points.add(new Point(x2, -1)); // 끝점
        }

        // 정렬을 진행합니다.
        // ArrayList에 대한 정렬에는 Collections를 이용합니다.
        Collections.sort(points);

        // x = k 전까지
        // 각 위치에 적혀있는 숫자들의 합을 구해줍니다.
        int sumVal = 0;
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;

            // x가 k 이상이 되면 종료합니다.
            if(x >= k)
                break;

            // 적혀있는 가중치를 전부 더해줍니다.
            sumVal += v;
        }
        
        // x = k에 겹쳐져 있는 선분의 수 = 2
        System.out.println(sumVal);
    }
}
```

---
# 전처리
전처리를 통해 미리 필요한 값을 추려 시간 복잡도를 줄이는 법

### 대표 문제)
```text
[8, 2, 6, 7, 5, 3] 와 같이 숫자들이 주어졌을 때, 특정 위치를 적절하게 선택하여
해당 위치에 놓여있는 숫자와 그 숫자를 포함하여 뒤에 놓여있는 숫자들 중 최솟값을 곱한 값이 
최대가 되도록 하라.

만약 위의 예에서 1번째 위치를 골랐다면,
1번째 위치에는 숫자 8이 있고, 해당 위치에서부터 맨 뒤에 있는 숫자까지 중 최솟값은 2이므로
8 * 2 = 16이 됩니다.

하지만 만약 4번째 숫자를 골랐다면,
4번째 위치에는 숫자 7이 있고, 해당 위치에서부터 맨 뒤에 있는 숫자까지 중 최솟값은 3이므로
7 * 3 = 21로 최대가 됩니다.
```
정직하게 문제를 풀면, 각 위치를 한번씩 잡아보면서 그 뒤에 있는 숫자를 전부 보면서 최솟값을 찾아 곱하게 되므로
위치를 잡는데 O(N), 최솟값을 찾는데 최악에 O(N)이 소요되므로 총 시간복잡도는 O(N^2)이다.

이때 만약 R 배열이 있어, 최솟값을 전부 구해놓았다면 각 위치의 숫자 A[i]와 R[i]를 곱한 값 중 최댓값을 구하면 되므로 O(N)이 된다.
- `R[N] = A[N]`이며, N-1번부터 1번까지 아래 점화식으로 구함
- `R[i] = Math.min(R[i+1], A[i])`

### 구현)
```java
public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[]{0, 8, 2, 6, 7, 5, 3};
        int[] R = new int[7];
        int n = 6;

        // R 배열을 채워줍니다.
        R[n] = arr[n];
        for(int i = n - 1; i >= 1; i--)
            R[i] = Math.min(R[i + 1], arr[i]);
        
        // 답을 구해줍니다.
        int ans = INT_MIN;
        for(int i = 1; i <= n; i++)
            ans = Math.max(ans, arr[i] * R[i]);
        
        // 가능한 최댓값 = 21
        System.out.print(ans);
    }
}
```

---
# Two Pointer
2개의 포인터를 앞으로만 끌고 나가 시간복잡도를 줄이는 법

### 대표 문제)
```text
[6, 3, 2, 4, 9, 1] 와 같이 숫자들이 주어졌을 때,
특정 구간을 잘 골라 구간 내 숫자의 합이 10을 넘지 않으면서
가장 큰 구간의 크기를 구하는 프로그램을 작성해보세요.
```
정직하게 구현하면, 모든 구간 O(N^2)개를 잡아보면서 그 안에 있는 숫자를 전부 더해 합이 10이 넘지 않는 경우 중
구간 크기의 최댓값을 구하면 되므로 O(N^3)이 소요된다.

하지만 이때 구간을 정한 뒤 구간 내 합을 구하는 것이 아니라, 
구간 내 시작점 i를 정하고 시작점 i로부터 합이 10이 넘지 않는 가장 멀리 있는 구간의 끝 j를 정하는 식으로 진행한다면
O(N^2)으로도 문제에서 원하는 최대 구간의 크기를 구할 수 있다.
```java
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 6, 3, 2, 4, 9, 1};
        int k = 10;
        int n = 6;

        // 가능한 구간 중 최대 크기를 구합니다.
        int ans = 0;

        // 모든 구간을 탐색합니다.
        for(int i = 1; i <= n; i++) {
            // 구간 내 합이 10을 넘지 않을때까지 계속 진행합니다.
            int sumVal = 0;
            for(int j = i; j <= n; j++) {
                sumVal += arr[j];
                
                // 구간 내 합이 10을 넘게되면 그만 진행합니다.
                if(sumVal > k)
                    break;

                // 현재 구간 [i, j]는 
                // 유효한 구간이므로
                // 구간 크기 중 최댓값을 갱신합니다.
                ans = Math.max(ans, j - i + 1);
            }
        }

        // 조건을 만족하는 가장 큰 구간의 크기는
        // [3, 2, 4]로 3이 됩니다.
        System.out.print(ans);
    }
}
```

그리고 더 나아가 투 포인터를 사용하면 O(N)으로 개선할 수 있다.
위의 예시를 잘 생각해보면 i가 1씩 늘어날 때마다, 최대로 뻗어나갈 수 있는 j의 위치는 항상 같거나 증가한다.
왜냐하면 i가 1 증가하면 합이 A[i]만큼 감소하기 때문에 그만큼 더 뒤로 이동할 수 있는 여유 공간이 생기기 때문이다.

이렇듯 문제에서 특정 조건에 의해 원하는 구간의 양 끝을 나타내는 2개의 포인터가 한 방향으로만 계속 전진하는 형태의 테크닉을 투포인터라고 한다.
투포인터를 이용해 i가 1 증가했을 때 j는 이전 값에서 시작하여 감소시키지 않고 뻗어나갈 수 있는 최대로 뻗어나가도록 진행을 하면
i, j 모두 한 방향으로만 진행하기 때문에 시간복잡도는 O(N)이 된다.

### 구현)
실제 2중 for문으로 작성되어 있지만, i, j 모두 한 방향으로만 진행하기 때문에 시간복잡도가 두 반복문의 곱이 아닌, 합으로 나타난다.
```java
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 6, 3, 2, 4, 9, 1};
        int k = 10;
        int n = 6;

        // 가능한 구간 중 최대 크기를 구합니다.
        int ans = 0;
        
        // 구간을 잡아봅니다.
        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 구간 내 합이 10을 넘지 않을때까지 계속 진행합니다.
            while(j + 1 <= n && sumVal + arr[j + 1] <= k) {
                sumVal += arr[j + 1];
                j++;
            }
            
            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 긴 구간이므로
            // 구간 크기 중 최댓값을 갱신합니다.
            ans = Math.max(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // arr[i]에 해당하는 값은 구간에서 제외시킵니다.
            sumVal -= arr[i];
        }

        // 조건을 만족하는 가장 큰 구간의 크기는
        // [3, 2, 4]로 3이 됩니다.
        System.out.print(ans);
    }
}
```



