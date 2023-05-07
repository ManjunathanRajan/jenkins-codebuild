@Library('jenkins-codebuild') _

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    customAwsCodeBuild(
                        credentialsId: 'aws-codebuild',
                        projectName: 'jenkins-codebuild',
                        region: 'us-west-2'
                    )
                }
            }
        }
    }
}
