package Graph.BOJ_14226;

import java.util.*;
import java.io.*;

// 14226번 이모티콘
// https://www.acmicpc.net/problem/14226

public class Main {
    static int S;
    static int answer = Integer.MAX_VALUE;
    static int [] visited;
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        visited = new int [S+1];

        bfs();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
    private static void bfs(){
        int cnt = 1;
        int time = 0;
        int clipboard = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair (cnt, time));

        while (!q.isEmpty()) {
            // 턴 사이즈 가지고 구분
            Pair c = q.remove();

            System.out.println(c.cnt+", "+c.time);
            if (c.cnt == S) {
                answer = Math.min(answer, c.time);
                break;
            }

            if (c.cnt - 1 >= 1 && c.cnt - 1 <= S) {
                q.add(new Pair(c.cnt - 1, c.time + 1));
            }

            if (c.cnt + clipboard >= 1 && c.cnt + clipboard <= S) {
                q.add(new Pair(c.cnt + clipboard, c.time + 1));
            }

            if (c.cnt * 2 >= 1 && c.cnt*2 <= S && clipboard >=1){
                q.add(new Pair(c.cnt * 2, c.time + 2));
                clipboard = cnt * 2;
            }

            if (c.cnt + 1 >= 1 && c.cnt +1 <= S && clipboard ==0){
                q.add(new Pair(c.cnt +1, c.time + 2));
                clipboard = 1;
            }
        }
    }
    private static class Pair {
        int cnt, time;

        Pair (int cnt, int time){
            this.time = time;
            this.cnt = cnt;
        }
    }
}
