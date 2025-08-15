package Graph.BOJ_16947;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16947
// 16947번 서울 지하철 2호선

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean foundCycle;
    static boolean [] visited;
    static boolean [] isCycle;
    static int [] dist;

    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            graph[u].add(v);
        }

        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        dist = new int[N + 1];

        getRoute(1, -1);

        getDistance();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }
    static private boolean getRoute (int current, int parent){
        visited[current] = true;

        for (int  next : graph[current]){
            if (next == parent) continue;

            if (visited[next]){ // 이미 visited면 사이클 발견으로 간주
                isCycle[next] = true;
                isCycle[current] = true;
                foundCycle = false;
                return true;
            }
            else{
                if (getRoute(next, current)) {
                    if (!foundCycle) isCycle[current] = true;
                    if (isCycle[current] && current == next) foundCycle = true;
                    return !foundCycle; // 마킹 계속할지 여부
                }
            }
        }
        return isCycle[current];
    }

    static private void getDistance (){
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
