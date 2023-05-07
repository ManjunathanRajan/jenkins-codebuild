import com.example.CustomAWSCredentials
import com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.SystemCredentialsProvider

def call(Map config = [:]) {
    script {
        // Create and store AWS credentials if accessKey and secretKey are provided
        if (config.accessKey && config.secretKey) {
            def awsCredentials = new AWSCredentialsImpl(CredentialsScope.GLOBAL, config.credentialsId, config.accessKey, config.secretKey, '')
            def customAWSCredentials = new CustomAWSCredentials(CredentialsScope.GLOBAL, config.credentialsId, '', awsCredentials)

            SystemCredentialsProvider.getInstance().getStore().addCredentials(null, customAWSCredentials)
        }

        // Use custom AWS credentials
        def customCredentials = new com.example.CustomAWSCredentials(credentialsId: config.credentialsId)

        awsCodeBuild(
            credentialsId: customCredentials,
            projectName: config.projectName,
            region: config.region
        )
    }
}
