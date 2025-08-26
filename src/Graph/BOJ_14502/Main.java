package Graph.BOJ_14502;

// https://www.acmicpc.net/problem/14502
// 14502번 연구소

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int K = 3;
    static int answer = 0;
    static int [][] graph;

    static int [] dr = { 0, 0, -1, 1};
    static int [] dc = { 1, -1, 0, 0};
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int [N][M];

        for (int i=0; i<N ;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken()); // 0은 빈 칸, 1은 벽, 2는 바이러스 + 3개의 벽을 추가로 세울 수 있음
            }
        }

        dfs(0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    private static void dfs (int depth){
        if (depth == K){
            answer = Math.max(answer, getSafeZone());
            return;
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (graph[i][j]==0){
                    graph[i][j] = 1;
                    dfs(depth+1);
                    graph[i][j] = 0;
                }
            }
        }
    }
    private static int getSafeZone (){
        int cnt = 0;
        int [][] visited = new int [N][M];
        int [][] graph_copy = new int [N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                graph_copy[i][j] = graph[i][j];
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (graph[i][j]==2){
                    queue.add(new Pair(i ,j));
                    visited [i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()){
            Pair p = queue.remove();
            int cr = p.r;
            int cc = p.c;

            for (int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >=0 && nr < N && nc >=0 && nc < M ){
                    if (graph_copy[nr][nc] ==0 && visited [nr][nc] ==0){
                        queue.add(new Pair (nr, nc));
                        graph_copy [nr][nc] = 2;
                    }
                }
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (graph_copy [i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static class Pair {
        int r, c;
        Pair (int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
