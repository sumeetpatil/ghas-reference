@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'sumeetpatil/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'codeql-scan'
       
try{
    node {
        
        stage('Init') {
            scm_variables = checkout scm
            echo scm_variables.get('GIT_COMMIT')
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
