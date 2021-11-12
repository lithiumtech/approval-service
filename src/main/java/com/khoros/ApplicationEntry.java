package com.khoros;

import com.khoros.modules.ApprovalServiceModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ApplicationEntry extends Application<ApprovalServiceConfiguration> {
    private ApprovalServiceConfiguration configuration;
    private Environment environment;
    public static void main(String[] args) throws Exception {
        new ApplicationEntry().run(args);
    }
    public void run(ApprovalServiceConfiguration configuration, Environment environment){
        this.configuration = configuration;
        this.environment= environment;
        HealthCheckUp healthCheckUp = new HealthCheckUp();
        environment.healthChecks().register(configuration.getAppInfo().getName(),healthCheckUp);
        //registry(configuration,environment);
        addPuma();
    }

    private void addPuma(){
        ApprovalComponent component = DaggerApprovalComponent.builder()
                .approvalServiceModule(new ApprovalServiceModule(configuration,environment))
                .build();
        environment.jersey().register(component.appInfoController());
        environment.jersey().register(component.teamsController());
    }
}
