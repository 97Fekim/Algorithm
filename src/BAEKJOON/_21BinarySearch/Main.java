package BAEKJOON._21BinarySearch;

import java.util.HashMap;
import java.util.Scanner;

/* 10816 숫자 카드 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i=0; i<m; ++i)
            target[i] = sc.nextInt();

        for(int i : arr)
            map.put(i, map.getOrDefault(i,0)+1);

        for(int i : target)
            sb.append(map.getOrDefault(i,0)+" ");

        System.out.println(sb);
    }
}

/* 1920 수 찾기 */
/*public class Main {
    static int binarySearch(int target, int[] arr){
        int lt = 0;
        int rt = arr.length-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == target)
                return 1;
            else if(target < arr[mid])
                rt = mid - 1;
            else
                lt = mid + 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i=0; i<m; ++i)
            target[i] = sc.nextInt();

        Arrays.sort(arr);
        for(int i=0; i<m; ++i){
            int tg = target[i];
            System.out.println(binarySearch(tg, arr));
        }
    }
}*/