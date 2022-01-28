import java.util.ArrayList;

public class Data{
    ArrayList<String>[] monthItems;
    ArrayList<Boolean>[] isMonthExpenses;
    ArrayList<Integer>[] monthQuantity;
    ArrayList<Integer>[] monthPrice;
    ArrayList<Integer> month;
    ArrayList<Integer> amount;
    ArrayList<Boolean> isExpenses;

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
    }
}
