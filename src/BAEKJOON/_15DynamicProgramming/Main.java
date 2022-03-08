package BAEKJOON._15DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 11055 가장 큰 증가 부분 수열 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[] arr = new int[n];
        int[] dy = new int[n];
        int[] sum = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        dy[0] = 1;
        sum[0] = arr[0];

        for(int i=1; i<arr.length; ++i){
            int max = 0;
            int cur_sum = arr[i];
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j] && dy[j] > max) {
                    max = dy[j];
                    cur_sum = sum[j];
                }
            }
            dy[i] = max + 1;
            sum[i] = cur_sum + arr[i];
            System.out.println(cur_sum);
            //answer = Math.max(sum[i], answer);
        }
        answer = Arrays.stream(sum).max().getAsInt();
        if(n==1)
            System.out.println(arr[0]);
        else
            System.out.println(answer);
    }
}

/* 11053 가장 긴 증가하는 부분 수열(LIS) */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[] arr = new int[n];
        int[] dy = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        dy[0] = 1;
        for(int i=1; i<arr.length; ++i){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j] && dy[j] > max)
                    max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(dy[i], answer);
        }
        if(n==1)
            System.out.println(1);
        else
            System.out.println(answer);
    }
}*/
/* 1003 피보나치 함수 */
/*public class Main {
    static int[] fibo = new int[41];
    static int fibonacci(int n){
        if(fibo[n] != 0)
            return fibo[n];
        if(n==1)
            return fibo[1] = 1;
        else if(n==2)
            return fibo[2] = 1;
        else
            return fibo[n] = fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0) {
            int i = sc.nextInt();
            if (i == 0)
                System.out.println(1 + " " + 0);
            else if (i == 1)
                System.out.println(0 + " " + 1);
            else
                System.out.println(fibonacci(i - 1) + " " + fibonacci(i));
        }
    }
}*/