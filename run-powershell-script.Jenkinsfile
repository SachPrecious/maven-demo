pipeline {
  agent any
  stages {
    stage('version') {
      steps {
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app mcr.microsoft.com/powershell pwsh --version"
      }
    }
    stage('Run Powershell Script') {
      steps {
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app mcr.microsoft.com/powershell pwsh ./powershell-script.ps1"
      }
    }
  }
}
