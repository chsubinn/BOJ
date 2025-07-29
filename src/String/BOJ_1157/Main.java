package String.BOJ_1157;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1157
// 1157번 단어 공부

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine().toUpperCase();
        String ALPHABET = "ABCEDFGHIJKLMNOPQRSTUVWXYZ";
        int [] cnt = new int [ALPHABET.length()];

        for (int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            cnt[ALPHABET.indexOf(c)] ++;
        }

        int max = 0;
        char answer = 'A';

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                answer = (char)(i + 'A');
            } else if (cnt[i] == max) {
                answer = '?';
            }
        }
        
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
