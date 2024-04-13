# 2024 상반기 LINE ADS AI/ML 인턴십
- 2시간 동안 3문제
- 문제 제한 시간 10초, 제한 메모리 2MB? 널널했음
- 입력으로 주어지는 값도 크지 않음 -> 최적화를 요구하지는 않음
- 화면 녹화 등 감시가 없어서 검색 및 IDE 사용이 자유로움
- 문제 난이도는 쉬운편 - 리팩토링 및 주석을 신경씀

## 문제 설명
1. String을 다룰 수 있는지 묻는 간단한 문제 = `codingtest/LINE_ADS`
2. 교집합을 찾는 문제 : retainAll() 사용 = `codingtest/LINE_ADS_7LED`
3. 그래프를 판단하는 문제
    1. 루트가 없는 포레스트가 홀짝트리 또는 역홀짝트리가 가능한지 판단
        2. 홀수 노드는 홀수 숫자를 가지며, 자식 노드 또한 홀수 개를 가짐
        3. 짝수 노드는 짝수 숫자를 가지며, 자식 노드 또한 짝수 개를 가짐
        4. 역홀수 노드는 홀수 숫자를 가지지만, 자식 노드는 짝수 개임
        5. 역짝수 노드는 짝수 숫자를 가지지만, 자식 노드는 홀수 개임
        6. 홀짝트리는 홀수 노드 또는 짝수 노드만을 가짐
        7. 역홀짝트리는 역홀수 노드 또는 역짝수 노드만을 가짐
    8. 어떤 포레스트에서 루트를 지정했을 때 홀짝트리 또는 역홀짝트리가 되는지 여부를 출력