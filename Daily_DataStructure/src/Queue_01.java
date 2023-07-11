import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        int location[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            q.offer(0);
            for (int j = 0; j < M; j++) {
                if(location[i] == i)
                    q.offer(1);
            }
        }
        System.out.println(q);
        int findFlag = 0;
//        while(findFlag != M){
//            location
//        }
    }
}
