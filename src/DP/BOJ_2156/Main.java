package DP.BOJ_2156;

// https://www.acmicpc.net/problem/2156
// 2156번 포도주

import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] wines = new int [N+1];
        int [] dp = new int [N+1];

        for (int i=1; i<=N; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }


        dp[1] = wines[1];
        if (N >= 2) dp[2] = wines[1] + wines[2]; // dp는 해당 와인잔까지의 최대 값
        if (N >= 3){
            for (int i=3; i<=N; i++){
                dp[i] = Math.max(
                        dp[i-1],
                        dp[i-2] + wines[i]);

                dp[i] = Math.max(
                        dp[i-3] + wines[i] + wines[i-1],
                        dp[i]);
            }
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }

}
