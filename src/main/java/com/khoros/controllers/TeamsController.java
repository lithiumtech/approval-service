package com.khoros.controllers;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.khoros.ApprovalServiceConfiguration;
import com.khoros.db.DynamoDbConnector;
import com.khoros.model.MultiLevelTeam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class TeamsController {
    private final ApprovalServiceConfiguration approvalServiceConfiguration;
    private String tableName = "approval-teams";

    @Inject
    public TeamsController(ApprovalServiceConfiguration approvalServiceConfiguration) {
        this.approvalServiceConfiguration = approvalServiceConfiguration;
    }
    @GET
    @Path("/teams")
    public List<MultiLevelTeam> getTeams(){
        DynamoDbConnector connector = new DynamoDbConnector(approvalServiceConfiguration.getAwsConfiguration(), tableName);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<MultiLevelTeam> teams = connector.getDynamoDbMapper().scan(MultiLevelTeam.class, scanExpression);
        return teams;
    }
}
