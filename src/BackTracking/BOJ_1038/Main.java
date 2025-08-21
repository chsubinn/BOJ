package BackTracking.BOJ_1038;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1038
// 1038번 감소하는 수

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Long> q = new LinkedList<>();
        for (long i=1; i<10; i++) {
            q.add(i);
        }

        int cnt = 0;
        long result = -1;

        while (!q.isEmpty()){
            long x = q.remove();
            cnt++;
            if (cnt == N){
                result = x;
                break;
            }
            long lastDigit = x % 10;
            for (long i=0; i<lastDigit; i++){
                long nx = x * 10 + i;
                q.add(nx);
            }
        }

        if (N == 0) result = 0;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
