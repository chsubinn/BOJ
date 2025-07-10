package Graph.BOJ_1260;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1260
// 1260번 DFS와 BFS

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main (String args []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m, v;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i=1; i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<m+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        int [] visited = new int [n+1];
        dfs(v, visited, graph);

        bw.newLine();
        visited = new int [n+1];
        bfs(v, visited, graph);

        bw.flush();
        bw.close();
    }

    private static void dfs (int v, int [] visited, ArrayList<Integer>[] graph) throws IOException{
        visited[v] = 1;
        bw.write(v + " ");
        for (int next : graph[v]){
            if (visited[next]==0){
                dfs(next, visited, graph);
            }
        }
    }

    private static void bfs(int v, int [] visited, ArrayList<Integer>[] graph) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = 1;
        while (!queue.isEmpty()){
            int q = queue.poll();
            bw.write(q + " ");
            for (int next : graph[q]){
                if (visited[next] == 0){
                    queue.add(next);
                    visited[next] = 1;
                }
            }
        }

    }
}
