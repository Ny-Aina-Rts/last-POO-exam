import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Fee {
    private int id;
    private String label;
    private double amount;
    private Instant deadline;
    private Student student;
    private List<Payment> payments = new ArrayList<>();

    public Fee(int id, String label, double amount, Instant deadline, Student student) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        this.deadline = deadline;
        this.student = student;
    }

    public int getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public double getAmount() {
        return amount;
    }
    public Instant getDeadline() {
        return deadline;
    }
    public Student getStudent() {
        return student;
    }
    public List<Payment> getPayments() {
        return payments;
    }
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    double getTotalPaid(Instant t) {
        double sum = 0;
        for (Payment p : payments) {
            if (!p.getDateTime().isAfter(t)) {
                sum += p.getAmount();
            }
        }
        return sum;
    }

    public FeeStatus getStatus(Instant t) {
        double totalPaid = getTotalPaid(t);
        if (totalPaid == 0) {
            return FeeStatus.NONE;
        }
        if (totalPaid > amount) {
            return FeeStatus.OVERPAID;
        }
        if (totalPaid == amount) {
            return FeeStatus.PAID;
        }
        if (t.isBefore(deadline)) {
            return FeeStatus.IN_PROGRESS;
        } else {
            return FeeStatus.LATE;
        }
    }

    public double getMissingAmount(Instant t) {
        double totalPaid = getTotalPaid(t);
        return amount - totalPaid;
    }
}
