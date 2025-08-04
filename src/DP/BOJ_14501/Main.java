package DP.BOJ_14501;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14501
// 14501번 퇴사

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [][] graph = new int [N+1][2];
        int [] dp = new int [N+2];

        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken()); // 0: 상담에 걸리는 시간(T), 1: 상담에 의한 이익(P)
        }

        for (int i=1; i<N+1; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);

            for (int j = i + graph[i][0]; j<=N+1; j++){
                if (dp[j] < dp[i] + graph[i][1]){
                    dp[j] = dp[i] + graph[i][1];
                }
            }
        }

        bw.write(String.valueOf(dp[N+1]));
        bw.flush();
        bw.close();

    }
}
