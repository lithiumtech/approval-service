package com.khoros;

import com.khoros.controllers.AppInfoController;
import com.khoros.controllers.TeamsController;
import com.khoros.db.DynamoDbConnector;
import com.khoros.modules.ApprovalServiceModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApprovalServiceModule.class)
public interface ApprovalComponent {
    AppInfoController appInfoController();
    TeamsController teamsController();
}
