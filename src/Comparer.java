public class Comparer {
    static boolean[] mistakes;
    public Comparer(){
        mistakes = new boolean[3];
    }

    public void getMistakes(MonthlyReport monthlyReport, YearlyReport yearlyReport){
        for (int i=0;i<3;i++)
           mistakes[i] = monthlyReport.sumExpenses[i] != yearlyReport.expenses[i] ||
                   monthlyReport.sumIncomes[i] != yearlyReport.incomes[i];
    }
}
