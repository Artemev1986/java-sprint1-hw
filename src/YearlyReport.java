import java.util.ArrayList;

//Класс отвечает за формирование годового отчёта
public class YearlyReport {
    ArrayList<ReportY> reportY;

    public YearlyReport() {
        reportY = new ArrayList<>();
    }

    //Получение среднего значения дохода за год
    public int getAverageIncome() {
        int averageSumIncome = 0;
        for (int i = 0; i < reportY.size(); i++) {
            averageSumIncome += reportY.get(i).income;
        }
        return averageSumIncome / reportY.size();
    }

    //Получение среднего значения затрат за год
    public int getAverageExpense() {
        int averageSumExpense = 0;
        for (int i = 0; i < reportY.size(); i++) {
            averageSumExpense += reportY.get(i).expense;
        }
        return averageSumExpense / reportY.size();
    }
}
