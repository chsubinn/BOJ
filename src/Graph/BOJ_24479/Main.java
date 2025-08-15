package Graph.BOJ_24479;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/24479
// 24479번 알고리즘 수업 - 깊이 우선 탐색 1

public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static int [] visited;
    static int order = 1;

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int [N+1];
        graph = new List[N+1];

        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer (br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i=1; i<N+1; i++){
            Collections.sort(graph[i]);
        }



        dfs(R);

        for (int i=1; i<N+1; i++){
            bw.write(visited[i]+"\n");
        }
        bw.flush();
    }
    static private void dfs (int x){
        visited[x] = order++;

        for (int y : graph[x]){
            if (visited[y] != 0) continue;
            dfs(y);
        }

    }
}
