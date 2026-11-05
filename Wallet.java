
import java.util.ArrayList;
import java.util.List;



public class Wallet implements PaymentStrategy {
    private String name;
    double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    @Override
    public boolean validate(double amount) {
        return cashValue >= amount;
    }

    @Override
    public void pay(double amount) {
        cashValue = cashValue - amount;
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> listMethod = new ArrayList<>();
        return listMethod;
    }

    

    @Override
    public boolean canPay(double amount) {
        return amount <=1000000 && amount>=100;
    }

    

    

    

        
}
