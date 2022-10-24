package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q52 {

    static class Node {
        int no;
        Node left;
        Node right;

        public Node(int no) {
            this.no = no;
        }

        public void insert(int no) {
            if (this.no > no) {

                if(this.left == null) {
                    this.left = new Node(no);
                } else {
                    this.left.insert(no);
                }

            } else if (this.no < no) {

                if(this.right == null) {
                    this.right = new Node(no);
                } else {
                    this.right.insert(no);
                }

            }
        }

        public void calculate() {
            if(this.left != null) this.left.calculate();
            if(this.right != null) this.right.calculate();
            print(no);
        }

        public void print(int no) {
            System.out.println(no);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String s = br.readLine();
            if(s == null || s.length() == 0 || s.equals("")) break;
            list.add(Integer.parseInt(s));
        }

        Node root = new Node(list.get(0));

        for (int i=0; i < list.size(); i++) {
            root.insert(list.get(i));
        }

        root.calculate();
    }

}
