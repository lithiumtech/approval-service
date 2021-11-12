package com.khoros.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AwsConfiguration {
    private String region;
    private String env;
    private String tableIdentifier;

    public AwsConfiguration(String region, String env,String tableIdentifier) {
        this.region = region;
        this.env = env;
        this.tableIdentifier = tableIdentifier;
    }

    public AwsConfiguration() {
    }

    @JsonProperty(value = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    @JsonProperty(value = "env")
    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
    @JsonProperty(value = "tableIdentifier")
    public String getTableIdentifier() {
        return tableIdentifier;
    }

    public void setTableIdentifier(String tableIdentifier) {
        this.tableIdentifier = tableIdentifier;
    }
}
