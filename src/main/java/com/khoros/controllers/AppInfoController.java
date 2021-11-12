package com.khoros.controllers;

import com.khoros.ApprovalServiceConfiguration;
import com.khoros.db.DynamoDbConnector;
import com.khoros.model.AppInfo;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class AppInfoController {
    private final ApprovalServiceConfiguration approvalServiceConfiguration;

    @Inject
    public AppInfoController(ApprovalServiceConfiguration approvalServiceConfiguration){
        this.approvalServiceConfiguration = approvalServiceConfiguration;
    }

    @GET
    @Path("/info")
    public AppInfo getAppInfo(){
        return approvalServiceConfiguration.getAppInfo();
    }
}
