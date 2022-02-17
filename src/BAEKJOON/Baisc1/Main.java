package BAEKJOON.Baisc1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



    }
}

/* 10799 쇠막대기 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inTag = false;
        Stack<Character> charStack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        String input = sc.nextLine();

        for(char c : input.toCharArray()){
            if(c == '<'){
                if(!charStack.isEmpty()){
                    while(!charStack.isEmpty())
                        answer.append(charStack.pop());
                }
                inTag = true;
                answer.append(c);

            }
            else if(c == '>'){
                inTag = false;
                answer.append(c);
            }
            else{   //
                if(inTag) // 태그 안에 있는 문자 처리
                    answer.append(c);
                else{   // 태그 밖에 있는 문자 처리 (거꾸로)
                    if(c == ' '){    // 띄어쓰기 만남, charStack 모두 pop해서 answer로
                        while(!charStack.isEmpty())
                            answer.append(charStack.pop());
                        answer.append(' ');
                    }
                    else{   // 띄어쓰기가 아님,
                        charStack.push(c);
                    }
                }
            }
        }
        // charStack에 남아있는 문자를 answer에 추가
        while(!charStack.isEmpty())
            answer.append(charStack.pop());

        System.out.println(answer);
    }
}*/
/* 1158 요세푸스 문제 */
/*public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=1; i<=n; ++i)
            q.offer(i);

        while(!q.isEmpty())
        {
            for(int i=0; i<k-1; ++i){
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        System.out.print('<');
        for(int i=0; i< answer.size()-1; ++i)
            System.out.print(answer.get(i)+", ");
        System.out.print(answer.get(answer.size()-1));
        System.out.print('>');
    }
}*/
/* 10845 큐 */
/*public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(10000);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();


        while(n-->0){
            String str = sc.next();

            switch (str){
                case "push":
                    q.push(sc.nextInt()); break;
                case "pop":
                    sb.append(q.pop()).append('\n'); break;
                case "front":
                    sb.append(q.front()).append('\n'); break;
                case "size":
                    sb.append(q.size()).append('\n'); break;
                case "empty":
                    sb.append(q.isEmpty()).append('\n'); break;
                case "back":
                    sb.append(q.back()).append('\n'); break;
            }
        }
        System.out.println(sb);

    }

    public static class Queue{
        int front;
        int rear;
        int[] queue;

        public Queue(int capacity){
            this.front = 0;
            this.rear = 0;
            this.queue = new int[capacity];
        }

        public void push(int n){
            if(rear!=queue.length-1)
                queue[++rear] = n;
        }

        public int pop(){
            if(front==rear)
                return -1;
            else
                return queue[++front];
        }

        public int size(){
            return rear - front;
        }

        public int isEmpty(){
            if(rear == front)
                return 1;
            else
                return 0;
        }

        public int front(){
            if(rear == front)
                return -1;
            else
                return queue[front+1];
        }

        public int back(){
            if(rear == front)
                return -1;
            else
                return queue[rear];
        }


    }
}*/


