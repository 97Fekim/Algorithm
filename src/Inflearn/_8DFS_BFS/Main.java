package Inflearn._8DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

/* 2. 바둑이 승차 */
/*public class Main {

    static int[] arr;
    static int target;
    static int max = Integer.MIN_VALUE;
    static void DFS(int L, int sum){
        if(sum > target){
            return ;
        }
        else{
            max = Math.max(sum,max);
            if(L < arr.length) {
                DFS(L+1, sum);
                DFS(L+1, sum+arr[L]);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        int n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        DFS(0,0);
        System.out.println(max);
    }
}*/
/* 1. 합이 같은 부분집합(인강) */
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
/* 1. 합이 같은 부분집합 */
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
