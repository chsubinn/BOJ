package DP.BOJ_9251;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9251
// 9251번 LCS

public class Main {
    static String str1, str2;
    static char [] arr1, arr2;
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();

        int [] dp = new int [arr1.length]; // 해당 인덱스에서부터 발생할 수 있는 공통부분 수열의 최댓값

        // ACAYKP
        // CAPCAK
        // ACAK -> 꼭 붙어있을 필요가 없자나,, 그냥 그 뒤에 인덱스에서 해당 글자가 발생하면 되는거잔아

        for (int i=0; i<arr1.length; i++){
            // 첫번째 글자가 두번째 수열에 있으면 해당 인덱스부터 탐색
            // i부터 글자수 늘려가면서 탐색!!
            int final_i = i;
            if (str2.chars().anyMatch(x -> x==arr1[final_i])){
                int index = str2.indexOf(arr1[i]);

                for (int j=index; j<arr2.length; j++){
                    int final_j = j;
                    if (str2.chars().anyMatch(x -> x==arr1[final_j])){
                        dp[i]++;

                    }
                }
            }

        }

        int max_val = 0;
        for (int i=0; i<dp.length; i++){
            max_val = Math.max(max_val, dp[i]);
        }

        bw.write(String.valueOf(max_val-1));
        bw.flush();
        bw.close();
    }
    private static void LCS (int x, int y){
        for (int i=0; i< arr1.length; i++){

        }
    }
}
