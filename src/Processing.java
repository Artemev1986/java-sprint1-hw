import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Класс логики обработки данных
public class Processing {
    MonthlyReport[] monthlyReport= new MonthlyReport[3];
    YearlyReport yearlyReport;
    boolean isReadDataM = false;
    boolean isReadDataY = false;
    String[] monthNames = new String[]{"январь", "февраль", "март"};

    //Получение пути в папку resources
    public Path getResourcesPath(){
        Path filePath = Path.of(System.getProperty("user.dir"));
        for (int i=0;i<3;i++)
            filePath = Path.of(filePath.toString()).getParent();
        return  Paths.get(filePath.toString(),"resources");
    }

    //Считывание месячного отчёта
    public boolean readDataM(int i){
            monthlyReport[i] = new MonthlyReport();
            Path filePath = Paths.get(getResourcesPath().toString(), "m.20210" + (i + 1) + ".csv");
            try {
                String fileContents = Files.readString(filePath);
                String[] lines = fileContents.split("\\n");
                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    ReportM reportM = new ReportM();
                    reportM.item = lineContents[0];
                    reportM.quantity = Integer.parseInt(lineContents[2]);
                    reportM.price = Integer.parseInt(lineContents[3].trim());
                    if (Boolean.parseBoolean(lineContents[1]))
                        monthlyReport[i].expenses.add(reportM);
                    else
                        monthlyReport[i].incomes.add(reportM);
                }
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                return false;
            }
        return true;
    }

    //Считывание годового отчёта
    public boolean readDataY(){
        yearlyReport = new YearlyReport();
        Path filePath = Paths.get(getResourcesPath().toString(),"y.2021.csv");
        int expense = 0;
        int income = 0;
        try {
            String fileContents = Files.readString(filePath);
            String[] lines = fileContents.split("\\n");
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                if (Boolean.parseBoolean(lineContents[2].trim()))
                    expense = Integer.parseInt(lineContents[1]);
                else
                    income = Integer.parseInt(lineContents[1]);
                if (j%2 == 0){
                    ReportY reportBuf = new ReportY();
                    reportBuf.income = income;
                    reportBuf.expense = expense;
                    reportBuf.month = Integer.parseInt(lineContents[0])-1;
                    yearlyReport.reportY.add(reportBuf);
                }
            }
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return false;
        }
        return true;
    }

    //Нахождение несоответствий суммы затрат и доходов между годовым и месяными отчётами
    public boolean getMistake(int i){
        return  monthlyReport[i].getSumExpenses() != yearlyReport.reportY.get(i).expense ||
                    monthlyReport[i].getSumIncomes() != yearlyReport.reportY.get(i).income;
    }

    //Печать результата считывания месячных отчётов
    public void printReadReportM(){
        isReadDataM = true;
        for (int i=0;i<monthlyReport.length;i++)
        isReadDataM &= readDataM(i);
        if (isReadDataM){
            System.out.println();
            System.out.println("Все месячные отчёты успешно считаны");
            System.out.println();
        }
    }

    //Печать результата считывания годового отчёта
    public void printReadReportY(){
        isReadDataY = readDataY();
        if (isReadDataY) {
            System.out.println();
            System.out.println("Годовой отчёт успешно считан");
            System.out.println();
        }
    }

    //Печать результата сравнения месячных и годового отчётов
    public void printCompareReports(){
        if (isReadDataM && isReadDataY){
            for (int i=0; i<monthlyReport.length; i++) {
                if (getMistake(i)) {
                    System.out.println();
                    System.out.println("Обнаружена ошибка в месяце \"" + monthNames[i]+"\"");
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
    }

    //Печать результата обработки месячных отчётов
    public void printMonthReports(){
        if (isReadDataM){
            for (int i=0; i<monthNames.length; i++) {
                System.out.println();
                System.out.println("Отчёт за " + monthNames[i]);
                int ind = monthlyReport[i].getMaxIncomes();
                System.out.println("Самый прибыльный товар: " + monthlyReport[i].incomes.get(ind).item + "; сумма = " + monthlyReport[i].incomes.get(ind).getSum());
                ind = monthlyReport[i].getMaxExpenses();
                System.out.println("Самая большая трата: " + monthlyReport[i].expenses.get(ind).item + "; сумма = " + monthlyReport[i].expenses.get(ind).getSum());
            }
            System.out.println();
        }else {
            System.out.println();
            System.out.println("Месячные отчёты не считаны. Выполнение операции не возможно");
            System.out.println("Считайте месячные отчёты затем повторите операцию");
            System.out.println();
        }
    }

    //Печать результата обработки годового отчёта
    public void printYearReport(){
        System.out.println();
        if  (isReadDataY){
            System.out.println("Отчёт за 2021г");
            for (int i=0; i<monthNames.length; i++) {
                System.out.println("Прибыль за " + monthNames[i] + ": " + yearlyReport.reportY.get(i).getProfit());
            }
            System.out.println("Средний расход за все месяцы в году: " + yearlyReport.getAverageExpense());
            System.out.println("Средний доход за все месяцы в году: " + yearlyReport.getAverageIncome());
        }else {
            System.out.println("Годовой отчёт не считан. Выполнение операции не возможно");
            System.out.println("Считайте годовой отчёт затем повторите операцию");
        }
        System.out.println();
    }

    //Печать меню
    public void printMenu() {
        System.out.println("Какую операцию вы хотите выполнить? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}
