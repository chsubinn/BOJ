package DP.BOJ_11052;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11052
// 11052번 카드 구매하기

public class Main {
    public static void main (String args []) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] p = new int [n+1];
        int [] dp = new int [n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<n+1; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n+1; i++){
            for (int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+p[j]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
