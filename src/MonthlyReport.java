public class MonthlyReport {


    public void getSumIncomes(Data data){
        for (int i=0; i<data.sumIncomes.length; i++) {
           int sum = 0;
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (!data.isMonthExpenses[i].get(j)) {
                    sum += data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                }
            }
            data.sumIncomes[i] = sum;
        }
    }

    public void getSumExpenses(Data data){
        for (int i=0; i<data.sumExpenses.length; i++) {
            int sum = 0;
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (data.isMonthExpenses[i].get(j)) {
                    sum += data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                }
            }
            data.sumExpenses[i] = sum;
        }
    }

    public void getMaxIncomes(Data data){
        for (int i = 0; i < data.maxIncomes.length; i++){
            int maxIncome = 0;
            String item = "";
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (!data.isMonthExpenses[i].get(j)) {
                    int income = data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                    if (maxIncome < income) {
                        maxIncome = income;
                        item = data.monthItems[i].get(j);
                    }
                }
            }
            data.itemMaxIncomes[i] = item;
            data.maxIncomes[i] = maxIncome;
        }
    }

    public void getMaxExpenses(Data data){
        for (int i = 0; i < data.maxExpenses.length; i++){
            int maxExpense = 0;
            String item = "";
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (data.isMonthExpenses[i].get(j)) {
                    int  expense = data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                    if (maxExpense < expense) {
                        maxExpense = expense;
                        item = data.monthItems[i].get(j);
                    }
                }
            }
            data.itemMaxExpenses[i] = item;
            data.maxExpenses[i] = maxExpense;
        }
    }
}
