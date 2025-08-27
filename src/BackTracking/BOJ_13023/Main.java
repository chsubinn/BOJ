package BackTracking.BOJ_13023;

// https://www.acmicpc.net/problem/13023
// 13023번 제출

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean found = false;
    static int [] visited;
    static ArrayList<List<Integer>> graph = new ArrayList<>();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int [N];
        for (int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i=0; i<N; i++){
            dfs(i, 1);
            if (found) break;
        }

        bw.write(String.valueOf(found? 1:0));
        bw.flush();
        bw.close();
    }
    private static void dfs(int start, int depth){
        visited[start] = 1;
        if (depth == 5){
            found=true;
            return;
        }
        for (int x : graph.get(start)){
            if (visited[x] != 1){
                dfs(x, depth+1);
                if (found) return;
            }
        }
        visited[start] = 0;

    }
}
