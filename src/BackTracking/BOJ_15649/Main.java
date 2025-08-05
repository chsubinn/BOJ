package BackTracking.BOJ_15649;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15649
// 15649번 N과 M (1)

public class Main {
    static int N, M;
    static int [] arr;
    static int [] visited;

    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N개의 자연수, 길이가 M인 수열을 모두 구하라
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [M];
        visited = new int [N];

        dfs(0);

        bw.flush();
        bw.close();
    }
    private static void dfs (int depth){
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]==0) {
                visited[i] = 1;

                arr[depth] = i + 1;
                dfs(depth + 1);

                visited[i] = 0; // 백트래킹!!
            }
        }

    }
}
