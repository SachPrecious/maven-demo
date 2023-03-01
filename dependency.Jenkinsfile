pipeline{
    agent any
    tools{
        maven 'maven'
    }
    
    stages{
        stage('Clone Repository') {
            steps {
                script {
                    checkout([
                            $class: 'GitSCM',
                            branches: [[name: "*/main"]],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [],
                            submoduleCfg: [],
                          userRemoteConfigs: [[credentialsId: 'github',         
                                                 url: 'https://github.com/SachPrecious/maven-demo.git']]
                             ])
                   }
                 }         
        }       
        
        stage('Build'){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage('Test'){
            steps{
                 sh 'mvn test'
            }
        }       
        
        stage('Dependency Check') {
            steps {
                dependencyCheck additionalArguments: '--format XML', odcInstallation: 'dp-check'
            }
        } 
        stage('Publish') {
            steps {
                dependencyCheckPublisher pattern: ''
            }
        } 
    }
    
}
