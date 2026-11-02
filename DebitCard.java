public class DebitCard {
    String cardNumber;
    double balance;
    String pin;

    public DebitCard(String cardNumber, double balance, String pin){
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validate(double amount){
        return balance >= amount;
    }

    public void pay(double amount) {
        if(validate(amount)){       
            balance = balance - amount;
        } else {
            System.out.print("Saldo Kurang!");
        }
    }



}