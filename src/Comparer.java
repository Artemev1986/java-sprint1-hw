//Класс отвечает за сравнивание месячных и годового отчётов
public class Comparer {

    //Нахождение несоответствий суммы затрат и доходов между годовым и месяными отчётами
    public void getMistakes(Data data){
        for (int i=0;i<3;i++)
           data.mistakes[i] = data.sumExpenses[i] != data.expenses[i] ||
                   data.sumIncomes[i] != data.incomes[i];
    }
}
