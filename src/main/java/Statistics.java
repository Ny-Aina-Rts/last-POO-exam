import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public List<Fee> getLateFees(List<Fee> fees, Instant t) {
        List<Fee> lateFees = new ArrayList<>();
        for (Fee f : fees) {
            if (f.getStatus(t) == FeeStatus.LATE) {
                lateFees.add(f);
            }
        }
        return lateFees;
    }

    public double getTotalMissingFees(List<Fee> fees, Instant t) {
        double totalMissing = 0;
        for (Fee f : fees) {
            if (f.getStatus(t) == FeeStatus.LATE) {
                totalMissing += f.getMissingAmount(t);
            }
        }
        return totalMissing;
    }

    public double getTotalPaidByStudent(Student student, List<Fee> fees, Instant t) {
        double totalPaid = 0;
        for (Fee f : fees) {
            if (f.getStudent().equals(student)) {
                totalPaid += f.getTotalPaid(t);
            }
        }
        return totalPaid;
    }
}