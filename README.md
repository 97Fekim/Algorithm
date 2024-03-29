# Algorithm
🗝<br>
## 오답노트
- [오답노트로 이동](https://github.com/97Fekim/Algorithm/blob/master/%EC%98%A4%EB%8B%B5%EB%85%B8%ED%8A%B8.md)
## BOJ 풀이
- [코드로 이동](https://github.com/97Fekim/Algorithm/tree/master/src/BAEKJOON)
## LeetCode 풀이
- [문제풀이](https://velog.io/@16fekim?tag=leetcode)
## Cos Pro 1급 대비 문제풀이
- [키워드 정리](https://github.com/97Fekim/Algorithm/blob/master/CosPro.md)
## [자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비] ,인프런
- [코드로 이동](https://github.com/97Fekim/Algorithm/tree/master/src/Inflearn)
- [강의 문제 풀이](https://github.com/97Fekim/Algorithm/blob/master/Inflearn%20Algorithm%20Basic.md)
- [문제 유형별 키워드](https://velog.io/@16fekim/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%A4%80%EB%B9%84)
## 마구잡이 정리 노트
- 정렬된 배열 순회시 <strong>이분 검색(Binary Search)</strong> 고려하기
```java
/**
 * Collections.binarySearch 를 활용하면 이분탐색을 아주 쉽게 구현할 수 있다.
 */
// 원소가 위치하고 있는 인덱스를 리턴한다.
int index = collections.binarySearch(list, cur);
// 해당원소가 리스트에 없다면, 들어가야 할 자리를 리턴한다. 이때 index가 3이라면, (-3-1)을 리턴한다.
if (index < 0) {
    index = Math.abs(index + 1);
}
// 찾아낸 index에 원소를 삽입한다.
list.add(index, cur);
````
- 무언가 연결해야 한다면 <strong>리스트</strong> 고려하기
- 쌍을 맞춰야 하는 연산자, 수식이 있다면 <strong>스택</strong> 고려하기
- 정렬된 배열을 다룬다면 <strong>투포인터</strong> 고려하기
- 배열에서 특정 구간씩 다룰때, <strong>슬라이딩 윈도우</strong> 고려하기
- 배열에서 범위가 어느정도 정해진 정답을 구해야 할때, <strong>결정 알고리즘</strong> 고려하기
- 소수와 관련된 문제라면 <strong>에라토스테네스의 체</strong> 이용하기
- 배열의 중복을 제거해야 하는 문제라면 <strong>HashMap 이나 HashSet</strong> 이용하기
- 최소공배수와 관련된 문제라면 <strong>GCD(Greate Common Devisior)</strong> 이용하기
- 불필요하게 반복 호출되는 재귀 (예를들면 피보나치, 조합, 등)는 <strong>메모이제이션</strong>을 통해 시간복잡도를 줄일 수 있다.
- 2차원, 3차원 배열로 주어진 그래프의 탐색 문제는 <strong>거리 정보를 담은 dx, dy 배열</strong> 이용하기
- BFS, DFS 구현시 check 배열의 범위를 초과해 발생하는 NullPointerException 주의. 
- 여러 개의 순서쌍이 주어지는 문제라면, 한 종류를 정렬 후 <strong>그리디 알고리즘</strong>으로 풀 수 있을지 고려하기
- 배열의 최솟값이나 최댓값을 이용해야 하는데 시간 복잡도를 O(logn)으로 줄여야 한다면 <strong>PrioriryQueue</strong> 이용하기
- 가중치 그래프의 최단거리를 구할때 <strong>다익스트라 알고리즘</strong> 고려하기
- 서로소인 집합인지 아닌지 확인해야 한다면 <strong>Union & Find</strong> 알고리즘 이용하기
- 최소한의 간선 갯수, 가중치로 모든 노드가 연결되게 만들어야 한다면 <strong>크루스칼</strong>이나 <strong>프림</strong>알고리즘 사용하기
