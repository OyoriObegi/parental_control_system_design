package com.parentalcontrol;

import com.parentalcontrol.config.SpringFxmlLoader;
import com.parentalcontrol.frontend.controllers.LoginController;
import com.parentalcontrol.frontend.controllers.SignupController;
import com.parentalcontrol.frontend.controllers.DashboardController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ParentalControlApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ParentalControlApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set Spring context in controllers
        LoginController.setApplicationContext(springContext);
        SignupController.setApplicationContext(springContext);
        DashboardController.setApplicationContext(springContext);
        SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader(springContext);
        Parent root = (Parent) springFxmlLoader.load("/com/parentalcontrol/views/login.fxml");
        primaryStage.setTitle("Parental Control System - Parent Dashboard");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 