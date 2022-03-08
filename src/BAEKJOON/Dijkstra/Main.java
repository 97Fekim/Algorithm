package BAEKJOON.Dijkstra;

public class Main {
    public static void main(String[] args) {

    }
}
/* 1753 최단경로 */
/*public class Main {
    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int[] dis;
    static boolean[] ch;
    static ArrayList<ArrayList<Edge>> graph;
    public static void dijkstra(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[v] = 0;
        pq.offer(new Edge(v,0));
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(ch[now])
                continue;
            ch[now] = true;
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        dis = new int[n+2];
        ch = new boolean[n+2];

        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=m+1; ++i)
            graph.add(new ArrayList<Edge>());

        for(int i=0; i<m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        dijkstra(x);
        for(int i=1; i<=n; ++i){
            if(dis[i] != Integer.MAX_VALUE)
                System.out.println(dis[i]);
            else
                System.out.println("INF");
        }
    }
}*/
/* 1238 파티 (다익스트라) */