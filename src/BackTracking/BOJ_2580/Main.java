package BackTracking.BOJ_2580;

// https://www.acmicpc.net/problem/2580
// 2580번 스도쿠

import java.util.*;
import java.io.*;

public class Main {
    static int [][] sudoku;
    public static void main (String args [] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int [9][9];
        for (int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
    }

    private static void solution (int r, int c){
        if (c == 9){
            solution(r+1, 0);
            return;
        }
        if (r == 9){
            print();
            System.exit(0);
        }

        if (sudoku[r][c] == 0){
            for (int n=1; n <=9; n++){
                if (isValid(r, c, n)){
                    sudoku[r][c] = n;
                    solution(r, c+1);
                    sudoku[r][c] = 0;
                }
            }
        }
        else{
            solution(r, c+1);
        }
    }
    private static boolean isValid(int r, int c, int n){
        for (int i=0; i<9; i++){
            if (sudoku[r][i] == n){ // 가로 방향 검증
                return false;
            }
            if (sudoku[i][c] == n){ // 세로 방향 검증
                return false;
            }
        }

        int border_c = (c/3) * 3;
        int border_r = (r/3) * 3;

        for (int i=border_r; i<border_r + 3; i++){
            for (int j=border_c; j<border_c +3 ; j++){
                if (sudoku[i][j] == n){
                    return false;
                }
            }
        }
        return true;
    }
    private static void print(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
