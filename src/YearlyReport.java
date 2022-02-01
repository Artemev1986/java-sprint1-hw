import java.util.ArrayList;

//Класс отвечает за формирование годового отчёта
public class YearlyReport {
    ReportY reportY;

    public  YearlyReport(){
        reportY = new ReportY();
    }

    public static class ReportY {
        ArrayList<Integer> income;
        ArrayList<Integer> expense;
        public ReportY(){
            income = new ArrayList<>();
            expense = new ArrayList<>();
        }
    }

    //Нахождение прибыли за каждый месяц
    public int[] getProfits(){
        int[] profits = new int[3];
        for (int i = 0; i < reportY.income.size(); i++){
            profits[i] = reportY.income.get(i) - reportY.expense.get(i);
        }
        return profits;
    }

    public int getAverage(ArrayList<Integer> reports){
        int averageSum = 0;
        for (int sum : reports){
            averageSum += sum;
        }
        return averageSum / reports.size();
    }

    //Получение среднего значения дохода за год
    public int getAverageIncome(){
        return getAverage(reportY.income);
    }

    //Получение среднего значения затрат за год
    public int getAverageExpense(){
        return getAverage(reportY.expense);
    }
}
