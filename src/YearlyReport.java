import java.util.ArrayList;

//Класс отвечает за формирование годового отчёта
public class YearlyReport {
    ArrayList<Integer> month; // список номеров месяца из годового отчета
    ArrayList<Integer> amount; // список сумм товаров или услуг за месяц из годового отчёта
    ArrayList<Boolean> isExpenses; // список меток, определяющих трату или доход из годового отчёта

    int[] profits; // массив прибыли за каждый месяц
    int averageIncome; // массив среднего дохода за каждый месяц
    int averageExpense; // массив средних затрат за каждый месяц
    int[] incomes; // массив доходов за каждый месяц
    int[] expenses; // массив затрат за каждый месяц

    public  YearlyReport(){
        month = new ArrayList<>();
        amount = new ArrayList<>();
        isExpenses = new ArrayList<>();

        profits = new int[3];
        incomes = new int[3];
        expenses = new int[3];
        averageIncome = 0;
        averageExpense = 0;
    }


//Нахождение затрат и доходов из годового отчёта
    public void sepIncomesExpenses(){
        for (int i = 0; i < month.size(); i++){
            if (isExpenses.get(i))
                expenses[month.get(i)-1] = amount.get(i);
            else
                incomes[month.get(i)-1] = amount.get(i);
        }
    }

    //Нахождение прибыли за каждый месяц
    public void getProfits(){
        int[] profits_ = new int[3];
        for (int i = 0; i < month.size(); i++){
            if (isExpenses.get(i))
                profits_[month.get(i)-1] -= amount.get(i);
            else
                profits_[month.get(i)-1] += amount.get(i);
        }
        profits = profits_;
    }

    //Получение среднего значения дохода за год
    public void getAverageIncome(){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < month.size(); i++){
            if (!isExpenses.get(i)) {
                averageSum += amount.get(i);
                count++;
            }
        }
        averageIncome = averageSum / count;
    }

    //Получение среднего значения затрат за год
    public void getAverageExpense(){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < month.size(); i++){
            if (isExpenses.get(i)) {
                averageSum += amount.get(i);
                count++;
            }
        }
        averageExpense = averageSum / count;
    }
}
