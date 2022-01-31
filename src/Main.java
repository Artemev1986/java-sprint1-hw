import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Processing processing = new Processing();


        while (true) {
            processing.printMenu();
            int command;
            try{
                command = scanner.nextInt();
            }catch (InputMismatchException e) {
                command = 6;
                scanner.next();
            }
            if(processing.execCommands(command,monthlyReport,yearlyReport)) //Проверка на команду "0"
                return;
        }
    }
}