package Greedy.BOJ_1138;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1138
// 1138번 한 줄로 서기
// 수정 후: 수정 가능한 리스트 ArrayList로 삽입할 생각조차 못했음.,,ㅎㅎㅎ

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] graph = new int [n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        List<Integer> line = new ArrayList<>();
        for (int i=n; i>0; i--){
            line.add(graph[i-1], i); // graph[i-1]자리에 숫자 i 넣기
            // 어차피 뒤에서부터 접근하는 인덱스 순으로 키가 클테니까,, 뒤로 밀려나는게 요구사항면에서도 맞다!!
        }

        for (int i=0; i<line.size(); i++){
            if (i!=line.size()-1){
                bw.write(line.get(i) + " ");
            }
            else{
                bw.write(String.valueOf(line.get(i)));
            }
        }
        bw.flush();
        bw.close();
    }
}
