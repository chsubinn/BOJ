package DP.BOJ_9461;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9461
// 9461번 파도반 수열

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int [] arr = new int [T+1];
        Long [] answer = new Long [T+1];
        for (int i=0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            answer[i] = solution(arr[i]);
        }

        for (int i=0; i<T; i++){
            bw.write(String.valueOf(answer[i]));
            if (i<T-1){
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static Long solution (int x){
        Long [] dp = new Long [x+1];
        for (int i=1; i<= x; i++){
            if (i==1){
                dp[i] = 1L;
            }
            if (i==2){
                dp[i] = 1L;
            }
            if (i==3){
                dp[i] = 1L;
            }
            if (i >= 4){
                dp[i] = dp[i-3] + dp[i-2];
            }
        }
        return dp[x];
    }
}
