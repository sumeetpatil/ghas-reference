@Library(['piper-lib', 'piper-lib-os']) _
       
try{
    node {
        
        stage('Init') {
            checkout scm
        }

        stage('Codeql'){
            setupPipelineEnvironment script: this 
            codeqlExecuteScan script: this
        }           
    }
} catch (err) {
  node {
    throw err
  }
}
