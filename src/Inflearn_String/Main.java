package Inflearn_String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        //String str = kb.next();         // next하면 문자열 하나 읽어들임
        String str = kb.nextLine();

        System.out.println();
    }

    public static String longestSubStringUsingIndexOf(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while(pos = str.indexOf(" "))

    }

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

}