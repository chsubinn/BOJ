package Greedy.BOJ_1477;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1477
// 1477번 휴게소 세우기
// 수정 전: 직접 휴게소 개수를 늘려가면서 거리를 쪼개려고 했음,,
// 수정 후: 전체 도로의 최대 간격을 최소화하는 지점을 찾기 + 찾으면서 횟수랑 맞는지 체크하는 로직!!

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m, l;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int [] graph = new int [n+2];
        for (int i=1; i<n+1; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }
        graph[0] = 0;
        graph[n+1] = l;
        Arrays.sort(graph);

        int left = 1;
        int right = l-1;

        while (left <= right){
            int mid = (left+right)/2;
            int sum = 0;

            for (int i=1; i<graph.length; i++){
                sum += (graph[i] - graph[i-1] -1)/mid;
            }

            if (sum > m){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }


        bw.write(String.valueOf(left));
        bw.flush();
        bw.close();
    }
}
