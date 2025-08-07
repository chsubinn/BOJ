package etc.BOJ_11286;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11286
// 11286번 절대값 힙

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if (x == 0){
                if (pq.isEmpty()) {
                    bw.write("0\n");
                }
                else{
                    bw.write(pq.remove().number+"\n");
                }
            }
            else {
                pq.add(new Pair(x, Math.abs(x)));
            }
        }

        bw.flush();
        bw.close();
    }
    static private class Pair implements Comparable<Pair>{
        int number;
        int abs;
        Pair (int number, int abs){
            this.number = number;
            this.abs = abs;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.abs != o.abs) {
                return this.abs - o.abs;
            }
            return this.number - o.number;
        }
    }
}
