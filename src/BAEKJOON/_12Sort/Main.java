package BAEKJOON._12Sort;

import java.util.*;

public class Main {

    /* 1181 단어정렬 */
    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] sArr = new String[n];

        for(int i=0; i<n; ++i)
            sArr[i] = kb.next();

        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });

        System.out.println(sArr[0]);
        for(int i=1; i<sArr.length; ++i)
            if(!sArr[i].equals(sArr[i-1]))
                System.out.println(sArr[i]);
    }*/
    /* 2108 통계학 */
    /*public static ArrayList<Integer> statistic2108(int[] arr){
        int len = arr.length;
        ArrayList<Integer> answer = new ArrayList<>(len);

        // 산술평균
        float sum=0;
        for(int i=0; i<len; ++i){
            sum += arr[i];
        }
        float res = sum / (float)len;
        answer.add((int)Math.floor(res));

        // 증앙깂
        Arrays.sort(arr);
        answer.add(arr[(len-1)/2]);

        // 최빈값
        int mode = 0;
        ArrayList<Integer> d = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i,0)+1);
        for(int key : map.keySet()){
            if(map.get(key) > mode)
                mode = map.get(key);
        }
        for(int key : map.keySet()){
            if(map.get(key) == mode)
                d.add(key);
        }

        int[] temp = new int[d.size()];
        for(int i=0; i<d.size(); ++i)
            temp[i] = d.get(i);
        Arrays.sort(temp);
        if(d.size()==1)
            answer.add(temp[0]);
        else
            answer.add(temp[1]);

        // 범위
        answer.add(arr[arr.length-1] - arr[0]);

        return answer;

    }*/
    /* 1427 소트인사이드(내림차순 정렬) */
    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        while(n > 0){
            list.add(n%10);
            n /= 10;
        }

        Collections.sort(list,Collections.reverseOrder());
        for(int k : list)
            System.out.print(k);
    }*/
    /* 10814 나이순 정렬 */
    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Person> pArr= new ArrayList<>();
        for(int i=0; i<n; ++i){
            int age = kb.nextInt();
            String name = kb.next();
            pArr.add(new Person(age, i, name));
        }

        Collections.sort(pArr);

        for(Person p : pArr)
            System.out.println(p.age + " " + p.name);

    }
    public static class Person implements Comparable<Person>{
        int age;
        int id;
        String name;
        public Person(int age, int id, String name) {
            this.age = age;
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age == o.age)
                return this.id - o.id;
            else
                return this.age - o.age;
        }
    }*/
    /* 18870 좌표 압축(시간초과) */
    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = kb.nextInt();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], cnt++);
            }
        }

        for(int key : arr)
            System.out.print(map.get(key)+ " ");
    }*/
}
