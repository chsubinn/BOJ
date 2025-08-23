//package DataStructure.BOJ_2304;
//
//// https://www.acmicpc.net/problem/2304
//// 2304번 창고 다각형
//
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static int N;
//    static HashMap<Integer, Integer> poll = new HashMap();
//    static ArrayList<Pair> pollList = new ArrayList<>();
//    static int answer = 0;
//
//    public static void main (String [] args ) throws IOException{
//        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//
//        int max_height = Integer.MIN_VALUE;
//        int max_l = N;
//
//        for (int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            int L = Integer.parseInt(st.nextToken());
//            int H = Integer.parseInt(st.nextToken());
//
//            poll.put(L, H);
//            pollList.add( new Pair(L, H));
//
//
//            if (max_height < H){
//                max_height = Math.max(max_height, H);
//                max_l = L;
//            }
//        }
//
//        List<Integer> keySet = new ArrayList<>(poll.keySet());
//        Collections.sort(keySet);
//
//        int left = max_l;
//        int right = left+1;
//
//        while (left == keySet.get(0)  && right == keySet.get(N-1)){
//            int max_right_height = getH(right, N-1);
//            int max_left_height = getH(0, left);
//
//            answer += max_right_height * (getL(right, max_right_height) + 1 );
//            answer += max_left_height * getL(left, max_left_height)  ;
//
//            right =getL(right, max_right_height)  + 1;
//            left = getL(left, max_left_height);
//        }
//
//        bw.write(String.valueOf(answer));
//        bw.flush();
//        bw.close();
//    }
//
//    private static int getL (int range, int H){
//        // 범위 체크해야할것같은데 어떻게 해야하는지 모르겠삼 ;
//        for (Pair p : pollList){
//            if (H == p.h){
//                return p.l;
//            }
//        }
//        return -1;
//    }
//
////    private static int getH (int left, int right){
////
////    }
//    static private class Pair implements Comparable<Pair>{
//        int l, h;
//        Pair (int l, int h){
//            this.l = l;
//            this.h = h;
//        }
//        @Override
//        public int compareTo(Pair o) {
//            return this.l - o.l;
//        }
//    }
//}
