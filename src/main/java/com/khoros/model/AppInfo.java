package com.khoros.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppInfo {
    private String name;
    private String version;

    public AppInfo(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public AppInfo() {
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty(value = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
