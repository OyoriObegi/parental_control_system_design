#!/bin/bash

echo "Starting Parental Control System..."
echo

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed or not in PATH"
    echo "Please install Java 17 or higher:"
    echo "  Ubuntu/Debian: sudo apt install openjdk-17-jdk"
    echo "  macOS: brew install openjdk@17"
    echo "  Or download from: https://adoptium.net/"
    exit 1
fi

# Check if JAR file exists
if [ ! -f "target/parental_control-1.0-SNAPSHOT.jar" ]; then
    echo "ERROR: JAR file not found"
    echo "Please build the project first: ./mvnw clean package"
    exit 1
fi

echo "Java version:"
java -version
echo

echo "Starting application..."
echo "The application will open in a new window."
echo "H2 Database Console: http://localhost:8080/h2-console"
echo "Demo Credentials: parent@example.com / 1234"
echo

# Run the JAR file
java -jar target/parental_control-1.0-SNAPSHOT.jar

echo
echo "Application closed." 