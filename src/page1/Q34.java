package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q34 {

    static ArrayList<int[]> pair = new ArrayList<>();
    static char[] chars;
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line = st.nextToken();
        Stack<Integer> stack = new Stack<>();
        chars = line.toCharArray();
        visited = new boolean[chars.length];
        Arrays.fill(visited, true);

        for (int i=0; i < chars.length; i++) {
            if (chars[i] == '(') stack.add(i);
            else if (chars[i] == ')') pair.add(new int[]{stack.pop(), i});
        }

        calculate(0);

        Collections.sort(answer);
        for (String l : answer) {
            if (line.equals(l)) continue;
            System.out.println(l);
        }

    }

    public static void calculate(int idx) {

        if (idx == pair.size()) {
            String line = "";
            for (int i=0; i < visited.length; i++) {
                if(visited[i]) {
                    line += chars[i];
                }
            }
            if (!answer.contains(line)) answer.add(line);

            return;
        }

        int[] p = pair.get(idx);
        visited[p[0]] = true;
        visited[p[1]] = true;
        calculate(idx+1);
        visited[p[0]] = false;
        visited[p[1]] = false;
        calculate(idx+1);
    }

}
