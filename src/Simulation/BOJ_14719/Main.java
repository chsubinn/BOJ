package Simulation.BOJ_14719;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14719
// 14719번 빗물

public class Main {
    static int H, W;
    static int [] input;
    static int [][] graph;
    static int answer = 0;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        input = new int [W];
        graph = new int [H][W];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<W; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<W; i++){
            for (int j=0; j<input[i]; j++){
                graph[H-j-1][i] = 1; // 1은 블록, 0은 빈 칸
            }
        }

        for (int i=0; i<H; i++){
            boolean flag = false;
            List<Integer> pending = new ArrayList<>();

            for (int j=0; j<W; j++){
                if (graph[i][j] == 1){
                    if (flag){
                        answer += pending.size();
                        pending.clear();
                    }
                    flag = true;
                }
                else if (graph[i][j] == 0 && flag){
                    pending.add(j);
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
