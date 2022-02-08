package Inflearn._3TwoPointerSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = kb.nextInt();
        }

        System.out.println();
    }

    /* 6. 최대 길이 연속부분수열 */
    /*public static int longestSubSequence(int k, int[] arr){
        int answer = 0;
        int lt=0, cnt=0;
        int length = 0;

        for(int rt=0; rt<arr.length; ++rt)
        {
            if(arr[rt] == 0){
                cnt++;
            }

            while(cnt > k){
                if(arr[lt]==1)
                    lt++;
                else{
                    cnt--;
                    lt++;
                }
            }

            if(rt - lt + 1 > answer)
                answer = rt - lt + 1;

        }
        return answer;
    }*/
    /* 1. 두 오름차순 배열 합치기 */
    /*public static ArrayList<Integer> sumTwoArray(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int p1=0, p2=0;

        // 하나라도 끝까지 갔다면 반복 종료
        while(p1<n && p2<m){
            // p1이 작다면, p1을 넣고 p1증가
            if(arr1[p1] < arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
            }
            else {  // p2가 작다면, p2를 넣고 p2 증가
                answer.add(arr2[p2]);
                p2++;
            }
        }

        // 남은 배열의 뒷부분 모두 삽입
        while(p1 < n){
            answer.add(arr1[p1]);
            p1++;
        }
        while(p2<m){
            answer.add(arr2[p2]);
            p2++;
        }
        return answer;
    }*/
    /* 2. 공통원소 구하기 */
    /*public static ArrayList<Integer> findCommonElement(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int p1=0, p2=0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 하나라도 끝까지 갔다면 종료
        while(p1<l1 && p2<l2){
            if(arr1[p1]==arr2[p2]){ // 같다면, 둘 모두 증가
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if(arr1[p1]<arr2[p2]){ 
                p1++;
            }
            else{
                p2++;
            }
        }

        return answer;
    }*/
    /* 3. 최대 매출 */
    /*public static int maximumSales(int k, int[] arr){
        int answer;
        int max = 0;

        for(int i=0; i<k; ++i){
            max += arr[i];
        }
        answer = max;

        // max에 누적시키고, 끝날때마다 answer와 max를 비교
        for(int i=k; i<arr.length; ++i){
            max += (arr[i] - arr[i-k]);
            answer = Math.max(max,answer);
        }

        return answer;
    }*/
    /* 4. 연속 부분 수열 */
    /*public static int maxSubSequence(int k, int[] arr){
        int answer = 0, sum=0, lt=0;

        // 1)rt증가, 2)sum에 rt 더하기, 
        // 3)sum과 max 비교 4)작다면 같을때까지 lt증가
        for(int rt=0; rt<arr.length; ++rt){
            sum += arr[rt];
            if(sum == k){
                answer++;
            }
            while(sum >= k){
                sum -= arr[lt];
                lt++;
                if(sum == k)
                    answer++;
            }
        }
        return answer;
    }*/
    /* 5. 연속된 자연수의 합 */
    /*public static int sumOfConsequenceInteger(int n){
        int answer = 0, sum=0, lt=0;

        int[] arr = new int[n/2+1];
        for(int i=0; i<arr.length; ++i){
            arr[i] = i+1;
        }

        for(int rt=0; rt<arr.length; ++rt){
            sum += arr[rt];
            if(sum == n){
                answer++;
            }
            while(sum >= n){
                sum -= arr[lt];
                lt++;
                if(sum == n)
                    answer++;
            }
        }
        return answer;
    }*/


}
