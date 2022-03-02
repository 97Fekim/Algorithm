package Inflearn._9Greedy;

import java.lang.reflect.Array;
import java.util.*;

/* 다익스트라 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}

/* 6-2. 친구인가(Disjoint-Set : Union & Find) */
/*public class Main {
    static int[] unf;   // 집합을 표현하는 배열
    public static int Find(int v){
        if(v == unf[v])
            return v;
        else
            return unf[v] = Find(unf[v]);   // 메모이제이션
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)
            unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; ++i)
            unf[i] = i;
        for(int i=1; i<=m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);    // a와 b를 한 집합으로 만들어라
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa==fb)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}*/

/* 6-1. 친구인가(DFS) */
/*public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int friend2;
    static boolean[] ch;
    static String answer = "NO";
    static void dfs(int friend){
        if(friend == friend2) {
            answer = "YES";
            return ;
        }
        else{
            for(int nv : graph.get(friend))
                if(!ch[nv]) {
                    ch[nv] = true;
                    dfs(nv);
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        ch = new boolean[n+1];
        for(int i=0; i<=n; ++i)
            graph.add(new ArrayList<Integer>());
        for(int i=0; i<m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int friend1 = sc.nextInt();
        friend2 = sc.nextInt();
        dfs(friend1);
        System.out.println(answer);
    }
}*/

/* 5. 다익스트라 알고리즘
* n개의 정점을 n번 순회해야 하기때문에 n^2 인 것처럼 보이지만,
* 다익스트라 알고리즘은 우선순위큐(logn)를 사용하기 때문에,
* nlogn 의 시간복잡도로 구현이 가능하다.
* - Arrays.fill(arr, n) : arr 배열을 n으로 모두 채운다.
* */
/*public class Main {
    static class Edge implements Comparable<Edge>{
        public int vex;
        public int cost;
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[v] = 0;
        pQ.offer(new Edge(v,0));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(dis[now] < nowCost) continue;
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<= n; ++i)
            graph.add(new ArrayList<Edge>());
        for(int i=0; i<m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        solution(1);
        for(int i=2; i<=n; ++i){
            if(dis[i] != Integer.MAX_VALUE)
                System.out.println(i+ " : " + dis[i]);
            else
                System.out.println(i+" : impossible");
        }
    }
}*/
/* 4. 최대수입 스케쥴 (Priority Queue)
* 우선순위를 '크게' 지정하였다면, 1,2,3,4,5 중 5가 제일 먼저 나온다.
* 우선순위를 '작게' 지정하였다면, 1,2,3,4,5 중 1이 제일 먼저 나온다.
* 생성
* - PriorityQueue<T> pQ = new PriorityQueue<>(); // 작은걸 우선순위
* - PriorityQueue<T> pQ = new PriorityQueue<>(Collections.reverseOrder());  // 큰걸 우선순위
* */
/*public class Main{
    static class Lecture implements Comparable<Lecture>{
        int price, time;
        public Lecture(int price, int time) {
            this.price = price;
            this.time = time;
        }
        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    static int n, max=Integer.MIN_VALUE;
    static int solution(ArrayList<Lecture> list){
        int answer = 0;
        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        for(int i=max; i>=1; ++i){
            for(j=0; i<n; ++j){
                if(list.get(j).time < i)
                    break;
                pQ.offer(list.get(j).price);
            }
            if(!pQ.isEmpty())
                answer += pQ.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> list = new ArrayList<>();
        for(int i=0; i<n; ++i){
            int price = sc.nextInt();
            int time = sc.nextInt();
            if(time > max)
                max = time;
            list.add(new Lecture(price, time));
        }
        System.out.println(solution(list));
    }
}*/
/* 3. 결혼식 */
/*public class Main{
    static class Time implements Comparable<Time>{
        public int start;
        public char when;
        public Time(int start, char when) {
            this.start = start;
            this.when = when;
        }

        @Override
        public int compareTo(Time o) {
            if(this.start == o.start)
                return this.when - o.when;
            else
                return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i=0; i<n; ++i){
            list.add(new Time(sc.nextInt(), 's'));
            list.add(new Time(sc.nextInt(), 'e'));
        }

        Collections.sort(list);

        int answer = 0;
        int cnt = 0;
        for(Time t : list){
            if(t.when=='e'){
                cnt--;
            }
            else{   // t.when == 's'
                cnt++;
                if(cnt > answer)
                    answer = cnt;
            }
        }
        System.out.println(answer);
    }
}*/
/* 2. 회의실 배정 */
/*public class Main{
    static class Conf implements Comparable<Conf>{
        public int start;
        public int end;
        public Conf(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Conf o) {
            if(this.end == o.end)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Conf> list = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Conf(start, end));
        }
        Collections.sort(list);

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(Conf c : list){
            if(c.start>=max){
                max = c.end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}*/
/* 1. 씨름선수 */
/*public class Main{
    static class Body implements Comparable<Body>{
        public int height;
        public int weight;
        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> list = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            int wei = sc.nextInt();
            int hei = sc.nextInt();
            list.add(new Body(wei, hei));
        }
        Collections.sort(list);

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(Body b : list){
            if(b.weight > max){
                max = b.weight;
                answer++;
            }
        }
        System.out.println(answer);
    }
}*/
