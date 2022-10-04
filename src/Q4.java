import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0 ; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];

        int left = 0;
        int right = 0;
        int len = 0;
        int answer = 0;

        while (right < n){
            int l = nums[left];
            int r = nums[right];

            if (count[r] + 1 > k) {
                count[l]--;
                len--;
                left++;
                continue;
            }

            len++;
            answer = Math.max(answer, len);
            count[r]++;
            right++;
        };

        System.out.println(answer);

    }


}
