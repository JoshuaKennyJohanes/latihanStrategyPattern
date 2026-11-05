
import java.util.ArrayList;
import java.util.List;

public class CreditCard implements PaymentStrategy{
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


    public String getCCV(){
        return this.ccv;
    }

    public String getPin(){
        return this.pin;
    }

    @Override 
    public boolean validate(double amount){
        return amount<=limit-currentDebt;
    }

    @Override 
    public void pay(double amount){
        if(validate(amount)){
            currentDebt = currentDebt + amount;
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> methodList = new ArrayList<>();
        methodList.add(AuthorizationMethod.CCV);
        methodList.add(AuthorizationMethod.PIN);
        return methodList;
    }


    @Override
    public boolean canPay(double amount) {
        return amount <=1000000 && amount >=100000;
    }

    

    


    
}
