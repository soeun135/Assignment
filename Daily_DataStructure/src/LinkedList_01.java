import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LinkedList_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        Queue q = new LinkedList();
        ArrayList <Integer>list = new ArrayList();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        IntStream.range(1,N+1).forEach(x -> q.add(x));

        while(!q.isEmpty()){
            int data = (int) q.remove();
            cnt += 1;
            if(cnt % K == 0){
                list.add(data);
            }
            else q.add(data);
        }
        sb.append("<");
        for(int i = 0;i<list.size();i++){
            sb.append(list.get(i));
            if(i != list.size()-1){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.print(sb);
    }
}
