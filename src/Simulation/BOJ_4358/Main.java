package Simulation.BOJ_4358;

// https://www.acmicpc.net/problem/4358
// 4358번 생태학

import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> dic = new HashMap<>();

        String tree;
        int total = 0;
        while ((tree = br.readLine()) != null  && !tree.isEmpty()){
            dic.put(tree, dic.getOrDefault(tree, 0)+1);
            total++;
        }

        List<String> keySet = new ArrayList<>(dic.keySet());
        Collections.sort(keySet);

        for (String key : keySet){
            System.out.println(key+" "+String.format("%.4f", (float) dic.get(key)/total * 100));
        }

    }
}
