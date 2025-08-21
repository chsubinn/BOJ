package Simulation.BOJ_1063;

// https://www.acmicpc.net/problem/1063
// 1063번 킹

import java.util.*;
import java.io.*;

public class Main {
    static int [][] graph = new int [9][9];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String king = st.nextToken();
        String rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kx = king.charAt(0) - 'A' + 1;
        int ky = king.charAt(1) - '0';
        int rx = rock.charAt(0) - 'A' + 1;
        int ry = rock.charAt(1) - '0';
        graph[kx][ky] = 1; // 킹은 1
        graph[rx][ry] = 2; // 돌은 2

        HashMap<String, Integer> move = new HashMap<>();
        move.put("R", 0); move.put("L", 1);
        move.put("B", 2); move.put("T", 3);
        move.put("RT", 4); move.put("LT", 5);
        move.put("RB", 6); move.put("LB", 7);

        int [] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int [] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        String [] dir = new String [N];

        for (int i=0; i<N; i++){
            dir[i] = br.readLine();
        }

        for (String d : dir){
            int i = move.get(d);
            int nkx = kx + dx[i];
            int nky = ky + dy[i];

            if (nkx < 1 || nkx > 8 || nky < 1 || nky > 8) continue;
            else {
                if (nkx == rx && nky == ry) {
                    int nrx = rx + dx[i];
                    int nry = ry + dy[i];
                    if (nrx < 1 || nrx > 8 || nry < 1 || nry > 8) continue;

                    rx = nrx;
                    ry = nry;
                }
                kx = nkx;
                ky = nky;
            }
        }
        System.out.println((char)(kx+'A'-1)+String.valueOf(ky));
        System.out.println((char)(rx+'A'-1)+String.valueOf(ry));
    }
}
