package Greedy.BOJ_1477;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1477
// 1477번 휴게소 세우기

public class Main {
    static int answer = Integer.MAX_VALUE;
    public static void main (String [] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m, l;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int [] graph = new int [n];
        for (int i=0; i<n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);

        int [][] dist = new int [m+1][n+1];
        int [] cnt = new int [n+1];

        dist[0][0] = graph[0] - 1;
        int max_dist = 0;
        int max_index = 0; // index = 0 에는 m이 아무것도 설치되지 않았을때의 정보 저장

        for (int i=1; i<n; i++){
            dist[0][i] = graph[i] - graph[i-1];
            if (max_dist < dist[0][i]){
                max_dist = dist[0][i];
                max_index = i;
            }
        }
        dist[0][n] = l - graph[n-1];

        for (int i=1; i<m-1; i++){
            dist[i][max_index] = dist[i-1][max_index]/2;
            cnt[i]++;
            for (int j=1; j<n; j++){
                if (max_dist < dist[i][j]){
                    max_dist = dist[i][j];
                    max_index = j;
                }
            }
        }

        for (int i=0; i<n+1; i++){
            if (cnt[i]!=0) {
                dist[m][i] = dist[m][i]/cnt[i];
                answer = Math.min(answer, dist[m][i]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
