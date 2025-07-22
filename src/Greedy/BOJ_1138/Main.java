package Greedy.BOJ_1138;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1138
// 1138번 한 줄로 서기

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] graph = new int [n+1];
        int [] answer = new int [n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<n+1; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        for (int i=1; i<n+1; i++){
            if (answer[graph[i]] == 0){
                answer[graph[i]] = i;
            }
            else if (answer[graph[i]] < i){
                answer[graph[i]+i-1] = i;
            }
        }

        for (int i=0; i<n; i++){
            if (i!=n-1){
                bw.write(answer[i] + " ");
            }
            else{
                bw.write(String.valueOf(answer[i]));
            }
        }
        bw.flush();
        bw.close();
    }
}
