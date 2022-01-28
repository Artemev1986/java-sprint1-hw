public class Comparer {

    public void getMistakes(Data data){
        for (int i=0;i<3;i++)
           data.mistakes[i] = data.sumExpenses[i] != data.expenses[i] ||
                   data.sumIncomes[i] != data.incomes[i];
    }
}
