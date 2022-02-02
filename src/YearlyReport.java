import java.util.ArrayList;

//Класс отвечает за формирование годового отчёта
public class YearlyReport {
    ArrayList<ReportY> reportY = new ArrayList<>();

    //Получение среднего значения дохода за год
    public int getAverageIncome() {
        int averageSumIncome = 0;
        for (ReportY report: reportY)
            averageSumIncome += report.income;

        return averageSumIncome / reportY.size();
    }

    //Получение среднего значения затрат за год
    public int getAverageExpense() {
        int averageSumExpense = 0;
        for (ReportY report: reportY)
            averageSumExpense += report.expense;

        return averageSumExpense / reportY.size();
    }
}
