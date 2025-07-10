package BOJ_7576;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/7576
// 7576번: 토마토
// 오답 이유:  "안익은 토마토에서 익은 토마토로 갈 수 있는 최단 경로를 dist[][]에 저장한 후 -1가 있으면 -1 반환, 그렇지 않으면 max(dist[][]) 반환"
// 로직을 위해 안익은 토마토 개수만큼 bfs 실행시킴^^;
// 따라서 "익은 토마토에서 안익은 토마토 각각으로 갈 수 있는 최단 경로를 구하고 여기서 max를 구하거나  0이 남아있으면 -1 반환하는 로직으로 변경

public class Main {
    static int m, n;
    static int [][] graph;
    static int [][] distance;
    static int max_dist = -1;

    public static void main (String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int [n][m];
        distance = new int [n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // -1은 토마토가 들어있지 않는 칸, 0은 안익은 토마토, 1은 익은 토마토
        // 안익은 토마토에서 익은 토마토로 갈 수 있는 최단 경로를 dist[][]에 저장한 후 -1가 있으면 -1 반환, 그렇지 않으면 max(dist[][]) 반환
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (graph[i][j]==0){
                    System.out.println("getDistance 호출: (" + i + ", " + j + ")");
                    int dist = getDistance(i, j);
                    System.out.println(dist);
                    if (dist == -1){
                        bw.write(-1);
                        bw.flush();
                        bw.close();
                        return;
                    }
                    else{
                        max_dist = Integer.max(dist, max_dist);
                    }
                }
            }
        }
        bw.write(max_dist);
        bw.flush();
        bw.close();
    }
    private static int getDistance(int x, int y){
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        int [][] visited = new int [n][m];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = 1;

        while (!queue.isEmpty()){
            Pair pair = queue.remove();
            int cx = pair.x;
            int cy = pair.y;

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >=0 && nx < n && ny >=0 && ny < m){
                    if (graph[nx][ny]==1){
                        return distance[cx][cy] + 1;
                    }
                    else if (visited[nx][ny]==0){
                        distance[nx][ny] = distance [cx][cy] + 1;
                        visited[nx][ny] = 1;
                        queue.add(new Pair (nx, ny));
                    }
                }
            }
        }
        return -1;
    }

    private static class Pair {
        int x,y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
