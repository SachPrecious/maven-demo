pipeline {
  agent any
  stages {
    stage('version') {
      steps {
        sh 'docker run -i --rm -v ${WORKSPACE}:app -w /app lts-7.2-alpine-3.14 pwsh --version'
      }
    }
    stage('Run Powershell Script') {
      steps {
        sh 'docker run -i --rm -v ${WORKSPACE}:app -w /app lts-7.2-alpine-3.14 pwsh powershell-script.ps1'
      }
    }
  }
}
