
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
    public void processPayment(PaymentStrategy paymentStrategy, double amount) throws Exception {
        if(!validate(amount)){
            throw new Exception("Limit Melebihi!");
        }

        List<AuthorizationMethod> reqAuthorizationMethods = paymentStrategy.getRequiredAuthorizations();
        String CCV;
        String PIN;
        for(int i = 0 ; i < reqAuthorizationMethods.size() ; i++){
            
            
            if(reqAuthorizationMethods.get(i)==AuthorizationMethod.CCV){
                System.out.println("Masukan Kode CCV: ");
                CCV = readUtil.nextLine();
                if(CCV==null){
                    throw new Exception("Kode CV tidak boleh kosong!");
                } else if(!CCV.equalsIgnoreCase(ccv)){
                    throw new Exception("Kode CV tidak sesuai, mohon masukan kemabli");
                }
            } 
            
            if(reqAuthorizationMethods.get(i)==AuthorizationMethod.PIN){
                System.out.println("Masukan PIN: ");
                PIN = readUtil.nextLine();  
                if(PIN==null){
                    throw new Exception("PIN tidak boleh kosong!");
                } else if(!PIN.equalsIgnoreCase(pin)){
                    throw new Exception("PIN tidak sesuai, tolong masukan kembali!");
                }
            }

            paymentStrategy.pay(amount);
        }



    }

    


    
}
