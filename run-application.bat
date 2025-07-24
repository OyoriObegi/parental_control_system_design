@echo off
echo Starting Parental Control System...
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 17 or higher from: https://adoptium.net/
    pause
    exit /b 1
)

REM Check if JAR file exists
if not exist "target\parental_control-1.0-SNAPSHOT.jar" (
    echo ERROR: JAR file not found
    echo Please build the project first: mvn clean package
    pause
    exit /b 1
)

echo Java version:
java -version
echo.

echo Starting application...
echo The application will open in a new window.
echo H2 Database Console: http://localhost:8080/h2-console
echo Demo Credentials: parent@example.com / 1234
echo.

REM Run the JAR file
java -jar target\parental_control-1.0-SNAPSHOT.jar

echo.
echo Application closed.
pause 