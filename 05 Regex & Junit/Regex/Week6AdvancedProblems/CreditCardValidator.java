public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        String visaRegex="^4[0-9]{15}$";
        String masterCardRegex="^5[0-9]{15}$";
        if (cardNumber.matches(visaRegex)) {
            return true;
        } else if (cardNumber.matches(masterCardRegex)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValidCreditCard("4123456789012345"));  
        System.out.println(isValidCreditCard("5123456789012345"));  
        System.out.println(isValidCreditCard("6123456789012345")); 
        System.out.println(isValidCreditCard("412345678901234"));
    }
}