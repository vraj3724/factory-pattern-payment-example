class StripePayment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Stripe");
    }
}

class PaypalPayment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class RazorpayPayment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Razorpay");
    }
}

class CheckoutService {

    void checkout(String provider, int amount) {

        if (provider.equals("STRIPE")) {
            StripePayment stripe = new StripePayment();
            stripe.pay(amount);

        } else if (provider.equals("PAYPAL")) {
            PaypalPayment paypal = new PaypalPayment();
            paypal.pay(amount);

        } else if (provider.equals("RAZORPAY")) {
            RazorpayPayment razorpay = new RazorpayPayment();
            razorpay.pay(amount);

        } else {
            throw new IllegalArgumentException("Unsupported provider");
        }
    }
}

public class WrongPattern {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        service.checkout("STRIPE", 500);
        service.checkout("PAYPAL", 1200);
        service.checkout("RAZORPAY", 800);
    }
}
