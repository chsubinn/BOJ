package BOJ_4179;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/4179
// 4179번 불!
// 오답 이유
// 불 관련 자료구조로 Queue 대신 ArrayList 사용 & 반복문을 돌면서 즉시 List 수정
//    -> 이렇게 하면 순회 도중 리스트가 변해서 순회가 끝나지 않거나 불이 한꺼번에 여러 칸을 뚫고 퍼지게 된다
// size 동적으로 가져가면 역시 순회 도중 큐의 사이즈 변경되므로 .... 문제 발생

public class Main {
    static int r, c;
    static char [][] graph;
    static int [][] visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char [r][c];
        visited = new int[r][c];

        int time = 0;

        Queue<Pair> fireQueue = new LinkedList<>();
        Queue<Pair> Jqueue = new LinkedList<>();

        for (int i =0; i<r; i++){
            String line = br.readLine();
            for (int j=0; j<c; j++){
                graph[i][j] = line.charAt(j);
                if (graph[i][j]=='F'){
                    fireQueue.add(new Pair(i, j));
                }
                if (graph[i][j]=='J'){
                    Jqueue.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        while (!Jqueue.isEmpty()){
            int fireSize = fireQueue.size();
            // F가 존재하는 곳 매분마다 업데이트
            for (int i=0; i<fireSize; i++){ // 정해진 만큼만 하기, 퍼지는 거 xx
                Pair fire = fireQueue.remove();
                for (int j=0; j<4; j++){
                    int nx = fire.x+dx[j];
                    int ny = fire.y+dy[j];

                    if (nx >= 0 && nx<r && ny>=0 && ny <c){
                        if (graph[nx][ny] == '.' ){
                            graph[nx][ny] = 'F';
                            fireQueue.add(new Pair(nx, ny));
                        }
                    }
                }
            }

            // J 이동
            int jSize = Jqueue.size();
            for (int i = 0; i < jSize; i++) {
                Pair pair = Jqueue.remove();
                int jx = pair.x;
                int jy = pair.y;

                for (int j=0; j<4; j++){
                    int njx = jx + dx[j];
                    int njy = jy + dy[j];

                    if (njx < 0 || njx >= r || njy < 0 || njy >= c){
                        bw.write(String.valueOf(time+1));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    if (graph[njx][njy] == '.' && (visited[njx][njy]==0)) {
                        visited[njx][njy] = 1;
                        Jqueue.add(new Pair(njx, njy));
                    }
                }
            }
            time++;
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
