pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    awsCodeBuild(
                        credentialsId: 'aws-codebuild',
                        projectName: 'jenkins-codebuild',
                        sourceControlType: 'project',
                        region: 'us-west-2'
                    )
                }
            }
        }
    }
}
