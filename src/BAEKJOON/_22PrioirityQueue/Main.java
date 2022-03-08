package BAEKJOON._22PrioirityQueue;

import java.util.HashMap;
import java.util.Scanner;


/* 11286 절댓값 힙 */
/*public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // abs1 == abs2 가 같은데
            if(abs1==abs2) {
                if(o1 > o2 )    // o1=5, o2=-5
                    return 1;   // o2(뒤에꺼)를 반환해야 함
                else            // o1=-5, o2=5
                    return -1;  // o1(앞에꺼)을 반환해야 함
            }
            return abs1 - abs2;
        });

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        while(n-->0){
            int cmd = sc.nextInt();
            if(cmd == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            }
            else
                pq.offer(cmd);
        }
        System.out.println(sb);
    }
}*/
/* 1927 최소 힙 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq =
                new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        while(n-->0){
            int cmd = sc.nextInt();
            if(cmd == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            }
            else
                pq.offer(cmd);
        }
        System.out.println(sb);
    }
}*/
/* 11279 최대힙 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while(n-->0){
            int cmd = sc.nextInt();
            if(cmd == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            }
            else
                pq.offer(cmd);
        }
        System.out.println(sb);
    }
}*/
