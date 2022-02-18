package BAEKJOON.Baisc1;

import java.util.Scanner;

public class Tree {

    static int N;
    static Node[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        arr = new Node[N];

        for(int i=0; i<N; ++i)
            arr[i] = new Node((char)('A'+i));

        while(N-->0){
            String temp = sc.nextLine();
            char ch = temp.charAt(0);
            char l = temp.charAt(2);
            char r = temp.charAt(4);

            if(l != '.')
                arr[ch-'A'].lt = arr[l-'A'];
            if(r != '.')
                arr[ch-'A'].rt = arr[r-'A'];
        }

        preOrder(arr[0]);
        System.out.println();
        inOrder(arr[0]);
        System.out.println();
        postOrder(arr[0]);
    }

    public static class Node{
        public char c;
        public Node lt;
        public Node rt;
        public Node(char c){
            this.c = c;
            this.lt=this.rt=null;
        }
    }

    public static void preOrder(Node root){
        if(root == null)
            return ;
        else{
            System.out.print(root.c);
            preOrder(root.lt);
            preOrder(root.rt);
        }
    }

    public static void inOrder(Node root){
        if(root == null)
            return ;
        else{
            inOrder(root.lt);
            System.out.print(root.c);
            inOrder(root.rt);
        }
    }

    public static void postOrder(Node root){
        if(root == null)
            return ;
        else{
            postOrder(root.lt);
            postOrder(root.rt);
            System.out.print(root.c);
        }
    }
}
