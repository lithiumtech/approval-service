package com.khoros.db;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.khoros.ApprovalServiceConfiguration;
import com.khoros.config.AwsConfiguration;
import io.dropwizard.setup.Environment;

import javax.inject.Inject;

public class DynamoDbConnector  {
    private String AWS_REGION = "us-west";
    private String ENV = "dev";
    private Regions regions;
    private String tableName;
    private String tableIdentifier;
    //TODO : improve connector
    public DynamoDbConnector(AwsConfiguration awsConfiguration,String tableName){
        regions = Regions.fromName(awsConfiguration.getRegion());
        ENV = awsConfiguration.getEnv();
        tableIdentifier = awsConfiguration.getTableIdentifier();
        this.tableName = tableName;
    }

    private AmazonDynamoDB getAmazonDynamoDBClient(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(regions).build();
        return client;
    }

    private String getTableName(){
        return ENV + "-default-"+tableIdentifier+"-"+tableName;
    }

    private  DynamoDBMapper getDynamoDbMapper(AmazonDynamoDB client){
        DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(getTableName())).build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client,mapperConfig);
        return dynamoDBMapper;
    }

    public DynamoDBMapper getDynamoDbMapper(){
        return getDynamoDbMapper(getAmazonDynamoDBClient());
    }

}
