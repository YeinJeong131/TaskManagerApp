# TaskManagerApp

A JavaFX-based **GUI application** that allows users to add and manage a list of tasks interactively.  
This project was developed to practice building graphical user interfaces in Java using **JavaFX**, as well as learning how to structure code using the **MVC (Model-View-Controller)** pattern.

---

## 📜 Project Purpose

The goal of this project was to move from console-based Java applications to JavaFX-based graphical applications.  
By building a Task Manager with a table-based UI, this project reinforced skills in:

- JavaFX layout design and scene graph
- GUI event handling
- Observable data binding
- MVC architecture in GUI apps

---

## ✏️ Features

- Add new tasks through a user-friendly form
- Display all tasks in a `TableView`
- Edit or delete existing tasks with buttons
- Use of JavaFX components and event-driven interactions

---

## 🏛 Key Class Overview (MVC Pattern)

### ✅ `Task` (Model)
- A simple data class representing a task
- Uses `SimpleStringProperty` for JavaFX data binding
- Attributes:
  - `taskName` — the name of the task

### ✅ `TaskView` (View)
- Defines the GUI layout using JavaFX
- UI components used:
  - `TextField` for user input
  - `Button` for adding and deleting tasks
  - `TableView<Task>` with `TableColumn<Task, String>` to display task list
- Exposes getters to allow `TaskController` to access UI components

### ✅ `TaskController` (Controller)
- Connects the `TaskView` and the `ObservableList<Task>` model
- Handles events for adding, editing, and deleting tasks
- Updates the table automatically using `ObservableList` binding

### ✅ `TaskApp` (Main Application)
- Entry point of the application
- Extends `Application` and sets up the `Stage` and `Scene`

---

## 🎯 JavaFX Components and Concepts Learned

This project provided hands-on experience with the following JavaFX elements:

- **`Stage`**: Represents the primary window of the app
- **`Scene`**: Holds the UI graph (layout)
- **`VBox`, `HBox`**: Layout managers for arranging nodes vertically/horizontally
- **`TextField`**: Input field for entering task names
- **`Button`**: Triggers add and delete operations
- **`TableView<Task>`**: Displays the list of tasks in table format
- **`TableColumn<Task, String>`**: Each column represents a property of the task
- **`ObservableList<Task>`**: Auto-updates UI when data changes
- **`SimpleStringProperty`**: Enables data binding between `Task` model and table columns

---

## 🧠 Learning Outcomes

- Structured a multi-class GUI JavaFX project using MVC
- Practiced data binding using `ObservableList` and `SimpleStringProperty`
- Handled UI events (button clicks, input processing)
- Learned how to use `TableView` and dynamically update it
- Built and launched a JavaFX application using `javac` and `java` with `--module-path` setup

---

## 💻 How to Run

1. Compile all Java source files:

   ```bash
   javac --module-path "YOUR_JAVAFX_LIB_PATH" --add-modules javafx.controls,javafx.fxml -d bin src/*.java
   ```
2. Run the application:
   ```bash
   java --module-path "YOUR_JAVAFX_LIB_PATH" --add-modules javafx.controls,javafx.fxml -cp bin TaskApp
   ```
   > Replace YOUR_JAVAFX_LIB_PATH with your actual path to JavaFX (e.g., C:/Users/ADMIN/openjfx-23.0.1_windows-x64_bin-sdk/javafx-sdk-23.0.1/lib).

## 🧩 Future Improvements
- Add task status (e.g., Pending, Done)
- Enable saving/loading tasks from a file
- Add task due dates and sorting
