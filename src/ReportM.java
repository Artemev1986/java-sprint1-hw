public class ReportM {
    String item = "";
    int quantity = 0;
    int price = 0;

    //Получение суммы
    public int getSum(){
        return quantity * price;
    }
}