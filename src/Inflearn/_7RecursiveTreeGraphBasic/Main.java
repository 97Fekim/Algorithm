package Inflearn._7RecursiveTreeGraphBasic;

public class Main {

    public static void main(String[] args) {

    }

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

