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
        int [] dp = new int [501];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<2; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max_cross = 0;
        int cnt = 0;
        while (true){
            for (int i=0; i<n; i++){ // 기준
                for (int j=0; j<n; j++){
                    if (graph[i][0] < graph[j][0] && graph[i][1]>graph[j][1]){
                        dp[graph[i][0]] ++;
                        dp[graph[i][1]] ++;
                    }
                    max_cross = Math.max(max_cross, dp[graph[i][0]]);
                }
            }
            for (int i=1; i<10; i++){
                System.out.print(dp[i]+ " ");
            }
            System.out.println();

            if (max_cross == 0){
                break;
            }
            for (int i=0; i<501; i++){
                if (max_cross == dp[i]){
                    cnt ++;
                    dp[i] = -1;

                }
            }
            max_cross=0;
        }
        bw.write(String.valueOf(cnt/2));
        bw.flush();
        bw.close();
    }
}
