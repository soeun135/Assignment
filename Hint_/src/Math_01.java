import java.util.ArrayList;

public class Math_01 {
        public static int[] solution(int n) {
            ArrayList<Integer> answer = new ArrayList();
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    answer.add(i);
                }
            }
            return answer.stream().mapToInt(x -> x).toArray();
        }
        public static void main(String args[]){
            System.out.println(solution(10));
        }
}
