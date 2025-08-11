package DP.BOJ_17070;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17070
// 17070번 파이프 옮기기 1

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int [][] graph = new int [N+1][N+1];
        int [][][] dp = new int [N+1][N+1][3];

        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<N+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (graph[i][j] == 1) continue;

                if (j-1 >= 1 && graph[i][j-1] == 0) dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                if (i-1 >= 1 && graph[i-1][j] == 0) dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                if (i-1 >= 1 && j-1 >= 1 && graph[i-1][j-1] == 0 && graph[i][j-1]==0 && graph[i-1][j] == 0) dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];

            }
        }
        bw.write(String.valueOf(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]));
        bw.flush();
        bw.close();
    }
}
