package BOJ_16236;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int size;
    static int [][] graph;
    static Queue<Pair> fishList = new LinkedList<>();

    public static void main (String args []) throws IOException {
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         n = Integer.parseInt(st.nextToken());
         graph = new int [n][n];

         int cx = 0, cy = 0; // 아기상어의 현재 위치
         size = 2; // 아기상어의 현재 크기
        int time = 0;

         for (int i=0; i<n; i++){
             st = new StringTokenizer(br.readLine(), " ");
             for (int j=0; j<n ;j++){
                 graph[i][j] = Integer.parseInt(st.nextToken());
                 if (graph[i][j] == 9){
                     cx = i;
                     cy = j;
                 }
             }
         }

         // 아기 상어의 위치는 9, 그외 물고기의 위치는 크기에 따라 1~6, 아무것도 없는 곳에는 0으로 표시
        // 가장 가까이서 찾을 수 있는 물고기 위치 찾기 + 이동 (시간 추가, 물고기 위치 업데이트)

        findFish(cx, cy);
         while (!fishList.isEmpty()){
             Pair pair = fishList.remove();
             int fish_x = pair.x;
             int fish_y = pair.y;

             // fish가 있는 좌표까지 가는 최단 거리 구하고 해당 거리 return해서 더하기
             time += findDistance(cx, cy, fish_x, fish_y);

             cx = fish_x;
             cy = fish_y;

             graph[fish_x][fish_y] = 0;

             size++;
             bw.write("("+fish_x+", "+fish_y+")");

             findFish(cx, cy);
         }

        bw.write(String.valueOf(time));
         bw.flush();
         bw.close();

    }

    private static int findDistance(int x, int y, int fish_x, int fish_y) {
        int dst = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // dfs 버전?


        // bfs 버전
        Queue<Pair> queue = new LinkedList();
        int[][] visited = new int[n][n];

        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int cx = pair.x;
            int cy = pair.y;

            visited[cx][cy] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx == fish_x && ny == fish_y){
                    return dst;
                }

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;

                    if (graph[nx][ny] <= size ) {
                        queue.add(new Pair(nx, ny));
                        dst ++;
                    }
                }

            }
        }
        return dst;
    }

    private static void findFish(int x, int y){
        // 아기 상어의 위치를 받아 각 조건을 만족하는 물고기의 위치를 큐에 추가

        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};

        Queue<Pair> queue = new LinkedList();
        int [][] visited = new int [n][n];

        queue.add(new Pair (x, y));

        while (!queue.isEmpty()){
            Pair pair = queue.remove();
            int cx = pair.x;
            int cy = pair.y;

            visited[cx][cy] = 1;

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >=0 && nx < n && ny >= 0 && ny < n && visited[nx][ny]==0){
                    visited[nx][ny] = 1;
                    queue.add(new Pair(nx, ny));
                    if (graph[nx][ny]< size && graph[nx][ny] != 0 && graph[nx][ny] != 9){
                        fishList.add(new Pair(nx,ny));

                    }
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
