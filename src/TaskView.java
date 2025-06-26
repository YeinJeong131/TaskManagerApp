import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

// View: Displays the user interface and handles user interactions
public class TaskView extends VBox {
    public TaskView(TaskController controller, Stage primaryStage) {
        super(10); // Spacing between UI components
        this.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Task Planner");

        // TableView: Displays the list of tasks
        TableView<Task> taskTable = new TableView<>(controller.getTasks());

        // Set a custom placeholder message
        taskTable.setPlaceholder(new Label("No tasks added yet. Click 'Add Task' to start."));

        // Create table columns for each attribute
        TableColumn<Task, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(data -> data.getValue().titleProperty());

        TableColumn<Task, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(data -> data.getValue().descriptionProperty());

        TableColumn<Task, String> dueDateColumn = new TableColumn<>("Due Date");
        dueDateColumn.setCellValueFactory(data -> data.getValue().dueDateProperty());

        TableColumn<Task, String> dueTimeColumn = new TableColumn<>("Due Time");
        dueTimeColumn.setCellValueFactory(data -> data.getValue().dueTimeProperty());

        TableColumn<Task, String> courseNameColumn = new TableColumn<>("Course Name");
        courseNameColumn.setCellValueFactory(data -> data.getValue().courseNameProperty());

        TableColumn<Task, String> priorityColumn = new TableColumn<>("Priority");
        priorityColumn.setCellValueFactory(data -> data.getValue().priorityProperty());

        TableColumn<Task, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());

        // Add all columns to the table
        taskTable.getColumns().addAll(titleColumn, descriptionColumn, dueDateColumn, dueTimeColumn, courseNameColumn, priorityColumn, statusColumn);

        // Buttons: Add and remove tasks
        Button addButton = new Button("Add Task");
        addButton.setOnAction(event -> openAddTaskWindow(controller, primaryStage));

        Button removeButton = new Button("Remove Task");
        removeButton.setOnAction(event -> openRemoveTaskWindow(controller, primaryStage));

        Button modifyButton = new Button("Modify Task");
        modifyButton.setOnAction(event -> openModifyTaskWindow(controller, primaryStage));


        HBox buttonRow = new HBox(10, addButton, removeButton, modifyButton);
        buttonRow.setAlignment(Pos.CENTER);

        // Add components to the layout
        this.getChildren().addAll(titleLabel, taskTable, buttonRow);
    }

    // Opens a window to add a new task
    private void openAddTaskWindow(TaskController controller, Stage owner) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);

        TextField titleField = new TextField();
        titleField.setPromptText("Task Title");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Task Description");

        TextField dueDateField = new TextField();
        dueDateField.setPromptText("Due Date (yyyy/MM/dd)");

        TextField dueTimeField = new TextField();
        dueTimeField.setPromptText("Due Time (HH:mm:ss)");

        TextField courseNameField = new TextField();
        courseNameField.setPromptText("Course Name");

        TextField priorityField = new TextField();
        priorityField.setPromptText("Priority (HIGH, MEDIUM, LOW)");

        // Radio buttons for status selection in a single row
        ToggleGroup statusGroup = new ToggleGroup();
        RadioButton inProgressButton = new RadioButton("In progress");
        inProgressButton.setToggleGroup(statusGroup);
        inProgressButton.setUserData("IN_PROGRESS");

        RadioButton doneButton = new RadioButton("Completed");
        doneButton.setToggleGroup(statusGroup);
        doneButton.setUserData("COMPLETED");

        RadioButton wontCompleteButton = new RadioButton("Not Started");
        wontCompleteButton.setToggleGroup(statusGroup);
        wontCompleteButton.setUserData("NOT_STARTED");

        HBox statusBox = new HBox(10, inProgressButton, doneButton, wontCompleteButton);
        statusBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Add");
        submitButton.setOnAction(event -> {
            String status = statusGroup.getSelectedToggle() != null
                    ? statusGroup.getSelectedToggle().getUserData().toString()
                    : "NOT_STARTED";
            controller.addTask(
                    titleField.getText(),
                    descriptionField.getText(),
                    dueDateField.getText(),
                    dueTimeField.getText(),
                    courseNameField.getText(),
                    priorityField.getText(),
                    status
            );
            stage.close();
        });

        VBox root = new VBox(10, titleField, descriptionField, dueDateField, dueTimeField, courseNameField, priorityField, statusBox, submitButton);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    // Opens a window to remove a task by title
    private void openRemoveTaskWindow(TaskController controller, Stage owner) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);

        Label instructionLabel = new Label("Enter the title of the task to remove:");

        TextField titleField = new TextField();
        titleField.setPromptText("Task Title");

        Button submitButton = new Button("Remove");
        submitButton.setOnAction(event -> {
            controller.removeTask(titleField.getText());
            stage.close();
        });

        VBox root = new VBox(10, instructionLabel, titleField, submitButton);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    private void openModifyTaskWindow(TaskController controller, Stage owner) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
    
        // Title section
        Label titleInstruction = new Label("Enter the title of the task you want to modify:");
        TextField titleField = new TextField();
        titleField.setPromptText("Enter Task Title (Required)");
    
        VBox titleBox = new VBox(5, titleInstruction, titleField);
        titleBox.setAlignment(Pos.CENTER_LEFT);
    
        // Instruction for modifying attributes
        Label modifyInstruction = new Label("Enter new values for the attributes you want to modify.\nLeave fields blank for attributes you don't want to change:");
    
        // Input fields for new values
        TextField newDescriptionField = new TextField();
        newDescriptionField.setPromptText("New Description");
    
        TextField newDueDateField = new TextField();
        newDueDateField.setPromptText("New Due Date (yyyy/MM/dd)");
    
        TextField newDueTimeField = new TextField();
        newDueTimeField.setPromptText("New Due Time (HH:mm:ss)");
    
        TextField newCourseNameField = new TextField();
        newCourseNameField.setPromptText("New Course Name");
    
        TextField newPriorityField = new TextField();
        newPriorityField.setPromptText("New Priority (HIGH, MEDIUM, LOW)");
    
        VBox modifyFieldsBox = new VBox(10, newDescriptionField, newDueDateField, newDueTimeField, newCourseNameField, newPriorityField);
        modifyFieldsBox.setAlignment(Pos.CENTER_LEFT);
    
        // Status selection
        Label statusInstruction = new Label("Select a new status (optional):");
        ToggleGroup newStatusGroup = new ToggleGroup();
        RadioButton inProgressButton = new RadioButton("In progress");
        inProgressButton.setToggleGroup(newStatusGroup);
        inProgressButton.setUserData("IN_PROGRESS");
    
        RadioButton completedButton = new RadioButton("Completed");
        completedButton.setToggleGroup(newStatusGroup);
        completedButton.setUserData("COMPLETED");
    
        RadioButton notStartedButton = new RadioButton("Not started");
        notStartedButton.setToggleGroup(newStatusGroup);
        notStartedButton.setUserData("NOT_STARTED");
    
        HBox statusBox = new HBox(10, notStartedButton, inProgressButton, completedButton);
        statusBox.setAlignment(Pos.CENTER_LEFT);
    
        VBox statusSection = new VBox(5, statusInstruction, statusBox);
        statusSection.setAlignment(Pos.CENTER_LEFT);
    
        // Submit button
        Button submitButton = new Button("Modify");
        submitButton.setOnAction(event -> {
            // Get the title to find the task
            String title = titleField.getText();
    
            // Get new values (if provided)
            String newDescription = newDescriptionField.getText();
            String newDueDate = newDueDateField.getText();
            String newDueTime = newDueTimeField.getText();
            String newCourseName = newCourseNameField.getText();
            String newPriority = newPriorityField.getText();
            String newStatus = newStatusGroup.getSelectedToggle() != null
                    ? newStatusGroup.getSelectedToggle().getUserData().toString()
                    : null; // No status change if not selected
    
            // Modify the task
            controller.modifyTask(title, newDescription, newDueDate, newDueTime, newCourseName, newPriority, newStatus);
            stage.close();
        });
    
        VBox root = new VBox(15, titleBox, modifyInstruction, modifyFieldsBox, statusSection, submitButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(10));
        stage.setScene(new Scene(root, 400, 600));
        stage.show();
    }    
    
}
