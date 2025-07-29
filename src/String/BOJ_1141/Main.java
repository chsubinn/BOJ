package String.BOJ_1141;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1141
// 1141번 접두사

public class Main {
    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> wordSet = new HashSet<>();

        for (int i=0; i<N; i++){
            String s = br.readLine();
            wordSet.add(s);
        }

        List<String> words = new ArrayList<>(wordSet);
        words.sort((a, b) -> b.length() - a.length());

        List<String> unique = new ArrayList<>();

        for (String w : words){
            int flag = 0;
            for (String o : unique){
                if (o.startsWith(w) && !w.equals(o)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) unique.add(w);
        }

        bw.write(String.valueOf(unique.size()));
        bw.flush();
        bw.close();
    }
}

