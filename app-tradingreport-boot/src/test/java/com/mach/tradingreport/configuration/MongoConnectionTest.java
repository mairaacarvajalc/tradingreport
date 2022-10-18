package com.mach.tradingreport.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest(classes = {MongoConfiguration.class})
@EnableConfigurationProperties
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoConnectionTest{

  @Value("${spring.mongodb.uri}")
  private String mongoUri;

  @Value("${spring.mongodb.database}")
  String databaseName;


  @Test
  public void testConnectionFindDataBase() {
    MongoClient mc = MongoClients.create(mongoUri);

    Assert.assertEquals(
        "Could not find database, has not allowed grant",
            mc.getDatabase(databaseName).getName(),
        "trading_report_des");
  }
}
