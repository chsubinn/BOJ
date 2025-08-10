package Simulation.BOJ_18111;

// https://www.acmicpc.net/problem/18111
// 18111번 마인크래프트

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, B;
    static int [][] ground;
    static int [][] cut;
    static int [][] put;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // r
        M = Integer.parseInt(st.nextToken()); // c
        B = Integer.parseInt(st.nextToken()); // 채울 수 있는 블록 개수
        ground = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, ground[i][j]);
                min = Math.min(min, ground[i][j]);
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        for (int target = min; target <= max; target++){
            int time = 0;
            int inventory = B;

            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    int diff = ground[i][j] - target;

                    if (diff > 0){
                        time += diff * 2;
                        inventory += diff;
                    }
                    else if (diff < 0){
                        time += (-diff);
                        inventory += diff;
                    }
                }
            }
            if (inventory >= 0) { // 가능한 경우
                if (time < bestTime || (time == bestTime && target > bestHeight)) {
                    bestTime = time;
                    bestHeight = target;
                }
            }
        }
        bw.write(bestTime+" "+bestHeight);
        bw.flush();
        bw.close();
    }
}