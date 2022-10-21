package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q42 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        ArrayList<int[]> tree=  new ArrayList<>();

        int round = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());


            while (st.hasMoreTokens()) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (u < 0 && v < 0) {
                    return;
                } else if(u == 0 && v == 0) {
                    calculate(tree, round++);
                    tree.clear();
                    break;
                }

                tree.add(new int[]{u, v});
            }


        }


    }

    public static void calculate(ArrayList<int[]> tree, int round) {

        if (tree.size() == 0) {
            System.out.println("Case " + round +" is a tree.");
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0 ; i < tree.size(); i++) {
            int u = tree.get(i)[0];
            int v = tree.get(i)[1];
            map.put(v, map.getOrDefault(v, 0) + 1);
            map.put(u, map.getOrDefault(u, 0));
        }

        int root = 0;
        int fail = 0;

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {

            int count = map.get(iterator.next());

            if (count == 0) {
                root++;
            } else if (count != 1) {
                fail++;
            }
        }


        if (fail > 0 || root != 1 ) {
            System.out.println("Case " + round +" is not a tree.");
        } else {
            System.out.println("Case " + round +" is a tree.");
        }

    }
}
