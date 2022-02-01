import java.util.ArrayList;

//Класс отвечает за формирование месяных отчётов
public class MonthlyReport {

    ArrayList<ReportM>[] incomes; //список дходов
    ArrayList<ReportM>[] expenses; //список затрат

    String[] monthNames; // массив названий месяцев

    public MonthlyReport(){
        incomes = new ArrayList[3];
        for (int i = 0; i < incomes.length; i++)
            incomes[i] = new ArrayList<>();

        expenses = new ArrayList[3];
        for (int i = 0; i < expenses.length; i++)
            expenses[i] = new ArrayList<>();

        monthNames = new String[]{"январь", "февраль", "март"};

    }

    public static class ReportM {
        String item="";
        int quantity=0;
        int price=0;
    }

    public class MaxSum{
        String item="";
        int max=0;
    }

    //Получение суммы
    public int[] getSum(ArrayList<ReportM>[] reports){
        int[] sums = new int[3];
        for (int i=0; i<reports.length; i++) {
            int sum = 0;
            for (int j = 0; j < reports[i].size(); j++) {
                sum += reports[i].get(j).quantity * reports[i].get(j).price;
            }
            sums[i] = sum;
        }
        return sums;
    }

    //Получение суммы дохода за месяц
    public int[] getSumIncomes(){
        return getSum(incomes);
    }

    //Получение суммы затрат за месяц
    public int[] getSumExpenses(){
        return getSum(expenses);
    }

    public MaxSum[] getMax(ArrayList<ReportM>[] reports){
        MaxSum[] maxSum = new MaxSum[3];
        for (int i = 0; i < maxSum.length; i++){
            maxSum[i] = new MaxSum();
            int max = 0;
            String item = "";
            for (int j = 0; j < reports[i].size(); j++) {
                int sum = reports[i].get(j).quantity * reports[i].get(j).price;
                if (max < sum) {
                    max = sum;
                    item = reports[i].get(j).item;
                }
            }
            maxSum[i].item = item;
            maxSum[i].max = max;
        }
        return maxSum;
    }

    //Нахождение максимального дохода и наименование соответствующего товара в месяце
    public MaxSum[] getMaxIncomes(){
        return getMax(incomes);
    }

    //Нахождение максимальной траты и наименование соответствующего товара в месяце
    public MaxSum[] getMaxExpenses(){
        return getMax(expenses);
    }
}
