package Graph.BOJ_1325;

// https://www.acmicpc.net/problem/1325
// 1325번 효율적인 해킹

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> [] graph;
    static int [] visited;
    static int [] cnt;
    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        cnt = new int [N+1];
        visited = new int[N+1];

        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer (br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[v].add(u);
        }

        for (int i=1; i<N+1; i++){
            Arrays.fill(visited, 0);
            dfs(i, i);
        }

        int max = Arrays.stream(cnt).max().getAsInt();

        for (int i=1; i<N+1; i++){
            if (max == cnt[i]) bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }

    static private void dfs (int x, int start){
        visited[x] = 1;

        for (int y : graph[x]){
            if (visited[y] == 1) continue;
            cnt[start] ++;
            dfs(y, start);
        }
    }
}
