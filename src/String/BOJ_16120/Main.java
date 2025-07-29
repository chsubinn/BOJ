package String.BOJ_16120;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16120
// 16120번 PPAP

public class Main {
    static String PPAP = "PPAP";

    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String str = br.readLine();
        char [] arr = str.toCharArray();

        Stack<Character> words = new Stack<>();
        words.add(arr[0]);

        while (!words.isEmpty()){
            for (int i=1; i<str.length(); i++){
                words.add(arr[i]);

                if (words.size() >= 4){
                    String checkPPAP = "";
                    for (int j=i; j<4; j++){
                        checkPPAP += words.indexOf(j);
                    }
                    if (checkPPAP.equals(PPAP)){
                        for (int j=0; j<4; j++){
                            words.pop();
                        }
                        words.add('P');
                    }
                }
            }

            StringBuilder remaining = new StringBuilder();
            for (char c : words){
                remaining.append(c);
            }

            if (words.size() <= 4 && !remaining.equals(PPAP)){
                bw.write("NP");
                bw.flush();
                return;
            }
        }

        bw.write(PPAP);
        bw.flush();
        bw.close();


        // 시간초과 남
//        String newStr = "";
//
//        while (!newStr.equals(PPAP) && !str.equals(PPAP)){
//            newStr = "";
//            String [] splitedStr = str.split(PPAP);
//            List<String> list = new ArrayList<>(List.of(splitedStr));
//
//            list.add(str.indexOf(PPAP), "P");
//
//            for (String s : list) {
//                newStr+=s;
//            }
//
//            if (newStr.length() <= PPAP.length() && !newStr.equals(PPAP)){
//                bw.write("NP");
//                bw.flush();
//                bw.close();
//                return;
//            }
//        }
//
//        bw.write(PPAP);
//        bw.flush();
//        bw.close();

    }
}
