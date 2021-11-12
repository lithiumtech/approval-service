package com.khoros;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.khoros.config.AwsConfiguration;
import com.khoros.model.AppInfo;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class ApprovalServiceConfiguration extends Configuration {


    private AppInfo appInfo = new AppInfo();
    private AwsConfiguration awsConfiguration = new AwsConfiguration();
    @JsonProperty(value = "app")
    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }
    @JsonProperty(value = "aws")
    public AwsConfiguration getAwsConfiguration() {
        return awsConfiguration;
    }

    public void setAwsConfiguration(AwsConfiguration awsConfiguration) {
        this.awsConfiguration = awsConfiguration;
    }
}
