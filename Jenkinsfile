@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'sumeetpatil/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'sumeetpatil/jenkins-library'
       
try{
    node {
        
        stage('Init') {
            checkout scm
        }

        stage('Codeql'){
            setupCommonPipelineEnvironment script: this
            codeqlExecuteScan script: this
        }           
    }
} catch (err) {
  node {
    throw err
  }
}
