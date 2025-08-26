package etc.BOJ_2630;

// https://www.acmicpc.net/problem/2630
// 2630번 색종이 만들기

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] paper;

    static int white = 0;
    static int blue = 0;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        paper = new int [N][N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkPaper(0, N, 0, N);

        bw.write(white+"\n");
        bw.write(String.valueOf(blue));
        bw.flush();
        bw.close();
    }
    private static void checkPaper(int left, int right, int up, int down){
        int first = paper[left][up];
        boolean isBlue = (first == 1);
        boolean isWhite = (first == 0);
        boolean isSame = true;

        for (int i=left; i<right; i++){
            for (int j=up; j<down; j++){
                if (first != paper[i][j]){
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame){
            if (isBlue) blue++;
            if (isWhite) white++;
            return;
        }

        int midR = (left+right)/2;
        int midC = (up+down)/2;

        checkPaper(left, midR, up, midC);
        checkPaper(left, midR, midC, down);
        checkPaper(midR, right, midC, down);
        checkPaper(midR, right, up, midC);

    }
}
