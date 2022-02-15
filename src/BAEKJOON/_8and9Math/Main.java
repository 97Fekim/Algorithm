package BAEKJOON._8and9Math;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }
}
/* 2581 소수 */
/*public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int m = kb.nextInt();
        int n = kb.nextInt();
        int sum = 0;
        int min = 0;

        for(int i=m; i<=n; ++i){
            if(isPrime(i)){
                if(min == 0)
                    min = i;
                sum+=i;
            }
        }

        if(sum==0 && min==0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
    public static boolean isPrime(int n){
        if(n == 1)
            return false;
        for(int i=2; i<n/2 + 1; ++i){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}*/
/* 1978 소수찾기 */
/*public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        int cnt = 0;

        for(int i=0; i<n; ++i)
            arr[i] = kb.nextInt();

        for(int i=0; i<n; ++i){
            if(isPrime(arr[i]))
                cnt++;
        }
        System.out.println(cnt);

    }
    public static boolean isPrime(int n){
        if(n == 1)
            return false;
        for(int i=2; i<n/2 + 1; ++i){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}*/

