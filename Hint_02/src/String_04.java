public class String_04 {
    public static int solution(String str1, String str2) {
        int answer = 2;
        if(str1.contains(str2)){
            answer = 1;
        }
            return answer;
    }
    public static void main(String args[]){
        System.out.println(solution("ab6CDE443fgh22iJKlmn1o","6CD"));
    }
}
