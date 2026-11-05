
import java.util.ArrayList;
import java.util.List;

public class DebitCard implements PaymentStrategy{
    String cardNumber;
    double balance;
    String pin;

    public DebitCard(String cardNumber, double balance, String pin){
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getPin(){
        return this.pin;
    }

    @Override 
    public boolean validate(double amount){
        return balance >= amount;
    }

    @Override 
    public void pay(double amount) {
        if(validate(amount)){       
            balance = balance - amount;
        } else {
            System.out.print("Saldo Kurang!");
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> methodList = new ArrayList<>();
        return methodList;
    }

    

    @Override
    public boolean canPay(double amount) {
        return amount<=10000000;
    }

    
}