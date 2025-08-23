package Graph.BOJ_2251;

// https://www.acmicpc.net/problem/2251
// 2251번 물통

import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static TreeSet<Integer> answerSheet = new TreeSet<>();
    static int [][][] visited;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new int [A+1][B+1][C+1];
        dfs(0, 0, C);

        for (int a : answerSheet) {
            bw.write(a+" ");
        }
        bw.flush();
        bw.close();
    }
    private static void dfs (int a, int b, int c){
        if (visited[a][b][c] == 1) return;
        visited[a][b][c] = 1;

        if (a == 0) answerSheet.add(c);

        int pour = Math.min(a, B-b);
        dfs(a - pour , b + pour, c);

        pour = Math.min(a, C-c);
        dfs(a - pour, b, c + pour);

        pour = Math.min (b, A-a);
        dfs(a + pour, b - pour, c);

        pour = Math.min(c, B-b);
        dfs(a, b +  pour, c-pour);

        pour = Math.min(b, C-c);
        dfs(a, b -pour, c + pour);

//        dfs(0, b, c+a);
//        dfs(0, b+a, c);
//        dfs(a, 0, c+b);
//        dfs(a+b, 0, c);
//        dfs(a+c, b, 0);
//        dfs(a, b+c, 0);
        // 다른 한 물통이 가득 차게 하는 경우
//        dfs(A, b - A + a, c);
//        dfs(A, b, c - A + a);
//        dfs(a - B + b, B, c);
//        dfs(a, B, c - B + b);
//        dfs(a- C + c, b, C);
//        dfs(a, b - C + c, C);
    }

}
