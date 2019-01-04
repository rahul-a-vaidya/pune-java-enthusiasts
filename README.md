# pune-java-enthusiasts
Code repository meant for Pune Java Enthusiast members to share code and examples


## Spring Core

This folder contains the code for 5th Jan 2019 meetup session.

## Setup Instruction and Requirements

1. Maven ( Must have to Run or Compile)
1. GIT ( not Mandatory )
1. JDK __1.8.i__
1. Eclipse is the preferred IDE but the code was tested on IntelliJ and the corresponding files were committed as well.


## Maven Setup

For maven Setting of JAVA_HOME is an important step. make sure you have that setup
The instruction for installing / setting up maven can be found  here [MAVEN INSTALL](https://maven.apache.org/install.html)

## GIT Setup

__Installing or knowing GIT is not mandatory__ the code can be downloaded as Zip although I'll recommend GIT as the examples or Fixes that may get added my Instructor can be pulled.

[GIT SETUP INSTRUCTIONS](https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup) 

### GIT ALTERNATIVE

Developers who don't know GIT can download the code from the repository and unzip with tools like 7.zip the top level folder name is __pune-java-enthusiasts__ any path used ahead must be taken in relation to this folder.



### Testing the Setup

If maven and GIT setup is done. One will have to go the location where the folder was unzipped. say __"c:\pune-java-enthusiasts"__  the folder has sub folders spring/spring-core navigate inside the folder and execute below command

__This is very Important Step__  we want to save setup time for everyone coming for the Meetup and maven may take time downloading dependencies. its better to do this before reaching for the meetup.

```
mvn clean install
```
The dependencies should automatically be downloaded and Build Success message should be displayed.


### Importing the project in Eclipse or IntelliJ
* Eclipse 

In eclipse file > import... > under Maven select "existing maven project"

once the project is imported right click the project > Maven > Update Project...

This should setup all classpath and Sources for the project in Eclipse

* IntelliJ
 File > new >Project from Existing Sources >> navigate to __pune-java-enthusiasts\spring\spring-core__  select ok and follow the instruction if prompted for maven project type select that.











