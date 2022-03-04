package BAEKJOON._16Greedy;

import java.util.Arrays;
import java.util.Scanner;

/* 11399 ATM */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int answer = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<=i; ++j)
                answer += arr[j];
        }
        System.out.println(answer);
    }
}

/* 1931 회의실 배정 */
/*public class Main {
    static class Lect implements Comparable<Lect>{
        public int start;
        public int end;
        public Lect(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lect o) {
            if(this.end == o.end)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lect> list = new ArrayList<>();
        for(int i=0; i<n; ++i)
            list.add(new Lect(sc.nextInt(), sc.nextInt()));

        Collections.sort(list);
        int count = 0;
        int min = Integer.MIN_VALUE;
        for(Lect l : list){
            if(l.start >= min){
                count++;
                min = l.end;
            }
        }
        System.out.println(count);
    }
}*/

/* 11047 동전 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int target = sc.nextInt();
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        int start = n-1;
        for(int i=n-1; i>=0; i--){
            if(arr[i] <= target) {
                start = i;
                break;
            }
        }
        if(n==1)
            start = 0;

        int temp = 0;
        int count = 0;
        for(int i = start; i>=0 || temp!=target; --i){
            while(true){
                if(temp + arr[i] > target)
                    break;
                else {
                    temp += arr[i];
                    count++;
                }
                if(temp == target)
                    break;
            }
        }
        System.out.println(count);
    }
}*/
