import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data();
        Reader reader = new Reader();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Comparer comparer = new Comparer();

        boolean isReadDataM = false;
        boolean isReadDataY = false;

        while (true) {
            printMenu();
            int command = 0;

            try{
                command = scanner.nextInt();
            }catch (InputMismatchException e) {
                command = 6;
                scanner.next();
            }

            switch (command) {
                case 0:
                    return;
                case 1:
                    isReadDataM = reader.readDataM(data);
                    if (isReadDataM){
                        System.out.println();
                        System.out.println("Все месячные отчёты успешно считаны");
                        System.out.println();
                    }
                    break;
                case 2:
                    isReadDataY = reader.readDataY(data);
                    if (isReadDataY) {
                        System.out.println();
                        System.out.println("Годовой отчёт успешно считан");
                        System.out.println();
                    }
                    break;
                case 3:
                    if (isReadDataM && isReadDataY){
                        monthlyReport.getSumIncomes(data);
                        monthlyReport.getSumExpenses(data);
                        yearlyReport.sepIncomesExpenses(data);
                        comparer.getMistakes(data);

                        for (int i=0; i<data.monthNames.length; i++) {
                            if (data.mistakes[i]) {
                                System.out.println();
                                System.out.println("Обнаружена ошибка в месяце \"" + data.monthNames[i]+"\"");
                            }
                        }
                        System.out.println();
                        System.out.println("Операция выполнена успешно");
                        System.out.println();
                    }else if (!(isReadDataM || isReadDataY)){
                        System.out.println();
                        System.out.println("Годовой и месячные отчёты не считаны. Выполнение операции не возможно");
                        System.out.println("Считайте отчёты затем повторите операцию");
                        System.out.println();
                    }else if (!isReadDataM) {
                        System.out.println();
                        System.out.println("Месячные отчёты не считаны. Выполнение операции не возможно");
                        System.out.println("Считайте месячные отчёты затем повторите операцию");
                        System.out.println();
                    }
                        else {
                        System.out.println();
                        System.out.println("Годовой отчёт не считан. Выполнение операции не возможно");
                        System.out.println("Считайте годовой отчёт затем повторите операцию");
                        System.out.println();
                    }

                    break;
                case 4:
                    if (isReadDataM){
                        monthlyReport.getMaxIncomes(data);
                        monthlyReport.getMaxExpenses(data);
                        for (int i=0; i<data.monthNames.length; i++) {
                            System.out.println();
                            System.out.println("Отчёт за " + data.monthNames[i]);
                            System.out.println("Самый прибыльный товар: " + data.itemMaxIncomes[i] + "; сумма = " + data.maxIncomes[i]);
                            System.out.println("Самая большая трата: " + data.itemMaxExpenses[i] + "; сумма = " + data.maxExpenses[i]);
                        }
                        System.out.println();
                    }else {
                        System.out.println();
                        System.out.println("Месячные отчёты не считаны. Выполнение операции не возможно");
                        System.out.println("Считайте месячные отчёты затем повторите операцию");
                        System.out.println();
                    }
                    break;
                case 5:
                    if (isReadDataY) {
                        yearlyReport.getProfits(data);
                        yearlyReport.getAverageIncome(data);
                        yearlyReport.getAverageExpense(data);
                        System.out.println();
                        System.out.println("Отчёт за 2021г");
                        for (int i=0; i<data.monthNames.length; i++) {
                            System.out.println("Прибыль за " + data.monthNames[i] + ": " + data.profits[i]);
                        }
                        System.out.println("Средний расход за все месяцы в году: " + data.averageExpense);
                        System.out.println("Средний доход за все месяцы в году: " + data.averageIncome);
                        System.out.println();
                    }else {
                        System.out.println();
                        System.out.println("Годовой отчёт не считан. Выполнение операции не возможно");
                        System.out.println("Считайте годовой отчёт затем повторите операцию");
                        System.out.println();
                    }
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

    static void printMenu() {
        System.out.println("Какую операцию вы хотите выполнить? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}