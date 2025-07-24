package com.parentalcontrol.frontend.controllers;

import com.parentalcontrol.service.AuthService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.parentalcontrol.config.SpringFxmlLoader;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@Component
public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label statusLabel;

    @Autowired
    private AuthService authService;

    private static ApplicationContext appContext;
    public static void setApplicationContext(ApplicationContext context) {
        appContext = context;
    }

    @FXML
    public void initialize() {
        // Set up initial UI state
        statusLabel.setText("");
        statusLabel.setStyle("-fx-text-fill: transparent;");
        
        // Add input validation
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            validateInputs();
        });
        
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            validateInputs();
        });
        
        // Set default focus
        emailField.requestFocus();
    }

    @FXML
    public void onLogin() {
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        // Clear previous status
        clearStatus();

        // Validate inputs
        if (email.isEmpty() || password.isEmpty()) {
            showStatus("Please fill in all fields", true);
            return;
        }

        // Disable login button during authentication
        loginButton.setDisable(true);
        loginButton.setText("Logging in...");

        try {
            if (authService.authenticate(email, password)) {
                showStatus("Login successful! Redirecting...", false);
                
                // Simulate loading time for better UX
                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(this::navigateToDashboard);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else {
                showStatus("Invalid email or password", true);
                passwordField.clear();
                passwordField.requestFocus();
            }
        } catch (Exception e) {
            showStatus("An error occurred during login", true);
        } finally {
            loginButton.setDisable(false);
            loginButton.setText("Login");
        }
    }

    @FXML
    public void onEnterPressed() {
        onLogin();
    }

    @FXML
    public void onGoToSignup() {
        navigateToSignup();
    }

    private void validateInputs() {
        boolean isValid = !emailField.getText().trim().isEmpty() && 
                         !passwordField.getText().isEmpty();
        loginButton.setDisable(!isValid);
    }

    private void showStatus(String message, boolean isError) {
        statusLabel.setText(message);
        statusLabel.setStyle(isError ? "-fx-text-fill: #d32f2f;" : "-fx-text-fill: #388e3c;");
    }

    private void clearStatus() {
        statusLabel.setText("");
        statusLabel.setStyle("-fx-text-fill: transparent;");
    }

    private void navigateToDashboard() {
        try {
            SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader(appContext);
            Parent dashboardRoot = (Parent) springFxmlLoader.load("/com/parentalcontrol/views/dashboard.fxml");
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            Scene dashboardScene = new Scene(dashboardRoot);
            currentStage.setScene(dashboardScene);
            currentStage.setTitle("Parental Control Dashboard");
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not load dashboard: " + e.getMessage());
        }
    }

    private void navigateToSignup() {
        try {
            SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader(appContext);
            Parent signupRoot = (Parent) springFxmlLoader.load("/com/parentalcontrol/views/signup.fxml");
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            Scene signupScene = new Scene(signupRoot);
            currentStage.setScene(signupScene);
            currentStage.setTitle("Parental Control System - Sign Up");
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not load signup screen: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
