import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Controller: Manages the list of tasks and interactions with the model
public class TaskController {
    private final ObservableList<Task> tasks; // Observable list for binding with the view

    public TaskController() {
        this.tasks = FXCollections.observableArrayList();
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title, String description, String dueDate, String dueTime, String courseName, String priority, String status) {
        tasks.add(new Task(title, description, dueDate, dueTime, courseName, priority, status));
    }

    public void removeTask(String title) {
        tasks.removeIf(task -> task.getTitle().equals(title));
    }

    public void updateTask(String title, String newDescription, String newPriority, String newStatus) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.setDescription(newDescription);
                task.setPriority(newPriority);
                task.setStatus(newStatus);
                break;
            }
        }
    }
    public void modifyTask(String title, String newDescription, String newDueDate, String newDueTime, String newCourseName, String newPriority, String newStatus) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                // Modify only provided fields
                if (newDescription != null && !newDescription.isEmpty()) {
                    task.setDescription(newDescription);
                }
                if (newDueDate != null && !newDueDate.isEmpty()) {
                    task.setDueDate(newDueDate);
                }
                if (newDueTime != null && !newDueTime.isEmpty()) {
                    task.setDueTime(newDueTime);
                }
                if (newCourseName != null && !newCourseName.isEmpty()) {
                    task.setCourseName(newCourseName);
                }
                if (newPriority != null && !newPriority.isEmpty()) {
                    task.setPriority(newPriority);
                }
                if (newStatus != null && !newStatus.isEmpty()) {
                    task.setStatus(newStatus);
                }
                break;
            }
        }
    }    
}
