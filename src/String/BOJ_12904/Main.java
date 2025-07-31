package String.BOJ_12904;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/12904
// 12904번 AB

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder nS = new StringBuilder();
        nS.append(T);

        while (nS.length() > S.length()){
            nS.deleteCharAt(nS.length()-1);
            if (nS.charAt(nS.length()-1) == 'B') nS.reverse();

//            if (nS.toString().equals(S)){
//                bw.write(String.valueOf(1));
//                break;
//            }
//            else if (nS.length()==S.length() && !nS.toString().equals(S)){
//                bw.write(String.valueOf(0));
//                break;
//            }
        }

        bw.write(nS.toString().equals(S) ? "1" : "0");
        bw.flush();
        bw.close();
    }
}
