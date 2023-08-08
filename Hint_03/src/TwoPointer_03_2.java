import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer_03_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());
        int answer = 0;

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = n - 1;
        int total = 0;

        while (p1 < p2) {
            if (arr[p1] + arr[p2] < target) {
                p1++;
            } else if (arr[p1] + arr[p2] > target) {
                p2--;
            }

            if (arr[p1] + arr[p2] == target) {
                answer++;
                p1++;
                p2--;
            }

        }
        System.out.println(answer);
    }
}
