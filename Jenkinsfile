pipeline {
    agent any
    tools {
        jdk 'aws-cred'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-codebuild']]) {
                        sh 'curl -L -o aws-sdk-java.zip https://sdk-for-java.amazonwebservices.com/latest/aws-java-sdk.zip'
                        sh 'unzip aws-sdk-java.zip'
                        
                        def project_name = 'jenkins-codebuild'
                        def region = 'us-west-2'
                        
                        sh """
                            java -cp "aws-java-sdk/lib/*:aws-java-sdk/third-party/lib/*" -Daws.accessKeyId=\$AWS_ACCESS_KEY_ID -Daws.secretKey=\$AWS_SECRET_ACCESS_KEY -Daws.region=$region com.example.CodeBuildTrigger "$project_name"
                        """
                    }
                }
            }
        }
    }
}
