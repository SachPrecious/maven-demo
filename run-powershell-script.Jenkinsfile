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
        sh 'chmod +x ./powershell-script.ps1'
        sh "docker run -i --rm -v ${WORKSPACE}:/app -w /app mcr.microsoft.com/powershell pwsh -File /app/powershell-script.ps1 "
      }
      post {
        always {
          emailext body: "${BUILD_LOG, maxLines=99999}", 
               subject: "Powershell Script Output - Build #${BUILD_NUMBER}", 
               to: "sachithram149@gmail.com"
        }
      }

    }
    
  }
}
