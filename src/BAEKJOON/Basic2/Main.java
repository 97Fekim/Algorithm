package BAEKJOON.Basic2;

import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[] ch;
    static int answer = 0;
    static List<Integer>[] graph;

    public static void DFS(int s, int depth){
        if(depth==5) {
            answer = 1;
            return ;
        }
        ch[s] = true;
        for(int nv : graph[s]){
            if(!ch[nv]){
                DFS(nv, depth+1);
            }
        }
        ch[s] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n];
        for(int i=0; i<n; ++i){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; ++i){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i=0; i<n; ++i){
            ch = new boolean[n];
            DFS(i, 1);
        }
        System.out.println(answer);
    }
}

/* 1260 DFS와 BFS */
/*
public class Main {

    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public static void DFS(int s){
        for(int nv : graph.get(s)){
            if(ch[nv] == 0){
                ch[nv] = 1;
                System.out.print(nv+" ");
                DFS(nv);
            }
        }
    }
    public static void BFS(int s){
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.offer(graph.get(s));
        while(!q.isEmpty()){
            int len = q.size();
            ArrayList<Integer> v = q.poll();
            for(int nv : v){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    System.out.print(nv + " ");
                    q.offer(graph.get(nv));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        ch = new int[n+1];

        graph = new ArrayList<>();
        for(int i=0; i<=n; ++i){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; ++i){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(ArrayList<Integer> i : graph)
            Collections.sort(i);
        ch[s] = 1;
        System.out.print(s+" ");
        DFS(s);

        System.out.println();

        ch = new int[n+1];

        ch[s] = 1;
        System.out.print(s+" ");
        BFS(s);

    }
}
*/
/* 13549 숨바꼭질 3 */
/*public class Main {

    static int[] time;
    static int[] dis = {-1,0,1};
    public static int BFS(int s, int e){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        time[s] = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                int v = q.poll();
                if(v == e)
                    return time[v]-1;
                for(int j=0; j<3; ++j){
                    int nv;
                    if(j==1) {
                        nv = 2 * v;
                        if(nv>=0 && nv < 100001 && time[nv] == 0) {
                            time[nv] = time[v];
                            q.offer(nv);
                        }
                    }
                    else{
                        nv = v + dis[j];
                        if(nv>=0 && nv < 100001 && time[nv] == 0) {
                            time[nv] = time[v] + 1;
                            q.offer(nv);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        time = new int[100001];
        System.out.println(BFS(s,e));

    }
}*/
/* 14226 이모티콘 */
/*public class Main {

    public static class Emoji{
        public int num;
        public int clip;
        public Emoji(int num, int clip){
            this.num = num;
            this.clip = clip;
        }
    }
    public static int[][] visited;
    public static int BFS(int target){
        int L=0;
        Queue<Emoji> q = new LinkedList<>();
        q.offer(new Emoji(1,0));
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                Emoji v = q.poll();
                if(v.num == target)
                    return L;
                // 복사
                if(v.num < 1001 && visited[v.num][v.num]==0) {
                    visited[v.num][v.num] = 1;
                    q.offer(new Emoji(v.num, v.num));
                }
                // 붙여넣기
                if(v.num+v.clip < 1001 &&
                        v.clip < 1001 &&
                visited[v.num+v.clip][v.clip] == 0) {
                    visited[v.num+v.clip][v.clip] = 1;
                    q.offer(new Emoji(v.num + v.clip, v.clip));
                }
                // 하나빼기
                if(v.num-1 < 1001 && v.
                        num-1 >= 0 &&
                        v.clip < 1001 &&
                visited[v.num-1][v.clip] == 0) {
                    visited[v.num-1][v.clip] = 1;
                    q.offer(new Emoji(v.num - 1, v.clip));
                }

            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new int[1001][1001];
        int target = sc.nextInt();
        System.out.println(BFS(target));

    }
}*/
/* 1697 숨바꼭질 */
/*public class Main {

    static int[] ch;
    static int[] parent;
    static int[] dis = {-1, 1};
    public static int BFS(int s, int e){
        int L=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; ++i){
                int v = q.poll();
                if(v == e)
                    return L;
                for(int j=0; j<3; ++j){
                    int nv;
                    if(j==2)
                        nv = 2 * v;
                    else
                        nv = v + dis[j];
                    if(nv >= 0 && nv <= 100000 && ch[nv]==0){
                        parent[nv] = v;
                        ch[nv] = 1;
                        q.offer(nv);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        ch = new int[100001];
        parent = new int[100001];
        ch[s] = 1;
        System.out.println(BFS(s,e));

        Stack<Integer> stack = new Stack<>();
        int index = e;
        stack.push(index);

        while(index != s){
            stack.push(parent[index]);
            index = parent[index];
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
}*/
/* 9095 123더하기 */
/*public class Main {

    static int target;
    static int cnt = 0;
    public static void DFS(int cur_sum){
        if(cur_sum == target)
            cnt++;
        else if(cur_sum > target)
            return ;
        else{
            DFS(cur_sum+1);
            DFS(cur_sum+2);
            DFS(cur_sum+3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; ++i){
            target = sc.nextInt();
            DFS(0);
            System.out.println(cnt);
            cnt = 0;
        }
    }
}*/
