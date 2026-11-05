public class OTPProcessor {
    public void OTPAuthMethod(String OTP, String generatedOTPString) throws Exception{
        if(!OTP.equalsIgnoreCase(generatedOTPString)){
            throw new Exception("Kode OTP Tidak Valid!");
        };
    }
}
