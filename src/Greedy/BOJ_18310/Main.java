package Greedy.BOJ_18310;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/18310
// 18310번 안테나

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int min_dist = 100000;
        int answer = 100000;

        int n = Integer.parseInt(br.readLine());
        int [] graph = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph); // 1 5 7 9
        int [] dp = new int [100001];
        Arrays.fill(dp, 100000);

        for (int i = graph[0]; i<= graph[n-1]; i++){ // i는 안테나
            int dist = 0;
            for (int j = 0; j<n; j++){
                dist += Math.abs(i-graph[j]);
            }
            dp[i] = dist;
            min_dist = Math.min(min_dist, dist);
        }

        for (int i=1; i<=100000; i++){
            if (min_dist == dp[i]){
                answer = Math.min(answer, i);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
