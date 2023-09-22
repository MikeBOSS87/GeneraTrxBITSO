package com.bitso;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionNexus {

    @Bean
    public DataSource ObtenDS() {	
		DataSourceBuilder DSB = DataSourceBuilder.create() ;
		DSB.driverClassName ("oracle.jdbc.OracleDriver");
		DSB.url ("jdbc:oracle:thin:@localhost:1521:ORCL");
		DSB.username ("USRGLOBALNET");
		DSB.password ("Mike");
		return (DataSource) DSB.build ();
	}
}