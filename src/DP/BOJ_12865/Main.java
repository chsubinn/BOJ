package DP.BOJ_12865;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/12865
// 12865번 평범한 배낭

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 무게 w와 가치 v
        int [][] graph = new int [n][2];
        int [] dp = new int [k+1];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<2; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            if (n==1){
                bw.write(String.valueOf(graph[i][1]));
                bw.flush();
                bw.close();
                return;
            }
        }
        for (int i=0; i<n; i++){
            dp[graph[i][0]]=graph[i][1];
        }

        for (int i=1; i<=k; i++){
            System.out.print(dp[i]);
        }
        System.out.println();


        for (int i=1; i>=k; i++){
            if (i%2==0){
                int cnt = i/2;
                for (int j=1; j<cnt; j++){
                    dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
                }
            }
            else {
                int cnt = (i - 1)/2;
                for (int j=1; j<=cnt; j++){
                    dp[i] = Math.max(dp[i]  , dp[j]+dp[i-j]);
                }
            }
            System.out.print("i="+i+": ");
            for (int m=1; m<k+1; m++){
                System.out.print(dp[m]);
            }
            System.out.print("\n");
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
    }
}
