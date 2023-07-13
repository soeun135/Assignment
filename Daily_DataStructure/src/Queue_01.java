import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Queue_01 {
    public static int leftShift(Deque <Integer>q){ //왼쪽이동 연산
        int leftCnt = 0;
        while(true){
            if(q.peek() == 1){
                q.offerLast(q.pollFirst());
                leftCnt++;
                break;
            }
        }
        System.out.println(q);
        return leftCnt;
    }
    public static int rightShift(Deque <Integer>q){ //왼쪽이동 연산
        int rightCnt = 0;
        while(true){
            if(q.peek() == 1){
                q.offerFirst(q.pollLast());
                rightCnt++;
                break;
            }
        }
        System.out.println(q);
        return rightCnt;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque <Integer> q = new LinkedList<>();
        int location[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            q.add(i+1);
        }
        int totalCnt = 0;
        for( int num : location){
        //처음 num은 2
        int leftCnt = 0;
        int rightCnt = 0;

            //q에서 num이 차지하고 있는 위치를 알아야한다.
            for (int x : q){ //왼쪽에서 몇 번에 있는지
                if(num != x){
                    leftCnt ++;
                }
                else{
                    break;
                }
            }
            rightCnt = q.size() - leftCnt;

            int numFlag = 0;
            int calFlag = 0;
            calFlag = leftCnt <= rightCnt ? 1 : 0;

            while(true){
                if(q.peek() == num){
                    q.pollFirst();
                    break;
                }
                if(calFlag == 1){
                    //왼쪽 연산
                    q.offerLast(q.pollFirst());
                    totalCnt ++;

                }
                else{
                    //오른쪽 연산
                    q.offerFirst(q.pollLast());
                    totalCnt ++;
                }
            }
        }
        System.out.println(totalCnt);
    }
}

