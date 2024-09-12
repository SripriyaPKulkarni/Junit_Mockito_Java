package MockitoDemo.MockitoDemo;

import java.util.Random;

public class PaymentProviderService {

    public PaymentProviderService() {
    }

    public String processPayment() throws IllegalStateException {

        String[] payment_status = {"Approved", "Denied", "Exception"};
        Random r = new Random();

        int randomIndex = r.nextInt(payment_status.length);

        if(payment_status[randomIndex].equalsIgnoreCase("Exception")) {
            throw new IllegalStateException();
        }

        return payment_status[randomIndex];
    }
}


