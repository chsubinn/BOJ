package etc.BOJ_1189;

// https://www.acmicpc.net/problem/1189
// 1189번 컴백홈

import java.util.*;
import java.io.*;

public class Main {
    static int R, C, K;
    static int [][] graph;
    static int [][] visited;
    static int answer = 0;

    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 왼쪽 아래 -> 오른쪽 위로 이동할 때 거리가 K인 가짓수 구하기

        graph = new int [R][C];
        visited = new int [R][C];

        for (int i=0; i<R; i++){
            String line = br.readLine();
            for (int j=0; j<C; j++){
                if (line.charAt(j) == '.') graph[i][j] = 0;
                if (line.charAt(j) == 'T') graph[i][j] = 1;
            }
        }

        Pair start = new Pair (R-1, 0);
        Pair end = new Pair (0, C-1);

        visited[start.x][start.y] = 1;
        dfs(start, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    private static void dfs (Pair start, int depth){
        // 거리가 K이고 도착지점이 end 이면 끝내기
        if (depth == K && start.x == 0 && start.y == C-1){
            answer ++;
            return;
        }

        for (int i=0; i<4; i++){
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if (nx >=0 && nx < R && ny >=0 && ny < C){
                if (graph[nx][ny] != 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    dfs(new Pair(nx, ny), depth+1);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
