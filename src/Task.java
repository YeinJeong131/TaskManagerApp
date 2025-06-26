import javafx.beans.property.SimpleStringProperty;

// Model: Represents the data and logic for a single Task
public class Task {
    private final SimpleStringProperty title; // Task title
    private final SimpleStringProperty description; // Task description
    private final SimpleStringProperty dueDate;  // yyyy/MM/dd
    private final SimpleStringProperty dueTime;  // HH:mm:ss
    private final SimpleStringProperty courseName; // Course name
    private final SimpleStringProperty priority; // Priority as String (HIGH, MEDIUM, LOW)
    private final SimpleStringProperty status;   // Status as String (NOT_STARTED, IN_PROGRESS, COMPLETED)

    // Constructor: Initializes the task with all attributes
    public Task(String title, String description, String dueDate, String dueTime, String courseName, String priority, String status) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.dueTime = new SimpleStringProperty(dueTime);
        this.courseName = new SimpleStringProperty(courseName);
        this.priority = new SimpleStringProperty(priority);
        this.status = new SimpleStringProperty(status);
    }

    // Getter and setter for title
    public String getTitle() { return title.get(); }
    public void setTitle(String title) { this.title.set(title); }
    public SimpleStringProperty titleProperty() { return title; } // Property accessor for JavaFX binding

    // Getter and setter for description
    public String getDescription() { return description.get(); }
    public void setDescription(String description) { this.description.set(description); }
    public SimpleStringProperty descriptionProperty() { return description; } // Property accessor for JavaFX binding

    // Getter and setter for due date
    public String getDueDate() { return dueDate.get(); }
    public void setDueDate(String dueDate) { this.dueDate.set(dueDate); }
    public SimpleStringProperty dueDateProperty() { return dueDate; } // Property accessor for JavaFX binding

    // Getter and setter for due time
    public String getDueTime() { return dueTime.get(); }
    public void setDueTime(String dueTime) { this.dueTime.set(dueTime); }
    public SimpleStringProperty dueTimeProperty() { return dueTime; } // Property accessor for JavaFX binding

    // Getter and setter for course name
    public String getCourseName() { return courseName.get(); }
    public void setCourseName(String courseName) { this.courseName.set(courseName); }
    public SimpleStringProperty courseNameProperty() { return courseName; } // Property accessor for JavaFX binding

    // Getter and setter for priority
    public String getPriority() { return priority.get(); }
    public void setPriority(String priority) { this.priority.set(priority); }
    public SimpleStringProperty priorityProperty() { return priority; } // Property accessor for JavaFX binding

    // Getter and setter for status
    public String getStatus() { return status.get(); }
    public void setStatus(String status) { this.status.set(status); }
    public SimpleStringProperty statusProperty() { return status; } // Property accessor for JavaFX binding

    // Returns a string representation of the task
    @Override
    public String toString() {
        return "Task: " + getTitle() + " | Priority: " + getPriority() + " | Status: " + getStatus();
    }
}
