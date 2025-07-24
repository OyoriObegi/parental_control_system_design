package com.parentalcontrol.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {
    // In-memory user store: email -> password
    private static final Map<String, String> users = new ConcurrentHashMap<>();
    static {
        // Add demo user
        users.put("parent@example.com", "1234");
    }

    public boolean authenticate(String email, String password) {
        String storedPassword = users.get(email.toLowerCase());
        return storedPassword != null && storedPassword.equals(password);
    }
    
    public String getParentName(String email) {
        // In a real application, this would fetch from database
        return "Parent User";
    }

    public boolean register(String name, String email, String password) {
        String key = email.toLowerCase();
        if (users.containsKey(key)) {
            return false; // Email already registered
        }
        users.put(key, password);
        return true;
    }
} 