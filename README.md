# Algorithm
🗝<br>
## LeetCode 풀이
- [문제풀이](https://velog.io/@16fekim?tag=%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)

## 인프런 인강
- [코드로 이동](https://github.com/97Fekim/Algorithm/blob/master/src/Inflearn/_1String/Main.java)
### 1) 문자열
<details>
<summary> <strong>1. 문자 찾기</strong> </summary>
- 소문자 <-> 대문자 변형시, <code>c = Character.to____Case(c) </code> 이용하여 변형한다.<br>
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
- ArrayList<String> 활용<br>
- StringBuilder의 reverse 메소드 활용<br>
- 손코딩시에는, 왼쪽 오른쪽을 lt rt로 지정하여, while(lt<rt) 루프 활용<br>
- <code>String str = String.valueOf(char[] temp)</code> 로, char 배열을 String으로 변환 가능하다.<br>
</details> 
 
<details>
<summary> <strong>5. 특정문자 뒤집기</strong> </summary>
- <code>while(lt < rt)</code> 를 항상 기억<br>
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
- 1) parseInt 활용 : <code>int n = Integer.parseInt(str)</code>를 활용해 String -> int 형 변환이 가능하다. 이때, 맨앞 0을 사라진다.<br>
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
- 2) 소수를 찾았다? > answer 1증가.<br>
- 3) 그 소수만큼 이동하면서 모든 자리에 체크 (소수가 아님을 1로 표시)<br>
</details> 
 
<details>
<summary> <strong>2. 뒤집어진 소수 </strong> </summary>
- 1) (t = temp를 10으로 나눈 나머지) > (res = res*10 + t) > (temp를 10으로 나누기) 로직으로 정수 뒤집기<br>
- 2) 뒤집어진 정수를 소수 판단 함수로 보내기<br>
- 3) 소수 판단 함수 : 약수가 있다( if(res%i != 0)사용) > false<br>
</details> 
 
<details>
<summary> <strong>3. 봉우리 </strong> </summary>
- 1) Out of index 에러 주의!<br>
- 2) int[] dx = {1,0,-1,0}; <br>
- 3) int[] dy = {0,1,0,-1}; dx, dy 두 배열을 이용하여, 양옆좌우를 손쉽게 탐색<br>  
</details> 
  

### 3) 투 포인터 / 슬라이딩 윈도우
- 시간복잡도 : O(n^2) -> O(n)<br>
- 정렬된 두 배열에만 적용 가능한 알고리즘<br>
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

 
## 마구잡이 정리 노트
- 배열 순회시 <strong>이진 탐색</strong> 고려하기
- 무언가 연결해야 한다면 <strong>리스트</strong> 고려하기
- 쌍을 맞춰야 하는 연산자, 수식이 있다면 <strong>스택</strong> 고려하기
- 정렬된 배열을 다룬다면 <strong>투포인터</strong> 고려하기
- 배열에서 특정 구간씩 다룰때, <strong>슬라이딩 윈도우</strong> 고려하기
