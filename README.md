# Parental Control System - Spring Boot + JavaFX

A comprehensive desktop application for parental control functionality, built with Spring Boot and JavaFX, demonstrating modern UI/UX design principles.

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher (or use the included Maven wrapper)

### Build and Run

#### Option 1: Using Maven Wrapper (Recommended)
```bash
# Build the project
./mvnw clean package

# Run the application
./mvnw javafx:run
```

#### Option 2: Create Executable JAR
```bash
# Build executable JAR
./mvnw clean package

# Run the JAR file
java -jar target/parental_control-1.0-SNAPSHOT.jar
```

#### Option 3: Using Run Scripts
- **Windows**: Double-click `run-application.bat`
- **Linux/Mac**: `./run-application.sh`

## 📦 Executable Distribution

### Building the Executable
The project includes scripts to create a distributable executable JAR:

```bash
# Build the executable
./mvnw clean package

# The executable JAR will be created at:
# target/parental_control-1.0-SNAPSHOT.jar
```

### Distribution Package
For distribution, create a package with:
- `target/parental_control-1.0-SNAPSHOT.jar`
- `run-application.bat` (Windows)
- `run-application.sh` (Linux/Mac)
- `README.md` (this file)

### Requirements for End Users
- Java 17 or higher installed
- No additional dependencies required (all included in JAR)

## 🔧 Development Setup

### Clone the Repository
```bash
git clone https://github.com/yourusername/parental-control-system.git
cd parental-control-system
```

### IDE Setup
1. Import as Maven project
2. Ensure Java 17 is configured
3. Run `ParentalControlApplication.java`

### Database Access
- **H2 Console**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:parentalcontrol`
- **Username**: `sa`
- **Password**: `password`

## 👤 Demo Credentials
- **Email**: `parent@example.com`
- **Password**: `1234`

## 🏗️ Architecture

### Technology Stack
- **Backend**: Spring Boot 3.2.0, Spring Security, Spring Data JPA
- **Frontend**: JavaFX 17.0.2, FXML, CSS
- **Database**: H2 In-Memory Database
- **Build Tool**: Maven 3.9.9

### Project Structure
```
parental_control/
├── src/main/java/com/parentalcontrol/
│   ├── ParentalControlApplication.java    # Main application class
│   ├── config/AppConfig.java             # Spring configuration
│   ├── service/AuthService.java          # Authentication service
│   └── frontend/controllers/
│       ├── LoginController.java          # Login screen controller
│       └── DashboardController.java      # Dashboard controller
└── src/main/resources/
    ├── application.properties            # Application configuration
    └── com/parentalcontrol/views/
        ├── login.fxml                    # Login screen layout
        └── dashboard.fxml                # Dashboard layout
```

## 🎨 UI/UX Features

### Design Principles
- **Modern Interface**: Clean, professional design
- **Responsive Layout**: Adapts to different screen sizes
- **Accessibility**: High contrast and readable fonts
- **User Experience**: Intuitive navigation and feedback

### Color Scheme
- **Primary**: #3498db (Blue) - Trust and security
- **Secondary**: #2c3e50 (Dark Blue) - Professional appearance
- **Success**: #27ae60 (Green) - Positive actions
- **Warning**: #e67e22 (Orange) - Time-related alerts
- **Error**: #e74c3c (Red) - Critical actions

## 🔒 Security Features

- **Spring Security**: Authentication and authorization
- **Password Validation**: Secure input validation
- **Session Management**: Secure session handling
- **Input Sanitization**: Protection against injection attacks

## 📊 Features

### Core Functionality
- **Secure Authentication**: Email and password login
- **Dashboard Overview**: Real-time system statistics
- **User Management**: Individual user profiles
- **Time Management**: Screen time limits and scheduling
- **Content Filtering**: Website blocking and categorization
- **Activity Reporting**: Usage analytics and logs

### Planned Features
- **Multi-device Support**: Cross-platform compatibility
- **Mobile Integration**: Companion mobile application
- **Advanced Analytics**: Machine learning insights
- **Cloud Integration**: Multi-tenant cloud platform

## 🧪 Testing

### Running Tests
```bash
# Run all tests
./mvnw test

# Run with coverage
./mvnw jacoco:report
```

### Test Coverage
- Unit tests for services
- Integration tests for controllers
- UI tests for JavaFX components

## 🚀 Deployment

### Development Environment
```bash
./mvnw spring-boot:run
```

### Production Environment
```bash
# Build for production
./mvnw clean package -Pprod

# Run production JAR
java -jar target/parental_control-1.0-SNAPSHOT.jar
```

### Docker Deployment
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/parental_control-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 🐛 Troubleshooting

### Common Issues

#### Java Version Issues
```bash
# Check Java version
java -version

# Should show Java 17 or higher
```

#### Maven Issues
```bash
# Clean and rebuild
./mvnw clean install

# Update dependencies
./mvnw dependency:resolve
```

#### Port Conflicts
```bash
# Change port in application.properties
server.port=8081
```

#### JavaFX Issues
```bash
# Ensure JavaFX dependencies are included
./mvnw dependency:tree | grep javafx
```

## 📚 Documentation

- **Complete Documentation**: See `Documentation.md`
- **Executable Guide**: See `EXECUTABLE_GUIDE.md`
- **API Documentation**: Generated with Spring Boot Actuator

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- JavaFX team for the modern UI toolkit
- HCI course instructors for guidance on UI/UX principles

---

**Note**: This is a demonstration project for HCI coursework, showcasing Spring Boot + JavaFX integration with modern UI/UX design principles. 