package Simulation.BOJ_2108;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2108
// 2108번 통계학

public class Main {
    static int median, mode, range, avg;
    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int [] numbers = new int [N];
        int sum = 0;

        for (int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            list.add(numbers[i]);
            sum += numbers[i];
        }

        Arrays.sort(numbers);

        range = Math.abs(numbers[0] - numbers[N-1]);
        avg = Math.round((float) sum / N);
        median = numbers[N/2];

        int[] cnt = new int[8001];

        for (int i : list){
            cnt[i+4000]++;
        }

        int max_cnt = Arrays.stream(cnt).max().getAsInt();
        List<Integer> q = new ArrayList<>();

        for (int i=0; i<8001; i++){
            if (max_cnt == cnt[i]){
                q.add(i-4000);
            }
        }

        Collections.sort(q);
        mode = q.size()==1 ? q.get(0) : q.get(1);

        bw.write(avg+ "\n");
        bw.write(median+ "\n");
        bw.write(mode+ "\n");
        bw.write(range+ "\n");
        bw.flush();
        bw.close();
    }
}
