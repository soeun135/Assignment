import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        Stack <Integer>stackArr[] = new Stack[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 4; i++) {
            stackArr[i] = new Stack<>();
            stackArr[i].push(0);
        }
        for (int i = 0; i < N; i++) { //수열의 맨 앞 수
            for (int j = 0; j < 4; j++) { //스택배열을 다 돌기
                if (stackArr[j].peek() < arr[i]) {
                    stackArr[j].push(arr[i]); //스택의 peek이 나보다 작아야됨.
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }
        if(!flag) System.out.println("NO");
        else System.out.println("YES");
    }
}