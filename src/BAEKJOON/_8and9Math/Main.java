package BAEKJOON._8and9Math;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int a = kb.nextInt();
        int b = kb.nextInt();
        int v = kb.nextInt();

        float x = (float)(v-b)/(a-b);
        System.out.println((int)Math.ceil(x));


    }

}

