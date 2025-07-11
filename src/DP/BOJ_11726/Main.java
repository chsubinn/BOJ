package DP.BOJ_11726;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11726
// 11726번 2xn 타일링

public class Main {
    public static void main (String args []) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long [] dp = new Long [n+1];

        /*
        * dp[1] = 1
        * dp[2] = 2
        * dp[3] = 3
        * dp[4] = 5
        * dp[5] = 8
        *  */
        for (int i=1; i<=n; i++){
            if (i==1){
                dp[i] = 1L;
            }
            if (i==2){
                dp[i] = 2L;
            }
            if (i>=3){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
