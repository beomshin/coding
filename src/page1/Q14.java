package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String T =st.nextToken();

        boolean flag = calculate(S, T);

        System.out.println(flag ? 1 : 0);
    }

    public static boolean calculate(String target, String word) {

        boolean flag1 = false;
        boolean flag2 = false;

        if (word.length() == target.length()) {
            return target.equals(word);
        }

        if (word.charAt(word.length() - 1) == 'A') {
            flag1 = calculate(target, word.substring(0, word.length() - 1));
        }

        if(word.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(word);
            sb.reverse();
            flag2 = calculate(target, sb.substring(0, sb.length() - 1));
        }

        return flag1 || flag2;
    }




}
