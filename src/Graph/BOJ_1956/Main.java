package Graph.BOJ_1956;

// https://www.acmicpc.net/problem/1956
// 1956번 운동

import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int [][] graph;
    final static int INF = 100000000;
    static int answer = Integer.MAX_VALUE;
    public static void main (String [] args ) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken()); // v는 마을의 수, e는 도로의 수
        E = Integer.parseInt(st.nextToken());

        graph = new int [V+1][V+1];
        for (int i=0; i<V+1; i++){
            for (int j=0; j<V+1; j++){
                graph[i][j] = INF;
            }
        }


        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            graph[V][U] = D;
        }

        for (int i=1; i<V+1; i++){
            for (int j=1; j<V+1; j++){
                for (int k=1; k<V+1; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i=1; i<V+1; i++){
            for (int j=1; j<V+1; j++){
                if (i!=j)
                    answer = Math.min(answer, graph[i][j] + graph[j][i]);
            }
        }

        if (answer >= INF) answer = -1;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
