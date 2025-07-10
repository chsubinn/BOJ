package BOJ_4179;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/4179
// 4179번 불!

public class Main {
    static int r, c;
    static char [][] graph;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char [r][c];

        int cx = 0;
        int cy = 0;
        ArrayList<Pair> fireList = new ArrayList<>();
        int time = -1;

        for (int i =0; i<r; i++){
            String line = br.readLine();
            for (int j=0; j<c; j++){
                graph[i][j] = line.charAt(j);
                if (graph[i][j]=='F'){
                    fireList.add(new Pair(i, j));
                }
                if (graph[i][j]=='J'){
                    cx = i;
                    cy = j;
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(cx, cy));

        // J의 좌표 업데이트
        while (!queue.isEmpty()){
            time++;
            // F가 존재하는 곳 매분마다 업데이트 -> 좌표를 ArrayList에 저장
            for (Pair fire : fireList){
                int fx = fire.x;
                int fy = fire.y;

                for (int i=0; i<4; i++){
                    int nx = fx+dx[i];
                    int ny = fy+dy[i];

                    if (nx >= 0 && nx<r && ny>=0 && ny <c){
                        if (graph[nx][ny] != '#' && !fireList.contains(new Pair(nx, ny))){
                            fireList.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            Pair pair = queue.remove();
            int jx = pair.x;
            int jy = pair.y;

            for (int i=0; i<4; i++){
                int njx = jx + dx[i];
                int njy = jy + dy[i];

                if (njx >= 0 && njx<r && njy>=0 && njy <c){
                    if (graph[njx][njy]=='.' && !fireList.contains(new Pair(njx, njy))){
                        jx = njx;
                        jy = njy;
                        if (njx == r-1 || njy == c-1 || njx == 0 || njy == 0){
                            bw.write(time);
                            bw.flush();
                            bw.close();
                            return;
                        }
                        queue.add(new Pair (njx, njy));
                    }
                }
            }
        }
        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
    }
    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
