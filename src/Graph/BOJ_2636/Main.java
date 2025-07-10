package Graph.BOJ_2636;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;

    public static void main (String args []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int [n][m];
        int cnt = 0;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1){
                    cnt ++;
                }
            }
        }

        if(cnt == 0)
            bw.write("0\n0");

        else {
            int time = 0;
            int last_cnt = 0;

            while (cnt > 0){
                // 0,0 부터 공기인거 탐색, 1이면 melt 예정에 추가 -> melt 예정인 것들 하나씩 녹이고 + 기존 너비에서 빼기
                time ++;
                last_cnt = cnt;

                Queue<Pair> melting = melt_cheese(0, 0);

                for (Pair pair : melting){
                    graph[pair.x][pair.y] = 0;
                }
                cnt -= melting.size();
            }


            bw.write(time + "\n" + last_cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static Queue<Pair> melt_cheese(int x, int y){
        Queue<Pair> melting = new LinkedList<>();
        Queue<Pair> air = new LinkedList<>();
        int [][] visited = new int [n][m];

        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};

        air.add(new Pair(x, y));
        visited[x][y]=1;

        while (!air.isEmpty()){
            Pair pair = air.remove();
            int cx = pair.x;
            int cy = pair.y;
            visited[cx][cy]=1;

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >=0 && ny <m && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    if (graph[nx][ny]==1){
                        melting.add(new Pair(nx, ny));
                    }
                    else if (graph[nx][ny]==0){
                        air.add(new Pair(nx, ny));
                    }
                }
            }
        }

        return melting;
    }
    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

