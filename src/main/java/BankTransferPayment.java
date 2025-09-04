import java.time.Instant;
import java.util.Objects;

public class BankTransferPayment extends Payment {
    private String reference;

    public BankTransferPayment(int id, double amount, Instant dateTime, String reference) {
        super(id, amount, dateTime);
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String getPaymentType() {
        return "Bank Transfer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BankTransferPayment that = (BankTransferPayment) o;
        return Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reference);
    }
}
