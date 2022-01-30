// класс Data отвечает за хранение данных

import java.util.ArrayList;

public class Data{
    ArrayList<String>[] monthItems; // список товаров (за все месяцы) из месячных отчётов
    ArrayList<Boolean>[] isMonthExpenses; // список меток, определяющих трату или доход (за все месяцы) из месячных отчётов
    ArrayList<Integer>[] monthQuantity; // список количество товаров или услуг (за все месяцы) из месячных отчётов
    ArrayList<Integer>[] monthPrice; // список цен за единицу товара или услуги (за все месяцы) из месячных отчётов
    ArrayList<Integer> month; // список номеров месяца из годового отчета
    ArrayList<Integer> amount; // список сумм товаров или услуг за месяц из годового отчёта
    ArrayList<Boolean> isExpenses; // список меток, определяющих трату или доход из годового отчёта

    int[] sumIncomes; // массив сумм дохода за месяц
    int[] sumExpenses; // массив сумм трат за месяц
    int[] maxIncomes; // массив доходов за самый выгодный товар или услугу в месяце
    String[] itemMaxIncomes; // массив самых доходных товаров или услуг в месяце
    int[] maxExpenses; // массив трат за самый затратный товар или услугу в месяце
    String[] itemMaxExpenses; // массив самых затратный товар или услугу в месяце
    String[] monthNames; // массив названий месяцев

    int[] profits; // массив прибыли за каждый месяц
    int averageIncome; // массив среднего дохода за каждый месяц
    int averageExpense; // массив средних затрат за каждый месяц
    int[] incomes; // массив доходов за каждый месяц
    int[] expenses; // массив затрат за каждый месяц

    boolean[] mistakes; // массив ошибок (при сверке отчётов)

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
