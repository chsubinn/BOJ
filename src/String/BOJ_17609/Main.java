package String.BOJ_17609;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17609
// 17609번 회문

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String [] S = new String [T];

        for (int i=0; i<T; i++){
            S[i] = br.readLine();
            System.out.println(solution(S[i]));
        }
    }
    private static int solution (String s){
        int left = 0;
        int right = s.length()-1;

        while (left<right) {
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                if (isPseudo(s, left+1, right) || isPseudo(s, left, right-1)){
                    return 1;
                }
                else {
                    return 2;
                }
            }
        }
        return 0;
    }
    static boolean isPseudo(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
