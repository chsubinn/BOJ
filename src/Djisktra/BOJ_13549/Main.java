package Djisktra.BOJ_13549;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13549
// 13549번 숨바꼭질 3

public class Main {
    static int N, K;
    static int [] time;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int [100001];
        Arrays.fill(time, -1);

        // X * 2는 0초, X-1과 X+1은 1초 소요
        bfs();

        bw.write(String.valueOf(time[K]));
        bw.flush();
        bw.close();
    }

    private static void bfs (){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);

        time[N] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K) return;

            // 순간이동 (0초)
            if (now * 2 <= 100000 && time[now * 2] == -1) {
                time[now * 2] = time[now];
                deque.addFirst(now * 2); // 0초니까 앞에 넣기
            }

            // -1 이동 (1초)
            if (now - 1 >= 0 && time[now - 1] == -1) {
                time[now - 1] = time[now] + 1;
                deque.addLast(now - 1);
            }

            // +1 이동 (1초)
            if (now + 1 <= 100000 && time[now + 1] == -1) {
                time[now + 1] = time[now] + 1;
                deque.addLast(now + 1);
            }
        }
    }
}
