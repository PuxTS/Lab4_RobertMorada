package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox topHBox = new HBox();
        topHBox.setPadding(new Insets(15));
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setStyle("-fx-background-color: #2c3e50;");
        Label titleLabel = new Label("College Student Registration System");
        titleLabel.setFont(Font.font("Arial", 20));
        titleLabel.setTextFill(Color.WHITE);
        topHBox.getChildren().add(titleLabel);
        root.setTop(topHBox);

        VBox leftVBox = new VBox(10);
        leftVBox.setPadding(new Insets(15));
        leftVBox.setStyle("-fx-background-color: #ecf0f1;");
        Label navLabel = new Label("Navigation");
        navLabel.setFont(Font.font("Arial", 12));
        
        Button btnDashboard = new Button("Dashboard");
        Button btnRegistration = new Button("Registration");
        Button btnCourses = new Button("Courses");
        Button btnHelp = new Button("Help");
        
        Button[] navButtons = {btnDashboard, btnRegistration, btnCourses, btnHelp};
        for (Button btn : navButtons) {
            btn.setMaxWidth(Double.MAX_VALUE);
        }
        
        leftVBox.getChildren().addAll(navLabel, btnDashboard, btnRegistration, btnCourses, btnHelp);
        root.setLeft(leftVBox);

        VBox centreVBox = new VBox(15);
        centreVBox.setPadding(new Insets(20));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 0, 10, 0));

        Label lblStudentId = new Label("Student ID:");
        TextField tfStudentId = new TextField();

        Label lblFullName = new Label("Full Name:");
        TextField tfFullName = new TextField();

        Label lblEmail = new Label("Email:");
        TextField tfEmail = new TextField();

        Label lblProgram = new Label("Program:");
        TextField tfProgram = new TextField();

        gridPane.add(lblStudentId, 0, 0);
        gridPane.add(tfStudentId, 1, 0);
        
        gridPane.add(lblFullName, 0, 1);
        gridPane.add(tfFullName, 1, 1);
        
        gridPane.add(lblEmail, 0, 2);
        gridPane.add(tfEmail, 1, 2);
        
        gridPane.add(lblProgram, 0, 3);
        gridPane.add(tfProgram, 1, 3);

        HBox actionHBox = new HBox(10);
        Button btnRegister = new Button("Register");
        Button btnClear = new Button("Clear");
        actionHBox.getChildren().addAll(btnRegister, btnClear);

        Label lblStatus = new Label();
        lblStatus.setWrapText(true);

        centreVBox.getChildren().addAll(gridPane, actionHBox, lblStatus);
        root.setCenter(centreVBox);

        btnRegister.setOnAction(e -> {
            String studentId = tfStudentId.getText().trim();
            String fullName = tfFullName.getText().trim();
            String email = tfEmail.getText().trim();
            String program = tfProgram.getText().trim();

            if (studentId.isEmpty() || fullName.isEmpty() || email.isEmpty() || program.isEmpty()) {
                lblStatus.setTextFill(Color.RED);
                lblStatus.setText("Error: Please fill in all required fields.");
            } else {
                lblStatus.setTextFill(Color.GREEN);
                lblStatus.setText("Success: Student " + fullName + " (ID: " + studentId + ") registered successfully for " + program + "!");
            }
        });

        btnClear.setOnAction(e -> {
            tfStudentId.clear();
            tfFullName.clear();
            tfEmail.clear();
            tfProgram.clear();
            lblStatus.setText("");
        });

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("College Student Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}