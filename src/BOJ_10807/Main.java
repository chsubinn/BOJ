package BOJ_10807;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10807
// 10807번 개수 세기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());
        int answer=0;

        for (int i=0; i<n; i++){
            if (arr[i]==v){
                answer++;
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();

    }
}