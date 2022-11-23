@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'SAP/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'fix-codeql-ref'
       
try{
    node {
        
        stage('Init') {
            checkout scm
            env.getEnvironment().each { name, value -> println "Name: $name -> Value $value" }
            setupCommonPipelineEnvironment script: this
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
