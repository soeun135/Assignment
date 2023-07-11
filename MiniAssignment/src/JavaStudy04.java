import java.util.Scanner;

public class JavaStudy04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int rand = (int)(Math.random() * 999999)+1;

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String year = scanner.next().substring(2);
        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = scanner.next();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = scanner.next();
        System.out.print("성별을 입력해 주세요.(m/f):");
        char gender = scanner.next().charAt(0);

        sb.append(year).append(month).append(day).append("-");

        if(gender == 'm'){
            sb.append(3);
        }
        else{
            sb.append(4);
        }
        sb.append(rand);

        System.out.println(sb);
        scanner.close();
    }
}