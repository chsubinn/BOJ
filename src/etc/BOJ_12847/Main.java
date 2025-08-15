package etc.BOJ_12847;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12847
// 12847번 꿀 아르바이트

public class Main {
    static int N, M;
    static long [] time;
    static long  answer = Long.MIN_VALUE;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new long [N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){

            time[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = M;

        long salary = 0;
        for (int i = (int) left; i<right; i++){
            salary += time[i];
        }
        answer = Math.max(answer, salary);

        while (left <= right && right < N){
            salary -= time[left++];
            salary += time[right++];

            answer = Math.max(answer, salary);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
