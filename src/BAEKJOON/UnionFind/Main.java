package BAEKJOON.UnionFind;

import java.util.Scanner;

/* 1976 여행 가자 */
/*public class Main {
    static int[] unf;
    static int find(int v){
        if(v == unf[v])
            return v;
        else
            return unf[v] = find(unf[v]);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb)
            unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; ++i)
            unf[i] = i;

        int m = sc.nextInt();

        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                if(sc.nextInt() == 1) {
                    union(i,j);
                }
            }
        }
        String answer = "YES";
        int first = sc.nextInt();
        for(int i=0; i<m-1; ++i)
            if(find(sc.nextInt()) != find(first))
                answer = "NO";

        System.out.println(answer);
    }
}*/

/* 1717 집합의 표현 */
/*
public class Main {
    static int[] unf;
    static int find(int n){
        if(n == unf[n])
            return n;
        else
            return unf[n] = find(unf[n]);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb)
            unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; ++i)
            unf[i] = i;
        for(int i=0; i<m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 0)
                union(b,c);
            else {
                if(find(b) == find(c))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}*/
