package DP.BOJ_15486;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15486
// 15486번 퇴사 2

public class Main {
    public static void main (String args []) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] t = new int [n+1];
        int [] p = new int [n+1];
        int [] dp = new int [n+2];

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n+1; i++){
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if (i + t[i] <= n+1){
                dp[i + t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]); // 이미 수익이 있을 경우와 이번에 수익이 발생했을때의 수익 비교
            }
        }

        bw.write(String.valueOf(dp[n+1]));
        bw.flush();
        bw.close();
    }
}
