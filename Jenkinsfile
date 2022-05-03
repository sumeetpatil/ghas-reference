@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'sumeetpatil/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'codeql-scan'
       
try{
    node {
        
        stage('Init') {
            scmVars = checkout scm
            env.GIT_COMMIT = scmVars.get('GIT_COMMIT')
            env.GIT_URL = scmVars.get('GIT_URL')
            env.GIT_LOCAL_BRANCH = scmVars.get('GIT_LOCAL_BRANCH')
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
