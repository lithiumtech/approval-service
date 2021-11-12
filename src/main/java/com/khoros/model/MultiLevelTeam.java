package com.khoros.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "")
public class MultiLevelTeam {
    private String uuid;
    private Long teamId;
    private List<TeamMember> teamMembers;
    private Boolean enabled;
    private Boolean postUpdateByUserFlag;
    private String createdOn;
    private String updatedOn;
    private List<String> preferences;

    public MultiLevelTeam(){}
    @DynamoDBAttribute(attributeName = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @DynamoDBHashKey(attributeName = "teamId")
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    @DynamoDBAttribute(attributeName = "teamMembers")
    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }
    @DynamoDBAttribute(attributeName = "enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    @DynamoDBAttribute(attributeName = "postUpdatedByUser")
    public Boolean getPostUpdateByUserFlag() {
        return postUpdateByUserFlag;
    }

    public void setPostUpdateByUserFlag(Boolean postUpdateByUserFlag) {
        this.postUpdateByUserFlag = postUpdateByUserFlag;
    }

    @DynamoDBAttribute(attributeName = "createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    @DynamoDBAttribute(attributeName = "updatedOn")
    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
    @DynamoDBAttribute(attributeName = "preferences")
    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
