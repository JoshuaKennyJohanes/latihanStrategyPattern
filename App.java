import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //bikin wallet, debit, dan credit
        Wallet newWallet = new Wallet("Dompet joken", 1000000);
        CreditCard newCreditCard  = new CreditCard("1125024", 2000000, 500000, "1125024","12346");
        DebitCard kartuatm = new DebitCard("1125024",100000 ,"12345");
        EWallet gopay = new EWallet("081222874034",100000,"12345");

        PaymentProcessor processor = new PaymentProcessor();
        OTPProcessor otpProcessor = new OTPProcessor();
        
        Scanner input = new Scanner(System.in);
        System.out.print("Nominal yang dibayar:  ");
        double amount = input.nextDouble();
        readUtil.nextLine();



        //proses filter metode pembayaran berdasarkan amount

        boolean canCash = false;
        boolean canDebit = false;
        boolean canCredit = false;
        boolean canEWallet = false;
        

        System.out.println("PILIH METODE PEMBAYARAN: ");
        if(newWallet.canPay(amount)){
            canCash = true;
            System.out.println("CASH (1)");
        }
        if(newCreditCard.canPay(amount)){
            canCredit = true;
            System.out.println("CREDIT (2)");
        }
        if(kartuatm.canPay(amount)){
            canDebit = true;
            System.out.println("DEBIT(3)");

        }
        if(gopay.canPay(amount)){
            canEWallet = true;
            System.out.println("GOPAY(4)");
        }

        int pilihan = readUtil.nextInt();
        readUtil.nextLine();
        try {
            switch (pilihan) {
                case 1:
                    processor.processPayment(newWallet, amount);
                    break;
                case 2:
                    processor.processPayment(newCreditCard, amount);
                    break;
                case 3:
                    processor.processPayment(kartuatm, amount);
                    break;
                case 4:
                    String generatedOTP = String.valueOf((int)(Math.random()*900000)+100000);
                    processor.processPayment(gopay, amount);
                    System.out.println("Masukan Kode OTP Yang dikirim: ");
                    String otpInput = readUtil.nextLine();
                    otpProcessor.OTPAuthMethod(otpInput, generatedOTP);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
