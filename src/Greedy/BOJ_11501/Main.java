package Greedy.BOJ_11501;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11501
// 11501번 주식

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int [] answer = new int [T];

        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int [] graph = new int [N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++){
                graph[j] = Integer.parseInt(st.nextToken());
            }
            answer[i] = solution(graph, N);
        }

        for (int i=0; i<T; i++){
            if (i!=T-1){
                bw.write(answer[i]+"\n");
            }
            else{
                bw.write(String.valueOf(answer[i]));
            }
        }
        bw.flush();
        bw.close();
    }
    private static int solution (int [] graph, int n){
        int profit = 0;
        int cnt = 0;

        for (int i=0; i <n; i++){
            if (i < n-1){
                if (graph[i] <= graph[i+1]){
                    cnt ++;
                }
                else if (graph[i] > graph[i+1]){
                    int cost = 0;
                    for (int j=1; j<cnt+1; j++){
                        cost += graph[i-j];
                    }
                    profit += cnt * graph[i] - cost;
                    cnt = 0;
                }
            }
            if (i==n-1){
                int cost = 0;
                for (int j=1; j<cnt+1; j++){
                    cost += graph[i-j];
                }
                profit += cnt * graph[i] - cost;
            }
        }
        return profit;
    }
}
