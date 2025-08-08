package BackTracking.BOJ_6987;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16987
// 16987번 계란으로 계란치기

public class Main {
    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static int answer = 0;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg (s, w));
        }

        int idx = 0;

        solution(idx);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void solution(int idx){
        if (idx == N) {
            answer = Math.max(answer, check());
            return;
        } // 오른쪽끝까지 오면 answer 반환

        if (eggs.get(idx).S <= 0) solution(idx+1); // 현재 계란이 깨진 상태면 깨진 계란의 오른쪽 계란으로 깨기

        else{
            boolean isBroken = false; // 현재 계란으로 다른 계란을 한번이라도 깼는지?
            for (int i=0; i<N; i++){
                if (i!=idx && eggs.get(i).S > 0){
                    isBroken = true;

                    eggs.get(idx).updateS(eggs.get(i).W);
                    eggs.get(i).updateW(eggs.get(idx).S);

                    solution(idx + 1); // 깨고 다음 계란으로 넘어가

                    eggs.get(idx).plusW(eggs.get(i).S);
                    eggs.get(i).plusS(eggs.get(idx).W);
                }
            }

            if (!isBroken) { // 깨지 못하면 다음 계란으로 넘어가기
                solution(idx+1);
            }
        }
    }

    private static int check(){
        int cnt = 0;
        for (Egg e : eggs){
            if (e.S <= 0){
                cnt ++;
            }
        }
        return cnt;
    }

    static private class Egg {
        int S, W;
        Egg (int S, int W){
            this.S = S;
            this.W = W;
        }
        void updateS (int mS){
            this.S -= mS;
        }
        void updateW (int mW){
            this.W -= mW;
        }
        void plusS (int mS){
            this.S += mS;
        }
        void plusW (int mW){
            this.W += mW;
        }
    }
}
