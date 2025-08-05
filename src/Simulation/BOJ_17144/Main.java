package Simulation.BOJ_17144;

// https://www.acmicpc.net/problem/17144
// 17144번 미세먼지 안녕!
// 오답노트
// 1. visited가 아니라 temp 배열에 퍼진 먼지 모두 반영하고 마지막에 더해줘야 합니다 <- visited는 한번만 처리하게 하지만 우리는 여러번 먼제를 확산 시켜야 함
// 2. air refresher: 일일이 값을 넘기지 않아도,,, 된다,,,,,,,,, 그리고 마지막으로 도달하는 방향(?) 먼저 넣어줘야 덮어쓰이지 않는다,,,,,,, 

import java.util.*;
import java.io.*;

public class Main {
    static int R, C, T;
    static int [][] graph;
    static int answer = 0;
    static List<Pair> refresher = new ArrayList<>();

    public static void main (String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int [R][C];

        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<C; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == -1) {
                    refresher.add(new Pair(i, j));
                }
            }
        }
        Collections.sort(refresher);

        // answer = T초 후 남아있는 미세먼지 양

        for (int i=0; i<T; i++){
            dust();
            airRefresh();
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if (graph[i][j] != -1 ) answer+=graph[i][j];
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    static private void dust(){
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};
        int [][] visited = new int [R][C];

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if (graph[i][j] == -1 || graph[i][j] == 0) continue;

                int movingDust = graph[i][j] / 5;
                int numOfMovingDust = 0;
                int remainingDust = graph[i][j];
                for (int k=0; k<4; k++){
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;

                    if (nr>=0 && nr < R && nc >= 0 && nc < C && graph[nr][nc] != -1){
                        numOfMovingDust++;
                        visited[nr][nc] += movingDust;
                    }
                }
                visited[i][j] += graph[i][j] - movingDust * numOfMovingDust;
            }
        }

        for (Pair pair : refresher){
            visited[pair.r][pair.c] = -1;
        }

        graph = visited;
    }

    static private void airRefresh(){
        // refresher은 r 기준 오름차순, 따라서 인덱스 값이 작을수록 위에 있음!
        Pair upper = refresher.get(0);
        Pair downer = refresher.get(1);

        // for Upper
        for (int i = upper.r - 1; i > 0; i--) graph[i][0] = graph[i - 1][0]; // 위에서 아래로
        for (int j = 0; j < C - 1; j++) graph[0][j] = graph[0][j + 1]; // 오른쪽에서 왼쪽으로
        for (int i = 0; i < upper.r; i++) graph[i][C - 1] = graph[i + 1][C - 1]; // 아래에서 위로
        for (int j = C - 1; j > 1; j--) graph[upper.r][j] = graph[upper.r][j - 1]; // 

        graph[upper.r][1] = 0;  

        // 아래쪽 (시계)
        for (int i = downer.r + 1; i < R - 1; i++)  graph[i][0] = graph[i + 1][0];
        for (int j = 0; j < C - 1; j++) graph[R - 1][j] = graph[R - 1][j + 1];
        for (int i = R - 1; i > downer.r; i--) graph[i][C - 1] = graph[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) graph[downer.r][j] = graph[downer.r][j - 1];
        
        graph[downer.r][1] = 0; 
    }

    static private class Pair implements Comparable<Pair>{
        int r, c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return this.r - o.r;
        }
    }
}
