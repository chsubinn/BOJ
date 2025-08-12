package Graph.BOJ_16947;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16947
// 16947번 서울 지하철 2호선

public class Main {
    final static int INF = Integer.MAX_VALUE;
    static int N;
    static int [] dist;
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> route = new ArrayList<>();
    static int [] visited;

    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dist = new int [N+1];
        for (int i = 1; i<N+1; i++){
            dist[i] = INF;
        }

        for (int i=1; i<N+1; i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        getRoute(1, 0);

        for (int i=1; i<N+1; i++){
            if (route.contains(i)) dist[i] = 0;
            else {
                for (int r : route){
                    dist[i] = Math.max(getDistance(i, r), dist[i]);
                }
            }
        }

        for (int i = 1; i<N+1; i++){
            System.out.print(dist[i]+" ");
        }
    }
    static private void getRoute (int current, int parent){
        visited = new int [N+1];
        visited[current] = 1;

        for (int i : graph.get(current)){
            if (visited[i] == 1) route.add(i);
            else{
                getRoute(i, current);
            }
        }
    }

    static private int getDistance (int node, int r){
        int dist = 0;

        int [] visited = new int [N+1];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> info = new HashMap<>();

        queue.add(node);
        info.put(node, 0);

        while (!queue.isEmpty()){
            int n = queue.remove();
            int cd = info.get(n);

            if (n == r) return cd;

            for (int i : graph.get(n)){
                if (visited[i]==0) {
                    queue.add(i);
                    info.put(i, cd+1);
                }
            }
        }
        return dist;
    }
    static private class Pair {
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

    }
}
