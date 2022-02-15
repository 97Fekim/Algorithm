package BAEKJOON._18Stack;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


/*public class Main{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = kb.nextInt();
        int[] arr = new int[n];
        int num = 1;

        boolean isAble = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; ++i){
            arr[i] = kb.nextInt();

            if(isAble){
                if(num < arr[i]){
                    while(num <= arr[i]){
                        stack.push(num++);
                        sb.append("+ \n");
                    }
                }

                if(stack.isEmpty())
                    isAble = false;
                else{
                    while(stack.peek() >= arr[i]){
                        stack.pop();
                        sb.append("- \n");
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
            }
        }
        if(isAble)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}*/

/* 4949 균형잡힌 세상 */
/*public class Main{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String temp = kb.nextLine();
            if(temp.equals("."))
                break;
            else
                list.add(wellBalanceWorld(temp));
        }

        for(String str :list)
            System.out.println(str);

    }
    public static String wellBalanceWorld(String str){
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for(char c : str.toCharArray()){
            // test code
            // System.out.println("c : " +c+ " stack : " + stack.toString());
            if(c == '(' || c == '[')
                stack.push(c);
            else if(c == ')' || c == ']'){
                if(stack.isEmpty())
                    return "no";
                else if(stack.peek() == '(' && c == ')')
                    stack.pop();
                else if(stack.peek() == '[' && c == ']')
                    stack.pop();
                else
                    return "no";
            }
        }

        if(stack.isEmpty())
            answer = "yes";
        else
            answer = "no";

        return answer;
    }

}*/
/* 9012 괄호 (인프런 인강과 동일 문제) */
/*public class Main{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] sArr = new String[n];
        for(int i = 0; i < n; ++i){
            String temp = kb.next();
            sArr[i] = rightBracket(temp);
        }

        for(String str : sArr)
            System.out.println(str);

    }
    public static String rightBracket(String str){
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for(char c : str.toCharArray()){
            if(c == '(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return "NO";
                else
                    stack.pop();
            }
        }

        if(stack.isEmpty())
            answer = "YES";
        else
            answer = "NO";

        return answer;
    }

}*/
/* 10773 제로 */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = kb.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            if(i == 0)
                stack.pop();
            else
                stack.push(i);
        }
        int sum = 0;
        for(int i : stack)
            sum += i;

        System.out.println(sum);
    }
}*/
/* 10828 스택 (구현) */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();

        Stack stack = new Stack(N);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; ++i){
            String str = kb.next();

            switch (str){
                case("pop"):
                    sb.append(stack.pop()).append('\n');break;
                case("size"):
                    sb.append(stack.size()).append('\n');break;
                case("empty"):
                    sb.append(stack.isEmpty()).append('\n');break;
                case("top"):
                    sb.append(stack.top()).append('\n');break;
                case("push"):
                    stack.push(kb.nextInt());break;
            }
        }
        System.out.println(sb);
    }

    public static class Stack{
        private int top;
        private int[] stack;

        public Stack(int capacity) {
            this.top = -1;
            this.stack = new int[capacity];
        }

        public int isEmpty(){
            if(top==-1)
               return 1;
            else
                return 0;
        }

        public void push(int item){
            stack[++top] = item;
        }

        public int pop(){
            if(this.isEmpty() == 1){
                return -1;
            }
            else
                return stack[top--];
        }

        public int size(){
            return top+1;
        }

        public int top(){
            if(this.isEmpty() == 1){
                return -1;
            }
            else
                return stack[top];
        }
    }
}*/
