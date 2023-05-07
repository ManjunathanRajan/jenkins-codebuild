pipeline {
    agent any
    tools {
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-codebuild']]) {
                        sh 'curl -L -o aws-sdk-java.zip https://sdk-for-java.amazonwebservices.com/latest/aws-java-sdk.zip'
                        sh 'unzip -q -o aws-sdk-java.zip'
                        
                        // Download the CodeBuildTrigger.class file from GitHub
                        sh 'mkdir -p src/com/example'
                        sh 'curl -L -o src/com/example/CodeBuildTrigger.class https://github.com/ManjunathanRajan/jenkins-codebuild/raw/main/src/com/example/CodeBuildTrigger.class'
                        
                        def project_name = 'jenkins-codebuild'
                        def region = 'us-west-2'
                        
                        sh """
                            java -cp "src:aws-java-sdk/lib/*:aws-java-sdk/third-party/lib/*" -Daws.accessKeyId=**** -Daws.secretKey=**** -Daws.region=us-west-2 com.example.CodeBuildTrigger jenkins-codebuild
                        """
                    }
                }
            }
        }
    }
}
