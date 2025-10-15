package Simulation.BOJ_1913;

import java.io.*;

// https://www.acmicpc.net/problem/1913
// 1913번 달팽이

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int[][] snail = new int [N][N];
        int x = 0, y=0;

        // 달팽이 만드는 로직
        int cnt = N * N;
        int d = 0;
        int r = 0, c = 0;

        while (cnt > 0) {
            snail[r][c] = cnt;

            int nr = r + dx[d];
            int nc = c + dy[d];

            if (nr < 0 || nr >= N || nc <0 || nc >= N || snail[nr][nc]!=0){
                d = (d+1)%4;

                nr = r + dx[d];
                nc = c + dy[d];
            }
            r = nr;
            c = nc;
            cnt--;
        }

        for (int i = 0; i<N; i++){
            for (int j=0; j<N; j++){
                System.out.print(snail[i][j]+" ");
                if (snail[i][j] == D){
                    x = i+1;
                    y = j+1;
                }
            }
            System.out.println();
        }
        System.out.println(x+" "+y);
    }
}
