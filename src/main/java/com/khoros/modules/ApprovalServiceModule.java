package com.khoros.modules;

import com.khoros.ApprovalServiceConfiguration;
import com.khoros.config.AwsConfiguration;
import dagger.Module;
import dagger.Provides;
import io.dropwizard.setup.Environment;

import javax.inject.Singleton;

@Module
public class ApprovalServiceModule {
    private final ApprovalServiceConfiguration configuration;
    private final Environment environment;

    public ApprovalServiceModule(ApprovalServiceConfiguration configuration,Environment environment){
        this.configuration = configuration;
        this.environment = environment;
    }

    @Provides
    @Singleton
    public ApprovalServiceConfiguration provideConfiguration(){
        return configuration;
    }
}
