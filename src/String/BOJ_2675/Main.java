package String.BOJ_2675;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2675
// 2675번 문자열 반복

public class Main {
    static int T, R;
    static String S;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            StringBuilder sb = new StringBuilder();
            char [] C = S.toCharArray();

            for (int j=0; j<S.length(); j++){
                for (int k=0; k<R; k++){
                    sb.append(C[j]);
                }
            }

            if (i==T-1) bw.write(String.valueOf(sb));
            else bw.write(sb+"\n");
        }
        bw.flush();
        bw.close();
    }
}
