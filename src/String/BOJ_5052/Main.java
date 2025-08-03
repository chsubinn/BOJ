package String.BOJ_5052;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5052
// 5052번 전화번호 목록

public class Main {

    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            String [] numbers = new String [N];

            for (int j = 0; j < N; j++) {
                numbers[j] = br.readLine();
            }

            Arrays.sort(numbers);

            boolean isConsistent = true;
            for (int j = 0; j < N - 1; j++) {
                if (numbers[j + 1].startsWith(numbers[j])) {
                    isConsistent = false;
                    break;
                }
            }

            bw.write(isConsistent ? "YES\n" : "NO\n");
        }
        bw.flush();
        bw.close();
    }
}
