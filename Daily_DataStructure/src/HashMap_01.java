import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class HashMap_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st.nextToken();
        br.readLine();
        long answer = 1;
        for (int i = 1; i < N; i++) {
            answer = (answer * M) % (int)(Math.pow(10,9)+7);
        }
        System.out.println( answer );

    }
}
