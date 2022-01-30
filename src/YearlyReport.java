//Класс отвечает за формирование годового отчёта
public class YearlyReport {

//Нахождение затрат и доходов из годового отчёта
    public void sepIncomesExpenses(Data data){
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i))
                data.expenses[data.month.get(i)-1] = data.amount.get(i);
            else
                data.incomes[data.month.get(i)-1] = data.amount.get(i);
        }
    }

    //Нахождение прибыли за каждый месяц
    public void getProfits(Data data){
        int[] profits_ = new int[3];
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i))
                profits_[data.month.get(i)-1] -= data.amount.get(i);
            else
                profits_[data.month.get(i)-1] += data.amount.get(i);
        }
        data.profits = profits_;
    }

    //Получение среднего значения дохода за год
    public void getAverageIncome(Data data){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < data.month.size(); i++){
            if (!data.isExpenses.get(i)) {
                averageSum += data.amount.get(i);
                count++;
            }
        }
        data.averageIncome = averageSum / count;
    }

    //Получение среднего значения затрат за год
    public void getAverageExpense(Data data){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i)) {
                averageSum += data.amount.get(i);
                count++;
            }
        }
        data.averageExpense = averageSum / count;
    }
}
