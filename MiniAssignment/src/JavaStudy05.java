import java.time.LocalDate;
import java.util.Scanner;

public class JavaStudy05 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = scanner.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = scanner.nextInt();
        System.out.printf("[%d년 %02d월]\n",year,month);
        String []title = {"일","월","화","수","목","금","토"};

        LocalDate localDate = LocalDate.of(year,month,1);

        int preFixCount = localDate.getDayOfWeek().getValue();

        int lastDay = localDate.plusMonths(1).minusDays(1).getDayOfMonth();
        int totalCount = 0;

        for (int i = 0; i < title.length; i++) {
            //System.out.print(title[i] + "\t");
            sb.append(title[i] + "\t");
        }
        sb.append("\n");
        for (int i = 0; i < preFixCount; i++) {
            //System.out.print(" " + "\t");
            sb.append(" " + "\t");
            totalCount ++;
        }
        for (int i = 1; i <= lastDay ; i++) {
            //System.out.printf("%02d \t",i);
            sb.append(i + "\t");
            totalCount ++;
            if(totalCount % 7 == 0){
                //System.out.println();
                sb.append("\n");
            }
        }
        System.out.println(sb);
        scanner.close();
    }
}