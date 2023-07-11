import java.util.Scanner;

public class JavaStudy03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = scanner.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = scanner.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        char country = scanner.next().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        char card = scanner.next().charAt(0);

        int price = 10000;
        if(card == 'y' || country == 'y') price = 8000;
        if(age>=3 && age<13) price = 4000;
        if(time>17) price = 4000;
        if(age < 3) price = 0;

        System.out.println("입장료: "+price);

        scanner.close();
    }
}