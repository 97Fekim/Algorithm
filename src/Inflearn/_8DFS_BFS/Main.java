package Inflearn._8DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

/* 2. 바둑이 승차 */
public class Main {

    public static void DFS(int L, int sum, int[] arr){

    }
    public static void main(String[] args) {

    }
}

/* 1. 합이 같은 부분집합(인강) */
/*public class Main {

    static String answer = "NO";
    static int total=0, n;
    static boolean flag = false;
    public static void DFS(int L, int sum, int[] arr){
        if(flag)
            return ;
        if(L==n){
            if(total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else{
            DFS(L+1, sum+arr[L], arr);  // 사용한다.
            DFS(L+1, sum, arr);              // 사용 안한다.
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        for(int i : arr)
            total += i;

        DFS(0, 0, arr);
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
