package BackTracking.BOJ_15686;

// https://www.acmicpc.net/problem/15686
// 15686번 치킨 배달

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int [][] city;
    static ArrayList<Pair> homes = new ArrayList<>();
    static ArrayList<Pair> chickens = new ArrayList<>();
    static int [] visited;
    static PriorityQueue<Integer> answerSheet = new PriorityQueue<>();

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // N은 도시 크기
        M = Integer.parseInt(st.nextToken()); // M은 치킨 집 개수

        city = new int [N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer( br.readLine(), " ");
            for (int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) homes.add(new Pair(i , j));
                if (city[i][j] == 2) chickens.add(new Pair(i , j));
            }
        }
        visited = new int[chickens.size()];

        dfs(0, 0);

//        for (int n : answerSheet){
//            System.out.println(n);
//        }

        bw.write(String.valueOf(answerSheet.remove()));
        bw.flush();
        bw.close();
    }
    private static void dfs (int start, int depth){
        if (depth == M) {
            answerSheet.add(getDistances());
            return;
        }
        for (int i=start; i<chickens.size(); i++){
            visited[i] = 1;
            dfs(i+1, depth+1);
            visited[i] = 0;
        }
    }
    private static int getDistances (){
        int answer = 0;

        for (Pair h : homes){
            answer += getDistance(h);
        }
        return answer;
    }

    private static int getDistance(Pair home){
        int min_distance = Integer.MAX_VALUE;
        for (int i=0; i<chickens.size(); i++){
            if (visited[i] == 1) {
                min_distance = Math.min(min_distance, getDist(home, chickens.get(i)));
            }
        }
        return min_distance;
    }
    private static int getDist(Pair home, Pair chicken){
        return Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
    }

    private static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
