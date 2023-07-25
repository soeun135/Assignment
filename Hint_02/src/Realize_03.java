import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Realize_03 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> q = new LinkedList<>();
        Stack<Integer> stack = new Stack();
        String str = br.readLine();
        while(!str.equals("=")){
            q.add(str);
            str = br.readLine();
        }
        while(!q.isEmpty()){
            String s = q.poll();
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int num1 = stack.pop();
                int num2 = Integer.parseInt(q.poll());

                if(s.equals("+")){
                    stack.push(num1 + num2);
                }
                else if(s.equals("-")){
                    stack.push(num1 - num2);
                }
                else if (s.equals("*")){
                    stack.push(num1 * num2);
                } else{
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        System.out.println(stack.pop());
    }
}
