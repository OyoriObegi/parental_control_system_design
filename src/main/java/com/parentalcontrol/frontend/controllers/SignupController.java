package com.parentalcontrol.frontend.controllers;

import com.parentalcontrol.service.AuthService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.parentalcontrol.config.SpringFxmlLoader;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@Component
public class SignupController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signupButton;

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
        statusLabel.setText("");
        statusLabel.setStyle("-fx-text-fill: transparent;");
    }

    @FXML
    public void onSignup() {
        System.out.println("AuthService is null? " + (authService == null));
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        clearStatus();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showStatus("Please fill in all fields", true);
            return;
        }
        if (!password.equals(confirmPassword)) {
            showStatus("Passwords do not match", true);
            confirmPasswordField.clear();
            confirmPasswordField.requestFocus();
            return;
        }

        signupButton.setDisable(true);
        signupButton.setText("Signing up...");

        try {
            // TODO: Implement actual registration logic in AuthService
            boolean success = authService.register(name, email, password);
            if (success) {
                showStatus("Signup successful! Redirecting to login...", false);
                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(this::navigateToLogin);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else {
                showStatus("Email already registered", true);
            }
        } catch (Exception e) {
            showStatus("An error occurred during signup", true);
        } finally {
            signupButton.setDisable(false);
            signupButton.setText("Sign Up");
        }
    }

    @FXML
    public void onGoToLogin() {
        navigateToLogin();
    }

    private void showStatus(String message, boolean isError) {
        statusLabel.setText(message);
        statusLabel.setStyle(isError ? "-fx-text-fill: #d32f2f;" : "-fx-text-fill: #388e3c;");
    }

    private void clearStatus() {
        statusLabel.setText("");
        statusLabel.setStyle("-fx-text-fill: transparent;");
    }

    private void navigateToLogin() {
        try {
            SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader(appContext);
            Parent loginRoot = (Parent) springFxmlLoader.load("/com/parentalcontrol/views/login.fxml");
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            Scene loginScene = new Scene(loginRoot);
            currentStage.setScene(loginScene);
            currentStage.setTitle("Parental Control System - Parent Login");
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not load login screen: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
} 