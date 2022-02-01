import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Processing processing = new Processing();

        while (true) {
            processing.printMenu(); //Печать меню
            int command;
            try{
                command = scanner.nextInt();
            }catch (InputMismatchException e) {
                command = 6;
                scanner.next();
            }
            switch (command) {
                case 0:
                    //Выход из программы
                    return;
                case 1:
                    //Печать результата считывания месячных отчётов
                    processing.printReadReportM();
                    break;
                case 2:
                    //Печать результата считывания годового отчёта
                    processing.printReadReportY();
                    break;
                case 3:
                    //Печать результата сравнения месячных и годового отчётов
                    processing.printCompareReports();
                    break;
                case 4:
                    //Печать результата обработки месячных отчётов
                    processing.printMonthReports();
                    break;
                case 5:
                    //Печать результата обработки годового отчёта
                    processing.printYearReport();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Введено значение в неправильном формате");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Команда с таким номером отсутствует");
                    System.out.println();
                    break;
            }
        }
    }
}