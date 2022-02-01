public class ReportM {
    String item;
    int quantity;
    int price;

    public ReportM(){
         item="";
         quantity=0;
        price=0;
    }

    //Получение суммы
    public int getSum(){
        return quantity * price;
    }
}