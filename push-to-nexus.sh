#!/bin/bash

# Set variables for Nexus URL, repository, username, and password
NEXUS_URL="https://10.101.16.48:8081"
REPO_NAME="maven-snapshots"
USERNAME="admin"
PASSWORD="admin"

# Set path to JAR file and artifact ID
JAR_FILE="./target/devops-integration.jar"
ARTIFACT_ID="devops-integration"

# Run Maven deploy command to push JAR file to Nexus repository
mvn deploy:deploy-file \
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
