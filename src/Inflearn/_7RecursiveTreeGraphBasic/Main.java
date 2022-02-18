package Inflearn._7RecursiveTreeGraphBasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    /* 8. 송아지 찾기 */
    /*static int[] dis = {1,-1,5};
    static int[] check;
    static Queue<Integer> q = new LinkedList<>();
    public static int BFS(int s, int e){
       check = new int[10001];
       q.offer(s);
       int L = 0;
       while(!q.isEmpty()){
           int len = q.size();
           for(int i=0; i<len; ++i){
               int x = q.poll();
               for(int j=0; j<3; ++j){
                   int nx = x + dis[j];
                   if(nx == e)
                       return L+1;
                   if(nx >= 1 && nx <= 10000 && check[nx]==0){
                       q.offer(nx);
                       check[nx] = 1;
                   }
               }
           }
           L++;
       }
       return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s,e));
    }*/
    /* 7. 이진트리 레벨탐색(BFS) */
    /*public static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            this.data = val;
            lt=rt=null;
        }
    }
    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        int L = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            System.out.print(L+" level : ");
            for(int i=0; i<len; ++i){
                Node cur = q.poll();
                System.out.print(cur.data+ " ");
                if(cur.lt != null)
                    q.offer(cur.lt);
                if(cur.rt != null)
                    q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }*/
    /* 6. 부분집합 구하기(DFS) */
    /*static int n;       // 집합 원소의 갯수
    static int[] ch;    // Check 배열
    public void DFS(int L){
        if(L == n+1){
            for(int i=1; i<n+1; ++i)
                if(ch[i] == 1)
                    System.out.print(i+" ");
            System.out.println();
        }
        else{
            ch[L] = 1;     // L은 사용하겠다.
            DFS(L+1);   // 왼쪽으로 뻗는 순회

            ch[L] = 0;     // L은 사용하지 않겠다.
            DFS(L+1);   // 오른쪽으로 뻗는 순회
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }*/
    /* 5. 이진트리 순회(DFS) */
    /*public static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public void DFS(Node root){
        if(root == null)
            return ;
        else{
            DFS(root.lt);
            DFS(root.rt);
            System.out.println(root.data);
            // root.data를 출력하는 부분을 어디에
            // 두느냐에 따라서 전위,중위,후위 탐색을
            // 각각 구현할 수 있다.
        }
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }*/
    /* 4. 피보나치(메모이제이션) */
    /*public static void main(String[] args) {

        int n = 30;
        fibo = new int[n+1];
        fibonacci(n);
        for(int i=1; i<=n; ++i)
            System.out.println(fibo[i]+" ");

    }
    static int[] fibo;
    public static int fibonacci(int n){
        if(fibo[n] > 0)
            return fibo[n];
        if(n==1)
            return fibo[n] = 1;
        else if(n==2)
            return fibo[n] = 1;
        else
            return fibo[n] = fibonacci(n-1)+fibonacci(n-2);
    }*/
    /* 3. 팩토리얼 */
    /*public static int factorial(int n){
        if(n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }*/
    /* 2. 이진수 출력(재귀) */
    /*public static void DFS(int n){
        if(n == 0)
            return ;
        else{
            DFS(n/2);
            System.out.print(n%2);
        }
    }*/
    /* 1. 스택프레임(1~10출력) */
    /*public static void DFS(int n){
        if(n==0) return ;
        else{
            DFS(n-1);
            System.out.print(n+" ");
        }
    }*/
}

