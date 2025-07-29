package String.BOJ_5582;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5582
// 5582번 공통 부분 문자열

// 수정 전: 브루트포스 방식, O(n^3)의 시간복잡도이므로 최대 문자열 길이 50만 처리 가능 -> 시간초과 발생
// 수정 후: DP로 구현하여 O(n*m)의 시간복잡도,,

public class Main {
    public static void main (String args []) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        int N = A.length();
        int M = B.length();

        int[][] dp = new int[N + 1][M + 1]; // dp[i][j] = A의 i번째 문자까지와 B의 j번쨰 문자까지 중 가장 긴 공통 부분 문자열의 길이
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}
