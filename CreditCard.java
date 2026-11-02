public class CreditCard {
    String cardNumber;
    double limit;   
    double currentDebt;
    String ccv;
    String pin;
    public CreditCard(String cardNumber, double limit, double currentDebt, String ccv, String pin){
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.currentDebt = currentDebt;
        this.ccv = ccv;
        this.pin = pin;
    }

    public boolean validate(double amount){
        return amount<=limit-currentDebt;
    }

    public void pay(double amount){
        if(validate(amount)){
            currentDebt = currentDebt + amount;
        }
    }
}
