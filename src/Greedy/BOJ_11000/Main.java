package Greedy.BOJ_11000;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11000
// 11000번 강의실 배정
// 수정 전: 일반적인 큐를 이용한 풀이 ... but 시간 초과로 실패
// 수정 후: 우선순위 큐를 이용한 풀이

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [][] graph = new int [n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, Comparator
                .comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(graph[0][1]); // 가장 먼저 시작하는 수업 & 가장 먼저 끝나는 수업의 종료시간
        for(int i=1; i<n ;i++){
            if(pq.peek() <= graph[i][0]){ // 현재 가장 빨리 끝나는 강의실 종료 시간 비교 후 삭제 (가장 작은 값이 맨 위에 있음) 
                pq.poll();
            }
            pq.add(graph[i][1]); // 종료시간이 쌓이면 그게 강의실 크기가 됨 ... 종료시간이 쌓이지 않으면 그냥 교체되는거고
        }
        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
    }
}
