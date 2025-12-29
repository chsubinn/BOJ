package Simulation.BOJ_20291;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20291
// 20291번 파일 정리

public class Main {
    static int N;
    static HashMap <String, Integer> files = new HashMap<>();

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String s = br.readLine();

            String[] file = s.split("\\.");

            files.put(file[1], files.getOrDefault(file[1], 0) + 1);
        }

        List<String> keyList = new ArrayList<>(files.keySet());

        Collections.sort(keyList);

        for (String key : keyList) {
            bw.write(key+" "+files.get(key)+"\n");
        }

        bw.flush();
        bw.close();
    }

}
