FROM openjdk:11
ARG SCORE_FILE

COPY $SCORE_FILE  score.txt
COPY target/bowling_score-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "score.txt"]

 
