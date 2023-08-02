package BAEKJOON.playground;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.misc.GC;

import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {

    // #9184
/*    static int[][][] mem;

    static int dfs(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        
        // 메모이제이션
        if (mem[a][b][c] != 0) {
            return mem[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            return mem[20][20][20] = dfs(20, 20, 20);
        }
        if (a < b && b < c) {
            return mem[a][b][c] = dfs(a, b, c-1) + dfs(a, b-1, c-1) - dfs(a, b-1, c);
        }
        return mem[a][b][c] = dfs(a-1, b, c) + dfs(a-1, b-1, c) + dfs(a-1, b, c-1) - dfs(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        mem = new int[51][51][51];
        mem[0][0][0] = 1;

        while (true) {
            String in = br.readLine();

            StringTokenizer st = new StringTokenizer(in, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a,b,c,dfs(a,b,c));
        }

    }*/


/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int recur = 0;

        int a0 = 1;
        int a1 = 1;

        for (int i=3; i<=N; ++i) {
            recur = a0 + a1;
            a0 = a1;
            a1 = recur;
        }

        System.out.println(recur + " " + (N-2));

    }*/

    // #14889
/*    static BufferedWriter bw;
    static int N;
    static int[][] stats;
    static boolean[] ch;
    static int[] left;
    static int[] right;
    static int min = Integer.MAX_VALUE;

    static void dfs(int depth, int start) throws IOException {
        if (depth == N/2) {
            left = new int[N/2];
            right = new int[N/2];
            int l = 0;
            int r = 0;
            for(int i=0; i<N; ++i) {
                if(ch[i]) {
                    left[l] = i;
                    l++;
                } else {
                    right[r] = i;
                    r++;
                }
            }
            int lSum = 0;
            int rSum = 0;
            for(int i=0; i<N/2; ++i) {
                for(int j=i; j<N/2; ++j) {
                    lSum += stats[left[i]][left[j]] + stats[left[j]][left[i]];
                    rSum += stats[right[i]][right[j]] + stats[right[j]][right[i]];
                }
            }
            min = Math.min(min, Math.abs(lSum-rSum));

        } else {
            for(int i=start; i<N; ++i) {
                if(!ch[i]) {
                    ch[i] = true;
                    dfs(depth+1, i+1);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        ch = new boolean[N];
        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; ++j) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }*/

    // #14888 연산자 끼워넣기
/*    static int[] arr;
    static char[] opers;
    static char[] realOpers;
    static boolean[] ch;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void dfs(int depth) {

        if (depth == opers.length) {
            int cur = arr[0];

            for(int i=1; i<arr.length; ++i) {
                switch (realOpers[i-1]) {
                    case '+' : { cur += arr[i]; break;}
                    case '-' : { cur -= arr[i]; break;}
                    case '*' : { cur *= arr[i]; break;}
                    case '/' : { cur /= arr[i]; break;}
                }
            }
            //System.out.println(cur);
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        } else {
            for (int i=0; i< opers.length; ++i) {
                if(!ch[i]) {
                    ch[i] = true;
                    realOpers[depth] = opers[i];
                    dfs(depth+1);
                    realOpers[depth] = ' ';
                    ch[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] fourOper = new int[4];
        for(int i=0; i<4; ++i) {
            fourOper[i] = Integer.parseInt(st.nextToken());
        }

        int totalOperCnt = Arrays.stream(fourOper).sum();
        opers = new char[totalOperCnt];
        realOpers = new char[totalOperCnt];
        ch = new boolean[totalOperCnt];
        Arrays.fill(ch, false);

        int k=0;
        for(int i=0; i<4; ++i) {
            for(int j=0; j<fourOper[i]; ++j) {
                if(i==0) {
                    opers[k] = '+';
                } else if (i==1) {
                    opers[k] = '-';
                } else if (i==2) {
                    opers[k] = '*';
                } else {
                    opers[k] = '/';
                }
                k++;
            }
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);

    }*/

    // #9663 N-Queen TODO
/*    static int cnt = 0;
    static int N;
    static int[] arr;

    static void dfs (int x) {
        if (x==N) {
            cnt++;
        } else {
            for (int i=0; i<N; ++i) {
                arr[x] = i;
                if (isPossible(x, i)) {

                    dfs(x+1);
                }
            }
        }
    }

    static boolean isPossible(int row, int col) {

        boolean isPossible = true;

        for (int i=0; i<row; ++i) {
            if (arr[i] == col) {
                isPossible = false;
            }

            if (Math.abs(i-row) == Math.abs(arr[i] - col)) {
                isPossible = false;
            }
        }
        return isPossible;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        System.out.println(cnt);

    }*/


    // #2580 스도쿠 TODO
/*    static int[][] arr;

    static void dfs(int x, int y) {

        if (x == 9) {
            for (int a=0; a<9; ++a) {
                for (int b=0; b<9; ++b) {
                    System.out.print(arr[a][b] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (y==9) {
            dfs(x+1, 0);
            return ;
        }

        if (arr[x][y] == 0) {

            for (int i=1; i<=9; ++i) {
                if (isPossible(x, y, i)) {
                    arr[x][y] = i;
                    dfs(x, y+1);
                }
            }
            arr[x][y] = 0;
            return;
        }

        dfs(x, y+1);

    }

    static boolean isPossible(int x, int y, int k) {

        boolean isPossible = true;

        for (int i=0; i<9; ++i) {
            if(arr[x][i] == k) {
                isPossible = false;
            }
        }

        for (int i=0; i<9; ++i) {
            if(arr[i][y] == k) {
                isPossible = false;
            }
        }

        int i_start;
        int i_end;
        int j_start;
        int j_end;

        if (x <= 2) {i_start = 0; i_end = 2;}
        else if (x >=3 && x<=5) {i_start = 3; i_end = 5;}
        else {i_start = 6; i_end =8;}

        if (y <= 2) {j_start = 0; j_end = 2;}
        else if (y >=3 && y<=5) {j_start = 3; j_end = 5;}
        else {j_start = 6; j_end =8;}

        for (int i=i_start; i<=i_end; ++i) {
            for (int j=j_start; j<=j_end; ++j) {
                if (arr[i][j] == k) {
                    isPossible = false;
                }
            }
        }

        return isPossible;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        arr = new int[9][9];

        for (int i=0; i<9; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<9; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

    }*/

/*    static BufferedWriter bw;
    static int[] arr, answer;

    static void dfs(int start, int len, int depth) throws IOException {

        if (depth == len) {
            for(int i : answer) {
                bw.write(i + " ");
            }
            bw.write('\n');
            return ;
        }
        for(int i=start; i<arr.length; ++i) {
            answer[depth] = arr[i];
            dfs(i, len, depth+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];

        for(int i=0; i<N; ++i) {
            arr[i] = i+1;
        }

        dfs(0, M, 0);

        bw.flush();
        bw.close();

    }*/

    // #2447
/*    static char[][] stars;

    static void recursiveStar(int x, int y, int size) {

        if (size == 1) {
            return;
        } else {

            int chunk = size/3;

            for(int i=x; i<x+size; ++i) {
                for(int j=y; j<y+size; ++j) {
                    if(i >= x+chunk && j >= y+chunk
                            && i < x+size-chunk && j < y+size-chunk) {
                        stars[i][j] = ' ';
                    }
                }
            }

            recursiveStar(x,y,chunk);
            recursiveStar(x,y+chunk,chunk);
            recursiveStar(x,y+2*chunk,chunk);
            recursiveStar(x+chunk,y,chunk);
            recursiveStar(x+chunk,y+2*chunk,chunk);
            recursiveStar(x+2*chunk,y,chunk);
            recursiveStar(x+2*chunk,y+chunk,chunk);
            recursiveStar(x+2*chunk,y+2*chunk,chunk);

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());
        br.close();
        stars = new char[N][N];

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                stars[i][j] = '*';
            }
        }

        recursiveStar(0, 0, N);

        // stars 출력
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                bw.write(stars[i][j]);
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();

    }*/

    // #4779
/*    static StringBuilder canto(String in) {
        if(in.length()==3) {
            return new StringBuilder("- -");
        }

        int div = in.length() / 3;
        StringBuilder middle = new StringBuilder();
        for(int i=0; i<div; ++i) {middle.append(' ');}

        StringBuilder post = canto(in.substring(0, div));

        return new StringBuilder().append(post).append(middle).append(post);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        while(true) {

            String next = br.readLine();

            if(next == null || next.isEmpty()) {
                break;
            }

            int N = Integer.parseInt(next);
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < (int) Math.pow(3, N); ++j) {
                str.append('.');
            }

            if (N == 0) {
                System.out.println("-");
            } else {
                System.out.println(canto(str.toString()));
            }
        }
    }*/

/*    static int cnt;

    static int recursion(char[] s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s[l] != s[r]) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(char[] s){
        return recursion(s, 0, s.length-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i) {
            cnt = 0;
            String str = br.readLine();

            System.out.println(isPalindrome(str.toCharArray()) + " " + cnt);
        }
    }*/

 /*   static long factorial(int N) {
        if (N==0) {
            return 1;
        } else {
            return N*factorial(N-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));

    }*/

 /*   static class Paper {
        int pos;
        int high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; ++i) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int targetPos = Integer.parseInt(st.nextToken());
            Queue<Paper> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<cnt; ++j) {
                Paper paper = new Paper();
                paper.pos = j;
                paper.high = Integer.parseInt(st.nextToken());
                q.offer(paper);
            }

            int result = 0;

            while(!q.isEmpty()) {

//                for(Paper p : q) {
//                    System.out.println(p.pos + " " + p.high);
//                }

                boolean isPass = false;
                int curHigh = q.peek().high;    // 1
                int curPos = q.peek().pos;

                for(Paper p : q) {
                    if (curPos != p.pos && curHigh < p.high) {     //
                        isPass = true;
                    }
                }

                if (isPass) {
                    q.offer(q.poll());
                } else {
                    if(q.peek().pos == targetPos) {
                        result++;
                        break;
                    } else {
                        q.poll();
                        result++;
                    }
                }

            }

            System.out.println(result);

        }

    }*/

    // #1874
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        List<Character> result = new ArrayList<>();

        int top = 1;
        boolean isErr = false;

        for(int i=0; i<N; ++i) {

            int current = Integer.parseInt(br.readLine());

            for(int j=top; j<=current; ++j) {
                stack.push(j);
                result.add('+');
                top++;
            }

            if(stack.peek() == current) {
                stack.pop();
                result.add('-');
            } else {
                isErr = true;
                break;
            }

        }

        if (isErr) {
            System.out.println("NO");
        } else {
            for(Character c : result) {
                System.out.println(c);
            }
        }

    }*/

    /*static class Word {
        String name;
        int count;
        int length;

        String getName() {
            return name;
        }

        int getCount() {
            return count;
        }

        int getLength() {
            return length;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = Integer.parseInt(st.nextToken());
        int cutOffLen = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<cnt; ++i) {
            String word = br.readLine();
            if(word.length() < cutOffLen) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        br.close();

        List<Word> list = new ArrayList<>();
        for(String w : map.keySet()) {
            Word word = new Word();
            word.name = w;
            word.length = w.length();
            word.count = map.get(w);
            list.add(word);
        }

        list.sort(Comparator.comparing(Word::getCount,Comparator.reverseOrder())
                .thenComparing(Word::getLength, Comparator.reverseOrder())
                .thenComparing(Word::getName));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(Word w : list) {
            bw.write(w.getName()+'\n');
        }

        bw.flush();
        bw.close();
    }*/

    // #2108
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];

        for(int i=0; i<N; ++i) {
            nums[i] = Long.parseLong(br.readLine());
        }

        // 1.산술평균
        long sum = 0;
        for(int i=0; i<N; ++i) {
            sum+=nums[i];
        }
        long avg = Math.round((double)sum / (double)N);

        // 2.중앙값
        Arrays.sort(nums);
        long middle =  nums[N/2];

        // 3.최빈값
        Map<Long, Long> map = new HashMap<>();
        List<Long> list = new ArrayList<>();

        for(int i=0; i<N; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0L)+1L);
        }

        long max = -1;
        for(Long l : map.keySet()) {
            if(map.get(l) > max) {
                max = map.get(l);
            }
        }

        for(Long l : map.keySet()) {
            if(map.get(l) == max) {
                list.add(l);
            }
        }

        long mod = 0;

        if(list.size() == 1) {
            mod = list.get(0);
        } else {
            // 내림차순 정렬해서, list.size-2
            Long[] tmp = new Long[list.size()];
            list.toArray(tmp);
            Arrays.sort(tmp, Collections.reverseOrder());
            mod = tmp[list.size()-2];
        }

        // 4.범위
        long right = Arrays.stream(nums).max().getAsLong();
        long left = Arrays.stream(nums).min().getAsLong();
        long range = right - left;

        if(N==1) {
            System.out.println(nums[0]);
            System.out.println(nums[0]);
            System.out.println(nums[0]);
            System.out.println(0);
        } else {
            System.out.println(avg);
            System.out.println(middle);
            System.out.println(mod);
            System.out.print(range);
        }

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int cnt = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for(int i=0; i<cnt; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String first = st.nextToken();
            String second = st.nextToken();

            if (set.contains(first) || set.contains(second)) {
                set.add(first);
                set.add(second);
            }
        }

        System.out.println(set.size());

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int cnt = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;

        for(int i=0; i<cnt; ++i) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                set.clear();
            } else {
                if(!set.contains(input)) {
                    result++;
                    set.add(input);
                }
            }
        }

        System.out.println(result);

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] array = new long[cnt];

        List<Long> list = new ArrayList<>();

        for(int i=0; i<cnt; ++i) {
            list.add(Long.parseLong(st.nextToken()));
        }

        long N = list.stream().mapToLong(x->x).max().orElseThrow(NoSuchElementException::new);

        while (true) {

            boolean isOK = true;

            for (Long l : list) {
                if (N % l != 0L || !list.contains(N/l)) {
                    isOK = false;
                }
            }

            if (isOK) {
                System.out.println(N);
                break;
            }

            N++;
        }
    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; ++i) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long r = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());

            if(r==n){
                System.out.println(1);
                continue;
            }

            long maxCuof = Math.max(n-r, r);
            long minCuof = Math.min(n-r, r);

            long up = 1;
            long down = 1;

            for(long j=maxCuof+1; j<=n; ++j) {
                up *= j;
            }

            for(long j=1; j<=minCuof; ++j) {
                down *= j;
            }

            System.out.println(up/down);


        }

    }*/

/*    public static int factorial(int n) {
        if(n==0) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=1; i*i<=N; ++i) {
            cnt++;
        }

        System.out.println(cnt);
    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int cnt = Integer.parseInt(br.readLine());
        for(int i=0; i<cnt; ++i) {

            int N = Integer.parseInt(br.readLine());

            boolean[] primes = new boolean[N+1];
            Arrays.fill(primes, false);

            List<Integer> list = new ArrayList<>();

            for(int j=2; j<=N; ++j) {
                if(!primes[j]) {
                    list.add(j);
                    for(int k=j; k<=N; k+=j) {
                        primes[k] = true;
                    }
                }
            }

            Integer resultArray[] = list.toArray(new Integer[list.size()]);

            int resultCount= 0;
            int start = 0;
            int end = resultArray.length-1;
            int sum = 0;

            while (start <= end) {

                sum = resultArray[start] + resultArray[end];

                if(sum == N) {
                    resultCount++;
                }

                if (sum <= N) {
                    start++;
                } else {
                    end--;
                }

            }

            if(i < cnt-1) {
                System.out.println(resultCount);
            } else {
                System.out.print(resultCount);
            }


        }

    }*/


/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int cnt = Integer.parseInt(br.readLine());

        long cur = 0;

        for(int i=0; i<cnt; ++i) {

            long N = Long.parseLong(br.readLine());

            if(N == 0 || N == 1 || N == 2) {
                System.out.println(2);
                continue;
            }

            cur = N;

            while(true) {

                boolean flag = true;
                for(long j=2; j<=Math.sqrt(cur); ++j) {
                    if(cur%j == 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    System.out.println(cur);
                    break;
                } else {
                    cur++;
                }

            }

        }

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int cnt = Integer.parseInt(br.readLine());
        int[] nums = new int[cnt-1];
        int GCD = 1;

        int before = Integer.parseInt(br.readLine());
        int min = before;
        int max = 0;

        for(int i=0; i<cnt-1; ++i) {
            nums[i] = before;
            before = Integer.parseInt(br.readLine());
            nums[i] = before - nums[i];

            if(i == cnt-2) {
                max = before;
            }
        }

        GCD = getGCD(nums[0], nums[1]);

        for(int i=2; i<nums.length; ++i) {
            GCD = getGCD(GCD, nums[i]);
        }

        System.out.println( (max - min)/GCD - (nums.length+1) +1 );

    }

    public static int getGCD(int a, int b) {
        if(a%b == 0) {
            return b;
        } else {
            return getGCD(b, a%b);
        }
    }*/

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
