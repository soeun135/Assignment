import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class JavaStudy05 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = scanner.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = scanner.nextInt();
        System.out.printf("[%d년 %02d월]\n",year,month);
        System.out.println("일\t"+"월\t"+"화\t"+"수\t"+"목\t"+"금\t"+"토\t");

        LocalDate calender = LocalDate.of(year,month,1);
        int day = calender.getDayOfWeek().getValue(); //해당 달이 시작하는 요일

        int cntDay = calender.lengthOfMonth();
        if(day != 7) {
            for (int i = 0; i < day; i++) {//시작 요일만큼 공백
                System.out.print("\t");
            }
        }
        int date=1;
        for(int i=0;i<cntDay;i++){
            System.out.printf("%02d\t",date);
            day++; date++;
            if(day%7==0){
                System.out.println();
            }
        }
        scanner.close();
    }
}