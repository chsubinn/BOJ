package Djisktra.BOJ_1446;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1446
// 1446번 지름길

public class Main{
    final static int INF = Integer.MAX_VALUE;
    static List<List<Pair>> graph = new ArrayList<>();
    static int N, D;
    static int [] dp;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i=0; i<D+1; i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (v > D || u > D) continue;
            graph.get(u).add(new Pair (w, v));
        }

        dp = new int [D+1];
        for (int i=1; i<D+1; i++){
            dp[i] = INF;
        }
        dp[0] = 0;
        for (int i=0; i<D+1; i++){
            if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (Pair pair : graph.get(i)){
                if (pair.node<=D){
                    dp[pair.node] = Math.min(dp[pair.node], dp[i] + pair.dist);
                }
            }
        }


        bw.write(String.valueOf(dp[D]));
        bw.flush();
        bw.close();
    }

    static class Pair {
        int dist, node;
        Pair (int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
}
