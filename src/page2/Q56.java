package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q56 {

    static String ori, target;
    static int flag = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ori = st.nextToken();

        st = new StringTokenizer(br.readLine());

        target = st.nextToken();

        dfs(target);

        System.out.println(flag);

    }

    public static void dfs(String word) {

        if (word.equals(ori)) {
            flag=1;
            return;
        } else if(flag == 1) return;

        if (word.charAt(word.length()-1) == 'A') {
            if (word.length() == 1) return;
            dfs(word.substring(0, word.length()-1));
        }

        if(word.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(word);
            String temp = sb.reverse().toString();
            if (temp.length() == 1) return;
            dfs(temp.substring(0, temp.length()-1));
        }


    }
}
