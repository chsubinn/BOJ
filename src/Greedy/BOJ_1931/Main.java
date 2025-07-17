package Greedy.BOJ_1931;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1931
// 1931번 회의실 배정

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [][] schedule = new int [n][2];
        int answer = 0;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(schedule, Comparator
                .comparingInt((int[] a) -> a[1])      // 두 번째 인덱스 기준
                .thenComparingInt(a -> a[0]));        // 같으면 첫 번째 인덱스 기준

        int flag =0;
        for (int i = 0; i<n; i++){
//            System.out.println("i: "+schedule[i][0]+", flag: "+flag+", answer="+answer);
            if (schedule[i][0] >= flag){
                answer+=1;
                flag = schedule[i][1];
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
