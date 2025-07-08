package BOJ_4963;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4963
// 4963번 섬의 개수

public class Main {
    static int w, h;
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> answer = new ArrayList<>();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0){
                break;
            }

            int [][] graph = new int [h][w];
            for (int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine() , " ");
                for (int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer.add(getNumberOfIsland(graph));
        }

        // 출력
        for (int i=0; i<answer.size(); i++){
            bw.write(String.valueOf(answer.get(i)));
            if (i!=answer.size()-1){
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static int getNumberOfIsland(int [][] graph){
        int [][] visited = new int [h][w];
        int cnt = 0;
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                if (graph[i][j] == 1 && visited[i][j]==0){
                    visited =  bfs(i, j, visited, graph);
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    private static int [][] bfs (int x, int y, int [][] visited, int [][] graph){
        int [] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int [] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

        Queue<Pair> queue  = new LinkedList<>();

        queue.add(new Pair(x ,y));

        while (!queue.isEmpty()){
            Pair pair = queue.remove();

            for (int i=0; i<8; i++){
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx >=0 && nx < h && ny >= 0 && ny < w && visited[nx][ny] == 0){
                    if (graph[nx][ny] == 1){
                        queue.add(new Pair(nx, ny));
                    }
                    visited[nx][ny] = 1;
                }
            }
        }
        return visited;
    }

    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
