package BAEKJOON._25ShortestPath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 10989 수 정렬하기 3 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i : arr)
            sb.append(i).append('\n');
        System.out.println(sb);
    }
}*/

/*  */
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
    static void dijkstra(int v, ArrayList<ArrayList<Edge>> graph){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[v] = 0;
        pQ.offer(new Edge(v,0));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(dis[now] < nowCost) continue;
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > ob.cost + nowCost)
                    dis[ob.vex] = ob.cost + nowCost;
                pQ.offer(new Edge(ob.vex,ob.cost + nowCost));
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<=m; ++i)
            graph.add(new ArrayList<Edge>());
        for(int i=0; i<m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        dijkstra(v, graph);
        for(int i=1; i<=n; ++i){
            if(dis[i] != Integer.MAX_VALUE)
                System.out.println(dis[i]);
            else
                System.out.println("INF");
        }
    }
}*/
