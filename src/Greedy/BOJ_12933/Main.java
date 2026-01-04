package Greedy.BOJ_12933;

import java.io.*;

// 12933번 오리
// https://www.acmicpc.net/problem/12933

public class Main {
    static final String quack = "quack";
    static int answer = 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String duckling = br.readLine();

        int cnt = 0;

        if (duckling.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        // q, u, a, c, k 각 단계에 몇 마리의 오리가 대기 중인지 저장
        // index: q=0, u=1, a=2, c=3, k=4 (k는 완료된 오리 대기소)
        int[] stepCount = new int[5];
        int totalDucks = 0; // 필요한 총 오리 수

        for (char c : duckling.toCharArray()) {
            int idx = -1;

            if (c == 'q') idx = 0;
            else if (c == 'u') idx = 1;
            else if (c == 'a') idx = 2;
            else if (c == 'c') idx = 3;
            else if (c == 'k') idx = 4;

            if (idx == 0) {
                if (stepCount[4] > 0) {
                    stepCount[4]--; // 다 울고 쉬던 오리 재사용
                } else {
                    totalDucks++;   // 쉬던 오리 없으면 새 오리 투입
                }
                stepCount[0]++; // q 단계 오리 1마리 추가
            } else { // u, a, c, k 가 나왔을 때
                if (stepCount[idx - 1] == 0) {
                    System.out.println(-1);
                    return;
                }
                stepCount[idx - 1]--;
                stepCount[idx]++;
            }
        }

        if (stepCount[0] + stepCount[1] + stepCount[2] + stepCount[3] > 0) {
            System.out.println(-1);
        } else {
            System.out.println(totalDucks);
        }


    }
}
