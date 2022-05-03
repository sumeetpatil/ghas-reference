@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'sumeetpatil/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'codeql-scan'
       
try{
    node {
        
        stage('Init') {
            checkout scm
            sh 'env'
        }

        stage('Codeql'){
            codeqlExecuteScan script: this
        }           
    }
} catch (err) {
  node {
    throw err
  }
} finally {
  node {
    mailSendNotification script: this
  }
}
