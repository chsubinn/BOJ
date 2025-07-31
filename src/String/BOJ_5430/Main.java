package String.BOJ_5430;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/5430
// 5430번 AC
// 수정 전: deque 그대로 복사해서 사용, split하지 않아서 일의 자리를 넘는 숫자 불가능,.. 시간 초과
// 수정 후: 뒤집는다고 해서 물리적으로 뒤집을 필요없음, deque에서 꺼내는 순서만 바꿔주면 됨

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수
        for (int i=0; i<T; i++){
            String RD = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String A = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            A = A.substring(1, A.length()-1);
            if (!A.isEmpty()){
                String [] nums = A.split(",");
                for (String n : nums){
                    deque.add(Integer.parseInt(n));
                }
            }
            String result = solution(RD, deque);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static String solution(String RD, Deque<Integer> deque){
        int D = deque.size();
        Deque<Integer> q = new ArrayDeque<>();
        boolean reversed = false;

        for (char cmd : RD.toCharArray()){
            if (cmd == 'R'){
                reversed = !reversed;
            }
            if (cmd == 'D'){
                if (deque.size()==0) {
                    return "error";
                }
                if (reversed){
                    deque.pollLast();
                }
                else{
                    deque.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");

        while (!deque.isEmpty()){
            if (reversed){
                sb.append(deque.removeLast());
            }
            else {
                sb.append(deque.removeFirst());
            }
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}
