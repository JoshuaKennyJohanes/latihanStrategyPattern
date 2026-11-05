import java.util.*;

public interface PaymentStrategy {
    
    public boolean validate(double amount);
    public void pay(double amount);
    public List<AuthorizationMethod> getRequiredAuthorizations();
    public void processPayment(PaymentStrategy paymentStrategy, double amount) throws Exception;
}

