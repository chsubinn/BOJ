package Simulation.BOJ_20436;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20436
// 20436번 ZOAC

public class Main {
    static int answer = 0;
    static String [] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static Map<Character, Pair> keyboardMap = new HashMap<>();
    static final String LS_KEYS = "qwertasdfgzxcv";

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String ls = st.nextToken();
        String rs = st.nextToken();

        char left = ls.charAt(0);
        char right = rs.charAt(0);

        String target = br.readLine();

        for (int j=0; j<3; j++){
            for (int i=0; i<keyboard[j].length(); i++){
                char c = keyboard[j].charAt(i);

                keyboardMap.put(c, new Pair(i, j));
            }
        }

        Pair lp = keyboardMap.get(left);
        Pair rp = keyboardMap.get(right);

        for (int i=0; i<target.length(); i++){
            char t = target.charAt(i);
            Pair tp = keyboardMap.get(t);

            int left_distance = Math.abs(lp.x- tp.x) + Math.abs(lp.y - tp.y);
            int right_distance = Math.abs(rp.x- tp.x) + Math.abs(rp.y - tp.y);

            if (LS_KEYS.indexOf(t)!= -1) {
                answer += (left_distance + 1);
                lp = tp;
            }
            else {
                answer += (right_distance + 1);
                rp = tp;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
