package Greedy.BOJ_11000;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11000
// 11000번 강의실 배정

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int [][] graph = new int [n][2];
        int [] visited = new int [n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, Comparator
                .comparingInt((int[] a) -> a[1])
                .thenComparingInt(a -> a[0]));

        Queue<Pair> queue = new LinkedList<>();


        for (int j=0; j<n; j++){
            if (visited[j]==0){
                queue.add(new Pair (graph[j][0], graph[j][1]));
                visited[j] = 1;
                while (!queue.isEmpty()){
                    Pair c = queue.remove();
                    for (int i=0; i<n; i++){
                        if (graph[i][0] >= c.y && visited[i]==0){
                            queue.add(new Pair (graph[i][0], graph[i][1]));
                            visited [i] =1;
                            break;
                        }
                    }
                }
                answer += 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
