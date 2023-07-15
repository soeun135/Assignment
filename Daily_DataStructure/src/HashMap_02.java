import java.util.ArrayList;
import java.util.HashSet;

public class HashMap_02 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashSet <String>set = new HashSet(); //옷의 종류 중복 없이 저장
        ArrayList <Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < clothes.length; i++) {
            set.add(clothes[i][1]);
        }
        for (String s : set) {
            cnt = 0;
            for (int i = 0; i < clothes.length; i++) {
                if(clothes[i][1].equals(s)) {
                    cnt++;
                }
            }
            list.add(cnt);
        }
        for (int i = 0; i < list.size(); i++) {
            answer *= (1+list.get(i));
        }
        return answer-1;
    }
    public static void main(String args[]){
        String arr[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(arr);
    }
}
