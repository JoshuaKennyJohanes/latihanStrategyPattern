public class Wallet {
    private String name;
    double cashValue;

    public Wallet(String name, double cashValue){
        this.name = name;
        this.cashValue = cashValue;
    }

    public boolean validate(double amount){
        return cashValue >= amount;
    }

    public void pay(double amount){
        cashValue = cashValue - amount;
    }
}