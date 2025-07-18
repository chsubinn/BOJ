package Greedy.BOJ_1026;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1026
// 1026번 보물

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] A = new int[n];
        int [] B = new int[n];
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // 0 1 1 1 6
        Arrays.sort(B);

        for (int i=0; i<n; i++){
            answer += A[i] * B[n-i-1];
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
