import com.example.CustomAWSCredentials
import com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.SystemCredentialsProvider

def call(String accessKey, String secretKey, String credentialsId, String projectName, String region) {
    def awsCredentials = new AWSCredentialsImpl(CredentialsScope.GLOBAL, credentialsId, accessKey, secretKey, '')
    def customAWSCredentials = new CustomAWSCredentials(CredentialsScope.GLOBAL, credentialsId, '', awsCredentials)

    SystemCredentialsProvider.getInstance().getStore().addCredentials(null, customAWSCredentials)

    awsCodeBuild(
        credentialsId: credentialsId,
        projectName: projectName,
        sourceControlType: 'project',
        region: region
    )
}

