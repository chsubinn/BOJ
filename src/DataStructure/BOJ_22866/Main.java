package DataStructure.BOJ_22866;

import java.util.*;
import java.io.*;

// 22866번 탑 보기
// https://www.acmicpc.net/problem/22866
// 시간 초과 이유: stack에 push할때마다 반복문이 돌아가서 -> 스택의 사이즈로?

public class Main {
    static int N;
    static int[] tops;
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tops = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            tops[i] = Integer.parseInt(st.nextToken());
            answer.add(new ArrayList<>()); // 가까운 건물, 작은 번호로 출력
        }

        Stack<Pair> left = new Stack<>();
        for (int i=0; i<N; i++){
            int top = tops[i];

            while (!left.isEmpty() && left.peek().height <= top){
                left.pop();
            }

            if (!left.isEmpty()){
                for (Pair p : left) {
                    answer.get(i).add(p.index);
                }
            }

            left.push(new Pair(top, i+1));
        }


        Stack<Pair> right = new Stack<>();
        for (int i=N-1; i>=0; i--){
            int top = tops[i];
            while (!right.isEmpty() && right.peek().height <= top){
                right.pop();
            }

            if (!right.isEmpty()){
                for (Pair p : right) {
                    answer.get(i).add(p.index);
                }
            }

            right.push(new Pair(top, i+1));
        }


        for (int i=0; i<N; i++){
            ArrayList<Integer> arr = answer.get(i);

            int index = i+1;

            if (arr.isEmpty()){
                System.out.println(0);
                continue;
            }
            System.out.print(arr.size()+" "+ getIndexOfTop(arr, index));
            System.out.println();
        }
    }

    private static int getIndexOfTop(ArrayList<Integer> arr, int index) {
        int min_distance = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int a : arr){
            int dist = Math.abs(a-index);
            if (min_distance > dist){
                min_distance = dist;
                result = a;
            } else if ( dist == min_distance ){
                result = Math.min(result, a);
            }
        }
        return result;
    }

    private static class Pair {
        int height, index;

        Pair (int height, int index){
            this.height = height;
            this.index = index;
        }
    }
}
