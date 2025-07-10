package DP.BOJ_1463;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1463
// 1463번 1로 만들기

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        int [] dp = new int [x+1]; // dp[i]를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값
        // 따라서 dp[12] = Math.min(dp[4], dp[6], dp[11]) + 1

        dp[1] = 0;

        for (int i=2; i<x+1; i++){
            dp[i] = dp[i-1]+1;
            if (i % 2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
        }

        bw.write(String.valueOf(dp[x]));
        bw.flush();
        bw.close();

    }
}
