public class MonthlyReport {
    static int[] sumIncomes;
    static int[] sumExpenses;
    static int[] maxIncomes;
    static String[] itemMaxIncomes;
    static int[] maxExpenses;
    static String[] itemMaxExpenses;
    String[] month;

    public MonthlyReport(){
        sumIncomes = new int[3];
        sumExpenses = new int[3];
        maxIncomes = new int[3];
        itemMaxIncomes = new String[3];
        maxExpenses = new int[3];
        itemMaxExpenses = new String[3];
        month = new String[]{"январь", "февраль", "март"};
    }

    public void getSumIncomes(Data data){
        for (int i=0; i<sumIncomes.length; i++) {
           int sum = 0;
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (!data.isMonthExpenses[i].get(j)) {
                    sum += data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                }
            }
            sumIncomes[i] = sum;
        }
    }

    public void getSumExpenses(Data data){
        for (int i=0; i<sumExpenses.length; i++) {
            int sum = 0;
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (data.isMonthExpenses[i].get(j)) {
                    sum += data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                }
            }
            sumExpenses[i] = sum;
        }
    }

    public void getMaxIncomes(Data data){
        for (int i = 0; i < maxIncomes.length; i++){
            int maxIncome = 0;
            int Incit = 0;
            String item = "";
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (!data.isMonthExpenses[i].get(j)) {
                    Incit = data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                    if (maxIncome < Incit) {
                        maxIncome = Incit;
                        item = data.monthItems[i].get(j);
                    }
                }
            }
            itemMaxIncomes[i] = item;
            maxIncomes[i] = maxIncome;
        }
    }

    public void getMaxExpenses(Data data){
        for (int i = 0; i < maxExpenses.length; i++){
            int maxExpense = 0;
            int expense = 0;
            String item = "";
            for (int j = 0; j < data.isMonthExpenses[i].size(); j++) {
                if (data.isMonthExpenses[i].get(j)) {
                    expense = data.monthQuantity[i].get(j) * data.monthPrice[i].get(j);
                    if (maxExpense < expense) {
                        maxExpense = expense;
                        item = data.monthItems[i].get(j);
                    }
                }
            }
            itemMaxExpenses[i] = item;
            maxExpenses[i] = maxExpense;
        }
    }
}
