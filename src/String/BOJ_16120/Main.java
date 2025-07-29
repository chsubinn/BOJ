package String.BOJ_16120;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16120
// 16120번 PPAP
// 수정 전: 쓸데없이 while 문을 추가해서 영원히 루프에서 빠져나오지 못함 (ppap 처리를 다 해도 stack이 비지 않을 수 있다는 점 간과)


public class Main {
    static String PPAP = "PPAP";

    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> words = new Stack<>();

        for (int i=0; i<str.length(); i++){
            words.push(str.charAt(i));

            int len = words.size();
            if (len >= 4){
                String checkPPAP = "";
                if (words.get(len - 4) == 'P' &&
                    words.get(len - 3) == 'P' &&
                    words.get(len - 2) == 'A' &&
                    words.get(len - 1) == 'P') {

                    // 'PPAP' 패턴 제거 후 'P' 추가
                    for (int j = 0; j < 4; j++) {
                        words.pop();
                    }
                    words.push('P');
                }
            }
        }
        if (words.size() == 1 && words.pop() == 'P') bw.write("PPAP");
        else bw.write("NP");

        bw.flush();
        bw.close();
    }
}
