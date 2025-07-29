package String.BOJ_10809;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10809
// 10809번 알파벳 찾기

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        int [] graph = new int [ALPHABET.length()];

        for (int i=0; i<ALPHABET.length(); i++){
            char c = ALPHABET.charAt(i);
            graph[i] = S.indexOf(c);
        }

        for (int i=0; i<ALPHABET.length(); i++){
            if (i==ALPHABET.length() -1) bw.write(String.valueOf(graph[i]));
            else bw.write(graph[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
