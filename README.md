# Algorithm
🗝하루에 한문제 풉니다<br>
## LeetCode 풀이
- [문제풀이](https://velog.io/@16fekim?tag=%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)

## 인프런 인강
- [코드로 이동](https://github.com/97Fekim/Algorithm/blob/master/src/Inflearn_String/Main.java)
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
<summary> <strong>7. 회문 문자열 (Palindrome) </strong> </summary>
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
 
## 마구잡이 정리 노트
- 배열 순회시 <strong>이진 탐색</strong> 고려하기
- 무언가 연결해야 한다면 <strong>리스트</strong> 고려하기
- 쌍을 맞춰야 하는 연산자, 수식이 있다면 <strong>스택</strong> 고려하기
