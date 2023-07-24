import java.util.Random;
import java.util.Scanner;

public class JavaStudy04 {

    public static String createJuminNo(int year, String month, String day, String gender){
        String rand = "";
        Random random = new Random();
        for (int i = 1; i <= 6; i++) {
            rand += random.nextInt(10) ;
        }

        int genderValue = "m".equalsIgnoreCase(gender) ? 3 : 4;

        String 주민번호 = String.format("%02d%s%s-%d%s", year - 2000, month, day, genderValue, rand);

        return 주민번호;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        //String year = scanner.next().substring(2);
        int year = scanner.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = scanner.next();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = scanner.next();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = scanner.next();

        System.out.println(createJuminNo(year, month, day, gender));
        scanner.close();
    }
}