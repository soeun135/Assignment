import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_03 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean vpsFlag = true;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            vpsFlag = vpsCheck(str);

            if(vpsFlag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean vpsCheck(String str) {
        Stack<String> stack = new Stack();
        boolean vpsFlag = true;

        for (String s : str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else { //닫힘 괄호이면
                if (!stack.isEmpty()) { //스택이 비어있지 않으면 ( 빼는데
                    stack.pop();
                } else { //스택이 비어있으면 짝이 안 맞음.
                    vpsFlag = false;
                }
            }
        }
        if (!stack.isEmpty()) {
            vpsFlag = false;
        }
        return vpsFlag;
    }
}
