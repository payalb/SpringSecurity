package com.demo.config;

import org.flywaydb.core.Flyway;

public class DbMigration extends Flyway{

	 public void repairAndMigrate() {
	        this.repair();
	        this.migrate();
	    }

}
