package DP.BOJ_1965;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1965
// 1965번 상자넣기

public class Main {
    static int N;
    static int[] boxes;
    static int[] dp;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        boxes = new int [N+1];
        dp = new int [N+1]; // dp[i] 는 거기까지 올 수 있는 상자의 최대 개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<N+1; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        dp[1]=1;

        for (int i=2; i<N+1; i++){
            int max = Integer.MIN_VALUE;
            for (int j=1; j<i; j++){
                if (boxes[i] > boxes[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            if (max == Integer.MIN_VALUE){
                dp[i] = 1;
                continue;
            }
            dp[i] = max + 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i=1; i<N+1; i++){
            answer = Math.max(answer, dp[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
