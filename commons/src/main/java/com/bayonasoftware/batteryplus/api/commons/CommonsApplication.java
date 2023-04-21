package com.bayonasoftware.batteryplus.api.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities")
@SpringBootApplication
public class CommonsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CommonsApplication.class, args);
  }

}
