package Inflearn._10DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/* 3. 최대부분증가수열(LIS) */
public class Main {
    static int[] dy;
    static int solution(int[] arr){
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for(int i=1; i<arr.length; ++i){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j] > max)
                    max = dy[j];
            }
            dy[i] = max+1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
}

/* 2. 돌다리 건너기 */
/*public class Main {

    static int solution(int n){
        int[] dy = new int[n+2];
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; ++i)
            dy[i] = dy[i-2] + dy[i-1];
        return dy[n+1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}*/
/* 1. 계단오르기 */
/*
public class Main {

    static int solution(int n){
        int[] dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; ++i)
            dy[i] = dy[i-2] + dy[i-1];
        return dy[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
*/
