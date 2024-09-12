package MockitoDemo.MockitoDemo;

public class Order {

	    public Order() {
	    }

	    public String checkout(PaymentProviderService payment) {
	        try {
	            return payment.processPayment().equalsIgnoreCase("Approved") ? "Success" : "Failure";
	        }
	        catch(Exception e) {
	            return "Exception occurred at payment provider service when trying to checkout";
	        }
	    }
	}

