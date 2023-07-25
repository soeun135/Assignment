import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Array_02 {
    public static int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        Deque <Integer> q = new ArrayDeque<Integer>();
        IntStream.of(numbers).forEach(x->q.offerLast(x));

        if (direction.equalsIgnoreCase("right")){
            q.offerFirst(q.pollLast());
        } else {
           q.offerLast(q.pollFirst());
        }
        answer = q.stream().mapToInt(x->x).toArray();
        return answer;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3};
        System.out.println(solution(arr,"right"));
    }
}
