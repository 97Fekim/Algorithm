package BAEKJOON.playground;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0L;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i=0; i<N; ++i) {
            answer += Math.abs(arr[i] - (i+1));
        }

        System.out.println(answer);

    }

    // #7677 Fibonacci - 행렬곱셈 분할정복을 이용한 피보나치
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
                mat3[i][j] = sum % 10000;
            }
        }
        return mat3;
    }

    public static long getFibo(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        fiboMat = new long[2][2];
        fiboMat[0][0] = 1;
        fiboMat[0][1] = 1;
        fiboMat[1][0] = 1;
        fiboMat[1][1] = 0;

        long[][] f0f1 = new long[2][1];
        f0f1[0][0] = 1;
        f0f1[1][0] = 0;

        long[][] answer;
        answer = multMat(divide(n-1), f0f1);

        return answer[0][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            long N = Long.parseLong(br.readLine());

            if (N == -1) {
                break;
            }

            bw.write(getFibo(N)+"\n");

        }

        bw.flush();
        bw.close();

    }*/

    // 행렬 이분탐색
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = M;

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            int cnt = 0;
            for (int i=1; i<=N; ++i) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= M) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(lt);

    }*/


    // 그리디 플레문제
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; ++i) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (String s : arr) {
            sb.append(s);
            if (Integer.parseInt(s) != 0) {
                isZero = false;
            }
        }

        if (isZero) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }

    }*/

    // #2568 전깃줄2 - 이분탐색을 활용한 LIS ( Nlog(N) ), 역추적
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[500002];
        int[] seq = new int[500002];
        boolean[] check = new boolean[500002];

        int len = 0;
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
            len = Math.max(len, a);
            len = Math.max(len, b);
        }

        // 연결되지 않은 전깃줄은 제거할 필요가 없으므로 check
        for (int i=0; i<=500001; ++i) {
            if (arr[i] == 0) {
                check[i] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        list.add(-1);

        for (int i=0; i<=500001; ++i) {

            // 연결되지 않은 전깃줄은 PASS
            if (arr[i] == 0) {
                continue;
            }

            int cur = arr[i];

            if (cur > list.get(list.size() - 1)) {
                list.add(cur);
                seq[i] = list.size()-1;
                continue;
            }

            int lt = 0;
            int rt = list.size()-1;

            while (lt < rt) {
                int middle = (lt + rt) / 2;

                if (list.get(middle) < cur) {
                    lt = middle + 1;
                } else {
                    rt = middle;
                }
            }
            list.set(rt, cur);
            seq[i] = rt;
        }

        int index = list.size()-1;

        for (int i=500001; i>=0; i--) {
            if (seq[i] == index) {
                check[i] = true;
                index--;
            }
        }

        int answer = 0;
        for (int i=0; i<=500001; ++i) {
            if (!check[i]) answer ++;
        }
        bw.write(answer+"\n");
        for (int i=0; i<=500001; ++i) {
            if (!check[i]) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();

    }*/

    // #12738 가장 긴 증가하는 부분 수열 3 - 이분탐색을 활용한 LIS ( Nlog(N) )
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        list.add(-1000000001);

        for (int i=0; i<N; ++i) {

            int cur = arr[i];

            if (cur > list.get(list.size() - 1)) {
                list.add(cur);
                continue;
            }

            int lt = 0;
            int rt = list.size()-1;

            while (lt < rt) {
                int middle = (lt + rt) / 2;

                if (list.get(middle) < cur) {
                    lt = middle + 1;
                } else {
                    rt = middle;
                }
            }
            list.set(rt, cur);
        }

        System.out.println(list.size()-1);

    }*/

    // #1655 가운데를 말해요 - 이분탐색, 우선순위 큐
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine());
        list.add(first);
        bw.write(first+"\n");

        for (int i=1; i<N; ++i) {
            int cur = Integer.parseInt(br.readLine());

            int index = Collections.binarySearch(list, cur);

            if (index < 0) {
                index = Math.abs(index + 1);
            }

            list.add(index, cur);

            if (list.size() % 2 == 0) {
                bw.write(list.get(list.size()/2 - 1)+"\n");
            } else {
                bw.write(list.get(list.size()/2)+"\n");
            }

        }
        
        bw.flush();
        bw.close();

    }*/

    // #2169 로봇 조종하기 - DP
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][M+1];

        for (int i=1; i<=N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=M; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp_left = new int[N+2][M+2];
        int[][] dp_right = new int[N+2][M+2];
        int[][] dp = new int[N+2][M+2];

        for (int i=0; i<=N+1; ++i) {
            for (int j = 0; j <= M + 1; ++j) {
                dp_left[i][j] = -1000000000;
                dp_right[i][j] = -1000000000;
                dp[i][j] = -1000000000;
            }
        }

        dp[1][1] = graph[1][1];
        dp_left[1][1] = graph[1][1];
        dp_right[1][1] = graph[1][1];

        for (int i=2; i<=M; ++i) {
            dp[1][i] = dp[1][i-1] + graph[1][i];
            dp_left[1][i] = dp_left[1][i-1] + graph[1][i];
            dp_right[1][i] = dp_right[1][i-1] + graph[1][i];
        }

        for (int i=2; i<=N; ++i) {
            
            // 왼쪽 dp row 만들기
            for (int j=1; j<=M; ++j) {
                dp_left[i][j] = Math.max(dp[i-1][j], dp_left[i][j-1]) + graph[i][j];
            }

            // 오른쪽 dp row 만들기
            for (int j=M; j>=1; j--) {
                dp_right[i][j] = Math.max(dp[i-1][j], dp_right[i][j+1]) + graph[i][j];
            }

            // 왼쪽/오른쪽 dp 중 최댓값을 골라서 최종 row 만들기
            for (int j=1; j<=M; ++j) {
                dp[i][j] = Math.max(dp_left[i][j], dp_right[i][j]);
            }
        }

        System.out.print(dp[N][M]+" ");

//        for (int i=0; i<=N+1; ++i) {
//            for (int j = 0; j <= M+1; ++j) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }


    }*/

    // #2352 반도체설계 - 이분탐색을 이용한 LIS *시간복잡도:Nlog(N)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    // #2437 저울 - 그리디
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i=0; i<N; ++i) {
            if (sum + 1 < arr[i]) {
                break;
            }
            sum += arr[i];
        }

        System.out.println(sum+1);

    }*/


    // #17136 색종이 붙이기 - DFS
/*    static int[][] graph = new int[10][10];
    static int[] select_size = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    static void dfs(int row, int col, int sum) {
        if (row > 9) {
            answer = Math.min(answer , sum);
            return ;
        }
        
        if (col > 9) {
            dfs (row+1, 0, sum);
            return ;
        }

        if (graph[row][col] == 1) {
            for (int i=5; i>=1; i--) {
                if (select_size[i] > 0 && check(row, col, i)) {
                    draw(row, col, i, 0);  // 0으로 칠한다.
                    select_size[i]--;
                    dfs(row, col+1, sum+1);
                    select_size[i]++;
                    draw(row, col, i, 1);  // 다시 1로 만든다.
                }
            }
        } else {
            dfs(row, col+1, sum);
        }
        
    }

    static void draw(int row, int col, int size, int value) {
        for (int i=row; i<row+size; ++i) {
            for (int j=col; j<col+size; ++j) {
                graph[i][j] = value;
            }
        }
    }

    static boolean check(int row, int col, int size) {
        for (int i=row; i<row+size; ++i) {
            for (int j=col; j<col+size; ++j) {
                if (i >= 10 || j >= 10 || graph[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<10; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<10; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0,0);

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);

    }*/

/*    static int answer = -1;
    static ArrayList<Node>[] graph;
    static Map<Integer, Integer> scores;
    static Map<Character, Integer> pos_map;
    static int[] moves = new int[10];
    static char[] moving = new char[10];
    static char[] horses = {'a', 'b', 'c', 'd'};

    static void backTracking(int depth) {
        if (depth == 10) {
//            String tmp = "";  //
//            for (char c : moving) {
//                tmp += String.valueOf(c);
//            }

            // 계산한다.
            pos_map = new HashMap<>();
            pos_map.put('a', 0); pos_map.put('b', 0); pos_map.put('c', 0); pos_map.put('d', 0);
            int sum = 0;
            for (int i=0; i<10; ++i) {
                int cur_pos = pos_map.get(moving[i]);
                if (cur_pos == 32) {  // 이미 끝점인 말이 선택되었다면 PASS한다.
                    return ;
                }

                for (int j=0; j<moves[i]; ++j) {

                    // 다음노드 찾기.
                    int next_pos = 0;
                    for (Node n : graph[cur_pos]) {
                        if (j == 0 && n.blueBranch) {
                            next_pos = n.next;
                            break;
                        } else {
                            if (!n.blueBranch) {
                                next_pos = n.next;
                            }
                        }
                    }

                    // 다음 노드로 이동
                    cur_pos = next_pos;
                    if (cur_pos == 32) {
                        break;
                    }

                }

                // 도착한 노드가 도착점이 아니며, 도착한 노드에 다른 말이 있다면 PASS
                for (char c : pos_map.keySet()) {
                    if (cur_pos != 32 && pos_map.get(c) == cur_pos) {
                        return ;
                    }
                }
                // 도착한 노드의 점수를 반영
                sum += scores.get(cur_pos);

                // 현재 말의 위치를 변경
                pos_map.remove(moving[i]);
                pos_map.put(moving[i], cur_pos);
//
//                if (tmp.equals("dcddbbaaba")) {
//                    System.out.println(pos_map);
//                }
            }
            answer = Math.max(answer, sum);
//            if (sum == 195) {
//                for (char c : moving) {
//                    System.out.print(c + " ");
//                }
//                System.out.println();
//                System.out.println(pos_map);
//            }

        } else {
            for (int i=0; i<4; ++i) {
                moving[depth] = horses[i];
                backTracking(depth+1);
            }
        }
    }

    // #17825 주사위 윷놀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new ArrayList[33];
        for (int i=0; i<33; ++i) {
            graph[i] = new ArrayList<>();
        }
        scores = new HashMap<>();

        makeGraph();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<10; ++i) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(answer);
    }

    static void makeGraph() {
        graph[0].add(new Node(1, false));
        graph[1].add(new Node(2, false));
        graph[2].add(new Node(3, false));
        graph[3].add(new Node(4, false));
        graph[4].add(new Node(5, false));
        graph[5].add(new Node(6, false));
        graph[6].add(new Node(7, false));
        graph[7].add(new Node(8, false));
        graph[8].add(new Node(9, false));
        graph[9].add(new Node(10, false));
        graph[10].add(new Node(11, false));
        graph[11].add(new Node(12, false));
        graph[12].add(new Node(13, false));
        graph[13].add(new Node(14, false));
        graph[14].add(new Node(15, false));
        graph[15].add(new Node(16, false));
        graph[16].add(new Node(17, false));
        graph[17].add(new Node(18, false));
        graph[18].add(new Node(19, false));
        graph[19].add(new Node(20, false));
        graph[20].add(new Node(32, false));

        graph[21].add(new Node(22, false));
        graph[22].add(new Node(23, false));
        graph[23].add(new Node(29, false));

        graph[24].add(new Node(25, false));
        graph[25].add(new Node(29, false));

        graph[26].add(new Node(27, false));
        graph[27].add(new Node(28, false));
        graph[28].add(new Node(29, false));

        graph[29].add(new Node(30, false));
        graph[30].add(new Node(31, false));
        graph[31].add(new Node(20, false));

        // 분기점
        graph[5].add(new Node(21, true));
        graph[10].add(new Node(24, true));
        graph[15].add(new Node(26, true));

        scores.put(0, 0);
        scores.put(1, 2);
        scores.put(2,4);
        scores.put(3,6);
        scores.put(4,8);
        scores.put(5,10);

        scores.put(6,12);
        scores.put(7,14);
        scores.put(8,16);
        scores.put(9,18);
        scores.put(10,20);

        scores.put(11,22);
        scores.put(12,24);
        scores.put(13,26);
        scores.put(14,28);
        scores.put(15,30);

        scores.put(16,32);
        scores.put(17,34);
        scores.put(18,36);
        scores.put(19,38);
        scores.put(20,40);

        scores.put(32,0);

        scores.put(21,13);
        scores.put(22,16);
        scores.put(23,19);
        scores.put(29,25);

        scores.put(24,22);
        scores.put(25,24);
        scores.put(28,26);
        scores.put(27,27);
        scores.put(26,28);

        scores.put(30,30);
        scores.put(31,35);


    }

    static class Node {
        int next;
        boolean blueBranch;
        Node (int next, boolean blueBranch) {
            this.next = next;
            this.blueBranch = blueBranch;
        }
        Node () {

        }
    }*/

    // #1941 소문난 칠공주 - 백트래킹, BFS
/*    static class Node {
        int row;
        int col;

        Node (int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object oo) {
            Node o = (Node) oo;
            return o.row == this.row && o.col == this.col;
        }

        public int hashCode() {
            return (row+""+col).hashCode();
        }

    }
    static Node[] src = new Node[25];
    static Node[] result = new Node[7];
    static char[][] graph = new char[5][5];
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    static int answer = 0;

    static void backTracking(int depth, int init) {
        if (depth == 7) {
            // BFS를 수행한다.
            Set<Node> set = new HashSet<>();
            for (Node n : result) {
                set.add(new Node(n.row, n.col));
            }

            Queue<Node> q = new LinkedList<>();
            q.offer(result[0]);

            int S = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (!set.contains(new Node(cur.row, cur.col))) {
                    continue;
                }
                set.remove(new Node(cur.row, cur.col));

                if (graph[cur.row][cur.col] == 'S') {
                    S++;
                }

                for (int i=0; i<4; ++i) {
                    int next_row = cur.row + d_row[i];
                    int next_col = cur.col + d_col[i];
                    if (next_row >= 0 && next_row < 5 && next_col >= 0 && next_col < 5) {
                        q.offer(new Node(next_row, next_col));
                    }
                }
            }

            if (set.isEmpty() && S >= 4) {
                answer ++;
            }

        } else {

            for (int i=init; i<25; ++i) {
                result[depth] = new Node(src[i].row, src[i].col);
                backTracking(depth+1, i+1);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=0; j<5; ++j) {
                graph[i][j] = inputs[j];
            }
        }

        int idx = 0;
        for (int i=0; i<5; ++i) {
            for (int j = 0; j < 5; ++j) {
                src[idx++] = new Node(i, j);
            }
        }

        backTracking(0, 0);
        System.out.println(answer);
    }*/

    // #4485 녹색 옷 입은 애가 젤다지? - 다익스트라
/*    static class Edge implements Comparable<Edge> {
        int row;
        int col;
        int wei;
        Edge (int row, int col, int wei) {
            this.row = row;
            this.col = col;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, -1, 0, 1};

        int case_cnt = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            case_cnt++;

            int[][] graph = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int[][] dis = new int[N][N];
            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    dis[i][j] = 100000000;
                }
            }

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; ++j) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 다익스트라 시작
            PriorityQueue<Edge> q = new PriorityQueue<>();
            dis[0][0] = graph[0][0];
            q.offer(new Edge(0, 0, graph[0][0]));

            while (!q.isEmpty()) {
                Edge cur = q.poll();
                if (visited[cur.row][cur.col]) {
                    continue;
                }
                visited[cur.row][cur.col] = true;

                for (int i=0; i<4; ++i) {
                    int next_row = cur.row + d_row[i];
                    int next_col = cur.col + d_col[i];

                    if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < N
                            && dis[cur.row][cur.col] + graph[next_row][next_col] < dis[next_row][next_col]) {
                        dis[next_row][next_col] = dis[cur.row][cur.col] + graph[next_row][next_col];
                        q.offer(new Edge(next_row, next_col, dis[next_row][next_col]));
                    }
                }
            }

            bw.write("Problem "+case_cnt+": "+dis[N-1][N-1]+"\n");

//            for (int i=0; i<N; ++i) {
//                for (int j = 0; j < N; ++j) {
//                    System.out.print(dis[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        bw.flush();
        bw.close();

    }*/

    // #2661 좋은수열 - 백트래킹
/*    static int N;
    static int[] seq = {1, 2, 3};

    static void backTracking(String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);
        } else {
            for (int i=0; i<3; ++i) {
                if (possible(result+seq[i])) {
                    backTracking(result+seq[i]);
                }
            }
        }
    }

    static boolean possible(String str) {
        boolean isPossible = true;
        for (int i=1; i<= str.length()/2; ++i) {
            String first = str.substring(str.length() - i*2 ,str.length()-i);
            String second = str.substring(str.length()-i ,str.length());
            if (first.equals(second)) {
                isPossible = false;
            }
        }
        return isPossible;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backTracking("");
    }*/

    // #3190 뱀 - 덱, 구현
/*    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        char[][] graph = new char[N+1][N+1];

        for (int i=1; i<=N; ++i) {
            for (int j = 1; j <= N; ++j) {
                graph[i][j] = 'O';
            }
        }

        while (K --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 'A';  // Apple
        }

        Map<Integer, Character> cmd_map = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        while (L --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            cmd_map.put(a, c);
        }


        Deque<Point> snake_deq = new LinkedList<>();
        char cur_cmd = 'R';
        snake_deq.offerFirst(new Point(1,1));
        graph[1][1] = 'S';
        int depth = 0;

        while (true) {

            // 현재 좌표 = deq.peekFirst
            Point cur_point = snake_deq.peekFirst();
            // 현재 방향에 따라 다음칸으로 이동.
            int next_row=0, next_col=0;
            if (cur_cmd == 'R') {
                next_row = cur_point.row;
                next_col = cur_point.col+1;
            }  else if (cur_cmd == 'D') {
                next_row = cur_point.row+1;
                next_col = cur_point.col;
            }  else if (cur_cmd == 'L') {
                next_row = cur_point.row;
                next_col = cur_point.col-1;
            }  else if (cur_cmd == 'U') {
                next_row = cur_point.row-1;
                next_col = cur_point.col;
            }
            //   다음칸이 밖이거나, 스네이크(S)이면 depth+1 출력하고 종료
            if (next_row <= 0 || next_row > N || next_col <= 0 || next_col > N) {
                System.out.println(depth+1);
                System.exit(0);
            }
            if (graph[next_row][next_col] == 'S') {
                System.out.println(depth+1);
                System.exit(0);
            }

            //   다음칸이 사과냐 아니냐에 따라 Queue 조작
            //      다음칸이 사과이면 graph[다음칸]을 S로 만들고, deq.offerFirst(다음좌표)
            if (graph[next_row][next_col] == 'A') {
                graph[next_row][next_col] = 'S';
                snake_deq.offerFirst(new Point(next_row, next_col));
            }
            //      다음칸이 사과가 아니면 graph[다음칸]을 S로 만들고, deq.offerFirst(다음좌표); deq.pollLast(); pollLast한 좌표에 graph를 공백으로 초기화한다.
            else {
                graph[next_row][next_col] = 'S';
                snake_deq.offerFirst(new Point(next_row, next_col));
                Point before = snake_deq.pollLast();
                graph[before.row][before.col] = 'O';
            }

            // 끝나고 방향 바꾸기
            depth++;
            if (cmd_map.get(depth) != null) {
                if (cmd_map.get(depth) == 'L') {  // 왼쪽
                    if (cur_cmd == 'R') cur_cmd = 'U';
                    else if (cur_cmd == 'D') cur_cmd = 'R';
                    else if (cur_cmd == 'L') cur_cmd = 'D';
                    else if (cur_cmd == 'U') cur_cmd = 'L';
                } else {  // 오른쪽
                    if (cur_cmd == 'R') cur_cmd = 'D';
                    else if (cur_cmd == 'D') cur_cmd = 'L';
                    else if (cur_cmd == 'L') cur_cmd = 'U';
                    else if (cur_cmd == 'U') cur_cmd = 'R';
                }
            }

            for (int i=1; i<=N; ++i) {
                for (int j=1; j<=N; ++j) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }


    }*/

    // #3055 탈출 - BFS
 /*   static class Edge {
        int row;
        int col;
        Edge (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, -1, 0, 1};

        int start_row = 0;
        int start_col = 0;

        for(int i=0; i<N; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=0; j<M; ++j) {
                graph[i][j] = inputs[j];
                if (graph[i][j] == 'S') {
                    start_row = i;
                    start_col = j;
                }
            }
        }

        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(start_row, start_col));

        int depth = 0;
        while (!q.isEmpty()) {

            Queue<Edge> water = new LinkedList<>();
            for(int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (graph[i][j] == '*') {
                        for (int k=0; k<4; ++k) {
                            int next_row = i + d_row[k];
                            int next_col = j + d_col[k];

                            if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M &&
                                    graph[next_row][next_col] != 'X' && graph[next_row][next_col] != 'D') {
                                water.offer(new Edge(next_row, next_col));
                            }
                        }
                    }
                }
            }
            for (Edge e : water) {
                graph[e.row][e.col] = '*';
            }

//            for (Edge e : q) {
//                System.out.print("["+ e.row+", "+e.col+"], ");
//            }
//            System.out.println();
//            for(int i=0; i<N; ++i) {
//                for (int j = 0; j < M; ++j) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


            int len = q.size();
            for (int i=0; i<len; ++i) {
                Edge cur = q.poll();

                if (visited[cur.row][cur.col]) {
                    continue;
                }
                visited[cur.row][cur.col] = true;

                if (graph[cur.row][cur.col] == 'D') {
                    System.out.println(depth);
                    System.exit(0);
                }

                for (int j=0; j<4; ++j) {
                    int next_row = cur.row + d_row[j];
                    int next_col = cur.col + d_col[j];
                    if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M
                            && (graph[next_row][next_col] == '.' || graph[next_row][next_col] == 'D') ) {
                        q.offer(new Edge(next_row, next_col));
                    }
                }

            }

            depth++;
        }

        System.out.println("KAKTUS");

    }*/

/*    static int N, M;
    static char[][] graph;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    static int min = 100000000;

    static void dfs(int row1, int col1, int row2, int col2, int depth) {
        if (depth >= 10) {
            return ;
        } else {
            for (int i=0; i<4; ++i) {
                int next_row1 = row1 + d_row[i]; int next_col1 = col1 + d_col[i]; int next_row2 = row2 + d_row[i]; int next_col2 = col2 + d_col[i];

                // 둘다 빠진다. continue
                if ((next_row1 < 0 || next_row1 >= N || next_col1 < 0 || next_col1 >= M) && (next_row2 < 0 || next_row2 >= N || next_col2 < 0 || next_col2 >= M)) {
                    continue;
                }

                // 둘다 갈곳이 벽이다. continue
                if (next_row1 >= 0 && next_col1 >= 0 && next_row1 < N && next_col1 < M
                        && next_row2 >= 0 && next_col2 >= 0 && next_row2 < N && next_col2 < M
                        && graph[next_row1][next_col1] == '#' && graph[next_row2][next_col2] == '#') {
                    continue;
                }

                // 한놈만 빠진다. max 갱신하고 return ;
                if ((next_row1 < 0 || next_row1 >= N || next_col1 < 0 || next_col1 >= M) || (next_row2 < 0 || next_row2 >= N || next_col2 < 0 || next_col2 >= M)) {
                    min = Math.min(min, depth+1);
                }
                // 둘다 갈곳이 있다. dfs
                else {
                    if (graph[next_row1][next_col1] == '#') {
                        dfs(row1, col1, next_row2, next_col2, depth+1);
                    } else if (graph[next_row2][next_col2] == '#') {
                        dfs(next_row1, next_col1, row2, col2, depth+1);
                    } else {
                        dfs(next_row1, next_col1, next_row2, next_col2, depth+1);
                    }
                }
            }
        }
    }

    // #16197 두 동전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        Queue<Integer> init_point = new LinkedList<>();

        for(int i=0; i<N; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=0; j<M; ++j) {
                graph[i][j] = inputs[j];
                if (graph[i][j] == 'o') {
                    init_point.offer(i);
                    init_point.offer(j);
                }
            }
        }

        int init_row1 = init_point.poll();
        int init_col1 = init_point.poll();
        int init_row2 = init_point.poll();
        int init_col2 = init_point.poll();

        dfs(init_row1, init_col1, init_row2, init_col2, 0);

        System.out.println(min != 100000000 ? min : -1);

    }*/

    // #5052 전화번호 목록 - 문자열,자료구조,트리,트라이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            Set<String> set = new HashSet<>();

            for (int i=0; i<n; ++i) {
                String input = br.readLine();
                arr[i] = input;
                set.add(input);
            }

            boolean isConc = true;
            for (int i=0; i<n; ++i) {
                String cur = arr[i];
                for (int j=0; j<cur.length(); ++j) {  // 목록의 두 전화번호가 같은 경우는 없으므로 j != cur.length()
                    if (set.contains(cur.substring(0, j))) {
                        isConc = false;
                    }
                }
            }

            System.out.println(isConc ? "YES" : "NO");

        }

    }*/

    // #1405 미친 로봇
/*    static int N;
    static int[] d_row = {0, 0, 1, -1};
    static int[] d_col = {1, -1, 0, 0};
    static double[] percents;
    static boolean[][] visited;
    static double answer = 0;

    static void dfs(int row, int col, int depth, double percent) {
        if (depth == N) {
            answer += percent;
        } else {
            visited[row][col] = true;

            for (int i=0; i<4; ++i) {
                int next_row = row + d_row[i];
                int next_col = col + d_col[i];
                if (!visited[next_row][next_col]) {
                    //visited[next_row][next_col] = true;
                    dfs(next_row, next_col, depth+1, percent*percents[i]);
                    visited[next_row][next_col] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        percents = new double[4];
        for (int i=0; i<4; ++i) {
            percents[i] = Double.parseDouble(st.nextToken()) / 100d;
        }

        visited = new boolean[40][40];

        dfs(20, 20, 0, 1.0d);

        System.out.println(answer);

    }*/

    // #16234 인구 이동
/*    static int N, L, R;
    static int[][] graph;
    static int[][] visited;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    static Map<Integer, Integer> sum_map;
    static Map<Integer, Integer> cnt_map;

    static void dfs(int row, int col, int rabel) {
        for (int i=0; i<4; ++i) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];
            if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < N
                    && visited[next_row][next_col] == 0
                    && Math.abs(graph[row][col] - graph[next_row][next_col]) <= R
                    && Math.abs(graph[row][col] - graph[next_row][next_col]) >= L) {
                visited[next_row][next_col] = rabel;
                sum_map.put(rabel, sum_map.getOrDefault(rabel, 0) + graph[next_row][next_col]);
                cnt_map.put(rabel, cnt_map.getOrDefault(rabel, 0) + 1);
                dfs(next_row, next_col, rabel);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {

            sum_map = new HashMap<>();
            cnt_map = new HashMap<>();
            visited = new int[N][N];
            int rabel = 1;

            for (int i=0; i<N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = rabel;
                        sum_map.put(rabel, sum_map.getOrDefault(rabel, 0) + graph[i][j]);
                        cnt_map.put(rabel, cnt_map.getOrDefault(rabel, 0) + 1);
                        dfs(i, j, rabel);
                        rabel++;
                    }
                }
            }

            for (int i=0; i<N; ++i) {
                for (int j = 0; j < N; ++j) {
                    graph[i][j] = (int) Math.floor( (double)sum_map.get(visited[i][j]) / (double)cnt_map.get(visited[i][j]) );
                }
            }

            if (rabel == N*N + 1) {
                System.out.println(days);
                System.exit(0);
            } else {
                days++;
            }
        }

    }*/

    // #15961 회전 초밥
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();

        // 초깃값
        for (int i=0; i<k; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        map.put(c, map.getOrDefault(c, 0) + 1);

        int max = map.size();

        // 순회 시작
        for (int i=1; i<N; ++i) {
            int lt = i-1;
            int rt = (i + k - 1) % N;

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            max = Math.max(max, map.size());
        }

        System.out.println(max);

    }*/

    // #4803 트리
/*    static class Edge {
        int cur;
        int before;
        Edge (int cur, int before) {
            this.cur = cur;
            this.before = before;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int case_num = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n==0 && m==0) {
                break;
            }

            case_num++;
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for (int i=0; i<=n; ++i) {
                graph[i] = new ArrayList<>();
            }

            while (m --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a == b) {
                    continue;
                }
                if (!graph[a].contains(b)) {
                    graph[a].add(b);
                }
                if (!graph[b].contains(a)) {
                    graph[b].add(a);
                }
            }

            boolean[] visited = new boolean[n+1];

            int tree_cnt = 0;
            for (int i=1; i<=n; ++i) {

                if (visited[i]) {
                    continue;
                }

                int node_cnt = 0;
                int edge_cnt = 0;

                Queue<Edge> q = new LinkedList<>();
                q.offer(new Edge(i, 0));

                while (!q.isEmpty()) {
                    Edge cur = q.poll();

                    if (visited[cur.cur]) {
                        continue;
                    }
                    visited[cur.cur] = true;
                    node_cnt++;

                    for (int next : graph[cur.cur]) {
                        q.offer(new Edge(next, cur.cur));

                        if (cur.before != next) {
                            edge_cnt++;
                        }
                    }
                }

                if (node_cnt == edge_cnt + 1) {
                    tree_cnt ++;
                }

            }
            if (tree_cnt == 0) {
                System.out.println("Case "+case_num+": No trees.");
            } else if (tree_cnt == 1) {
                System.out.println("Case "+case_num+": There is one tree.");
            } else {
                System.out.println("Case "+case_num+": A forest of "+tree_cnt+" trees.");
            }

        }

    }*/

    // 줄세우기 - DP (LIS)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];

        dp[0] = 1;

        for (int i=1; i<N; ++i) {
            int lis = 0;
            for (int j=0; j<=i-1; ++j) {
                if (arr[i] > arr[j]) {
                    lis = Math.max(lis, dp[j]);
                }
            }
            dp[i] = lis + 1;
        }

        int LIS = Arrays.stream(dp).max().getAsInt();

        System.out.println(N - LIS);

    }*/


/*    static class Edge implements Comparable<Edge> {
        int v;
        int wei;
        public Edge (int v, int wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    // #10282 해킹 - TODO 다익스트라 구하고, 다익스트라 배열 중 최대거리를 구한다? 어차피 그 최대거리를 가는동안 다른곳은 모두 도착을 했으니까?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] dis = new int[n+1];
            boolean[] visited = new boolean[n+1];
            ArrayList<Edge>[] graph = new ArrayList[n+1];
            for (int i=0; i<=n; ++i) {
                graph[i] = new ArrayList<>();
            }

            while (d --> 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                graph[y].add(new Edge(x, z));
            }

            PriorityQueue<Edge> q = new PriorityQueue<>();
            q.offer(new Edge(c, 0));

            Arrays.fill(dis, 1000000001);
            dis[c] = 0;

            while (!q.isEmpty()) {
                Edge cur = q.poll();

                if (visited[cur.v]) {
                    continue;
                }
                visited[cur.v] = true;

                for (Edge next : graph[cur.v]) {
                    if (dis[cur.v] + next.wei < dis[next.v]) {
                        dis[next.v] = dis[cur.v] + next.wei;
                        q.offer(new Edge(next.v, dis[next.v]));
                    }
                }
            }

            int cnt = 1;
            int max = -1;
            for(int i=1; i<=n; ++i) {
                if (i != c && dis[i] != 1000000001) {
                    cnt++;
                    max = Math.max(max, dis[i]);
                }
            }

            if (max == -1) {
                System.out.println(1 + " " + 0);
                continue;
            }

            if (n == 1) {
                System.out.println(1 + " " + 0);
            } else {
                System.out.println(cnt + " " + max);
            }

        }

    }*/

    // #16562 친구비
/*    static int[] parent;
    static int[] costs;

    static int find(int a) {
        if (parent[a] == a) {
            return parent[a];
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentA] = parentB;
//            if (parentA > parentB) {
//                parent[parentA] = parentB;
//            } else {
//                parent[parentB] = parentA;
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        costs = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; ++i) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; ++i) {
            parent[i] = i;
        }
        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        // 한번에 안되면, 여기에 i~N 돌면서 find 한번씩 하자.
//        for (int i=1; i<=N; ++i) {
//            find(i);
//        }

        Queue<Integer>[] qs = new PriorityQueue[N+1];
        for (int i=0; i<=N; ++i) {
            qs[i] = new PriorityQueue<>();
        }

        for (int i=1; i<=N; ++i) {
            qs[find(i)].add(costs[i]);
        }

        int answer = 0;
        for (int i=1; i<=N; ++i) {
            if (!qs[i].isEmpty()) {
                answer += qs[i].poll();
            }
        }

        if (answer > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(answer);
        }

    }*/

/*    static class CCTV {
        int row;
        int col;
        String status;

        public CCTV(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public CCTV(int row, int col, String status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }

    static int N, M;
    static int[][] graph;
    static int[][] wkGraph;
    static ArrayList<CCTV> org;
    static ArrayList<CCTV> result;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    static void backTracking(int depth) {
        if (result.size() == org.size()) {
            wkGraph = new int[N][M];
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    wkGraph[i][j] = graph[i][j];
                }
            }

            for (CCTV cur : result) {
                int cur_value = graph[cur.row][cur.col];
                if (cur_value == 1){
                    String cmd = cur.status;
                    if (cmd.equals("left")) {
                        setLeftArea(cur.row, cur.col);
                    } else if (cmd.equals("right")) {
                        setRightArea(cur.row, cur.col);
                    } else if (cmd.equals("up")) {
                        setUpArea(cur.row, cur.col);
                    } else if (cmd.equals("down")) {
                        setDownArea(cur.row, cur.col);
                    }
                }
                else if (cur_value == 2) {
                    String cmd = cur.status;
                    if (cmd.equals("horizonal")) {
                        setLeftArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                    } else if (cmd.equals("vertical")) {
                        setUpArea(cur.row, cur.col);
                        setDownArea(cur.row, cur.col);
                    }
                }
                else if (cur_value == 3) {
                    String cmd = cur.status;
                    if (cmd.equals("up_right")) {
                        setUpArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                    } else if (cmd.equals("down_right")) {
                        setDownArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                    } else if (cmd.equals("down_left")) {
                        setDownArea(cur.row, cur.col);
                        setLeftArea(cur.row, cur.col);
                    } else if (cmd.equals("up_left")) {
                        setUpArea(cur.row, cur.col);
                        setLeftArea(cur.row, cur.col);
                    }
                }
                else if (cur_value == 4) {
                    String cmd = cur.status;
                    if (cmd.equals("left")) {
                        setUpArea(cur.row, cur.col);
                        setLeftArea(cur.row, cur.col);
                        setDownArea(cur.row, cur.col);
                    } else if (cmd.equals("right")) {
                        setUpArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                        setDownArea(cur.row, cur.col);
                    } else if (cmd.equals("up")) {
                        setLeftArea(cur.row, cur.col);
                        setUpArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                    } else if (cmd.equals("down")) {
                        setLeftArea(cur.row, cur.col);
                        setDownArea(cur.row, cur.col);
                        setRightArea(cur.row, cur.col);
                    }
                }
                else if (cur_value == 5) {
                    setLeftArea(cur.row, cur.col);
                    setDownArea(cur.row, cur.col);
                    setRightArea(cur.row, cur.col);
                    setUpArea(cur.row, cur.col);
                }
            }

            int sum = 0;
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (wkGraph[i][j] == 0) {
                        sum++;
                    }
                }
            }

            answer = Math.min(answer, sum);

        } else {
            for (int i=depth; i< org.size(); ++i) {

                CCTV cur = org.get(i);

                int cur_value = graph[cur.row][cur.col];

                if (cur_value == 1) {
                    result.add(new CCTV(cur.row, cur.col, "left"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "right"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "up"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "down"));
                    backTracking(i+1);
                    result.remove(result.size()-1);
                }
                else if (cur_value == 2) {
                    result.add(new CCTV(cur.row, cur.col, "horizonal"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "vertical"));
                    backTracking(i+1);
                    result.remove(result.size()-1);
                }
                else if (cur_value == 3) {
                    result.add(new CCTV(cur.row, cur.col, "up_right"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "down_right"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "down_left"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "up_left"));
                    backTracking(i+1);
                    result.remove(result.size()-1);
                }
                else if (cur_value == 4) {
                    result.add(new CCTV(cur.row, cur.col, "left"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "right"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "up"));
                    backTracking(i+1);
                    result.remove(result.size()-1);

                    result.add(new CCTV(cur.row, cur.col, "down"));
                    backTracking(i+1);
                    result.remove(result.size()-1);
                }
                else if (cur_value == 5) {
                    result.add(new CCTV(cur.row, cur.col));
                    backTracking(i+1);
                    result.remove(result.size()-1);
                }
            }
        }
    }

    // #15683 감시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        org = new ArrayList<>();
        result = new ArrayList<>();

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if (a != 0 && a != 6) {
                    org.add(new CCTV(i, j));
                }
            }
        }

        visited = new boolean[org.size()];

        backTracking(0);

        System.out.println(answer);

    }

    static void setLeftArea(int row, int col) {
        for (int i=col-1; i>=0; i--) {
            if (wkGraph[row][i] == 6) {
                break;
            }
            wkGraph[row][i] = 9;

        }
    }

    static void setRightArea(int row, int col) {
        for (int i=col+1; i<M; ++i) {
            if (wkGraph[row][i] == 6) {
                break;
            }

            wkGraph[row][i] = 9;

        }
    }

    static void setUpArea(int row, int col) {
        for (int i=row-1; i>=0; i--) {
            if (wkGraph[i][col] == 6) {
                break;
            }

            wkGraph[i][col] = 9;

        }
    }

    static void setDownArea(int row, int col) {
        for (int i=row+1; i<N; ++i) {
            if (wkGraph[i][col] == 6) {
                break;
            }

            wkGraph[i][col] = 9;

        }
    }*/

/*    static class Node {
        int row;
        int col;
        int wei;
        Node(int row, int col, int wei) {
            this.row = row;
            this.col = col;
            this.wei = wei;
        }
    }

    // #2665 미로만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, -1, 0, 1};
        int[][] graph = new int[N][N];
        int[][] visited = new int[N][N];

        for (int i=0; i<N; ++i) {
            Arrays.fill(visited[i], 2501);
        }

        for (int i=0; i<N; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=0; j<N; ++j) {
                graph[i][j] = Integer.parseInt(String.valueOf(inputs[j]));
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0));

        visited[0][0] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i=0; i<4; ++i) {
                int next_row = cur.row + d_row[i];
                int next_col = cur.col + d_col[i];

                if (next_row < 0 || next_col < 0 || next_row >=N || next_col >=N) {
                    continue;
                }

                // 방문한 적이 없다? (visited == 2501)
                //   >> visited[next_row][next_col] = wei;
                //   >> q.offer(new Node(next_row, next_col, wei);
                // 방문한 적이 있다?
                //   >> if (cur.wei < visited[next_row][next_col]) {
                //   >>     q.offer(new Node(next_row, next_col, wei);
                //   >> }
                if (visited[next_row][next_col] == 2501) {
                    if (graph[next_row][next_col] == 1) {  // 벽X ==> 그대로
                        visited[next_row][next_col] = cur.wei;
                        q.offer(new Node(next_row, next_col, cur.wei));
                    } else {
                        visited[next_row][next_col] = cur.wei+1;
                        q.offer(new Node(next_row, next_col, cur.wei + 1));
                    }
                } else {
                    if (graph[next_row][next_col] == 1) { // 벽X
                        if (cur.wei < visited[next_row][next_col]) {
                            visited[next_row][next_col] = cur.wei;
                            q.offer(new Node(next_row, next_col, cur.wei));
                        }
                    } else {
                        if (cur.wei + 1 < visited[next_row][next_col]) {
                            visited[next_row][next_col] = cur.wei+1;
                            q.offer(new Node(next_row, next_col, cur.wei + 1));
                        }
                    }
                }
            }
        }

        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }

    }*/
    
/*    static int N, M;
    static int[][] src_graph;
    static int[][] dst_graph;
    static int[][] visited;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};

    static void dfs(int row, int col, int value) {
        int cur = src_graph[row][col];

        for (int i=0; i<4; ++i) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];
            if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M &&
                    visited[next_row][next_col] == 0 &&
                    src_graph[next_row][next_col] == cur) {

                visited[next_row][next_col] = value;
                dfs(next_row, next_col, value);
            }
        }
    }

    // #2636 치즈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // visited[0] : 아직 체크하지 않음
        // visited[1] : 바깥 공기영역임
        // visited[2] : 치즈 영역임
        // visited[3] : 치즈 내부 영역임

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src_graph = new int[N][M];
        dst_graph = new int[N][M];
        visited = new int[N][M];

        boolean isCheeseEmpty = true;
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    isCheeseEmpty = false;
                }
                src_graph[i][j] = a;
            }
        }
        if (isCheeseEmpty) { // 처음부터 치즈가 없다면 종료
            System.out.println(0);
            System.out.println(0);
            System.exit(0);
        }

        int answer = 0;
        while (true) {
            answer++;

            visited = new int[N][M];
            
            // 바깥 공기영역을 체크
            visited[0][0] = 1;
            dfs(0,0,1);

            // 치즈영역, 치즈내부영역을 체크
            for (int i=0; i<N; ++i) {
                for (int j=0; j<M; ++j) {
                    if (visited[i][j] == 0 && src_graph[i][j] == 1) { // 치즈영역
                        visited[i][j] = 2;
                        dfs(i, j, 2);
                    } else if (visited[i][j] == 0 && src_graph[i][j] == 0) { // 치즈내부영역
                        visited[i][j] = 3;
                        dfs(i, j, 3);
                    }
                }
            }

            dst_graph = new int[N][M];
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    dst_graph[i][j] = src_graph[i][j];
                }
            }

            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    boolean isBreak = false;
                    for (int k=0; k<4; ++k) {
                        int next_row = i + d_row[k];
                        int next_col = j + d_col[k];

                        if (src_graph[i][j] == 1 && next_row >= 0 && next_col >= 0 &&
                        next_row < N && next_col < M && src_graph[next_row][next_col] == 0 &&
                        visited[next_row][next_col] == 1) {
                            isBreak = true;
                        }
                    }
                    if (isBreak) {
                        dst_graph[i][j] = 0;
                    }
                }
            }


            boolean isEnd = true;
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (dst_graph[i][j] == 1) {
                        isEnd = false;
                    }
                }
            }

            // dst_graph 에 치즈가 없다? >> src_graph의 치즈의 갯수와 answer를 리턴
            if (isEnd) {

                int sum = 0;

                for (int i=0; i<N; ++i) {
                    for (int j = 0; j < M; ++j) {
                        if (src_graph[i][j] == 1) {
                            sum++;
                        }
                    }
                }

                System.out.println(answer);
                System.out.println(sum);
                System.exit(0);

            } else { // dst_graph 에 아직 치즈가 있다? >> src_graph에 dst_graph를 깊은 복사한다.
                for (int i=0; i<N; ++i) {
                    for (int j = 0; j < M; ++j) {
                        src_graph[i][j] = dst_graph[i][j];
                    }
                }
            }

        }


    }*/
    
    // #3020 개똥벌레 - 이분탐색
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] up = new int[N/2];
        int[] down = new int[N/2];

        for (int i=0; i<N; ++i) {
            if (i % 2 == 0) down[i/2] = Integer.parseInt(br.readLine());
            else up[i/2] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = N;
        int count = 0;
        for (int i=1; i<=H; ++i) {

            int walls = binarySearch(i, down) + binarySearch(H-i+1, up);

            if (min == walls) {
                count++;
                continue;
            }
            if (min > walls) {
                min = walls;
                count = 1;
            }

//            if (walls < min) {
//                min = walls;
//                count = 1;
//            } else if (walls == min) {
//                count++;
//            } else {
//                continue;
//            }

        }

        System.out.println(min + " " + count);

    }

    static int binarySearch(int h, int arr[]) {

        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {

            int mid = (lt + rt) / 2;

            if (h <= arr[mid]) {
                rt = mid;
            } else {
                lt = mid + 1;
            }

        }

        return arr.length - rt;

    }*/


    // #1759 암호 만들기 - 백트래킹
/*    static BufferedWriter bw;
    static int N, M;
    static char[] org;
    static List<Character> result;

    static void backTracking(int cur) throws IOException {

        if (result.size() == N) {
            int mom = 0;
            int child = 0;

            for (char c : result) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    mom ++;
                } else {
                    child ++;
                }
            }

            if (mom >= 1 && child >= 2) {
                for (char c : result) {
                    bw.write(String.valueOf(c));
                }
                bw.write("\n");
            }

        } else {

            for (int i=cur; i<M; ++i) {
                result.add(org[i]);
                backTracking(i+1);
                result.remove(result.size()-1);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        org = new char[M];
        result = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        for (int i=0; i<M; ++i) {
            org[i] = inputs[i].charAt(0);
        }

        Arrays.sort(org);

        backTracking(0);

        bw.flush();
        bw.close();
    }*/

    // #2458 키 순서 - 플로이드 와샬 ?왜
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=N; ++j) {
                graph[i][j] = 100000000;
            }
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        for (int k=1; k<=N; ++k) {
            for (int i=1; i<=N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (i == j) {
                        continue;
                    }
                    if (i == k || j == k) {
                        continue;
                    }

                    if (graph[i][j] == 100000000 && graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }

                    if (graph[i][j] == 100000000 && graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                    }

                }
            }
        }

        int answer = N;
        for (int i=1; i<=N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (i!=j && graph[i][j] == 100000000) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }*/

    // #1922 네트워크 연결 - 최소신장트리
/*    static class Edge implements Comparable<Edge> {
        int v;
        int wei;
        Edge (int v, int wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        while (M --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));

        long answer = 0L;
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;
            answer += cur.wei;

            for (Edge next : graph[cur.v]) {
                q.offer(next);
            }
        }

        System.out.println(answer);

    }*/

    // #1744 수 묶기 - 그리디
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>();

        int answer = 0;
        while (N --> 0) {
            int in = Integer.parseInt(br.readLine());
            if (in == 1) {
                answer++;
            } else if (in > 1) {  // 양수
                positiveQ.offer(in);
            } else { // 0 or 음수
                negativeQ.offer(in);
            }
        }

        while (positiveQ.size() >= 2) {
            int a = positiveQ.poll();
            int b = positiveQ.poll();
            answer += a * b;
        }

        while (negativeQ.size() >= 2) {
            int a = negativeQ.poll();
            int b = negativeQ.poll();
            answer += a * b;
        }

        while (!positiveQ.isEmpty()) {
            answer += positiveQ.poll();
        }
        while (!negativeQ.isEmpty()) {
            answer += negativeQ.poll();
        }

        System.out.println(answer);

    }*/

    // ? 그리디 우선순위큐 문제
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();

        while (N --> 0) {
            q.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            answer += a+b;
            q.offer(a+b);
        }

        System.out.println(answer);

    }*/
    
    // #1339 단어 수학 - 그리디 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A:0, B:1, C:2 ...
        int[] arr = new int[26];

        int N = Integer.parseInt(br.readLine());
        while (N --> 0) {
            String input = br.readLine();
            int pos = 1;
            for (int i=input.length()-1; i>=0; --i) {
                int idx = input.charAt(i)-'A';
                int value = pos;
                arr[idx] += value;
                pos *= 10;
            }
        }

        Arrays.sort(arr);

        int answer = 0;
        int idx = 25;
        for (int i=9; i>=0; i--) {
            answer += arr[idx--] * i;
        }

        System.out.println(answer);
    }*/

    // #1339 단어 수학 - 백트래킹 완전탐색 풀이
/*    static int[] result;
    static boolean[] visited;
    static List<String> inputs;
    static Map<Character, Integer> map;
    static int max = -1;

    static void backTracking(int depth) {
        if (depth == result.length) {
            // 계산한다.
            int sum = 0;
            for (String s : inputs) {

                int pos = 1;
                for (int i=s.length()-1; i>=0; i--) {
                    sum += result[map.get(s.charAt(i))] * pos;
                    pos *= 10;
                }

            }
            max = Math.max(max, sum);
        } else {
            for (int i=0; i<10; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = i;
                    backTracking(depth+1);
                    visited[i] = false;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inputs = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for (int i=0; i<N; ++i) {
            inputs.add(br.readLine());
        }

        for (String s : inputs) {
            for (char c : s.toCharArray()) {
                set.add(c);
            }
        }

        result = new int[set.size()];
        visited = new boolean[10];
        map = new HashMap<>();

        int idx = 0;
        for (Character c : set) {
            map.put(c, idx);
            idx++;
        }

        // A만 있을때, result = {0}, {1}, ....
        // A,B 있을때, result = {0,1}, {0,2}, {0,3} ... {8,9}
        backTracking(0);

        System.out.println(max);
    }*/

    // #1261 알고스팟 - BFS+우선순위 큐
/*    static class Edge implements Comparable<Edge>{
        int row;
        int col;
        int cnt;
        Edge (int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i=0; i<N; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=0; j<M; ++j) {
                graph[i][j] = Integer.parseInt(String.valueOf(inputs[j]));
            }
        }

        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, -1, 0, 1};

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(0,0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Edge cur = q.poll();

            if (cur.row == N-1 && cur.col == M-1) {
                System.out.println(cur.cnt);
                System.exit(0);
            }

            for (int i=0; i<4; ++i) {
                int next_row = cur.row + d_row[i];
                int next_col = cur.col + d_col[i];

                if (next_row < 0 || next_col < 0 || next_row >= N || next_col >= M) {
                    continue;
                } else {
                    if (graph[next_row][next_col] == 0 && !visited[next_row][next_col]) {
                        visited[next_row][next_col] = true;
                        q.offer(new Edge(next_row, next_col, cur.cnt));
                    }

                    if (graph[next_row][next_col] == 1 && !visited[next_row][next_col]) {
                        visited[next_row][next_col] = true;
                        q.offer(new Edge(next_row, next_col, cur.cnt + 1));
                    }
                }
            }

        }


    }*/

    // #1261 알고스팟 - DP
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][M+1];
        int[][] dp = new int[N+2][M+2];

        for (int i=1; i<=N; ++i) {
            char[] inputs = br.readLine().toCharArray();
            for (int j=1; j<=M; ++j) {
                graph[i][j] = Integer.parseInt(String.valueOf(inputs[j-1]));
            }
        }

        for (int i=0; i<=N+1; ++i) {
            for (int j=0; j<=M+1; ++j) {
                dp[i][j] = 50000;
            }
        }

        dp[1][1] = 0;

        int tmp = 1000;
        while (tmp --> 0) {
            for (int i=1; i<=N; ++i) {
                for (int j=1; j<=M; ++j) {

                    int min1 = Math.min(dp[i-1][j], dp[i][j-1]);
                    int min2 = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));

                    if (graph[i][j] == 0) {
                        dp[i][j] = Math.min(min1, min2);
                    } else {
                        dp[i][j] = Math.min(min1, min2) + 1;
                    }

                }
            }
        }

        System.out.println(dp[N][M]);

    }*/

    // #1027 고층 건물
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; ++i) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        int[] dis = new int[N];

        for (int i=0; i<N; ++i) {

            double cur = arr[i];

            int cnt = 0;
            // 왼쪽으로 탐색
            for (int j=i-1; j>=0; j--) {
                double target = arr[j];

                double dydx = (target - cur) / (j - i);

                boolean isPossible = true;
                int idx = 0;
                for (int k=j+1; k<=i-1; ++k) {
                    idx++;
                    if (arr[k] >= target + dydx * idx) {
                        isPossible = false;
                    }
                }
                if (isPossible) {
                    cnt++;
                }
            }

            for (int j=i+1; j<N; ++j) {
                double target = arr[j];

                double dydx = (cur - target) / (i - j);

                boolean isPossible = true;
                int idx = 0;
                for (int k=i+1; k<=j-1; ++k) {
                    idx++;
                    if (arr[k] >= cur + dydx * idx) {
                        isPossible = false;
                    }
                }
                if (isPossible) {
                    cnt++;
                }
            }

            dis[i] = cnt;

        }

        int answer = Arrays.stream(dis).max().getAsInt();
        System.out.println(answer);

    }*/

    // #10159 저울
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N+1][N+1];
        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=N; ++j) {
                graph[i][j] = 100000000;
            }
        }

        int M = Integer.parseInt(br.readLine());

        while (M --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        for (int k=1; k<=N; ++k) {
            for (int i=1; i<=N; ++i) {
                for (int j=1; j<=N; ++j) {
                    if (i==j || i==k || j==k) continue;

                    if (graph[i][j]==100000000 && graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }

                    if (graph[i][j]==100000000 && graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                    }

                }
            }
        }

        for (int i=1; i<=N; ++i) {
            int sum = N-1;
            for (int j = 1; j <= N; ++j) {
                if (graph[i][j] != 100000000 && i!= j) sum -= 1;
            }
            System.out.println(sum);
        }

    }*/

    // DFS로 넓이 구하기 (실버1)
/*    static int[][] graph;
    static boolean[][] visited;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};

    static int dfs(int row, int col) {

        int size = 1;

        for (int i=0; i<4; ++i) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];
            if (next_row >= 0 && next_col >= 0 && next_row < graph.length && next_col < graph[0].length && !visited[next_row][next_col] && graph[next_row][next_col] == 1) {
                visited[next_row][next_col] = true;
                size += dfs(next_row, next_col);
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = -1;
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited[i][j] && graph[i][j]==1) {
                    cnt++;
                    visited[i][j] = true;
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max == -1 ? 0 : max);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=N; i<N+M; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (Integer i : arr) {
            bw.write(i+" ");
        }

        bw.flush();
        bw.close();
    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr_a = new int[N];
        Integer[] arr_b = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr_a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr_b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_a);
        Arrays.sort(arr_b, Collections.reverseOrder());

        int answer = 0;
        for (int i=0; i<N; ++i) {
            answer += arr_a[i] * arr_b[i];
        }

        System.out.println(answer);


    }*/

    // DP
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + graph[i][j];
            }
        }

        System.out.println(dp[N][M]);

    }*/

    // #6497 - 전력난 (최소신장트리)
/*    static class Edge implements Comparable<Edge> {
        int v;
        int wei;
        Edge (int v, int wei) {
            this.v = v;
            this.wei = wei;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);

            // 0 0  이면 종료
            if (N == 0 && M == 0) {
                break;
            }

            ArrayList<Edge>[] graph = new ArrayList[N];
            for (int i=0; i<N; ++i) {
                graph[i] = new ArrayList<>();
            }

            int total = 0;
            while (M --> 0) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int c = Integer.parseInt(inputs[2]);

                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));

                total += c;
            }

            // 프림 수행
            int min_mst = 0;

            boolean[] visited = new boolean[N];
            PriorityQueue<Edge> q = new PriorityQueue<>();
            q.offer(new Edge(0, 0));

            while (!q.isEmpty()) {
                Edge cur = q.poll();

                if (visited[cur.v]) {
                    continue;
                }
                visited[cur.v] = true;
                min_mst += cur.wei;

                for (Edge next : graph[cur.v]) {
                    q.offer(next);
                }
            }

            bw.write(total - min_mst+"\n");
        }

        bw.flush();
        bw.close();

    }*/


    // #1956 - 운동 (플로이드 와샬)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] graph = new long[N+1][N+1];

        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=N; ++j) {
                graph[i][j] = 10000000000L;
            }
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for (int k=1; k<=N; ++k) {
            for (int i=1; i<=N; ++i) {
                for (int j=1; j<=N; ++j) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        long min = 10000000000L;
        for (int i=1; i<=N; ++i) {
            min = Math.min(min, graph[i][i]);
        }

        System.out.println(min == 10000000000L ? -1 : min);

    }*/

    // 11657 - 타임머신
/*    static class Edge implements Comparable<Edge> {
        int v;
        int wei;
        Edge (int v, int wei) {
            this.v = v;
            this.wei = wei;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));

        }

        // 벨만포드 수행
        boolean is_minus_cycle = false;
        long[] dis = new long[N+1];
        Arrays.fill(dis, 1000000000);
        dis[1] = 0;

        for (int i=1; i<N; ++i) {
            for (int j=1; j< graph.length; ++j) {
                for (Edge next : graph[j]) {
                    if (dis[j] != 1000000000 && dis[j] + next.wei < dis[next.v]) {
                        dis[next.v] = dis[j] + next.wei;
                    }
                }
            }
        }

        for (int j=1; j< graph.length; ++j) {
            for (Edge next : graph[j]) {
                if (dis[j] != 1000000000 && dis[j] + next.wei < dis[next.v]) {
                    is_minus_cycle = true;
                }
            }
        }

        //if (graph[1].size() != 0 && is_minus_cycle) {
        if (is_minus_cycle) {
            System.out.println(-1);
            System.exit(0);
        } else {
            for (int i=2; i<=N; ++i) {
                if (dis[i] == 1000000000) {
                    bw.write("-1\n");
                    //System.out.println(-1);
                } else {
                    bw.write(dis[i]+"\n");
                    //System.out.println(dis[i]);
                }
            }
        }
        bw.flush();
        bw.close();

    }*/


    // 용액 양산문제
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length-1;

        int min = arr[lt] + arr[rt];
        int min_lt = lt;
        int min_rt = rt;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                min_lt = lt;
                min_rt = rt;
            }

            if (sum > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        System.out.println(arr[min_lt] + " " + arr[min_rt]);

    }*/

    // ACM크래프트 - 실패
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] times = new int[N+1];  // 10, 1, 100, 10

            st = new StringTokenizer(br.readLine(), " ");
            for (int i=1; i<=N; ++i) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] graph = new ArrayList[N+1];
            for (int i=0; i<=N; ++i) {
                graph[i] = new ArrayList<>();
            }
            int[] inDegree = new int[N+1];

            while (K --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                inDegree[b]++;
                graph[a].add(b);
            }

            int W = Integer.parseInt(br.readLine());

            int answer = Integer.MAX_VALUE;
            for (int i=1; i<=N; ++i) {
                // 진입차수가 0인 곳에서만 탐색을 할꺼기 때문
                if (inDegree[i] != 0) {
                    continue;
                }

                int[] inDegreeTmp = new int[N+1];
                for (int j=0; j<=N; ++j) {
                    inDegreeTmp[j] = inDegree[j];
                }

                int cur = i;

                int[] curtimes = new int[1001];
                Arrays.fill(curtimes, 0);

                Queue<Integer> q = new LinkedList<>();
                q.offer(cur);

                int depth = 1;

                boolean beAnswer = false;

                lable:
                while (!q.isEmpty()) {

                    int len = q.size();
                    while (len --> 0) {
                        int cur_build = q.poll();
                        if (cur_build == W) {
                            curtimes[depth] = times[cur_build];
                            beAnswer = true;
                            break lable;
                        }
                        curtimes[depth] = Math.max(curtimes[depth], times[cur_build]);

                        for (Integer next : graph[cur_build]) {
                            inDegreeTmp[next]--;
                            if (inDegreeTmp[next] == 0) {
                                q.offer(next);
                            }
                        }
                    }
                    depth++;
                }

                if (beAnswer) {
                    int sum = 0;
                    for (int j=1; j<=depth; ++j) {
                        sum += curtimes[j];
                    }
                    answer = Math.min(answer, sum);

//                    for (Integer a : curtimes) {
//                        System.out.print(a + " ");
//                    }
//                    System.out.println();
//                    System.out.println("i = " + i + " ," + depth + " = " + depth);

                }
            }

            System.out.println(answer);

        }

    }*/

    // #10775 - 공항 (유니온파인드)
/*    static int[] parent;

    static int find(int a) {
        if (a == parent[a]) {
            return parent[a];
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {

        // * 작은 값을 루트노드로 설정하는 방법
*//*        int parentA = find(a);
        int parentB = find(b);

        if (parentA > parentB) {
            parent[parentA] = parent[parentB];
        } else {
            parent[parentB] = parent[parentA];
        }*//*
        
        // * 일반적인 방법
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentA] = parentB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for (int i=0; i<=G; ++i) {
            parent[i] = i;
        }

        int answer = 0;
        while (P --> 0) {
            int a = find(Integer.parseInt(br.readLine()));

            if (a == 0) {
                break;
            }

            answer++;
            union(a, a-1);
        }

        System.out.println(answer);

    }*/

    // #1766 - 문제집 (위상정렬)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            inDegree[b]++;
            graph[a].add(b);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=1; i<inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        for (int i=1; i<=N; ++i) {

            int cur = q.poll();
            System.out.print(cur + " ");

            for (Integer next : graph[cur]) {

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; ++i) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; ++i) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum1 = new long[n*(n+1)/2];

        int idx = 0;
        for (int i=0; i<arr1.length; ++i) {  // 1개씩, 2개씩, 2개씩... 더하겠다.
            for (int j=0; j<arr1.length-i; ++j) {
                int sum = 0;
                for (int k=j; k<=j+i; ++k) {
                    sum += arr1[k];
                }
                sum1[idx] = sum;
                idx++;
            }
        }


        long[] sum2 = new long[m*(m+1)/2];

        idx = 0;
        for (int i=0; i<arr2.length; ++i) {  // 1개씩, 2개씩, 2개씩... 더하겠다.
            for (int j=0; j<arr2.length-i; ++j) {
                int sum = 0;
                for (int k=j; k<=j+i; ++k) {
                    sum += arr2[k];
                }
                sum2[idx] = sum;
                idx++;
            }
        }

        TreeSet<Long> tset1 = new TreeSet<>();
        TreeSet<Long> tset2 = new TreeSet<>();

        Map<Long, Long> map1 = new HashMap();
        Map<Long, Long> map2 = new HashMap();

        for (Long i : sum1) {
            tset1.add(i);
            map1.put(i, map1.getOrDefault(i, 0L)+1L);
        }

        for (Long i : sum2) {
            tset2.add(i);
            map2.put(i, map2.getOrDefault(i, 0L)+1L);
        }

        sum1 = new long[tset1.size()];
        sum2 = new long[tset2.size()];

        idx = 0;
        for (Long i : tset1) {
            sum1[idx] = i;
            idx++;
        }

        idx = 0;
        for (Long i : tset2) {
            sum2[idx] = i;
            idx++;
        }

        long answer = 0L;

        int lt = 0;
        int rt = sum2.length-1;

        while (lt < sum1.length && rt > -1) {
            long sum = sum1[lt] + sum2[rt];

            if (sum == T) {
                answer += map1.get(sum1[lt]) * map2.get(sum2[rt]);
            }

            if (sum > T) {
                rt--;
            } else {
                lt++;
            }

        }

        System.out.println(answer);

    }*/

    // #16724 - 피리 부는 사나이
/*    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public boolean equals(Object o) {
            Point obj = (Point) o;
            return obj.row == this.row && obj.col == this.col;
        }

        @Override
        public int hashCode() {
            return (row+""+col).hashCode();
        }
    }
    static Point[][] parent;
    static Point find(Point p) {
        if (parent[p.row][p.col].equals(p)) {
            return parent[p.row][p.col];
        }
        return parent[p.row][p.col] = find(parent[p.row][p.col]);
    }

    static void union(Point a, Point b) {
        Point parentB = find(b);
        parent[parentB.row][parentB.col] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        parent = new Point[N][M];
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                parent[i][j] = new Point(i, j);
            }
        }

        for (int i=0; i<N; ++i) {
            graph[i] = br.readLine().toCharArray();
        }

        //for (int z=0; z<2; ++z) {

        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                int next_row = i;
                int next_col = j;
                if (graph[i][j] == 'U') {
                    next_row--;
                } else if (graph[i][j] == 'D') {
                    next_row++;
                } else if (graph[i][j] == 'L') {
                    next_col--;
                } else if (graph[i][j] == 'R') {
                    next_col++;
                }

                if (next_row >= 0 && next_row < N && next_col >= 0 && next_col < M) {

                    if (find(new Point(i, j)) != find(new Point(next_row, next_col))) {
                        union(new Point(i, j), new Point(next_row, next_col));
                    }

                }
            }
        }

        //}

        // 모든 노드의 부모를 최상위 노드로 바꿔준다.
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                find(new Point(i, j));
            }
        }

        Set<Point> set = new HashSet<>();
        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                set.add(new Point(parent[i][j].row,parent[i][j].col));
            }
        }
        System.out.println(set.size());

    }*/

    // #27172 - 수 나누기 게임
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = -1;

        Set<Integer> set = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
            set.add(n);
            order.add(n);
        }

        int[] arr = new int[max+1];

        for (int i=min; i<=max; ++i) {

            int n = i;

            // set에 없는 정수라면 PASS한다.
            if (!set.contains(n)) {
                continue;
            }

            for (int j=n; j<=max; j += n) {
                if (set.contains(j)) {
                    arr[n]++;
                    arr[j]--;
                }
            }

        }

        for (Integer i : order) {
            System.out.print(arr[i]+" ");
        }

    }*/

    // #4386 - 별자리 만들기
/*    static class Edge implements Comparable<Edge> {
        int v;
        double wei;
        Edge (int v, double wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            if (this.wei < o.wei) {
                return -1;
            } else if (this.wei == o.wei) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[][] point = new double[N+1][2];

        for (int i=1; i<=N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            point[i][0] = a;
            point[i][1] = b;
        }

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=N && i!=j; ++j) {
                double dis = Math.sqrt(Math.pow(Math.abs(point[i][0]-point[j][0]), 2)
                        + Math.pow(Math.abs(point[i][1]-point[j][1]), 2));  // 루트 (a^2 + b^2)
                graph[i].add(new Edge(j, dis));
                graph[j].add(new Edge(i, dis));
            }
        }

        boolean[] visited = new boolean[N+1];

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));

        double answer = 0.0d;
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;
            answer += cur.wei;

            for (Edge next : graph[cur.v]) {
                q.offer(next);
            }
        }

        System.out.println(String.format("%.2f", answer));

    }*/

    // RGB거리 2
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int answer = Integer.MAX_VALUE;

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<3; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];

        // 빨간색으로 먼저 칠했을때
        dp[0][0] = arr[0][0];
        dp[0][1] = 1001 * 1001;
        dp[0][2] = 1001 * 1001;

        for (int i=1; i<N; ++i) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        for (int i=0; i<3; ++i) {
            if (i != 0) {
                answer = Math.min(answer, dp[N-1][i]);
            }
        }


        dp = new int[N][N];

        // 초록색으로 먼저 칠했을때
        dp[0][0] = 1001 * 1001;
        dp[0][1] = arr[0][1];
        dp[0][2] = 1001 * 1001;

        for (int i=1; i<N; ++i) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        for (int i=0; i<3; ++i) {
            if (i != 1) {
                answer = Math.min(answer, dp[N-1][i]);
            }
        }

        // 파란색으로 먼저 칠했을때
        dp[0][0] = 1001 * 1001;
        dp[0][1] = 1001 * 1001;
        dp[0][2] = arr[0][2];

        for (int i=1; i<N; ++i) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        for (int i=0; i<3; ++i) {
            if (i != 2) {
                answer = Math.min(answer, dp[N-1][i]);
            }
        }

        System.out.println(answer);

    }*/

    // #1647 도시 분할 계획 - MST
/*    static class Edge implements Comparable<Edge>{
        int v;
        int wei;
        Edge (int v, int wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        boolean[] visited = new boolean[N+1];

        int answer = 0;
        int max = -1;
        for (int i=1; i<=N; ++i) {

            PriorityQueue<Edge> q = new PriorityQueue<>();
            q.offer(new Edge(i, 0));

            while (!q.isEmpty()) {

                Edge cur = q.poll();
                if (visited[cur.v]) {
                    continue;
                }
                visited[cur.v] = true;
                answer += cur.wei;
                max = Math.max(max, cur.wei);

                for (Edge next : graph[cur.v]) {
                    q.offer(next);
                }

            }
        }

        System.out.println(answer - max);

    }*/

    // #2473 세 용액
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = Long.MAX_VALUE;
        long a0 = 0;
        long a1 = 0;
        long a2 = 0;

        for (int i=0; i<N; ++i) {
            int lt = i+1;
            int rt = N-1;
            while (lt < rt) {
                if (Math.abs(arr[lt] + arr[i] + arr[rt]) < answer) {
                    answer = Math.abs(arr[lt] + arr[i] + arr[rt]);
                    a0 = arr[i];
                    a1 = arr[lt];
                    a2 = arr[rt];
                }

                long move_lt = arr[i] + arr[lt+1] + arr[rt];
                long move_rt = arr[i] + arr[lt] + arr[rt-1];

                if (Math.abs(move_lt) < Math.abs(move_rt)) {
                    lt++;
                } else {
                    rt--;
                }

            }
        }

        System.out.println(a0 + " " + a1 + " " + a2);

    }*/

    // 평범한 배낭
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] wei = new int[N];
        int[] value = new int[N];

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            wei[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // i = 물건의 순서 , j = 무게
        int[][] dp = new int[N][K+1];

        // 첫번째 물건에 대한 dp배열 생성
        for (int i=0; i<=K; ++i) {
            if (wei[0] <= i) {
                dp[0][i] = value[0];
            }
        }

        for (int i=1; i<N; ++i) {
            for (int j=0; j<=K; ++j) {
                // 현재 아이템을 가방에 포함시킬 수 있을때
                if (wei[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j-wei[i]]);
                } else {  // 현재 아이템을 가방에 포함시킬 수 없을때
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][K]);

    }*/

    // #1021 회전하는 큐
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; ++i) {
            q.offer(i);
        }

        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        while (M --> 0) {
            int value = Integer.parseInt(st.nextToken());

            int pos = 0;
            for (Integer i : q) {
                pos++;
                if (value == i) {
                    break;
                }
            }

            // 타겟이 왼쪽에 있는 경우
            if ((q.size() % 2 == 0 && pos <= q.size() / 2) ||          // 큐가 짝수개일땐 8 -> 4
                    (q.size() % 2 == 1 && pos <= q.size() / 2 + 1) ) { // 큐가 홀수개일땐 9 -> 4
                while (q.peekFirst() != value) {
                    q.offerLast(q.pollFirst()); // 왼쪽에서 오른쪽으로 옮김
                    answer++;
                }
                q.poll();
            } else {  // 타겟이 오른쪽에 있는 경우
                while (q.peekFirst() != value) {
                    q.offerFirst(q.pollLast());
                    answer++;
                }
                q.poll();
            }

        }
        System.out.println(answer);

    }*/

    // #7579 앱
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        int[] costs = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            memories[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][10001];
        
        // 첫번째 앱의 dp배열을 생성
        for (int i=0; i<=10000; ++i) {
            if (costs[0] <= i) {
                dp[0][i] = memories[0];
            }
        }

        for (int i=1; i<N; ++i) {
            for (int j=0; j<=10000; ++j) {

                *//** 현재 앱의 코스트가 기준 코스트보다 작다?
                 * >> 현재 앱을 포함시킬수도 있고, 안할수도 있다. *//*
                if (costs[i] <= j) {

                    dp[i][j] = Math.max(
                            dp[i-1][j],    // 포함시키지 않은 경우 >> 이전 앱만으로 확보 가능한 메모리를 그대로 가져감
                            memories[i] + dp[i-1][j-costs[i]] // 포함시키는 경우 >> 현재앱의 메모리 + 기준코스트에서 현재 앱의 코스트를 뺀 코스트로 확보 가능한 최대 메모리
                    );

                } else {  *//** 현재 앱의 코스트가 기준 코스트보다 크다?
                              >> 포함할 수 없으므로, 이전앱만으로 확보 가능한 메모리를 그대로 가져간다. *//*
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<N; ++i) {
            for (int j=0; j<10001; ++j) {
                if (dp[i][j] >= M) {
                    answer = Math.min(answer , j);
                }
            }
        }

        System.out.println(answer);
    }*/

    // 수의 합? 완전탐색
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i=0; i<N; ++i) {
            int cur = arr[i];
            if (cur == M) {
                answer ++;
                continue;
            } else {
                for (int j=i-1; j>=0; --j) {
                    cur += arr[j];
                    if (cur == M) {
                        answer ++;
                        continue;
                    }
                }
            }
        }

        System.out.println(answer);

    }*/

    // 어린왕자
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(br.readLine());
            int answer = 0;
            while (cnt --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int center_x = Integer.parseInt(st.nextToken());
                int center_y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                double start_to_center =
                        Math.sqrt(Math.pow(Math.abs(start_x - center_x), 2) + Math.pow(Math.abs(start_y - center_y), 2));
                double end_to_center =
                        Math.sqrt(Math.pow(Math.abs(end_x - center_x), 2) + Math.pow(Math.abs(end_y - center_y), 2));

                if (start_to_center <= r && end_to_center <= r) {
                    // 아무것도 안함
                } else if (start_to_center <= r) {
                    answer ++;
                } else if (end_to_center <= r) {
                    answer ++;
                }
            }
            System.out.println(answer);

        }

    }*/

    // #2623 음악프로그램 - 위상정렬 (사이클 여부까지 판단)
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[cnt];
            for (int i=0; i<cnt; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<cnt; ++i) {
                graph[arr[i-1]].add(arr[i]);
                inDegree[arr[i]]++;
            }
        }

        // 위상정렬 시작
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=N; ++i) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        for (int i=1; i<=N; ++i) {

            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }

            int cur = q.poll();
            bw.write(cur+"\n");

            for (int j=0; j<graph[cur].size(); ++j) {
                int next = graph[cur].get(j);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }

        }

        bw.flush();
        bw.close();

    }*/

/*    static void recursion(int n, int depth) {
        String preFix = "";
        for (int i=0; i<depth; ++i) {
            preFix += "____";
        }
        System.out.println(preFix+"\"재귀함수가 뭔가요?\"");

        if (n == 0) {
            System.out.println(preFix+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            System.out.println(preFix+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(preFix+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(preFix+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            recursion(n-1, depth+1);
        }

        System.out.println(preFix+"라고 답변하였지.");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(N, 0);
    }*/

    // 촌수 구하기
/*    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void dfs(int cur, int target, int depth) {
        if (cur == target) {
            System.out.println(depth);
            System.exit(0);
        } else {
            for (Integer next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dfs(next, target, depth+1);
                    visited[next] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int human1 = Integer.parseInt(st.nextToken());
        int human2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        while (m --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited[human1] = true;
        dfs(human1, human2, 0);

        System.out.println(-1);

    }*/

    // 색종이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] paper = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i=a; i<a+10; ++i) {
                for (int j=b; j<b+10; ++j) {
                    paper[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i=0; i<101; ++i) {
            for (int j=0; j<101; ++j) {
                answer += paper[i][j] ? 1 : 0;
            }
        }
        System.out.println(answer);

    }*/

    // 위상정렬문제
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] inDegree = new int[N+1];

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int small = Integer.parseInt(st.nextToken());
            int large = Integer.parseInt(st.nextToken());

            graph[small].add(large);
            inDegree[large]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur+" ");

            for (Integer next : graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        bw.flush();
        bw.close();

    }*/

    // #1197 최소 스패닝 트리
/*    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=0; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; ++i) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            long c = Integer.parseInt(inputs[2]);

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        long answer = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            // 안되면 이 부분을 !visited로 바꾸자
            if (visited[cur.v]) {
                continue;
            }
            answer += cur.wei;
            visited[cur.v] = true;

            for (Edge next : graph[cur.v]) {
                q.offer(next);
            }
        }

        System.out.println(answer);

    }

    static class Edge implements Comparable<Edge> {
        int v;
        long wei;
        Edge(int v, long wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            if (this.wei > o.wei) {
                return 1;
            } else if (this.wei == o.wei) {
                return 0;
            } else {
                return -1;
            }
        }
    }*/

    // LCS 골드4
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];
        StringBuilder[][] answer = new StringBuilder[str1.length+1][str2.length+1];

        for (int i=0; i< answer.length; ++i) {
            Arrays.fill(answer[i], new StringBuilder(""));
        }

        for (int i=1; i<=str1.length; ++i) {
            for (int j=1; j<=str2.length; ++j) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    answer[i][j] = answer[i-1][j-1].append(str2[j-1]);
                } else {
                    if (dp[i][j-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i][j-1];
                        answer[i][j] = answer[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                        answer[i][j] = answer[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        System.out.println(answer[str1.length][str2.length]);

    }*/

    // #10942 펠린드롬?
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][N+1];  // dp[start][end] : stard 부터 end 까지가 펠린드롬인지 아닌지.

        for (int i=1; i<=N; ++i) {
            dp[i][i] = true;
        }
        for (int i=2; i<=N; ++i) {
            if (arr[i] == arr[i-1]) {
                dp[i-1][i] = true;
            }
        }

        // i가 3일때 ==> 1,2,3을 비교해야 함.                                                     ==> j는 1부터     1(i-3+1) 까지     i==j 인지 확인 + (j+1)~(i-1)이 펠린드롬인지 확인.
        // i가 4일때 ==> 1,2,3,4 / 2,3,4 를 비교해야 함.                                          ==> j는 1부터     2(i-3+1) 까지     i==j 인지 확인 + (j+1)~(i-1)이 펠린드롬인지 확인.
        // i가 5일때 ==> 1,2,3,4,5 / 2,3,4,5 / 3,4,5 를 비교해야 함.                              ==> j는 1부터     3(i-3+1) 까지     i==j 인지 확인 + (j+1)~(i-1)이 펠린드롬인지 확인.
        // i가 6일때 ==> 1,2,3,4,5,6 / 2,3,4,5,6 / 3,4,5,6 / 4,5,6 를 비교해야 함.                ==> j는 1부터     4(i-3+1) 까지     i==j 인지 확인 + (j+1)~(i-1)이 펠린드롬인지 확인.
        // i가 7일때 ==> 1,2,3,4,5,6,7 / 2,3,4,5,6,7 / 3,4,5,6,7 / 4,5,6,7 / 5,6,7 를 비교해야 함.==> j는 1부터     5(i-3+1) 까지     i==j 인지 확인 + (j+1)~(i-1)이 펠린드롬인지 확인.
        for (int i=3; i<=N; ++i) {
            for (int j=1; j<=i-2; ++j) {
                if (arr[i] == arr[j] && dp[j+1][i-1]) {
                    dp[j][i] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dp[a][b]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();

    }*/

    // 스도쿠
/*    static int[][] arr;

    static void backTracking(int row, int col) {

        if (row == 9) {
            // 배열 출력하고 종료
            for (int i=0; i<9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (col == 9) {
            backTracking(row+1, 0);
            return ;
        }

        if (arr[row][col] == 0) {
            for (int i=1; i<=9; ++i) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    backTracking(row, col+1);
                }
            }

            arr[row][col] = 0;
            return ;
        }

        backTracking(row, col+1);

    }

    static boolean isPossible(int row, int col, int value) {
        boolean isPosb = true;
        for (int i=0; i<9; ++i) {
            if (arr[row][i] == value) isPosb = false;
            if (arr[i][col] == value) isPosb = false;
        }

        int start_row = 0;
        int end_row = 0;
        int start_col = 0;
        int end_col = 0;

        if (row >= 0 && row <= 2) {
            start_row = 0;
            end_row = 2;
        } else if (row >= 3 && row <= 5) {
            start_row = 3;
            end_row = 5;
        } else {
            start_row = 6;
            end_row = 8;
        }

        if (col >= 0 && col <= 2) {
            start_col = 0;
            end_col = 2;
        } else if (col >= 3 && col <= 5) {
            start_col = 3;
            end_col = 5;
        } else {
            start_col = 6;
            end_col = 8;
        }

        for (int i=start_row; i<=end_row; ++i) {
            for (int j=start_col; j<=end_col; ++j) {
                if (arr[i][j] == value) {
                    isPosb = false;
                }
            }
        }

        return isPosb;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];

        for (int i=0; i<9; ++i) {
            String in = br.readLine();
            for (int j=0; j<9; ++j) {
                arr[i][j] = Integer.parseInt(String.valueOf(in.charAt(j)));
            }
        }

        backTracking(0, 0);

    }*/

    // #2467 용액
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = N-1;
        int min = arr[lt] + arr[rt];
        int min_a = arr[lt];
        int min_b = arr[rt];

        while (lt < rt) {

            //System.out.println("arr[lt], arr[rt] = " + arr[lt]+ ", " + arr[rt]);
            if (Math.abs(arr[lt] + arr[rt]) <= Math.abs(min)) {
                min = arr[lt] + arr[rt];
                min_a = arr[lt];
                min_b = arr[rt];
            }

            int lt_move = Math.abs(arr[lt+1] + arr[rt]);
            int rt_move = Math.abs(arr[lt] + arr[rt-1]);

            if (lt_move < rt_move) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(min_a + " " + min_b);

    }*/

    // #투포인터 부분합
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;

        int cur_sum = arr[0];
        int cur_len = 1;
        int min_len = Integer.MAX_VALUE;

        while (lt <= rt) {
            //System.out.println("lt, rt, cur_len, cur_sum = " + lt + ", " + rt + ", " + cur_len + ", " + cur_sum);

            if (cur_sum >= S) {  // lt를 오른쪽으로 보낼거임
                min_len = Math.min(min_len, cur_len);

                cur_len--;
                cur_sum -= arr[lt];
                lt++;

            } else {  // rt를 오른쪽으로 보낼거임
                rt++;
                if (rt == N) {
                    break;
                }
                cur_len ++;
                cur_sum += arr[rt];
            }
        }

        System.out.println(min_len != Integer.MAX_VALUE ? min_len : 0);

    }*/

    // #20040 사이클 게임
/*    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) {
            return parent[a];
        }
        
        // ★경로 압축 필수★
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            return false;
        }

        // 작은 수를 가지는 점을 무조건 루트 노드로 설정한다.
        if (parentA > parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        parent = new int[n];
        for (int i=0; i<n; ++i) {
            parent[i] = i;
        }

        for (int i=1; i<=m; ++i) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            if (!union(a, b)) {
                System.out.println(i);
                System.exit(0);
            }
        }

        System.out.println(0);

    }*/

    // 다각형의 넓이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] xArr = new long[N+1];
        long[] yArr = new long[N+1];
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }
        xArr[N] = xArr[0];
        yArr[N] = yArr[0];
        long x = 0;
        long y = 0;
        for (int i=1; i<=N; ++i) {
            x += yArr[i-1] * xArr[i];
            y += xArr[i-1] * yArr[i];
        }

        System.out.println(String.format("%.1f", Math.abs(x-y) / 2D));

    }*/

    // 문자열 폭발
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        char[] regex = br.readLine().toCharArray();
        int regex_size = regex.length;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<line.length; ++i) {
            stack.push(line[i]);

            if (stack.size() >= regex_size) {
                boolean bomb = true;
                for (int j=0; j<regex_size; ++j) {
                    if (stack.get(stack.size()-1-j) != regex[regex_size-1-j]) {
                        bomb = false;
                    }
                }

                if (bomb) {
                    for (int j=0; j<regex_size; ++j) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (Character c : stack) {
                bw.write(c);
            }
        }

        bw.flush();
        bw.close();

    }*/

/*    static class Edge implements Comparable<Edge>{
        int v;
        int wei;
        Edge(int v, int wei) {
            this.v = v;
            this.wei = wei;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 수행
        int[] dis = new int[n+1];
        int[] before_v = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        Arrays.fill(dis, 987654321);
        dis[start] = 0;
        q.offer(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;

            for (Edge next : graph[cur.v]) {
                if (dis[next.v] > dis[cur.v] + next.wei) {
                    dis[next.v] = dis[cur.v] + next.wei;
                    before_v[next.v] = cur.v;
                    q.offer(new Edge(next.v, dis[next.v]));
                }
            }
        }
        System.out.println(dis[end]);

        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (end == start) {
                stack.push(end);
                break;
            } else {
                stack.push(end);
                end = before_v[end];
            }
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+ " ");
        }

    }*/


/*    static BufferedWriter bw;
    static int[] left_child;
    static int[] right_child;

    static void preOrder(int n, int cur_key) {
        if (n < cur_key) { // 왼쪽에 삽입
            if (left_child[cur_key] == 0) {
                left_child[cur_key] = n;
            } else {
                preOrder(n, left_child[cur_key]);
            }
        } else {            // 오른쪽에 삽입
            if (right_child[cur_key] == 0) {
                right_child[cur_key] = n;
            } else {
                preOrder(n, right_child[cur_key]);
            }
        }
    }

    static void postOrder(int cur_key) throws IOException {

        //left
        if (left_child[cur_key] != 0) {
            postOrder(left_child[cur_key]);
        }
        //right
        if (right_child[cur_key] != 0) {
            postOrder(right_child[cur_key]);
        }
        //출력
        bw.write(cur_key+"\n");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        left_child = new int[1000000];
        right_child = new int[1000000];

        int root_key = Integer.parseInt(br.readLine());

        while (true) {
            String in = br.readLine();
            if (in == null || in.isEmpty()) {
                break;
            }
            preOrder(Integer.parseInt(in), root_key);
        }

        postOrder(root_key);

        bw.flush();
        bw.close();
    }*/

    // #14938 서강그라운드
/*    static int n, m, r;
    static int[] items;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    static int bfs(int start) {
        visited = new boolean[n+1];
        visited[start] = true;  // 처음 도착한 위치
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Edge next : graph[cur.pos]) {
                if (!visited[next.v]) {
                    if (cur.used_dis + next.wei <= m) {
                        visited[next.v] = true;
                        q.offer(new Node(next.v, cur.used_dis + next.wei));
                    }
                }
            }
        }

//        for (int i=1; i<=n; ++i) {
//            System.out.print(visited[i] + " ");
//        }
//        System.out.println();

        int sum = 0;
        for (int i=1; i<=n; ++i) {
            if (visited[i]) {
                sum += items[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        r = Integer.parseInt(inputs[2]);

        items = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; ++i) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n+1];
        for (int i=1; i<=n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<r; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        int answer = -1;
        for (int i=1; i<=n; ++i) {
            answer = Math.max(answer, bfs(i));
        }

        System.out.println(answer);

    }

    static class Edge {
        int v;
        int wei;
        Edge(int v, int wei) {
            this.v = v;
            this.wei = wei;
        }
    }
    static class Node implements Comparable<Node>{
        int pos;
        int used_dis;
        Node(int pos, int used_dis) {
            this.pos = pos;
            this.used_dis = used_dis;
        }
        @Override
        public int compareTo(Node o) {
            return this.used_dis - o.used_dis;
        }

    }*/

    // #14502 연구소
/*    static int N,M;
    static int[][] graph;
    static int[][] cur_graph;
    static boolean[][] visited_graph;
    static ArrayList<Point> possible_walls;
    static ArrayList<Point> valid_walls;
    static boolean[] visited_walls;
    static int[] d_row = {-1,0,1,0};
    static int[] d_col = {0,-1,0,1};
    static int answer = Integer.MIN_VALUE;


    static void backTracking(int start, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, getSaftyArea());
        } else {
            for (int i=start+1; i<possible_walls.size(); ++i) {
                if (!visited_walls[i]) {
                    int next_row = possible_walls.get(i).row;
                    int next_col = possible_walls.get(i).col;
                    valid_walls.add(new Point(next_row, next_col));
                    visited_walls[i] = true;
                    backTracking(i, depth+1);
                    visited_walls[i] = false;
                    valid_walls.remove(valid_walls.size()-1);
                }
            }
        }
    }

    static int getSaftyArea() {
        // 그래프 복사
        cur_graph = new int[N][M];
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                cur_graph[i][j] = graph[i][j];
            }
        }

        // 벽 쌓기
        for (Point p : valid_walls) {
            cur_graph[p.row][p.col] = 1;
        }

        visited_graph = new boolean[N][M];

        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited_graph[i][j] && cur_graph[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }

        int area = 0;
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (cur_graph[i][j] == 0) {
                    area++;
                }
            }
        }

        return area;
    }

    static void dfs(int row, int col) {
        for (int i=0; i<4; ++i) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];
            if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M &&
                    !visited_graph[next_row][next_col] && cur_graph[next_row][next_col] == 0) {
                visited_graph[next_row][next_col] = true;
                cur_graph[next_row][next_col] = 2;
                dfs(next_row, next_col);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        graph = new int[N][M];
        possible_walls = new ArrayList<>();
        valid_walls = new ArrayList<>();

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) {
                    possible_walls.add(new Point(i, j));
                }
            }
        }
        visited_walls = new boolean[possible_walls.size()];

        backTracking(-1, 0);

        System.out.println(answer);
    }

    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }*/


    // 아기 상어 ㅠㅠ
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int sh_i = 0;
        int sh_j = 0;
        int sh_size = 2;
        int sh_eaten = 0;
        int answer = 0;

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sh_i = i;
                    sh_j = j;
                }
            }
        }

        while (true) {
            boolean isEnd = true;
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (arr[i][j] != 0 && arr[i][j] != 9 && arr[i][j] < sh_size) {
                        isEnd = false;
                    }
                }
            }
            if (isEnd) {
                break;
            }

            int fs_i = sh_i;
            int fs_j = sh_j;
            int cur_min_dis = Integer.MAX_VALUE;
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (arr[i][j] != 0 && arr[i][j] != 9 && arr[i][j] < sh_size) {
                        if (Math.abs(sh_i-i)+Math.abs(sh_j-j) < cur_min_dis) {
                            cur_min_dis = Math.abs(sh_i-i)+Math.abs(sh_j-j);
                            fs_i = i;
                            fs_j = j;
                        } else if (Math.abs(sh_i-i)+Math.abs(sh_j-j) == cur_min_dis) {
                            if (i < fs_i) {
                                fs_i = i;
                                fs_j = j;
                            } else if (i == fs_i && j < fs_j) {
                                fs_i = i;
                                fs_j = j;
                            }
                        }

                    }
                }
            }

            answer += Math.abs(fs_i - sh_i) + Math.abs(fs_j - sh_j);

            arr[sh_i][sh_j] = 1000000;
            arr[fs_i][fs_j] = 9;
            sh_i = fs_i;
            sh_j = fs_j;

            sh_eaten++;
            if (sh_eaten == sh_size) {
                sh_size ++;
                sh_eaten = 0;
            }

            for (int i=0; i<N; ++i) {
                for (int j = 0; j < N; ++j) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

        System.out.println(answer);

    }*/

    // #1987 알파벳
/*    static int N,M;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    static char[][] graph;
    static Set<Character> set;
    static int max = -1;

    static void dfs(int row, int col, int sum) {
        max = Math.max(max, sum);

        for (int i=0; i<4; ++i) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];

            if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M &&
            !set.contains(graph[next_row][next_col])) {
                set.add(graph[next_row][next_col]);
                dfs(next_row, next_col, sum+1);
                set.remove(graph[next_row][next_col]);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        graph = new char[N][M];
        for (int i=0; i<N; ++i) {
            graph[i] = br.readLine().toCharArray();
        }

        set = new HashSet<>();
        set.add(graph[0][0]);

        dfs(0, 0, 1);

        System.out.println(max);

    }*/


    // #1916 최소비용 구하기 - 우선순위 큐를 이용한 다익스트라 풀이
/*    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dis;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int pos;
        int dis;
        Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

    static void djk(int start) {
        dis = new int[N+1];
        Arrays.fill(dis, 1000000000);
        dis[start] = 0;

        visited = new boolean[N+1];
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.pos]) {
                continue;
            }
            visited[cur.pos] = true;

            for (int i = 0; i < graph[cur.pos].size(); ++i) {
                Node next = graph[cur.pos].get(i);
                if (dis[cur.pos] + next.dis < dis[next.pos]) {
                    dis[next.pos] = dis[cur.pos] + next.dis;
                    q.offer(new Node(next.pos, dis[next.pos]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for (int i=1; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            graph[a].add(new Node(b, c));
        }

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        djk(start);

        System.out.println(dis[end]);

    }*/

    // #1504 특정한 최단 경로 - 우선순위 큐를 이용한 다익스트라 풀이
/*    static int N,M;
    static ArrayList<Edge>[] graph;
    static int[] dis;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int s_to_v1 = djk(1, v1);
        int v1_to_v2 = djk(v1, v2);
        int v2_to_end = djk(v2, N);

        int s_to_v2 = djk(1, v2);
        int v2_to_v1 = djk(v2, v1);
        int v1_to_end = djk(v1, N);

        int answer = Math.min(s_to_v1 + v1_to_v2 + v2_to_end,
                s_to_v2 + v2_to_v1 + v1_to_end);

        System.out.println(answer >= 200000000 ? -1 : answer);

    }

    // start -> end 로 가는 최단 경로를 반환한다.
    static int djk(int start, int end) {
        dis = new int[N+1];
        Arrays.fill(dis, 200000000);
        visited = new boolean[N+1];

        Queue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;

            for (int i=0; i<graph[cur.v].size(); ++i) {
                Edge next = graph[cur.v].get(i);

                if (dis[cur.v] + next.wei < dis[next.v]) {
                    dis[next.v] = dis[cur.v] + next.wei;
                    q.offer(new Edge(next.v, dis[next.v]));
                }

            }
        }

        return dis[end];
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int wei;
        Edge(int v, int wei) {
            this.v = v;
            this.wei = wei;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wei - o.wei;
        }
    }*/


    // #?? - 구사과의 미세먼지 청소기
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int T = Integer.parseInt(inputs[2]);

        int[][] arr = new int[R][C];
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, -1, 0, 1};
        int clean2_row = 0;
        int clean2_col = 0;

        for (int i=0; i<R; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<C; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    arr[i][j] = Integer.MIN_VALUE;
                    clean2_row = i;
                    clean2_col = j;
                }
            }
        }
        int clean1_row = clean2_row-1;
        int clean1_col = clean2_col;

        while (T --> 0) {
            // 마스킹 배열 생성
            int[][] mask = new int[R][C];
            for (int i = 0; i < R; ++i) {
                for (int j = 0; j < C; ++j) {
                    int cur = arr[i][j];
                    if (cur == Integer.MIN_VALUE) continue;

                    int remain = 0;

                    int token = (int) Math.ceil(arr[i][j] / 5);  // 나눠줄 토큰
                    for (int k = 0; k < 4; ++k) {
                        int target_row = i + d_row[k];
                        int target_col = j + d_col[k];
                        if (target_row >= 0 && target_col >= 0 &&
                                target_row < R && target_col < C &&
                                arr[target_row][target_col] != Integer.MIN_VALUE) {
                            mask[target_row][target_col] += token;
                            remain -= token;
                        }
                    }
                    mask[i][j] += remain;
                }
            }
            // 마스킹 배열 적용
            for (int i = 0; i < R; ++i) {
                for (int j = 0; j < C; ++j) {
                    arr[i][j] += mask[i][j];
                }
            }

            // 청소기1 가동
            for (int row = clean1_row - 2; row >= 0; row--) {
                arr[row + 1][0] = arr[row][0];
            }
            for (int col = 1; col <= C-1; ++col) {
                arr[0][col - 1] = arr[0][col];
            }
            for (int row = 1; row <= clean1_row; row++) {
                arr[row-1][C-1] = arr[row][C-1];
            }
            for (int col = C-2; col >= 1; col--) {
                arr[clean1_row][col+1] = arr[clean1_row][col];
            }
            arr[clean1_row][1] = 0;

            // 청소기2 가동
            for (int row = clean2_row+2; row <= R-1; ++row) {
                arr[row-1][0] = arr[row][0];
            }
            for (int col = 1; col <= C-1; ++col) {
                arr[R-1][col-1] = arr[R-1][col];
            }
            for (int row = R-2; row >= clean2_row; --row) {
                arr[row+1][C-1] = arr[row][C-1];
            }
            for (int col = C-2; col >= 1; --col) {
                arr[clean2_row][col+1] = arr[clean2_row][col];
            }
            arr[clean2_row][1] = 0;

//            // T
//            for (int i = 0; i < R; ++i) {
//                for (int j = 0; j < C; ++j) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//
//            }

        }
        int answer = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                answer += arr[i][j] != Integer.MIN_VALUE ? arr[i][j] : 0;
            }
        }
        System.out.println(answer);
    }*/

/*    static int[] d_row = {1, 0, 1}; // 하, 우, 우하
    static int[] d_col = {0, 1, 1}; // 하, 우, 우하
    static int[][] graph;

    static int bfs() {
        int answer = 0;
        Queue<Edge> q = new LinkedList<>();

        if (graph[0][2] != 1)  {
            q.offer(new Edge(0, 2, "right"));
        }
        if (graph[0][2] != 1 && graph[1][1] != 1 && graph[1][2] != 1) {
            q.offer(new Edge(1, 2, "cross"));
        }

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            System.out.println(q.size());
            // 마지막에 도달함.
            if (cur.row == graph.length-1 && cur.col == graph[0].length - 1) {
                answer++;
                continue;
            }

            for (int i=0; i<3; ++i) {
                int next_row = cur.row + d_row[i];
                int next_col = cur.col + d_col[i];

                if (i == 0) {   // 하
                    if (cur.status.equals("right")) continue;

                    if (next_row < graph.length && next_col < graph[0].length &&
                            graph[next_row][next_col] != 1) {
                        q.offer(new Edge(next_row, next_col, "down"));
                    }

                } else if (i == 1) {  // 우
                    if (cur.status.equals("down")) continue;

                    if (next_row < graph.length && next_col < graph[0].length &&
                            graph[next_row][next_col] != 1) {
                        q.offer(new Edge(next_row, next_col, "right"));
                    }

                } else {  // 우하

                    if (next_row < graph.length && next_col < graph[0].length &&
                            graph[next_row][cur.col] != 1 &&
                            graph[cur.row][next_col] != 1 &&
                            graph[next_row][next_col] != 1 ) {
                        q.offer(new Edge(next_row, next_col, "cross"));
                    }

                }

            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (graph[N-1][N-1] == 1) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    static class Edge {
        int row;
        int col;
        String status;
        Edge(int row, int col, String status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }*/



    // #15686 치킨 배달
/*    static int N,M;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Node> home_nodes;
    static ArrayList<Node> ck_nodes;
    static ArrayList<Node> valid_ck_nodes;

    static class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void bt(int start, int depth) {
        if (depth == M) {
            answer = Math.min(answer, getCksDis());
        } else {
            for (int i=start; i<ck_nodes.size(); ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    Node next = ck_nodes.get(i);
                    valid_ck_nodes.add(new Node(next.row, next.col));
                    bt(i+1, depth+1);
                    valid_ck_nodes.remove(valid_ck_nodes.size()-1);
                    visited[i] = false;
                }
            }

        }
    }

    static int getCksDis() {
        int dis_sum = 0;
        for (int i=0; i<home_nodes.size(); ++i) {
            int dis_min = Integer.MAX_VALUE;
            for (int j=0; j< valid_ck_nodes.size(); ++j) {
                Node home = home_nodes.get(i);
                Node ck = valid_ck_nodes.get(j);
                int dis = Math.abs(home.row - ck.row) + Math.abs(home.col - ck.col);
                dis_min = Math.min(dis_min, dis);
            }
            dis_sum += dis_min;
        }
        return dis_sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home_nodes = new ArrayList<>(); // 집 모든 위치
        ck_nodes = new ArrayList<>();  // 치킨집 모든 위치

        for (int i=0; i<N; ++i) {
            String[] inputs = br.readLine().split(" ");
            for (int j=0; j<N; ++j) {
                int value = Integer.parseInt(inputs[j]);
                if (value == 1) {
                    home_nodes.add(new Node(i, j));
                } else if (value == 2) {
                    ck_nodes.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[ck_nodes.size()];
        valid_ck_nodes = new ArrayList<>();

        bt(0, 0);

        System.out.println(answer);

    }*/

    // #2096 내려가기
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp_max = new int[N+1][3];
        int[][] dp_min = new int[N+1][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dp_max[1][0] = dp_min[1][0] = Integer.parseInt(st.nextToken());
        dp_max[1][1] = dp_min[1][1] = Integer.parseInt(st.nextToken());
        dp_max[1][2] = dp_min[1][2] = Integer.parseInt(st.nextToken());

        for (int i=2; i<=N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            dp_max[i][0] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + first;
            dp_max[i][1] = Math.max(Math.max(dp_max[i-1][0], dp_max[i-1][1]), dp_max[i-1][2]) + second;
            dp_max[i][2] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + third;

            dp_min[i][0] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + first;
            dp_min[i][1] = Math.min(Math.min(dp_min[i-1][0], dp_min[i-1][1]), dp_min[i-1][2]) + second;
            dp_min[i][2] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + third;

        }

        int max = Math.max(Math.max(dp_max[N][0], dp_max[N][1]), dp_max[N][2]);
        int min = Math.min(Math.min(dp_min[N][0], dp_min[N][1]), dp_min[N][2]);
        System.out.println(max + " " + min);

    }*/

/*    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dis;

    static class Node {
        int pos;
        int dis;
        Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }

    static void djk(int start) {
        dis[start] = 0;

        for (int i=1; i<N; ++i) {
            for (int cur=1; cur<=N; ++cur) {
                for (Node next : graph[cur]) {
                    if (dis[next.pos] > dis[cur] + next.dis) {
                        dis[next.pos] = dis[cur] + next.dis;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        dis = new int[N+1];
        Arrays.fill(dis, 1000000000);

        for (int i=1; i<=N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            graph[a].add(new Node(b, c));
        }

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        djk(start);

        System.out.println(dis[end]);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        int cnt = 0;
        while (target > 0) {
            if (target == start) {
                System.out.println(cnt+1);
                System.exit(0);
            }

            String str = String.valueOf(target);
            if (str.charAt(str.length()-1) == '1') {
                target = (int)Math.ceil(target / 10);
                cnt++;
            } else {
                if (target % 2 == 0) {
                    target /= 2;
                    cnt++;
                } else {
                    break;
                }
            }
        }

        System.out.println(-1);

    }*/

/*    static int N, M;
    static StringBuilder sb;
    static Integer[] arr;
    static int[] answer;
    static boolean[] visited;

    static void find(int start, int depth) {
        if (depth == M) {
            for (int res : answer) {
                sb.append(res + " ");
            }
            sb.append("\n");
        } else {
            for (int i=start; i<arr.length; ++i) {
                if (!visited[i]) {
                    answer[depth] = arr[i];
                    find(i, depth+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = new Integer[set.size()];
        visited = new boolean[set.size()];
        answer = new int[M];

        set.toArray(arr);

        find(0,0);

        System.out.print(sb);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; ++i) {

            char c = arr[i];

            if (Character.isAlphabetic(c)) {  // 문자가 숫자일 경우.
                sb.append(c);
            } else {  // 문자가 수식일 경우.

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {  // { +, -, *, / } 인 경우
                    while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    static int getPriority(char c) {
        if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return 0;
    }*/

/*    static int N;
    static int M;
    static int W;
    static int[] dis;
    static ArrayList<Node>[] graph;

    static class Node {
        int pos;
        int dis;
        Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }

    static boolean bf() {
        dis[1] = 0;
        *//* 1) 다익스트라 수행
        *   loop1 : [노드의 갯수-1] 회 반복한다.
        *    loop2 : 모든 노드를 순회한다.
        *     loop3 : 각 노드마다 연결된 노드들을 순회한다.
        * *//*
        for (int i=1; i<N; ++i) {
            for (int j=1; j< graph.length; ++j) {
                for (Node next : graph[j]) {

                    *//** [현재노드까지의 최소거리] + [현재노드 -> 다음노드 거리]  <  [다음노드까지의 최소거리]
                     *    >> [다음노드까지의 최소거리]  =  [현재노드까지의 최소거리] + [현재노드 -> 다음노드 거리]
                     *   *//*
                    if (dis[j] + next.dis < dis[next.pos]) {
                        dis[next.pos] = dis[j] + next.dis;
                    }

                }
            }
        }

        *//* 2) 음수 사이클이 있는지 체크
        *   loop1 : 모든 노드를 순회한다.
        *    loop2 : 각 노드마다 연결된 노드들을 순회한다.
        * *//*
        for (int i=1; i< graph.length; ++i) {
            for (Node next : graph[i]) {

                *//** [현재노드까지의 최소거리] + [현재노드 -> 다음노드 거리]  <  [다음노드까지의 최소거리]
                 *    >> 참이다?
                 *     >> 다익스트라로 모두 갱신을 완료했는데도,
                 *     >> 또 갱신할 수 있다는 건 음수 사이클이 있다는 뜻임
                 *   *//*
                if (dis[i] + next.dis < dis[next.pos]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        while (cnt --> 0) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            W = Integer.parseInt(inputs[2]);

            dis = new int[N+1];
            Arrays.fill(dis, 987654321);
            graph = new ArrayList[N+1];

            for (int i=0; i<N+1; ++i) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<M; ++i) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int c = Integer.parseInt(inputs[2]);
                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            for (int i=0; i<W; ++i) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int c = Integer.parseInt(inputs[2]);
                graph[a].add(new Node(b, -c));
            }

            boolean isPossible = bf();
            System.out.println(isPossible ? "YES" : "NO");

        }

    }*/

    // 트리의 지름 리벤지
/*    static class Conn {
        int pos;
        int dis;
        Conn(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }
    static ArrayList<Conn>[] list;
    static boolean[] visited;
    static int max = -1;
    static int max_pos = 0;

    static void dfs(int cur_pos, int cur_val) {
        if (cur_val > max) {
            max = cur_val;
            max_pos = cur_pos;
        }

        for(Conn nConn : list[cur_pos]) {
            if (!visited[nConn.pos]) {
                visited[nConn.pos] = true;
                dfs(nConn.pos, cur_val + nConn.dis);
                visited[nConn.pos] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; ++i) {
            ArrayList<Conn> l = new ArrayList<>();
            list[i] = l;
        }
        for (int i=1; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Conn(b, c));
            list[b].add(new Conn(a, c));
        }

        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;

        visited[max_pos] = true;
        dfs(max_pos, 0);
        visited[max_pos] = false;

        System.out.println(max);

    }*/

/*    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] graph;
    static boolean[][][] visited;
    static int N, M;
    static int answer = Integer.MAX_VALUE;

    static class Node {
        int row;
        int col;
        int dis;
        boolean broke;
        Node(int row, int col, int dis, boolean broke) {
            this.row = row;
            this.col = col;
            this.dis = dis;
            this.broke = broke;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.row == N-1 && cur.col == M-1) {
                answer = Math.min(answer, cur.dis);
                continue;
            }

            for (int i=0; i<4; ++i) {
                int next_row = cur.row + dx[i];
                int next_col = cur.col + dy[i];

                // 다음 노드가 방문이 불가능한 노드라면 PASS
                if (next_row < 0 || next_col < 0 || next_row >= N || next_col >= M) {
                    continue;
                }

                int next_val = graph[next_row][next_col];

                *//** 0인 곳을 방문할 때
                 *   - visited[0][][] : 벽돌을 한번도 부수지 않은 애가 방문
                 *   - visited[1][][] : 벽돌을 이미 한번 부순 애가 방문 *//*

                *//** 1인 곳을 방문할 때
                 *   - visited[0][][] : 벽돌을 한번도 부수지 않은 해가 방문 *//*
                if (next_val == 1) {
                    if (cur.broke) {
                        continue;
                    } else {
                        if (!visited[0][next_row][next_col]) {
                            visited[0][next_row][next_col] = true;
                            q.offer(new Node(next_row, next_col, cur.dis+1, true));
                        }
                    }
                } else {
                    if (cur.broke) {
                        if (!visited[1][next_row][next_col]) {
                            visited[1][next_row][next_col] = true;
                            q.offer(new Node(next_row, next_col, cur.dis+1, true));
                        }
                    } else {
                        if (!visited[0][next_row][next_col]) {
                            visited[0][next_row][next_col] = true;
                            q.offer(new Node(next_row, next_col, cur.dis+1, false));
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        graph = new int[N][M];

        visited = new boolean[2][N][M];

        for (int i=0; i<N; ++i) {
            String input = br.readLine();
            for (int j=0; j<M; ++j) {
                graph[i][j] = input.charAt(j) == '1' ? 1 : 0;
            }
        }

        bfs();

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int bus_cnt = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i != j) {
                    arr[i][j] = 1000000000;
                }
            }
        }

        while (bus_cnt --> 0) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]) - 1;
            int b = Integer.parseInt(inputs[1]) - 1;
            int dis = Integer.parseInt(inputs[2]);

            // 처음 배열을 초기화한다.
            arr[a][b] = Math.min(arr[a][b], dis);

        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; ++j) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int answer = arr[i][j] != 1000000000 ? arr[i][j] : 0;
                System.out.print(answer + " ");
            }
            System.out.println();
        }

    }*/

/*    static int[] arr;
    static int[] cur_arr;
    static boolean[] visited;
    static ArrayList<Value> answer_list;

    static class Value {
        int[] arr;
        int n;
        public Value(int[] arr) {
            this.arr = new int[arr.length];
            for (int i=0; i<this.arr.length; ++i) {
                this.arr[i] = arr[i];
            }
        }

        // ArrayList 의 isContains() 를 사용하려면
        // 클래스 내에 equals 를 구현해야 함
        @Override
        public boolean equals(Object o) {
            Value v = (Value) o;
            for (int i=0; i<this.arr.length; ++i) {
                if (this.arr[i] != v.arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static void dfs(int depth, int target) {
        if (depth == target) {
            Value v = new Value(cur_arr);
            if (!answer_list.contains(v)) {
                answer_list.add(v);
            }
        } else {
            for (int i=0; i<arr.length; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    cur_arr[depth] = arr[i];
                    dfs(depth+1, target);

                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        cur_arr = new int[M];
        visited = new boolean[N];
        answer_list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, M);

        for (Value v : answer_list) {
            for (int i : v.arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }*/

    // 스티커
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        while (cnt --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            String[] inputs1 = br.readLine().split(" ");
            String[] inputs2 = br.readLine().split(" ");
            for (int i=0; i<n; ++i) {
                arr[0][i] = Integer.parseInt(inputs1[i]);
                arr[1][i] = Integer.parseInt(inputs2[i]);
            }

            int[] select_top_dp = new int[n];
            int[] select_bottom_dp = new int[n];
            int[] select_nothing_dp = new int[n];

            select_top_dp[0] = arr[0][0];
            select_bottom_dp[0] = arr[1][0];
            select_nothing_dp[0] = 0;

            for (int i=1; i<n; ++i) {
                select_top_dp[i] = Math.max(select_bottom_dp[i-1], select_nothing_dp[i-1]) + arr[0][i];
                select_bottom_dp[i] = Math.max(select_top_dp[i-1], select_nothing_dp[i-1]) + arr[1][i];
                select_nothing_dp[i] = Math.max(select_top_dp[i-1], select_bottom_dp[i-1]);
            }

            int answer = Math.max(select_top_dp[n-1], select_bottom_dp[n-1]);
            answer = Math.max(answer, select_nothing_dp[n-1]);
            bw.write(answer+"\n");

        }

        bw.flush();
        bw.close();

    }*/

    // 마인크래프트
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int B = Integer.parseInt(inputs[2]);

        int[][] arr = new int[N][M];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCnt = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int a=0; a<=256; ++a) {
            boolean isPossible = true;
            int cuofHeight = a;
            int marginBlock = B;
            int cnt = 0;

            // 깎는 작업만 수행
            for (int i=0; i<N; ++i) {
                for (int j=0; j<M; ++j) {
                    if (arr[i][j] > cuofHeight) {  // 땅을 깎아야 하는 경우
                        cnt += 2 * (arr[i][j] - cuofHeight);  // 블록 한개에 2초 걸림
                        marginBlock += arr[i][j] - cuofHeight;  // 깎은 블록 만큼 여유블록에 추가
                    }
                }
            }

            // 블록을 놓는 작업을 수행
            for (int i=0; i<N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (arr[i][j] < cuofHeight) {  // 땅에 블록을 놓아야 하는 경우
                        if (marginBlock < cuofHeight - arr[i][j]) {  // 땅에 블록을 놓아야 하는데, 여유 블록이 없음
                            isPossible = false;
                        } else {
                            marginBlock -= cuofHeight - arr[i][j];  // 블록을 사용한다.
                            cnt += cuofHeight - arr[i][j];  // 블록 한개에 1초 걸림
                        }
                    }
                }
            }

            if (!isPossible) {
                continue;
            } else {
                if (cnt <= minCnt) {
                    minCnt = cnt;
                    answerHeight = cuofHeight;
                }
            }
        }

        System.out.println(minCnt + " " + answerHeight);

    }*/

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        while (cnt --> 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            int cmdCnt = Integer.parseInt(br.readLine());
            while (cmdCnt --> 0) {
                String[] inputs = br.readLine().split(" ");
                String cmd = inputs[0];
                int value = Integer.parseInt(inputs[1]);

                switch (cmd) {
                    case "I": {
                        treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                        break;
                    } case "D": {
                        if (treeMap.size() == 0) {
                            break;
                        } else {
                            int key = value == -1 ? treeMap.firstKey() : treeMap.lastKey();

                            if (treeMap.get(key) == 1) {
                                treeMap.remove(key);
                            } else {
                                treeMap.put(key, treeMap.get(key) - 1);
                            }
                            break;
                        }
                    }
                }

            }

            if (treeMap.size() == 0) {
                bw.write("EMPTY\n");
            } else {
                bw.write(String.valueOf(treeMap.lastKey() + " " + String.valueOf(treeMap.firstKey()))+"\n");
            }

        }
        bw.flush();
        bw.close();

    }*/

    //
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        long answer = 0L;
        for (int i=0; i<N; ++i) {
            long ai = (int)arr[i] - 96;
            for (int j=1; j<=i; ++j) {
                ai = ai * 31L % 1234567891L;
            }
            answer += ai;
            answer %= 1234567891L;
        }
        System.out.println(answer);
        // a = 97
        // z = 122

    }*/

    // 9019 DSLR
/*    static boolean[] visited;

    static String bfs(int input, int output) {
        Queue<Register> q = new LinkedList<>();
        q.offer(new Register(input, ""));
        visited[input] = true;

        while (!q.isEmpty()) {
            Register cur = q.poll();
            if (cur.result == output) {
                return cur.cmds;
            }

            int after_D = cur.process_D();
            if (!visited[after_D]) {
                visited[after_D] = true;
                q.offer(new Register(after_D, cur.cmds+"D"));
            }

            int after_S = cur.process_S();
            if (!visited[after_S]) {
                visited[after_S] = true;
                q.offer(new Register(after_S, cur.cmds+"S"));
            }

            int after_L = cur.process_L();
            if (!visited[after_L]) {
                visited[after_L] = true;
                q.offer(new Register(after_L, cur.cmds+"L"));
            }

            int after_R = cur.process_R();
            if (!visited[after_R]) {
                visited[after_R] = true;
                q.offer(new Register(after_R, cur.cmds+"R"));
            }

        }
        return "";
    }

    static class Register {
        int result;
        String cmds;

        Register(int result, String cmds) {
            this.result = result;
            this.cmds = cmds;
        }

        int process_D() {
            return (2 * this.result) % 10000;
        }

        int process_S() {
            if (this.result == 0) {
                return 9999;
            } else {
                return this.result - 1;
            }
        }

        int process_L() {
            return this.result % 1000 * 10 + this.result / 1000;
        }

        int process_R() {
            return this.result / 10 + this.result % 10 * 1000;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int i=0; i<cnt; ++i) {
            String inputs[] = br.readLine().split(" ");
            int input = Integer.parseInt(inputs[0]);
            int output = Integer.parseInt(inputs[1]);
            visited = new boolean[10000];
            bw.write(bfs(input, output)+"\n");
        }
        bw.flush();
        bw.close();
    }*/

    // #14500 테트로미노
/*    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max;

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return ;
        } else {
            for (int i=0; i<4; ++i) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x >= 0 && next_x < graph.length &&
                    next_y >= 0 && next_y < graph[0].length &&
                    !visited[next_x][next_y]) {

                    visited[next_x][next_y] = true;
                    dfs(next_x, next_y, depth + 1, sum + graph[next_x][next_y]);
                    visited[next_x][next_y] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;
        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                max = -1;
                if (j-1 >= 0 && i-1 >= 0 && j+1 < M) {  // 좌(j-1), 상(i-1), 우(j+1)
                    max = Math.max(max, graph[i][j] + graph[i][j-1] + graph[i-1][j] + graph[i][j+1]);
                }
                if (i-1 >= 0 && j+1 < M && i+1 < N) {  // 상(i-1), 우(j+1), 하(i+1)
                    max = Math.max(max, graph[i][j] + graph[i-1][j] + graph[i][j+1] + graph[i+1][j]);
                }
                if (j+1 < M && i+1 < N && j-1 >= 0) {  // 우(j+1), 하(i+1), 좌(j-1)
                    max = Math.max(max, graph[i][j] + graph[i][j+1] + graph[i+1][j] + graph[i][j-1]);
                }
                if (i+1 < N && j-1 >= 0 && i-1 >= 0) {  // 하(i+1), 좌(j-1), 상(i-1)
                    max = Math.max(max, graph[i][j] + graph[i+1][j] + graph[i][j-1] + graph[i-1][j]);
                }

                visited[i][j] = true;
                dfs(i, j, 1, graph[i][j]);
                visited[i][j] = false;

                answer = Math.max(answer, max);

            }
        }
        System.out.println(answer);

    }*/

    // #10026 적록색약
/*    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] RGB;
    static char[][] YB;
    static boolean[][] RGB_visited;
    static boolean[][] YB_visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static void bfs_RGB(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        RGB_visited[x][y] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i=0; i<4; ++i) {
                int next_x = cur.x+dx[i];
                int next_y = cur.y+dy[i];
                if (next_x >= 0 && next_y >= 0 &&
                    next_x < RGB.length && next_y < RGB[0].length &&
                    !RGB_visited[next_x][next_y] &&
                    RGB[cur.x][cur.y] == RGB[next_x][next_y]) {

                    RGB_visited[next_x][next_y] = true;
                    q.offer(new Point(next_x, next_y));
                }
            }
        }
    }

    static void bfs_YB(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        YB_visited[x][y] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i=0; i<4; ++i) {
                int next_x = cur.x+dx[i];
                int next_y = cur.y+dy[i];
                if (next_x >= 0 && next_y >= 0 &&
                        next_x < YB.length && next_y < YB[0].length &&
                        !YB_visited[next_x][next_y] &&
                        YB[cur.x][cur.y] == YB[next_x][next_y]) {

                    YB_visited[next_x][next_y] = true;
                    q.offer(new Point(next_x, next_y));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        RGB = new char[N][N];
        YB = new char[N][N];
        RGB_visited = new boolean[N][N];
        YB_visited = new boolean[N][N];

        for (int i=0; i<N; ++i) {
            String input = br.readLine();
            for (int j=0; j<N; ++j) {
                RGB[i][j] = input.charAt(j);
                YB[i][j] = input.charAt(j)=='B' ? 'B' : 'Y';
            }
        }

        int RGB_answer = 0;
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!RGB_visited[i][j]) {
                    bfs_RGB(i, j);
                    RGB_answer++;
                }
            }
        }
        int YB_answer = 0;
        for (int i=0; i<N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!YB_visited[i][j]) {
                    bfs_YB(i, j);
                    YB_answer++;
                }
            }
        }

        System.out.println(RGB_answer + " " + YB_answer);

    }*/

    // #16928 뱀과 사다리 게임
/*    static int[] arr;
    static int[] answer;
    static boolean[] visited;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i=1; i<=6 && cur+i<=100; ++i) {
                int next = arr[cur+i];
                if (!visited[next] && next <= 100) {
                    visited[next] = true;
                    answer[next] = answer[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        arr = new int[101];
        answer = new int[101];
        visited = new boolean[101];
        for (int i=1; i<=100; ++i) {
            arr[i] = i;
        }
        while (N+M --> 0) {
            inputs = br.readLine().split(" ");
            arr[Integer.parseInt(inputs[0])] = Integer.parseInt(inputs[1]);
        }

        bfs();

        System.out.println(answer[100]);

    }*/

/*    static int[][] graph;
    static boolean[] visited;

    static boolean bfs(int pos, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(pos);
        boolean isFirst = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            // 첫방문 이후에만 경로여부를 판단함.
            // Ex) A -> A 가는 경로가 무조건 있다고 판단하면 안되므로.
            if (!isFirst && cur == target) {
                return true;
            }

            // 이미 방문했던 노드라면 PASS
            if (visited[cur]) {
                continue;
            }
            // 처음 방문하는 노드라면 방문했음을 Check
            visited[cur] = true;

            isFirst = false; // 첫방문 이후임을 표시
            for (int i=0; i<graph.length; ++i) {
                if (graph[cur][i] == 1) {
                    q.offer(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N][N];
        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                visited = new boolean[N];
                boolean isPossible = bfs(i, j);
                if (isPossible) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }

        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }*/

/*    static class Point {
        int pos;
        int value;
        int answer;
        public int getPos() {
            return pos;
        }
        public int getValue() {
            return value;
        }
        public int getAnswer() {
            return answer;
        }
    }

    // #18870 좌표 압축
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Point> list = new ArrayList<>();
        for (int i=1; i<=N; ++i) {
            Point p = new Point();
            p.pos = i;
            p.value = Integer.parseInt(st.nextToken());
            p.answer = 0;
            list.add(p);
        }

        Collections.sort(list, Comparator.comparing(Point::getValue));

        for (int i=1; i<list.size(); ++i) {
            list.get(i).answer = list.get(i-1).answer;
            if (list.get(i-1).value < list.get(i).value) {
                list.get(i).answer++;
            }
        }

        Collections.sort(list, Comparator.comparing(Point::getPos));

        for (int i=0; i<list.size(); ++i) {
            if (i == list.size()-1) {
                bw.write(String.valueOf(list.get(i).answer));
            } else {
                bw.write(list.get(i).answer + " ");
            }
        }

        bw.flush();
        bw.close();
    }*/

    // #20529 가장 가까운 세 사람의 심리적 거리
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        for (int i=0; i<cnt; ++i) {

            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");

            if (n >= 33) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j=0; j<inputs.length-2; ++j) {
                String A = inputs[j];
                for (int k=j+1; k<inputs.length-1; ++k) {
                    String B = inputs[k];
                    for (int l=k+1; l<inputs.length; ++l) {
                        String C = inputs[l];
                        int cur = 0;
                        for (int m=0; m<4; ++m) {
                            if (A.charAt(m) != B.charAt(m)) {
                                cur++;
                            }
                            if (A.charAt(m) != C.charAt(m)) {
                                cur++;
                            }
                            if (B.charAt(m) != C.charAt(m)) {
                                cur++;
                            }
                        }
                        min = Math.min(min, cur);
                    }
                }
            }
            System.out.println(min);

        }
    }*/

    // #21736 헌내기는 친구가 필요해
/*    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;

    static void dfs(int x, int y) {

        if (arr[x][y] == 'X') {
            return ;
        }
        if (arr[x][y] == 'P') {
            answer ++;
        }
        for (int i=0; i<4; ++i) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_y >= 0 &&
                next_x < N && next_y < M &&
                !visited[next_x][next_y]) {

                visited[next_x][next_y] = true;
                dfs(next_x, next_y);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];

        int start_i = 0;
        int start_j = 0;

        for(int i=0; i<N; ++i) {
            String in = br.readLine();
            for(int j=0; j<M; ++j) {
                arr[i][j] = in.charAt(j);
                if(arr[i][j] == 'I') {
                    start_i = i;
                    start_j = j;
                }
            }
        }

        dfs(start_i, start_j);

        System.out.println(answer == 0 ? "TT" : answer);
    }*/

    // #17626 Four Squares
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; ++i) {
            int min = Integer.MAX_VALUE;

            if (Math.pow((int)Math.sqrt(i), 2) == i) {
                dp[i] = 1;
                continue;
            }

            for (int j=1; j<=Math.sqrt(i); ++j) {
                min = Math.min(min, dp[(int)Math.pow(j,2)] + dp[i-(int)Math.pow(j,2)]);
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);

    }*/

 /*   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Map<String, String> map = new HashMap<>();
        for (int i=0; i<N; ++i) {
            inputs = br.readLine().split(" ");
            map.put(inputs[0], inputs[1]);
        }

        for (int i=0; i<M; ++i) {
            bw.write(map.get(br.readLine())+"\n");
        }

        bw.flush();
        bw.close();
    }*/

    // #11727 2×n 타일링 2
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            System.out.println(1);
            System.exit(0);
        }

        if (N==1) {
            System.out.println(3);
            System.exit(0);
        }

        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 3;
        for (int i=3; i<=N; ++i) {
            arr[i] = (arr[i-1] + 2*arr[i-2]) % 10007;
        }

        System.out.println(arr[N]);
    }*/

    // #11726 2xn 타일링
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            System.out.println(1);
            System.exit(0);
        }

        if (N==1) {
            System.out.println(2);
            System.exit(0);
        }

        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=N; ++i) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[N]);

    }*/

    // 11723 집합 - 비트마스킹을 활용한 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];

        for (int i=0; i<cnt; ++i) {
            String inputs[] = br.readLine().split(" ");

            String cmd = inputs[0];

            int value = 0;
            if (inputs.length > 1) {
                value = Integer.parseInt(inputs[1]);
            }

            switch (cmd) {
                case "add": {
                    set[value] = true;
                    break;
                }
                case "remove": {
                    set[value] = false;
                    break;
                }
                case "check": {
                    if(set[value]) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                }
                case "toggle": {
                    if (set[value]) {
                        set[value] = false;
                    } else {
                        set[value] = true;
                    }
                    break;
                }
                case "all": {
                    Arrays.fill(set, true);
                    break;
                }
                case "empty": {
                    set = new boolean[21];
                    break;
                }
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }*/

    // 11723 집합 - Set을 활용한 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        for (int i=0; i<cnt; ++i) {
            String inputs[] = br.readLine().split(" ");

            String cmd = inputs[0];

            char value = 'a';
            if (inputs.length > 1) {
                value = (char)Integer.parseInt(inputs[1]);
            }

            switch (cmd) {
                case "add": {
                    set.add(value);
                    break;
                }
                case "remove": {
                    set.remove(value);
                    break;
                }
                case "check": {
                    if(set.contains(value)) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                }
                case "toggle": {
                    if (set.contains(value)) {
                        set.remove(value);
                    } else {
                        set.add(value);
                    }
                    break;
                }
                case "all": {
                    set.clear();
                    for (int j=1; j<=20; ++j) {
                        set.add((char)j);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }*/

    // #9375 패션왕 신해빈
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int k=0; k<cnt; ++k) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<n; ++i) {
                String kind = br.readLine().split(" ")[1];
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int answer = 1;
            for (String key : map.keySet()) {
                answer *= (map.get(key)+1);
            }
            answer -= 1;

            System.out.println(answer);

        }
    }*/

    // 5430 AC
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        for (int i=0; i<cnt; ++i) {
            char[] cmd = br.readLine().toCharArray();
            int len = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();

            String tmp = br.readLine();
            String[] inputs = tmp.substring(1,tmp.length()-1).split(",");
            if (len > 0) {
                for(int j=0; j<inputs.length; ++j) {
                    dq.add(Integer.parseInt(inputs[j]));
                }
            }

            boolean isError = false;
            String pos = "left";

            for (char c : cmd) {
                // 제거할 정수가 없다면 에러처리
                if (c == 'D' && dq.size()==0) {
                    isError = true;
                    break;
                }

                if (c == 'R') {
                    pos = pos.equals("left") ? "right" : "left";
                }

                if (c == 'D') {
                    if (pos.equals("left")) {  // 왼쪽에서 제거
                        dq.poll();
                    } else {    // 오른쪽에서 제거
                        dq.pollLast();
                    }
                }

            }

            if (isError) {
                bw.write("error\n");
            } else {
                if (dq.size()==0) {
                    bw.write("[]\n");
                } else {
                    if (pos.equals("left")) {
                        bw.write("[");
                        int dqLen = dq.size();
                        for (int j=0; j<dqLen; ++j) {
                            if (j == dqLen-1) {
                                bw.write(String.valueOf(dq.poll()));
                            } else {
                                bw.write(String.valueOf(dq.poll())+",");
                            }
                        }
                        bw.write("]\n");
                    } else {
                        bw.write("[");
                        int dqLen = dq.size();
                        for (int j=0; j<dqLen; ++j) {
                            if (j == dqLen-1) {
                                bw.write(String.valueOf(dq.pollLast()));
                            } else {
                                bw.write(String.valueOf(dq.pollLast())+",");
                            }
                        }
                        bw.write("]\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();

    }*/

/*    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int minDis = Integer.MAX_VALUE;

    static void dfs(int cur, int target, int depth) {

        if (cur == target) {
            minDis = Math.min(minDis, depth);
        } else {
            for (Integer i : arr[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, target, depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // ----------------------------여기서부터 입력-----------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        // 초기화
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for(int i=0; i<=N; ++i) {
            arr[i] = new ArrayList<>();
        }

        for (int i=0; i<M; ++i) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            arr[a].add(b);
            arr[b].add(a);
        }
        // ----------------------------여기까진 입력-----------------------------

        int minTot = Integer.MAX_VALUE;
        int maxNode = -1;
        for (int i=1; i<=N; ++i) {
            int sumDis = 0;
            for (int j=1; j<=N; ++j) {
                minDis = Integer.MAX_VALUE;

                visited[i] = true;
                dfs(i, j, 0);   // cur, target, depth
                sumDis += minDis;

                visited = new boolean[N+1];
            }

            if (sumDis < minTot) {
                minTot = sumDis;
                maxNode = i;
            }
        }
        System.out.println(maxNode);
    }*/

    // #1107 리모콘
/*    static class Channel{
        int curChannel;
        int clickedCnt;
        Channel(int curChannel, int clickedCnt) {
            this.curChannel = curChannel;
            this.clickedCnt = clickedCnt;
        }
    }

    static ArrayList<Channel> list;
    static StringBuilder sb;
    static Integer[] arr;
    static int len=0;

    static void dfs(int depth) {
        if (depth > 6) {
            return;
        }

        list.add(new Channel(Integer.parseInt(sb.toString()), depth));

        for (int i=0; i<arr.length; ++i) {
            sb.append(arr[i]);
            dfs(depth+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) throws IOException {
        
        // ==========================여기부터 입력===========================
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        len = String.valueOf(N).length();

        int cnt = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        arr = new Integer[10-cnt];
        List<Integer> tmp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        if (cnt != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<cnt; ++i) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i=0; i<10; ++i) {
            if (!set.contains(i)) {
                tmp.add(i);
            }
        }
        tmp.toArray(arr);
        // ==========================여기까지 입력===========================

        sb = new StringBuilder("");
        for (int i=0; i<arr.length; ++i) {

            sb.append(arr[i]);
            dfs(1);
            sb.deleteCharAt(sb.length()-1);  // length? length-1?

        }

        int min = Integer.MAX_VALUE;
        for (Channel c : list) {
            int cur = Math.abs(N - c.curChannel) + c.clickedCnt;
            min = Math.min(cur, min);
        }

        System.out.println(Math.min(Math.abs(100-N), min));

    }*/


    // #1074 Z
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int r = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);
        int answer = 0;
        // N= 10>9
        N--;

        while (N>=0) {

            // size = 2^9 = 512
            int size = (int)Math.pow(2, N);
            int beAdd = (int)Math.pow(size, 2);

            if (r >= size) {
                answer += 2*beAdd;
            }
            if (c >= size) {
                answer += beAdd;
            }

            r %= size;
            c %= size;

            N--;

        }

        System.out.println(answer);

    }*/
    
    // #1012 유기농 배추
/*    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while(!q.isEmpty()) {
            Point cur = q.poll();

            // 이미 방문했던 곳은 PASS
            if (visited[cur.x][cur.y]) { // || arr[cur.x][cur.y]==0) {
                continue;
            }
            visited[cur.x][cur.y] = true; // 현재좌표를 방문했음을 체크

            for(int i=0; i<4; ++i) {
                int nextX = cur.x + dx[i];    
                int nextY = cur.y + dy[i];    
                if (nextX >= 0 && nextY >= 0         // cur.x + dx[x] >= 0 이어야함
                        && nextX < arr.length        // cur.y + dy[y] >= 0 이어야함
                        && nextY < arr[0].length     // cur.x + dx[x] < N 이어야함 
                        && !visited[nextX][nextY]    // cur.y + dy[y] < M 이어야함
                        && arr[nextX][nextY] == 1) {
                    //visited[nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
        answer ++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<problemCnt; ++i) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            int pointCnt = Integer.parseInt(inputs[2]);

            arr = new int[N][M];
            visited = new boolean[N][M];
            answer = 0;

            for (int j=0; j<pointCnt; ++j) {
                String[] points = br.readLine().split(" ");
                int x = Integer.parseInt(points[0]);
                int y = Integer.parseInt(points[1]);
                arr[x][y] = 1;
            }

            for(int a=0; a<N; ++a) {
                for (int b=0; b<M; ++b) {
                    if(!visited[a][b] && arr[a][b] == 1) {
                        bfs(a, b);
                    }
                }
            }
            System.out.println(answer);
        }

    }*/

    // #1003 피보나치 함수
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[41];
        arr[0] = 0;
        arr[1] = 1;
        for (int i=2; i<=40; ++i) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i) {
            int n = Integer.parseInt(br.readLine());
            if (n==0) {
                System.out.println(1 + " " + 0);
                continue;
            }
            System.out.println(arr[n-1] + " " + arr[n]);
        }

    }*/

    // #1167 트리의 지름 - BFS
/*    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static int maxCost = -1;
    static int maxPos = 0;

    static class Node {
        int pos;
        int cost;
        Node(){

        };
        Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }
    }

    static void bfs(int pos, int cost) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(pos, cost));
        dist[pos] = cost;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.pos]) {
                continue;
            }
            visited[cur.pos] = true;

            for(Node node : list[cur.pos]) {
                if (!visited[node.pos]) {
                    q.offer(node);
                    dist[node.pos] = dist[cur.pos] + node.cost;
                    maxCost = Math.max(maxCost, dist[node.pos]);
                }
            }
        }

        for(int i=1; i<dist.length; ++i) {
            if (dist[i] == maxCost) {
                maxPos = i;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N+1];

        for (int i = 1; i <= N; ++i) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; ++i) {
            String input[] = br.readLine().split(" ");

            for (int j = 1; j <= input.length - 3; j += 2) {
                Node node = new Node();
                node.pos = Integer.parseInt(input[j]);
                node.cost = Integer.parseInt(input[j + 1]);
                list[Integer.parseInt(input[0])].add(node);
            }

        }

        bfs(1, 0);

        visited = new boolean[N+1];
        dist = new int[N+1];
        maxCost = -1;

        bfs(maxPos, 0);

        System.out.println(maxCost);

    }*/

    // #1167 트리의 지름 - DFS
/*    static List<Node>[] list;
    static boolean[] visited;
    static int maxCost = -1;
    static int maxPos = 0;

    static class Node {
        int pos;
        int cost;
    }

    static void dfs(int pos, int cost) {

        if (cost > maxCost) {
            maxPos = pos;
            maxCost = cost;
        }

        for (Node node : list[pos]) {
            if (!visited[node.pos]) {
                visited[pos] = true;
                dfs(node.pos, cost+node.cost);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; ++i) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; ++i) {
            String input[] = br.readLine().split(" ");

            for(int j=1; j<=input.length-3; j+=2) {
                Node node = new Node();
                node.pos = Integer.parseInt(input[j]);
                node.cost = Integer.parseInt(input[j+1]);
                list[Integer.parseInt(input[0])].add(node);
            }

        }

        for (int i=1; i<=N; ++i) {
            System.out.println(list[i].toString());

        }

        dfs(1, 0);

        visited = new boolean[N+1];

        dfs(maxPos, 0);

        System.out.println(maxCost);

    }*/

    // #1043 거짓말
/*    static int[] parent;

    static int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b){
        int parentB=find(b);
        parent[parentB]=a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[M+1];

        for(int i=1; i<=M; ++i) {
            arr[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        for(int i=1; i<=N; ++i) {
            parent[i] = i;
        }

        boolean[] knowTruth = new boolean[N+1];


        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; ++i) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        // 입력 저장 및 Union
        for(int i=1; i<=M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            int before = 0;
            for(int j=1; j<=n; ++j) {
                int cur = Integer.parseInt(st.nextToken());
                arr[i].add(cur);

                if(j==1) {
                    before = cur;
                } else {
                    if (find(before) != find(cur)) {
                        union(before, cur);
                    }
                    before = cur;
                }
            }

        }

        // 진실을 아는사람인지/모르는사람인지 체크하여 채우기
        for(int i=1; i<= N; ++i) {
            int parentNow = find(i);
            for(int j=1; j<= N; ++j) {
                if(parentNow == find(j) && knowTruth[j]) {
                    knowTruth[i] = true;
                }
            }
        }

        // 진실을 아는사람이 한명도 없는 파티만 세기
        int answer = 0;
        for(int i=1; i<arr.length; ++i) {
            boolean isNotKnow = true;
            for(Integer it : arr[i]) {
                if (knowTruth[it]) {
                    isNotKnow = false;
                }
            }
            if (isNotKnow) {
                answer ++;
            }
        }

        System.out.println(answer);
    }*/


    // #1043 거짓말 - Set 이용한 풀이
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] party = new int[M][50];
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; ++i) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; ++j) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < 50; a++) {
            for(int i=0; i<M; ++i) {
                for(int j=0; j<50; ++j) {
                    if(party[i][j]!=0 && set.contains(party[i][j])) {
                        for(int k=0; k<50; ++k) {
                            if (party[i][k]!=0) {
                                set.add(party[i][k]);
                            }
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<M; ++i) {
            boolean isPossible = true;
            for (int j = 0; j < n; ++j) {
                if(set.contains(party[i][j])) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }*/

    // #2110 공유기 설치
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = Arrays.stream(arr).max().getAsInt();

        int left = 1;
        int right = max;

        int answer = 0;
        while (left <= right) {
            int middle = (left+right)/2;

            int count = 1;
            int beforeLoc = arr[0];
            for(int i=1; i<N; ++i) {
                if(arr[i] - beforeLoc >= middle) {
                    count++;
                    beforeLoc = arr[i];
                }
            }

            if(count >= C) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(answer);

    }*/

    // #2805
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = -1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int left = 0;
        int right = max;
        long answer = 0;
        while(left <= right) {
            int middle = (left+right)/2;

            long hei = 0;
            for (int i=0; i<N; ++i) {
                if (arr[i] > middle) {
                    hei += arr[i] - middle;
                }
            }

            if (M > hei) {
                right = middle - 1;
            } else {
                answer = middle;
                left = middle + 1;
            }
        }

        System.out.println(answer);

    }*/

    // #1654 랜선 자르기
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for(int i=0; i<K; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long max = Arrays.stream(arr).max().getAsLong();

        long left = 1;
        long right = max;

        List<Long> list = new ArrayList<>();

        while(left <= right) {
            long middle = (left + right) / 2;
            long answer = 0;

            for(int i=0; i<K; ++i) {
                answer += arr[i] / middle;
            }

            if(answer >= N) {
                left = middle+1;
                list.add(middle);
            } else if (answer < N) {
                right = middle-1;
            }
        }

        System.out.println(Collections.max(list));

    }*/

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
