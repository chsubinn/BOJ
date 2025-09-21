package DP.BOJ_2240;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2240
// 2240번 자두나무
// 완전탐색하면 시간초과남..ㅎㅎㅎㅎㅎㅎ
// dp로 다시 풀게요

public class Main {
    static int T, W; // T개의 줄, W는 움직이는 횟수
    static int [] trees; // 어떤 나무에서 자두가 떨어질까?
    static int answer = 0;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        trees = new int [T];
        for (int i=0; i<T; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 1, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs (int cnt, int time, int where, int plums){
        if (time == T){
            answer = Math.max(answer, plums);
            return;
        }

        // cnt가 유지되는 경우
        dfs(cnt, time+1, where, plums+getAdd(time, where));

        // cnt+1되는 경우:
        if (cnt+1 <= W){
            dfs(cnt+1, time+1, getWhere(where), plums+getAdd(time, getWhere(where)));
        }

    }

    private static int getWhere (int where){
        return (where==1)? 2: 1;
    }
    private static int getAdd(int time, int where){
        return (trees[time] == where) ? 1:0;
    }
}
