package com.sparta.ScheduleManagement_Upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleManagementUpgradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleManagementUpgradeApplication.class, args);
	}

}
