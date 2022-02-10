package Inflearn._5StackQueue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr1 = new int[n][n];
        for(int i=0; i<n; ++i)
            for(int j=0; j<n; ++j)
                arr1[i][j] = kb.nextInt();
        int k = kb.nextInt();
        int[] arr2 = new int[k];
        for(int l=0; l<k; ++l)
            arr2[l] = kb.nextInt();
    }

    /* 1. 올바른 괄호 */
    /* public static String correctBrachets(String str) {
        Stack<Character> stack = new Stack();
        String answer = "YES";

        for(char x: str.toCharArray()){
            if(x=='(')
                stack.push(x);
            else{
                if(stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }

        if(stack.isEmpty())
            answer = "YES";
        else
            answer = "NO";

        return answer;
    }*/
    /* 2-1. 괄호문자제거(공백스택일때 추가) */
    /*public static ArrayList<Character> deleteBracketChar(String str){
        ArrayList<Character> answer = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c == '(')
                stack.push(c);
            else if(c == ')')
                stack.pop();
            else {
                if(stack.isEmpty())
                    answer.add(c);
            }
        }
        return answer;
    }*/
    /* 2-2. 괄호문자제거(괄호쌍까지 pop())
     * 1) stack.get()으로 stack의 첫번째 인덱스부터 접근
     * */
    /*public static String deleteBracketChar(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x == ')')
                while(stack.pop() != '(');
            else
                stack.push(x);
        }
        for(int i=0; i<stack.size(); ++i)
            answer += stack.get(i);
        return answer;
    }*/
    /* 3. 크레인게임 */
    /*public static int crainGame(int[][] arr1, int[] arr2){
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int n = arr1[0].length;
        int m = arr2.length;


        for(int i=0; i<m; ++i) {
            int pos = arr2[i]-1;
            for (int j = 0; j < n; ++j) {
                if(arr1[j][pos] != 0){
                    if(!stack.isEmpty() && stack.peek() == arr1[j][pos]) {
                        stack.pop();
                        answer += 2;
                    }
                    else
                        stack.push(arr1[j][pos]);
                    arr1[j][pos] = 0;
                    break;
                }
            }
        }

        return answer;
    }*/
}
