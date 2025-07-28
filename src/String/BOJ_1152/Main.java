package String.BOJ_1152;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1152
// 1152번 단어의 개수

public class Main {
    public static void main (String [] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
        bw.close();
    }
}
