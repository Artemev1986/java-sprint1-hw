import java.util.ArrayList;

//Класс отвечает за формирование месяных отчётов
public class MonthlyReport {

    ArrayList<String>[] monthItems; // список товаров (за все месяцы) из месячных отчётов
    ArrayList<Boolean>[] isMonthExpenses; // список меток, определяющих трату или доход (за все месяцы) из месячных отчётов
    ArrayList<Integer>[] monthQuantity; // список количество товаров или услуг (за все месяцы) из месячных отчётов
    ArrayList<Integer>[] monthPrice; // список цен за единицу товара или услуги (за все месяцы) из месячных отчётов

    int[] sumIncomes; // массив сумм дохода за месяц
    int[] sumExpenses; // массив сумм трат за месяц
    int[] maxIncomes; // массив доходов за самый выгодный товар или услугу в месяце
    String[] itemMaxIncomes; // массив самых доходных товаров или услуг в месяце
    int[] maxExpenses; // массив трат за самый затратный товар или услугу в месяце
    String[] itemMaxExpenses; // массив самых затратный товар или услугу в месяце
    String[] monthNames; // массив названий месяцев

    boolean[] mistakes; // массив ошибок (при сверке отчётов)

    public MonthlyReport(){
        monthItems = new ArrayList[3];
        for (int i = 0; i < monthItems.length; i++)
            monthItems[i] = new ArrayList<>();

        isMonthExpenses = new ArrayList[3];
        for (int i = 0; i < isMonthExpenses.length; i++)
            isMonthExpenses[i] = new ArrayList<>();

        monthQuantity = new ArrayList[3];
        for (int i = 0; i < monthQuantity.length; i++)
            monthQuantity[i] = new ArrayList<>();

        monthPrice = new ArrayList[3];
        for (int i = 0; i < monthPrice.length; i++)
            monthPrice[i] = new ArrayList<>();

        sumIncomes = new int[3];
        sumExpenses = new int[3];
        maxIncomes = new int[3];
        itemMaxIncomes = new String[3];
        maxExpenses = new int[3];
        itemMaxExpenses = new String[3];
        monthNames = new String[]{"январь", "февраль", "март"};

        mistakes = new boolean[3];
    }
//Получение суммы дохода за месяц
    public void getSumIncomes(){
        for (int i=0; i<sumIncomes.length; i++) {
           int sum = 0;
            for (int j = 0; j < isMonthExpenses[i].size(); j++) {
                if (!isMonthExpenses[i].get(j)) {
                    sum += monthQuantity[i].get(j) * monthPrice[i].get(j);
                }
            }
            sumIncomes[i] = sum;
        }
    }

    //Получение суммы затрат за месяц
    public void getSumExpenses(){
        for (int i=0; i<sumExpenses.length; i++) {
            int sum = 0;
            for (int j = 0; j < isMonthExpenses[i].size(); j++) {
                if (isMonthExpenses[i].get(j)) {
                    sum += monthQuantity[i].get(j) * monthPrice[i].get(j);
                }
            }
            sumExpenses[i] = sum;
        }
    }

    //Нахождение максимального дохода и наименование соответствующего товара в месяце
    public void getMaxIncomes(){
        for (int i = 0; i < maxIncomes.length; i++){
            int maxIncome = 0;
            String item = "";
            for (int j = 0; j < isMonthExpenses[i].size(); j++) {
                if (!isMonthExpenses[i].get(j)) {
                    int income = monthQuantity[i].get(j) * monthPrice[i].get(j);
                    if (maxIncome < income) {
                        maxIncome = income;
                        item = monthItems[i].get(j);
                    }
                }
            }
            itemMaxIncomes[i] = item;
            maxIncomes[i] = maxIncome;
        }
    }

    //Нахождение максимальной траты и наименование соответствующего товара в месяце
    public void getMaxExpenses(){
        for (int i = 0; i < maxExpenses.length; i++){
            int maxExpense = 0;
            String item = "";
            for (int j = 0; j < isMonthExpenses[i].size(); j++) {
                if (isMonthExpenses[i].get(j)) {
                    int  expense = monthQuantity[i].get(j) * monthPrice[i].get(j);
                    if (maxExpense < expense) {
                        maxExpense = expense;
                        item = monthItems[i].get(j);
                    }
                }
            }
            itemMaxExpenses[i] = item;
            maxExpenses[i] = maxExpense;
        }
    }
}
