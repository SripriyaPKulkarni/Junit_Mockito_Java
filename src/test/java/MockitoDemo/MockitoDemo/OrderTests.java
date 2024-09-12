package MockitoDemo.MockitoDemo;
import MockitoDemo.MockitoDemo.Order;
import MockitoDemo.MockitoDemo.PaymentProviderService;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
public class OrderTests {

	    @Test
	    public void checkoutOrderSuccessOnPaymentSuccess() {

	        Order order = new Order();
	        PaymentProviderService ppMock = mock(PaymentProviderService.class);
	        when(ppMock.processPayment()).thenReturn("Approved");

	        Assert.assertEquals(
	            "Success",
	            order.checkout(ppMock)
	        );
	    }

	    @Test
	    public void checkoutOrderFailOnPaymentFailure() {

	        Order order = new Order();
	        PaymentProviderService ppMock = mock(PaymentProviderService.class);
	        when(ppMock.processPayment()).thenReturn("Denied");

	        Assert.assertEquals(
	            "Failure",
	            order.checkout(ppMock)
	        );
	    }

	    @Test
	    public void checkoutOrder_verifyNumberOfCallsToProcessPayment_shouldBeOne() {

	        Order order = new Order();
	        PaymentProviderService ppMock = mock(PaymentProviderService.class);
	        when(ppMock.processPayment()).thenReturn("Approved");

	        order.checkout(ppMock);

	        verify(ppMock, times(1)).processPayment();
	    }

	    @Test
	    public void checkoutOrder_paymentProviderThrowsException_shouldBeCaught() {

	        Order order = new Order();
	        PaymentProviderService ppMock = mock(PaymentProviderService.class);
	        when(ppMock.processPayment()).thenThrow(new IllegalStateException());

	        Assert.assertEquals(
	            "Exception occurred at payment provider service when trying to checkout",
	            order.checkout(ppMock)
	        );
	    }
	}

