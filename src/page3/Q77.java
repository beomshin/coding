package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q77 {


    /**
     * 회문
     * https://www.acmicpc.net/problem/17609
     *
     * 단어의 양쪽 끝을 비교해준다
     * 전부 일치시 0
     *
     * 중간에 서로 다른 단어를 찾은 경우 양쪽에 해당 단어를 뺀 단어로 회문을 검사한다.
     * 둘 중 하나라도 일치시 1
     *
     * 이외는
     * 2
     * 처리하면 된다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i < N; i++) {
            String word = br.readLine();
            System.out.println(palindrome(word));
        }
    }

    public static int palindrome(String word) {
        int end = word.length() - 1;
        for (int i=0 ; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(end-i)) {
                if (check(new StringBuilder(word).deleteCharAt(i))
                        || check(new StringBuilder(word).deleteCharAt(end-i))) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

       return 0;
    }

    public static boolean check(StringBuilder word) {
        if(word.toString().equals(word.reverse().toString())) return true;
        return false;
    }
}
