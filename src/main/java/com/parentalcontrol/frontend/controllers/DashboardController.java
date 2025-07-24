package com.parentalcontrol.frontend.controllers;

import com.parentalcontrol.config.SpringFxmlLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DashboardController {

    @FXML
    private VBox overviewSection;
    @FXML
    private VBox userManagementSection;
    @FXML
    private VBox timeLimitsSection;
    @FXML
    private VBox contentFilteringSection;
    @FXML
    private VBox activityReportsSection;
    @FXML
    private VBox settingsSection;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label activeUsersLabel;
    @FXML
    private Label timeLimitsLabel;
    @FXML
    private Label blockedSitesLabel;
    @FXML
    private Label devicesLabel;

    private static ApplicationContext appContext;
    public static void setApplicationContext(ApplicationContext context) {
        appContext = context;
    }

    @FXML
    public void initialize() {
        // Set initial view to overview
        showOverview();
        
        // Update welcome message
        welcomeLabel.setText("Welcome, Parent!");
        
        // Load initial statistics (in a real app, this would come from services)
        loadStatistics();
    }

    @FXML
    public void showOverview() {
        hideAllSections();
        overviewSection.setVisible(true);
        overviewSection.setManaged(true);
        updateNavigationStyle("overview");
    }

    @FXML
    public void showUserManagement() {
        hideAllSections();
        userManagementSection.setVisible(true);
        userManagementSection.setManaged(true);
        updateNavigationStyle("userManagement");
    }

    @FXML
    public void showTimeLimits() {
        hideAllSections();
        timeLimitsSection.setVisible(true);
        timeLimitsSection.setManaged(true);
        updateNavigationStyle("timeLimits");
    }

    @FXML
    public void showContentFiltering() {
        hideAllSections();
        contentFilteringSection.setVisible(true);
        contentFilteringSection.setManaged(true);
        updateNavigationStyle("contentFiltering");
    }

    @FXML
    public void showActivityReports() {
        hideAllSections();
        activityReportsSection.setVisible(true);
        activityReportsSection.setManaged(true);
        updateNavigationStyle("activityReports");
    }

    @FXML
    public void showSettings() {
        hideAllSections();
        settingsSection.setVisible(true);
        settingsSection.setManaged(true);
        updateNavigationStyle("settings");
    }

    @FXML
    public void lockAllDevices() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Lock All Devices");
        alert.setHeaderText("Confirm Action");
        alert.setContentText("Are you sure you want to lock all devices? This will immediately log out all users.");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // In a real application, this would call a service to lock devices
                showAlert("Devices Locked", "All devices have been locked successfully.");
            }
        });
    }

    @FXML
    public void checkDeviceStatus() {
        // In a real application, this would check actual device status
        showAlert("Device Status", "All devices are currently online and monitored.");
    }

    @FXML
    public void onLogout() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Confirm Logout");
        alert.setContentText("Are you sure you want to logout?");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                navigateToLogin();
            }
        });
    }

    private void hideAllSections() {
        overviewSection.setVisible(false);
        overviewSection.setManaged(false);
        userManagementSection.setVisible(false);
        userManagementSection.setManaged(false);
        timeLimitsSection.setVisible(false);
        timeLimitsSection.setManaged(false);
        contentFilteringSection.setVisible(false);
        contentFilteringSection.setManaged(false);
        activityReportsSection.setVisible(false);
        activityReportsSection.setManaged(false);
        settingsSection.setVisible(false);
        settingsSection.setManaged(false);
    }

    private void updateNavigationStyle(String activeSection) {
        // In a real application, this would update the navigation button styles
        // to show which section is currently active
    }

    private void loadStatistics() {
        // In a real application, this would load data from services
        activeUsersLabel.setText("3");
        timeLimitsLabel.setText("5 Active");
        blockedSitesLabel.setText("12");
        devicesLabel.setText("4 Online");
    }

    private void navigateToLogin() {
        try {
            SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader(appContext);
            Parent loginRoot = (Parent) springFxmlLoader.load("/com/parentalcontrol/views/login.fxml");
            Stage currentStage = (Stage) welcomeLabel.getScene().getWindow();
            Scene loginScene = new Scene(loginRoot, 800, 600);
            currentStage.setScene(loginScene);
            currentStage.setTitle("Parental Control System - Parent Login");
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not load login screen: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
} 