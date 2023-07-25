import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Hashtable_01 {
    public static String solution(String s) {
        String answer = "";
        Hashtable <String,Integer> ht = new Hashtable<>();
        ArrayList <String> list = new ArrayList<>();
        for(String str : s.split("")) {
            ht.put(str,ht.getOrDefault(str, 0 ) + 1);
        }
        for(Map.Entry<String, Integer> map : ht.entrySet()){
            if(map.getValue() == 1){
                list.add(map.getKey());
            }
        }
        Collections.sort(list);
        answer = String.join("",list);
        return answer;
    }
    public static void main(String args[]){
        System.out.println(solution("abcabcadc"));
    }
}
