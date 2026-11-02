import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //bikin wallet, debit, dan credit
        Wallet newWallet = new Wallet("Dompet joken", 1000000);
        
        CreditCard newCreditCard  = new CreditCard("1125024", 2000000, 500000, "1125024","12346");
        DebitCard kartuatm = new DebitCard("1125024",250000 ,"12345");

        
        Scanner input = new Scanner(System.in);
        System.out.print("Nominal yang dibayar:  ");
        double amount = input.nextDouble();

        System.out.println("PILIH METODE PEMBAYARAN: (1 - Cash, 2 - Debit, 3 - Credit");
        int opsi = input.nextInt();
        switch (opsi) {
            case 1:
                newWallet.pay(amount);
                break;
            case 2:
                System.out.println("PIN: ");
                String pin = input.nextLine();
                if(pin==kartuatm.pin){
                    kartuatm.pay(amount);
                } else {
                    System.out.println("PIN SALAH");
                }
                break;
            case 3:
                System.out.println("PIN: ");
                String pinCredit = input.nextLine();
                System.out.println("CCV: ");
                String ccv = input.nextLine();
                if(pinCredit == newCreditCard.pin && ccv==newCreditCard.ccv){
                    newCreditCard.pay(amount);
                } else {
                    System.out.println("PIN DAN CCV SALAH!");
                }
            default:   
                throw new AssertionError();
        }



    }
}
