public class YearlyReport {
    static int[] profits;
    static int averageIncome;
    static int averageExpense;
    static int[] incomes;
    static int[] expenses;

    public YearlyReport(){
        profits = new int[3];
        incomes = new int[3];
        expenses = new int[3];
        averageIncome = 0;
        averageExpense = 0;
    }

    public void sepIncomesExpenses(Data data){
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i))
                expenses[data.month.get(i)-1] = data.amount.get(i);
            else
                incomes[data.month.get(i)-1] = data.amount.get(i);
        }
    }

    public void getProfits(Data data){
        int[] profits_ = new int[3];
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i))
                profits_[data.month.get(i)-1] -= data.amount.get(i);
            else
                profits_[data.month.get(i)-1] += data.amount.get(i);
        }
        profits = profits_;
    }

    public void getAverageIncome(Data data){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < data.month.size(); i++){
            if (!data.isExpenses.get(i)) {
                averageSum += data.amount.get(i);
                count++;
            }
        }
        averageIncome = averageSum / count;
    }

    public void getAverageExpense(Data data){
        int averageSum = 0;
        int count=0;
        for (int i = 0; i < data.month.size(); i++){
            if (data.isExpenses.get(i)) {
                averageSum += data.amount.get(i);
                count++;
            }
        }
        averageExpense = averageSum / count;
    }
}
