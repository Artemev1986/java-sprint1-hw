import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data();
        Reader reader = new Reader();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Comparer comparer = new Comparer();

      //  yearlyReport.getProfits(data);
      //  yearlyReport.getAverageIncome(data);
      //  yearlyReport.getAverageExpense(data);

      //  System.out.println(yearlyReport.profits[0]+" "+yearlyReport.profits[1]+" "+yearlyReport.profits[2]);
      //  System.out.println(yearlyReport.averageIncome);
       // System.out.println(yearlyReport.averageExpense);

        boolean isReadDataM = false;
        boolean isReadDataY = false;

        while (true) {
            printMenu();

            int command = scanner.nextInt();
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
                        comparer.getMistakes(monthlyReport,yearlyReport);

                        for (int i=0; i<monthlyReport.month.length; i++) {
                            if (comparer.mistakes[i]) {
                                System.out.println();
                                System.out.println("Обнаружена ошибка в месяце \"" + monthlyReport.month[i]+"\"");
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
                        for (int i=0; i<monthlyReport.month.length; i++) {
                            System.out.println();
                            System.out.println("Отчёт за " + monthlyReport.month[i]);
                            System.out.println("Самый прибыльный товар: " + monthlyReport.itemMaxIncomes[i] + "; сумма = " + monthlyReport.maxIncomes[i]);
                            System.out.println("Самая большая трата: " + monthlyReport.itemMaxExpenses[i] + "; сумма = " + monthlyReport.maxExpenses[i]);
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
                        for (int i=0; i<monthlyReport.month.length; i++) {
                            System.out.println("Прибыль за " + monthlyReport.month[i] + ": " + yearlyReport.profits[i]);
                        }
                        System.out.println("Средний расход за все месяцы в году: " + yearlyReport.averageExpense);
                        System.out.println("Средний доход за все месяцы в году: " + yearlyReport.averageIncome);
                        System.out.println();
                    }else {
                        System.out.println();
                        System.out.println("Годовой отчёт не считан. Выполнение операции не возможно");
                        System.out.println("Считайте годовой отчёт затем повторите операцию");
                        System.out.println();
                    }
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