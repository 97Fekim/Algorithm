package BAEKJOON.Basic2;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();


    }
}

/* 1476 날짜 계산 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int e = 0, s=0, m=0;
        int t_e = sc.nextInt();
        int t_s = sc.nextInt();
        int t_m = sc.nextInt();
        while(e!= t_e || s != t_s || m!=t_m){
            if(++e>15)
                e=1;
            if(++s>28)
                s=1;
            if(++m>19)
                m=1;
            cnt++;
        }
        System.out.println(cnt);
    }
}*/
/* 15649 N과 M (1) */
/*public class Main {

    static int n,m;
    static boolean[] ch;
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int L){
        if(L == m){
            for(int i:res)
                if(i != 0)
                    sb.append(i).append(' ');
            sb.append('\n');
            return ;
        }
        else{
            for(int i=1; i<=n; ++i){
                if(!ch[i]){
                ch[i] = true;
                res[L+1] = i;
                dfs(L+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n+1];
        res = new int[m+1];
        dfs(0);
        System.out.println(sb);
    }
}*/
/* 15651 N과 M (3) */
/*public class Main {

    static int n,m;
    static boolean[] ch;
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int L){
        if(L == m){
            for(int i:res)
                if(i != 0)
                    sb.append(i).append(' ');
            sb.append('\n');
            return ;
        }
        else{
            for(int i=1; i<=n; ++i){
               // if(!ch[i]){
                    //ch[i] = true;
                    res[L+1] = i;
                    dfs(L+1);
               // }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n+1];
        res = new int[m+1];
        dfs(0);
        System.out.println(sb);
    }
}*/
/* 1182 부분수열의 합 (쓴다/안쓴다) */
/*public class Main {

    static int n,cnt = 0;
    static void dfs(int L, int[] arr, int sum,int target){
        if(L == n){
            if(sum == target)
                cnt++;
            else
                return ;
        }
        else{
            dfs(L+1, arr, sum, target);
            dfs(L+1, arr, sum+arr[L], target);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        dfs(0,arr,0,target);
        if(target == 0)
            System.out.println(cnt-1);
        else
            System.out.println(cnt);
    }
}*/
/* 11725 트리의 부모 찾기 */
/*public class Main{

    static int[] parent;
    static ArrayList<ArrayList<Integer>> graph;

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        parent[1] = 1;
        q.offer(1);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                int v = q.poll();
                for(int nv : graph.get(v)){
                    if(parent[nv] == 0){
                        parent[nv] = v;
                        q.offer(nv);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new ArrayList<ArrayList<Integer>>();
        int n = sc.nextInt();

        for(int i=0; i<=n; ++i)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<n-1; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        parent = new int[n+1];
        bfs();
        for(int i=2; i<=n; ++i) {
            System.out.println(parent[i]);
        }
    }
}*/
/* 7576 토마토(3차원) */
/*import java.util.*;
public class Main {

    static class Point{
        int hei;
        int wid;
        int z;
        public Point(int z ,int hei, int wid) {
            this.z = z;
            this.hei = hei;
            this.wid = wid;
        }
    }

    static int w,h,z;
    static int[][][] graph;
    static boolean[][][] ch;
    static int[] dx = {-1,0,0,1,0,0};
    static int[] dy = {0,1,-1,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static ArrayList<Point> init;
    static int bfs(){
        int L = 0;
        Queue<Point> q = new LinkedList<>();
        for(Point p : init) {
            ch[p.z][p.hei][p.wid] = true;
            q.offer(p);
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                Point v = q.poll();
                for(int j=0; j<dx.length; ++j){
                    int vhei = v.hei + dy[j];
                    int vwid = v.wid + dx[j];
                    int vz = v.z + dz[j];
                    if(vhei >= 0 && vwid >= 0 && vz >= 0
                    && vhei < h && vwid < w && vz < z
                    && !ch[vz][vhei][vwid] && graph[vz][vhei][vwid]==0){
                        ch[vz][vhei][vwid] = true;
                        graph[vz][vhei][vwid] = 1;
                        q.offer(new Point(vz, vhei, vwid));
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
        z = sc.nextInt();
        graph = new int[z][h][w];
        ch = new boolean[z][h][w];
        for(int k = 0; k < z; ++k)
            for (int i = 0; i < h; ++i)
               for (int j = 0; j < w; ++j)
                    graph[k][i][j] = sc.nextInt();

        init = new ArrayList<>();

        for(int k = 0; k < z; ++k)
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    if(graph[k][i][j] == 1)
                        init.add(new Point(k,i,j));
                }
            }

        int answer = bfs()-1;
        boolean done = true;
        for(int k = 0; k < z; ++k)
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    if(graph[k][i][j] == 0)
                        done = false;
                }
            }

        if(done)
            System.out.println(answer);
        else
            System.out.println(-1);
    }
}*/
/* 7562 나이트의 이동 */
/*public class Main {

    static class Point{
        int hei;
        int wid;
        public Point(int hei, int wid) {
            this.hei = hei;
            this.wid = wid;
        }
    }

    static int m;
    static boolean[][] ch;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    static int bfs(int s_x,int s_y,int e_x,int e_y){
        int L = 0;
        Queue<Point> q = new LinkedList<>();
        ch[s_y][s_x] = true;
        q.offer(new Point(s_y, s_x));
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                Point v = q.poll();
                if(v.wid == e_x && v.hei == e_y)
                    return L;
                for(int j=0; j<dx.length; ++j){
                    int nv_x = v.wid + dx[j];
                    int nv_y = v.hei + dy[j];
                    if(nv_x >= 0 && nv_y >= 0
                        && nv_x < m && nv_y < m
                        && !ch[nv_y][nv_x]){
                        ch[nv_y][nv_x] = true;
                        q.offer(new Point(nv_y, nv_x));
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0) {
            m = sc.nextInt();
            ch = new boolean[m][m];
            int s_x = sc.nextInt();
            int s_y = sc.nextInt();
            int e_x = sc.nextInt();
            int e_y = sc.nextInt();

            System.out.println(bfs(s_x, s_y, e_x, e_y));
        }
    }
}*/
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
/* 1697 숨바꼭질 */
/*public class Main {

    static int[] distance = {1,-1,2};
    static int[] ch;
    static Queue<Integer> q;
    public static int BFS(int s, int e){
        q.offer(s);
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i< len; ++i){
                int v = q.poll();
                if(v == e)
                    return L;
                for(int j=0; j< distance.length; ++j){
                    int nv;
                    if(j==2)
                        nv = distance[j]*v;
                    else
                        nv = v + distance[j];

                    if(nv == e)
                        return L+1;
                    if(nv >= 0 && nv <100001 && ch[nv]==0){
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
        q = new LinkedList<>();

        System.out.println(BFS(s,e));
    }
}*/
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
/* 13913 숨바꼭질 4 */
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
