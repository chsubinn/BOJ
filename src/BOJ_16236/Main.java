package BOJ_16236;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16236
// 16236번 아기상어

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
                     graph[i][j]=0;
                 }
             }
         }

         // 아기 상어의 위치는 9, 그외 물고기의 위치는 크기에 따라 1~6, 아무것도 없는 곳에는 0으로 표시
        // 가장 가까이서 찾을 수 있는 물고기 위치 찾기 + 이동 (시간 추가, 물고기 위치 업데이트)

        int eaten = 0;
         while (true){
             Pair fish = findFish(cx, cy);

             if (fish == null) break;

             int fish_x = fish.x;
             int fish_y = fish.y;

             // fish가 있는 좌표까지 가는 최단 거리 구하고 해당 거리 return해서 더하기
             time += findDistance(cx, cy, fish_x, fish_y);

             cx = fish_x;
             cy = fish_y;

             graph[cx][cy] = 0;

             eaten++;

             if ( eaten == size) {
                 size++;
                 eaten = 0;
             }
         }

        bw.write(String.valueOf(time));
         bw.flush();
         bw.close();

    }

    private static int findDistance(int x, int y, int fish_x, int fish_y) {
        int[] dx = {-1, 0, 0, 1}; // 위, 왼, 오, 아래 순서로
        int[] dy = {0, -1, 1, 0};

        Queue<Pair> queue = new LinkedList();
        int[][] visited = new int[n][n];
        visited[x][y] = 1;

        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int cx = pair.x;
            int cy = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0) {
                    if (graph[nx][ny] <= size ) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        if (nx == fish_x && ny == fish_y){
                            return visited[nx][ny] - 1;
                        }
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
        return 0;
    }

    private static Pair findFish(int x, int y){
        // 아기 상어의 위치를 받아 각 조건을 만족하는 물고기의 위치를 큐에 추가

        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};

        Queue<Pair> queue = new LinkedList();
        int [][] visited = new int [n][n];

        queue.add(new Pair (x, y));

        List<Pair> candidates = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        int[][] dist = new int[n][n];
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int cx = cur.x, cy = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] != 0 || graph[nx][ny] > size) continue;

                visited[nx][ny] = 1;
                dist[nx][ny] = dist[cx][cy] + 1;

                if (graph[nx][ny] != 0 && graph[nx][ny] < size) {
                    if (dist[nx][ny] < minDistance) {
                        minDistance = dist[nx][ny];
                        candidates.clear();
                        candidates.add(new Pair(nx, ny));
                    } else if (dist[nx][ny] == minDistance) {
                        candidates.add(new Pair(nx, ny));
                    }
                }

                queue.add(new Pair(nx, ny));
            }
        }
        if (candidates.isEmpty()) return null;

        candidates.sort((a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(a.y, b.y);
        });

        return candidates.get(0);
    }

    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
