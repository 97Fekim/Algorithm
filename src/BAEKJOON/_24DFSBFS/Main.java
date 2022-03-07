package BAEKJOON._24DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 2606 바이러스 */
/*public class Main {
    static int n,k,answer=0;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        ch[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int v = q.poll();
            for (int nv : graph.get(v)) {
                if (!ch[nv]) {
                    answer++;
                    ch[nv] = true;
                    q.offer(nv);
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new boolean[n+1];
        for(int i=0; i<=n; ++i)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<k; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs();
        System.out.println(answer);
    }
}*/
