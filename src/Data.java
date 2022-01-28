import java.util.ArrayList;

public class Data{
    ArrayList<String>[] monthItems;
    ArrayList<Boolean>[] isMonthExpenses;
    ArrayList<Integer>[] monthQuantity;
    ArrayList<Integer>[] monthPrice;
    ArrayList<Integer> month;
    ArrayList<Integer> amount;
    ArrayList<Boolean> isExpenses;

    int[] sumIncomes;
    int[] sumExpenses;
    int[] maxIncomes;
    String[] itemMaxIncomes;
    int[] maxExpenses;
    String[] itemMaxExpenses;
    String[] monthNames;

    int[] profits;
    int averageIncome;
    int averageExpense;
    int[] incomes;
    int[] expenses;

    boolean[] mistakes;

    public Data(){
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

        month = new ArrayList<>();
        amount = new ArrayList<>();
        isExpenses = new ArrayList<>();

        sumIncomes = new int[3];
        sumExpenses = new int[3];
        maxIncomes = new int[3];
        itemMaxIncomes = new String[3];
        maxExpenses = new int[3];
        itemMaxExpenses = new String[3];
        monthNames = new String[]{"январь", "февраль", "март"};

        profits = new int[3];
        incomes = new int[3];
        expenses = new int[3];
        averageIncome = 0;
        averageExpense = 0;

        mistakes = new boolean[3];
    }
}
