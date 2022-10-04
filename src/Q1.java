import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1 {

    static int mul = 1;
    static Stack<Character> stack = new Stack<>();
    static int answer = 0;
    static String bracket;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bracket = st.nextToken();
        boolean ok = true;

        for (int i=0 ; i < bracket.length(); i++ ) {

            char c = bracket.charAt(i);

            switch (c) {
                case '(': calculate(2, c); break;
                case '[': calculate(3, c); break;
                case ')': ok = calculate2(2, '(', i-1); break;
                case ']': ok = calculate2(3, '[', i-1); break;
            }

            if (!ok) {
                answer = 0;
                break;
            }
        }

        if (stack.isEmpty()) System.out.println(answer);
        else System.out.println(0);
    }

    public static void calculate(int num, char c) {
        mul *= num;
        stack.push(c);
    }

    public static boolean calculate2(int num, char c, int idx) {

        if (stack.isEmpty() || stack.peek() != c) {
            return false;
        }

        if (bracket.charAt(idx) == c) answer += mul;
        stack.pop();
        mul /= num;
        return true;
    }


}
