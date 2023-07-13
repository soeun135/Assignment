import java.util.ArrayList;
import java.util.Collections;

public class Array_02 {
    public static ArrayList solution(int[] arr, int divisor) {
        ArrayList answer = new ArrayList();
        for(int x : arr){
            if(x % divisor == 0){
                answer.add(x);
            }
        }
        Collections.sort(answer);
        if (answer.size() == 0) answer.add(-1);
        return answer;
    }
    public static void main(String args[]){
        int arr[] = {5,9,7,10};
        int divisor = 5;
        System.out.println(solution(arr,divisor));
    }
}
