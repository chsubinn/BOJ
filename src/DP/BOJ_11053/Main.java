package DP.BOJ_11053;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11053
// 11053번 가장 긴 증가하는 수열

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] A = new int [N];
        int [] dp = new int [N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=0; i<N;i ++){
            for (int j=0; j<i; j++){
                if (A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        int max_val = 0;
        for (int i=0; i<N; i++){
//            System.out.print("i="+i+", ");
//            for (int j=0; j<N; j++){
//                System.out.print(dp[j]+", ");
//            }
//            System.out.println();
            max_val = Math.max(max_val, dp[i]);
        }

        bw.write(String.valueOf(max_val));
        bw.flush();
        bw.close();
    }
}
