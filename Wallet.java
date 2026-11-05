
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
        listMethod.add(null);
        return listMethod;
    }

    @Override
    public void processPayment(PaymentStrategy paymentStrategy, double amount) throws Exception {
        if(!validate(amount)){
            throw new Exception("Uang mu kurang!");
        } else {
            paymentStrategy.pay(amount);
        }
    }

    

    

        
}
