package BAEKJOON.playground;

import java.io.*;
import java.util.*;

public class Main {

    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //int N = Integer.parseInt(br.readLine());
    //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //int N = Integer.parseInt(st.nextToken());
    //String str = br.readLine();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }

    // #11444 피보나치 수 6 TODO
/*    static long[][] fiboMat;
    static long[][] cur;

    static long[][] divide(long n) {
        if (n==1) {
            return fiboMat;
        }

        cur = divide(n/2);

        if (n%2 == 0) {
            return multMat(cur, cur);
        } else {
            return multMat(multMat(cur, cur), fiboMat);
        }

    }

    static long[][] multMat(long[][] mat1, long[][] mat2) {
        long[][] mat3 = new long[mat1.length][mat2.length];

        for(int i=0; i<mat1.length; ++i) {
            for(int j=0; j<mat2[0].length; ++j) {
                long sum = 0L;
                for(int k=0; k<mat1.length; ++k) {
                    sum += mat1[i][k]*mat2[k][j];
                }
                mat3[i][j] = sum % 1000000007L;
            }
        }
        return mat3;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        if(n==1) {
            System.out.println(1);
            System.exit(0);
        } else if(n==2) {
            System.out.println(1);
            System.exit(0);
        }

        fiboMat = new long[2][2];
        fiboMat[0][0] = 1;
        fiboMat[0][1] = 1;
        fiboMat[1][0] = 1;
        fiboMat[1][1] = 0;

        long[][] f0f1 = new long[2][1];
        f0f1[0][0] = 1;
        f0f1[1][0] = 0;

        long[][] answer = multMat(divide(n-1), f0f1);

        System.out.println(answer[0][0]);

    }*/

    // #10830 행렬 제곱
    /*    static long[][] org;
    static long[][] cur;

    static long[][] dfs(long B) {
        if (B==1L) {
            return org;
        }
        cur = dfs(B/2L);

        if (B%2L == 0L) {
            return multMat(cur, cur);
        } else {
            return multMat(multMat(cur,cur), org);
        }
    }

    static long[][] multMat(long[][] mat1, long[][] mat2) {
        long[][] mat3 = new long[mat1.length][mat2.length];

        for(int i=0; i<mat1.length; ++i) {
            for(int j=0; j<mat1.length; ++j) {
                long sum = 0L;
                for(int k=0; k<mat1.length; ++k) {
                    sum += mat1[i][k]*mat2[k][j];
                }
                mat3[i][j] = sum % 1000L;
            }
        }
        return mat3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        org = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                org[i][j] = Integer.parseInt(st.nextToken())%1000L;
            }
        }

        long[][] answer = dfs(B);

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }*/

/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] mat1 = new int[N][M];
        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; ++j) {
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] mat2 = new int[M][K];
        for(int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; ++j) {
                mat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N][K];

        for(int i=0; i<N; ++i) {
            for(int j=0; j<K; ++j) {
                int sum = 0;
                for(int k=0; k<M; ++k) {
                    sum += mat1[i][k]*mat2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }*/

    // #1629 곱셈
/*    static int A;
    static int C;
    static long[] mem;

    static long dfs(int B) {
        // 메모이제이션
        if(B<101L && mem[B] != 0) {
            return mem[B];
        }

        // B가 100,000보다 크면
        //  >> 분할한다. (Recursive)
        if (B > 100L) {
            if(B%2 == 0) return (dfs(B/2) * dfs(B/2))%C;
            else return (dfs(B/2+1)%C * dfs(B/2))%C;
        }
        // B가 100,000보다 작으면
        //  >> 계산한다. (Base)
        else {
            return mem[B] = getRt(B);
        }
        
    }

    static long getRt(int B) {
        // 시작 = A^1%C
        long before = A%C;
        for(int i=1; i<B; ++i) {
            before = A*before%C;
        }
        return before;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mem = new long[101];

        if(B==1) {
            System.out.println(A%C);
            System.exit(0);
        }

        System.out.println(dfs(B));

    }*/

    // #1780 종이의 개수
/*    static int[][] arr;
    static int mOne=0, zero=0, one=0;

    static void dfs(int x, int y, int N) {

        int first = arr[x][y];
        boolean isSame = true;
        for(int i=x; i<x+N; ++i) {
            for(int j=y; j<y+N; ++j) {
                if (arr[i][j] != first) {
                    isSame = false;
                }
            }
        }

        if (isSame) {
            switch (first) {
                case -1 :
                    mOne++;
                    break;
                case 0 :
                    zero++;
                    break;
                case 1 :
                    one++;
                    break;
            }
        } else {
            dfs(x,y,N/3);
            dfs(x,y+N/3,N/3);
            dfs(x,y+2*N/3,N/3);
            dfs(x+N/3,y,N/3);
            dfs(x+N/3,y+N/3,N/3);
            dfs(x+N/3,y+2*N/3,N/3);
            dfs(x+2*N/3,y,N/3);
            dfs(x+2*N/3,y+N/3,N/3);
            dfs(x+2*N/3,y+2*N/3,N/3);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, N);
        System.out.print(mOne+"\n"+zero+"\n"+one);
    }*/

/*    static int[][] arr;
    static StringBuilder answer;

    static void dfs(int x, int y, int n) {

        boolean isSame = true;
        int first = arr[x][y];
        for(int i=x; i<x+n; ++i) {
            for (int j=y; j<y+n; ++j) {
                if(arr[i][j] != first) {
                    isSame = false;
                }
            }
        }

        if (isSame) {
            if (first == 1) {
                answer.append("1");
            } else {
                answer.append("0");
            }
        } else {
            answer.append("(");
            dfs(x, y, n/2);
            dfs(x, y+n/2, n/2);
            dfs(x+n/2, y, n/2);
            dfs(x+n/2, y+n/2, n/2);
            answer.append(")");
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        answer = new StringBuilder("");

        arr = new int[N][N];
        for(int i=0; i<N; ++i) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str[j]);
            }
        }

        int first = arr[0][0];
        boolean isAllSame = true;
        for(int i=0; i<N; ++i) {
            for (int j = 0; j < N; j++) {
                if (first != arr[i][j]) {
                    isAllSame = false;
                }
            }
        }

        if(isAllSame) {
            System.out.println(first);
        } else {
            dfs(0,0,N);
            System.out.println(answer);
        }

    }*/
    
    // #2630 색종이 만들기
/*    static int[][] arr;
    static int whiteTotal = 0;
    static int blueTotal = 0;

    static void dfs(int a, int b, int n) {

        boolean isSame = true;
        int first = arr[a][b];
        for(int i=a; i<a+n; ++i) {
            for(int j=b; j<b+n; ++j) {
                if(arr[i][j] != first) {
                    isSame = false;
                }
            }
        }

        if(isSame) {
            if(first == 0) {
                whiteTotal++;
            } else {
                blueTotal++;
            }
        } else {
            dfs(a, b, n/2);
            dfs(a+n/2, b, n/2);
            dfs(a, b+n/2, n/2);
            dfs(a+n/2, b+n/2, n/2);
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(whiteTotal);
        System.out.println(blueTotal);

    }*/

    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //int N = Integer.parseInt(br.readLine());
    //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //int N = Integer.parseInt(st.nextToken());
    //String str = br.readLine();

    // #13305 주유소
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigDecimal[] dis = new BigDecimal[N];
        BigDecimal[] price = new BigDecimal[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<N; ++i) {
            dis[i] = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            price[i] = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
        }

        BigDecimal answer = BigDecimal.ZERO;
        BigDecimal curPrice = price[0];
        BigDecimal curDis = BigDecimal.ZERO;
        for(int i=1; i<price.length; ++i) {
            if (i == price.length - 1) {
                answer = answer.add(curPrice.multiply(curDis.add(dis[i])));
            } else {
                if(price[i].compareTo(curPrice) < 0) {
                    answer = answer.add(curPrice.multiply(curDis.add(dis[i])));
                    curPrice = price[i];
                    curDis = BigDecimal.ZERO;
                } else {
                    curDis = curDis.add(dis[i]);
                }
            }
        }

        System.out.println(answer);

    }*/

    // #1541 잃어버린 괄호 - 그리디  (리팩토링버전)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strs = str.split("-");

        int answer = 0;
        for(int i=0; i<strs.length; ++i) {
            String[] nums = strs[i].split("\\+");
            int sum = 0;
            for(int j=0; j<nums.length; ++j) {
                sum += Integer.parseInt(nums[j]);
            }
            if(i==0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }*/

    // #1541 잃어버린 괄호 - 그리디
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[51];
        char[] oper = new char[51];

        int i = 0;
        int j=1;
        int sum=0;
        for(int x=0; x<str.length(); ++x) {

            if (Character.isDigit(str.charAt(x))) {
                sum *= 10;
                sum += Character.getNumericValue(str.charAt(x));
            } else {
                arr[i] = sum;
                sum = 0;
                i+=2;
                oper[j] = str.charAt(x);
                j+=2;
            }

        }

        arr[j-1] = sum;

        int answer = arr[0];
        boolean isPositive = true;
        for(int x=2; x<51; ++x) {
            if(!isPositive && oper[x-1]=='-') {
                isPositive = true;
            }

            if(isPositive && oper[x-1]=='-') {
                isPositive = false;
            }

            if(isPositive) {
                answer += arr[x];
            } else {
                answer-=arr[x];
            }
        }

        System.out.println(answer);
    }*/

    // #1931
/*    static class Conf {
        int start;
        int end;
        int getStart() {
            return start;
        }
        int getEnd() {
            return end;
        }

        public String toString() {
            return "start : " + start + ", end : " + end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Conf> list = new ArrayList<>();
        for (int i=0; i<N; ++i) {
            Conf conf = new Conf();
            st = new StringTokenizer(br.readLine(), " ");
            conf.start = Integer.parseInt(st.nextToken());
            conf.end = Integer.parseInt(st.nextToken());
            list.add(conf);
        }

        Collections.sort(list, Comparator
                .comparing(Conf::getEnd)
                .thenComparing(Conf::getStart));
        Conf[] arr = new Conf[list.size()];
        list.toArray(arr);

        int answer = 1;
        int end = arr[0].end;

        for(int i=1; i<N; ++i) {
            if (arr[i].getStart() >= end) {
                end = arr[i].getEnd();
                answer++;
            }
        }

        System.out.println(answer);

    }*/

    // #11047
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int count = 0;

        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-1; i>=0; --i) {
            count += K/arr[i];
            K %= arr[i];
        }

        System.out.println(count);

    }*/

    // #9663 백트래킹
/*    static int answer = 0;
    static int[] arr;
    static int N;

    static void dfs(int i) {

        if(i >= N) {
            answer++;
        } else {

            for(int j=0; j<N; ++j) {
                arr[i] = j;
                if (isPossible(i)) {
                    dfs(i+1);
                }
            }
        }
    }

    static boolean isPossible(int row) {
        boolean isPosb = true;
        for(int i=0; i<row; ++i) {
            if(arr[i] == arr[row] || Math.abs(i-row) == Math.abs(arr[i]-arr[row])) {
                isPosb = false;
            }
        }
        return isPosb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);

        System.out.println(answer);

    }*/

    // #10986
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // M=3 >> 나머지는 0,1,2
        int[] mod = new int[M];
        mod[0] = 1;

        int before = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            before = (before + Integer.parseInt(st.nextToken()))%M;
            mod[before]++;
        }

        long answer = 0;
        for(int i : mod) {
            answer += (long)i * ((long)i-1) / 2;
        }

        System.out.println(answer);

    }*/

    // #25682 체스판 다시칠하기 2
   /* public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        char[][] chess = new char[N+1][M+1];
        int[][] blackSum = new int[N+1][M+1];
        int[][] whiteSum = new int[N+1][M+1];

        for(int i=1; i<=N; ++i) {
            String str = br.readLine();
            for(int j=1; j<=M; ++j) {
                chess[i][j] = str.charAt(j-1);
            }
        }

        // 첫번째가 B인 체스판의 누적합
        char cuOf = 'B';
        int rowSum;
        for(int i=1; i<=N; ++i) {
            rowSum=0;
            for(int j=1; j<=M; ++j) {
                if (chess[i][j] == cuOf) {
                    blackSum[i][j] = blackSum[i-1][j] + rowSum;
                } else {
                    rowSum++;
                    blackSum[i][j] = blackSum[i-1][j] + rowSum;
                }
                if(cuOf == 'W') cuOf = 'B';
                else cuOf = 'W';

            }
            if (M % 2 == 0) {
                if(cuOf == 'W') cuOf = 'B';
                else cuOf = 'W';
            }
        }

        // 첫번째가 W인 체스판의 누적합
        cuOf = 'W';
        for(int i=1; i<=N; ++i) {
            rowSum=0;
            for(int j=1; j<=M; ++j) {
                if (chess[i][j] == cuOf) {
                    whiteSum[i][j] = whiteSum[i-1][j] + rowSum;
                } else {
                    rowSum++;
                    whiteSum[i][j] = whiteSum[i-1][j] + rowSum;
                }
                if(cuOf == 'W') cuOf = 'B';
                else cuOf = 'W';

            }
            if (M % 2 == 0) {
                if(cuOf == 'W') cuOf = 'B';
                else cuOf = 'W';
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=N; i>=K; --i) {
            for(int j=M; j>=K; --j) {
                min = Math.min(min, blackSum[i][j] - blackSum[i][j-K] -blackSum[i-K][j] +blackSum[i-K][j-K]);
                min = Math.min(min, whiteSum[i][j] - whiteSum[i][j-K] -whiteSum[i-K][j] +whiteSum[i-K][j-K]);
            }
        }

        System.out.println(min);
        
    }*/

    // 체스판 다시 칠하기
    /*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chess = new char[N][M];

        for(int i=0; i<N; ++i) {
            String str = br.readLine();
            for (int j = 0; j <M; ++j) {
                chess[i][j] = str.charAt(j);
            }
        }

        int min = 64;

        for(int i=0; i<=N-8; ++i) {
            for(int j=0; j<=M-8; ++j) {

                char cuOf = 'W';
                for(int k=0; k<2; ++k) {
                    int sum = 0;
                    for (int a = i; a < i+8; a++) {
                        for (int b = j; b < j+8; b++) {
                            if(chess[a][b] != cuOf) {
                                sum++;
                            }
                            if(cuOf=='W') cuOf = 'B';
                            else cuOf = 'W';
                        }
                        if(cuOf=='W') cuOf = 'B';
                        else cuOf = 'W';
                    }
                    min = Math.min(min, sum);
                    cuOf = 'B';
                }

            }
        }

        System.out.println(min);

    }*/


    // #11660
/*    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N+1][N+1];

        for(int i=1; i<=N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int rowSum = 0;
            for (int j = 1; j <= N; j++) {
                rowSum += Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i-1][j] + rowSum;
            }
        }

        for(int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int answer = sum[x1][y1] - sum[x2-1][y1] - sum[x1][y2-1] + sum[x2-1][y2-1];
            bw.write(String.valueOf(answer));
            bw.write('\n');
        }

        bw.flush();
        bw.close();

    }*/


    // #10986 나머지 합
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] count = new int[M];
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            sum = (sum+Integer.parseInt(st.nextToken()))%M;
            count[sum]++;
        }

        long answer = count[0];
        for(int i=0; i< count.length; ++i) {
            answer += (long)count[i] * (count[i]-1) / 2;
        }
        System.out.println(answer);

    }*/



/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        List<Integer[]> list = new ArrayList<>();

        Integer[] first = new Integer[26];
        for(int j=0; j<26; ++j) {
            first[j] = 0;
        }
        list.add(first);

        char[] arr = str.toCharArray();
        for(int i=1; i<=arr.length; ++i) {
            Integer[] cur = list.get(i-1).clone();
            cur[(int)arr[i-1]-97]++;
            list.add(cur);
        }

        StringTokenizer st;
        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(list.get(end+1)[(int)c-97]-list.get(start)[(int)c-97]));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }*/

    // #16139
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sums = new ArrayList<>();
        for (int i=N-1; i>=K-1; --i) {
            int sum = 0;
            for(int j=i; j>=i-K+1; --j) {
                sum+=arr[j];
            }
            sums.add(sum);
        }

        System.out.println(Collections.max(sums));

    }*/

    // #11659
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; ++i) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sum[end] - sum[start-1]);
        }

    }*/

    // #12865  - 냅색 1차원배열을 이용한 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N+1][2];

        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];

        for (int i=1; i<=N; ++i) {
            int curWei = items[i][0];
            int curVal = items[i][1];
            for (int j=K; j>=1; --j) {
                if (j>=curWei  &&  curVal + dp[j-curWei] > dp[j]) {
                    dp[j] = curVal + dp[j-curWei];
                }
            }
        }

        System.out.println(dp[K]);
    }*/

    // #12865  - 냅색 2차원배열을 이용한 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N+1][2];

        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for (int i=1; i<=N; ++i) {

            for (int j=1; j<=K; ++j) {
                if (j < items[i][0]) {  // 가방에 현재 아이템을 담지 못하는 경우
                    dp[i][j] = dp[i-1][j];
                } else {  // 가방에 현재 아이템을 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }*/

    // #11054
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length+1][str2.length+1];

        for (int i=1; i<=str1.length; ++i) {
            for (int j=1; j<=str2.length; ++j) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);

    }*/

    // #2565
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = 1;
        dp2[0] = 1;

        for(int i=1; i<N; ++i) {
            for (int j=0; j<=i-1; ++j) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j]);
                }
                if (arr[j] > arr[i]) {
                    dp2[i] = Math.max(dp2[i], Math.max(dp1[j], dp2[j]));
                }
            }
            dp1[i]++;
            dp2[i]++;
        }
        System.out.println(Math.max(Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).max().getAsInt()));

        int[] arr = new int[501];
        int[] dp = new int[501];

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            arr[idx] = val;
        }

        for (int i=1; i<=N; ++i) {
            if (arr[i] != 0) {
                dp[i] = 1;
                break;
            }
        }
        for (int i=2; i<=500; ++i) {
            if (arr[i] != 0) {
                int max = 0;
                for (int j=1; j<=i-1; ++j) {
                    if (arr[j] < arr[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
            }
        }
        System.out.println(N - Arrays.stream(dp).max().getAsInt());

    }*/

    // #12015
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(-1);

        for(int i=0; i<N; ++i) {

            int cur = Integer.parseInt(st.nextToken());

            if (cur > list.get(list.size()-1)) {
                list.add(cur);
            } else {
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int middle = (left + right) / 2;

                    if(list.get(middle) < cur) {
                        left = middle+1;
                    } else {
                        right = middle;
                    }
                }
                list.set(right, cur);
            }
        }

        System.out.println(list.size()-1);
    }*/

    // #11722
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i=1; i<N; ++i) {
            for (int j=0; j<=i-1; ++j) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }*/

    // #11055
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        sum[0] = arr[0];

        for(int i=1; i<N; ++i) {
            for (int j=0; j<=i-1; ++j) {
                if (arr[j] < arr[i] && sum[j] > sum[i]) {
                    dp[i] = dp[j];
                    sum[i] = sum[j];
                }
            }
            sum[i]+=arr[i];
            dp[i]++;
        }

        System.out.println(Arrays.stream(sum).max().getAsInt());

    }*/

        // #11053
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i=1; i<N; ++i) {
            for (int j=0; j<=i-1; ++j) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }*/

    // #2156
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp1 = new int[N+1];
        int[] dp2 = new int[N+1];

        for(int i=1; i<=N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp1 : 직전 + 자신을 마심  >> dp[i-1]는 직전을 안마신애여야 함(dp[i] = dp2[i-1] + 지금)
        // dp2 : 직전x 자신만 마심   >> dp[i-2]까지의 모든 애들중 하나랑, 자신을 마시면됨 ( dp[i] = Math.max(dp1[~i-2], dp2[~i-2] + 현재)
        dp1[0] = 0;
        dp2[0] = 0;
        dp1[1] = arr[1];
        dp2[1] = arr[1];

        for(int i=2; i<=N; ++i) {

            dp1[i] = dp2[i-1] + arr[i];

            int max = -1;
            for(int j=0; j<=i-2; ++j) {
                max = Math.max(max, Math.max(dp1[j], dp2[j]));
            }
            dp2[i] = max + arr[i];

        }
        System.out.println(Math.max(Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).max().getAsInt()));

    }*/


/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i=2; i<=N; ++i) {
            for(int j=0; j<=9; ++j) {
                if(j==0) {
                    dp[i][j] = dp[i-1][1] % 1000000000L;
                } else if (j==9) {
                    dp[i][j] = dp[i-1][8] % 1000000000L;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% 1000000000L;
                }
            }
        }

        System.out.println(Arrays.stream(dp[N]).sum() % 1000000000L);

    }*/

/*    static int[] mem;

    static int dfs(int cur) {
        if (cur == 1) {
            return 0;
        } else {
            if (mem[cur] > 0) {
                return mem[cur];
            }

            int cond1 = Integer.MAX_VALUE;
            int cond2 = Integer.MAX_VALUE;
            int cond3 = Integer.MAX_VALUE;
            if(cur%2 == 0) {
                cond2 = dfs(cur/2);
                mem[cur/2] = cond2;
            }
            if(cur%3==0) {
                cond3 = dfs(cur/3);
                mem[cur/3] = cond3;
            }

            if (mem[cur-1] > 0) {
                cond1 = mem[cur-1];
            } else {
                cond1 = dfs(cur-1);
                mem[cur-1] = cond1;
            }

            cond1 = Math.min(cond1, cond2);
            return mem[cur] = Math.min(cond1, cond3) + 1;
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
        mem = new int[N + 1];
        System.out.println(dfs(N));

    }*/


    // #1463
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+1];

        dp[1] = 0;

        for(int i=2; i<=N; ++i) {

            int cond1 = Integer.MAX_VALUE;
            int cond2 = Integer.MAX_VALUE;
            int cond3 = Integer.MAX_VALUE;

            cond1 = dp[i - 1];
            if (i % 2 == 0) {
                cond2 = dp[i / 2];
            }
            if (i % 3 == 0) {
                cond3 = dp[i / 3];
            }

            dp[i] = Math.min(cond1, cond2);
            dp[i] = Math.min(dp[i], cond3) + 1;
        }

        System.out.println(dp[N]);

    }*/

    // #2579
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp1 = new int[N+1];
        int[] dp2 = new int[N+1];

        for (int i=1; i<=N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp1[0] = 0;
        dp2[0] = 0;
        dp1[1] = arr[1];
        dp2[1] = arr[1];

        for (int i=2; i<=N; ++i) {
            dp1[i] = dp2[i-1] + arr[i];
            dp2[i] = Math.max(dp1[i-2], dp2[i-2]) + arr[i];
        }

        System.out.println(Math.max(dp1[N], dp2[N]));

    }*/

    // #1932
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<i+1; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i=1; i<N; ++i) {
            for(int j=0; j<=i; ++j) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
                else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }

        System.out.println(Arrays.stream(dp[N-1]).max().getAsInt());

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i=1; i<N; ++i) {

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));

    }*/


    // #1912
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAllNegative = true;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; ++i) {
            if (arr[i] >= 0) {
                isAllNegative = false;
            }
            max = Math.max(max, arr[i]);
        }

        int sum = arr[0];
        List<Integer> maxs = new ArrayList<>();

        for(int i=1; i<N; ++i) {
            if (arr[i] < 0) {
                maxs.add(sum);
            }
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
        }

        maxs.add(sum);

        Collections.sort(maxs);

        if (isAllNegative) {
            System.out.println(max);
        } else {
            System.out.println(maxs.get(maxs.size()-1));
        }
    }*/

    // #9461
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //int N = Integer.parseInt(st.nextToken());
        //String str = br.readLine();

        int cnt = Integer.parseInt(br.readLine());

        for (int j=0; j<cnt; ++j) {
            int N = Integer.parseInt(br.readLine());

            long[] arr = new long[N+1];

            if (N==1) {
                System.out.println(1);
                continue;
            } else if (N==2) {
                System.out.println(1);
                continue;
            } else if (N==3) {
                System.out.println(1);
                continue;
            } else if (N==4) {
                System.out.println(2);
                continue;
            } else if (N==5) {
                System.out.println(2);
                continue;
            }

            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;
            arr[5] = 2;

            for(int i=6; i<=N; ++i) {
                arr[i] = arr[i-1] + arr[i-5];
            }

            System.out.println(arr[N]);
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

        int a0 = 1;
        int a1 = 2;
        int cur = 0;

        for (int i=3; i<=N; ++i) {
            cur = a0 + a1;
            a0 = a1;
            a1 = cur;

            if (a0 > 15746 && a1 > 15746) {
                a0 %= 15746;
                a1 %= 15746;

            }

        }

        if (N==1) {
            System.out.println(a0);
        } else if (N==2) {
            System.out.println(a1);
        } else {
            System.out.println(cur % 15746);
        }

    }*/

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
