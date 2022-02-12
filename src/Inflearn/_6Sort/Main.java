package Inflearn._6Sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = kb.nextInt();

    }

    /* 1. 선택정렬 (제1 for문 시작과 끝 idx) */
    /* public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; ++i){
            int idx = i;
            for(int j=i+1; j<arr.length; ++j){
                if(arr[j] < arr[idx])
                    idx = j;
            }

            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }*/
    /* 2. 버블정렬 */
    /*public static int[] bubbleSort(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j<i; ++j){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }*/
    /* 3. 삽입정렬 */   // 다시(복습 요망)
    /*public static int[] insertionSort(int[] arr){
        for(int i=1; i < arr.length; i++) {
            int tmp = arr[i]; int j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp)
                    arr[j + 1] = arr[j];
                else
                    break;;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }*/
}
