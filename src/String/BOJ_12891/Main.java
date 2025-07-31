package String.BOJ_12891;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/12891
// 12891번 DNA 비밀번호

public class Main {
    static int [] ACGT = new int [4];
    static int [] cnt = new int [4];

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;

        int S = Integer.parseInt(st.nextToken()); // DNA의 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호의 길이
        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<4; i++){
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        // sliding window
        for (int i=0; i<P; i++) {
            add(DNA.charAt(i));
        }

        if (cnt[0]>=ACGT[0] && cnt[1]>=ACGT[1] && cnt[2]>=ACGT[2] && cnt[3]>=ACGT[3]) answer++;

        for (int i=P; i<S; i++){
            remove(DNA.charAt(i-P));
            add(DNA.charAt(i));

            if (cnt[0]>=ACGT[0] && cnt[1]>=ACGT[1] && cnt[2]>=ACGT[2] && cnt[3]>=ACGT[3]) answer++;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void add (char c){
        if (c=='A') cnt[0]++;
        if (c=='C') cnt[1]++;
        if (c=='G') cnt[2]++;
        if (c=='T') cnt[3]++;
    }
    private static void remove (char c){
        if (c=='A') cnt[0]--;
        if (c=='C') cnt[1]--;
        if (c=='G') cnt[2]--;
        if (c=='T') cnt[3]--;
    }

}
