package Greedy.BOJ_11501;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11501
// 11501번 주식

// 수정 전: 한번 주식이 오른 후에도 더 큰 주가가 발생할 수 있다는 점을 간과함 (예: 10 6 14)
// 수정 후: 반대로 접근하면 된다!! 천재인듯

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
        int maxPrice = 0;
        for (int i=n-1; i>=0; i--){
            if (graph[i] > maxPrice){
                maxPrice = graph[i];
            }
            else{
                profit += maxPrice - graph[i];
            }
        }
        return profit;
    }
}
