package String.BOJ_9935;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9935
// 9935번 문자열 폭발

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));

        String S = br.readLine(); // 주어진 문자열
        String B = br.readLine(); // 폭발 문자열

        Stack<Character> answer = new Stack<>();

        for (int i=0; i<S.length(); i++){
            answer.push(S.charAt(i));

            if (answer.size() >= B.length()){
                boolean isBomb = true;
                for (int j=B.length(); j>0; j--){

                    char c = answer.get(answer.size()-j);
                    char b = B.charAt(B.length()-j);

                    if (answer.get(answer.size()-j) != B.charAt(B.length()-j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb && !B.isEmpty()){
                    for (int j=B.length(); j>0; j--){
                        answer.pop();
                    }
                }
            }
        }
        if (answer.isEmpty()) bw.write("FRULA");

        for (Character character : answer) {
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }
}
