public class String_02 {
    public static int solution(String s) {
        int answer = 0;
        String number[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        for (int i = 0; i < number.length; i++) {
            s = s.replaceAll(number[i],Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
    public static void main(String args[]){
        System.out.println(solution("1zerotwozero3"));
    }
}
