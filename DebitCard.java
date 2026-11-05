
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
    public void processPayment(PaymentStrategy paymentStrategy, double amount) throws Exception {
        if(!paymentStrategy.validate(amount)){
            throw new Exception("Saldomu Kurang!");
        }

        List<AuthorizationMethod> requiredAuthorizations = paymentStrategy.getRequiredAuthorizations();
        String PIN;
        for(int i = 0 ; i < requiredAuthorizations.size() ; i++){
            if (requiredAuthorizations.get(i)==AuthorizationMethod.PIN){
                System.out.println("Masukan PIN: ");
                PIN = readUtil.nextLine();
                if(pin==null){
                    throw new Exception("PIN tidak boleh kosong!");
                } else if(!PIN.equals(pin)){
                    throw new Exception("PIN salah, tolong masukan kembali!");
                }
            } 
        }
        paymentStrategy.pay(amount);
    }

    @Override
    public boolean canPay(double amount) {
        return amount<=10000000;
    }

    
}