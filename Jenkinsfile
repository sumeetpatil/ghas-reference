@Library(['piper-lib', 'piper-lib-os']) _

try {
    deleteDir()
    checkout scm
    setupPipelineEnvironment script: this
    codeqlExecuteScan script: this
} catch (err) {
    throw err
}
