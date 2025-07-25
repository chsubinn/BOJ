package Djisktra.BOJ_18352;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/18352
// 18352번 특정 거리의 도시 찾기

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Pair>> graph = new ArrayList<>();
    static int N, M, K, X;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 정보

        for (int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Pair (1, v));
        }

        int [] answer = solution();

        int flag = 0;
        for (int i=1; i<answer.length; i++){
            if (answer[i]==K && i!= answer.length-1){
                bw.write(i+"\n");
                flag = 1;
            }
            else if (answer[i]==K && i==answer.length-1){
                bw.write(String.valueOf(i));
                flag = 1;
            }
        }
        if (flag==0) bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }

    private static int[] solution (){
        int [] answer = new int [N+1];
        for (int i=0; i<N+1; i++){
            answer[i] = INF;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, X));
        answer[X] = 0;

        while (!pq.isEmpty()){
            Pair current = pq.remove();
            int curNode = current.node;
            int curDist = current.dist;

            if (curDist > answer[curNode]) continue;

            for (Pair next : graph.get(curNode)){
                int nextNode = next.node;
                int nextDist = next.dist + curDist;

                if (nextDist < answer[nextNode]){
                    answer[nextNode] = nextDist;
                    pq.add(new Pair(nextDist, nextNode));
                }
            }
        }

        return answer;
    }

    static class Pair implements Comparable<Pair>{
        int dist, node;
        Pair (int dist, int node){
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }
}
