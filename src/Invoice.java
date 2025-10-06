public class Invoice{
    private String detailNumber;
    private String detailDescription;
    private int quantity;
    private double price;


    public Invoice(String detailNumber, String detailDescription, int quantity, double price) {
        this.detailNumber = detailNumber;
        this.detailDescription = detailDescription;

        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;

        if (price > 0)
            this.price = price;
        else
            this.price = 0;
    }


    public void setDetailNumber(String detailNumber){
        this.detailNumber = detailNumber;
    }

    public void setDetailDescription(String detailDescription){
        this.detailDescription = detailDescription;
    }

    public void setQuantity(int quantity){
        if (quantity > 0){
        this.quantity = quantity;
        }else{
        this.quantity = 0;
        }
    }

    public void setPrice(double price){
        if(price > 0) {
            this.price = price;
        }else{
            this.price = 0;
        };
    }

    public String getDetailNumber(){
        return detailNumber;
    }

    public String getDetailDescription(){
        return detailDescription;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }


    public double getInvoiceAmount(){
        return quantity * price;
    }

}

class InvoiceTest {
    public static void main(String[] args) {
        Invoice item1 = new Invoice("Aaa1", "Horoshaya", 11, -6.5);

        System.out.println("Номер детали: " + item1.getDetailNumber());
        System.out.println("Описание: " + item1.getDetailDescription());
        System.out.println("Количество: " + item1.getQuantity());
        System.out.println("Цена за единицу: " + item1.getPrice());
        System.out.println("Сумма счёта: " + item1.getInvoiceAmount());
    }}