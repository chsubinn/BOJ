package DP.BOJ_1149;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1149
// 1149번 RGB거리

public class Main {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [][] graph = new int [n][3];

        for (int i=0 ;i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<3; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
        for (int i = 1; i < n; i++) {
            graph[i][RED] += Math.min(graph[i - 1][GREEN], graph[i - 1][BLUE]);
            graph[i][GREEN] += Math.min(graph[i - 1][RED], graph[i - 1][BLUE]);
            graph[i][BLUE] += Math.min(graph[i - 1][RED], graph[i - 1][GREEN]);
        }
        bw.write(String.valueOf(Math.min(Math.min(graph[n - 1][RED], graph[n - 1][GREEN]), graph[n - 1][BLUE])));
        bw.flush();
        bw.close();
    }
}
