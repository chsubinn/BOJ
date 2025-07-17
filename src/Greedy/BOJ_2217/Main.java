package Greedy.BOJ_2217;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2217
// 2217번 로프

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] ropes = new int [n];
        for (int i=0; i<n; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);

        int answer = 0;
        for (int i=0; i<n; i++){
            int cnt = (n - i) * ropes[i];
            answer = Math.max(answer, cnt);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
