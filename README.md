# Automation script execution procedure
## Required environment
- JDK 18 (download link: https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html , download and run "Windows x64 Installer").
- JAVA_HOME variable is set and "%JAVA_HOME%\bin" is appended to "Path" variable
- Download and install MAVEN according to the link: https://mkyong.com/maven/how-to-install-maven-in-windows/
- IDE: Intellij

## Execution procedure
1. Via IDE
   1. Open suite file: `DemoApp/src/test/resources/testng.xml`
   2. Change the value browser params to the desired one (chrome or firefox)
   3. Run xml file

2. Via command line
   1. Open CMD at project folder 
   2. Run: `mvn clean compile`
   3. Run test: `mvn test -Dsuite=<xmlFileName> -Dbrowser=<browsername>`
   </br> Example: `mvn test -Dsuite=testng -Dbrowser=firefox`
