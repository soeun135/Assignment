import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XyClose {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int my[] = new int[2];
        System.out.println("내 좌표 x값을 입력해 주세요.");
        my[0] = Integer.parseInt(br.readLine());
        System.out.println("내 좌표 y값을 입력해 주세요.");
        my[1] = Integer.parseInt(br.readLine());

        double minVal = Integer.MAX_VALUE;

        int x[] = new int[10];
        int y[] = new int[10];
        int[] result = new int[2];
        int Idx = 0;
        while (Idx < 10) {
            System.out.println((Idx + 1)+"/10 번째 입력");
            System.out.println("임의의 좌표 x값을 입력해 주세요.");
            int xNum = Integer.parseInt(br.readLine());
            System.out.println("임의의 좌표 y값을 입력해 주세요.");
            int yNum = Integer.parseInt(br.readLine());


            if (isDuplicate(xNum, yNum, x, y)) {
                System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
                continue;
            }
            x[Idx] = xNum;
            y[Idx] = yNum;
            Idx++;
        }
        for (int i = 0; i < x.length ; i++) {
            double temp = Math.sqrt(Math.pow(my[0] - x[i], 2) + Math.pow(my[1] - y[i], 2));
            System.out.printf("(%d, %d) => %.6f\n",x[i],y[i],temp);
            if (temp < minVal) {
                minVal = temp;
                result[0] = x[i];
                result[1] = y[i];
            }
        }
        System.out.println("제일 가까운 좌표:");
        System.out.printf("(%d, %d) => %.6f\n",result[0],result[1],minVal);
    }
    public static boolean isDuplicate(int x, int y, int []xArr, int []yArr) {
        for (int i = 0; i < xArr.length; i++) {
            if (xArr[i] == x && yArr[i] == y) {
                return true;
            }
        } return false;
    }
}
