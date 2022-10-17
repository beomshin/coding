import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q39 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word1 = st.nextToken();

        st = new StringTokenizer(br.readLine());

        String word2 = st.nextToken();


        int[][] dp = new int[word1.length()+1][word2.length()+1];


        for (int y=1; y <= word2.length(); y++ ) {

            char c1 = word2.charAt(y-1);

            for (int x=1; x <= word1.length(); x++) {

                char c2 = word1.charAt(x-1);
                int n1 = dp[x-1][y-1] + (c1 == c2 ? 1 : 0);
                int n2 = dp[x][y-1];
                int n3  = dp[x-1][y];

                dp[x][y] = Math.max(n1, n2);
                dp[x][y] = Math.max(dp[x][y], n3);

            }


        }


        System.out.println(dp[word1.length()][word2.length()]);

    }
}
