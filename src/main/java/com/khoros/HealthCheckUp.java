package com.khoros;

import com.codahale.metrics.health.HealthCheck;

public class HealthCheckUp extends HealthCheck {

    protected Result check() throws Exception {
        final String field = "ApprovalService";
        if(field.equalsIgnoreCase("ApprovalService")){
            return Result.healthy("All is Well");
        }
        return Result.unhealthy("I am not feeling good about this.");
    }
}
