# GitHub Releases Guide

This guide explains how to create GitHub releases to distribute your executable JAR file without including it in the main repository.

## 🎯 **Why GitHub Releases?**

### **Benefits:**
- ✅ **Clean Repository**: Source code only, no large binary files
- ✅ **Version Management**: Tagged releases with version numbers
- ✅ **Easy Distribution**: Downloadable assets for users
- ✅ **Release Notes**: Document changes and improvements
- ✅ **Professional**: Industry standard practice

### **What Goes Where:**
- **Repository**: Source code, documentation, scripts
- **Releases**: Compiled executables, installers, distributions

---

## 🚀 **Creating Your First Release**

### **Step 1: Build the Executable**
```bash
# Build the JAR file
./mvnw clean package

# Verify the JAR was created
ls -lh target/parental_control-1.0-SNAPSHOT.jar
```

### **Step 2: Create a Git Tag**
```bash
# Create and push a tag
git tag -a v1.0.0 -m "Initial release: Parental Control System"
git push origin v1.0.0
```

### **Step 3: Create GitHub Release**
1. Go to your GitHub repository
2. Click "Releases" in the right sidebar
3. Click "Create a new release"
4. Select the tag you just created (v1.0.0)

### **Step 4: Configure Release**
- **Release Title**: `Parental Control System v1.0.0`
- **Description**: Include release notes, features, and instructions
- **Assets**: Upload the JAR file and run scripts

---

## 📦 **Release Assets to Include**

### **Required Files:**
- `parental_control-1.0-SNAPSHOT.jar` (Main executable)
- `run-application.bat` (Windows run script)
- `run-application.sh` (Linux/Mac run script)
- `README.md` (Setup instructions)

### **Optional Files:**
- `Documentation.md` (Complete documentation)
- `EXECUTABLE_GUIDE.md` (Build instructions)
- Screenshots of the application
- Demo video or GIF

---

## 📝 **Sample Release Description**

```markdown
# Parental Control System v1.0.0

## 🎉 Initial Release

A comprehensive desktop application for parental control functionality, built with Spring Boot and JavaFX, demonstrating modern UI/UX design principles.

## ✨ Features

- **Secure Authentication**: Email and password login system
- **Dashboard Overview**: Real-time system statistics and monitoring
- **Modern UI Design**: Professional interface following HCI principles
- **Cross-Platform**: Works on Windows, Mac, and Linux
- **H2 Database**: Built-in database with web console

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher

### Installation
1. Download the JAR file from this release
2. Download the appropriate run script for your OS
3. Run the application using the script or command line

### Demo Credentials
- **Email**: `parent@example.com`
- **Password**: `1234`

### Database Access
- **H2 Console**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:parentalcontrol`
- **Username**: `sa`
- **Password**: `password`

## 🛠️ Technical Details

- **Backend**: Spring Boot 3.2.0
- **Frontend**: JavaFX 17.0.2
- **Database**: H2 In-Memory Database
- **Build Tool**: Maven 3.9.9

## 📋 System Requirements

- **OS**: Windows 10+, macOS 10.14+, or Linux
- **Java**: Version 17 or higher
- **Memory**: 4GB RAM minimum
- **Storage**: 100MB free space

## 🔧 Troubleshooting

### Java Not Found
Download and install Java 17+ from: https://adoptium.net/

### Port Already in Use
The application uses port 8080. If busy, change it in application.properties.

### Permission Denied (Linux/Mac)
Make the shell script executable: `chmod +x run-application.sh`

## 📚 Documentation

- **Complete Documentation**: See Documentation.md
- **Build Instructions**: See EXECUTABLE_GUIDE.md
- **Source Code**: Available in the main repository

## 🎓 Academic Project

This project was developed as part of an HCI (Human-Computer Interaction) course assignment, demonstrating:
- Modern UI/UX design principles
- Spring Boot + JavaFX integration
- Professional software development practices

## 🤝 Support

For issues or questions:
1. Check the troubleshooting section
2. Review the documentation
3. Create an issue in the repository

---

**Download the executable JAR file and run scripts from the assets below.**
```

---

## 🔄 **Release Workflow**

### **For Each New Version:**

1. **Update Version** in `pom.xml`
2. **Build Executable** with `./mvnw clean package`
3. **Create Tag** with `git tag -a v1.0.1 -m "Release v1.0.1"`
4. **Push Tag** with `git push origin v1.0.1`
5. **Create Release** on GitHub with assets
6. **Update Documentation** if needed

### **Version Naming Convention:**
- `v1.0.0` - Initial release
- `v1.0.1` - Bug fixes
- `v1.1.0` - New features
- `v2.0.0` - Major changes

---

## 📊 **Release Statistics**

### **What GitHub Tracks:**
- **Downloads**: Number of times assets were downloaded
- **Views**: How many people viewed the release
- **Stars**: Repository popularity
- **Forks**: Community interest

### **Analytics Available:**
- Download counts per asset
- Geographic distribution
- Referrer information
- Time-based trends

---

## 🎯 **Best Practices**

### **Release Management:**
- ✅ **Consistent Naming**: Use semantic versioning
- ✅ **Clear Descriptions**: Include features and changes
- ✅ **Multiple Assets**: Provide different formats
- ✅ **Documentation**: Include setup instructions
- ✅ **Screenshots**: Visual preview of the application

### **Asset Organization:**
- ✅ **Descriptive Names**: `parental-control-v1.0.0.jar`
- ✅ **Platform Specific**: `parental-control-windows-v1.0.0.zip`
- ✅ **Complete Packages**: Include all necessary files
- ✅ **Checksums**: Provide MD5/SHA256 for verification

---

## 🚀 **Automation Options**

### **GitHub Actions (Advanced):**
```yaml
name: Build and Release
on:
  push:
    tags:
      - 'v*'

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-java@v2
        with:
          java-version: '17'
      - run: ./mvnw clean package
      - uses: actions/upload-artifact@v2
        with:
          name: parental-control-jar
          path: target/parental_control-1.0-SNAPSHOT.jar
```

### **Manual Process (Recommended for Learning):**
1. Build locally
2. Create tag manually
3. Upload assets manually
4. Write release notes

---

## 📞 **Next Steps**

1. **Create Your First Release**: Follow the steps above
2. **Test the Release**: Download and test the assets
3. **Share the Release**: Use the release URL for distribution
4. **Monitor Downloads**: Check GitHub analytics
5. **Gather Feedback**: Encourage users to report issues

---

**Remember**: GitHub releases are perfect for distributing executables while keeping your repository clean and professional! 🎉 