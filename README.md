# BOWLING SCORE 

## Description

This project reads a file with the player scores and prints 
the score board of the match.

This application is written in Java and uses some classes to
represent the score board.

In the project we use some basic dependency injection classes 
to separate thw implementation from some services that we develop

We develop three kind of services for this application.

* FillScoreBoardService
* CalculateScoreService
* PrintScoreBoardService

The application is a Maven project but it has a maven wrapper 
that helps execution if you don't have mvn installed.

## Execution

The project can be executed as indicated.

The name of the txt file is part of the arguments in the mvnw command

If you want to use a different txt file you can put it at the root of the 
project folder at the same level of the pom.xml

```
./mvnw clean package exec:java -Dexec.mainClass="org.example.App" -Dexec.args="score.txt" 
```
