pipeline {
  agent any
  stages {
  stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/SachPrecious/maven-demo.git']])
                

            }
        }
    stage('version') {
      steps {
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app mcr.microsoft.com/powershell pwsh --version"
      }
    }
    stage('Run Powershell Script') {
      steps {
        sh 'chmod +x ./powershell-script.ps1'
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app mcr.microsoft.com/powershell pwsh -File /app/powershell-script.ps1 "
      }
    }
  }
}
