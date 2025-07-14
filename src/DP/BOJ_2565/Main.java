package DP.BOJ_2565;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2565
// 2565번 전깃줄

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [][] graph = new int [n][2];
        int [] dp = new int [n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<2; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[i] = 1;
        }
        Arrays.sort(graph, Comparator.comparingInt(a -> a[0]));

        int max_val = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                if (graph[j][1] < graph[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max_val = Math.max(max_val, dp[i]);
        }

        bw.write(String.valueOf(n-max_val));
        bw.flush();
        bw.close();
    }
}
