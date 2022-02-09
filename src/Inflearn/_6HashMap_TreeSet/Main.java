package Inflearn._6HashMap_TreeSet;

import java.util.*;

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

    /* 1. 학급 회장
     * 1)map.getOrDefault(key,0) : 해당 key의 value를 가져와라, 없다면 0을 가져와라
     * 2)map.containsKey : map에 key가 있는지 없는지,
     * 3)map.containsValue : map에 Value가 있는지 없는지,
     * 4)map.size() : key의 갯수
     * 5)★map.remove()★ : 특정 key 삭제. 삭제하면서 그 key의 value를 리턴
     */
    /*public static char classLeader(int n, String str){
        char answer = 'c';
        int max = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char c : map.keySet()){
            if(max < map.get(c)){
                max = map.get(c);
                answer = c;
            }
        }
        return answer;
    }*/
    /* 2. 아나그램 */
    /*public static String anagram(String str1, String str2){
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(char c: str1.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        for(char c: str2.toCharArray()){
            if(!map1.containsKey(c) || map1.get(c)==0)
                return "NO";
            else{
                map1.put(c, map1.get(c)-1);
            }
        }
        return "YES";
    }*/
    /* 3. 매출액의 종류
     * 1) map.size()
     * 2) map.remove()
     *  */
    /*public static ArrayList<Integer> kindsOfSales(int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k-1; ++i){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int lt=0;
        for(int rt=k-1; rt<arr.length; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt],0)+1);
            answer.add(map.size());

            // remove
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt])==0){
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }*/
    /* 4. 모든 아나그램 찾기 */
    /*public static int findAllAnagram(String str1, String str2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int answer = 0;
        int len = str2.length();

        for(int i=0; i<len-1; ++i){
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0; i<str2.length(); ++i){
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i),0)+1);
        }
        int lt = 0;
        for(int rt = len-1; rt < str1.length(); ++rt){
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt),0)+1);

            // test
            if(map1.equals(map2))
                answer++;

            // remove value[lt]
            map1.put(str1.charAt(lt),map1.get(str1.charAt(lt))-1);
            if(map1.get(str1.charAt(lt)) == 0)
                map1.remove(str1.charAt(lt));

            // raise lt
            lt ++;
        }

        return answer;
    }*/

    /* 5. k번째 큰 수 (TreeSet)
     * 1) new TreeSet<>(Collections.reverseOrder())
     * 2) Test.add()
     * 3) Tset.remove()
     * 4) Tset.size()
     * 5) Tset,first()
     * 6) Tset.last()
     * */
   /* public static int kthBigNumber(int k, int[] arr){
        int answer = 0;
        TreeSet<Integer> Test = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<arr.length; ++i){
            for(int j=i+1; j<arr.length; ++j){
                for(int l=j+1; l<arr.length; ++l){
                    Test.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int x : Test) {
            cnt++;
            if(cnt == k)
                return x;
        }
        return -1;
    }*/
}

