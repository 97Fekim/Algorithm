package BAEKJOON._19QeueDeque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 11866 요세푸스 문제 0 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();
        int target = sc.nextInt();

        for(int i=1; i<=n; ++i)
            q.offer(i);

        while(!q.isEmpty()){
            for(int i=0; i<target-1; ++i)
                q.offer(q.poll());
            list.add(q.poll());
        }

        System.out.print('<');
        for(int i=0; i<list.size()-1; ++i)
            System.out.print(list.get(i)+", ");
        System.out.print(list.get(list.size()-1));
        System.out.print('>');
    }
}*/
/* 18258 큐 2 */
/*public class Main {
    static class Queue{
        public int front;
        public int rear;
        public int[] item;
        public Queue(int size) {
            this.front = -1;
            this.rear = -1;
            this.item = new int[size];
        }
        public void push(int item){
            this.item[++rear] = item;
        }
        public int pop(){
            if(this.front == this.rear)
                return -1;
            else
                return this.item[++front];
        }
        public int size(){
            return rear - front;
        }
        public int empty(){
            if(this.front == this.rear)
                return 1;
            else
                return 0;
        }
        public int front(){
            if(front==rear)
                return -1;
            else
                return this.item[front+1];
        }
        public int back(){
            if(front==rear)
                return -1;
            else
                return this.item[rear];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue q = new Queue(n);

        while(n --> 0){
            String cmd = br.readLine();
            if(cmd.equals("front"))
                sb.append(q.front()).append('\n');
            else if(cmd.equals("back"))
                sb.append(q.back()).append('\n');
            else if(cmd.equals("size"))
                sb.append(q.size()).append('\n');
            else if(cmd.equals("pop"))
                sb.append(q.pop()).append('\n');
            else if(cmd.equals("empty"))
                sb.append(q.empty()).append('\n');
            else{
                String[] cmd_arr = cmd.split(" ");
                q.push(Integer.parseInt(cmd_arr[1]));
            }
        }
        System.out.println(sb);
    }
}*/
