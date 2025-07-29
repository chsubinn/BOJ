package String.BOJ_5582;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5582
// 5582번 공통 부분 문자열

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int answer = 0;
        String [] string = new String [2];
        string[0] = br.readLine();
        string[1] = br.readLine();

        Arrays.sort(string, Comparator.comparingInt(String::length));
        int N = string[0].length();
        int M = string[1].length();

        for (int i=N; i>0; i--){
            for (int k=0; k<=N-i; k++){
                String slice0 = string[0].substring(k, k+i);
                for (int j=0; j<M-i; j++){
                    String slice1 = string[1].substring(j, j+i);
                    if (slice0.equals(slice1)){
                        answer = Math.max(answer, i);
                        break;
                    }
                }
                if (answer==i) break;
            }
            if (answer>0) break;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}
