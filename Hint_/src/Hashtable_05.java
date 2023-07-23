import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Hashtable_05 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Hashtable <Integer,Integer>ht = new Hashtable();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            ht.put(num, ht.getOrDefault(num,0)+1);
        }
        int result = Integer.parseInt(br.readLine());
        System.out.println(ht.getOrDefault(result,0));
    }
}
