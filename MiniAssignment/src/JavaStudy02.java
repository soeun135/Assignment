import java.util.Scanner;

public class JavaStudy02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[캐시백 계산]");

        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int price = scanner.nextInt();

        int cashBack = (int)((double)price * 0.1);

        cashBack = cashBack/100 * 100;

        if(cashBack > 300) cashBack = 300;

        System.out.println("결제 금액은 "+price+"원이고, 캐시백은 "+cashBack+"원 입니다.");

        scanner.close();
    }
}