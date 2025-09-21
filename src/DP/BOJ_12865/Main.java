package DP.BOJ_12865;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12865
// 12865번 평범한 배낭

public class Main {
    static int N, K;
    static int [][] items;
    static int [] backpack;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new int [N][2];
        backpack = new int [K+1]; // 무게가 k일 때의 최대 가치

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken()); // w
            items[i][1] = Integer.parseInt(st.nextToken()); // v
        }
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));

        for (int i=0; i<N; i++){
            int w = items[i][0];
            int v = items[i][1];

            for (int j=K; j>= w; j--){ // 7 - 3
                backpack[j] = Math.max(backpack[j], v + backpack[j-w]);
            }
        }

        bw.write(String.valueOf(backpack[K]));
        bw.flush();
        bw.close();
    }
}
