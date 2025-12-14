package Simulation.BOJ_1244;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1244
// 1244번 스위치 켜고 끄기

public class Main {
    static int N, K;
    static int[] switches;
    static int[][] students;
    public static void main  (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        switches = new int [N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<N+1; i++){
            switches[i] = Integer.parseInt(st.nextToken()); // 1은 켜져있음, 0은 꺼져있음
        }

        K = Integer.parseInt(br.readLine());
        students = new int [K][2];

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            students[i][0] = Integer.parseInt(st.nextToken()); // 1은 남자, 2는 여자
            students[i][1] = Integer.parseInt(st.nextToken());
        }

        // 남자는 해당 숫자의 배수에 해당하는 스위치에 상태 변환
        // 여자는 해당 숫자 기준 대칭인 스위치에 대해 모두 상태 변환

        for (int i=0; i<K; i++){
            if (students[i][0] == 1)
                male(students[i][1]);

            else
                female(students[i][1]);
        }

        for (int i=1; i<=N; i++){
            bw.write(switches[i] + "");

            if (i % 20 == 0) {
                bw.newLine();
            } else if (i != N) {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }
    private static void male (int x){
        int i = x;
        while (x <= N){
            if (switches[x]==1)
                switches[x] = 0;
            else
                switches[x] = 1;

            x += i;
        }
    }
    private static void female (int x){
        int left = x-1;
        int right = x+1;

        if (switches[x]==1)
            switches[x] = 0;
        else
            switches[x] = 1;

        while (left>=1 && right <=N ){
            if (switches[left] == switches[right]){
                if (switches[left]==1){
                    switches[left] = 0;
                }
                else{
                    switches[left] = 1;
                }

                if (switches[right]==1){
                    switches[right] = 0;
                }
                else {
                    switches[right] = 1;
                }
                left--;
                right++;
            }

            else{
                break;
            }
        }
    }
}
