pipeline {
  agent any
  stages {
    stage('version') {
      steps {
        sh 'pwsh --version'
      }
    }
    stage('Run Powershell Script') {
      steps {
        sh 'pwsh powershell-script.ps1'
      }
    }
  }
}
