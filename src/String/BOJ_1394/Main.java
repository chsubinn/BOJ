package String.BOJ_1394;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1394
// 1394번 암호

public class Main {
    private static int MOD = 900528;
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String usable = br.readLine();
        String pw = br.readLine();

        int N = pw.length();
        int M = usable.length();

        long answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<M; i++){
            map.put(usable.charAt(i), i);
        }

        // 1자리부터 (N-1)자리까지 가능한 모든 암호의 개수 미리 더하기
        long pow = 1;
        for (int i = 1; i < N; i++) {
            pow = (pow * M) % MOD;
            answer = (answer + pow) % MOD;
        }

        // N자리 암호 중에서 현재 암호의 순서 구하기
        pow = 1;
        for (int i = N - 1; i >= 0; i--) {
            answer = (answer + map.get(pw.charAt(i)) * pow) % MOD;
            pow = (pow * M) % MOD;
        }

        answer = (answer + 1) % MOD;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
