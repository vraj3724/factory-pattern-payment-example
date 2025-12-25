interface PaymentGateway {
    void pay(int amount);
}

class StripePayment implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Stripe");
    }
}

class PaypalPayment implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class RazorpayPayment implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Razorpay");
    }
}

class PaymentFactory {

    static PaymentGateway getGateway(String provider) {

        if (provider.equals("STRIPE")) {
            return new StripePayment();
        }

        if (provider.equals("PAYPAL")) {
            return new PaypalPayment();
        }

        if (provider.equals("RAZORPAY")) {
            return new RazorpayPayment();
        }

        throw new IllegalArgumentException("Unsupported provider");
    }
}

class CheckoutService {

    void checkout(String provider, int amount) {

        PaymentGateway gateway = PaymentFactory.getGateway(provider);
        gateway.pay(amount);
    }
}

public class CorrectPattern {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        service.checkout("STRIPE", 500);
        service.checkout("PAYPAL", 1200);
        service.checkout("RAZORPAY", 800);
    }
}

