package Simulation.BOJ_3190;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3190
// 3190번 뱀

public class Main {
    static int N, K, L;
    static int [][] graph;
    static Queue<Move> moveList = new LinkedList<>();
    static Deque<Pair> snake = new ArrayDeque<>();

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int [N][N];
        K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) -1 ;
            int c = Integer.parseInt(st.nextToken()) -1;
            graph[r][c] = 1; // 사과는 1, 빈칸은 0
        }

        L = Integer.parseInt(br.readLine()); // 방향 변환 횟수: X초 후에 왼쪽(L), 오른쪽(D) 방향으로 90도 방향 회전
        for (int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            moveList.add(new Move(X, C));
        }

        // 뱀 초기 설정: 위치(0,0) 뱀의 길이는 1, 뱀의 방향 D.
        snake.add(new Pair(0, 0));
        int d = 0;

        int time = 0;

        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1,  0};

        while (true){
            time++;
            Pair head = snake.peekFirst();

//            System.out.println(head);

            int nr = head.r + dr[d];
            int nc = head.c + dc[d];

//            System.out.print(new Pair(nr, nc));
//            System.out.println("->" + isValid(nr, nc));

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || !isValid(nr, nc)) break;

            if (graph[nr][nc] == 1){
                graph[nr][nc] = 0;
                snake.addFirst(new Pair(nr, nc));
            }
            else{
                snake.addFirst(new Pair(nr, nc));
                snake.removeLast();
            }

            if (!moveList.isEmpty()){
                if (moveList.peek().t == time){
                    Move m = moveList.remove();

                    if (m.d == 'D') d = (d + 1) % 4;
                    else d = (d + 3) % 4;
                }
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    private static boolean isValid(int r, int c){
        for (Pair p : snake){
            if (p.r == r && p.c == c){
                return false;
            }
        }
        return true;
    }

    private static class Pair {
        int r, c;
        Pair (int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "("+this.r + ", "+this.c+")";
        }
    }
    private static class Move {
        int t;
        char d;
        Move (int t, char d){
            this.t = t;
            this.d = d;
        }
    }
}
