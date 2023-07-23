import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bit_04 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int oneArr[] = new int[21];
        String []arr = new String[N];
        long total = 0;

        for (int i = 0; i < N; i++) {
            //toBinary
            arr[i] = Integer.toBinaryString(Integer.parseInt(br.readLine()));
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(arr[i].length() - 1 - j);
                if ( c == '1'){
                    oneArr[j] ++;
                }
            }
        }
        System.out.println(Integer.toBinaryString(1000000));
        for (int i = 0; i < oneArr.length; i++) {
            total += (long) oneArr[i] * ( arr.length - oneArr[i] ) * (int)Math.pow(2,i);
        }
        System.out.print(total);
    }
}
