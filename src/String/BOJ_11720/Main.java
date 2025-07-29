package String.BOJ_11720;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11720
// 11720번 숫자의 합

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += numbers.charAt(i) - '0';
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
