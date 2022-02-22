package Inflearn._8DFS_BFS;

import java.util.*;

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
