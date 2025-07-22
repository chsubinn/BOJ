package Greedy.BOJ_13975;

// https://www.acmicpc.net/problem/13975
// 13975번 파일 합치기 3

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args ) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        long [] answer = new long [T];

        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            long [] graph = new long [N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++){
                graph[j] = Long.parseLong(st.nextToken());
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
    private static long solution (long [] graph, int n){
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 그래프 내용물을 싹다 우선순위 큐 안에 넣고 더할때마다 다시 넣어서 그 안에서 최솟값 갖고나오셈!! 그럴때마다 더하기값 갱신
        for (int i=0; i<n; i++){
            pq.add(graph[i]);
        }

        while (pq.size()>1){
            long x = pq.remove();
            long y = pq.remove();
            long size = x + y;
            answer += size;
            pq.add(size);
        }
        return answer;
    }
}
