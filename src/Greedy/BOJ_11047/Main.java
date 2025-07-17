package Greedy.BOJ_11047;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11047
// 11047번 동전 0

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] coins = new int [n];
        for (int i=n-1; i>=0; i--){
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0; i<n; i++){
            if (coins[i] <= k) {
                int val = (k - (k%coins[i]))/coins[i]; // 몫만 구하기
                answer += val;
                k -= val * coins[i];
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
