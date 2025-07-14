package DP.BOJ_12865;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/12865
// 12865번 평범한 배낭

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] w = new int [n+1];
        int [] v = new int [n+1];
        int [] dp = new int [k+1];

        for (int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n+1; i++){
            for (int j=k; j-w[i]>=0; j--){ // i번 아이템을 넣어도 되는 한에서 반복문 실행
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]); // i번 아이템을 넣을만한 무게가 남아있는데 dp로 확인하고 해당 가치 더하기
            }
        }
        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
    }
}
