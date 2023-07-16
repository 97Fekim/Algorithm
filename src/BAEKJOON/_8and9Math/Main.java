package BAEKJOON._8and9Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

/* BigDecimal */
public class Main {
    public static void main(String[] args) {

        BigDecimal num1 = new BigDecimal("350.25");
        BigDecimal num2 = new BigDecimal("-275.35");

        System.out.println("+ 연산 결과 = " + num1.add(num2));
        System.out.println("- 연산 결과 = " + num1.subtract(num2));
        System.out.println("* 연산 결과 = " + num1.multiply(num2));
        System.out.println("/ 연산 결과 = " + num1.divide(num2, 34, BigDecimal.ROUND_CEILING));
        System.out.println("% 연산 결과 = " + num1.remainder(num2));
        System.out.println("최댓값 연산 결과 = " + num1.max(num2));
        System.out.println("최솟값 연산 결과 = " + num1.min(num2));
        System.out.println("절댓값 연산 결과 = " + num2.abs());
        System.out.println("반올림 연산 결과 = " + num1.setScale(0, RoundingMode.HALF_EVEN));



    }
}

/* 1002 터렛 */
/*public class Main {
    public static void main(String[] args) throws IOException{
        *//*Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
*//*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(turret(x1, y1, r1, x2, y2, r2));
        }

    }
    public static int turret(int x1, int y1, int r1, int x2, int y2, int r2){
        int answer = -1;

        *//* 원의 중심이 같을때 *//*
        if(x1 == x2 && y1==y2){
            if(r1 == r2)
                answer = -1;    // 반지름 같음 -> 교점 무한대
            else
                answer = 0;     // 반지름 다름 -> 교점 x
        }
        else{   *//* 원의 중심이 다를때 *//*
            double c2c = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
            double r_sum = r1 + r2;
            double r_sub = Math.sqrt(Math.pow(r1-r2,2));

            if(c2c == r_sum || c2c == r_sub)        // 외접, 교점이 1개인 경우
                answer = 1;
            else if(c2c > r_sum)    // 중심간의 거리가 더 커, 교점이 없는 경우
                answer = 0;
            else                    // 중심간의 거리가 더 작아, 교점이 두개인 경우
                answer = 2;

        }

        return answer;
    }
}*/

/* 4153 직각삼각형 */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while(true){
            int[] arr = new int[3];
            for(int i=0; i<3; ++i)
                arr[i] = kb.nextInt();

            if(arr[0]==0&&arr[1]==0&&arr[2]==0)
                break;

            if(Math.pow(arr[0],2) + Math.pow(arr[1],2) == Math.pow(arr[2],2))
                System.out.println("right");
            else if(Math.pow(arr[0],2) + Math.pow(arr[2],2) == Math.pow(arr[1],2))
                System.out.println("right");
            else if(Math.pow(arr[0],2) == Math.pow(arr[1],2) + Math.pow(arr[2],2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }

    }
}*/
/* 3009 네번째 점 */
/*public class Main{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        HashMap<Integer,Integer> mapX = new HashMap();
        HashMap<Integer,Integer> mapY = new HashMap();

        for(int i=0; i<3; ++i){
            int x = kb.nextInt();
            int y = kb.nextInt();
            mapX.put(x, mapX.getOrDefault(x,0)+1);
            mapY.put(y, mapY.getOrDefault(y, 0)+1);
        }
        for(Integer key : mapX.keySet()){
            if(mapX.get(key) == 1)
                System.out.print(key+ " ");
        }
        for(Integer key : mapY.keySet()){
            if(mapY.get(key) == 1)
                System.out.print(key);
        }
    }
}*/
/* 1085 직사각형에서 탈출 */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println(escapeSquare(kb.nextInt(),kb.nextInt(),kb.nextInt(),kb.nextInt()));
    }
    public static int escapeSquare(int x, int y, int w, int h){
        return Math.min(Math.min(w-x, h-y),Math.min(x,y));
    }
}*/
/* 9020 골드바흐의 추측 */
/*public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        for(int i=0; i<n; ++i)
            goldbach(kb.nextInt());

    }

    public static void goldbach(int n){

        int N = 10000;
        boolean check[] = new boolean[N+1];

        // 소수의 위치. 일단 모두 소수
        for(int i=2; i<=N; ++i)
            check[i] = true;

        // 에라토스테네스의 체. 소수의 배수에는 모두 약수(true)를 남김
        for(int i=2; i<=Math.sqrt(N); ++i){
            for(int j=i+i; j<=N; j=j+i){
                check[j] = false;
            }
        }

        int tmp = n/2;
        for(int j=tmp; j>= 2; j--){
           if(check[j]&&check[n-j]) {
               System.out.println(j + " " + (n- j));
               break;
           }
        }
    }
}*/
/* 1929 소수 구하기(에라토스테네스 체 응용) */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int m = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n+1];
        for(int i : arr)
            i = 0;

        for(int i=2; i<arr.length; ++i){
            if(arr[i]==0){
                if(i >= m)
                    System.out.println(i);
                for(int j=i; j<arr.length; j=j+i){
                    arr[j] = 1;
                }
            }
        }
    }
}*/
/* 11653 소인수분해 */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        for(int i=2; i<=Math.sqrt(n); ++i){
            while(n % i == 0){
                System.out.println(i);
                n /= i;
            }
        }

        if(n != 1){
            System.out.println(n);
        }
    }
}*/
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
/* 4948 베트르랑 공준 */
/*public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while(true){
            int n = kb.nextInt();
            if(n == 0)
                break;
            else
                System.out.println(eratostenes(n));
        }
    }

    public static int eratostenes(int n){
        int[] arr = new int[2*n+1];
        int cnt = 0;
        for(int i: arr)
            i = 0;
        for(int i=2; i<arr.length; ++i){
            if(arr[i]==0){
                if(i>n)
                    cnt ++;
                for(int j=i; j<arr.length; j=j+i){
                    arr[j] = 1;
                }
            }
        }
        return cnt;
    }
}*/