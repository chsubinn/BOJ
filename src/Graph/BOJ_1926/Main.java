package Graph.BOJ_1926;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1926
// 1926번 그림

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [][] graph = new int [n][m];
        int [][] visited = new int [n][m];

        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};

        Queue<Pair> queue = new LinkedList<>();

        int numOfPic = 0;
        int maxSize = 0;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (graph[i][j]==1 && visited[i][j]==0){
                    int size = 0;

                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()){
                        Pair pair = queue.remove();
                        size++;

                        for (int k=0; k<4; k++){
                            int nx = pair.x +dx[k];
                            int ny = pair.y + dy[k];

                            if (nx>=0 && nx <n && ny >= 0 && ny < m){
                                if (graph[nx][ny]==1 && visited[nx][ny]==0){
                                    queue.add(new Pair(nx, ny));
                                    visited[nx][ny]=1;
                                }
                            }
                        }
                    }
                    numOfPic++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }



        bw.write(numOfPic + "\n" + maxSize);
        bw.flush();
        bw.close();
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
