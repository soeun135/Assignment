import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Stack;

public class Palindrome_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack <Character> stack = new Stack<>();
        int answer = 0;
        boolean containsPal = false;
        int cnt = 0;

        //모든 문자열이 팰린드롬인지 판별
        for (int i = 0 ; i < str.length() ; i++) {
            if (isPalindrome(str.substring(i))) {
                System.out.println(str.length() + i);
                return;
            }
        }
        System.out.println(str.length() * 2);
    }
    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2 ; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
