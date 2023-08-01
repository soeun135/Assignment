import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Palindrome_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack <Character> stack = new Stack<>();
        int answer = 0;
        boolean isPalindrome = false;
        boolean containsPal = false;
        int cnt = 0;

        //모든 문자열이 팰린드롬인지 판별
        for (int i = 0 ; i < str.length() / 2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) { //완전 팰린드롬일 때
            answer = str.length();
        }
        else { //아닐 때
            for (int i = 0; i < str.length() ; i++) {
                String temp = str.substring(i);
                cnt = 0;
                for (int j = 0; j < temp.length() / 2; j++) {
                    if (temp.charAt(j) != temp.charAt(temp.length() - 1 - j)) {
                        containsPal = false;
                        break;
                    } else {
                        containsPal = true;
                        cnt++;
                    }
                }
                if (containsPal == true) {
                    break;
                }

            }
            if (containsPal) { //팰린드롬 문자열이 섞여있음
                answer = cnt * 2 + (str.length() - cnt * 2);
            }
        }

        System.out.println(answer);
    }
}
