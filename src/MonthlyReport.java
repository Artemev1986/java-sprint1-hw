import java.util.ArrayList;

//Класс отвечает за формирование месяных отчётов
public class MonthlyReport {

    ArrayList<ReportM> incomes = new ArrayList<>(); //список дходов
    ArrayList<ReportM> expenses = new ArrayList<>(); //список затрат

    //Получение суммы
    public int getSumMonth(ArrayList<ReportM> reports){
            int sum = 0;
            for (ReportM reportM: reports)
                sum += reportM.getSum();
        return sum;
    }

    //Получение суммы дохода за месяц
    public int getSumIncomes(){
        return getSumMonth(incomes);
    }

    //Получение суммы затрат за месяц
    public int getSumExpenses(){
        return getSumMonth(expenses);
    }

    //Нахождение индекса максимального дохода или траты в месяце
    public int getMax(ArrayList<ReportM> reports){
            int max = 0;
            int ind = 0;
            for (int j = 0; j < reports.size(); j++) {
                int sum = reports.get(j).getSum();
                if (max < sum) {
                    max = sum;
                    ind = j;
                }
            }
        return ind;
    }

    //Нахождение индекса максимального дохода в месяце
    public int getMaxIncomes(){
        return getMax(incomes);
    }

    //Нахождение индекса максимальной траты в месяце
    public int getMaxExpenses(){
        return getMax(expenses);
    }
}
