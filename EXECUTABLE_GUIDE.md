# Parental Control System - Executable Creation Guide

This guide shows you how to convert your Spring Boot + JavaFX application into different types of executable files.

## 🎯 **Option 1: Executable JAR (Already Created!)**

### **What You Have:**
- ✅ **File**: `target/parental_control-1.0-SNAPSHOT.jar`
- ✅ **Size**: ~15-20MB (includes all dependencies)
- ✅ **Type**: Fat JAR with embedded dependencies

### **How to Run:**
```bash
# Navigate to target directory
cd target

# Run the JAR
java -jar parental_control-1.0-SNAPSHOT.jar
```

### **Distribution:**
- **Single File**: Just the JAR file
- **Requirements**: Java 17+ installed on target machine
- **Cross-Platform**: Works on Windows, Mac, Linux

---

## 🚀 **Option 2: Native Executable (Recommended for Distribution)**

### **Using GraalVM Native Image**

#### **Prerequisites:**
1. Install GraalVM
2. Install native-image tool

#### **Build Native Executable:**
```bash
# Install native-image
gu install native-image

# Build native executable
./mvnw native:compile -Pnative
```

#### **Result:**
- **File**: `target/parental_control` (Linux/Mac) or `target/parental_control.exe` (Windows)
- **Size**: ~50-100MB
- **Speed**: Faster startup time
- **Requirements**: No Java runtime needed

---

## 🐳 **Option 3: Docker Container**

### **Create Dockerfile:**
```dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file
COPY target/parental_control-1.0-SNAPSHOT.jar app.jar

# Expose port for H2 console
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### **Build and Run:**
```bash
# Build Docker image
docker build -t parental-control-system .

# Run container
docker run -p 8080:8080 parental-control-system
```

---

## 📦 **Option 4: Windows Executable (.exe)**

### **Using Launch4j (Windows Only)**

#### **Install Launch4j:**
1. Download from: http://launch4j.sourceforge.net/
2. Install and configure

#### **Configuration:**
```xml
<launch4jConfig>
  <dontWrapJar>false</dontWrapJar>
  <headerType>gui</headerType>
  <jar>target/parental_control-1.0-SNAPSHOT.jar</jar>
  <outfile>ParentalControlSystem.exe</outfile>
  <errTitle>Parental Control System</errTitle>
  <cmdLine></cmdLine>
  <chdir>.</chdir>
  <priority>normal</priority>
  <downloadUrl>https://adoptium.net/</downloadUrl>
  <supportUrl></supportUrl>
  <stayAlive>false</stayAlive>
  <restartOnCrash>false</restartOnCrash>
  <manifest></manifest>
  <jre>
    <path></path>
    <bundledJre64Bit>false</bundledJre64Bit>
    <bundledJreAsFallback>false</bundledJreAsFallback>
    <minVersion>17</minVersion>
    <maxVersion></maxVersion>
    <jdkPreference>preferJre</jdkPreference>
    <runtimeBits>64/32</runtimeBits>
  </jre>
</launch4jConfig>
```

---

## 🍎 **Option 5: macOS App Bundle**

### **Using jpackage (Java 14+)**

#### **Create App Bundle:**
```bash
# Create app bundle
jpackage --input target \
  --name "Parental Control System" \
  --main-jar parental_control-1.0-SNAPSHOT.jar \
  --main-class com.parentalcontrol.ParentalControlApplication \
  --type app-image \
  --dest dist
```

#### **Create DMG Installer:**
```bash
jpackage --input target \
  --name "Parental Control System" \
  --main-jar parental_control-1.0-SNAPSHOT.jar \
  --main-class com.parentalcontrol.ParentalControlApplication \
  --type dmg \
  --dest dist
```

---

## 🐧 **Option 6: Linux Package**

### **Using jpackage for Linux**

#### **Create DEB Package:**
```bash
jpackage --input target \
  --name "parental-control-system" \
  --main-jar parental_control-1.0-SNAPSHOT.jar \
  --main-class com.parentalcontrol.ParentalControlApplication \
  --type deb \
  --dest dist
```

#### **Create RPM Package:**
```bash
jpackage --input target \
  --name "parental-control-system" \
  --main-jar parental_control-1.0-SNAPSHOT.jar \
  --main-class com.parentalcontrol.ParentalControlApplication \
  --type rpm \
  --dest dist
```

---

## 🎯 **Recommended Approach for Your Project**

### **For HCI Assignment Submission:**
1. **Primary**: Executable JAR (already created)
2. **Backup**: Docker container
3. **Documentation**: Include setup instructions

### **For Portfolio/Distribution:**
1. **Windows**: Launch4j .exe file
2. **Cross-Platform**: Native executable with GraalVM
3. **Cloud**: Docker container

### **For Academic Demonstration:**
1. **Simple**: Executable JAR with batch script
2. **Professional**: Native executable
3. **Modern**: Docker container

---

## 🚀 **Quick Start Commands**

### **Build Executable JAR:**
```bash
./mvnw clean package
```

### **Run Executable JAR:**
```bash
java -jar target/parental_control-1.0-SNAPSHOT.jar
```

### **Create Distribution Package:**
```bash
# Create distribution folder
mkdir parental-control-distribution
cp target/parental_control-1.0-SNAPSHOT.jar parental-control-distribution/
cp README.md parental-control-distribution/

# Create run script for Windows
echo "@echo off" > parental-control-distribution/run.bat
echo "java -jar parental_control-1.0-SNAPSHOT.jar" >> parental-control-distribution/run.bat

# Create run script for Linux/Mac
echo "#!/bin/bash" > parental-control-distribution/run.sh
echo "java -jar parental_control-1.0-SNAPSHOT.jar" >> parental-control-distribution/run.sh
chmod +x parental-control-distribution/run.sh

# Create ZIP
zip -r parental-control-distribution.zip parental-control-distribution/
```

---

## 📋 **File Sizes Comparison**

| Method | Size | Startup Time | Requirements |
|--------|------|--------------|--------------|
| JAR | ~15-20MB | Medium | Java 17+ |
| Native | ~50-100MB | Fast | None |
| Docker | ~200MB | Slow | Docker |
| Windows .exe | ~20-25MB | Medium | Java 17+ |

---

## 🛠️ **Troubleshooting**

### **Common Issues:**

#### **1. Java Not Found**
```bash
# Check Java version
java -version

# Install Java 17 if needed
# Windows: Download from https://adoptium.net/
# Linux: sudo apt install openjdk-17-jdk
# Mac: brew install openjdk@17
```

#### **2. Permission Denied**
```bash
# Make executable (Linux/Mac)
chmod +x target/parental_control-1.0-SNAPSHOT.jar
```

#### **3. Port Already in Use**
```bash
# Change port in application.properties
server.port=8081
```

---

## 🎉 **Success!**

Your executable JAR is ready at:
```
target/parental_control-1.0-SNAPSHOT.jar
```

**To run it:**
```bash
java -jar target/parental_control-1.0-SNAPSHOT.jar
```

**To distribute it:**
- Copy the JAR file
- Include Java 17+ requirement
- Provide run instructions

---

## 📞 **Next Steps**

1. **Test the JAR**: Run it on different machines
2. **Create Distribution**: Package with instructions
3. **Choose Platform**: Select best format for your audience
4. **Document**: Update README with executable instructions

Your Spring Boot + JavaFX application is now ready for distribution! 🚀 