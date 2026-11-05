
import java.util.List;


public class PaymentProcessor{
    public void processPayment(PaymentStrategy strategy, double amount) throws Exception {
        if(!strategy.validate(amount)){
            throw new Exception("Gagal Melakukan Pembayaran");
        } 

        List<AuthorizationMethod> requiredAuthorization  = strategy.getRequiredAuthorizations();

        
        for (int i = 0 ; i < requiredAuthorization.size() ; i++){
            AuthorizationMethod auth = requiredAuthorization.get(i);

            switch(auth){

                case PIN:
                    System.out.println("Masukan PIN!");
                    String inputPin = readUtil.nextLine();

                    if(strategy instanceof DebitCard){
                        DebitCard card = (DebitCard) strategy;
                        if(!card.getPin().equals(inputPin)){
                            throw new Exception("PIN SALAH!");
                        }
                    }
                    break;
                    
                case CCV:
                    System.out.println("Masukan CCV!");
                    String ccv = readUtil.nextLine();

                    if(strategy instanceof CreditCard){
                        CreditCard card = (CreditCard) strategy;
                        if(!card.getCCV().equals(ccv)){
                            throw new Exception("CCV SALAH!");
                        }
                    }
            }
        }
        strategy.pay(amount);
        System.out.println("Pembayaran Berhasil!");
    }       
}
