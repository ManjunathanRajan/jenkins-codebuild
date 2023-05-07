package com.example;

import com.amazonaws.services.codebuild.AWSCodeBuildClientBuilder;
import com.amazonaws.services.codebuild.AWSCodeBuild;
import com.amazonaws.services.codebuild.model.*;

public class CodeBuildTrigger {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java CodeBuildTrigger <project_name>");
            System.exit(1);
        }

        String projectName = args[0];

        AWSCodeBuild codebuild = AWSCodeBuildClientBuilder.standard().build();
        StartBuildRequest startBuildRequest = new StartBuildRequest().withProjectName(projectName);
        StartBuildResult startBuildResult = codebuild.startBuild(startBuildRequest);
        
        System.out.println("Build started: " + startBuildResult.getBuild().getArn());
    }
}

