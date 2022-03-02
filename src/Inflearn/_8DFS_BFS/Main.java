package Inflearn._8DFS_BFS;

import java.awt.*;
import java.util.*;

/* 13-2. 섬나라 아일랜드 (BFS) */

/* 13-1. 섬나라 아일랜드(DFS) */
/*public class Main {

    static int n;
    static int answer = 0;
    static int[][] arr;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx < n
                    && ny >= 0 && ny<n
                    && board[nx][ny]==1){
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }
    static void solution(int[][] board){
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j]==1){
                    answer++;
                    board[i][j] = 0;
                    DFS(i,j,board);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }
}*/
/* 12. 토마토 (BFS) */
/*public class Main {
    static class Point{
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, dis;
    static int n,m;
    static Queue<Point> q = new LinkedList<>();
    static void bfs(){
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0; i<4; ++i){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && ny >= 0
                && nx < n && ny < m
                && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1)
                    q.offer(new Point(i,j));
            }
        }
        bfs();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(board[i][j]==0)
                    flag = false;
            }
        }
        if(flag){
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else
            System.out.println(-1);

    }
}*/
/* 11. 미로의 최단거리 통로 (BFS) */
/*public class Main {
    static class Point{
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, dis;
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        board[x][y] = 1;
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0; i<4; ++i){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 1 && nx <= 7
                && ny >=1 && ny <= 7
                && board[nx][ny]==0){
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for(int i=1; i<=7; ++i){
            for(int j=1; j<=7; ++j){
                board[i][j] = sc.nextInt();
            }
        }
        bfs(1,1);
        if(dis[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);
    }
}*/
/* 10. 미로 탐색(DFS) */
/*public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int answer = 0;
    static void dfs(int x, int y){
        if(x==7 && y==7)
            answer++;
        else{
            for(int i=0; i<4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx > 0 && ny > 0
                && nx < 8 && ny < 8
                && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    dfs(nx,ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for(int i=1; i<=7; ++i){
            for(int j=1; j<=7; ++j){
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        dfs(1,1);
        System.out.println(answer);
    }
}*/
/* 9. 조합 구하기 */
/*public class Main {
    static int[] combi;
    static int n,m;
    static void dfs(int L, int s){
        if(L==m){
            for(int i: combi)
                System.out.print(i+" ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; ++i){
                combi[L] = i;
                dfs(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        dfs(0,1);
    }
}*/
/* 8. 수열 추측하기 (파스칼의 삼각형) */
/*public class Main {
    static int[] b, p, ch;
    static int n,f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];
    static int combi(int n, int r){
        if(dy[n][r] > 0)
            return dy[n][r];
        if(n==r || r==0)
            return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
    static void dfs(int L, int sum){
        if(flag)
            return ;
        if(L==n){
            if(sum == f) {
                for(int x : p)
                    System.out.print(x+" ");
                flag = true;
            }
        }
        else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L+1,sum+(p[L]*b[L]));
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        for(int i=0; i<n; ++i){
            b[i] = combi(n-1, i);
        }
        dfs(0,0);
    }
}*/
/* 7. 조합수(메모이제이션) */
/*public class Main{
    static int[][] mem;
    public static int dfs(int n, int r){
        if(mem[n][r] != 0)
            return mem[n][r];
        if(n==r)
            return 1;
        else if(n!=1 && r==1)
            return n;
        else
            return mem[n][r] = dfs(n-1,r-1)+dfs(n-1,r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        mem = new int[n+1][m+1];

        System.out.println(dfs(n,m));
    }
}*/
/* 6. 순열 구하기 */
/*public class Main {
    static int[] pm, arr;
    static boolean[] ch;
    static int n,m;
    public static void DFS(int L){
        if(L==m){
            for(int x : pm)
                System.out.print(x + " ");
            System.out.println();
            return ;
        }
        else{
            for(int i=0; i<n; ++i){
                if(!ch[i]){
                    ch[i] = true;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        pm = new int[m];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        ch = new boolean[n];
        DFS(0);
    }
}*/
/* 5-1. 동전교환 (★ DFS 시간복잡도 줄이기 ★)  */
/*public class Main {
    static int target;
    static int min = Integer.MAX_VALUE;
    public static void DFS(int L, int sum, Integer[] coins){
        if(sum > target)
            return ;
        if(L >= min)
            return ;
        if(sum == target)
            min = Math.min(L, min);
        else{
            for(int i=0; i<coins.length; ++i){
                DFS(L+1, sum+coins[i], coins);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for(int i=0; i<n; ++i)
            coins[i] = sc.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());
        target = sc.nextInt();
        DFS(0,0, coins);
        System.out.println(min);
    }
}*/
/* 5-1. 동전교환 (BFS) */
/*public class Main {
    static int[] coins;
    static boolean[] ch;
    public static int BFS(int target){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; ++i){
                int v = q.poll();
                if(v == target)
                    return L;
                for(int j=0; j<coins.length; ++j){
                    int nv = v + coins[j];
                    if(nv < ch.length && !ch[nv]){
                        ch[nv] = true;
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
        int n = sc.nextInt();
        coins = new int[n];
        for(int i=0; i<n; ++i)
            coins[i] = sc.nextInt();
        int target = sc.nextInt();
        ch = new boolean[target+1];
        System.out.println(BFS(target));
    }
}*/
/* 4. 중복순열 (DFS, 부분집합 로직 응용) */
/*public class Main {
    static int[] pm;
    static int n,m;
    static int cnt;
    public static void DFS(int L){
        if(L == m){
            for(int i : pm)
                System.out.print(i + " ");
            System.out.println();
        }
        else{
            for(int i=1; i<= n; ++i){
                pm[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        DFS(0);
    }
}*/
/* 3. 최대점수 구하기 (DFS, 부분집합 로직 응용) */
/*public class Main {
    static int n, target;
    static int[] score;
    static int[] time;
    static int max = Integer.MIN_VALUE;
    public static void DFS(int L, int sum, int t){
        if(t > target)
            return ;
        if(L == n) {
            if(t <= target)
                max = Math.max(sum, max);
            else
                return ;
        }
        else{
            DFS(L+1, sum, t);
            DFS(L+1, sum+score[L], t+time[L]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        target = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for(int i=0; i<n; ++i){
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        DFS(0, 0, 0);
        System.out.println(max);
    }
}*/
/* 2. 바둑이 승차 (DFS, 부분집합 로직 응용)*/
/*public class Main {

    static int[] arr;
    static int n;
    static int target;
    static int max = Integer.MIN_VALUE;
    static void DFS(int L, int sum){
        if(sum > target){
            return ;
        }
        if(L == n)
            max = Math.max(sum,max);
        else{
            DFS(L+1, sum);
            DFS(L+1, sum+arr[L]);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        DFS(0,0);
        System.out.println(max);
    }
}*/
/* 1-2. 합이 같은 부분집합(인강) */
/*public class Main {

    static int n, target;
    static int[] arr;
    static String answer = "NO";
    static boolean find = false;
    static void DFS(int L, int sum){
        if(find){
            return ;
        }
        if(sum == target - sum) {
            answer = "YES";
            find = true;
        }
        else if(sum >= target - sum){
            return ;
        }
        else{
            if(L < arr.length) {
                DFS(L + 1, sum);
                DFS(L + 1, sum + arr[L]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        target = Arrays.stream(arr).sum();
        DFS(0,0);
        System.out.println(answer);
    }
}*/
/* 1-1. 합이 같은 부분집합 */
/*public class Main {

    static String answer = "NO";
    static int[] arr;
    static int[] ch;
    public static void DFS(int left, int right){
        if(left == right){
            answer = "YES";
        }
        else if(left > right){
            return ;
        }
        else{
            for(int i=0; i<arr.length; ++i) {
                if(ch[arr[i]] == 0) {
                    ch[arr[i]] = 1;
                    DFS(left + arr[i], right - arr[i]);
                    ch[arr[i]] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        int sum = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        ch = new int[max+1];
        for(int i : arr)
            sum += i;

        DFS(0, sum);
        System.out.println(answer);
    }
}*/
