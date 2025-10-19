package Simulation.BOJ_5212;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5212
// 5212번 지구 온난화

public class Main {
    static int R, C;
    static char[][] map;
    static Queue<Pair> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char [R][C];

        for (int i=0; i<R; i++){
            String line = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if (map[i][j] == 'X'){
                    // check if it turns to '.' (1) 3면 이상이 바다 (2) 지도의 범위와 맞닿음


                }
            }
        }
        int xr = Integer.MIN_VALUE;
        int xc = Integer.MIN_VALUE;
        int ir = Integer.MAX_VALUE;
        int ic = Integer.MAX_VALUE;

        for (Pair p : queue) {
            map[p.r][p.c] = '.';

            xr = Math.max(xr, p.r);
            ir = Math.min(ir, p.r);
            xc = Math.max(xc, p.c);
            ic = Math.min(ic, p.c);
        }
        for (int i=ir; i<=xr; i++){
            for (int j=ic; j<xc; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    private class Pair {
        int r, c;
        Pair (int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
