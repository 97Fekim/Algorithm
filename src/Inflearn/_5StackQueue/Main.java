package Inflearn._5StackQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; ++i)
            arr[i] = kb.nextInt();

        System.out.println();
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
    /* 4. 후위식 연산(postfix) */
    /*public static int postfix(String str){
        int res=0;
        Stack<Integer> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(Character.isDigit(c))
                stack.push(c -'0');
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+')
                    res = lt + rt;
                else if(c == '-')
                    res = lt - rt;
                else if(c == '*')
                    res = lt * rt;
                else if(c == '/')
                    res = lt / rt;
                stack.push(res);
            }
        }
        return stack.pop();
    }*/
    /* 6. 공주 구하기
     * Queue<Integer> Q = new LinkedList<>();
     * 1) q.offer() : 맨 뒤에 넣기
     * 2) q.poll() : 맨 앞 꺼내기
     * 3) q.peek() : 맨앞 찾기
     * 4) q.size() : queue의 사이즈
     * 5) q.contains(object) : object가 있는지 확인
     * */
    /*public static int rescuePrincess(int n, int k){
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=n; ++i)
            Q.offer(i);

        while(Q.size()>1){
            for(int i=1; i<k; ++i){
                Q.offer(Q.poll());
            }
            Q.poll();
        }

        answer = Q.poll();
        return answer;
    }*/
    /* 7. 커리큘럼 설계 */
    /*public static String designCurriculum(String str1, String str2){
        Queue<Character> Q = new LinkedList<>();
        for(char c : str1.toCharArray())
            Q.offer(c);

        for(char c : str2.toCharArray()){
            if(Q.contains(c)){
                if(Q.peek() == c)
                    Q.poll();
                else
                    return "NO";
            }
        }

        if(!Q.isEmpty())
            return "NO";

        return "YES";
    }*/
    /* 8.응급실 */
    /*public static int emergencyRoom(int[] arr, int k){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i<arr.length; ++i)
            Q.add(new Person(i, arr[i]));

        while(!Q.isEmpty()){
            Person tmp = Q.poll();
            for(Person x : Q){
                if(x.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == k)
                    return answer;
            }
        }
        return answer;
    }
    public static class Person{
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }*/
}
