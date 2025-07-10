package Graph.BOJ_2178;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2178
// 2178번 미로탐색

public class Main {
    static int n, m;
    static int [][] graph;
    static int [][] visited;

    public static void main (String args []) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new int[n][m];
        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(visited[n-1][m-1]));
        bw.flush();
        bw.close();
    }
    private static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();

        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};

        visited[x][y] = 1;
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()){
            Pair pair = queue.remove();
            for (int i=0; i<4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                        queue.add(new Pair(nx, ny));
                        visited[nx][ny]=visited[pair.x][pair.y]+1;
                    }
                }
            }
        }
    }
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
