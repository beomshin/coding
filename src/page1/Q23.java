package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q23 {

    static int N;
    static int[] tower;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[N];
        tower = new int[N];
        for (int i=0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }


        for (int i=N-1; i >=0 ; i--) {

            if (!stack.isEmpty()) {
                int h = stack.peek()[1];

                while (h <= tower[i]) {
                    answer[stack.peek()[0]] = i+1;
                    stack.pop();
                    if(stack.isEmpty()) break;
                    h = stack.peek()[1];
                }
            }

            stack.add(new int[]{i, tower[i]});
        }

        for (int i=0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}
