import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main: Entry point for the Task Planner application
public class TaskApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the controller to manage tasks
        TaskController controller = new TaskController();
        // Create the view to display the UI
        TaskView view = new TaskView(controller, primaryStage);

        // Set up the primary stage (window) with the view
        Scene scene = new Scene(view, 600, 400);
        primaryStage.setTitle("Study Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

