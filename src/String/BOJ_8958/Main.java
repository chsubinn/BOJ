package String.BOJ_8958;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/8958
// 8958번 OX퀴즈

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int [] answer = new int [T];

        for (int i=0; i<T; i++){
            String S = br.readLine();

            int flag = 0;
            int score = 0;
            for (int j=0; j<S.length(); j++){
                if (S.charAt(j)=='O'){
                    flag++;
                }
                else if (S.charAt(j)=='X') {
                    for (int k=1; k<=flag; k++){
                        score += (k);
                    }
                    flag = 0;
                }
            }
            if (flag > 0){
                for (int k=1; k<=flag; k++){
                    score += (k);
                }
            }

            answer[i] = score;
        }

        for (int i =0; i<T; i++){
            if (i==T-1) bw.write(String.valueOf(answer[i]));
            else bw.write(answer[i]+"\n");
        }
        bw.close();
    }
}
