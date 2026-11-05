
import com.sun.security.jgss.AuthorizationDataEntry;

import java.util.ArrayList;
import java.util.List;

public class EWallet implements PaymentStrategy {
    String phoneNumber;
    double balance;
    String pin;
    
    public EWallet(String phoneNumber, double balance, String pin){
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean validate(double amount) {
        return balance>=amount;
    }

    @Override
    public void pay(double amount) {
        if(validate(amount)){
            balance = balance-amount;
        } else {
            System.out.println("Saldo Kurang!");
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> methodList = List.of(AuthorizationMethod.OTP,AuthorizationMethod.PIN);
        return methodList;
    }

    @Override
    public boolean canPay(double amount){
        return amount <= 10000000 && amount >= 100;
    }

}
