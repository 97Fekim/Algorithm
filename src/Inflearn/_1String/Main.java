package Inflearn._1String;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){

        // 정수 타입 오름차순
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o1[0];
        });

        // 정수 타입 내림차순
        Arrays.sort(arr, (o1, o2) -> {
            return o2[0] - o1[0];
        });

        // String은
        // o1.compareTo(o2) 쓰면 오름차순
        // o2.compareTo(o1) 쓰면 내림차순

        // 2가지 조건으로 정렬할때
        // 예를들어) order by 시작시간, 종료시간
        Arrays.sort(arr, (o1, o2) -> {
           if (o1.srt == o2.srt) {
               return o1.end - o2.end;
           } else {
               return o1.srt - o2.srt;
           }
        });


    }

    int dajikstra(int target) {

        // 우선순위큐 만들고
        // 시작좌표 넣고
        // dis 배열 초기화 하고
        // dis[0] = 0 으로 초기화 하고

        while (!q.isEmpty()) {

            Node cur = q.poll();
            if (visited[cur.pos]) {
                continue;
            }
            visited[cur.pos] = true;

            for (int i=0; i<graph[cur.pos].size(); ++i) {
                Node next = graph[cur.pos].get(i);

                if (dis[cur.pos] + next.cost < dis[next.pos]) {
                    dis[next.pos] = dis[cur.pos] + next.cost;
                    q.offer(new Node(next.pos, dis[cur.pos] + next.cost));
                }

            }

        }

    }

    /* 1. 문자 찾기 */  //1ok
    /*public static int findChar(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char c : str.toCharArray()){
            if(c == t)
                answer++;
        }
        return answer;
    }*/
    /* 2. 대소문자 변환 */    //1ok
    /*public static String upperLowerTranslate(String str){

        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray())
        {
            if(Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }*/
    /* 3-1. 가장 긴 부분문자열(split) */    //1ok
    /*public static String longestSubStringUsingSplit(String str){
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] strs = str.split(" ");

        for(String x : strs){
            if(x.length() > m) {
                m = x.length();
                answer = x;
            }
        }
        return answer;
    }*/
    /* 3-2. 가장 긴 부분문자열(indexOf) */
    /*public static String longestSubStringUsingIndexOf(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(" ")) != -1){
            String temp = str.substring(0,pos);
            int len = temp.length();
            if(len > m){
                m = len;
                answer = temp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m)
            answer = str;

        return answer;
    }*/
    /* 4-1. 문장 뒤집기(StringBuilder) */    //1ok
    /*public static ArrayList<String> reverseStringUsingStringBuilder(int n, String[] strs){
        ArrayList<String> answer = new ArrayList<>();

        for(String str : strs){
            String temp = new StringBuilder(str).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }*/
    /* 4-2. 문장 뒤집기(lt, rt) */   //1ok
    /*public static ArrayList<String> reverseStringUsingBruteForce(int n, String[] strs){
        ArrayList<String> answer = new ArrayList<>();

        for(String str : strs){
            char[] s = str.toCharArray();
            int lt = 0;
            int rt = s.length -1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                lt ++;
                rt --;
            }
            String temp = String.ValueOf(str);
            answer.add(temp);
        }
        return answer;
    }*/
    /* 5. 특정 문자 뒤집기(isAlphabetic) */    //1ok
    /*public static String reverseSpecificChar(String str){
        String answer;
        char[] cStr = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;

        while(lt < rt){
            if(!Character.isAlphabetic(cStr[lt]))
                lt ++;
            else if(!Character.isAlphabetic(cStr[rt]))
                rt --;
            else{
                char temp = cStr[lt];
                cStr[lt] = cStr[rt];
                cStr[rt] = temp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(cStr);
        return answer;
    }*/
    /* 6. 중복 문자 제거(indexOf) */  //1ok
    /*public static String deleteDuplicatedChar(String str){
        String answer = "";

        for(int i=0; i<str.length(); ++i){
            if(i == str.indexOf(str.charAt(i)))
                answer += str.charAt(i);
        }

        return answer;
    }*/
    /* 7-1. 회문문자열(lt, rt) */    //1ok
    /*public static String palindromeStringUsingLtRt(String str){
        int lt = 0;
        int rt = str.length()-1;
        str = str.toUpperCase();

        while(lt < rt){
            if(str.charAt(lt) != str.charAt(rt))
                return "NO";
            else{
                lt++;
                rt--;
            }

        }
        return "YES";

    }*/
    /* 7-2. 회문문자열(StrungBuilder 활용) */  //1ok
    /*public static String palindromeStringUsingStringBuilder(String str){

        StringBuilder sb = new StringBuilder(str);
        String temp = sb.reverse().toString();

        if(str.equalsIgnoreCase(temp))
            return "YES";
        else
            return "NO";
    }*/
    /* 8-1. 유효한 회문문자열(lt, rt) */    //1ok
    /*public static String palindromeStringOnlyAlphabetUsingLtRt(String str){

        int lt = 0;
        int rt = str.length()-1;
        str = str.toUpperCase();

        while(lt < rt){
            if(!Character.isAlphabetic(str.charAt(lt)))
                lt++;
            else if(!Character.isAlphabetic(str.charAt(rt)))
                rt--;
            else{
                if(str.charAt(lt) != str.charAt(rt))
                    return "NO";
                lt++;
                rt--;
            }
        }
        return "YES";
    }*/
    /* 8-2. 유효한 회문문자열(replaceAll 활용) */ //1ok
    /*public static String palindromeStringOnlyAlphabetUsingReplaceAll(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();
        if(temp.equals(str))
            return "YES";
        else
            return "NO";
    }*/
    /* 9-1. 숫자만 추출 (parseInt 활용) */     //1ok
    /*public static int extractOnlyNumberUsingParseInt(String str){

        String answer = "";
        for(int i=0; i<str.length(); ++i){
            if(!Character.isAlphabetic(str.charAt(i)))
                answer += str.charAt(i);
        }

        return Integer.parseInt(answer);
    }*/
    /* 9-2. 숫자만 추출 (곱셈 로직 활용) */    //1ok
    /*public static int extractOnlyNumberUsingMultiply(String str){
        int answer = 0;
        for(char c : str.toCharArray()){
            if((c > 48) && (c < 57)){
                answer = answer * 10 + (c - 48);
            }
        }

        return answer;
    }*/
    /* 10. 가장 짧은 문자거리 (양방향 로직 활용) */    //1ok
    /*public static int[] shortestCharDistance(String str, char c){
        int[] result = new int[str.length()];
        int p = 1000;

        for(int i=0; i < str.length(); ++i){
            if(str.charAt(i) != c){
                p++;
                result[i] = p;
            }
            else{
                p = 0;
                result[i] = p;
            }
        }

        p = 1000;
        for(int i=str.length()-1; i >= 0; i--){
            if(str.charAt(i) != c){
                p++;
                result[i] = Math.min(result[i],p);
            }
            else{
                p = 0;
            }
        }

        return result;
    }*/
    /* 11. 문자 압축 (끝에 빈문자 추가 주의) */
    /*public static String compressString(String str){
        StringBuilder answer = new StringBuilder();
        answer.append(str.charAt(0));
        int count = 1;
        str += " ";

        for(int i=1; i<str.length(); ++i){
            if(answer.charAt(answer.length()-1) == str.charAt(i)){
                count++;
            }
            else{
                if(count == 1)
                    answer.append(str.charAt(i));
                else{
                    answer.append(str.charAt(i));
                    answer.append(count);
                    count = 1;
                }
            }
        }

        return answer.toString();
    }*/
    /* 12. 암호(substring, replace, parseInt(str,2) 활용) */
    /*public static String password(int n,String str){
        String answer = "";
        for(int i=0; i<n; ++i){
            String temp = str.substring(0,7)
                    .replace('#', '1')
                    .replace('*','0');
            int num = Integer.parseInt(temp, 2);
            answer += (char)num;
            str = str.substring(7);
        }
        return answer;
    }*/
}
