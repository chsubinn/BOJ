package String.BOJ_2852;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2852
// 2852번 NBA 농구

public class Main {
    static int N;
    static int score1 = 0;
    static int score2 = 0;
    static int time1 = 0;
    static int time2 = 0;
    public static void main (String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int previousTime = 0;

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int team = Integer.parseInt(st.nextToken());

            String time = st.nextToken();
            String [] times = time.split(":");
            int currentTime = Integer.parseInt(times[0]) * 60 +  Integer.parseInt(times[1]);

            if (score1 > score2){
                time1 += currentTime - previousTime;
            }
            if (score1 < score2){
                time2 += currentTime - previousTime;
            }

            if (team == 1) {
                score1++;
            }
            else {
                score2++;
            }

            previousTime = currentTime;
        }

        if (score1 > score2){
            time1 += 48 * 60 - previousTime;
        }
        if (score1 < score2){
            time2 += 48 * 60 - previousTime;
        }

        sb.append(String.format("%02d:%02d\n", time1 / 60, time1 % 60));
        sb.append(String.format("%02d:%02d\n", time2 / 60, time2 % 60));

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();


    }
}
