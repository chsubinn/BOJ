package String.BOJ_1394;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1394
// 1394번 암호

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String usable = br.readLine();
        String pw = br.readLine();

        int answer = 0;
        char [] password = pw.toCharArray();
        char [] usableList = usable.toCharArray();

//        // hash map에 각 값을 저장해놓고 불러와서 업데이트하기
//        HashMap<String, Integer> hash = new HashMap<>();
//
//        for (int i=0; i<usableList.length; i++){
//            hash.put(String.valueOf(usableList[i]), i+1);
//        }
//
//        for (int i=0; i<password.length; i++){
//            for (int j=0; j<usable.length(); j++){
//                Map<String, Integer> copy = new HashMap<>(hash);
//
//                for (String key : hash.keySet()){
//                    String newStr = key + usableList[j];
//                    copy.put(newStr, copy.get(key) + (int) Math.pow(usableList.length, key.length()));
//                }
//                hash = new HashMap<>(copy);
//            }
//        }
//        bw.write(String.valueOf(hash.get(pw) % 900528));


//        // pw의 각 한 글자씩을 따서 해당 char의 인덱스를 파악, 인덱스를 정답값에 더한다
//        for (int i=0; i<password.length; i++){
//            int index = usable.indexOf(password[i]) + 1;
//            System.out.println(index);
//            answer+=index;
//
//            if (i==password.length-1) break;
//            else{
//                answer += (usable.length()-1);
//            }
//        }
//        bw.write(String.valueOf(answer%900528));

        // 그냥 수학적으로 구하기
        int N = pw.length();
        int M = usable.length();

        char end = pw.charAt(N-1);
        int end_index = usable.indexOf(end)+1;

        for (int i=0; i<N; i++){
            answer = Math.max((int) Math.pow(M, i) + end_index, answer);
//            System.out.println(answer);
        }

        bw.write(String.valueOf(answer % 900528));
        bw.flush();
        bw.close();

    }
}
