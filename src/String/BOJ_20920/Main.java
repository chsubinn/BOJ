package String.BOJ_20920;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20920
// 20920번 영단어 암기는 괴로워

public class Main {
    static int N, M;

    public static void main (String [] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();

        for (int i=0; i<N; i++){
            String str = br.readLine();

            if (str.length() < M) continue;

            words.put(str, words.getOrDefault(str, 0) + 1);
        }

        List<Pair> wordList = new ArrayList<>();

        for (String s : words.keySet()){
            wordList.add(new Pair(s, words.get(s)));
        }

        Collections.sort(wordList);

        for (int i=0; i<wordList.size(); i++){
            if (i==wordList.size()-1) bw.write(wordList.get(i).word);
            else bw.write(wordList.get(i).word+"\n");
        }
        bw.flush();
        bw.close();
    }
    static class Pair implements Comparable<Pair>{
        String word;
        int cnt;

        Pair (String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.cnt == o.cnt){
                if (this.word.length() == o.word.length()){
                    return this.word.compareTo(o.word);
                }
                return o.word.length() - this.word.length();
            }

            return o.cnt - this.cnt;
        }
    }
}
