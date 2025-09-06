package etc.BOJ_2531;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2531
// 2531번 회전 초밥

public class Main {
    static int N, d, k, c;
    static int [] dishes;
    static int answer = Integer.MIN_VALUE;
    public static void main (String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()); // 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c

        dishes = new int [N];
        for (int i=0; i<N; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }

        // solution : 배열로 시간 단축하거나 포인터 옮겨가면서 단축하셈
//        for (int i=0; i<N; i++){
//            Set<Integer> set = new HashSet<>();
//            for (int j = i; j<i+k ;j++){
//
//                if (j > N-1){
//                    set.add(dishes[j-N]);
//                    continue;
//                }
//
//                set.add(dishes[j]);
//            }
//
//            if (!set.contains(c)){
//                set.add(c);
//            }
//            answer = Math.max(answer, set.size());
//        }

        Set<Integer> set = new HashSet<>();

        int start = 0;
        int end = k;

        for (int i=0; i<k ;i++){
            set.add(dishes[i]);
        }

        for (int i=0; i<N; i++){

            set.remove(dishes[start]);
            set.add(dishes[end]);

            if (!set.contains(c)){
                set.add(c);
            }
            answer = Math.max(answer, set.size());

            start += 1;
            end += 1;
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
