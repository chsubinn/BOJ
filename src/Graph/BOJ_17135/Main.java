package Graph.BOJ_17135;

// https://www.acmicpc.net/problem/17135
// 17135번 캐슬 디펜스

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D;
    static int K = 3;
    static int [][] graph;
    static int answer = 0;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int [N+1][M]; // 0은 빈칸, 1은 적이 있는 칸, 2는 성 (성에 배치 가능, 적이 성에 가면 게임에서 제외 된다), 3은 궁수의 위치
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j=0; j<M; j++){
            graph[N][j] = 2;
        }

        dfs(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth){
        if (depth == K){
            answer = Math.max(answer, getNumOfEnemies());
            return;
        }

        for (int j=start; j<M; j++){
            graph[N][j] = 3;
            dfs(j+1, depth+1);
            graph[N][j] = 2;
        }
    }

    private static int getNumOfEnemies() {
        int cnt = 0;
        int [][] copy = new int [N+1][M];
        Queue<Pair> arch = new LinkedList<>();
        Queue<Pair> killed = new LinkedList<>();

        for (int i=0; i<N+1; i++){
            for (int j=0; j<M; j++){
                copy[i][j] = graph[i][j];
                if (graph[i][j] == 3){
                    arch.add (new Pair(i, j));
                }
            }
        }

        for (int i=0; i<N; i++){
            for (Pair a : arch){
                Pair e = findTarget(a, copy);
                if (e!=null) killed.add(e);
            }

            for (Pair k : killed) {
                if (copy[k.r][k.c] == 1) {
                    cnt++;
                    copy[k.r][k.c] = 0;
                }
            }
            killed.clear();

            for (int r = N-1; r>=0; r--){
                for (int c = 0; c<M; c++){
                    if (copy[r][c] == 1){
                        if (r+1 == N){
                            copy[r][c] = 0;
                        }
                        else{
                            copy[r][c] = 0;
                            copy[r+1][c] = 1;
                        }
                    }
                }
            }
        }


        return cnt;
    }
    private static Pair findTarget (Pair arch, int [][] graph){
        int min = Integer.MAX_VALUE;
        Pair target = null;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (graph[i][j] == 1){
                    int d = Math.abs(i - arch.r) + Math.abs(j - arch.c);

                    if (d<=D){
                        if (d < min || (d == min && (target == null || j < target.c))){
                            min = d;
                            target = new Pair(i, j);
                        }
                    }

                }
            }
        }
        return target;
    }

    private static class Pair {
        int r, c;
        Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
