# Algorithm
🗝하루에 한문제 풉니다<br>
## LeetCode
- [문제풀이](https://velog.io/@16fekim?tag=%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)

## 인프런 인강
### 1-1. 문자 찾기
- 소문자 <-> 대문자 변형시, <code>c = Character.to____Case(c) </code> 이용하여 변형한다.
- 문자열에서 for-each 문을 돌릴때, <code>for(char c : str.toCharArray){} </code> 의 형태로, char 배열을 이용해서 for문을 돌려야 한다.
### 1-2. 대소문자 변환
- Character 클래스의 메소드중, <code>isLowerCase</code>와 <code>isUpperCase</code>를 이용해서 대문자인지 소문자인지 알 수 있다. 
### 1-3 가장 긴 부분문자열
- nextLine()으로 줄바꿈 된 문자열을 입력 받는다.
- <code>String[] strs = String.split("CH") </code>로 <code>"CH"</code>을 기준으로 쪼개진 문자열 배열을 얻는다.
- <code>int pos = str.indexOf("CH")</code> 로, <code>"CH"</code> 문자가 있는 인덱스를 pos에 반환받는다. 발견하지 못하면, pos에 -1를 리턴한다.
- <code>String temp = str.substring(index1, index2)</code> 로, index1 ~ index1 의 부분 문자열을 temp에 담을 수 있다


## 마구잡이 정리 노트
- 배열 순회시 <strong>이진 탐색</strong> 고려하기
- 무언가 연결해야 한다면 <strong>리스트</strong> 고려하기
- 쌍을 맞춰야 하는 연산자, 수식이 있다면 <strong>스택</strong> 고려하기
