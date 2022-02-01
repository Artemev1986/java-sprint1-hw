public class ReportY {
    int month;
    int income;
    int expense;
    public ReportY(){
        month = 0;
        income = 0;
        expense = 0;
    }

    //Нахождение прибыли
    public int getProfit(){
        return income - expense;
    }
}