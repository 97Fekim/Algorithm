package BAEKJOON.playground;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

    }

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int firstUp = 0;
        int firstDown = 0;
        int secondUp = 0;
        int secondDown = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        firstUp = Integer.parseInt(st.nextToken());
        firstDown = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        secondUp = Integer.parseInt(st.nextToken());
        secondDown = Integer.parseInt(st.nextToken());

        int resultUp = firstUp*secondDown + secondUp*firstDown;
        int resultDown = firstDown * secondDown;

        for(int i=resultUp; i>=1; i--) {
            if(resultUp % i == 0 && resultDown % i == 0) {
                resultUp /= i;
                resultDown /= i;

            }
        }

        System.out.println(resultUp + " " + resultDown);

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long GCD = 1;

        for(long i=2; i<=Math.min(N, M); ++i) {

            if(N%i==0 && M%i==0) {
                GCD = i;
            }

        }

        System.out.println(N*M/GCD);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> sToImap = new HashMap<>();
        Map<Integer, String> iToSmap = new HashMap<>();

        String cur;

        for(int i=1; i<=N; ++i) {
            cur = br.readLine();
            sToImap.put(cur, i);
            iToSmap.put(i, cur);
        }

        for(int i=1; i<=M; ++i) {
            cur = br.readLine();
            try {
                System.out.println(iToSmap.get(Integer.parseInt(cur)));
            } catch (NumberFormatException e) {
                System.out.println(sToImap.get(cur));
            }
        }

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new TreeMap<>(Collections.reverseOrder());

        String name;
        String active;

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            name = st.nextToken();
            active = st.nextToken();

            if(!map.containsKey(name) && active.equals("enter")) {
                map.put(name, Boolean.TRUE);
            }

            if(map.containsKey(name) && active.equals("leave")) {
                map.remove(name);
            }
        }

        for(String key : map.keySet()) {
            System.out.println(key);
        }

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int sum = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int sum = Integer.parseInt(st.nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; ++i) {
            map.put(br.readLine(), 1);
        }

        String str;
        int sum = 0;

        for(int i=0; i<M; ++i) {
            str = br.readLine();
            sum += map.get(str) == null ? 0 : map.get(str);
        }

        System.out.println(sum);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int sum = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int sum = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; ++i) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int isExist = 0;
        int tmp;

        for(int i=0; i<N; ++i) {
            tmp = Integer.parseInt(st.nextToken());
            isExist = map.get(tmp) == null ? 0 : map.get(tmp);

            System.out.print(isExist + " ");
        }

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int sum = Integer.parseInt(br.readLine());
>>>>>>> a0b43a3d91715394e84762854a7c0faaa2a059ee
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int sum = Integer.parseInt(st.nextToken());

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int sum = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<=N; ++i) {
            for(int j=0; j<=N; ++j) {

                if(i*5 + 3*j == N) {
                    min = Math.min(min, i+j);
                }

            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }*/


/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int sum = Integer.parseInt(st.nextToken());

        int cnt = 0;
        long i = 0;

        while(true) {
            if(Long.toString(i).contains("666")) {
                cnt++;
            }

            if(cnt == N) {
                System.out.println(i);
                break;
            }

            i++;
        }

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int curX = 0;
        int curY = 0;

        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;

        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int i=0; i<cnt; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());

            if (maxX < curX) {
                maxX = curX;
            }
            if (curX < minX) {
                minX = curX;
            }

            if (maxY < curY) {
                maxY = curY;
            }
            if (curY < minY) {
                minY = curY;
            }

        }

        System.out.println((maxX-minX)*(maxY-minY));

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = Integer.parseInt(br.readLine());
        int total = 0;
        int[] exchange = new int[4];
        Arrays.fill(exchange, 0);

        for(int i=0; i<count; i++) {

            total = Integer.parseInt(br.readLine());

            while(total > 0) {
                if (total >= 25) {
                    exchange[0]++;
                    total -= 25;
                } else if (total >= 10) {
                    exchange[1]++;
                    total -= 10;
                } else if (total >= 5) {
                    exchange[2]++;
                    total -= 5;
                } else {
                    exchange[3]++;
                    total -= 1;
                }
            }

            for(int j=0; j<exchange.length; j++) {
                System.out.print(exchange[j] + " ");
            }

            if(i != count-1) {
                System.out.println();
            }

            Arrays.fill(exchange, 0);
        }
    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> scoreMap = new HashMap<>();
        scoreMap.put("A+",4.5);
        scoreMap.put("A0",4.0);
        scoreMap.put("B+",3.5);
        scoreMap.put("B0",3.0);
        scoreMap.put("C+",2.5);
        scoreMap.put("C0",2.0);
        scoreMap.put("D+",1.5);
        scoreMap.put("D0",1.0);
        scoreMap.put("F",0.0);


        double totSum = 0.0d;
        double totCnt = 0.0d;

        String curGrade = "";
        double curScore = 0.0d;

        while(true) {

            String inStr = br.readLine();
            if(inStr == null || inStr.isEmpty()){
                break;
            }

            StringTokenizer st = new StringTokenizer(inStr, " ");

            String temp = st.nextToken(); // dummy
            curScore = Double.parseDouble(st.nextToken());
            curGrade = st.nextToken();

            if(!curGrade.equals("P")) {

                totCnt += curScore;
                totSum += curScore * scoreMap.get(curGrade);

            }

        }

        System.out.print(totSum / totCnt);


    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        for(int i=0; i<size; i+=4) {
            System.out.print("long" + " ");
        }

        System.out.print("int");
    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sumAmt = Integer.parseInt(br.readLine());
        int totCnt = Integer.parseInt(br.readLine());
        int actualAmt = 0;

        for(int i=0; i<totCnt; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            actualAmt += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        System.out.println(sumAmt == actualAmt ? "Yes" : "No");

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        int max = first;

        if (first == second && second == third) {
            System.out.println(10000+first*1000);
        } else if (first == second) {
            System.out.println(1000 + 100*first);
        } else if (first == third) {
            System.out.println(1000 + 100*first);
        } else if (second == third) {
            System.out.println(1000 + 100*second);
        } else {
            if(second > first && second > third) {
                max = second;
            } else if (third > first && third > second) {
                max = third;
            }

            System.out.println(100*max);
        }

    }*/

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int pointX = Integer.parseInt(br.readLine());
//        int pointY = Integer.parseInt(br.readLine());
//
//        int quadrant = 0;
//
//        if (pointX < 0 && pointY < 0) {
//            quadrant = 3;
//        } else if (pointX < 0 && pointY > 0) {
//            quadrant = 2;
//        } else if (pointX > 0 && pointY < 0) {
//            quadrant = 4;
//        } else {
//            quadrant = 1;
//        }
//
//        System.out.println(quadrant);
//
//    }

/*    public static void main(String[] args) throws IOException {

//        int a = Integer.parseInt(br.readLine());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//        st = new StringTokenizer(br.readLine(), " ");  // 정수배열만들기

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bowl = new int[N];

        for(int i=0; i<N; ++i) {
            bowl[i] = i+1;
        }

        int left = 0;
        int right = 0;
        int temp = 0;

        for(int i=0; i<M; ++i) {

            st = new StringTokenizer(br.readLine(), " ");

            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            while(left-1 < right-1) {

                temp = bowl[left-1];
                bowl[left-1] = bowl[right-1];
                bowl[right-1] = temp;

                left++;
                right--;
            }

        }

        for(int i=0; i<bowl.length; ++i) {
            System.out.print(bowl[i] + " ");
        }


    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        System.out.println(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()));

    }*/

}
