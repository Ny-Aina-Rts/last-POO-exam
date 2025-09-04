import java.time.Instant;
import java.util.Objects;

public abstract class Payment {
    private int id;
    private double amount;
    private Instant dateTime;

    public Payment(int id, double amount, Instant dateTime) {
        this.id = id;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public Instant getDateTime() {
        return dateTime;
    }
    public abstract String getPaymentType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && Double.compare(payment.amount, amount) == 0 && Objects.equals(dateTime, payment.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, dateTime);
    }
}
