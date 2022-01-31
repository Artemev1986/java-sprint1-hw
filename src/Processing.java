import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Класс логики обработки данных
public class Processing {
    boolean isReadDataM;
    boolean isReadDataY;

    public Processing(){
        isReadDataM = false;
        isReadDataY = false;
    }

    //Получение пути в папку resources
    public Path getResourcesPath(){
        Path filePath = Path.of(System.getProperty("user.dir"));
        for (int i=0;i<3;i++)
            filePath = Path.of(filePath.toString()).getParent();
        return  Paths.get(filePath.toString(),"resources");
    }

    //Считывание месячных отчётов
    public boolean readDataM(MonthlyReport monthlyReport){
        for (int i=0; i<3; i++) {
            monthlyReport.monthItems[i].clear();
            monthlyReport.isMonthExpenses[i].clear();
            monthlyReport.monthQuantity[i].clear();
            monthlyReport.monthPrice[i].clear();
            Path filePath = Paths.get(getResourcesPath().toString(), "m.20210" + (i + 1) + ".csv");
            try {
                String fileContents = Files.readString(filePath);
                String[] lines = fileContents.split("\\n");
                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    monthlyReport.monthItems[i].add(lineContents[0]);
                    monthlyReport.isMonthExpenses[i].add(Boolean.parseBoolean(lineContents[1]));
                    monthlyReport.monthQuantity[i].add(Integer.parseInt(lineContents[2]));
                    monthlyReport.monthPrice[i].add(Integer.parseInt(lineContents[3].trim()));
                }
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                return false;
            }
        }
        return true;
    }

    //Считывание годового отчёта
    public boolean readDataY(YearlyReport yearlyReport){
        yearlyReport.month.clear();
        yearlyReport.amount.clear();
        yearlyReport.isExpenses.clear();
        Path filePath = Paths.get(getResourcesPath().toString(),"y.2021.csv");
        try {
            String fileContents = Files.readString(filePath);
            String[] lines = fileContents.split("\\n");
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                yearlyReport.month.add(Integer.parseInt(lineContents[0]));
                yearlyReport.amount.add(Integer.parseInt(lineContents[1]));
                yearlyReport.isExpenses.add(Boolean.parseBoolean(lineContents[2].trim()));
            }
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return false;
        }
        return true;
    }

    //Нахождение несоответствий суммы затрат и доходов между годовым и месяными отчётами
    public void getMistakes(MonthlyReport monthlyReport, YearlyReport yearlyReport){
        for (int i=0;i<3;i++)
            monthlyReport.mistakes[i] = monthlyReport.sumExpenses[i] != yearlyReport.expenses[i] ||
                    monthlyReport.sumIncomes[i] != yearlyReport.incomes[i];
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

    //Вывод данных
    public boolean printReports(int command,MonthlyReport monthlyReport,YearlyReport yearlyReport){
        boolean out = false;
        switch (command) {
            case 0:
                out = true;
                break;
            case 1:
                isReadDataM = readDataM(monthlyReport);
                if (isReadDataM){
                    System.out.println();
                    System.out.println("Все месячные отчёты успешно считаны");
                    System.out.println();
                }
                break;
            case 2:
                isReadDataY = readDataY(yearlyReport);
                if (isReadDataY) {
                    System.out.println();
                    System.out.println("Годовой отчёт успешно считан");
                    System.out.println();
                }
                break;
            case 3:
                if (isReadDataM && isReadDataY){
                    monthlyReport.getSumIncomes();
                    monthlyReport.getSumExpenses();
                    yearlyReport.sepIncomesExpenses();
                    getMistakes(monthlyReport,yearlyReport);

                    for (int i=0; i<monthlyReport.monthNames.length; i++) {
                        if (monthlyReport.mistakes[i]) {
                            System.out.println();
                            System.out.println("Обнаружена ошибка в месяце \"" + monthlyReport.monthNames[i]+"\"");
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
                    monthlyReport.getMaxIncomes();
                    monthlyReport.getMaxExpenses();
                    for (int i=0; i<monthlyReport.monthNames.length; i++) {
                        System.out.println();
                        System.out.println("Отчёт за " + monthlyReport.monthNames[i]);
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
                    yearlyReport.getProfits();
                    yearlyReport.getAverageIncome();
                    yearlyReport.getAverageExpense();
                    System.out.println();
                    System.out.println("Отчёт за 2021г");
                    for (int i=0; i<monthlyReport.monthNames.length; i++) {
                        System.out.println("Прибыль за " + monthlyReport.monthNames[i] + ": " + yearlyReport.profits[i]);
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
        return out;
    }
}
