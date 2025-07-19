package Greedy.BOJ_1541;

import java.io.*;

// https://www.acmicpc.net/problem/1541
// 1541번 잃어버린 괄호

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        String line = br.readLine();
        String [] lines = line.split("-");

        for (int i=0; i<lines.length; i++){
//            if (i==0) { answer += Integer.parseInt(lines[i]);}
//            else{
//                String [] plus = lines[i].split("\\+");
//
//                int value = 0;
//                for (int j=0; j<plus.length; j++){
//                    value+=Integer.parseInt(plus[i]);
//                }
//                answer -= value;
//            }
            String[] plus = lines[i].split("\\+");
            int value = 0;

            for (int j = 0; j < plus.length; j++) {
                value += Integer.parseInt(plus[j]);
            }

            if (i == 0) answer += value;
            else answer -= value;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
