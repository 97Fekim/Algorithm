package Inflearn._6Sort;

import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

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
            if(j == -1)
                System.out.println("j 지금 -1이에요~~");
        }
        return arr;
    }*/
    /* 4. LRU(캐시) */ // 다시(복습 요망)
    /*public static int[] cashMemory(int k, int[] arr){
        int[] cashe = new int[k];
        for(int x : arr){
            int pos = -1;
            // check hit
            for(int i=0; i<k; ++i) {
                if (x == cashe[i])
                    pos = i;
            }
            if(pos == -1){  // miss processing
                for(int i=k-1; i>=1; i--){
                    cashe[i] = cashe[i-1];
                }
            }
            else{   // hit processing
                for(int i=pos; i>=1; i--){
                    cashe[i] = cashe[i-1];
                }
            }
            // current process processing
            cashe[0] = x;
        }
        return cashe;
    }*/
    /* 5-1. 중복확인(TreeSet 활용) */
    /*public static String checkDuplication(int[] arr){
        TreeSet<Integer> ts = new TreeSet<>();
        String answer = "D";
        for(int i : arr)
            ts.add(i);
        if(ts.size() != arr.length)
            answer = "D";
        else
            answer = "U";
        return answer;
    }*/
    /* 5-2. 중복확인(HashMap 활용) */
    /*public static String checkDuplication(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        String answer = "U";
        for(int i: arr)
            map.put(i, map.getOrDefault(i,0)+1);
        for(int i : map.keySet())
            if(map.get(i) != 1)
                answer = "D";
        return answer;
    }*/
    /* 5-3. 중복확인(정렬 이용)) */
    /*public static String checkDuplication(int[] arr){
        Arrays.sort(arr);
        String answer = "U";
        for(int i=0; i<arr.length-1; ++i)
            if(arr[i] == arr[i+1])
                answer = "D";
        return answer;
    }*/
    /* 6.장난꾸러기 */   // 다시봐
    /*public static ArrayList<Integer> mischief(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i=0; i<arr.length; ++i){
            if(arr[i] != tmp[i])
                answer.add(i+1);
        }

        return answer;
    }*/
    /* 7. 좌표정렬  // 다시봐
     * implements Comparable<T>
     * compareTo() 오버라이딩
     * 어떤 값으로 비교할건지 compareTo()에 if문으로 정의
     * 오름차순, 내림차순에 따라 리턴문의 빼기 순서 차이
     * */
    /*public static ArrayList<Point> sortCoordinate(ArrayList<Point> arr){
        Collections.sort(arr);
        return arr;
    }
    public static class Point implements Comparable<Point>{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 오름차순이려면 음수가 리턴되도록 (this - o)
        // 내림차순이려면 양수가 리턴되도록 (o - this)
        @Override
        public int compareTo(Point o) {
            if(this.x == o.x)
                return this.y - o.y;
            else
                return this.x - o.x;
        }
    }*/
    /* 8. 이분검색 */
    /*public static int binarySearch(int target, int[] arr){
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == target)
                return mid+1;
            else if(target < arr[mid])
                rt = mid - 1;
            else
                lt = mid + 1;
        }
        return 0;
    }*/
    /* 10. 마구간 정하기(결정알고리즘) */
    /*public static int horseRange(int k, int[] arr){
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length-1];
        int answer = 0;
        while(lt < rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid)>=k){
                answer = mid;
                lt = mid + 1;
            }
            else
                rt = mid - 1;
        }
        return answer;
    }
    public static int count(int[] arr, int dist){
        int cnt = 1;
        int ep = arr[0];

        for(int i=1; i<arr.length; ++i){
            if(arr[i] - ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }*/

}
