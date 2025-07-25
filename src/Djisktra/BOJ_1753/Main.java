package Djisktra.BOJ_1753;

import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static List<List<Pair>> graph = new ArrayList<>();
    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        for (int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Pair(w, v));
        }

        int [] answer = solution(V, K);

        for (int i=1; i<V+1; i++){
            if (i!=V) {
                if (answer[i]==INF) bw.write("INF\n");
                else bw.write(answer[i]+"\n");
            }

            else {
                if (answer[i]==INF) bw.write("INF");
                else bw.write(String.valueOf(answer[i]));
            }
        }
        bw.flush();
        bw.close();
    }

    private static int[] solution (int V, int K){
        int [] answer = new int [V+1];

        for (int i=0; i<V+1; i++){
            if (i!=K) answer[i] = INF;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair (0, K));
        answer[K] = 0;

        while (!pq.isEmpty()){
            Pair c = pq.remove();
            int dist = c.dist;
            int node = c.node;

            if (dist > answer[node]) continue; // 이미 짧은 경로로 방문했다면 굳이 방문할 필요가 없음

            for (Pair n : graph.get(node)){ // 해당 노드와 연결되어있는 다른 노드의 노드 인덱스와 가중치 돌면서 newDist 찾기 
                int newNode = n.node;
                int newDist = dist + n.dist;

                if (newDist < answer[newNode]){
                    answer[newNode] = newDist;
                    pq.add(new Pair(newDist, newNode));
                }
            }

        }

        return answer;
    }

    static class Pair implements Comparable<Pair> {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist; // 거리를 기준으로 오름차순 정렬
        }
    }
}
