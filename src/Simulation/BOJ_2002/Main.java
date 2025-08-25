package Simulation.BOJ_2002;

// https://www.acmicpc.net/problem/2002
// 2002번 추월

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static HashMap<String, Integer> dk = new HashMap<>();
    static String [] ys;
    static int answer = 0;

    public static void main (String [] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ys = new String [N];

        for (int i=0; i<N; i++){
            String number = br.readLine();
            dk.put(number, i);
        }
        for (int i=0; i<N; i++){ ys[i] = br.readLine();}

        for (int i=0; i<N; i++){
            for (int j=i+1;j<N; j++){
                if (dk.get(ys[i]) > dk.get(ys[j])){
                    answer++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
