package DataStructure.BOJ_1991;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1991
// 1991번 트리 순회

public class Main {
    static int N;
    static Node [] tree;
    public static void main (String args []) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node [N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[node - 'A'] == null){
                tree[node - 'A'] = new Node (node);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[node - 'A'].left = tree[left - 'A'];
            }
            if (right != '.'){
                tree[right - 'A'] = new Node(right);
                tree[node - 'A'].right = tree[right - 'A'];
            }

        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
    }
    private static void preorder (Node node){
        if (node == null) return;
        System.out.print(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    private static void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val);
        inorder(node.right);
    }
    private static void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val);
    }

    private static class Node {
        char val;
        Node left;
        Node right;

        Node (char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
