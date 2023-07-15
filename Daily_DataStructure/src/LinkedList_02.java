import java.util.*;

public class LinkedList_02 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue <Integer>rank = new LinkedList();
        Queue <Character>c = new LinkedList();
        ArrayList <Integer>list = new ArrayList();
        for(int i =0 ;i<priorities.length;i++){
            list.add(priorities[i]);
            rank.add(priorities[i]);
            c.add((char)(65+i));
        }char data = (char)(location+65);
        Collections.sort(list, Collections.reverseOrder());

        while(true){
            if(c.peek() == data && rank.peek() == list.get(0)){
                answer+=1;
                break;
            }
            int cur = rank.remove();
            char peekData = c.remove();
            Integer out = list.get(0);
            if(cur == out){
                answer ++;
                list.remove(0);
            }
            else{
                rank.add(cur);
                c.add(peekData);
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        int arr[] = {1,1,9,1,1,1};
        System.out.println(solution(arr, 0));
    }
}
