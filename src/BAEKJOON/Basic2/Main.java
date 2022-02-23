package BAEKJOON.Basic2;

import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {



    }

}
/* 7576 토마토 */
/*import java.util.*;
public class Main {

    static class Point{
        int hei;
        int wid;
        public Point(int hei, int wid) {
            this.hei = hei;
            this.wid = wid;
        }
    }

    static int w,h;
    static int[][] graph;
    static boolean[][] ch;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static ArrayList<Point> init;
    static int bfs(){
        int L = 0;
        Queue<Point> q = new LinkedList<>();
        for(Point p : init) {
            ch[p.hei][p.wid] = true;
            q.offer(p);
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                Point v = q.poll();
                for(int j=0; j<dx.length; ++j){
                    int vhei = v.hei + dy[j];
                    int vwid = v.wid + dx[j];
                    if(vhei >= 0 && vwid >= 0
                    && vhei < h && vwid < w
                    && !ch[vhei][vwid] && graph[vhei][vwid]==0){
                        ch[vhei][vwid] = true;
                        graph[vhei][vwid] = 1;
                        q.offer(new Point(vhei, vwid));
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        w = sc.nextInt();
        h = sc.nextInt();
        graph = new int[h][w];
        ch = new boolean[h][w];

        for (int i = 0; i < h; ++i)
            for (int j = 0; j < w; ++j)
                graph[i][j] = sc.nextInt();

        init = new ArrayList<>();

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if(graph[i][j] == 1)
                    init.add(new Point(i, j));
            }
        }

        int answer = bfs()-1;
        boolean done = true;
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if(graph[i][j] == 0)
                    done = false;
            }
        }

        if(done)
            System.out.println(answer);
        else
            System.out.println(-1);
    }
}*/
/* 2178 미로탐색 */
/*import java.util.*;
public class Main {

    static class Point{
        int hei;
        int wid;
        public Point(int hei, int wid) {
            this.wid = wid;
            this.hei = hei;
        }
    }

    static int w,h;
    static int[][] graph;
    static boolean[][] ch;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static int BFS(int hei, int wid){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(hei, wid));
        int L = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                Point v = q.poll();
                if(v.wid == w-1 && v.hei == h-1)
                    return L;
                for(int j=0; j<dx.length; ++j){
                    int vh = v.hei + dy[j];
                    int vw = v.wid + dx[j];
                    if(vw >= 0 && vh >= 0
                        && vw < w && vh < h
                            && !ch[vh][vw] && graph[vh][vw]==1){
                        ch[vh][vw] = true;
                        q.offer(new Point(vh, vw));
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        graph = new int[h][w];
        ch = new boolean[h][w];

        for (int i = 0; i < h; ++i) {
            String input = sc.next();
            for (int j = 0; j < w; ++j)
                graph[i][j] = input.charAt(j)-'0';
        }
        ch[0][0] = true;
        System.out.println(BFS(0,0));

    }
}*/
/* 4963 섬의 개수 */
/*public class Main {

    static int w,h, result=0;
    static int[][] graph;
    static boolean[][] ch;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    static void DFS(int y, int x){
        ch[y][x] = true;
        for(int i=0; i<dx.length; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >= 0 &&
               nx < w && ny < h &&
               !ch[ny][nx] && graph[ny][nx]==1)
                    DFS(ny,nx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0)
                break;

            ch = new boolean[50][50];
            result = 0;

            graph = new int[h][w];
            for (int i = 0; i < h; ++i)
                for (int j = 0; j < w; ++j)
                    graph[i][j] = sc.nextInt();

            for (int i = 0; i < h; ++i)
                for (int j = 0; j < w; ++j) {
                    if (!ch[i][j] && graph[i][j] == 1) {
                        DFS(i, j);
                        result++;
                    }
                }
            System.out.println(result);
        }
    }
}*/
/* 2667 단지번호 붙이기 */
/*public class Main {

    static int[][] graph = new int[25][25];
    static boolean[][] ch = new boolean[25][25];
    static int[] result = new int[25*25];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 0;
    static int n;
    static void DFS(int x,int y){
        ch[x][y] = true;
        result[cnt]++;
        for(int i=0; i<4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(graph[nx][ny]==1 && !ch[nx][ny])
                    DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; ++i){
            String input = sc.next();
            for(int j=0; j<n; ++j){
                graph[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(!ch[i][j] && graph[i][j]==1) {
                    DFS(i,j);
                    cnt++;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; result[i]!=0; ++i)
            list.add(result[i]);
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list)
            System.out.println(i);
    }
}*/
/* 11724 연결 요소의 개수 */
/*public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int answer = 0;
    // BFS
    static void BFS(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                int v = q.poll();
                for(int nv : graph.get(v)){
                    if(ch[nv] == 0){
                        ch[nv] = 1;
                        q.offer(nv);
                    }
                }
            }
        }
        answer++;
    }
    // DFS
    public static void DFS(int s){
        if(ch[s] == 1)
            return ;
        else{
            ch[s] = 1;
            for(int nv : graph.get(s)){
                if(ch[nv]==0)
                    DFS(nv);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n+1];
        for(int i=0; i<n+1; ++i)
            graph.add(new ArrayList<Integer>());
        for(int i=0; i<m; ++i){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=1; i<=n; ++i){
            if(ch[i]==0) {
                DFS(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
}*/
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
