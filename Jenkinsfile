@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'sumeetpatil/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'codeql-scan'
       
try{
    node {
        
        stage('Init') {
            scmVars = checkout scm
            env.GIT_COMMIT = scmVars.get('GIT_COMMIT')
            env.GIT_URL = scmVars.get('GIT_URL')
            env.GIT_BRANCH = scmVars.get('GIT_BRANCH').split("/")[1]
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
