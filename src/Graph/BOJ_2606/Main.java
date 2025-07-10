package Graph.BOJ_2606;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2606
// 2606번 바이러스

public class Main {
    static int cnt = 0;
    public static void main (String args []) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[v+1];
        for (int i=0; i<v+1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        int [] visited = new int [v+1];
        dfs(1, graph, visited);

        bw.write(String.valueOf(cnt-1));
        bw.flush();
        bw.close();
    }

    private static void dfs(int v, ArrayList<Integer>[] graph, int[] visited){
        visited[v] = 1;
        cnt++;
        for (int next : graph[v]){
            if (visited[next] == 0){
                dfs(next, graph, visited);
            }
        }
    }
}
