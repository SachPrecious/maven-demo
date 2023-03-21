#!/bin/bash

# Set variables for Nexus URL, repository, username, and password
NEXUS_URL="http://10.101.16.48:8081"
REPO_NAME="maven-snapshots"
USERNAME="admin"
PASSWORD="admin"
MAVEN_SETTINGS=.m2/setting.xml

# Set path to JAR file and artifact ID
JAR_FILE="./target/devops-integration.jar"
ARTIFACT_ID="devops-integration"


# Run Maven deploy command to push JAR file to Nexus repository
mvn -s ${MAVEN_SETTINGS} deploy:deploy-file \
  -Durl=$NEXUS_URL/repository/$REPO_NAME \
  -DrepositoryId=$REPO_NAME \
  -Dfile=$JAR_FILE \
  -DgroupId=com.example \
  -DartifactId=$ARTIFACT_ID \
  -Dversion=1.0-SNAPSHOT \
  -Dpackaging=jar \
  -DgeneratePom=true \
  -DupdateReleaseInfo=true \
  -Duser=$USERNAME \
  -Dpassword=$PASSWORD
  -Dmaven.wagon.http.ssl.insecure=true
  -Dmaven.wagon.http.ssl.allowall=true
  -Dmaven.wagon.http.ssl.ignore.validity.dates=true
