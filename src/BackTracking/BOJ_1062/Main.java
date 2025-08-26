package BackTracking.BOJ_1062;

// https://www.acmicpc.net/problem/1062
// 1062번 가르침

import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static String [] words;
    static int answer = 0;
    static ArrayList<List<Character>> ch_in_words = new ArrayList<>();
    static int [] visited = new int [26];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();

            return;
        }
        else if (K == 26){
            bw.write(String.valueOf(N));
            bw.flush();
            bw.close();
            return;
        }

        words = new String [N];
        for (int i=0; i<N; i++){
            words[i] = br.readLine();
            ch_in_words.add(new ArrayList<>());
        }
        for (int j=0; j<N; j++) {
            for (int i = 0; i < words[j].length(); i++) {
                if ("antic".indexOf(words[j].charAt(i)) == -1) {
                    ch_in_words.get(j).add(words[j].charAt(i));
                }
            }
        }

        visited['a'-'a'] = 1;
        visited['n'-'a'] = 1;
        visited['t'-'a'] = 1;
        visited['i'-'a'] = 1;
        visited['c'-'a'] = 1;

        K -= 5;

        dfs(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    private static void dfs (int start, int depth){
        if (depth == K ){
            answer = Math.max(answer, checkReadableWords());
            return;
        }
        if (start == 26) return;

        if (start != 'a'-'a' && start != 'n'-'a' && start != 't'-'a' && start != 'i'-'a' && start != 'c'-'a'){
            visited[start] = 1;
            dfs(start + 1, depth +1 );
            visited[start] = 0;

            dfs(start+1, depth);
        }
        else{
            dfs(start + 1, depth);
        }
    }
    private static int checkReadableWords(){
        int cnt = 0;

        for (int i=0; i<N; i++){
            boolean flag = true;
            for (int j=0; j<ch_in_words.get(i).size(); j++){
                if (visited[ch_in_words.get(i).get(j)-'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
