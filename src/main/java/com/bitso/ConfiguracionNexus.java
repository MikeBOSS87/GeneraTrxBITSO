package com.bitso;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

public class ConfiguracionNexus {

	private DataSourceBuilder<?> DSB = null ;
	
    public DataSource ObtenDS(){
		DSB = DataSourceBuilder.create() ;
		DSB.driverClassName( "oracle.jdbc.OracleDriver" );
		DSB.url( "jdbc:oracle:thin:@localhost:1521:ATLBD" );
		DSB.username( "USRPUENTE" );
		DSB.password( "Puente" );
		return( DataSource ) DSB.build ();
	}
}