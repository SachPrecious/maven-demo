pipeline {
    agent any

    tools {
        maven "jenkins-maven"
    }
    stages {
        
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']],
                extensions: [],
                userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/SachPrecious/maven-demo.git']])
                
            }
        }
        stage('Maven Build'){
            steps{
                 sh 'mvn clean install && ls -la'
                 sh 'cd target && ls -la'
            }
        }
        stage('Push to Nexus'){
            steps{
                
                sh 'chmod +x push-to-nexus.sh'
                sh 'sh push-to-nexus.sh'
                
            }
        }
              
        
    }
}
