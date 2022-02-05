package Inflearn._2Array;

import java.io.SequenceInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[5][n];

        for(int i=0; i<5; ++i){
            for(int j=0; j<n; ++j){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println();
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
    /* 5. 소수(에라토스테네스 체) */
    /*public static int primeNumber(int n){
        int answer = 0;
        int[] ch = new int[n+1];
        for(int i=2; i<=n; ++i){
            if(ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }*/
    /* 6. 뒤집은 소수 */
    /*public static ArrayList<Integer> reversedPrimeNumber(int n, int[] nums){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            int temp = nums[i];
            int res =0; int t = 0;
            while(temp > 0) {
                t = temp % 10;
                res = res*10 + t;
                temp = temp / 10;
            }
            if(isPrime(res))
                answer.add(res);
        }
        return answer;
    }
    public static boolean isPrime(int num){
        if(num == 1)return false;
        for(int i=2; i<num; ++i){
            if(num%i==0) return false;
        }
        return true;
    }*/
    /* 7. 점수 계산 */      // ok
    /*public static int calScore(int n, int[] scores){
        int answer = 0;
        int sequence = 0;
        for(int i=0; i<scores.length; ++i) {
            if(scores[i] == 0) sequence = 0;
            else answer += (sequence++) + 1;
        }
        return answer;
    }*/
    /* 8. 등수 구하기 */     // ok
    /*public static ArrayList<Integer> lineUp(int n, int[] scores){
        ArrayList<Integer> rank = new ArrayList<>();

        for(int i=0; i< scores.length; ++i){
            int pos = 1;
            for(int j=0; j<scores.length; ++j){
                if(scores[i] < scores[j])
                    pos ++;
            }
            rank.add(pos);
        }
        return rank;
    }*/
    /* 9. 격자판 최대합 */    // ok
    /*public static int gridSum(int[][] arr){
        int max = -1;
        int sum1=0; int sum2=0; int sum3=0; int sum4 = 0;

        for(int i=0; i<arr[0].length; ++i){
            for(int j=0; j<arr[0].length; ++j){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
            sum2 = 0;
            sum1 = 0;
        }

        for(int i=0; i<arr[0].length; ++i){
            for(int j=0; j<arr[0].length; ++j){
                if(i == j)
                    sum3 += arr[j][i];
            }
        }
        max = Math.max(max,sum3);
        sum3 = 0;

        for(int i=0; i<arr[0].length; ++i){
            for(int j=0; j<arr[0].length; ++j){
                if(i == (arr[0].length-j-1))
                    sum4 += arr[j][i];
            }
        }
        max = Math.max(max,sum4);

        return max;
    }*/
    /* 10-1. 봉우리 (if문 활용) */
    /*public static int peaks1(int[][] arr){
        int answer = 0;
        int[][] temp = new int[arr[0].length+2][arr[0].length+2];

        for(int i=0; i<arr[0].length; ++i){
            for(int j=0; j<arr[0].length; ++j) {
                temp[i + 1][j + 1] = arr[i][j];
            }
        }

        for(int i=1; i<temp[0].length-1; ++i) {
            for (int j = 1; j < temp[0].length - 1; ++j) {
                if (temp[i][j] > temp[i - 1][j] &&
                        temp[i][j] > temp[i][j - 1] &&
                        temp[i][j] > temp[i + 1][j] &&
                        temp[i][j] > temp[i][j + 1])
                    answer++;
            }
        }
        return answer;
    }*/
    /* 10-2. 봉우리(dx, dy 활용) */
    /*public static int peaks2(int[][] arr) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] temp = new int[arr[0].length + 2][arr[0].length + 2];

        for (int i = 0; i < arr[0].length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                temp[i + 1][j + 1] = arr[i][j];
            }
        }

        for (int i = 1; i < temp[0].length - 1; ++i) {
            for (int j = 1; j < temp[0].length - 1; ++j) {
                int flag = 1;
                for (int k = 0; k < dx.length; ++k) {
                    if (temp[i][j] < temp[i + dx[k]][j + dy[k]])
                        flag = 0;
                }
                if(flag==1)
                    answer++;
            }
        }
        return answer;
    }*/
    /* 11. 임시 반장 */ // 나중에 다시
    /*public static int tempClassLeader(int[][] arr){
        return 0;
    }*/
    /* 12. 멘토멘티 */  // 나중에 다시


}