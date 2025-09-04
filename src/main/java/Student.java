import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private Instant entryDate;
    private List<Group> groupHistory = new ArrayList<>();

    public Student(int id, String lastName, String firstName, Instant entryDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public Instant getEntryDate() {
        return entryDate;
    }
    public List<Group> getGroupHistory() {
        return groupHistory;
    }
    public void addGroup(Group group) {
        this.groupHistory.add(group);
    }
}

