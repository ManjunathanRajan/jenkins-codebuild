pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    awsCodeBuild(
                        credentialsId: 'aws-codebuild',
                        credentialsType: 'jenkins', // Add this line
                        projectName: 'jenkins-codebuild',
                        sourceControlType: 'project',
                        region: 'us-west-2'
                    )
                }
            }
        }
    }
}
