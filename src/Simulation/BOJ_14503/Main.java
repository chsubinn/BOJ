package Simulation.BOJ_14503;

// https://www.acmicpc.net/problem/14503
// 14503번 로봇 청소기

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        graph = new int[N][M]; // 1은 벽, 0은 빈칸 (최초 청소되지 않은 상태), 2는 청소된 칸
        int [][] visited = new int [N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1, 0, 1, 0}; // d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽을 바라본다
        int[] dc = {0, 1, 0, -1};

        while (true) {
            if (graph[R][C] != 1 && visited[R][C]==0) {
                visited[R][C] = 1;
                answer++;
            }
            boolean isCleanable = false;
            for (int i = 0; i < 4; i++) {
                D = (D + 3) % 4;

                int nr = R + dr[D];
                int nc = C + dc[D];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && graph[nr][nc]==0 && visited[nr][nc]==0) {
                    isCleanable = true;
                    R = nr;
                    C = nc;
                    break;
                }
            }
            if (!isCleanable) { // 청소되지 않은 빈 칸이 없는 경우 - 후진 가능하면 R, C 갱신, 그렇지 않으면 작동 멈춤
                int NR = R - dr[D];
                int NC = C - dc[D];

                if (graph[NR][NC] == 1) break;

                R = NR;
                C = NC;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}