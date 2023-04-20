pipeline {
  agent any
  stages {
    stage('version') {
      steps {
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app microsoft/powershell:nanoserver pwsh --version"
      }
    }
    stage('Run Powershell Script') {
      steps {
        sh 'chmod +x ./powershell-script.ps1'
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app microsoft/powershell:nanoserver pwsh.exe ./powershell-script.ps1"
      }
    }
  }
}
