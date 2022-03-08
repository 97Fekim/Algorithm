package Inflearn._10DynamicProgramming;

import java.util.Scanner;

/* 6. 최대점수 구하기(냅색 알고리즘) */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dy = new int[m+1];
        for(int i=0; i<n; ++i){
            int ps = sc.nextInt();  // 풀면 얻는 점수
            int pt = sc.nextInt();  // 푸는데 걸리는 시간
            for(int j=m; j>=pt; j--){
                dy[j] = Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);
    }
}

/* 5. 동전교환(냅색 알고리즘) */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];

        for(int i=0; i<n; ++i)
            coins[i] = sc.nextInt();

        int target = sc.nextInt();

        int[] dy = new int[target+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for(int i=0; i<coins.length; ++i){
            for(int j = coins[i]; j<dy.length; j++)
                dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
        }

        System.out.println(dy[target]);
    }
}*/
/* 4. 가장 높은 탑 쌓기(LIS 응용) */
/*public class Main {
    static class Brick implements Comparable<Brick>{
        public int area;
        public int hei;
        public int wei;
        public Brick(int area, int hei, int wei) {
            this.area = area;
            this.hei = hei;
            this.wei = wei;
        }
        @Override
        public int compareTo(Brick o) {
            return this.area - o.area;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Brick> list = new ArrayList<>();
        int[] result = new int[n];

        for(int i=0; i<n; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Brick(a,b,c));
        }
        Collections.sort(list);

        result[0] = list.get(0).hei;
        for(int i=1; i<n; ++i){
            int max = 0;
            for(int j=0; j<=i-1; ++j){
                if(list.get(i).wei > list.get(j).wei)
                    max = Math.max(max, result[j]);
            }
            result[i] = max + list.get(i).hei;
        }

        int max = Arrays.stream(result).max().getAsInt();
        System.out.println(max);
    }
}*/
/* 3. 최대부분증가수열(LIS) */
/*public class Main {
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
}*/
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
