@Library(['piper-lib', 'piper-lib-os']) _

env.REPOSITORY_UNDER_TEST       = 'SAP/jenkins-library' 
env.LIBRARY_VERSION_UNDER_TEST  = 'fix-codeql-ref'

def commitHashForBuild(build) {
    def scmAction = build?.actions.find { action -> action instanceof jenkins.scm.api.SCMRevisionAction }
    if (scmAction?.revision instanceof org.jenkinsci.plugins.github_branch_source.PullRequestSCMRevision) {
        return scmAction?.revision?.pullHash
    } else if (scmAction?.revision instanceof jenkins.plugins.git.AbstractGitSCMSource$SCMRevisionImpl) {
        return scmAction?.revision?.hash
    } else {
        error("Build doesn't contain revision information. Do you run this from GitHub organization folder?")
    }
}


try{
    node {
        
        stage('Init') {
            checkout scm
            
            commit_sha = commitHashForBuild(currentBuild.rawBuild)   
            echo commit_sha
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
