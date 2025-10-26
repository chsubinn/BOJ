package DataStructure.BOJ_2493;

import java.io.*;
import java.util.*;

// 2493번 탑
// https://www.acmicpc.net/problem/2493
// 기존 코드에서 시간 초가가 난 이유: 하나 찾을 때마다 스택을 만들어서,,

public class Main {
    static int N;
    static int[] tops;
    static int[] answer;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tops = new int [N];
        answer = new int [N];

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");
        for (int i=0; i<N; i++){
            tops[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Pair> stack = new Stack<>();

        for (int i=0; i<N; i++){
            int top = tops[i];

            // 현재 탑의 높이보다 낮으면 그냥 뽑아버려
            while (!stack.isEmpty() && stack.peek().height < top ){
                stack.pop();
            }

            if (!stack.isEmpty()){
                // 현재 탑의 높이보다 높거나 같으면 작성해
                answer[i] = stack.peek().index;
            }
            stack.push(new Pair(top, i+1));
        }


        for (int a : answer){
            System.out.print(a+" ");
        }
    }

    private static class Pair {
        int height, index;

        Pair (int height, int index){
            this.height = height;
            this.index = index;
        }
    }
}
