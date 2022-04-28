@Library(['piper-lib', 'piper-lib-os']) _
       
try{
    node {
        
        stage('Init') {
            checkout scm
        }

        stage('Codeql'){
            codeqlExecuteScan script: this
        }           
    }
} catch (err) {
  node {
    throw err
  }
}
