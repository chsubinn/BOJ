package Djisktra.BOJ_1261;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1261
// 1261번 알고스팟

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M;
    static int [][] graph;
    static int [][] visited;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int [M+1][N+1];
        visited = new int [M+1][N+1];

        for (int i=1; i<M+1; i++){
            Arrays.fill(visited[i], INF);
        }

        for (int i=1; i<M+1; i++){
            String line = br.readLine();
            for (int j=1; j<N+1; j++){
                graph[i][j] = line.charAt(j -1) - '0';
            }
        }

        // 0으로 가는 경우 비용 0, 1로 가는 경우 비용 1
        bfs();

        bw.write(String.valueOf(visited[M][N]));
        bw.flush();
        bw.close();

    }

    private static void bfs(){
        int [] dx = {0, 0, -1, 1};
        int [] dy = {1, -1, 0, 0};

        Deque<Pair> deque = new ArrayDeque<>();
        deque.addFirst(new Pair (1, 1));
        visited[1][1] = 0;

        while (!deque.isEmpty()){
            Pair c = deque.poll();
            int cx = c.x;
            int cy = c.y;

            if (cx == N && cy == M) return;

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx > 0 && nx <= M && ny > 0 && ny <= N && visited[nx][ny] == INF){
                    if (graph[nx][ny] == 0){
                        deque.addFirst(new Pair (nx, ny));
                        visited[nx][ny] = Math.min(visited[cx][cy], visited[nx][ny]);
                    }

                    if (graph[nx][ny] == 1){
                        deque.addLast(new Pair (nx, ny));
                        visited[nx][ny] = Math.min(visited[cx][cy]+1, visited[nx][ny]);
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
