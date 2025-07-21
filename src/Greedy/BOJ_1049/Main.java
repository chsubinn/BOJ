package Greedy.BOJ_1049;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1049
// 1049번 기타줄

public class Main {
    public static void main (String [] args ) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] six = new int [m];
        int [] one = new int [m];

        // [0]에는 6개당 가격
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            six[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(six); Arrays.sort(one);

        if (one[0] * 6 >= six[0]){
            answer = six[0] * (n / 6) + one[0] * (n%6);
            if (one[0] * (n % 6) > six[0]){
                answer = six[0] * (n / 6 +1);
            }
        }
        else {
            answer = one[0] * n;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
