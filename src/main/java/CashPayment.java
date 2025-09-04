import java.time.Instant;

public class CashPayment extends Payment {
    public CashPayment(int id, double amount, Instant dateTime) {
        super(id, amount, dateTime);
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}
