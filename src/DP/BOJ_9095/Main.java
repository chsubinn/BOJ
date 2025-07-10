package DP.BOJ_9095;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int [] arr = new int [T+1];
        int [] answer = new int [T+1];
        for (int i=0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            answer[i] = solution(arr[i]);
        }

        for (int i=0; i<T; i++){
            bw.write(String.valueOf(answer[i]));
            if (i<T-1){
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static int solution(int x){
        int [] dp = new int [x+1];
        dp[1] = 1;
        // dp [2] = 1+1 = 2 -> 2
        // dp [3] = 2+1 = 1+1+1 = 1+2 = 3 -> 4
        // dp [4] = 7
        // dp [5] 13
        // dp [6] 24
        // ...

        for (int i=2; i<=x; i++){
            if (i == 2){
                dp[i] = 2;
            }
            else if (i ==3){
                dp[i] = 4;
            }
            else {
                dp[i] = dp[i-2] + dp[i-1] + dp[i-3];
            }
//            System.out.print(dp[i]);
        }
        return dp[x];
    }
}
