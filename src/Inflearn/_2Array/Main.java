package Inflearn._2Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

    }

    /* 1. 큰 수 출력하기 */   // ok
    /*public static ArrayList<Integer> printBigInteger(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i=1; i < arr.length; ++i){
            if(arr[i] > arr[i-1])
                answer.add(arr[i]);
        }

        return answer;
    }*/
    /* 2. 보이는 학생 */     // require one more
    /*public static int visibleStudentNumber(int n, int[] arr){
        int max = -1;
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }*/
    /* 3. 가위바위보 */      // ok(just if-else)
    /*public static ArrayList<Character> rockScissorPaper(int n, int[] arr1, int[] arr2){

    }*/
    /* 4. 피보나치 수열 */   // ok
    /*public static int[] pibonacci(int n){
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        answer[2] = 2;
        for(int i=2; i<n; ++i){
            answer[i] = answer[i-1] + answer[i-2];
        }
        return answer;
    }*/

}