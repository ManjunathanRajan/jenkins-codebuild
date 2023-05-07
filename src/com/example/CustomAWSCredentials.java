import com.amazonaws.codebuild.jenkinsplugin.CodeBuildBaseCredentials;
import com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;

public class CustomAWSCredentials extends BaseStandardCredentials implements CodeBuildBaseCredentials {

    private final AWSCredentialsImpl awsCredentials;

    public CustomAWSCredentials(CredentialsScope scope, String id, String description, AWSCredentialsImpl awsCredentials) {
        super(scope, id, description);
        this.awsCredentials = awsCredentials;
    }

    @Override
    public String getAccessKey() {
        return awsCredentials.getCredentials().getAWSAccessKeyId();
    }

    @Override
    public String getSecretKey() {
        return awsCredentials.getCredentials().getAWSSecretKey();
    }
}

