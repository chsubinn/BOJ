package DataStructure.BOJ_2304;

// https://www.acmicpc.net/problem/2304
// 2304번 창고 다각형

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Pair> poll = new ArrayList<>();
    static int answer = 0;

    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int max_height = Integer.MIN_VALUE;
        int max_l = N;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            poll.add(new Pair(L, H));

            if (max_height < H){
                max_height = Math.max(max_height, H);
                max_l = L;
            }
        }

        poll.sort(Comparator.comparingInt(p -> p.l));

        int left = poll.get(0).l;
        int right = poll.get(N-1).l;

        int left_max = 0;
        int right_max = 0;

        // 왼 -> 오 이동
        for (int i=0; i< poll.size(); i++){
            if (poll.get(i).l > max_l) break;

            if (poll.get(i).h > left_max) {
                answer += left_max * (poll.get(i).l - left);
                left_max = poll.get(i).h;
            }
            else {
                answer += left_max * (poll.get(i).l - left);
            }
            left = poll.get(i).l;
        }
        answer += max_height;
        // 오 -> 왼 이동
        for (int i=poll.size()-1; i>=0; i--){
            if (poll.get(i).l < max_l) break;

            if (poll.get(i).h > right_max){
                answer += right_max * (right - poll.get(i).l);
                right_max = Math.max(right_max, poll.get(i).h);
            }
            else {
                answer += right_max * (right - poll.get(i).l);
            }
            right = poll.get(i).l;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static private class Pair implements Comparable<Pair>{
        int l, h;
        Pair (int l, int h){
            this.l = l;
            this.h = h;
        }
        @Override
        public int compareTo(Pair o) {
            return this.l - o.l;
        }
    }
}
