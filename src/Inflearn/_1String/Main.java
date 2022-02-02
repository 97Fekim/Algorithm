package Inflearn._1String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println();
    }

    /* 1. 문자 찾기 */
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

    /* 2. 대소문자 변환 */
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

    /* 3-1. 가장 긴 부분문자열(split) */
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

    /* 4-1. 문장 뒤집기(StringBuilder) */
    /*public static ArrayList<String> reverseStringUsingStringBuilder(int n, String[] strs){
        ArrayList<String> answer = new ArrayList<>();

        for(String str : strs){
            String temp = new StringBuilder(str).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }*/

    /* 4-2. 문장 뒤집기(BruteForce) */
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

    /* 5. 특정 문자 뒤집기(isAlphabetic) */
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

    /* 6. 중복 문자 제거(indexOf) */
    /*public static String deleteDuplicatedChar(String str){
        String answer = "";

        for(int i=0; i<str.length(); ++i){
            if(i == str.indexOf(str.charAt(i)))
                answer += str.charAt(i);
        }

        return answer;
    }*/

    /* 7-1. 회문문자열(lt, rt 활용) */
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

    /* 7-2. 회문문자열(StrungBuilder 활용) */
    /*public static String palindromeStringUsingStringBuilder(String str){

        StringBuilder sb = new StringBuilder(str);
        String temp = sb.reverse().toString();

        if(str.equalsIgnoreCase(temp))
            return "YES";
        else
            return "NO";
    }*/

    /* 8-1. 유효한 회문문자열(lt, rt 활용) */
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

    /* 8-2. 유효한 회문문자열(replaceAll 활용) */
    /*public static String palindromeStringOnlyAlphabetUsingReplaceAll(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();
        if(temp.equals(str))
            return "YES";
        else
            return "NO";
    }*/
}