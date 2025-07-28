    package Djisktra.BOJ_31230;

    import java.io.*;
    import java.util.*;

    // https://www.acmicpc.net/problem/31230
    // 31230번 모비스터디

    public class Main {
        final static int INF = Integer.MAX_VALUE;
        static int N, M, A, B;
        static List<List<Pair>> graph = new ArrayList<>();
        static List<Integer>[] reverseGraph;
        static boolean[] visited;
        static int [] distance;
        static Set<Integer> result = new HashSet<>();

        public static void main (String [] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken()); // 도시의 개수
            M = Integer.parseInt(st.nextToken()); // 도로의 개수
            A = Integer.parseInt(st.nextToken()); // 민겸이가 사는 도시
            B = Integer.parseInt(st.nextToken()); // 시은이가 사는 도시

            for (int i=0; i<N+1; i++){
                graph.add(new ArrayList<>());
            }

            reverseGraph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                reverseGraph[i] = new ArrayList<>();
            }

            for (int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Pair (v, w));
                reverseGraph[v].add(u);
            }

            djistrka();

            visited = new boolean[N + 1];
            bfsFromB(B);  // B에서 역추적하여 최단 경로에 포함된 노드만 방문

            List<Integer> sorted = new ArrayList<>(result);
            Collections.sort(sorted);

            bw.write(sorted.size() + "\n");
            for (int node : sorted) {
                bw.write(node + " ");
            }
            bw.write("\n");

            bw.flush();
            bw.close();

            bw.flush();
            bw.close();

        }

        private static void djistrka (){
            distance = new int [N+1];
            for (int i=1; i<N+1; i++) distance[i] = INF;
            distance[A] = 0; // 거리 저장

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair (A, 0));

            while (!pq.isEmpty()){
                Pair c = pq.remove();
                int cn = c.node;
                int cd = c.dist;

                if (distance[cn] > cd) continue;

                for (Pair n : graph.get(cn)){
                    int nn = n.node;
                    int nd = n.dist + cd;

                    distance[nn] = Math.min(distance[nn], nd);
                    pq.add(new Pair (nn, nd));
                }

            }
        }

        // 역추적하면서 최단 경로에 포함된 모든 노드를 찾음
        private static void bfsFromB(int start) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            result.add(start);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int prev : reverseGraph[curr]) {
                    for (Pair p : graph.get(prev)) {
                        if (p.node == curr && distance[prev] + p.dist == distance[curr]) {
                            if (!visited[prev]) {
                                visited[prev] = true;
                                result.add(prev);
                                queue.offer(prev);
                            }
                        }
                    }
                }
            }
        }

        static class Pair implements Comparable<Pair>{
            int dist, node;
            Pair (int node, int dist){
                this.dist = dist;
                this.node = node;
            }
            @Override
            public int compareTo(Pair o) {
                return this.dist - o.dist;
            }
        }
    }
