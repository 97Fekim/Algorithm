### 1) 문자열
<details>
<summary> <strong>1. 문자 찾기</strong> </summary>
- 소문자 &lt;-&gt; 대문자 변형시, <code>c = Character.to____Case(c) </code> 이용하여 변형한다.<br>
- 문자열에서 for-each 문을 돌릴때, <code>for(char c : str.toCharArray){} </code> 의 형태로, char 배열을 이용해서 for문을 돌려야 한다.<br>
</details>

 <details>
<summary> <strong>2. 대소문자 변환</strong> </summary>
- Character 클래스의 메소드중, <code>isLowerCase</code>와 <code>isUpperCase</code>를 이용해서 대문자인지 소문자인지 알 수 있다. <br>
</details>

<details>
<summary> <strong>3. 가장 긴 부분문자열</strong> </summary>
- nextLine()으로 줄바꿈 된 문자열을 입력 받는다.<br>
- <code>String[] strs = String.split("CH") </code>로 <code>"CH"</code>을 기준으로 쪼개진 문자열 배열을 얻는다.<br>
- <code>int pos = str.indexOf("CH")</code> 로, <code>"CH"</code> 문자가 있는 인덱스를 pos에 반환받는다. 발견하지 못하면, pos에 -1를 리턴한다.<br>
- <code>String temp = str.substring(index1, index2)</code> 로, index1 ~ index1 의 부분 문자열을 temp에 담을 수 있다<br>
- <code>String temp = str.substring(index1)</code> 로, index1 부터 시작하는 부분 문자열을 temp에 담을 수 있다<br>
</details>

<details>
<summary> <strong>4. 단어 뒤집기</strong> </summary>
- ArrayList&lt;String&gt; 활용<br>
- StringBuilder의 reverse 메소드 활용<br>
- 손코딩시에는, 왼쪽 오른쪽을 lt rt로 지정하여, while(lt&lt;rt) 루프 활용<br>
- <code>String str = String.valueOf(char[] temp)</code> 로, char 배열을 String으로 변환 가능하다.<br>
</details> 
 
<details>
<summary> <strong>5. 특정문자 뒤집기</strong> </summary>
- <code>while(lt &lt; rt)</code> 를 항상 기억<br>
- 특정문자일 경우에만 lt를 증가시키거나 rt를 감소시키는 로직으로 구현.<br>
- <code>Character.isAlphabetic(CH)</code> 메소드 활용 (특정 문자가 알파벳임을 확인)<br>
- char[] 를 String으로 변환하려면 반드시 <code>String str = String.valueOf(char[])</code> 을 활용해라.<br>
</details>
 
<details>
<summary> <strong>6. 중복 문자 제거</strong> </summary>
- String 클래스의 indexOf()를 활용하여 해결한다.<br>
</details> 
 
<details>
<summary> <strong>7. 회문 문자열 </strong> </summary>
- lt, rt를 활용!<br>
- StringBuilder의 reverse를 활용하여 비교할때는, String의 equalsIgnoreCase 메소드를 이용하여 비교하면 대소문자를 무시하고 비교 가능하다.<br>
</details>  
 
<details>
<summary> <strong>8. 유효한 회문 문자열 </strong> </summary>
- <code>str = str.replaceAll("[^A-Z]","")</code>로 A-Z가 아닌 모든 문자를 ""로 변환 가능하다.<br>
- 세가지 풀이가 가능하다<br>
- 1) if-elseif-else 구문으로 문자만 체크해서 lt,rt를 증감 시키는 로직<br>
- 2) replaceAll과 toUpperCase로 대문자 알파벳만 남긴 후 lt,rt 를 활용하는 로직<br>
- 3) replaceAll과 toUpperCase로 대문자 알파벳만 남긴 후, StringBuilder의 reverse를 활용하는 로직<br>
</details>
 
<details>
<summary> <strong>9. 숫자만 추출 </strong> </summary>
- 세 가지 풀이가 가능하다.
- 1) parseInt 활용 : <code>int n = Integer.parseInt(str)</code>를 활용해 String -&gt; int 형 변환이 가능하다. 이때, 맨앞 0을 사라진다.<br>
- 2) isDigit 활용 : <code>Character.isDigit(ch)</code>을 활용해 문자가 숫자인지 확인하여 해결 가능하다.<br>
- 3) 곱셈 로직 활용 : ascii 넘버를 활용하여, int 변수 answer에 값을 축적시킨다. 0~9는 ascii표에서 48 ~ 57에 대응한다.<br>
</details>   
 
<details>
<summary> <strong>10. 문자 거리 </strong> </summary>
- step1) 거리를 나타낼 변수 p를 1000으로 초기화한다.<br>
- step2) for문을 앞에서부터 한번 돌면서, e를 만나면 0으로 초기화하고 e가 아니면 1씩 증가시키며 배열에 넣는다.<br>
- step3) for문을 뒤에서부터 다시 돌면서 똑같이 배열에 넣는데, 이때는 p값과 원래 int 배열의 값을 비교하여 작은 값을 넣는다, <code>Math.min(answer[i], p)</code> 활용<br>
</details>  
 
<details>
<summary> <strong>11. 문자 압축 </strong> </summary>
- StringBuilder를 이용<br>
- count를 누적시키는 방법을 이용<br>
- <strong>마지막에 빈문자를 넣어줄것!!! <code> str += " ";</code></strong><br>
</details> 
 
<details>
<summary> <strong>12. 암호 </strong> </summary>
- 반복문 속 substring 이용<br>
- <code>String temp = str.replace('#','1").replace('*','0')</code> 이용<br>
- <code>int num = Integer.parseInt(str,2)</code> 이용하여 이진수 문자열을 십진수로 변환<br>
</details>
 
### 2) 배열
<details>
<summary> <strong>1. 소수(에라토스테네스 체) </strong> </summary>
- 1) 입력된 정수의 개수만큼 공백 배열 생성 후, 순회<br>
- 2) 소수를 찾았다? &gt; answer 1증가.<br>
- 3) 그 소수만큼 이동하면서 모든 자리에 체크 (소수가 아님을 1로 표시)<br>
</details> 
 
<details>
<summary> <strong>2. 뒤집어진 소수 </strong> </summary>
- 1) (t = temp를 10으로 나눈 나머지) &gt; (res = res*10 + t) &gt; (temp를 10으로 나누기) 로직으로 정수 뒤집기<br>
- 2) 뒤집어진 정수를 소수 판단 함수로 보내기<br>
- 3) 소수 판단 함수 : 약수가 있다( if(res%i != 0)사용) &gt; false<br>
</details> 
 
<details>
<summary> <strong>3. 봉우리 </strong> </summary>
- 1) Out of index 에러 주의!<br>
- 2) int[] dx = {1,0,-1,0}; <br>
- 3) int[] dy = {0,1,0,-1}; dx, dy 두 배열을 이용하여, 양옆좌우를 손쉽게 탐색<br>  
</details> 
  

### 3) 투 포인터 / 슬라이딩 윈도우
<details>
<summary> <strong>1. 두 배열 합치기 </strong> </summary>
- 오름차순 돼 있는 두 배열을 더해서 다시 정렬을 하면, 시간 복잡도가 nlogn 이 된다. 이를 투 포인터를 사용하면 O(n)으로 구현 가능하다 <br>
</details> 
 
<details>
<summary> <strong>2. 공통 원소 구하기 </strong> </summary>
- 결과가 오름차순 정렬되어 있어야 하므로, 반드시 입력 배열 둘다 미리 오름차순 정렬해야 한다. <br>
- 1) 두 배열을 <code>Arrays.sort</code>를 이용해 정렬한다.
- 2) 오름차순 정렬된 두 배열을 비교한다.<br>
- 3) 값이 작은 위치의 포인터를 증가시킨다.<br>
- 4) 값이 같다면 두 포인터를 모두 증가시킨다.<br> 
</details> 
 
<details>
<summary> <strong>3. 최대 매출 </strong> </summary>
- 슬라이딩 윈도우를 이용한다.<br>
- 배열의 특정 구간을 다뤄야 하는 문제를 풀때, 이중 for문 대신에 사용한다,<br>
</details> 

<details>
<summary> <strong>4. 연속 부분 수열 </strong> </summary>
- 투 포인터를 이용한다.<br>
- 부분합이 타겟보다 작다면, rt를 증가한다. 증가 후 비교한다.<br>
- 부분합이 타겟보다 크다면, lt를 증가한다. 비교 후 감소한다.<br>
- 제1 for문에 rt 를 iterator로 넣는 로직을 사용한다.(어차피 rt는 끝까지 가야하기 때문)<br> 
</details>
 
<details>
<summary> <strong>5. 연속된 자연수의 합 </strong> </summary>
- 투 포인터를 이용한다.<br>
- n이 1000이라면, 1~500 까지만 배열에 넣는다.(500 이후부터는 절대 두수의 합이 1000이 될 수 없으므로)<br>
- 이후 연속 부분 수열의 로직을 똑같이 사용한다. (1반복문의 itrerator로 rt를 기억!)<br>
- 수학적 알고리즘을 활용해서도 풀이가 가능하다.(딱 떨어지는 나머지를 활용)<br>
</details> 
 
<details>
<summary> <strong>6. 최대길이 연속부분수열 </strong> </summary>
- 투 포인터를 이용한다.<br>
- <strong>제1 for문의 iterator를 rt로 지정</strong>하는 점에 유의한다.<br>
- 다른 투포인터 예제들과 마찬가지로, <strong>rt가 증가하다가, target보다 넘어서는 지점이 생기면, lt증가 while문에 걸리도록 로직을 구성한다.</strong>
</details>

### 4) HashMap, TreeSet (해쉬, 정렬지원 Set)

<details>
<summary> <strong>1. 학급 회장 </strong> </summary>
- <code>map.put(x, map.getOrDefault(x,0)+1);</code>를 이용해, 각 알파벳을 카운트하여 맵이 넣는다.<br>
- keySet으로 순회하며, value중 가장 큰 값을 찾는다. <br>
- etc : map.containsKey(key), map.containsValue(value), map.size(), map.remove()<br>
</details> 
 
<details>
<summary> <strong>2. 아나그램 </strong> </summary>
- 풀이1) 해쉬맵 두개를 만들어 비교한다.<br>
- 풀이2) 해쉬맵 하나를 채운뒤, 두번째 해쉬맵을 빼면서 비교한다.<br>
</details> 
 
<details>
<summary> <strong>3. 매출액의 종류 </strong> </summary>
- 슬라이딩 윈도우를 이용한다.<br>
- 제1 for문에 rt를 iterator로 지정한다.<br>
- map에서 arr[lt]를 제거한 후, value값이 0인지 반드시 체크한다.<br>
</details>
 
<details>
<summary> <strong>4. 모든 아나그램 찾기 </strong> </summary>
- 슬라이딩 윈도우를 이용한다<br>
- 제1 for문에 rt를 iterator로 지정한다.<br>
- map에서 arr[lt]를 제거한 후, value값이 0인지 반드시 체크한다.<br>
</details>
 
<details>
<summary> <strong>5. k번째 큰 수 </strong> </summary>
- 배열의 모든 3중 합을 구하려면, 3중 for문을 이용하여 i=0부터, j는 i+1부터, k는j+1부터로 돌린다.<br>
- 중복 제거를 위해 HashSet을 이용한다. <br>
- HashSet 관련 메소드에는 add, remove, size, first, last가 있다.<br>
</details>
 
### 5) Stack, Queue
<details>
<summary> <strong>1. 올바른 괄호 </strong> </summary>
- 문제가 <strong>괄호를 다룬다면</strong> 10중8,9 stack을 사용하는 문제다<br>
- 1) '('가 들어올때, -&gt; push()<br>
- 2) ')'가 들어올때,<br>
- 2-1) 스택이 공백이라면 -&gt; return "NO"<br>
- 2-2) 그 외의 경우에는 -&gt; pop()<br>
</details>
 
<details>
<summary> <strong>2. 괄호문자 제거 </strong> </summary>
(풀이1)<br>
- 1) '('가 들어올때, -&gt; push()<br>
- 2) ')'가 들어올때, -&gt; pop()<br>
- 3) 알파벳이 들어올때, 스택이 비어있다면 -&gt; answer에 알파벳 추가<br>
(풀이2)<br>
- 1) ')'가 들어올때, -&gt; '('를 만날때까지 pop() -&gt; <code>while(stack.pop()!='(');(</code><br>
- 2) 그 외의 모든 문자 -&gt; push()<br>
- 3) answer에 stack.get()으로 stack의 첫 index부터 삽입<br>
</details>

<details>
<summary> <strong>3. 크레인 게임 </strong> </summary>
- pop()을 하기전, 스택이 공백인지 check한다.<br>
</details>
 
<details>
<summary> <strong>4. 후위식 연산(postfix) </strong> </summary>
- char -&gt; int 변환은 <code>int n = c - '0';</code>을 이용한다<br>
- 연산을 할때 pop()의 순서에 주의한다. (거꾸로 연산될 수도 있음을 유의)<br> 
</details>
 
<details>
<summary> <strong>5. 공주 구하기</strong> </summary>
- 큐의 선언 : <code>Queue&lt;Integer&gt; Q = new LinkedList&lt;&gt;();</code><br>
- 큐 관련 메소드 : offer(), poll(), peek(), size(), isEmpty(), comtains()<br> 
</details> 
 
<details>
<summary> <strong>6. 커리큘럼 설계</strong> </summary>
- <br>
</details>

<details>
<summary> <strong>7. 응급실</strong> </summary>
- 중복되는 위험도에 대해 특정 index를 부여하기 위해, id와 priority를 가진 Person 객체를 생성한다. <br>
- priorty를 비교하며 poll()과 offer()를 수행하고 최종적으로 id를 비교하여 문제를 해결한다.<br>
</details>

### 5) Sorting and Searching(정렬, 이분검색과 결정알고리즘)
<details>
<summary> <strong>1. 선택정렬</strong> </summary>
- 1) 제1 for문(i=0 ~ i=len-1)의 시작에서 idx에 i를 넣는다.<br>
- 2) 제2 for문(j=i+1 ~ j=len)을 돌며 가장 큰 혹은 작은 값의 index를 찾아 idx에 넣는다.<br>
- 3) 제1 for문의 끝에서 arr[i]와 arr[idx]를 스위칭한다.<br>
</details>

<details>
<summary> <strong>2. 버블정렬</strong> </summary>
- 현재와 다음 배열값을 비교하며 밀고 나가여,<br>
- [ _ , _ , _ , _ , _ , max ]<br>
- [ _ , _ , _ , _ , second , max ]<br>
- [ _ , _ , _ , third , second , max ]<br>
- 혹은<br>
- [ _ , _ , _ , _ , _ , min ]<br>
- [ _ , _ , _ , _ , second , min ]<br>
- [ _ , _ , _ , third , second , min ]<br>
- 의 형태로 남겨가며 정렬을 진행한다.<br>
</details>

<details>
<summary> <strong>3. 삽입정렬</strong> </summary>
- 1) 제1 for문(i=1 ~ i=len)의 시작에서 tmp에 arr[i]를 넣는다.<br>
- 2) 제2 for문(j=i-1 ~ j=0)을 돈다<br>
- 2-1) arr[j]가 tmp보다 크/작 다면 arr[j+1]에 arr[j]를 넣는다.<br>
- 2-2) 위의 조건을 만족하지 않는다면, arr[i](tmp)가 자리를 찾은것이므로, break한다.<br>
- 3) 제1 for문의 끝에서 arr[j+1]에 tmp를 삽입한다.<br>
- j가 j for loop 밖에서 사용되야 하므로, j를 for loop 밖에서 선언해야 함을 유의한다.<br>
</details>

<details>
 <summary> <strong>4. LRU(Least Recently Used) cashe</strong> </summary>
- 배열에서 한칸씩 밀리는 로직을 짤때, insertion 로직을 사용한다<br>
- 1) Hit 발생했는지 확인하고, 발생했다면 pos에 그 지점을 넣는다.<br>
- 2) pos값을 판단하여, hit와 miss 두 로직을 구성한다.<br>
</details>

<details>
 <summary> <strong>5. 중복확인</strong> </summary>
- 세가지 풀이가 가능하다.<br>
- 1) HashMap을 활용한 풀이 (O(n))<br>
- 2) TreeSet을 활용한 풀이 (O(n))<br>
- 3) 정렬을 활용한 풀이 (O(nlog(n)))<br>
</details>

<details>
 <summary> <strong>6. 장난꾸러기</strong> </summary>
- 정렬 후, 정렬 전 배열과 비교하여 문제를 해결한다.<br>
- 배열을 복사할때, <strong>깊은복사와 얕은복사</strong>의 차이점을 주의한다.<br>
- <strong>깊은복사</strong> : '실제 값'을 새로운 메모리에 복사한다.<br>
- <strong>얕은복사</strong> : '주소 값'을 복사한다.<br>
</details>

<details>
 <summary> <strong>7. 좌표정렬</strong> </summary>
- 1) x,y좌표를 가진 Point class를 선언한다.<br>
- 2) Point class를 Arrays.sort()의 인자로 사용하기 위해 Comparable interface를 implements한다.<br> 
- 3) Point class에 compareTo() 함수를 오버라이딩한다.<br>
- 4) 오버라이딩한 compareTo()함수에 <code>x가 같을시 y로 정렬</code>를 구현한다<br>
- 5-1) 오름차순 정렬시 <code>return this - o</code> 를 기억한다.<br>
- 5-2) 내림차순 정렬시 <code>return o - this</code> 를 기억한다.<br> 
</details>

<details>
 <summary> <strong>8. 이분검색</strong> </summary>
- 이분검색은 <strong>정렬된 배열</strong>에만 사용 가능하다<br> 
- 완전탐색의 시간복잡도는 O(n)이지만, 이분검색을 이용하면 O(logn)으로 줄일 수 있다.<br> 
</details>

<details>
 <summary> <strong>9. 뮤직비디오</strong> </summary>
- 결정 알고리즘은 답이 될 수 있는 범위를 정해놓고 그 범위를 이분탐색하여 문제를 해결하는 방법이다.<br> 
- 이 문제의 결정 범위 : 배열의 최댓값 ~ 배열의 총합<br>
</details>

<details>
 <summary> <strong>10. 뮤직비디오</strong> </summary>
- 결정 알고리즘을 사용하는 문제다.<br>
- mid값을 검증하는 함수의 로직을 짜는게 관건이다.<br>
- 이 문제에서는, mid값이 인자로 들어오면 mid값 만큼 떨어지게 말을 배치했을때 반복문이 k번 이상 반복되는지 확인한다.
</details>

### 6) Recursive, Tree, Graph(DFS, BFS 기초)
<details>
<summary> <strong>1. 재귀함수(스택프레임)</strong> </summary>
- 재귀함수를 짤때는 if-else 문으로 종료점을 정해라.<br>
- <strong>(1)재귀함수를 호출하는 부분</strong>과 <strong>유의미한 기능이 실행되는 부분</strong>의 순서를 바꾸는 것만으로도 큰 차이를 가져온다.<br>
</details>

<details>
<summary> <strong>2. 피보나치 재귀(메모이제이션)</strong> </summary>
- 재귀로 구현한 피보나치 수열은, fibonacci(10)을 호출하면, fibonacc(1),fibonacc(2),fibonacc(3).....fibonacc(9),fibonacc(10)을 모두 계산한다.<br>
- 따라서 n의 크기를 가진 배열을 선언후, fibonacci(10)이 호출될 때 1~9의 계산값들을 모두 저장해 둔다면, 시간을 대폭 줄일 수 있다.<br>
- 추가로, 계산이 재귀함수가 호출되기 전에 배열에 값이 있는지 확인하여,, 배열에 값이 있다면 재귀함수를 호출하지 않고 배열값을 리턴하도록 구현한다면, 시간을 추가적으로 대폭 줄일 수 있다.<br> 
</details>

<details>
<summary> <strong>3. 이진트리순회(DFS)</strong> </summary>
- 1~10출력과 10~1 출력의 순서를 재귀함수안 명령의 위치를 다르게하여 바꿀 수 있던 것처럼, 트리의 전위 중위 후위 순회 또한 마찬가지로 바꿀 수 있다.<br>
</details>

<details>
<summary> <strong>4. 부분집합 구하기</strong> </summary>
- 무조건 트리와 스택을 그려보면서 푼다<br>
</details>

<details>
<summary> <strong>5. 이진트리 레벨탐색(BFS) </strong> </summary>
- BFS는 Queue를 활용한다.<br>
- 처음엔 root 노드를 Queue에 넣은 후, poll()과 동시에 lt rt에 있는 노드를 다시 큐에 offer한다.<br>
</details>

<details>
<summary> <strong>6. 송아지 찾기 </strong> </summary>
- Queue를 활용한 BFS<br>
- 모든 노드의 값을 담을 수 있는 check 배열 이용<br>
- 1, -1, 5를 담은 배열을 생성하여, 3번 반복하는 for문으로 다음 노드를 처리한다.<br>
- check 배열의 인덱스 값의 범위에 유의한다.<br>
</details>

<details>
<summary> <strong>7. 말단노드까지 최단거리 </strong> </summary>
- DFS, BFS 모두 활용 가능하지만 최단거리 문제는 BFS로 푸는것이 맞다고 보면 된다.<br>
- 그 이유는 DFS로 구현시 노드의 lt rt 모두 확인하며 최종적으로 root 노드에서 모든 노드들의 최솟값을 확인하는데, 이때 자식이 쌍을 이루지 않는 노드는 최솟값을 비교할 수 없으므로 에러가 발생한다.<br>
- 최단거리 문제에서는 속도 면에서도 BFS가 DFS보다 우수한 성능을 갖는다. 모든 노드들을 비교하여 레벨의 최솟값을 찾는 DFS에 반해 BFS는 자식이 없는 노드를 발견하는 즉시 레벨을 반환하면 그만이기 때문이다.<br>
</details>

<details>
<summary> <strong>8. 그래프와 인접행렬 </strong> </summary>
- 인접행렬로 그래프를 표현하기위해 배열에 행과 열을 이용하여 그래프를 저장한다.<br>
- 1) 무방향 그래프의 저장 : <code>graph[2][4] = 1; graph[4][2] = 1;</code> (2,4 노드가 무방향으로 연결되어 있음)<br>
- 2) 방향 그래프의 저장 : <code>graph[2][4] = 1;</code> (2,4 노드가 2에서 4방향으로 연결되어 있음)<br>
- 3) 가중치 방향 그래프의 저장 : <code>graph[2][4] = 7;</code> (2,4 노드가 2에서 4방향으로 7의 가중치로 연결되어 있음)<br>
</details>

<details>
<summary> <strong>9. 경로탐색(DFS) </strong> </summary>
- 1 ~ 5 가는길을 탐색한다고 하면 다섯개의 트리가 다시 각각의 5개의 트리로 뻗어 나가는 방식으로 DFS를 구현한다.<br>
- check 배열을 이용하여 풀어야 하며 들어갈때는 check배열을 체크하고, 나올때는 다시 check배열을 풀어야 함을 유의한다.<br>
</details>

<details>
<summary> <strong>10. 경로탐색(인접리스트) </strong> </summary>
- 인접행렬로 정점과 간선을 구현하게 되면, 많은 정점과 간선을 다루게 될 시 공간복잡도와 시간복잡도 모두 기하급수적으로 늘어나게 된다.<br>
 (2차원 배열의 크기와 탐색해야하는 경우의 수 모두 크게 늘어나기 때문에)<br>
- ArrayList를 Element로 갖는 ArrayList를 graph로 활용한다<br>
- 2차원 배열 한줄을 모두 뒤질 필요 없이, <code>for(int nv : graph.get(v))</code> 한줄을 통해서 어레이 리스트 한줄만 뒤지면 들어가야 할 정점을 탐색 가능하다.<br>
- 정점과 간선을 입력 받아 graph에 삽입할때는, <code>graph.get(a).add(b)</code><br>
</details>

<details>
<summary> <strong>11. 그래프 최단거리(BFS, 인접리스트) </strong> </summary>
- ArrayList<ArrayList<Integer>>를 이용해 다음 노드가 있는 노드만을 큐에 offer()한다.<br>
- 큐에서 꺼낸 정수가 end point와 같다면, 해당 레벨을 return한다.<br>
</details>

<details>
<summary> <strong>12. 그래프 최단거리(BFS, distance 배열) </strong> </summary>
- 큐와 인접리스트(ArrayList<ArrayList<Integer>>)를 이용한 BFS로 해결한다.<br>
- 각 노드까지의 최단거리를 저장하는 배열을 만든다.<br>
- 다음 노드로 이동할때, 현재 노드까지의 최단거리에 +1 값을 더하여 distance 배열의 다음 노드 index에 저장한다<br>
</details>

### 7) DFS, BFS 활용
<details>
<summary> <strong>1. 합이 같은 부분집합(DFS) </strong> </summary>
- DFS 문제<br>
- 다음노드를 결과에 적용 할지, 안할지를 else문에 넣는 로직이다.<br>
- <code>DFS(L + 1, sum);</code><br>
- <code>DFS(L + 1, sum + arr[L]);</code><br>
- 위와 같은 구조이다.<br> 
</details>

<details>
<summary> <strong>2. 바둑이 승차(DFS) </strong> </summary>
- DFS 문제<br>
- 부분집합 문제와 유사한 로직<br>
</details>

<details>
<summary> <strong>3. 최대점수 구하기(DFS) </strong> </summary>
- DFS 문제<br>
- 부분집합 문제와 마찬가지로, L은 계속 증가시키며 재귀호출하되 다음 노드를 결과에 반영할지 안할지를 나눠서 탐색해 나간다.<br>
</details>

<details>
<summary> <strong>4. 중복순열 구하기(DFS) </strong> </summary>
- 배열을 사용해 각 자리를 레벨로 가정하고 재귀호출한다.<br>
</details>

<details>
<summary> <strong>5. 동전교환(DFS/BFS, DFS의 호출시간 줄이기) </strong> </summary>
- 최소의 무언가를 구하는 문제이므로, BFS를 쓰는편이 낫다.<br>
- DFS로 구현할 때는 끝 노드들을 모두 탐색하며 최소 길이를 저장해나가는데, 이때 이미 구한 길이보다는 더 깊이 들어가지 않겠다는 if문을 걸어서 시간복잡도를 줄인다.<br>
- 배열 원소의 순서에 따라서 짧은 길이가 더 먼저 발견될 가능성이 높다. 따라서 배열을 내림차순 정리하여 탐색하면 시간복잡도를 대폭 줄일 수 있다.<br> 
</details>

<details>
<summary> <strong>6. 순열 구하기 </strong> </summary>
- ch배열을 사용하는 DFS로 쉽게 구현<br>
- <code>들어갈때 ch를 true, 나올때 ch를 false</code> 에 유의하자<br>
</details>

<details>
<summary> <strong>7. 조합수 구하기 </strong> </summary>
- 조합(nCr) 을 구하는 문제<br>
- <code>nCr = n!/(n-r)!r!</code> 으로 구할수도 있지만,<br>
- <code>nCr = n-1Cr-1 + n-1Cr</code> 으로도 구할 수 있다.<br>
- 두번째 식은 피보나치 수열과 동일한 구조이며, n==r 인 경우나, r==1 인 경우에 각각 n,1 을 리턴하도록 재귀를 구현한다<br>
- 이때 큰 수를 입력받으면 쓸모없는 연산이 많아지므로, 시간복잡도를 줄이기 위해 메모이제이션을 활용한다<br>
</details>

<details>
<summary> <strong>8. 수열 추측하기 </strong> </summary>
- 파스칼의 삼각형 문제<br>
- 파스칼의 삼각형 계수가 조합의 규칙을 따르므로, 조합을 계산하여 배열에 넣어둔다.<br>
- 조합의 배열을 이용해 수열을 찾는다.<br>
</details>

<details>
<summary> <strong>9. 조합 구하기 </strong> </summary>
- 조합은 중복되지 않게, n개 중 r개를 뽑는것<br>
- DFS 안에서는 for문이 돌고, 재귀호출을 할때마다 for문의 첫 인덱스를 한칸씩 앞으로만 옮겨주면 된다<br>
</details>

<details>
<summary> <strong>10. 미로 탐색 </strong> </summary>
- 백준문제 풀이와 동일.<br>
</details>

<details>
<summary> <strong>11. 미로의 최단거리 통로 </strong> </summary>
- 백준문제 풀이와 다른점은, 이 문제에서는 BFS의 한 사이클마다 L을 증가시켜 L 을 반환하는 것이 아니라 거리를 저장하는 dis 배열을 추가하여 마지막에 dis 배열의 목표 index에서의 값을 찾는다.<br>
</details>

<details>
<summary> <strong>12. 토마토 </strong> </summary>
- 
</details>

<details>
<summary> <strong>13. 섬나라 아일랜드 </strong> </summary>
- 
</details>

### 8) Greedy Algorithm
<details>
<summary> <strong>1. 씨름선수 </strong> </summary>
- 먼저 키 순으로 퀵정렬 시킨다.<br>
- 키가 가장 큰 친구부터 몸무게를 비교하면서 max값을 갱신, 결과를 count한다.<br>
</details>

<details>
<summary> <strong>2. 회의실 배정 </strong> </summary>
- 회의가 빨리 끝나는 순서부터 계산을 하면 최대로 할 것이다 : Greedy Algorithm<br>
- 반례에 주의한다. 회의가 끝나는 시간이 같은 경우, 시작 시간을 오름차순으로 정리해야함을 주의<br>
</details>

<details>
<summary> <strong>3. 결혼식 </strong> </summary>
- 시작 시간, 종료 시간을 그저 일렬로 세워놓고,<br>
- 시작을 만나면 cnt증가<br>
- 종료를 만나면 cnt감소<br>
- 시작과 종료가 같이 있으면, 종료부터 적용<br> 
</details>



