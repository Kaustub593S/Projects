package List;
public class Task 
{
    private String description;
    private String priority; // "High", "Medium", "Low"
    private String dueDate;  // Format: "YYYY-MM-DD"

    public Task(String description, String priority, String dueDate) {
        this.description = description.toLowerCase().trim(); // Normalize
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return description + " [Priority: " + priority + ", Due: " + dueDate + "]";
    }

    // For checking duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task t = (Task) o;
        return this.description.equalsIgnoreCase(t.description); // Only desc checked
    }

    @Override
    public int hashCode() {
        return description.toLowerCase().hashCode();
    }
}
