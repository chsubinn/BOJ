package Simulation.BOJ_17144;

// https://www.acmicpc.net/problem/17144
// 17144번 미세먼지 안녕!

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
                visited[i][j] = 1;

                if (graph[i][j] == -1 || graph[i][j] == 0) continue;

                int movingDust = graph[i][j] / 5;
                int numOfMovingDust = 0;
                int remainingDust = graph[i][j];
                for (int k=0; k<4; k++){
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;

                    if (nr>=0 && nr < R && nc >= 0 && nc < C && graph[nr][nc] != -1 && visited[nr][nc]!=1){
                        numOfMovingDust++;
                        graph[nr][nc] += movingDust;
                        visited[nr][nc] = 1;
                    }
                }
                remainingDust -= movingDust * numOfMovingDust;
                graph[i][j] = remainingDust;
            }
        }
    }

    static private void airRefresh(){
        // refresher은 r 기준 오름차순, 따라서 인덱스 값이 작을수록 위에 있음!
        Pair upper = refresher.get(0);
        Pair downer = refresher.get(1);

        int [] drForUpper = {0, 1, 0, -1};
        int [] dcForUpper = {1, 0, -1, 0};
        int [] drForDowner = {0, -1, 0, 1};
        int [] dcForDowner = {1, 0, -1, 0};

        // for Upper
        int prev = 0;
        for (int d = 0; d<4; d++){
            int ni = upper.r + drForUpper[d];
            int nj = upper.c + dcForUpper[d];
            while (ni >= 0 && ni < R && nj>=0 && nj<C && ni!=upper.r && nj != upper.c){

                int temp = graph[ni][nj];
                graph[ni][nj] = prev;
                prev = temp;

                ni += drForUpper[d];
                nj += dcForUpper[d];
            }
        }

        // for Downer
        prev = 0;
        for (int d = 0; d<4; d++){
            int ni = downer.r + drForDowner[d];
            int nj = downer.c + dcForDowner[d];
            while (ni >= 0 && ni < R && nj>=0 && nj<C && ni!=downer.r && nj != downer.c){

                int temp = graph[ni][nj];
                graph[ni][nj] = prev;
                prev = temp;

                ni += drForDowner[d];
                nj += dcForDowner[d];
            }
        }
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
