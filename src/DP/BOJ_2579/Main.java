package DP.BOJ_2579;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2579
// 2579번 계단 오르기

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] stairs = new int [n+1];
        int [] dp = new int [n+1];
        for (int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        /*
        dp[1] = 10
        dp[2] = 30, 20
        dp[3] =
         */
        for (int i=1; i<=n; i++){
            if (i==1){
                dp[i] = stairs[i];
            }
            else if (i==2){
                dp[i] = stairs[i] + stairs[i-1];
            }
            else {
                dp[i] = stairs[i] + Math.max(stairs[i-1] + dp[i-3], dp[i-2]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
