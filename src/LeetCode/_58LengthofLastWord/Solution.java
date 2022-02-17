package LeetCode._58LengthofLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {

        int cnt = 0;

        // 문자열의 끝에서부터 앞으로 탐색
        for(int i=s.length()-1; i>-1; i--){

            // index의 문자가 ' '일때,
            if(s.charAt(i) == ' '){
                if(cnt == 0)    // index의 문자가 ' '이고 cnt가 0이라면, 배열 뒤쪽에 공백만 채워진 상태이다.
                    continue;   // 따라서 이경우는 앞으로 이동하며 계속 탐색한다.
                else
                    return cnt; // 현재 index가 공백인데, cnt가 0이 아니면 하나의 단어를 탐색을 마친 상태이다.
            }                   // 따라서 이경우는 현재까지 센 글자 수를 반환한다.
            else
                cnt++;          // 현재 index가 공백이 아니라면, cnt를 증가한다.
        }
        return cnt;             // 한번의 공백도 없었으므로, cnt를 반환한다.
    }
}
