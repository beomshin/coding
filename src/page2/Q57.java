package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q57 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        if (nums.length == 1 || nums.length == 2) {
            System.out.println(nums.length);
            return;
        }

        int answer = 2;

        for (int i=0; i < N-2; i++) {

            int sum = nums[i] + nums[i+1];
            int count = 2;


            for (int j=i+2; j < N; j++) {

                if (sum > nums[j] ) count++;

            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }


}
