# Factory Design Pattern – Payment Gateway Example (LLD)

This repository demonstrates a **common design mistake** in payment systems and how it is solved using the **Factory Design Pattern**.

The goal of this project is to show:
- Why a naive if–else based approach breaks in real systems
- How Factory Pattern improves scalability and maintainability
- What interviewers expect in **Low-Level Design (LLD)** discussions
---

## Project Structure
```
factory-pattern-payment-example/
│
├── wrong-implementation/
│ └── WrongPattern.java
│
├── factory-implementation/
│ └── CorrectPattern.java
│
└── README.md
```
---
## ❌ Wrong Implementation (Problematic Design)

### What this code does
- `CheckoutService` directly decides which payment gateway to create
- Uses `if-else` conditions based on provider type
- Creates concrete objects like `StripePayment`, `PaypalPayment`, etc.

### Why this is a problem
- `CheckoutService` is tightly coupled to payment implementations
- The same `if-else` logic will be repeated in:
  - RefundService
  - SubscriptionService
  - PayoutService
  - RetryPaymentService
- Adding a new gateway (e.g. Apple Pay) requires changes in **multiple places**

This violates a key LLD principle:
New features should not require modifying existing business logic everywhere.
---
### Output (Wrong Implementation)
```
Paid 500 using Stripe
Paid 1200 using PayPal
Paid 800 using Razorpay
```

⚠️ The output is correct, but the **design does not scale**.

---

## ✅ Correct Implementation (Factory Design Pattern)

### What this code does differently
- Introduces a `PaymentGateway` interface
- Concrete classes (`StripePayment`, `PaypalPayment`, `RazorpayPayment`) implement the interface
- Object creation is moved to a single place: `PaymentFactory`
- `CheckoutService` depends only on the **abstraction**, not concrete classes

### Why this design is better
- Object creation is centralized
- Services don’t care about specific gateways
- Adding a new payment method requires minimal changes
- Code is easier to extend, test, and maintain

This is exactly what **LLD interviews** are testing for.
---
### Output (Factory Implementation)
```
Paid 500 using Stripe
Paid 1200 using PayPal
Paid 800 using Razorpay
```

✅ Same output  
✅ Much better design

---

## ▶️ How to Run the Code

### Prerequisites
- Java 8 or above
- Any IDE or command line

### Steps

#### Run Factory Implementation
```bash
javac CorrectPattern.java
java CorrectPattern


