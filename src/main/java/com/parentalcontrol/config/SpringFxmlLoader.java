package com.parentalcontrol.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import java.io.IOException;
import java.io.InputStream;

public class SpringFxmlLoader {
    private final ApplicationContext context;

    public SpringFxmlLoader(ApplicationContext context) {
        this.context = context;
    }

    public Object load(String fxmlPath) throws IOException {
        try (InputStream fxmlStream = getClass().getResourceAsStream(fxmlPath)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(context::getBean);
            return loader.load(fxmlStream);
        }
    }
} 