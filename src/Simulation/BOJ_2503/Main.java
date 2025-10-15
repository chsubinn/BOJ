package Simulation.BOJ_2503;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2503
// 2503번 숫자 야구
// 문제를 제대로 읽자^^

public class Main {
    static int N;
    static int [][] input;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        input = new int [N][3];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++){
            int number = input[i][0];
            int K = input[i][1];
            int B = input[i][2];

            if (i==0){
                for (int j=100; j<1000; j++) {
                    if (isMatched(number, j, K, B)) {
                        queue.add(j);
                    }
                }
            }
            else {
                int size = queue.size();
                for (int k=0; k<size; k++){
                    int j = queue.remove();
                    if (isMatched(number, j, K, B)){
                        queue.add(j);
                    }
                }
            }
//            print(queue);
        }

//        System.out.println(isMatched(489, 326, 0, 1));
//        System.out.println(isMatched(327, 621, 2, 0));
        bw.write(String.valueOf(queue.size()));
        bw.flush();
        bw.close();
    }

    private static boolean isMatched (int number, int j, int K, int B){
        String dn = String.valueOf(number);
        String dj = String.valueOf(j);

        for (int i=0; i<3; i++){
            if (dj.charAt(i) == '0') return false;
            for (int k=0; k<3; k++){
                if (i!=k && dj.charAt(k)==dj.charAt(i)) return false;
            }
        }

        int nK = 0;
        int nB = 0;

        for (int i=0; i<3; i++){
            if (dn.charAt(i) == dj.charAt(i)){
                nK++;
            }
            else {
                for (int k=0; k<3; k++){
                    if (dn.charAt(i) == dj.charAt(k)){
                        nB++;
                    }
                }
            }
        }

        return nK==K && nB==B;
    }

    private static void print (Queue<Integer> q){
        for (Integer i : q){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}
