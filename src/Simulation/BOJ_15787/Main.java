package Simulation.BOJ_15787;

import java.io.*;
import java.util.*;

// 15787번 기차가 어둠을 헤치고 은하수를
// https://www.acmicpc.net/problem/15787

public class Main {
    static int N, M;
    static int[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trains = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    int x1 = Integer.parseInt(st.nextToken());
                    trains[t] |= (1 << (x1 - 1));
                    break;

                case 2:
                    int x2 = Integer.parseInt(st.nextToken());
                    trains[t] &= ~(1 << (x2 - 1));
                    break;

                case 3:
                    trains[t] <<= 1;
                    trains[t] &= ((1 << 20) - 1);
                    break;

                case 4:
                    trains[t] >>= 1;
                    break;
            }
        }

        HashSet<Integer> uniqueTrains = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniqueTrains.add(trains[i]);
        }

        System.out.println(uniqueTrains.size());
    }
}