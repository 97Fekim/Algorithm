package BAEKJOON._18Stack;


import java.util.Scanner;



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
