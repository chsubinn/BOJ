//package Graph.BOJ_16234;
//
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static int N, L, R;
//    static int [][] graph;
//    static int answer = 0;
//    static int [] dx = {0, 0, -1, 1};
//    static int [] dy = {0, 0, 1, -1};
//
//    public static void main (String [] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken());
//        L = Integer.parseInt(st.nextToken());
//        R = Integer.parseInt(st.nextToken()); // 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//
//        graph = new int [N][N];
//        for (int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j=0; j<N; j++){
//                graph[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        while (true){
//            if (!isOpened()) break;
//
//            answer++;
//            movePopularity();
//        }
//
//        bw.write(String.valueOf(answer));
//        bw.flush();
//        bw.close();
//    }
//    private static boolean isOpened(){
//        int [][] visited = new int [N][N];
//        Queue<Pair> queue = new LinkedList<>();
//
//        visited[0][0] = 1;
//        queue.add(new Pair(0, 0));
//
//        while (!queue.isEmpty()){
//            Pair p = queue.remove();
//
//            for (int i=0; i<4; i++){
//                int nx = p.x + dx[i];
//                int ny = p.y + dy[i];
//
//                if (nx>=0 && nx <N && ny>=0 && ny<N){
//                    if (visited[nx][ny] == 0 && Math.abs(graph[nx][ny] - graph[p.x][p.y]) >= L && Math.abs(graph[nx][ny] - graph[p.x][p.y]) <= R){
//                        visited[nx][ny] = 1;
//                        queue.add(new Pair(nx, ny));
//                    }
//                    else{
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    private static void movePopularity() {
//        // bfs 가지고 연합 구하기, 연합 구했으면 연합 안의 인구 수 조정 -> 여러번 연합에 체크될수도 있으니까 visited 배열 쓰기!
//        int [][] visited = new int [N][N];
//        Queue<Pair> queue = new LinkedList<>();
//        Queue<Pair> union = new LinkedList<>();
//
//        visited[0][0] = 1;
//        queue.add(new Pair(0, 0));
//
//        while (!queue.isEmpty()){
//
//            }
//        }
//
//    }
//    private static class Pair {
//        int x, y;
//        Pair (int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
