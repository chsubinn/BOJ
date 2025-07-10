package Graph.BOJ_1000;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1000
// 1000번 A+B

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = 0;
        int b = 0;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bw.write((a+b) + "\n");
        bw.flush();
        bw.close();
    }
}
